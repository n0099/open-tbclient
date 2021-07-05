package com.yy.hiidostatis.inner.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class SharedTimerTask implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CANCELLED = 3;
    public static final int EXECUTED = 2;
    public static final int SCHEDULED = 1;
    public static final int VIRGIN = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object lock;
    public long nextExecutionTime;
    public long period;
    public int state;

    public SharedTimerTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lock = new Object();
        this.state = 0;
    }

    public boolean cancel() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.lock) {
                z = true;
                if (this.state != 1) {
                    z = false;
                }
                this.state = 3;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public long scheduledExecutionTime() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.lock) {
                j = this.nextExecutionTime;
            }
            return j;
        }
        return invokeV.longValue;
    }
}
