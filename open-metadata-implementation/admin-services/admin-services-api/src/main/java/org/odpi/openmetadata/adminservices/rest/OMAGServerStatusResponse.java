/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adminservices.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.adminservices.properties.ServerStatus;

import java.util.Arrays;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * ServerListResponse returns the list of servers running in a platform.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class OMAGServerStatusResponse extends AdminServicesAPIResponse
{
    private static final long    serialVersionUID = 1L;

    private ServerStatus serverStatus = null;


    /**
     * Default constructor
     */
    public OMAGServerStatusResponse()
    {
        super();
    }


    /**
     * Copy/clone constructor
     *
     * @param template object to copy
     */
    public OMAGServerStatusResponse(OMAGServerStatusResponse template)
    {
        super(template);

        if (template != null)
        {
            serverStatus = template.getServerStatus();
        }
    }


    /**
     * Return the server status structure.
     *
     * @return server status
     */
    public ServerStatus getServerStatus()
    {
        return serverStatus;
    }


    /**
     * Set up the server status structure.
     *
     * @param serverStatus server status
     */
    public void setServerStatus(ServerStatus serverStatus)
    {
        this.serverStatus = serverStatus;
    }


    /**
     * JSON-like toString
     *
     * @return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "OMAGServerStatusResponse{" +
                       "serverStatus=" + serverStatus +
                       ", exceptionClassName='" + getExceptionClassName() + '\'' +
                       ", exceptionCausedBy='" + getExceptionCausedBy() + '\'' +
                       ", actionDescription='" + getActionDescription() + '\'' +
                       ", relatedHTTPCode=" + getRelatedHTTPCode() +
                       ", exceptionErrorMessage='" + getExceptionErrorMessage() + '\'' +
                       ", exceptionErrorMessageId='" + getExceptionErrorMessageId() + '\'' +
                       ", exceptionErrorMessageParameters=" + Arrays.toString(getExceptionErrorMessageParameters()) +
                       ", exceptionSystemAction='" + getExceptionSystemAction() + '\'' +
                       ", exceptionUserAction='" + getExceptionUserAction() + '\'' +
                       ", exceptionProperties=" + getExceptionProperties() +
                       '}';
    }


    /**
     * Return comparison result based on the content of the properties.
     *
     * @param objectToCompare test object
     * @return result of comparison
     */
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
        {
            return true;
        }
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
        {
            return false;
        }
        if (! super.equals(objectToCompare))
        {
            return false;
        }
        OMAGServerStatusResponse that = (OMAGServerStatusResponse) objectToCompare;
        return Objects.equals(serverStatus, that.serverStatus);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), serverStatus);
    }
}
