package kuprowski.jug.jugcasa;

import static kuprowski.jug.jugcasa.Defaults.*;
import kuprowski.jug.jugcasa.cases.*;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;

public class App {

    public static void main(String[] args) {
        Cluster cluster = HFactory.getOrCreateCluster(clusterName, cassandraHost);
        Keyspace keyspace = HFactory.createKeyspace(keyspaceName, cluster);

        new Insert(keyspace);
        new GetColumn(keyspace);
        new Delete(keyspace);
        new GetSuperColumn(keyspace);
        new GetCounter(keyspace);
        new IncrCounter(keyspace);
        new GetCounter(keyspace);
        new DecrCounter(keyspace);
        new GetCounter(keyspace);
        new GetSlice(keyspace);
        new GetSuperSlice(keyspace);
        new MultiGetSlice(keyspace);
        new RangeSlice(keyspace);
        new GetIndexed(keyspace);
    }
}
