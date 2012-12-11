package tomekkup.jug.jugcasa.cases;

import me.prettyprint.cassandra.serializers.LongSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.ColumnQuery;
import me.prettyprint.hector.api.query.MultigetSliceQuery;
import me.prettyprint.hector.api.query.RangeSlicesQuery;
import me.prettyprint.hector.api.query.RangeSuperSlicesQuery;
import me.prettyprint.hector.api.query.SliceQuery;

/**
 *
 * @author tomek
 */
public class RangeSlice extends AbstractCase {
   
    public static void main( String[] args )
    {
        new RangeSlice();
    }
    
    public RangeSlice() {
        super();
    }
    
    public RangeSlice(Keyspace keyspace) {
        super(keyspace);
    }
    
    @Override
    public Object getQueryResult() {
        RangeSlicesQuery<String,String,String> query = HFactory.createRangeSlicesQuery(keyspace, StringSerializer.get(), StringSerializer.get(), StringSerializer.get());
        query.setColumnFamily("Accounts");
        query.setKeys("PL88501065888793830797234174","PL51501065880320839427928716");
        query.setRowCount(3);
        query.setRange("a", "close_date", false, 10);
        return query.execute().get();
    }
}
