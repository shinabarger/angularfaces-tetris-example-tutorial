/**
 *  (C) 2013-2015 Stephan Rauh http://www.beyondjava.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.beyondjava.angularFaces.core.transformation;

import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextFactory;

/** Helper class */
public class AngularViewContextWrapperFactory extends PartialViewContextFactory {
	private static final Logger LOGGER = Logger.getLogger("de.beyondjava.angularFaces.core.transformation.AngularViewContextWrapperFactory");
	private PartialViewContextFactory wrappedPartialViewContextFactory;

	public AngularViewContextWrapperFactory(PartialViewContextFactory partialViewContextFactory) {
		this.wrappedPartialViewContextFactory = partialViewContextFactory;
		LOGGER.info("Running on AngularFaces 2.1.9");
	}

	@Override
	public PartialViewContext getPartialViewContext(FacesContext context) {
		return new AngularViewContextWrapper(wrappedPartialViewContextFactory.getPartialViewContext(context));
	}
}
