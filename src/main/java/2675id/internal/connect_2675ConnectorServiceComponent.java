/*
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package 2675id.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import 2675id.connect_2675ProvisioningConnectorFactory;

/**
 * @scr.component name=
 * "2675id.internal.connect_2675ConnectorServiceComponent"
 * immediate="true"
 */
public class connect_2675ConnectorServiceComponent {

    private static Log log = LogFactory.getLog(connect_2675ConnectorServiceComponent.class);

    protected void activate(ComponentContext context) {
        if (log.isDebugEnabled()) {
            log.debug("Activating connect_2675ConnectorServiceComponent");
        }
        try {
            connect_2675ProvisioningConnectorFactory provisioningConnectorFactory = new connect_2675ProvisioningConnectorFactory();
            context.getBundleContext().registerService(
                    AbstractProvisioningConnectorFactory.class.getName(),
                        provisioningConnectorFactory, null);
            if (log.isDebugEnabled()) {
                log.debug("connect_2675 Identity Provisioning Connector bundle is activated");
            }
        } catch (Throwable e) {
            log.fatal(" Error while activating connect_2675 Identity Provisioning Connector ", e);
        }
    }
}
