
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiadianOrder")
public class JiadianOrderController {
    private static final Logger logger = LoggerFactory.getLogger(JiadianOrderController.class);

    private static final String TABLE_NAME = "jiadianOrder";

    @Autowired
    private JiadianOrderService jiadianOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JiadianService jiadianService;//商品
    @Autowired
    private JiadianCollectionService jiadianCollectionService;//商品收藏
    @Autowired
    private JiadianCommentbackService jiadianCommentbackService;//商品评价
    @Autowired
    private LiuyanService liuyanService;//留言反馈
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jiadianOrderService.queryPage(params);

        //字典表数据转换
        List<JiadianOrderView> list =(List<JiadianOrderView>)page.getList();
        for(JiadianOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiadianOrderEntity jiadianOrder = jiadianOrderService.selectById(id);
        if(jiadianOrder !=null){
            //entity转view
            JiadianOrderView view = new JiadianOrderView();
            BeanUtils.copyProperties( jiadianOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(jiadianOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 商品
            //级联表
            JiadianEntity jiadian = jiadianService.selectById(jiadianOrder.getJiadianId());
            if(jiadian != null){
            BeanUtils.copyProperties( jiadian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiadianId(jiadian.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiadianOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiadianOrderEntity jiadianOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiadianOrder:{}",this.getClass().getName(),jiadianOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiadianOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jiadianOrder.setCreateTime(new Date());
        jiadianOrder.setInsertTime(new Date());
        jiadianOrderService.insert(jiadianOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiadianOrderEntity jiadianOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiadianOrder:{}",this.getClass().getName(),jiadianOrder.toString());
        JiadianOrderEntity oldJiadianOrderEntity = jiadianOrderService.selectById(jiadianOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiadianOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jiadianOrderService.updateById(jiadianOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiadianOrderEntity> oldJiadianOrderList =jiadianOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiadianOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiadianOrderEntity> jiadianOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiadianOrderEntity jiadianOrderEntity = new JiadianOrderEntity();
//                            jiadianOrderEntity.setJiadianOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            jiadianOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            jiadianOrderEntity.setJiadianId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            jiadianOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiadianOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            jiadianOrderEntity.setJiadianOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            jiadianOrderEntity.setJiadianOrderCourierName(data.get(0));                    //快递公司 要改的
//                            jiadianOrderEntity.setJiadianOrderCourierNumber(data.get(0));                    //订单快递单号 要改的
//                            jiadianOrderEntity.setJiadianOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            jiadianOrderEntity.setJiadianOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            jiadianOrderEntity.setInsertTime(date);//时间
//                            jiadianOrderEntity.setCreateTime(date);//时间
                            jiadianOrderList.add(jiadianOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("jiadianOrderUuidNumber")){
                                    List<String> jiadianOrderUuidNumber = seachFields.get("jiadianOrderUuidNumber");
                                    jiadianOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiadianOrderUuidNumber = new ArrayList<>();
                                    jiadianOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiadianOrderUuidNumber",jiadianOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<JiadianOrderEntity> jiadianOrderEntities_jiadianOrderUuidNumber = jiadianOrderService.selectList(new EntityWrapper<JiadianOrderEntity>().in("jiadian_order_uuid_number", seachFields.get("jiadianOrderUuidNumber")));
                        if(jiadianOrderEntities_jiadianOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiadianOrderEntity s:jiadianOrderEntities_jiadianOrderUuidNumber){
                                repeatFields.add(s.getJiadianOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiadianOrderService.insertBatch(jiadianOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiadianOrderService.queryPage(params);

        //字典表数据转换
        List<JiadianOrderView> list =(List<JiadianOrderView>)page.getList();
        for(JiadianOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiadianOrderEntity jiadianOrder = jiadianOrderService.selectById(id);
            if(jiadianOrder !=null){


                //entity转view
                JiadianOrderView view = new JiadianOrderView();
                BeanUtils.copyProperties( jiadianOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(jiadianOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    JiadianEntity jiadian = jiadianService.selectById(jiadianOrder.getJiadianId());
                if(jiadian != null){
                    BeanUtils.copyProperties( jiadian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiadianId(jiadian.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiadianOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiadianOrderEntity jiadianOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiadianOrder:{}",this.getClass().getName(),jiadianOrder.toString());
            JiadianEntity jiadianEntity = jiadianService.selectById(jiadianOrder.getJiadianId());
            if(jiadianEntity == null){
                return R.error(511,"查不到该商品");
            }
            // Double jiadianNewMoney = jiadianEntity.getJiadianNewMoney();

            if(false){
            }
            else if(jiadianEntity.getJiadianNewMoney() == null){
                return R.error(511,"现价不能为空");
            }
            else if((jiadianEntity.getJiadianKucunNumber() -jiadianOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - jiadianEntity.getJiadianNewMoney()*jiadianOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            jiadianOrder.setJiadianOrderTypes(101); //设置订单状态为已支付
            jiadianOrder.setJiadianOrderTruePrice(jiadianEntity.getJiadianNewMoney()*jiadianOrder.getBuyNumber()); //设置实付价格
            jiadianOrder.setYonghuId(userId); //设置订单支付人id
            jiadianOrder.setJiadianOrderUuidNumber(String.valueOf(new Date().getTime()));
            jiadianOrder.setJiadianOrderPaymentTypes(1);
            jiadianOrder.setInsertTime(new Date());
            jiadianOrder.setCreateTime(new Date());
                jiadianEntity.setJiadianKucunNumber( jiadianEntity.getJiadianKucunNumber() -jiadianOrder.getBuyNumber());
                jiadianService.updateById(jiadianEntity);
                jiadianOrderService.insert(jiadianOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String jiadianOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

            Integer jiadianOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("jiadianOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("jiadians"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> jiadians = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<JiadianOrderEntity> jiadianOrderList = new ArrayList<>();
        //商品表
        List<JiadianEntity> jiadianList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : jiadians) {
           //取值
            Integer jiadianId = Integer.valueOf(String.valueOf(map.get("jiadianId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            JiadianEntity jiadianEntity = jiadianService.selectById(jiadianId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(jiadianEntity.getJiadianKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(jiadianEntity.getJiadianName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                jiadianEntity.setJiadianKucunNumber(jiadianEntity.getJiadianKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            JiadianOrderEntity jiadianOrderEntity = new JiadianOrderEntity<>();

            //赋值订单信息
            jiadianOrderEntity.setJiadianOrderUuidNumber(jiadianOrderUuidNumber);//订单号
            jiadianOrderEntity.setAddressId(addressId);//收货地址
            jiadianOrderEntity.setJiadianId(jiadianId);//商品
                        jiadianOrderEntity.setYonghuId(userId);//用户
            jiadianOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            jiadianOrderEntity.setJiadianOrderTypes(101);//订单类型
            jiadianOrderEntity.setJiadianOrderPaymentTypes(jiadianOrderPaymentTypes);//支付类型
            jiadianOrderEntity.setInsertTime(new Date());//订单创建时间
            jiadianOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(jiadianOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(jiadianEntity.getJiadianNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    jiadianOrderEntity.setJiadianOrderTruePrice(money);

                }
            }
            jiadianOrderList.add(jiadianOrderEntity);
            jiadianList.add(jiadianEntity);

        }
        jiadianOrderService.insertBatch(jiadianOrderList);
        jiadianService.updateBatchById(jiadianList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);

        return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            JiadianOrderEntity jiadianOrder = jiadianOrderService.selectById(id);//当前表service
            Integer buyNumber = jiadianOrder.getBuyNumber();
            Integer jiadianOrderPaymentTypes = jiadianOrder.getJiadianOrderPaymentTypes();
            Integer jiadianId = jiadianOrder.getJiadianId();
            if(jiadianId == null)
                return R.error(511,"查不到该商品");
            JiadianEntity jiadianEntity = jiadianService.selectById(jiadianId);
            if(jiadianEntity == null)
                return R.error(511,"查不到该商品");
            Double jiadianNewMoney = jiadianEntity.getJiadianNewMoney();
            if(jiadianNewMoney == null)
                return R.error(511,"商品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(jiadianOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = jiadianEntity.getJiadianNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            jiadianEntity.setJiadianKucunNumber(jiadianEntity.getJiadianKucunNumber() + buyNumber);


            jiadianOrder.setJiadianOrderTypes(102);//设置订单状态为已退款
            jiadianOrderService.updateById(jiadianOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            jiadianService.updateById(jiadianEntity);//更新订单中商品的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer jiadianCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            JiadianOrderEntity jiadianOrder = jiadianOrderService.selectById(id);
        if(jiadianOrder == null)
            return R.error(511,"查不到该订单");
        Integer jiadianId = jiadianOrder.getJiadianId();
        if(jiadianId == null)
            return R.error(511,"查不到该商品");

        JiadianCommentbackEntity jiadianCommentbackEntity = new JiadianCommentbackEntity();
            jiadianCommentbackEntity.setId(id);
            jiadianCommentbackEntity.setJiadianId(jiadianId);
            jiadianCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            jiadianCommentbackEntity.setJiadianCommentbackText(commentbackText);
            jiadianCommentbackEntity.setInsertTime(new Date());
            jiadianCommentbackEntity.setReplyText(null);
            jiadianCommentbackEntity.setUpdateTime(null);
            jiadianCommentbackEntity.setCreateTime(new Date());
            jiadianCommentbackService.insert(jiadianCommentbackEntity);

            jiadianOrder.setJiadianOrderTypes(105);//设置订单状态为已评价
            jiadianOrderService.updateById(jiadianOrder);//根据id更新
            return R.ok();
    }

    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String jiadianOrderCourierNumber, String jiadianOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JiadianOrderEntity  jiadianOrderEntity = jiadianOrderService.selectById(id);
        jiadianOrderEntity.setJiadianOrderTypes(103);//设置订单状态为已发货
        jiadianOrderEntity.setJiadianOrderCourierNumber(jiadianOrderCourierNumber);
        jiadianOrderEntity.setJiadianOrderCourierName(jiadianOrderCourierName);
        jiadianOrderService.updateById( jiadianOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JiadianOrderEntity  jiadianOrderEntity = jiadianOrderService.selectById(id);
        jiadianOrderEntity.setJiadianOrderTypes(104);//设置订单状态为收货
        jiadianOrderService.updateById( jiadianOrderEntity);
        return R.ok();
    }

}

