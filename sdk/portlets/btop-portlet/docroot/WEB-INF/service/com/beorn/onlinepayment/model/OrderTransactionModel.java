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

package com.beorn.onlinepayment.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OrderTransaction service. Represents a row in the &quot;Payment_OrderTransaction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.beorn.onlinepayment.model.impl.OrderTransactionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.beorn.onlinepayment.model.impl.OrderTransactionImpl}.
 * </p>
 *
 * @author Sebastien Meunier
 * @see OrderTransaction
 * @see com.beorn.onlinepayment.model.impl.OrderTransactionImpl
 * @see com.beorn.onlinepayment.model.impl.OrderTransactionModelImpl
 * @generated
 */
public interface OrderTransactionModel extends BaseModel<OrderTransaction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a order transaction model instance should use the {@link OrderTransaction} interface instead.
	 */

	/**
	 * Returns the primary key of this order transaction.
	 *
	 * @return the primary key of this order transaction
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this order transaction.
	 *
	 * @param primaryKey the primary key of this order transaction
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this order transaction.
	 *
	 * @return the uuid of this order transaction
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this order transaction.
	 *
	 * @param uuid the uuid of this order transaction
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the create date of this order transaction.
	 *
	 * @return the create date of this order transaction
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this order transaction.
	 *
	 * @param createDate the create date of this order transaction
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this order transaction.
	 *
	 * @return the modified date of this order transaction
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this order transaction.
	 *
	 * @param modifiedDate the modified date of this order transaction
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the order ID of this order transaction.
	 *
	 * @return the order ID of this order transaction
	 */
	public long getOrderId();

	/**
	 * Sets the order ID of this order transaction.
	 *
	 * @param orderId the order ID of this order transaction
	 */
	public void setOrderId(long orderId);

	/**
	 * Returns the transaction ID of this order transaction.
	 *
	 * @return the transaction ID of this order transaction
	 */
	public long getTransactionId();

	/**
	 * Sets the transaction ID of this order transaction.
	 *
	 * @param transactionId the transaction ID of this order transaction
	 */
	public void setTransactionId(long transactionId);

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

	public int compareTo(OrderTransaction orderTransaction);

	public int hashCode();

	public CacheModel<OrderTransaction> toCacheModel();

	public OrderTransaction toEscapedModel();

	public String toString();

	public String toXmlString();
}