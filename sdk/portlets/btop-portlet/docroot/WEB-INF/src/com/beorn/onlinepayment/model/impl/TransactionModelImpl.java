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

import com.beorn.onlinepayment.model.Transaction;
import com.beorn.onlinepayment.model.TransactionModel;
import com.beorn.onlinepayment.model.TransactionSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Transaction service. Represents a row in the &quot;Payment_Transaction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.beorn.onlinepayment.model.TransactionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TransactionImpl}.
 * </p>
 *
 * @author Sebastien Meunier
 * @see TransactionImpl
 * @see com.beorn.onlinepayment.model.Transaction
 * @see com.beorn.onlinepayment.model.TransactionModel
 * @generated
 */
@JSON(strict = true)
public class TransactionModelImpl extends BaseModelImpl<Transaction>
	implements TransactionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a transaction model instance should use the {@link com.beorn.onlinepayment.model.Transaction} interface instead.
	 */
	public static final String TABLE_NAME = "Payment_Transaction";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "transactionId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "applicationId", Types.VARCHAR },
			{ "sellerId", Types.BIGINT },
			{ "amount", Types.DOUBLE },
			{ "currencyCode", Types.VARCHAR },
			{ "status", Types.BIGINT },
			{ "paymentApplicationId", Types.VARCHAR },
			{ "amountPaid", Types.DOUBLE },
			{ "amountRefunded", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table Payment_Transaction (uuid_ VARCHAR(75) null,companyId LONG,groupId LONG,userId LONG,transactionId LONG not null primary key,createDate DATE null,modifiedDate DATE null,applicationId VARCHAR(255) null,sellerId LONG,amount DOUBLE,currencyCode VARCHAR(75) null,status LONG,paymentApplicationId VARCHAR(75) null,amountPaid DOUBLE,amountRefunded DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table Payment_Transaction";
	public static final String ORDER_BY_JPQL = " ORDER BY transaction.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Payment_Transaction.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.beorn.onlinepayment.model.Transaction"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.beorn.onlinepayment.model.Transaction"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.beorn.onlinepayment.model.Transaction"),
			true);
	public static long APPLICATIONID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long SELLERID_COLUMN_BITMASK = 4L;
	public static long USERID_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Transaction toModel(TransactionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Transaction model = new TransactionImpl();

		model.setUuid(soapModel.getUuid());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setTransactionId(soapModel.getTransactionId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setApplicationId(soapModel.getApplicationId());
		model.setSellerId(soapModel.getSellerId());
		model.setAmount(soapModel.getAmount());
		model.setCurrencyCode(soapModel.getCurrencyCode());
		model.setStatus(soapModel.getStatus());
		model.setPaymentApplicationId(soapModel.getPaymentApplicationId());
		model.setAmountPaid(soapModel.getAmountPaid());
		model.setAmountRefunded(soapModel.getAmountRefunded());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Transaction> toModels(TransactionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Transaction> models = new ArrayList<Transaction>(soapModels.length);

		for (TransactionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.beorn.onlinepayment.model.Transaction"));

	public TransactionModelImpl() {
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTransactionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_transactionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Transaction.class;
	}

	public String getModelClassName() {
		return Transaction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("transactionId", getTransactionId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationId", getApplicationId());
		attributes.put("sellerId", getSellerId());
		attributes.put("amount", getAmount());
		attributes.put("currencyCode", getCurrencyCode());
		attributes.put("status", getStatus());
		attributes.put("paymentApplicationId", getPaymentApplicationId());
		attributes.put("amountPaid", getAmountPaid());
		attributes.put("amountRefunded", getAmountRefunded());

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

		Long transactionId = (Long)attributes.get("transactionId");

		if (transactionId != null) {
			setTransactionId(transactionId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String applicationId = (String)attributes.get("applicationId");

		if (applicationId != null) {
			setApplicationId(applicationId);
		}

		Long sellerId = (Long)attributes.get("sellerId");

		if (sellerId != null) {
			setSellerId(sellerId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String currencyCode = (String)attributes.get("currencyCode");

		if (currencyCode != null) {
			setCurrencyCode(currencyCode);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String paymentApplicationId = (String)attributes.get(
				"paymentApplicationId");

		if (paymentApplicationId != null) {
			setPaymentApplicationId(paymentApplicationId);
		}

		Double amountPaid = (Double)attributes.get("amountPaid");

		if (amountPaid != null) {
			setAmountPaid(amountPaid);
		}

		Double amountRefunded = (Double)attributes.get("amountRefunded");

		if (amountRefunded != null) {
			setAmountRefunded(amountRefunded);
		}
	}

	@JSON
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

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
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

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public long getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(long transactionId) {
		_transactionId = transactionId;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getApplicationId() {
		if (_applicationId == null) {
			return StringPool.BLANK;
		}
		else {
			return _applicationId;
		}
	}

	public void setApplicationId(String applicationId) {
		_columnBitmask |= APPLICATIONID_COLUMN_BITMASK;

		if (_originalApplicationId == null) {
			_originalApplicationId = _applicationId;
		}

		_applicationId = applicationId;
	}

	public String getOriginalApplicationId() {
		return GetterUtil.getString(_originalApplicationId);
	}

	@JSON
	public long getSellerId() {
		return _sellerId;
	}

	public void setSellerId(long sellerId) {
		_columnBitmask |= SELLERID_COLUMN_BITMASK;

		if (!_setOriginalSellerId) {
			_setOriginalSellerId = true;

			_originalSellerId = _sellerId;
		}

		_sellerId = sellerId;
	}

	public long getOriginalSellerId() {
		return _originalSellerId;
	}

	@JSON
	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	@JSON
	public String getCurrencyCode() {
		if (_currencyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _currencyCode;
		}
	}

	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;
	}

	@JSON
	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	@JSON
	public String getPaymentApplicationId() {
		if (_paymentApplicationId == null) {
			return StringPool.BLANK;
		}
		else {
			return _paymentApplicationId;
		}
	}

	public void setPaymentApplicationId(String paymentApplicationId) {
		_paymentApplicationId = paymentApplicationId;
	}

	@JSON
	public double getAmountPaid() {
		return _amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		_amountPaid = amountPaid;
	}

	@JSON
	public double getAmountRefunded() {
		return _amountRefunded;
	}

	public void setAmountRefunded(double amountRefunded) {
		_amountRefunded = amountRefunded;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Transaction.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Transaction toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Transaction)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		TransactionImpl transactionImpl = new TransactionImpl();

		transactionImpl.setUuid(getUuid());
		transactionImpl.setCompanyId(getCompanyId());
		transactionImpl.setGroupId(getGroupId());
		transactionImpl.setUserId(getUserId());
		transactionImpl.setTransactionId(getTransactionId());
		transactionImpl.setCreateDate(getCreateDate());
		transactionImpl.setModifiedDate(getModifiedDate());
		transactionImpl.setApplicationId(getApplicationId());
		transactionImpl.setSellerId(getSellerId());
		transactionImpl.setAmount(getAmount());
		transactionImpl.setCurrencyCode(getCurrencyCode());
		transactionImpl.setStatus(getStatus());
		transactionImpl.setPaymentApplicationId(getPaymentApplicationId());
		transactionImpl.setAmountPaid(getAmountPaid());
		transactionImpl.setAmountRefunded(getAmountRefunded());

		transactionImpl.resetOriginalValues();

		return transactionImpl;
	}

	public int compareTo(Transaction transaction) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				transaction.getModifiedDate());

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

		Transaction transaction = null;

		try {
			transaction = (Transaction)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = transaction.getPrimaryKey();

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
		TransactionModelImpl transactionModelImpl = this;

		transactionModelImpl._originalUuid = transactionModelImpl._uuid;

		transactionModelImpl._originalGroupId = transactionModelImpl._groupId;

		transactionModelImpl._setOriginalGroupId = false;

		transactionModelImpl._originalUserId = transactionModelImpl._userId;

		transactionModelImpl._setOriginalUserId = false;

		transactionModelImpl._originalApplicationId = transactionModelImpl._applicationId;

		transactionModelImpl._originalSellerId = transactionModelImpl._sellerId;

		transactionModelImpl._setOriginalSellerId = false;

		transactionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Transaction> toCacheModel() {
		TransactionCacheModel transactionCacheModel = new TransactionCacheModel();

		transactionCacheModel.uuid = getUuid();

		String uuid = transactionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			transactionCacheModel.uuid = null;
		}

		transactionCacheModel.companyId = getCompanyId();

		transactionCacheModel.groupId = getGroupId();

		transactionCacheModel.userId = getUserId();

		transactionCacheModel.transactionId = getTransactionId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			transactionCacheModel.createDate = createDate.getTime();
		}
		else {
			transactionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			transactionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			transactionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		transactionCacheModel.applicationId = getApplicationId();

		String applicationId = transactionCacheModel.applicationId;

		if ((applicationId != null) && (applicationId.length() == 0)) {
			transactionCacheModel.applicationId = null;
		}

		transactionCacheModel.sellerId = getSellerId();

		transactionCacheModel.amount = getAmount();

		transactionCacheModel.currencyCode = getCurrencyCode();

		String currencyCode = transactionCacheModel.currencyCode;

		if ((currencyCode != null) && (currencyCode.length() == 0)) {
			transactionCacheModel.currencyCode = null;
		}

		transactionCacheModel.status = getStatus();

		transactionCacheModel.paymentApplicationId = getPaymentApplicationId();

		String paymentApplicationId = transactionCacheModel.paymentApplicationId;

		if ((paymentApplicationId != null) &&
				(paymentApplicationId.length() == 0)) {
			transactionCacheModel.paymentApplicationId = null;
		}

		transactionCacheModel.amountPaid = getAmountPaid();

		transactionCacheModel.amountRefunded = getAmountRefunded();

		return transactionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", transactionId=");
		sb.append(getTransactionId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", applicationId=");
		sb.append(getApplicationId());
		sb.append(", sellerId=");
		sb.append(getSellerId());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", currencyCode=");
		sb.append(getCurrencyCode());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", paymentApplicationId=");
		sb.append(getPaymentApplicationId());
		sb.append(", amountPaid=");
		sb.append(getAmountPaid());
		sb.append(", amountRefunded=");
		sb.append(getAmountRefunded());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.beorn.onlinepayment.model.Transaction");
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
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
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
			"<column><column-name>applicationId</column-name><column-value><![CDATA[");
		sb.append(getApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sellerId</column-name><column-value><![CDATA[");
		sb.append(getSellerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyCode</column-name><column-value><![CDATA[");
		sb.append(getCurrencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentApplicationId</column-name><column-value><![CDATA[");
		sb.append(getPaymentApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amountPaid</column-name><column-value><![CDATA[");
		sb.append(getAmountPaid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amountRefunded</column-name><column-value><![CDATA[");
		sb.append(getAmountRefunded());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Transaction.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Transaction.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _transactionId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _applicationId;
	private String _originalApplicationId;
	private long _sellerId;
	private long _originalSellerId;
	private boolean _setOriginalSellerId;
	private double _amount;
	private String _currencyCode;
	private long _status;
	private String _paymentApplicationId;
	private double _amountPaid;
	private double _amountRefunded;
	private long _columnBitmask;
	private Transaction _escapedModelProxy;
}