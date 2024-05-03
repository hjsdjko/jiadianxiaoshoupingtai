package com.entity.model;

import com.entity.JiadianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiadianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品名称
     */
    private String jiadianName;


    /**
     * 商品编号
     */
    private String jiadianUuidNumber;


    /**
     * 商品照片
     */
    private String jiadianPhoto;


    /**
     * 商品类型
     */
    private Integer jiadianTypes;


    /**
     * 商品库存
     */
    private Integer jiadianKucunNumber;


    /**
     * 商品原价
     */
    private Double jiadianOldMoney;


    /**
     * 现价
     */
    private Double jiadianNewMoney;


    /**
     * 商品热度
     */
    private Integer jiadianClicknum;


    /**
     * 商品介绍
     */
    private String jiadianContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jiadianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商品名称
	 */
    public String getJiadianName() {
        return jiadianName;
    }


    /**
	 * 设置：商品名称
	 */
    public void setJiadianName(String jiadianName) {
        this.jiadianName = jiadianName;
    }
    /**
	 * 获取：商品编号
	 */
    public String getJiadianUuidNumber() {
        return jiadianUuidNumber;
    }


    /**
	 * 设置：商品编号
	 */
    public void setJiadianUuidNumber(String jiadianUuidNumber) {
        this.jiadianUuidNumber = jiadianUuidNumber;
    }
    /**
	 * 获取：商品照片
	 */
    public String getJiadianPhoto() {
        return jiadianPhoto;
    }


    /**
	 * 设置：商品照片
	 */
    public void setJiadianPhoto(String jiadianPhoto) {
        this.jiadianPhoto = jiadianPhoto;
    }
    /**
	 * 获取：商品类型
	 */
    public Integer getJiadianTypes() {
        return jiadianTypes;
    }


    /**
	 * 设置：商品类型
	 */
    public void setJiadianTypes(Integer jiadianTypes) {
        this.jiadianTypes = jiadianTypes;
    }
    /**
	 * 获取：商品库存
	 */
    public Integer getJiadianKucunNumber() {
        return jiadianKucunNumber;
    }


    /**
	 * 设置：商品库存
	 */
    public void setJiadianKucunNumber(Integer jiadianKucunNumber) {
        this.jiadianKucunNumber = jiadianKucunNumber;
    }
    /**
	 * 获取：商品原价
	 */
    public Double getJiadianOldMoney() {
        return jiadianOldMoney;
    }


    /**
	 * 设置：商品原价
	 */
    public void setJiadianOldMoney(Double jiadianOldMoney) {
        this.jiadianOldMoney = jiadianOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getJiadianNewMoney() {
        return jiadianNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setJiadianNewMoney(Double jiadianNewMoney) {
        this.jiadianNewMoney = jiadianNewMoney;
    }
    /**
	 * 获取：商品热度
	 */
    public Integer getJiadianClicknum() {
        return jiadianClicknum;
    }


    /**
	 * 设置：商品热度
	 */
    public void setJiadianClicknum(Integer jiadianClicknum) {
        this.jiadianClicknum = jiadianClicknum;
    }
    /**
	 * 获取：商品介绍
	 */
    public String getJiadianContent() {
        return jiadianContent;
    }


    /**
	 * 设置：商品介绍
	 */
    public void setJiadianContent(String jiadianContent) {
        this.jiadianContent = jiadianContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiadianDelete() {
        return jiadianDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiadianDelete(Integer jiadianDelete) {
        this.jiadianDelete = jiadianDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
