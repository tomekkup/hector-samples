package tomekkup.jug.jugcasa;

import tomekkup.jug.jugcasa.cases.DecrCounter;
import tomekkup.jug.jugcasa.cases.MultiGetSlice;
import tomekkup.jug.jugcasa.cases.RangeSlice;
import tomekkup.jug.jugcasa.cases.Delete;
import tomekkup.jug.jugcasa.cases.GetSuperColumn;
import tomekkup.jug.jugcasa.cases.GetSuperSlice;
import tomekkup.jug.jugcasa.cases.GetSlice;
import tomekkup.jug.jugcasa.cases.GetCounter;
import tomekkup.jug.jugcasa.cases.IncrCounter;
import tomekkup.jug.jugcasa.cases.Insert;
import tomekkup.jug.jugcasa.cases.GetColumn;
import tomekkup.jug.jugcasa.cases.GetIndexed;
import static tomekkup.jug.jugcasa.Defaults.*;
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
