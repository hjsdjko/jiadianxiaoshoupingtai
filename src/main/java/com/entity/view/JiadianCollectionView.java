package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiadianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiadian_collection")
public class JiadianCollectionView extends JiadianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jiadianCollectionValue;

	//级联表 商品
		/**
		* 商品名称
		*/

		@ColumnInfo(comment="商品名称",type="varchar(200)")
		private String jiadianName;
		/**
		* 商品编号
		*/

		@ColumnInfo(comment="商品编号",type="varchar(200)")
		private String jiadianUuidNumber;
		/**
		* 商品照片
		*/

		@ColumnInfo(comment="商品照片",type="varchar(200)")
		private String jiadianPhoto;
		/**
		* 商品类型
		*/
		@ColumnInfo(comment="商品类型",type="int(11)")
		private Integer jiadianTypes;
			/**
			* 商品类型的值
			*/
			@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
			private String jiadianValue;
		/**
		* 商品库存
		*/

		@ColumnInfo(comment="商品库存",type="int(11)")
		private Integer jiadianKucunNumber;
		/**
		* 商品原价
		*/
		@ColumnInfo(comment="商品原价",type="decimal(10,2)")
		private Double jiadianOldMoney;
		/**
		* 现价
		*/
		@ColumnInfo(comment="现价",type="decimal(10,2)")
		private Double jiadianNewMoney;
		/**
		* 商品热度
		*/

		@ColumnInfo(comment="商品热度",type="int(11)")
		private Integer jiadianClicknum;
		/**
		* 商品介绍
		*/

		@ColumnInfo(comment="商品介绍",type="longtext")
		private String jiadianContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiadianDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public JiadianCollectionView() {

	}

	public JiadianCollectionView(JiadianCollectionEntity jiadianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jiadianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJiadianCollectionValue() {
		return jiadianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJiadianCollectionValue(String jiadianCollectionValue) {
		this.jiadianCollectionValue = jiadianCollectionValue;
	}


	//级联表的get和set 商品

		/**
		* 获取： 商品名称
		*/
		public String getJiadianName() {
			return jiadianName;
		}
		/**
		* 设置： 商品名称
		*/
		public void setJiadianName(String jiadianName) {
			this.jiadianName = jiadianName;
		}

		/**
		* 获取： 商品编号
		*/
		public String getJiadianUuidNumber() {
			return jiadianUuidNumber;
		}
		/**
		* 设置： 商品编号
		*/
		public void setJiadianUuidNumber(String jiadianUuidNumber) {
			this.jiadianUuidNumber = jiadianUuidNumber;
		}

		/**
		* 获取： 商品照片
		*/
		public String getJiadianPhoto() {
			return jiadianPhoto;
		}
		/**
		* 设置： 商品照片
		*/
		public void setJiadianPhoto(String jiadianPhoto) {
			this.jiadianPhoto = jiadianPhoto;
		}
		/**
		* 获取： 商品类型
		*/
		public Integer getJiadianTypes() {
			return jiadianTypes;
		}
		/**
		* 设置： 商品类型
		*/
		public void setJiadianTypes(Integer jiadianTypes) {
			this.jiadianTypes = jiadianTypes;
		}


			/**
			* 获取： 商品类型的值
			*/
			public String getJiadianValue() {
				return jiadianValue;
			}
			/**
			* 设置： 商品类型的值
			*/
			public void setJiadianValue(String jiadianValue) {
				this.jiadianValue = jiadianValue;
			}

		/**
		* 获取： 商品库存
		*/
		public Integer getJiadianKucunNumber() {
			return jiadianKucunNumber;
		}
		/**
		* 设置： 商品库存
		*/
		public void setJiadianKucunNumber(Integer jiadianKucunNumber) {
			this.jiadianKucunNumber = jiadianKucunNumber;
		}

		/**
		* 获取： 商品原价
		*/
		public Double getJiadianOldMoney() {
			return jiadianOldMoney;
		}
		/**
		* 设置： 商品原价
		*/
		public void setJiadianOldMoney(Double jiadianOldMoney) {
			this.jiadianOldMoney = jiadianOldMoney;
		}

		/**
		* 获取： 现价
		*/
		public Double getJiadianNewMoney() {
			return jiadianNewMoney;
		}
		/**
		* 设置： 现价
		*/
		public void setJiadianNewMoney(Double jiadianNewMoney) {
			this.jiadianNewMoney = jiadianNewMoney;
		}

		/**
		* 获取： 商品热度
		*/
		public Integer getJiadianClicknum() {
			return jiadianClicknum;
		}
		/**
		* 设置： 商品热度
		*/
		public void setJiadianClicknum(Integer jiadianClicknum) {
			this.jiadianClicknum = jiadianClicknum;
		}

		/**
		* 获取： 商品介绍
		*/
		public String getJiadianContent() {
			return jiadianContent;
		}
		/**
		* 设置： 商品介绍
		*/
		public void setJiadianContent(String jiadianContent) {
			this.jiadianContent = jiadianContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiadianDelete() {
			return jiadianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiadianDelete(Integer jiadianDelete) {
			this.jiadianDelete = jiadianDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "JiadianCollectionView{" +
			", jiadianCollectionValue=" + jiadianCollectionValue +
			", jiadianName=" + jiadianName +
			", jiadianUuidNumber=" + jiadianUuidNumber +
			", jiadianPhoto=" + jiadianPhoto +
			", jiadianKucunNumber=" + jiadianKucunNumber +
			", jiadianOldMoney=" + jiadianOldMoney +
			", jiadianNewMoney=" + jiadianNewMoney +
			", jiadianClicknum=" + jiadianClicknum +
			", jiadianContent=" + jiadianContent +
			", jiadianDelete=" + jiadianDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
