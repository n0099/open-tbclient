package com.kwad.v8;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class V8Locker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean released;
    public V8 runtime;
    public Thread thread;

    public V8Locker(V8 v8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.thread = null;
        this.released = false;
        this.runtime = v8;
        acquire();
    }

    public synchronized void acquire() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.thread != null && this.thread != Thread.currentThread()) {
                    throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
                }
                if (this.thread == Thread.currentThread()) {
                    return;
                }
                this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
                this.thread = Thread.currentThread();
                this.released = false;
            }
        }
    }

    public void checkThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.released && this.thread == null) {
                throw new Error("Invalid V8 thread access: the locker has been released!");
            }
            if (this.thread == Thread.currentThread()) {
                return;
            }
            throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
        }
    }

    public Thread getThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.thread : (Thread) invokeV.objValue;
    }

    public boolean hasLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.thread == Thread.currentThread() : invokeV.booleanValue;
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if ((this.released && this.thread == null) || this.runtime.isReleased()) {
                    return;
                }
                checkThread();
                this.runtime.releaseLock(this.runtime.getV8RuntimePtr());
                this.thread = null;
                this.released = true;
            }
        }
    }

    public synchronized boolean tryAcquire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (this.thread == null || this.thread == Thread.currentThread()) {
                    if (this.thread == Thread.currentThread()) {
                        return true;
                    }
                    this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
                    this.thread = Thread.currentThread();
                    this.released = false;
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
