package tomekkup.jug.jugcasa.cases;

import static tomekkup.jug.jugcasa.Defaults.*;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tomek
 */
public abstract class AbstractCase {

    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    protected Keyspace keyspace;
    private Cluster cluster;

    public AbstractCase() {
        super();
        this.cluster = HFactory.getOrCreateCluster(clusterName, cassandraHost);
        this.keyspace = HFactory.createKeyspace(keyspaceName, cluster);
        
        Object obj = getQueryResult();

        logger.info(obj == null ? "value not returned" : obj.toString());
    }

    public AbstractCase(Keyspace keyspace) {
        this.keyspace = keyspace;
        Object obj = getQueryResult();

        logger.info(obj == null ? "value not returned" : obj.toString());
    }

    public abstract Object getQueryResult();
}
