import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JavaReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

	private IntWritable result = new IntWritable();

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		Iterator<IntWritable> iter = values.iterator();

		int sum = 0;
		while (iter.hasNext()) {
			sum += iter.next().get();
		}

		result.set(sum);
		context.write(key, result);

	}

}
