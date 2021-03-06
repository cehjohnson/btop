/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.beorn.onlinepayment.model.impl;

import com.beorn.onlinepayment.model.Rule;
import com.beorn.onlinepayment.model.RuleModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Rule service. Represents a row in the &quot;Payment_Rule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.beorn.onlinepayment.model.RuleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RuleImpl}.
 * </p>
 *
 * @author Sebastien Meunier
 * @see RuleImpl
 * @see com.beorn.onlinepayment.model.Rule
 * @see com.beorn.onlinepayment.model.RuleModel
 * @generated
 */
public class RuleModelImpl extends BaseModelImpl<Rule> implements RuleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rule model instance should use the {@link com.beorn.onlinepayment.model.Rule} interface instead.
	 */
	public static final String TABLE_NAME = "Payment_Rule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "ruleId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "paymentPluginConfigId", Types.BIGINT },
			{ "content", Types.CLOB },
			{ "priority", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Payment_Rule (uuid_ VARCHAR(75) null,companyId LONG,groupId LONG,userId LONG,ruleId LONG not null primary key,createDate DATE null,modifiedDate DATE null,paymentPluginConfigId LONG,content TEXT null,priority INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Payment_Rule";
	public static final String ORDER_BY_JPQL = " ORDER BY rule.priority DESC, rule.paymentPluginConfigId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Payment_Rule.priority DESC, Payment_Rule.paymentPluginConfigId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.beorn.onlinepayment.model.Rule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.beorn.onlinepayment.model.Rule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.beorn.onlinepayment.model.Rule"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long PAYMENTPLUGINCONFIGID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.beorn.onlinepayment.model.Rule"));

	public RuleModelImpl() {
	}

	public long getPrimaryKey() {
		return _ruleId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRuleId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ruleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Rule.class;
	}

	public String getModelClassName() {
		return Rule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("ruleId", getRuleId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("paymentPluginConfigId", getPaymentPluginConfigId());
		attributes.put("content", getContent());
		attributes.put("priority", getPriority());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long paymentPluginConfigId = (Long)attributes.get(
				"paymentPluginConfigId");

		if (paymentPluginConfigId != null) {
			setPaymentPluginConfigId(paymentPluginConfigId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getPaymentPluginConfigId() {
		return _paymentPluginConfigId;
	}

	public void setPaymentPluginConfigId(long paymentPluginConfigId) {
		_columnBitmask = -1L;

		if (!_setOriginalPaymentPluginConfigId) {
			_setOriginalPaymentPluginConfigId = true;

			_originalPaymentPluginConfigId = _paymentPluginConfigId;
		}

		_paymentPluginConfigId = paymentPluginConfigId;
	}

	public long getOriginalPaymentPluginConfigId() {
		return _originalPaymentPluginConfigId;
	}

	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	public void setContent(String content) {
		_content = content;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_columnBitmask = -1L;

		_priority = priority;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Rule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Rule toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Rule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		RuleImpl ruleImpl = new RuleImpl();

		ruleImpl.setUuid(getUuid());
		ruleImpl.setCompanyId(getCompanyId());
		ruleImpl.setGroupId(getGroupId());
		ruleImpl.setUserId(getUserId());
		ruleImpl.setRuleId(getRuleId());
		ruleImpl.setCreateDate(getCreateDate());
		ruleImpl.setModifiedDate(getModifiedDate());
		ruleImpl.setPaymentPluginConfigId(getPaymentPluginConfigId());
		ruleImpl.setContent(getContent());
		ruleImpl.setPriority(getPriority());

		ruleImpl.resetOriginalValues();

		return ruleImpl;
	}

	public int compareTo(Rule rule) {
		int value = 0;

		if (getPriority() < rule.getPriority()) {
			value = -1;
		}
		else if (getPriority() > rule.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPaymentPluginConfigId() < rule.getPaymentPluginConfigId()) {
			value = -1;
		}
		else if (getPaymentPluginConfigId() > rule.getPaymentPluginConfigId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Rule rule = null;

		try {
			rule = (Rule)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = rule.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		RuleModelImpl ruleModelImpl = this;

		ruleModelImpl._originalUuid = ruleModelImpl._uuid;

		ruleModelImpl._originalCompanyId = ruleModelImpl._companyId;

		ruleModelImpl._setOriginalCompanyId = false;

		ruleModelImpl._originalGroupId = ruleModelImpl._groupId;

		ruleModelImpl._setOriginalGroupId = false;

		ruleModelImpl._originalPaymentPluginConfigId = ruleModelImpl._paymentPluginConfigId;

		ruleModelImpl._setOriginalPaymentPluginConfigId = false;

		ruleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Rule> toCacheModel() {
		RuleCacheModel ruleCacheModel = new RuleCacheModel();

		ruleCacheModel.uuid = getUuid();

		String uuid = ruleCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			ruleCacheModel.uuid = null;
		}

		ruleCacheModel.companyId = getCompanyId();

		ruleCacheModel.groupId = getGroupId();

		ruleCacheModel.userId = getUserId();

		ruleCacheModel.ruleId = getRuleId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			ruleCacheModel.createDate = createDate.getTime();
		}
		else {
			ruleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ruleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ruleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ruleCacheModel.paymentPluginConfigId = getPaymentPluginConfigId();

		ruleCacheModel.content = getContent();

		String content = ruleCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			ruleCacheModel.content = null;
		}

		ruleCacheModel.priority = getPriority();

		return ruleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", ruleId=");
		sb.append(getRuleId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", paymentPluginConfigId=");
		sb.append(getPaymentPluginConfigId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.beorn.onlinepayment.model.Rule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ruleId</column-name><column-value><![CDATA[");
		sb.append(getRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentPluginConfigId</column-name><column-value><![CDATA[");
		sb.append(getPaymentPluginConfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Rule.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Rule.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _ruleId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _paymentPluginConfigId;
	private long _originalPaymentPluginConfigId;
	private boolean _setOriginalPaymentPluginConfigId;
	private String _content;
	private int _priority;
	private long _columnBitmask;
	private Rule _escapedModelProxy;
}