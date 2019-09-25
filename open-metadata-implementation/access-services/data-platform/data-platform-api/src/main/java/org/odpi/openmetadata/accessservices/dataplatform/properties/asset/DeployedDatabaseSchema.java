/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.dataplatform.properties.asset;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.accessservices.dataplatform.properties.DatabaseSource;
import org.odpi.openmetadata.accessservices.dataplatform.properties.Source;
import org.odpi.openmetadata.accessservices.dataplatform.properties.schema.TabularSchema;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * The type DeployedDatabaseSchema is an asset in Apache Cassandra Database.
 */
@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeployedDatabaseSchema extends Source {

    private String name;
    private String displayName;
    private List<TabularSchema> tabularSchemaList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<TabularSchema> getTabularSchemaList() {
        return tabularSchemaList;
    }

    public void setTabularSchemaList(List<TabularSchema> tabularSchemaList) {
        this.tabularSchemaList = tabularSchemaList;
    }

    @Override
    public String toString() {
        return "DeployedDatabaseSchema{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", tabularSchemaList=" + tabularSchemaList +
                ", additionalProperties=" + additionalProperties +
                ", qualifiedName='" + qualifiedName + '\'' +
                ", guid='" + guid + '\'' +
                "} " + super.toString();
    }
}