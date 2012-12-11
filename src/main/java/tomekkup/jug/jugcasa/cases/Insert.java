package tomekkup.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;

/**
 *
 * @author tomek
 */
public class Insert extends AbstractCase {
   
    public static void main( String[] args )
    {
        new Insert();
    }
    
    public Insert() {
        super();
    }
    
    public Insert(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public String getQueryResult() {
        Mutator<String> mutator = HFactory.createMutator(keyspace, StringSerializer.get());
        
        String key = "999123123";
        String cf = "Customers";
        mutator.addInsertion(key, cf, HFactory.createColumn("firstname", "jug"));
        mutator.addInsertion(key, cf, HFactory.createColumn("lastname", "jug2"));
        mutator.execute();
        return null;
    }
}
