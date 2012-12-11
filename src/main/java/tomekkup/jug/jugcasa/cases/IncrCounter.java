package tomekkup.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;

/**
 *
 * @author tomek
 */
public class IncrCounter extends AbstractCase {

    public static void main(String[] args) {
        new IncrCounter();
    }

    public IncrCounter() {
        super();
    }

    public IncrCounter(Keyspace keyspace) {
        super(keyspace);
    }

    @Override
    public String getQueryResult() {
        Mutator<String> mutator = HFactory.createMutator(keyspace, StringSerializer.get());
        mutator.incrementCounter("jug", "Countery", "foo", 1L);

        return null;
    }
}
