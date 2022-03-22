package org.aspectj.runtime.internal.cflowstack;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
/* loaded from: classes8.dex */
public class ThreadCounterImpl11 implements ThreadCounter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLLECT_AT = 20000;
    public static final int MIN_COLLECT_AT = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public Counter cached_counter;
    public Thread cached_thread;
    public int change_count;
    public Hashtable counters;

    /* loaded from: classes8.dex */
    public static class Counter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        public Counter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = 0;
        }
    }

    public ThreadCounterImpl11() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.counters = new Hashtable();
        this.change_count = 0;
    }

    private synchronized Counter getThreadCounter() {
        InterceptResult invokeV;
        Counter counter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            synchronized (this) {
                if (Thread.currentThread() != this.cached_thread) {
                    Thread currentThread = Thread.currentThread();
                    this.cached_thread = currentThread;
                    Counter counter2 = (Counter) this.counters.get(currentThread);
                    this.cached_counter = counter2;
                    if (counter2 == null) {
                        Counter counter3 = new Counter();
                        this.cached_counter = counter3;
                        this.counters.put(this.cached_thread, counter3);
                    }
                    this.change_count++;
                    if (this.change_count > Math.max(100, 20000 / Math.max(1, this.counters.size()))) {
                        ArrayList<Thread> arrayList = new ArrayList();
                        Enumeration keys = this.counters.keys();
                        while (keys.hasMoreElements()) {
                            Thread thread = (Thread) keys.nextElement();
                            if (!thread.isAlive()) {
                                arrayList.add(thread);
                            }
                        }
                        for (Thread thread2 : arrayList) {
                            this.counters.remove(thread2);
                        }
                        this.change_count = 0;
                    }
                }
                counter = this.cached_counter;
            }
            return counter;
        }
        return (Counter) invokeV.objValue;
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public void dec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Counter threadCounter = getThreadCounter();
            threadCounter.value--;
        }
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public void inc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getThreadCounter().value++;
        }
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public boolean isNotZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getThreadCounter().value != 0 : invokeV.booleanValue;
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadCounter
    public void removeThreadCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
