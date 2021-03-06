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

package com.beorn.paypalpaymentplugin.model.impl;

import com.beorn.paypalpaymentplugin.model.Token;
import com.beorn.paypalpaymentplugin.model.TokenModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Token service. Represents a row in the &quot;PaypalPaymentPlugin_Token&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.beorn.paypalpaymentplugin.model.TokenModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TokenImpl}.
 * </p>
 *
 * @author Sebastien Meunier
 * @see TokenImpl
 * @see com.beorn.paypalpaymentplugin.model.Token
 * @see com.beorn.paypalpaymentplugin.model.TokenModel
 * @generated
 */
public class TokenModelImpl extends BaseModelImpl<Token> implements TokenModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a token model instance should use the {@link com.beorn.paypalpaymentplugin.model.Token} interface instead.
	 */
	public static final String TABLE_NAME = "PaypalPaymentPlugin_Token";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "tokenId", Types.VARCHAR },
			{ "transactionId", Types.BIGINT },
			{ "status", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table PaypalPaymentPlugin_Token (uuid_ VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,tokenId VARCHAR(75) not null primary key,transactionId LONG,status LONG)";
	public static final String TABLE_SQL_DROP = "drop table PaypalPaymentPlugin_Token";
	public static final String ORDER_BY_JPQL = " ORDER BY token.transactionId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY PaypalPaymentPlugin_Token.transactionId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.beorn.paypalpaymentplugin.model.Token"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.beorn.paypalpaymentplugin.model.Token"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.beorn.paypalpaymentplugin.model.Token"),
			true);
	public static long STATUS_COLUMN_BITMASK = 1L;
	public static long TRANSACTIONID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.beorn.paypalpaymentplugin.model.Token"));

	public TokenModelImpl() {
	}

	public String getPrimaryKey() {
		return _tokenId;
	}

	public void setPrimaryKey(String primaryKey) {
		setTokenId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _tokenId;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return Token.class;
	}

	public String getModelClassName() {
		return Token.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tokenId", getTokenId());
		attributes.put("transactionId", getTransactionId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String tokenId = (String)attributes.get("tokenId");

		if (tokenId != null) {
			setTokenId(tokenId);
		}

		Long transactionId = (Long)attributes.get("transactionId");

		if (transactionId != null) {
			setTransactionId(transactionId);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
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

	public String getTokenId() {
		if (_tokenId == null) {
			return StringPool.BLANK;
		}
		else {
			return _tokenId;
		}
	}

	public void setTokenId(String tokenId) {
		_tokenId = tokenId;
	}

	public long getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(long transactionId) {
		_columnBitmask = -1L;

		if (!_setOriginalTransactionId) {
			_setOriginalTransactionId = true;

			_originalTransactionId = _transactionId;
		}

		_transactionId = transactionId;
	}

	public long getOriginalTransactionId() {
		return _originalTransactionId;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public long getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Token toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Token)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		TokenImpl tokenImpl = new TokenImpl();

		tokenImpl.setUuid(getUuid());
		tokenImpl.setCreateDate(getCreateDate());
		tokenImpl.setModifiedDate(getModifiedDate());
		tokenImpl.setTokenId(getTokenId());
		tokenImpl.setTransactionId(getTransactionId());
		tokenImpl.setStatus(getStatus());

		tokenImpl.resetOriginalValues();

		return tokenImpl;
	}

	public int compareTo(Token token) {
		int value = 0;

		if (getTransactionId() < token.getTransactionId()) {
			value = -1;
		}
		else if (getTransactionId() > token.getTransactionId()) {
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

		Token token = null;

		try {
			token = (Token)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = token.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		TokenModelImpl tokenModelImpl = this;

		tokenModelImpl._originalUuid = tokenModelImpl._uuid;

		tokenModelImpl._originalTransactionId = tokenModelImpl._transactionId;

		tokenModelImpl._setOriginalTransactionId = false;

		tokenModelImpl._originalStatus = tokenModelImpl._status;

		tokenModelImpl._setOriginalStatus = false;

		tokenModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Token> toCacheModel() {
		TokenCacheModel tokenCacheModel = new TokenCacheModel();

		tokenCacheModel.uuid = getUuid();

		String uuid = tokenCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tokenCacheModel.uuid = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tokenCacheModel.createDate = createDate.getTime();
		}
		else {
			tokenCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tokenCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tokenCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tokenCacheModel.tokenId = getTokenId();

		String tokenId = tokenCacheModel.tokenId;

		if ((tokenId != null) && (tokenId.length() == 0)) {
			tokenCacheModel.tokenId = null;
		}

		tokenCacheModel.transactionId = getTransactionId();

		tokenCacheModel.status = getStatus();

		return tokenCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", tokenId=");
		sb.append(getTokenId());
		sb.append(", transactionId=");
		sb.append(getTransactionId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.beorn.paypalpaymentplugin.model.Token");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
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
			"<column><column-name>tokenId</column-name><column-value><![CDATA[");
		sb.append(getTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Token.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Token.class
		};
	private String _uuid;
	private String _originalUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tokenId;
	private long _transactionId;
	private long _originalTransactionId;
	private boolean _setOriginalTransactionId;
	private long _status;
	private long _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private Token _escapedModelProxy;
}