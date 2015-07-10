# Stratos Membership Scheme 
### Apache Stratos Membership Scheme for WSO2 Carbon Kernel

This repository includes an update for the WSO2 Carbon Kernel including a Hazelcast cluster discovery feature based on Apache Stratos messaging model. This update can be applied on existing Carbon servers for automating cluster configuration.

## How it works
- Introduces a new membership scheme: StratosMembershipScheme
- At the server startup, the above membership scheme will wait until the topology is initialized via the message broker
- Once topology is initialized the list of members found in the given clusters will be added to the Hazelcast cluster configuration 
- 
