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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the PaymentPlugin service. Represents a row in the &quot;Payment_PaymentPlugin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.beorn.onlinepayment.model.impl.PaymentPluginModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.beorn.onlinepayment.model.impl.PaymentPluginImpl}.
 * </p>
 *
 * @author Sebastien Meunier
 * @see PaymentPlugin
 * @see com.beorn.onlinepayment.model.impl.PaymentPluginImpl
 * @see com.beorn.onlinepayment.model.impl.PaymentPluginModelImpl
 * @generated
 */
public interface PaymentPluginModel extends BaseModel<PaymentPlugin> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a payment plugin model instance should use the {@link PaymentPlugin} interface instead.
	 */

	/**
	 * Returns the primary key of this payment plugin.
	 *
	 * @return the primary key of this payment plugin
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this payment plugin.
	 *
	 * @param primaryKey the primary key of this payment plugin
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this payment plugin.
	 *
	 * @return the uuid of this payment plugin
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this payment plugin.
	 *
	 * @param uuid the uuid of this payment plugin
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the company ID of this payment plugin.
	 *
	 * @return the company ID of this payment plugin
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this payment plugin.
	 *
	 * @param companyId the company ID of this payment plugin
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this payment plugin.
	 *
	 * @return the group ID of this payment plugin
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this payment plugin.
	 *
	 * @param groupId the group ID of this payment plugin
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this payment plugin.
	 *
	 * @return the user ID of this payment plugin
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this payment plugin.
	 *
	 * @param userId the user ID of this payment plugin
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this payment plugin.
	 *
	 * @return the user uuid of this payment plugin
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this payment plugin.
	 *
	 * @param userUuid the user uuid of this payment plugin
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the payment plugin ID of this payment plugin.
	 *
	 * @return the payment plugin ID of this payment plugin
	 */
	public long getPaymentPluginId();

	/**
	 * Sets the payment plugin ID of this payment plugin.
	 *
	 * @param paymentPluginId the payment plugin ID of this payment plugin
	 */
	public void setPaymentPluginId(long paymentPluginId);

	/**
	 * Returns the create date of this payment plugin.
	 *
	 * @return the create date of this payment plugin
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this payment plugin.
	 *
	 * @param createDate the create date of this payment plugin
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this payment plugin.
	 *
	 * @return the modified date of this payment plugin
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this payment plugin.
	 *
	 * @param modifiedDate the modified date of this payment plugin
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the application ID of this payment plugin.
	 *
	 * @return the application ID of this payment plugin
	 */
	@AutoEscape
	public String getApplicationId();

	/**
	 * Sets the application ID of this payment plugin.
	 *
	 * @param applicationId the application ID of this payment plugin
	 */
	public void setApplicationId(String applicationId);

	/**
	 * Returns the name of this payment plugin.
	 *
	 * @return the name of this payment plugin
	 */
	public String getName();

	/**
	 * Returns the localized name of this payment plugin in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this payment plugin
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this payment plugin in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this payment plugin. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this payment plugin in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this payment plugin
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this payment plugin in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this payment plugin
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this payment plugin.
	 *
	 * @return the locales and localized names of this payment plugin
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this payment plugin.
	 *
	 * @param name the name of this payment plugin
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this payment plugin in the language.
	 *
	 * @param name the localized name of this payment plugin
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this payment plugin in the language, and sets the default locale.
	 *
	 * @param name the localized name of this payment plugin
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this payment plugin from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this payment plugin
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this payment plugin from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this payment plugin
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the plugin config parameters of this payment plugin.
	 *
	 * @return the plugin config parameters of this payment plugin
	 */
	@AutoEscape
	public String getPluginConfigParameters();

	/**
	 * Sets the plugin config parameters of this payment plugin.
	 *
	 * @param pluginConfigParameters the plugin config parameters of this payment plugin
	 */
	public void setPluginConfigParameters(String pluginConfigParameters);

	/**
	 * Returns the seller config parameters of this payment plugin.
	 *
	 * @return the seller config parameters of this payment plugin
	 */
	@AutoEscape
	public String getSellerConfigParameters();

	/**
	 * Sets the seller config parameters of this payment plugin.
	 *
	 * @param sellerConfigParameters the seller config parameters of this payment plugin
	 */
	public void setSellerConfigParameters(String sellerConfigParameters);

	/**
	 * Returns the plugin config of this payment plugin.
	 *
	 * @return the plugin config of this payment plugin
	 */
	@AutoEscape
	public String getPluginConfig();

	/**
	 * Sets the plugin config of this payment plugin.
	 *
	 * @param pluginConfig the plugin config of this payment plugin
	 */
	public void setPluginConfig(String pluginConfig);

	/**
	 * Returns the configured of this payment plugin.
	 *
	 * @return the configured of this payment plugin
	 */
	public boolean getConfigured();

	/**
	 * Returns <code>true</code> if this payment plugin is configured.
	 *
	 * @return <code>true</code> if this payment plugin is configured; <code>false</code> otherwise
	 */
	public boolean isConfigured();

	/**
	 * Sets whether this payment plugin is configured.
	 *
	 * @param configured the configured of this payment plugin
	 */
	public void setConfigured(boolean configured);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	public Object clone();

	public int compareTo(PaymentPlugin paymentPlugin);

	public int hashCode();

	public CacheModel<PaymentPlugin> toCacheModel();

	public PaymentPlugin toEscapedModel();

	public String toString();

	public String toXmlString();
}