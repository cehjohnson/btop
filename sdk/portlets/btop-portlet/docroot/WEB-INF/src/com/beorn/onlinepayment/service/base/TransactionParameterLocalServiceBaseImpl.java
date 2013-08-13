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

package com.beorn.onlinepayment.service.base;

import com.beorn.onlinepayment.model.TransactionParameter;
import com.beorn.onlinepayment.service.OrderTransactionLocalService;
import com.beorn.onlinepayment.service.PaymentMethodLocalService;
import com.beorn.onlinepayment.service.PaymentMethodService;
import com.beorn.onlinepayment.service.PaymentPluginConfigLocalService;
import com.beorn.onlinepayment.service.PaymentPluginLocalService;
import com.beorn.onlinepayment.service.PaymentPluginService;
import com.beorn.onlinepayment.service.RuleLocalService;
import com.beorn.onlinepayment.service.SellerLocalService;
import com.beorn.onlinepayment.service.SellerService;
import com.beorn.onlinepayment.service.TransactionLocalService;
import com.beorn.onlinepayment.service.TransactionLogLocalService;
import com.beorn.onlinepayment.service.TransactionParameterLocalService;
import com.beorn.onlinepayment.service.TransactionService;
import com.beorn.onlinepayment.service.persistence.OrderTransactionPersistence;
import com.beorn.onlinepayment.service.persistence.PaymentMethodFinder;
import com.beorn.onlinepayment.service.persistence.PaymentMethodPersistence;
import com.beorn.onlinepayment.service.persistence.PaymentPluginConfigPersistence;
import com.beorn.onlinepayment.service.persistence.PaymentPluginFinder;
import com.beorn.onlinepayment.service.persistence.PaymentPluginPersistence;
import com.beorn.onlinepayment.service.persistence.RuleFinder;
import com.beorn.onlinepayment.service.persistence.RulePersistence;
import com.beorn.onlinepayment.service.persistence.SellerFinder;
import com.beorn.onlinepayment.service.persistence.SellerPersistence;
import com.beorn.onlinepayment.service.persistence.TransactionFinder;
import com.beorn.onlinepayment.service.persistence.TransactionLogPersistence;
import com.beorn.onlinepayment.service.persistence.TransactionParameterFinder;
import com.beorn.onlinepayment.service.persistence.TransactionParameterPersistence;
import com.beorn.onlinepayment.service.persistence.TransactionPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the transaction parameter local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.beorn.onlinepayment.service.impl.TransactionParameterLocalServiceImpl}.
 * </p>
 *
 * @author Sebastien Meunier
 * @see com.beorn.onlinepayment.service.impl.TransactionParameterLocalServiceImpl
 * @see com.beorn.onlinepayment.service.TransactionParameterLocalServiceUtil
 * @generated
 */
