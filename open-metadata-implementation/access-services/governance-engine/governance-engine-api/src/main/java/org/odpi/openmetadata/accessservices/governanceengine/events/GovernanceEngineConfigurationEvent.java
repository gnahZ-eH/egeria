/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.accessservices.governanceengine.events;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * GovernanceEngineConfigurationEvent is used to inform the governance server that the configuration of
 * one of its governance engines has changed.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GovernanceServiceConfigurationEvent.class, name = "GovernanceServiceConfigurationEvent")
})
public class GovernanceEngineConfigurationEvent extends GovernanceEngineEvent
{
    private static final long serialVersionUID = 1L;

    private String governanceEngineGUID = null;
    private String governanceEngineName = null;

    /**
     * Default constructor
     */
    public GovernanceEngineConfigurationEvent()
    {
        super();
    }


    /**
     * Copy/clone constructor.
     *
     * @param template object to copy
     */
    public GovernanceEngineConfigurationEvent(GovernanceEngineConfigurationEvent template)
    {
        super(template);

        if (template != null)
        {
            governanceEngineGUID = template.getGovernanceEngineGUID();
            governanceEngineName = template.getGovernanceEngineName();
        }
    }


    /**
     * Return the unique identifier of the governance engine that has a configuration change.
     *
     * @return string guid
     */
    public String getGovernanceEngineGUID()
    {
        return governanceEngineGUID;
    }


    /**
     * Set up the unique identifier of the governance engine that has a configuration change.
     *
     * @param governanceEngineGUID string guid
     */
    public void setGovernanceEngineGUID(String governanceEngineGUID)
    {
        this.governanceEngineGUID = governanceEngineGUID;
    }


    /**
     * Return the unique name of the governance engine that has a configuration change.
     *
     * @return string name
     */
    public String getGovernanceEngineName()
    {
        return governanceEngineName;
    }


    /**
     * Set up the unique name of the governance engine that has a configuration change.
     *
     * @param governanceEngineName string name
     */
    public void setGovernanceEngineName(String governanceEngineName)
    {
        this.governanceEngineName = governanceEngineName;
    }


    /**
     * JSON-style toString
     *
     * @return return string containing the property names and values
     */
    @Override
    public String toString()
    {
        return "GovernanceEngineConfigurationEvent{" +
                "governanceEngineGUID='" + governanceEngineGUID + '\'' +
                ", governanceEngineName='" + governanceEngineName + '\'' +
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
        if (!super.equals(objectToCompare))
        {
            return false;
        }
        GovernanceEngineConfigurationEvent that = (GovernanceEngineConfigurationEvent) objectToCompare;
        return Objects.equals(governanceEngineGUID, that.governanceEngineGUID) &&
                Objects.equals(governanceEngineName, that.governanceEngineName);
    }


    /**
     * Return hash code for this object
     *
     * @return int hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), governanceEngineGUID, governanceEngineName);
    }
}
