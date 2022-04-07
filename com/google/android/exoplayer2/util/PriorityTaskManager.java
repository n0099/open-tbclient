package com.google.android.exoplayer2.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
/* loaded from: classes4.dex */
public final class PriorityTaskManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int highestPriority;
    public final Object lock;
    public final PriorityQueue<Integer> queue;

    /* loaded from: classes4.dex */
    public static class PriorityTooLowException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PriorityTooLowException(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + PreferencesUtil.RIGHT_MOUNT);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public PriorityTaskManager() {
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
        this.lock = new Object();
        this.queue = new PriorityQueue<>(10, Collections.reverseOrder());
        this.highestPriority = Integer.MIN_VALUE;
    }

    public void add(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            synchronized (this.lock) {
                this.queue.add(Integer.valueOf(i));
                this.highestPriority = Math.max(this.highestPriority, i);
            }
        }
    }

    public void proceed(int i) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this.lock) {
                while (this.highestPriority != i) {
                    this.lock.wait();
                }
            }
        }
    }

    public boolean proceedNonBlocking(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            synchronized (this.lock) {
                z = this.highestPriority == i;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void proceedOrThrow(int i) throws PriorityTooLowException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this.lock) {
                if (this.highestPriority != i) {
                    throw new PriorityTooLowException(i, this.highestPriority);
                }
            }
        }
    }

    public void remove(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            synchronized (this.lock) {
                this.queue.remove(Integer.valueOf(i));
                this.highestPriority = this.queue.isEmpty() ? Integer.MIN_VALUE : this.queue.peek().intValue();
                this.lock.notifyAll();
            }
        }
    }
}
