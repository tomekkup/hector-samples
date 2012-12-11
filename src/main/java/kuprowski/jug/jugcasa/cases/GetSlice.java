package kuprowski.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.ColumnQuery;
import me.prettyprint.hector.api.query.SliceQuery;

/**
 *
 * @author tomek
 */
public class GetSlice extends AbstractCase {
   
    public static void main( String[] args )
    {
        new GetSlice();
    }
    
    public GetSlice() {
        super();
    }
    
    public GetSlice(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public Object getQueryResult() {
        SliceQuery<String,String,String> query = HFactory.createSliceQuery(keyspace, StringSerializer.get(), StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("CustomerAccounts").setKey("000130101").setRange(null, null, true, 4);
        
        return query.execute().get();
    }
}
