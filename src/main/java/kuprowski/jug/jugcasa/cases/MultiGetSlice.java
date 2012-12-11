package kuprowski.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.MultigetSliceQuery;

/**
 *
 * @author tomek
 */
public class MultiGetSlice extends AbstractCase {
   
    public static void main( String[] args )
    {
        new MultiGetSlice();
    }
    
    public MultiGetSlice() {
        super();
    }
    
    public MultiGetSlice(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public Object getQueryResult() {
        MultigetSliceQuery<String,String,String> query = HFactory.createMultigetSliceQuery(keyspace, StringSerializer.get(), StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("Customers");
        query.setKeys("000228408","000248142","000102014");
        query.setColumnNames("checker","maker");
        
        return query.execute().get();
    }
}
