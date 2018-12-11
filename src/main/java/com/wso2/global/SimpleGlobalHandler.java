package com.wso2.global;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.AbstractSynapseHandler;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.axis2.Axis2MessageContext;

public class SimpleGlobalHandler extends AbstractSynapseHandler {

    private static final Log log = LogFactory.getLog(SimpleGlobalHandler.class);

    public boolean handleRequestInFlow(MessageContext messageContext) {
        // Can log/get/publish/etc details at request in flow (when the request is made on Gateway)
        return true;
    }

    public boolean handleRequestOutFlow(MessageContext messageContext) {
        // Can log/get/publish/etc details at request out flow (when the request is going out of Gateway, to the backend)
        return true;
    }

    public boolean handleResponseInFlow(MessageContext messageContext) {
        // Can log/get/publish/etc details at request in flow (when the request is made on Gateway)
        return true;
    }

    public boolean handleResponseOutFlow(MessageContext messageContext) {
        org.apache.axis2.context.MessageContext axis2MC = ((Axis2MessageContext) messageContext).
                getAxis2MessageContext();
        Integer httpStatusCode = (Integer) axis2MC.getProperty("HTTP_SC");
        log.info("HTTP Status Code : " + httpStatusCode);
        return true;
    }
}
