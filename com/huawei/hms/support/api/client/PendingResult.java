package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public abstract class PendingResult<R extends Result> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract R await();

    public abstract R await(long j, TimeUnit timeUnit);

    @Deprecated
    public abstract void cancel();

    @Deprecated
    public abstract boolean isCanceled();

    public abstract void setResultCallback(Looper looper, ResultCallback<R> resultCallback);

    public abstract void setResultCallback(ResultCallback<R> resultCallback);

    @Deprecated
    public abstract void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit);

    public PendingResult() {
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

    public <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> resultConvert) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, resultConvert)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ConvertedResult) invokeL.objValue;
    }
}
