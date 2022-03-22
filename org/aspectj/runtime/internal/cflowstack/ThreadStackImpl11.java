package org.aspectj.runtime.internal.cflowstack;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
/* loaded from: classes8.dex */
public class ThreadStackImpl11 implements ThreadStack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLLECT_AT = 20000;
    public static final int MIN_COLLECT_AT = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public Stack cached_stack;
    public Thread cached_thread;
    public int change_count;
    public Hashtable stacks;

    public ThreadStackImpl11() {
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
        this.stacks = new Hashtable();
        this.change_count = 0;
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
    public synchronized Stack getThreadStack() {
        InterceptResult invokeV;
        Stack stack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (Thread.currentThread() != this.cached_thread) {
                    Thread currentThread = Thread.currentThread();
                    this.cached_thread = currentThread;
                    Stack stack2 = (Stack) this.stacks.get(currentThread);
                    this.cached_stack = stack2;
                    if (stack2 == null) {
                        Stack stack3 = new Stack();
                        this.cached_stack = stack3;
                        this.stacks.put(this.cached_thread, stack3);
                    }
                    this.change_count++;
                    if (this.change_count > Math.max(100, 20000 / Math.max(1, this.stacks.size()))) {
                        Stack stack4 = new Stack();
                        Enumeration keys = this.stacks.keys();
                        while (keys.hasMoreElements()) {
                            Thread thread = (Thread) keys.nextElement();
                            if (!thread.isAlive()) {
                                stack4.push(thread);
                            }
                        }
                        Enumeration elements = stack4.elements();
                        while (elements.hasMoreElements()) {
                            this.stacks.remove((Thread) elements.nextElement());
                        }
                        this.change_count = 0;
                    }
                }
                stack = this.cached_stack;
            }
            return stack;
        }
        return (Stack) invokeV.objValue;
    }

    @Override // org.aspectj.runtime.internal.cflowstack.ThreadStack
    public void removeThreadStack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }
}
