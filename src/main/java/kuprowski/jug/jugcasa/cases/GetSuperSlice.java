package kuprowski.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.LongSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.SuperSliceQuery;

/**
 *
 * @author tomek
 */
public class GetSuperSlice extends AbstractCase {
   
    public static void main( String[] args )
    {
        new GetSuperSlice();
    }
    
    public GetSuperSlice() {
        super();
    }
    
    public GetSuperSlice(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public Object getQueryResult() {
        SuperSliceQuery<String,Long,String,String> query = HFactory.createSuperSliceQuery(keyspace, StringSerializer.get(), LongSerializer.get(), StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("AccountsHistory");
        query.setKey("PL68501065882571718283936285");
        query.setRange(61095850541000L, 61093919715000L, true, 10);
        
        return query.execute().get();
    }
}
