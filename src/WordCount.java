import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Job job = new Job();
		job.setJarByClass(WordCount.class);
		job.setMapperClass(JavaMap.class);
		job.setReducerClass(JavaReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path("/home/deniz/Desktop/metin"));
		FileOutputFormat.setOutputPath(job, new Path("/home/deniz/Desktop/out"));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
