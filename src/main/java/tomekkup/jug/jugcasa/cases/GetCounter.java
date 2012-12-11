package tomekkup.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.CounterQuery;

/**
 *
 * @author tomek
 */
public class GetCounter extends AbstractCase {

    public static void main(String[] args) {
        new GetCounter();
    }

    public GetCounter() {
        super();
    }

    public GetCounter(Keyspace keyspace) {
        super(keyspace);
    }

    @Override
    public String getQueryResult() {
        CounterQuery<String, String> query = HFactory.createCounterColumnQuery(keyspace, StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("Countery").setKey("jug").setName("foo");

        return query.execute().get().toString();
    }
}