public abstract class TransactionParameterLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TransactionParameterLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.beorn.onlinepayment.service.TransactionParameterLocalServiceUtil} to access the transaction parameter local service.
	 */

	/**
	 * Adds the transaction parameter to the database. Also notifies the appropriate model listeners.
	 *
	 * @param transactionParameter the transaction parameter
	 * @return the transaction parameter that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TransactionParameter addTransactionParameter(
		TransactionParameter transactionParameter) throws SystemException {
		transactionParameter.setNew(true);

		return transactionParameterPersistence.update(transactionParameter,
			false);
	}

	/**
	 * Creates a new transaction parameter with the primary key. Does not add the transaction parameter to the database.
	 *
	 * @param transactionParameterId the primary key for the new transaction parameter
	 * @return the new transaction parameter
	 */
	public TransactionParameter createTransactionParameter(
		long transactionParameterId) {
		return transactionParameterPersistence.create(transactionParameterId);
	}

	/**
	 * Deletes the transaction parameter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transactionParameterId the primary key of the transaction parameter
	 * @return the transaction parameter that was removed
	 * @throws PortalException if a transaction parameter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public TransactionParameter deleteTransactionParameter(
		long transactionParameterId) throws PortalException, SystemException {
		return transactionParameterPersistence.remove(transactionParameterId);
	}

	/**
	 * Deletes the transaction parameter from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transactionParameter the transaction parameter
	 * @return the transaction parameter that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public TransactionParameter deleteTransactionParameter(
		TransactionParameter transactionParameter) throws SystemException {
		return transactionParameterPersistence.remove(transactionParameter);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TransactionParameter.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return transactionParameterPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return transactionParameterPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return transactionParameterPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return transactionParameterPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public TransactionParameter fetchTransactionParameter(
		long transactionParameterId) throws SystemException {
		return transactionParameterPersistence.fetchByPrimaryKey(transactionParameterId);
	}

	/**
	 * Returns the transaction parameter with the primary key.
	 *
	 * @param transactionParameterId the primary key of the transaction parameter
	 * @return the transaction parameter
	 * @throws PortalException if a transaction parameter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TransactionParameter getTransactionParameter(
		long transactionParameterId) throws PortalException, SystemException {
		return transactionParameterPersistence.findByPrimaryKey(transactionParameterId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return transactionParameterPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the transaction parameter with the UUID in the group.
	 *
	 * @param uuid the UUID of transaction parameter
	 * @param groupId the group id of the transaction parameter
	 * @return the transaction parameter
	 * @throws PortalException if a transaction parameter with the UUID in the group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TransactionParameter getTransactionParameterByUuidAndGroupId(
		String uuid, long groupId) throws PortalException, SystemException {
		return transactionParameterPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the transaction parameters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaction parameters
	 * @param end the upper bound of the range of transaction parameters (not inclusive)
	 * @return the range of transaction parameters
	 * @throws SystemException if a system exception occurred
	 */
	public List<TransactionParameter> getTransactionParameters(int start,
		int end) throws SystemException {
		return transactionParameterPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of transaction parameters.
	 *
	 * @return the number of transaction parameters
	 * @throws SystemException if a system exception occurred
	 */
	public int getTransactionParametersCount() throws SystemException {
		return transactionParameterPersistence.countAll();
	}

	/**
	 * Updates the transaction parameter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param transactionParameter the transaction parameter
	 * @return the transaction parameter that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TransactionParameter updateTransactionParameter(
		TransactionParameter transactionParameter) throws SystemException {
		return updateTransactionParameter(transactionParameter, true);
	}

	/**
	 * Updates the transaction parameter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param transactionParameter the transaction parameter
	 * @param merge whether to merge the transaction parameter with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the transaction parameter that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TransactionParameter updateTransactionParameter(
		TransactionParameter transactionParameter, boolean merge)
		throws SystemException {
		transactionParameter.setNew(false);

		return transactionParameterPersistence.update(transactionParameter,
			merge);
	}

	/**
	 * Returns the order transaction local service.
	 *
	 * @return the order transaction local service
	 */
	public OrderTransactionLocalService getOrderTransactionLocalService() {
		return orderTransactionLocalService;
	}

	/**
	 * Sets the order transaction local service.
	 *
	 * @param orderTransactionLocalService the order transaction local service
	 */
	public void setOrderTransactionLocalService(
		OrderTransactionLocalService orderTransactionLocalService) {
		this.orderTransactionLocalService = orderTransactionLocalService;
	}

	/**
	 * Returns the order transaction persistence.
	 *
	 * @return the order transaction persistence
	 */
	public OrderTransactionPersistence getOrderTransactionPersistence() {
		return orderTransactionPersistence;
	}

	/**
	 * Sets the order transaction persistence.
	 *
	 * @param orderTransactionPersistence the order transaction persistence
	 */
	public void setOrderTransactionPersistence(
		OrderTransactionPersistence orderTransactionPersistence) {
		this.orderTransactionPersistence = orderTransactionPersistence;
	}

	/**
	 * Returns the payment method local service.
	 *
	 * @return the payment method local service
	 */
	public PaymentMethodLocalService getPaymentMethodLocalService() {
		return paymentMethodLocalService;
	}

	/**
	 * Sets the payment method local service.
	 *
	 * @param paymentMethodLocalService the payment method local service
	 */
	public void setPaymentMethodLocalService(
		PaymentMethodLocalService paymentMethodLocalService) {
		this.paymentMethodLocalService = paymentMethodLocalService;
	}

	/**
	 * Returns the payment method remote service.
	 *
	 * @return the payment method remote service
	 */
	public PaymentMethodService getPaymentMethodService() {
		return paymentMethodService;
	}

	/**
	 * Sets the payment method remote service.
	 *
	 * @param paymentMethodService the payment method remote service
	 */
	public void setPaymentMethodService(
		PaymentMethodService paymentMethodService) {
		this.paymentMethodService = paymentMethodService;
	}

	/**
	 * Returns the payment method persistence.
	 *
	 * @return the payment method persistence
	 */
	public PaymentMethodPersistence getPaymentMethodPersistence() {
		return paymentMethodPersistence;
	}

	/**
	 * Sets the payment method persistence.
	 *
	 * @param paymentMethodPersistence the payment method persistence
	 */
	public void setPaymentMethodPersistence(
		PaymentMethodPersistence paymentMethodPersistence) {
		this.paymentMethodPersistence = paymentMethodPersistence;
	}

	/**
	 * Returns the payment method finder.
	 *
	 * @return the payment method finder
	 */
	public PaymentMethodFinder getPaymentMethodFinder() {
		return paymentMethodFinder;
	}

	/**
	 * Sets the payment method finder.
	 *
	 * @param paymentMethodFinder the payment method finder
	 */
	public void setPaymentMethodFinder(PaymentMethodFinder paymentMethodFinder) {
		this.paymentMethodFinder = paymentMethodFinder;
	}

	/**
	 * Returns the payment plugin local service.
	 *
	 * @return the payment plugin local service
	 */
	public PaymentPluginLocalService getPaymentPluginLocalService() {
		return paymentPluginLocalService;
	}

	/**
	 * Sets the payment plugin local service.
	 *
	 * @param paymentPluginLocalService the payment plugin local service
	 */
	public void setPaymentPluginLocalService(
		PaymentPluginLocalService paymentPluginLocalService) {
		this.paymentPluginLocalService = paymentPluginLocalService;
	}

	/**
	 * Returns the payment plugin remote service.
	 *
	 * @return the payment plugin remote service
	 */
	public PaymentPluginService getPaymentPluginService() {
		return paymentPluginService;
	}

	/**
	 * Sets the payment plugin remote service.
	 *
	 * @param paymentPluginService the payment plugin remote service
	 */
	public void setPaymentPluginService(
		PaymentPluginService paymentPluginService) {
		this.paymentPluginService = paymentPluginService;
	}

	/**
	 * Returns the payment plugin persistence.
	 *
	 * @return the payment plugin persistence
	 */
	public PaymentPluginPersistence getPaymentPluginPersistence() {
		return paymentPluginPersistence;
	}

	/**
	 * Sets the payment plugin persistence.
	 *
	 * @param paymentPluginPersistence the payment plugin persistence
	 */
	public void setPaymentPluginPersistence(
		PaymentPluginPersistence paymentPluginPersistence) {
		this.paymentPluginPersistence = paymentPluginPersistence;
	}

	/**
	 * Returns the payment plugin finder.
	 *
	 * @return the payment plugin finder
	 */
	public PaymentPluginFinder getPaymentPluginFinder() {
		return paymentPluginFinder;
	}

	/**
	 * Sets the payment plugin finder.
	 *
	 * @param paymentPluginFinder the payment plugin finder
	 */
	public void setPaymentPluginFinder(PaymentPluginFinder paymentPluginFinder) {
		this.paymentPluginFinder = paymentPluginFinder;
	}

	/**
	 * Returns the payment plugin config local service.
	 *
	 * @return the payment plugin config local service
	 */
	public PaymentPluginConfigLocalService getPaymentPluginConfigLocalService() {
		return paymentPluginConfigLocalService;
	}

	/**
	 * Sets the payment plugin config local service.
	 *
	 * @param paymentPluginConfigLocalService the payment plugin config local service
	 */
	public void setPaymentPluginConfigLocalService(
		PaymentPluginConfigLocalService paymentPluginConfigLocalService) {
		this.paymentPluginConfigLocalService = paymentPluginConfigLocalService;
	}

	/**
	 * Returns the payment plugin config persistence.
	 *
	 * @return the payment plugin config persistence
	 */
	public PaymentPluginConfigPersistence getPaymentPluginConfigPersistence() {
		return paymentPluginConfigPersistence;
	}

	/**
	 * Sets the payment plugin config persistence.
	 *
	 * @param paymentPluginConfigPersistence the payment plugin config persistence
	 */
	public void setPaymentPluginConfigPersistence(
		PaymentPluginConfigPersistence paymentPluginConfigPersistence) {
		this.paymentPluginConfigPersistence = paymentPluginConfigPersistence;
	}

	/**
	 * Returns the rule local service.
	 *
	 * @return the rule local service
	 */
	public RuleLocalService getRuleLocalService() {
		return ruleLocalService;
	}

	/**
	 * Sets the rule local service.
	 *
	 * @param ruleLocalService the rule local service
	 */
	public void setRuleLocalService(RuleLocalService ruleLocalService) {
		this.ruleLocalService = ruleLocalService;
	}

	/**
	 * Returns the rule persistence.
	 *
	 * @return the rule persistence
	 */
	public RulePersistence getRulePersistence() {
		return rulePersistence;
	}

	/**
	 * Sets the rule persistence.
	 *
	 * @param rulePersistence the rule persistence
	 */
	public void setRulePersistence(RulePersistence rulePersistence) {
		this.rulePersistence = rulePersistence;
	}

	/**
	 * Returns the rule finder.
	 *
	 * @return the rule finder
	 */
	public RuleFinder getRuleFinder() {
		return ruleFinder;
	}

	/**
	 * Sets the rule finder.
	 *
	 * @param ruleFinder the rule finder
	 */
	public void setRuleFinder(RuleFinder ruleFinder) {
		this.ruleFinder = ruleFinder;
	}

	/**
	 * Returns the seller local service.
	 *
	 * @return the seller local service
	 */
	public SellerLocalService getSellerLocalService() {
		return sellerLocalService;
	}

	/**
	 * Sets the seller local service.
	 *
	 * @param sellerLocalService the seller local service
	 */
	public void setSellerLocalService(SellerLocalService sellerLocalService) {
		this.sellerLocalService = sellerLocalService;
	}

	/**
	 * Returns the seller remote service.
	 *
	 * @return the seller remote service
	 */
	public SellerService getSellerService() {
		return sellerService;
	}

	/**
	 * Sets the seller remote service.
	 *
	 * @param sellerService the seller remote service
	 */
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	/**
	 * Returns the seller persistence.
	 *
	 * @return the seller persistence
	 */
	public SellerPersistence getSellerPersistence() {
		return sellerPersistence;
	}

	/**
	 * Sets the seller persistence.
	 *
	 * @param sellerPersistence the seller persistence
	 */
	public void setSellerPersistence(SellerPersistence sellerPersistence) {
		this.sellerPersistence = sellerPersistence;
	}

	/**
	 * Returns the seller finder.
	 *
	 * @return the seller finder
	 */
	public SellerFinder getSellerFinder() {
		return sellerFinder;
	}

	/**
	 * Sets the seller finder.
	 *
	 * @param sellerFinder the seller finder
	 */
	public void setSellerFinder(SellerFinder sellerFinder) {
		this.sellerFinder = sellerFinder;
	}

	/**
	 * Returns the transaction local service.
	 *
	 * @return the transaction local service
	 */
	public TransactionLocalService getTransactionLocalService() {
		return transactionLocalService;
	}

	/**
	 * Sets the transaction local service.
	 *
	 * @param transactionLocalService the transaction local service
	 */
	public void setTransactionLocalService(
		TransactionLocalService transactionLocalService) {
		this.transactionLocalService = transactionLocalService;
	}

	/**
	 * Returns the transaction remote service.
	 *
	 * @return the transaction remote service
	 */
	public TransactionService getTransactionService() {
		return transactionService;
	}

	/**
	 * Sets the transaction remote service.
	 *
	 * @param transactionService the transaction remote service
	 */
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	/**
	 * Returns the transaction persistence.
	 *
	 * @return the transaction persistence
	 */
	public TransactionPersistence getTransactionPersistence() {
		return transactionPersistence;
	}

	/**
	 * Sets the transaction persistence.
	 *
	 * @param transactionPersistence the transaction persistence
	 */
	public void setTransactionPersistence(
		TransactionPersistence transactionPersistence) {
		this.transactionPersistence = transactionPersistence;
	}

	/**
	 * Returns the transaction finder.
	 *
	 * @return the transaction finder
	 */
	public TransactionFinder getTransactionFinder() {
		return transactionFinder;
	}

	/**
	 * Sets the transaction finder.
	 *
	 * @param transactionFinder the transaction finder
	 */
	public void setTransactionFinder(TransactionFinder transactionFinder) {
		this.transactionFinder = transactionFinder;
	}

	/**
	 * Returns the transaction log local service.
	 *
	 * @return the transaction log local service
	 */
	public TransactionLogLocalService getTransactionLogLocalService() {
		return transactionLogLocalService;
	}

	/**
	 * Sets the transaction log local service.
	 *
	 * @param transactionLogLocalService the transaction log local service
	 */
	public void setTransactionLogLocalService(
		TransactionLogLocalService transactionLogLocalService) {
		this.transactionLogLocalService = transactionLogLocalService;
	}

	/**
	 * Returns the transaction log persistence.
	 *
	 * @return the transaction log persistence
	 */
	public TransactionLogPersistence getTransactionLogPersistence() {
		return transactionLogPersistence;
	}

	/**
	 * Sets the transaction log persistence.
	 *
	 * @param transactionLogPersistence the transaction log persistence
	 */
	public void setTransactionLogPersistence(
		TransactionLogPersistence transactionLogPersistence) {
		this.transactionLogPersistence = transactionLogPersistence;
	}

	/**
	 * Returns the transaction parameter local service.
	 *
	 * @return the transaction parameter local service
	 */
	public TransactionParameterLocalService getTransactionParameterLocalService() {
		return transactionParameterLocalService;
	}

	/**
	 * Sets the transaction parameter local service.
	 *
	 * @param transactionParameterLocalService the transaction parameter local service
	 */
	public void setTransactionParameterLocalService(
		TransactionParameterLocalService transactionParameterLocalService) {
		this.transactionParameterLocalService = transactionParameterLocalService;
	}

	/**
	 * Returns the transaction parameter persistence.
	 *
	 * @return the transaction parameter persistence
	 */
	public TransactionParameterPersistence getTransactionParameterPersistence() {
		return transactionParameterPersistence;
	}

	/**
	 * Sets the transaction parameter persistence.
	 *
	 * @param transactionParameterPersistence the transaction parameter persistence
	 */
	public void setTransactionParameterPersistence(
		TransactionParameterPersistence transactionParameterPersistence) {
		this.transactionParameterPersistence = transactionParameterPersistence;
	}

	/**
	 * Returns the transaction parameter finder.
	 *
	 * @return the transaction parameter finder
	 */
	public TransactionParameterFinder getTransactionParameterFinder() {
		return transactionParameterFinder;
	}

	/**
	 * Sets the transaction parameter finder.
	 *
	 * @param transactionParameterFinder the transaction parameter finder
	 */
	public void setTransactionParameterFinder(
		TransactionParameterFinder transactionParameterFinder) {
		this.transactionParameterFinder = transactionParameterFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.beorn.onlinepayment.model.TransactionParameter",
			transactionParameterLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.beorn.onlinepayment.model.TransactionParameter");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return TransactionParameter.class;
	}

	protected String getModelClassName() {
		return TransactionParameter.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = transactionParameterPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = OrderTransactionLocalService.class)
	protected OrderTransactionLocalService orderTransactionLocalService;
	@BeanReference(type = OrderTransactionPersistence.class)
	protected OrderTransactionPersistence orderTransactionPersistence;
	@BeanReference(type = PaymentMethodLocalService.class)
	protected PaymentMethodLocalService paymentMethodLocalService;
	@BeanReference(type = PaymentMethodService.class)
	protected PaymentMethodService paymentMethodService;
	@BeanReference(type = PaymentMethodPersistence.class)
	protected PaymentMethodPersistence paymentMethodPersistence;
	@BeanReference(type = PaymentMethodFinder.class)
	protected PaymentMethodFinder paymentMethodFinder;
	@BeanReference(type = PaymentPluginLocalService.class)
	protected PaymentPluginLocalService paymentPluginLocalService;
	@BeanReference(type = PaymentPluginService.class)
	protected PaymentPluginService paymentPluginService;
	@BeanReference(type = PaymentPluginPersistence.class)
	protected PaymentPluginPersistence paymentPluginPersistence;
	@BeanReference(type = PaymentPluginFinder.class)
	protected PaymentPluginFinder paymentPluginFinder;
	@BeanReference(type = PaymentPluginConfigLocalService.class)
	protected PaymentPluginConfigLocalService paymentPluginConfigLocalService;
	@BeanReference(type = PaymentPluginConfigPersistence.class)
	protected PaymentPluginConfigPersistence paymentPluginConfigPersistence;
	@BeanReference(type = RuleLocalService.class)
	protected RuleLocalService ruleLocalService;
	@BeanReference(type = RulePersistence.class)
	protected RulePersistence rulePersistence;
	@BeanReference(type = RuleFinder.class)
	protected RuleFinder ruleFinder;
	@BeanReference(type = SellerLocalService.class)
	protected SellerLocalService sellerLocalService;
	@BeanReference(type = SellerService.class)
	protected SellerService sellerService;
	@BeanReference(type = SellerPersistence.class)
	protected SellerPersistence sellerPersistence;
	@BeanReference(type = SellerFinder.class)
	protected SellerFinder sellerFinder;
	@BeanReference(type = TransactionLocalService.class)
	protected TransactionLocalService transactionLocalService;
	@BeanReference(type = TransactionService.class)
	protected TransactionService transactionService;
	@BeanReference(type = TransactionPersistence.class)
	protected TransactionPersistence transactionPersistence;
	@BeanReference(type = TransactionFinder.class)
	protected TransactionFinder transactionFinder;
	@BeanReference(type = TransactionLogLocalService.class)
	protected TransactionLogLocalService transactionLogLocalService;
	@BeanReference(type = TransactionLogPersistence.class)
	protected TransactionLogPersistence transactionLogPersistence;
	@BeanReference(type = TransactionParameterLocalService.class)
	protected TransactionParameterLocalService transactionParameterLocalService;
	@BeanReference(type = TransactionParameterPersistence.class)
	protected TransactionParameterPersistence transactionParameterPersistence;
	@BeanReference(type = TransactionParameterFinder.class)
	protected TransactionParameterFinder transactionParameterFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private TransactionParameterLocalServiceClpInvoker _clpInvoker = new TransactionParameterLocalServiceClpInvoker();
}