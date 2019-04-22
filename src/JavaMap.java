import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class JavaMap extends Mapper<LongWritable, Text, Text, IntWritable> {

	private IntWritable one = new IntWritable(1);
	private Text word = new Text();

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		StringTokenizer st = new StringTokenizer(value.toString(), " ");

		while (st.hasMoreElements()) {
			word.set(st.nextToken());
			context.write(word, one);
		}

	}

}
