package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public R a;
    public int b;

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ResultCallback a;
        public final /* synthetic */ ErrorResultImpl b;
        public final /* synthetic */ ErrorResultImpl c;

        public a(ErrorResultImpl errorResultImpl, ResultCallback resultCallback, ErrorResultImpl errorResultImpl2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {errorResultImpl, resultCallback, errorResultImpl2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = errorResultImpl;
            this.a = resultCallback;
            this.b = errorResultImpl2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ResultCallback resultCallback = this.a;
                ErrorResultImpl errorResultImpl = this.c;
                resultCallback.onResult(errorResultImpl.a(errorResultImpl.b, this.b));
            }
        }
    }

    public ErrorResultImpl(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = i;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, resultCallback) == null) {
            setResultCallback(Looper.getMainLooper(), resultCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public R a(int i, ErrorResultImpl errorResultImpl) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i, errorResultImpl)) == null) {
            Type genericSuperclass = errorResultImpl.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                try {
                    R r = (R) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).newInstance();
                    this.a = r;
                    r.setStatus(new Status(i));
                } catch (IllegalAccessException unused) {
                    HMSLog.e("ErrorResultImpl", "IllegalAccessException");
                } catch (InstantiationException unused2) {
                    HMSLog.e("ErrorResultImpl", "InstantiationException");
                }
                return this.a;
            }
            return null;
        }
        return (R) invokeIL.objValue;
    }

    public void postRunnable(Looper looper, ResultCallback<R> resultCallback, ErrorResultImpl errorResultImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, looper, resultCallback, errorResultImpl) == null) {
            if (looper == null) {
                looper = Looper.myLooper();
            }
            new Handler(looper).post(new a(this, resultCallback, errorResultImpl));
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{resultCallback, Long.valueOf(j), timeUnit}) == null) {
            setResultCallback(resultCallback);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return await(0L, null);
        }
        return (R) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return a(this.b, this);
            }
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        return (R) invokeJL.objValue;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, looper, resultCallback) == null) {
            postRunnable(looper, resultCallback, this);
        }
    }
}
