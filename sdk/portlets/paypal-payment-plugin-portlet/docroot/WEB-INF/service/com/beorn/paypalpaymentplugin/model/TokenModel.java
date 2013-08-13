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

package com.beorn.paypalpaymentplugin.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Token service. Represents a row in the &quot;PaypalPaymentPlugin_Token&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.beorn.paypalpaymentplugin.model.impl.TokenModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.beorn.paypalpaymentplugin.model.impl.TokenImpl}.
 * </p>
 *
 * @author Sebastien Meunier
 * @see Token
 * @see com.beorn.paypalpaymentplugin.model.impl.TokenImpl
 * @see com.beorn.paypalpaymentplugin.model.impl.TokenModelImpl
 * @generated
 */
public interface TokenModel extends BaseModel<Token> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a token model instance should use the {@link Token} interface instead.
	 */

	/**
	 * Returns the primary key of this token.
	 *
	 * @return the primary key of this token
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this token.
	 *
	 * @param primaryKey the primary key of this token
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the uuid of this token.
	 *
	 * @return the uuid of this token
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this token.
	 *
	 * @param uuid the uuid of this token
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the create date of this token.
	 *
	 * @return the create date of this token
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this token.
	 *
	 * @param createDate the create date of this token
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this token.
	 *
	 * @return the modified date of this token
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this token.
	 *
	 * @param modifiedDate the modified date of this token
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the token ID of this token.
	 *
	 * @return the token ID of this token
	 */
	@AutoEscape
	public String getTokenId();

	/**
	 * Sets the token ID of this token.
	 *
	 * @param tokenId the token ID of this token
	 */
	public void setTokenId(String tokenId);

	/**
	 * Returns the transaction ID of this token.
	 *
	 * @return the transaction ID of this token
	 */
	public long getTransactionId();

	/**
	 * Sets the transaction ID of this token.
	 *
	 * @param transactionId the transaction ID of this token
	 */
	public void setTransactionId(long transactionId);

	/**
	 * Returns the status of this token.
	 *
	 * @return the status of this token
	 */
	public long getStatus();

	/**
	 * Sets the status of this token.
	 *
	 * @param status the status of this token
	 */
	public void setStatus(long status);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Token token);

	public int hashCode();

	public CacheModel<Token> toCacheModel();

	public Token toEscapedModel();

	public String toString();

	public String toXmlString();
}