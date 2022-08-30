package com.google.android.exoplayer2.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class ConditionVariable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isOpen;

    public ConditionVariable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public synchronized void block() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                while (!this.isOpen) {
                    wait();
                }
            }
        }
    }

    public synchronized boolean close() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = this.isOpen;
                this.isOpen = false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean open() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.isOpen) {
                    return false;
                }
                this.isOpen = true;
                notifyAll();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean block(long j) throws InterruptedException {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = j + currentTimeMillis;
                while (!this.isOpen && currentTimeMillis < j2) {
                    wait(j2 - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
                z = this.isOpen;
            }
            return z;
        }
        return invokeJ.booleanValue;
    }
}
