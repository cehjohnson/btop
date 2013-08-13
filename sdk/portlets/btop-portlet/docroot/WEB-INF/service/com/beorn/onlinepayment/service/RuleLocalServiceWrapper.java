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

package com.beorn.onlinepayment.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link RuleLocalService}.
 * </p>
 *
 * @author    Sebastien Meunier
 * @see       RuleLocalService
 * @generated
 */
public class RuleLocalServiceWrapper implements RuleLocalService,
	ServiceWrapper<RuleLocalService> {
	public RuleLocalServiceWrapper(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	/**
	* Adds the rule to the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.beorn.onlinepayment.model.Rule addRule(
		com.beorn.onlinepayment.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.addRule(rule);
	}

	/**
	* Creates a new rule with the primary key. Does not add the rule to the database.
	*
	* @param ruleId the primary key for the new rule
	* @return the new rule
	*/
	public com.beorn.onlinepayment.model.Rule createRule(long ruleId) {
		return _ruleLocalService.createRule(ruleId);
	}

	/**
	* Deletes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleId the primary key of the rule
	* @return the rule that was removed
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.beorn.onlinepayment.model.Rule deleteRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.deleteRule(ruleId);
	}

	/**
	* Deletes the rule from the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public com.beorn.onlinepayment.model.Rule deleteRule(
		com.beorn.onlinepayment.model.Rule rule)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.deleteRule(rule);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ruleLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.beorn.onlinepayment.model.Rule fetchRule(long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.fetchRule(ruleId);
	}

	/**
	* Returns the rule with the primary key.
	*
	* @param ruleId the primary key of the rule
	* @return the rule
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.beorn.onlinepayment.model.Rule getRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRule(ruleId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rule with the UUID in the group.
	*
	* @param uuid the UUID of rule
	* @param groupId the group id of the rule
	* @return the rule
	* @throws PortalException if a rule with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.beorn.onlinepayment.model.Rule getRuleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRuleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rules
	* @param end the upper bound of the range of rules (not inclusive)
	* @return the range of rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.beorn.onlinepayment.model.Rule> getRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRules(start, end);
	}

	/**
	* Returns the number of rules.
	*
	* @return the number of rules
	* @throws SystemException if a system exception occurred
	*/
	public int getRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRulesCount();
	}

	/**
	* Updates the rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.beorn.onlinepayment.model.Rule updateRule(
		com.beorn.onlinepayment.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.updateRule(rule);
	}

	/**
	* Updates the rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @param merge whether to merge the rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.beorn.onlinepayment.model.Rule updateRule(
		com.beorn.onlinepayment.model.Rule rule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.updateRule(rule, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ruleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ruleLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ruleLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.beorn.onlinepayment.model.Rule addRule(long userId,
		long paymentPluginConfigId, java.lang.String content, int priority,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.addRule(userId, paymentPluginConfigId,
			content, priority, serviceContext);
	}

	public java.util.List<com.beorn.onlinepayment.model.Rule> getSellerRules(
		long sellerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getSellerRules(sellerId, start, end,
			orderByComparator);
	}

	public int getSellerRulesCount(long sellerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getSellerRulesCount(sellerId);
	}

	public java.util.List<com.beorn.onlinepayment.model.Rule> getPaymentPluginConfigRules(
		long paymentPluginConfigId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getPaymentPluginConfigRules(paymentPluginConfigId,
			start, end, orderByComparator);
	}

	public int getPaymentPluginConfigRulesCount(long paymentPluginConfigId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getPaymentPluginConfigRulesCount(paymentPluginConfigId);
	}

	public com.beorn.onlinepayment.model.Rule updateRule(long ruleId,
		long paymentPluginConfigId, java.lang.String content, int priority,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.updateRule(ruleId, paymentPluginConfigId,
			content, priority, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RuleLocalService getWrappedRuleLocalService() {
		return _ruleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRuleLocalService(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	public RuleLocalService getWrappedService() {
		return _ruleLocalService;
	}

	public void setWrappedService(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	private RuleLocalService _ruleLocalService;
}