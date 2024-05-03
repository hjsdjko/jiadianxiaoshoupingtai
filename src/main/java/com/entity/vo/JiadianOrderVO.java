package com.entity.vo;

import com.entity.JiadianOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiadian_order")
public class JiadianOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "jiadian_order_uuid_number")
    private String jiadianOrderUuidNumber;


    /**
     * 收货地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 商品
     */

    @TableField(value = "jiadian_id")
    private Integer jiadianId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "jiadian_order_true_price")
    private Double jiadianOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "jiadian_order_courier_name")
    private String jiadianOrderCourierName;


    /**
     * 订单快递单号
     */

    @TableField(value = "jiadian_order_courier_number")
    private String jiadianOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "jiadian_order_types")
    private Integer jiadianOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "jiadian_order_payment_types")
    private Integer jiadianOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getJiadianOrderUuidNumber() {
        return jiadianOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setJiadianOrderUuidNumber(String jiadianOrderUuidNumber) {
        this.jiadianOrderUuidNumber = jiadianOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：商品
	 */
    public Integer getJiadianId() {
        return jiadianId;
    }


    /**
	 * 获取：商品
	 */

    public void setJiadianId(Integer jiadianId) {
        this.jiadianId = jiadianId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getJiadianOrderTruePrice() {
        return jiadianOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setJiadianOrderTruePrice(Double jiadianOrderTruePrice) {
        this.jiadianOrderTruePrice = jiadianOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getJiadianOrderCourierName() {
        return jiadianOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setJiadianOrderCourierName(String jiadianOrderCourierName) {
        this.jiadianOrderCourierName = jiadianOrderCourierName;
    }
    /**
	 * 设置：订单快递单号
	 */
    public String getJiadianOrderCourierNumber() {
        return jiadianOrderCourierNumber;
    }


    /**
	 * 获取：订单快递单号
	 */

    public void setJiadianOrderCourierNumber(String jiadianOrderCourierNumber) {
        this.jiadianOrderCourierNumber = jiadianOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getJiadianOrderTypes() {
        return jiadianOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setJiadianOrderTypes(Integer jiadianOrderTypes) {
        this.jiadianOrderTypes = jiadianOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getJiadianOrderPaymentTypes() {
        return jiadianOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setJiadianOrderPaymentTypes(Integer jiadianOrderPaymentTypes) {
        this.jiadianOrderPaymentTypes = jiadianOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
