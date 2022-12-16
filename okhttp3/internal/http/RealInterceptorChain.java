package okhttp3.internal.http;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.data.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
/* loaded from: classes9.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Call call;
    public int calls;
    public final int connectTimeout;
    public final RealConnection connection;
    public final EventListener eventListener;
    public final HttpCodec httpCodec;
    public final int index;
    public final List<Interceptor> interceptors;
    public final int readTimeout;
    public final Request request;
    public final StreamAllocation streamAllocation;
    public final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {list, streamAllocation, httpCodec, realConnection, Integer.valueOf(i), request, call, eventListener, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.interceptors = list;
        this.connection = realConnection;
        this.streamAllocation = streamAllocation;
        this.httpCodec = httpCodec;
        this.index = i;
        this.request = request;
        this.call = call;
        this.eventListener = eventListener;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.call;
        }
        return (Call) invokeV.objValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.connectTimeout;
        }
        return invokeV.intValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.connection;
        }
        return (Connection) invokeV.objValue;
    }

    public EventListener eventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.eventListener;
        }
        return (EventListener) invokeV.objValue;
    }

    public HttpCodec httpStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.httpCodec;
        }
        return (HttpCodec) invokeV.objValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.readTimeout;
        }
        return invokeV.intValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.request;
        }
        return (Request) invokeV.objValue;
    }

    public StreamAllocation streamAllocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.streamAllocation;
        }
        return (StreamAllocation) invokeV.objValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.writeTimeout;
        }
        return invokeV.intValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, request)) == null) {
            return proceed(request, this.streamAllocation, this.httpCodec, this.connection);
        }
        return (Response) invokeL.objValue;
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, request, streamAllocation, httpCodec, realConnection)) == null) {
            if (this.index < this.interceptors.size()) {
                this.calls++;
                if (this.httpCodec != null && !this.connection.supportsUrl(request.url())) {
                    throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
                } else if (this.httpCodec != null && this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
                } else {
                    RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation, httpCodec, realConnection, this.index + 1, request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
                    Interceptor interceptor = this.interceptors.get(this.index);
                    Response intercept = interceptor.intercept(realInterceptorChain);
                    if (httpCodec != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                        throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                    } else if (intercept != null) {
                        if (intercept.body() != null) {
                            return intercept;
                        }
                        throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                    } else {
                        throw new NullPointerException("interceptor " + interceptor + " returned null");
                    }
                }
            }
            throw new AssertionError();
        }
        return (Response) invokeLLLL.objValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, timeUnit)) == null) {
            return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, Util.checkDuration(a.O, i, timeUnit), this.readTimeout, this.writeTimeout);
        }
        return (Interceptor.Chain) invokeIL.objValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, timeUnit)) == null) {
            return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, Util.checkDuration(a.O, i, timeUnit), this.writeTimeout);
        }
        return (Interceptor.Chain) invokeIL.objValue;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, timeUnit)) == null) {
            return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, Util.checkDuration(a.O, i, timeUnit));
        }
        return (Interceptor.Chain) invokeIL.objValue;
    }
}
