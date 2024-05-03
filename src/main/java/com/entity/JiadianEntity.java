package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 商品
 *
 * @author 
 * @email
 */
@TableName("jiadian")
public class JiadianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiadianEntity() {

	}

	public JiadianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 商品名称
     */
    @ColumnInfo(comment="商品名称",type="varchar(200)")
    @TableField(value = "jiadian_name")

    private String jiadianName;


    /**
     * 商品编号
     */
    @ColumnInfo(comment="商品编号",type="varchar(200)")
    @TableField(value = "jiadian_uuid_number")

    private String jiadianUuidNumber;


    /**
     * 商品照片
     */
    @ColumnInfo(comment="商品照片",type="varchar(200)")
    @TableField(value = "jiadian_photo")

    private String jiadianPhoto;


    /**
     * 商品类型
     */
    @ColumnInfo(comment="商品类型",type="int(11)")
    @TableField(value = "jiadian_types")

    private Integer jiadianTypes;


    /**
     * 商品库存
     */
    @ColumnInfo(comment="商品库存",type="int(11)")
    @TableField(value = "jiadian_kucun_number")

    private Integer jiadianKucunNumber;


    /**
     * 商品原价
     */
    @ColumnInfo(comment="商品原价",type="decimal(10,2)")
    @TableField(value = "jiadian_old_money")

    private Double jiadianOldMoney;


    /**
     * 现价
     */
    @ColumnInfo(comment="现价",type="decimal(10,2)")
    @TableField(value = "jiadian_new_money")

    private Double jiadianNewMoney;


    /**
     * 商品热度
     */
    @ColumnInfo(comment="商品热度",type="int(11)")
    @TableField(value = "jiadian_clicknum")

    private Integer jiadianClicknum;


    /**
     * 商品介绍
     */
    @ColumnInfo(comment="商品介绍",type="longtext")
    @TableField(value = "jiadian_content")

    private String jiadianContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiadian_delete")

    private Integer jiadianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiadian{" +
            ", id=" + id +
            ", jiadianName=" + jiadianName +
            ", jiadianUuidNumber=" + jiadianUuidNumber +
            ", jiadianPhoto=" + jiadianPhoto +
            ", jiadianTypes=" + jiadianTypes +
            ", jiadianKucunNumber=" + jiadianKucunNumber +
            ", jiadianOldMoney=" + jiadianOldMoney +
            ", jiadianNewMoney=" + jiadianNewMoney +
            ", jiadianClicknum=" + jiadianClicknum +
            ", jiadianContent=" + jiadianContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", jiadianDelete=" + jiadianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
