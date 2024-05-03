package com.entity.vo;

import com.entity.JiadianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiadian")
public class JiadianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品名称
     */

    @TableField(value = "jiadian_name")
    private String jiadianName;


    /**
     * 商品编号
     */

    @TableField(value = "jiadian_uuid_number")
    private String jiadianUuidNumber;


    /**
     * 商品照片
     */

    @TableField(value = "jiadian_photo")
    private String jiadianPhoto;


    /**
     * 商品类型
     */

    @TableField(value = "jiadian_types")
    private Integer jiadianTypes;


    /**
     * 商品库存
     */

    @TableField(value = "jiadian_kucun_number")
    private Integer jiadianKucunNumber;


    /**
     * 商品原价
     */

    @TableField(value = "jiadian_old_money")
    private Double jiadianOldMoney;


    /**
     * 现价
     */

    @TableField(value = "jiadian_new_money")
    private Double jiadianNewMoney;


    /**
     * 商品热度
     */

    @TableField(value = "jiadian_clicknum")
    private Integer jiadianClicknum;


    /**
     * 商品介绍
     */

    @TableField(value = "jiadian_content")
    private String jiadianContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiadian_delete")
    private Integer jiadianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：商品名称
	 */
    public String getJiadianName() {
        return jiadianName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setJiadianName(String jiadianName) {
        this.jiadianName = jiadianName;
    }
    /**
	 * 设置：商品编号
	 */
    public String getJiadianUuidNumber() {
        return jiadianUuidNumber;
    }


    /**
	 * 获取：商品编号
	 */

    public void setJiadianUuidNumber(String jiadianUuidNumber) {
        this.jiadianUuidNumber = jiadianUuidNumber;
    }
    /**
	 * 设置：商品照片
	 */
    public String getJiadianPhoto() {
        return jiadianPhoto;
    }


    /**
	 * 获取：商品照片
	 */

    public void setJiadianPhoto(String jiadianPhoto) {
        this.jiadianPhoto = jiadianPhoto;
    }
    /**
	 * 设置：商品类型
	 */
    public Integer getJiadianTypes() {
        return jiadianTypes;
    }


    /**
	 * 获取：商品类型
	 */

    public void setJiadianTypes(Integer jiadianTypes) {
        this.jiadianTypes = jiadianTypes;
    }
    /**
	 * 设置：商品库存
	 */
    public Integer getJiadianKucunNumber() {
        return jiadianKucunNumber;
    }


    /**
	 * 获取：商品库存
	 */

    public void setJiadianKucunNumber(Integer jiadianKucunNumber) {
        this.jiadianKucunNumber = jiadianKucunNumber;
    }
    /**
	 * 设置：商品原价
	 */
    public Double getJiadianOldMoney() {
        return jiadianOldMoney;
    }


    /**
	 * 获取：商品原价
	 */

    public void setJiadianOldMoney(Double jiadianOldMoney) {
        this.jiadianOldMoney = jiadianOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getJiadianNewMoney() {
        return jiadianNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setJiadianNewMoney(Double jiadianNewMoney) {
        this.jiadianNewMoney = jiadianNewMoney;
    }
    /**
	 * 设置：商品热度
	 */
    public Integer getJiadianClicknum() {
        return jiadianClicknum;
    }


    /**
	 * 获取：商品热度
	 */

    public void setJiadianClicknum(Integer jiadianClicknum) {
        this.jiadianClicknum = jiadianClicknum;
    }
    /**
	 * 设置：商品介绍
	 */
    public String getJiadianContent() {
        return jiadianContent;
    }


    /**
	 * 获取：商品介绍
	 */

    public void setJiadianContent(String jiadianContent) {
        this.jiadianContent = jiadianContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiadianDelete() {
        return jiadianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiadianDelete(Integer jiadianDelete) {
        this.jiadianDelete = jiadianDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
