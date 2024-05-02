package com.entity.view;

import com.entity.JiaoanLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 教案留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaoan_liuyan")
public class JiaoanLiuyanView extends JiaoanLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 jiaoan
			/**
			* 教案标题
			*/
			private String jiaoanName;
			/**
			* 教案照片
			*/
			private String jiaoanPhoto;
			/**
			* 教案文件
			*/
			private String jiaoanFile;
			/**
			* 教案类型
			*/
			private Integer jiaoanTypes;
				/**
				* 教案类型的值
				*/
				private String jiaoanValue;
			/**
			* 点击次数
			*/
			private Integer jiaoanClicknum;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer jiaoanDelete;
			/**
			* 教案介绍
			*/
			private String jiaoanContent;

		//级联表 yonghu
			/**
			* 学号
			*/
			private String yonghuUuidNumber;
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 学生手机号
			*/
			private String yonghuPhone;
			/**
			* 学生身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 学生头像
			*/
			private String yonghuPhoto;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public JiaoanLiuyanView() {

	}

	public JiaoanLiuyanView(JiaoanLiuyanEntity jiaoanLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, jiaoanLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




























				//级联表的get和set jiaoan
					/**
					* 获取： 教案标题
					*/
					public String getJiaoanName() {
						return jiaoanName;
					}
					/**
					* 设置： 教案标题
					*/
					public void setJiaoanName(String jiaoanName) {
						this.jiaoanName = jiaoanName;
					}
					/**
					* 获取： 教案照片
					*/
					public String getJiaoanPhoto() {
						return jiaoanPhoto;
					}
					/**
					* 设置： 教案照片
					*/
					public void setJiaoanPhoto(String jiaoanPhoto) {
						this.jiaoanPhoto = jiaoanPhoto;
					}
					/**
					* 获取： 教案文件
					*/
					public String getJiaoanFile() {
						return jiaoanFile;
					}
					/**
					* 设置： 教案文件
					*/
					public void setJiaoanFile(String jiaoanFile) {
						this.jiaoanFile = jiaoanFile;
					}
					/**
					* 获取： 教案类型
					*/
					public Integer getJiaoanTypes() {
						return jiaoanTypes;
					}
					/**
					* 设置： 教案类型
					*/
					public void setJiaoanTypes(Integer jiaoanTypes) {
						this.jiaoanTypes = jiaoanTypes;
					}


						/**
						* 获取： 教案类型的值
						*/
						public String getJiaoanValue() {
							return jiaoanValue;
						}
						/**
						* 设置： 教案类型的值
						*/
						public void setJiaoanValue(String jiaoanValue) {
							this.jiaoanValue = jiaoanValue;
						}
					/**
					* 获取： 点击次数
					*/
					public Integer getJiaoanClicknum() {
						return jiaoanClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setJiaoanClicknum(Integer jiaoanClicknum) {
						this.jiaoanClicknum = jiaoanClicknum;
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
					public Integer getJiaoanDelete() {
						return jiaoanDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setJiaoanDelete(Integer jiaoanDelete) {
						this.jiaoanDelete = jiaoanDelete;
					}
					/**
					* 获取： 教案介绍
					*/
					public String getJiaoanContent() {
						return jiaoanContent;
					}
					/**
					* 设置： 教案介绍
					*/
					public void setJiaoanContent(String jiaoanContent) {
						this.jiaoanContent = jiaoanContent;
					}































				//级联表的get和set yonghu
					/**
					* 获取： 学号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}
					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 学生手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 学生身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 学生头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
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



}
