# Stratos Membership Scheme 
### Apache Stratos Membership Scheme for WSO2 Carbon Clustering

This repository includes an update for the WSO2 Carbon Kernel including a Hazelcast cluster discovery feature based on Stratos messaging model. This update can be applied on existing Carbon servers for automating cluster configuration.

## How it works
- Introduces a new membership scheme: StratosMembershipScheme
- At the server startup, the above membership scheme will wait until the topology is initialized via the message broker
- Once topology is initialized the list of members found in the given clusters will be added to the Hazelcast cluster configuration

## How to apply

- Copy the files found under carbon-[version]/patch folder to the carbon server:

```
└── repository
    ├── components
    │   ├── dropins
    │   │   ├── org.apache.stratos.common_4.1.0.jar
    │   │   └── org.apache.stratos.messaging_4.1.0.jar
    │   ├── lib
    │   │   ├── activemq-client-5.10.0.jar
    │   │   └── geronimo-j2ee-management_1.1_spec-1.0.1.jar
    │   └── patches
    │       └── patch9999
    │           └── org.wso2.carbon.core-4.4.0.jar
    └── conf
        └── jndi.properties
```

- Update the repository/conf/axis2/axis2.xml as follows:

```
    <clustering class="org.wso2.carbon.core.clustering.hazelcast.HazelcastClusteringAgent"
                enable="true">
				...
		        <parameter name="membershipScheme">stratos</parameter>
		        <parameter name="clusterIds">cluster-1,cluster-2</parameter>
				...
	</clustering>
```