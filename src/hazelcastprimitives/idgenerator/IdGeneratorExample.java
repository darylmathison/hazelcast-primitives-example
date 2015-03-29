/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hazelcastprimitives.idgenerator;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

/**
 *
 * @author Daryl
 */
public class IdGeneratorExample {
 
    public static void main(String[] args) {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        IdGenerator generator = instance.getIdGenerator("generator");
        
        for(int i = 0; i < 10; i++) {
            System.out.println("The generated value is " + generator.newId());
        }
        
        instance.shutdown();
        System.exit(0);
    }
}
