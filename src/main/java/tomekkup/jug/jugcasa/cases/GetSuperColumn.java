package tomekkup.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.LongSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.SuperColumnQuery;

/**
 *
 * @author tomek
 */
public class GetSuperColumn extends AbstractCase {
    
    public static void main( String[] args )
    {
        new GetSuperColumn();
    }
    
    public GetSuperColumn() {
        super();
    }
    
    public GetSuperColumn(Keyspace keyspace) {
        super(keyspace);
    }

    @Override
    public Object getQueryResult() {
        SuperColumnQuery<String,Long,String,String> query = HFactory.createSuperColumnQuery(keyspace, StringSerializer.get(), LongSerializer.get(), StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("AccountsHistory").setKey("PL14501065882796893457692938").setSuperName(55303754753000L);
        
        return query.execute().get();
    }
}
