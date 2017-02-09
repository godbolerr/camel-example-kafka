/**
 * 
 */
package org.apache.camel.example.kafka;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class StringPartitioner implements Partitioner {

	/**
	 * 
	 */
	public StringPartitioner() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.common.Configurable#configure(java.util.Map)
	 */
	@Override
	public void configure(Map<String, ?> configs) {}
	/* (non-Javadoc)
	 * @see org.apache.kafka.clients.producer.Partitioner#partition(java.lang.String, java.lang.Object, byte[], java.lang.Object, byte[], org.apache.kafka.common.Cluster)
	 */
	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		
		int partId = 0;
		
		if ( key != null && key instanceof String){
			
			String sKey = (String)key;
			
			int len = sKey.length();
			
			// This will return either 1 or zero
			
			partId = len % 2 ; 
			
		}
		
		
		return partId;
	}

	/* (non-Javadoc)
	 * @see org.apache.kafka.clients.producer.Partitioner#close()
	 */
	@Override
	public void close() {}

}
