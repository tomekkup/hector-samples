package tomekkup.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;

/**
 *
 * @author tomek
 */
public class Delete extends AbstractCase {
   
    public static void main( String[] args )
    {
        new Delete();
    }
    
    public Delete() {
        super();
    }
    
    public Delete(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public String getQueryResult() {
        Mutator<String> mutator = HFactory.createMutator(keyspace, StringSerializer.get());
        mutator.delete("999123123", "Customers", null, StringSerializer.get());
        
        return null;
    }
}
