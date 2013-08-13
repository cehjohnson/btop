/**
 * Copyright (c) 2007-2013 BEORN Technologies, SARL. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.beorn.onlinepayment.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.beorn.onlinepayment.messaging.MessageBroker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Sébastien Meunier
 */
public class PaymentContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();

		try {
			_broker = new MessageBroker();
			_broker.start();

			PaymentSystemMessagingContext.startInstance(servletContext);

		} catch (Exception e) {
			_log.error("start", e);
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		try {
			PaymentSystemMessagingContext.stopInstance();

			_broker.stop();
			_broker = null;

		} catch (Exception e) {
			_log.error("stop", e);
		}
	}

	private MessageBroker _broker;

	private static Log _log = LogFactoryUtil
			.getLog(PaymentContextListener.class);
}
