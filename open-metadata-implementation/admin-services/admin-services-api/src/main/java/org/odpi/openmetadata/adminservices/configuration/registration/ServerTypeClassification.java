/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.adminservices.configuration.registration;

/**
 * ServerTypeClassification manages a list of different server types.
 */
public enum ServerTypeClassification
{
    OMAG_SERVER("Open Metadata and Governance (OMAG) Server",
                "Generic name for a server that runs on the OMAG Platform",
                null,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/omag-server.html"),
    COHORT_MEMBER("Cohort Member",
                "OMAG Server that is capable of joining one or more open metadata repository cohorts.",
                 ServerTypeClassification.OMAG_SERVER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/cohort-member.html"),
    METADATA_ACCESS_POINT("Metadata Access Point",
                "Server that provides specialist APIs for accessing and storing metadata in" +
                            "open metadata repositories connected through one or more open metadata repository cohorts.",
                 ServerTypeClassification.COHORT_MEMBER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/metadata-access-point.html"),
    METADATA_SERVER("Metadata Server",
                "Server that is a metadata access point with its own native open metadata repository.",
                 ServerTypeClassification.METADATA_ACCESS_POINT,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/metadata-server.html"),
    REPOSITORY_PROXY("Repository Proxy",
                "Hosting environment for a repository connector acting as an adapter to a third party metadata server",
                 ServerTypeClassification.COHORT_MEMBER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/repository-proxy.html"),
    CONFORMANCE_SERVER("Conformance Test Server",
                "Server that hosts the conformance test suite",
                 ServerTypeClassification.COHORT_MEMBER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/conformance-test-server.html"),
    GOVERNANCE_SERVER("Governance Server",
                "Server that hosts integration, management or governance function",
                 ServerTypeClassification.OMAG_SERVER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/governance-server-types.html"),
    INTEGRATION_DAEMON("Integration Daemon",
                "Governance server that hosts connectors that are exchanging metadata with third party technology.  " +
                               "These servers typically do not have their own API which is why they are called daemons",
                 ServerTypeClassification.GOVERNANCE_SERVER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/integration-daemon.html"),
    ENGINE_HOST("Engine Host Server",
                "Governance server that hosts the Open Metadata Engine Services (OMES) that is managing workloads for an aspect of governance",
                 ServerTypeClassification.GOVERNANCE_SERVER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/engine-host.html"),
    OPEN_LINEAGE_SERVER("Open Lineage Server",
                "Server that manages a warehouse of lineage information",
                 ServerTypeClassification.GOVERNANCE_SERVER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/open-lineage-server.html"),
    DATA_ENGINE_PROXY("Data Engine Proxy",
                "Server that manages the extraction of metadata from a single data engine",
                 ServerTypeClassification.GOVERNANCE_SERVER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/data-engine-proxy.html"),
    VIEW_SERVER("View Server",
                "A View Server is an OMAG Server that hosts the view services to support a User Interface.",
                ServerTypeClassification.OMAG_SERVER,
                "https://egeria.odpi.org/open-metadata-implementation/admin-services/docs/concepts/view-server.html"),
    ;

    private String                   serverTypeName;
    private String                   serverTypeDescription;
    private ServerTypeClassification superType;
    private String                   serverTypeWiki;



    ServerTypeClassification(String                     serverTypeName,
                             String                     serverTypeDescription,
                             ServerTypeClassification   superType,
                             String                     serverTypeWiki)
    {
        this.serverTypeName        = serverTypeName;
        this.serverTypeDescription = serverTypeDescription;
        this.superType             = superType;
        this.serverTypeWiki        = serverTypeWiki;
    }


    /**
     * Returns the unique identifier for the error message.
     *
     * @return logMessageId
     */
    public String getServerTypeName()
    {
        return serverTypeName;
    }


    /**
     * Returns description of server type
     *
     * @return userAction String
     */
    public String getServerTypeDescription()
    {
        return serverTypeDescription;
    }


    /**
     * Returns super type of server - null for top level.
     *
     * @return systemAction String
     */
    public ServerTypeClassification getSuperType()
    {
        return superType;
    }


    /**
     * Return the link to the page on the Egeria website that describes this server.
     *
     * @return url
     */
    public String getServerTypeWiki()
    {
        return serverTypeWiki;
    }
}
