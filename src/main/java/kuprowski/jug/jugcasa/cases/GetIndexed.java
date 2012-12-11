package kuprowski.jug.jugcasa.cases;

import me.prettyprint.cassandra.model.IndexedSlicesQuery;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.MultigetSliceQuery;
import me.prettyprint.hector.api.query.RangeSlicesQuery;

/**
 *
 * @author tomek
 */
public class GetIndexed extends AbstractCase {
   
    public static void main( String[] args )
    {
        new GetIndexed();
    }
    
    public GetIndexed() {
        super();
    }
    
    public GetIndexed(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public Object getQueryResult() {
        RangeSlicesQuery<String,String,String> query = HFactory.createRangeSlicesQuery(keyspace, StringSerializer.get(), StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("Accounts");
        query.setColumnNames("account_number", "limit_ccy","closing_date");
        query.setKeys("PL88501065888793830797234174", null);
        query.setRowCount(20);
        
        query.addEqualsExpression("limit_ccy", "PLN");
        
        return query.execute().get();
    }
}
