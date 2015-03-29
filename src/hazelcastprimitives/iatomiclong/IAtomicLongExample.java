/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hazelcastprimitives.iatomiclong;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IFunction;
import java.io.Serializable;

/**
 *
 * @author Daryl
 */
public class IAtomicLongExample {
    public static class MultiplyByTwoAndSubtractOne 
        implements IFunction<Long, Long>, Serializable {

        @Override
        public Long apply(Long t) {
            return (long)(2 * t - 1);
        }
        
    }
    
    public static final void main(String[] args) {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        final String NAME = "atomic";
        IAtomicLong aLong = instance.getAtomicLong(NAME);
        IAtomicLong bLong = instance.getAtomicLong(NAME);
        aLong.getAndSet(1L);
        System.out.println("bLong is now: " + bLong.getAndAdd(2));
        System.out.println("aLong is now: " + aLong.getAndAdd(0L));
        
        MultiplyByTwoAndSubtractOne alter = new MultiplyByTwoAndSubtractOne();
        aLong.alter(alter);
        System.out.println("bLong is now: " + bLong.getAndAdd(0L));
        bLong.alter(alter);
        System.out.println("aLong is now: " + aLong.getAndAdd(0L));
        
        System.exit(0);
    }
}
