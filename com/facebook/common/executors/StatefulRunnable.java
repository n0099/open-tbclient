package com.facebook.common.executors;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class StatefulRunnable implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_CANCELLED = 2;
    public static final int STATE_CREATED = 0;
    public static final int STATE_FAILED = 4;
    public static final int STATE_FINISHED = 3;
    public static final int STATE_STARTED = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger mState;

    public void disposeResult(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
        }
    }

    public abstract Object getResult() throws Exception;

    public void onCancellation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void onFailure(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
        }
    }

    public void onSuccess(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
        }
    }

    public StatefulRunnable() {
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
        this.mState = new AtomicInteger(0);
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mState.compareAndSet(0, 2)) {
            onCancellation();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !this.mState.compareAndSet(0, 1)) {
            return;
        }
        try {
            Object result = getResult();
            this.mState.set(3);
            try {
                onSuccess(result);
            } finally {
                disposeResult(result);
            }
        } catch (Exception e) {
            this.mState.set(4);
            onFailure(e);
        }
    }
}
