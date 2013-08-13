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

package com.beorn.paymentapi.messaging.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Thrown when a plugin message context isn't ready
 * 
 * (most likely it cannot connect to the messaging system)
 * 
 * @author Sébastien Meunier
 */
public class MessagingContextUnavailableException extends PortalException {

	public MessagingContextUnavailableException() {
		super();
	}

	public MessagingContextUnavailableException(String msg) {
		super(msg);
	}

	public MessagingContextUnavailableException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MessagingContextUnavailableException(Throwable cause) {
		super(cause);
	}

}