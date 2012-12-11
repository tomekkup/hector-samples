package tomekkup.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.ColumnQuery;

/**
 *
 * @author tomek
 */
public class GetColumn extends AbstractCase {
   
    public static void main( String[] args )
    {
        new GetColumn();
    }
    
    public GetColumn() {
        super();
    }
    
    public GetColumn(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public Object getQueryResult() {
        ColumnQuery<String,String,String> query = HFactory.createColumnQuery(keyspace, StringSerializer.get(), StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("Accounts").setKey("PL14501065882796893457692938").setName("branch");
        
        return query.execute().get();
    }
}
