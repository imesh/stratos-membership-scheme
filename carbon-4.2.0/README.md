## Private PaaS Membership Scheme

### Axis2.xml Configuration

```
<clustering class="org.wso2.carbon.core.clustering.hazelcast.HazelcastClusteringAgent"
                enable="true">

    <parameter name="membershipScheme">private-paas</parameter>
    <parameter name="membershipSchemeClassName">org.wso2.carbon.ppaas.PrivatePaaSBasedMembershipScheme</parameter>
    <parameter name="clusterIds">cluster-1,cluster-2</parameter>  
</clustering>
```
