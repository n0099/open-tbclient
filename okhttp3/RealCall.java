package okhttp3;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
/* loaded from: classes8.dex */
public final class RealCall implements Call {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient client;
    public EventListener eventListener;
    public boolean executed;
    public final boolean forWebSocket;
    public final Request originalRequest;
    public final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;

    /* loaded from: classes8.dex */
    public final class AsyncCall extends NamedRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callback responseCallback;
        public final /* synthetic */ RealCall this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncCall(RealCall realCall, Callback callback) {
            super("OkHttp %s", realCall.redactedUrl());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {realCall, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = realCall;
            this.responseCallback = callback;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            IOException e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = true;
                try {
                    try {
                        Response responseWithInterceptorChain = this.this$0.getResponseWithInterceptorChain();
                        try {
                            if (this.this$0.retryAndFollowUpInterceptor.isCanceled()) {
                                this.responseCallback.onFailure(this.this$0, new IOException("Canceled"));
                            } else {
                                this.responseCallback.onResponse(this.this$0, responseWithInterceptorChain);
                            }
                        } catch (IOException e2) {
                            e = e2;
                            if (z) {
                                Platform platform = Platform.get();
                                platform.log(4, "Callback failure for " + this.this$0.toLoggableString(), e);
                            } else {
                                this.this$0.eventListener.callFailed(this.this$0, e);
                                this.responseCallback.onFailure(this.this$0, e);
                            }
                        }
                    } finally {
                        this.this$0.client.dispatcher().finished(this);
                    }
                } catch (IOException e3) {
                    e = e3;
                    z = false;
                }
            }
        }

        public RealCall get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.this$0;
            }
            return (RealCall) invokeV.objValue;
        }

        public String host() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.this$0.originalRequest.url().host();
            }
            return (String) invokeV.objValue;
        }

        public Request request() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.this$0.originalRequest;
            }
            return (Request) invokeV.objValue;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient, request, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
    }

    private void captureCallStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
        }
    }

    @Override // okhttp3.Call
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.retryAndFollowUpInterceptor.cancel();
        }
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.retryAndFollowUpInterceptor.isCanceled();
        }
        return invokeV.booleanValue;
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                z = this.executed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public String redactedUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.originalRequest.url().redact();
        }
        return (String) invokeV.objValue;
    }

    @Override // okhttp3.Call
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.originalRequest;
        }
        return (Request) invokeV.objValue;
    }

    public StreamAllocation streamAllocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.retryAndFollowUpInterceptor.streamAllocation();
        }
        return (StreamAllocation) invokeV.objValue;
    }

    public static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, okHttpClient, request, z)) == null) {
            RealCall realCall = new RealCall(okHttpClient, request, z);
            realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
            return realCall;
        }
        return (RealCall) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okhttp3.Call
    public RealCall clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return newRealCall(this.client, this.originalRequest, this.forWebSocket);
        }
        return (RealCall) invokeV.objValue;
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, callback) == null) {
            synchronized (this) {
                if (!this.executed) {
                    this.executed = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            captureCallStackTrace();
            this.eventListener.callStart(this);
            this.client.dispatcher().enqueue(new AsyncCall(this, callback));
        }
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (!this.executed) {
                    this.executed = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            captureCallStackTrace();
            this.eventListener.callStart(this);
            try {
                try {
                    this.client.dispatcher().executed(this);
                    Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                    if (responseWithInterceptorChain != null) {
                        return responseWithInterceptorChain;
                    }
                    throw new IOException("Canceled");
                } catch (IOException e) {
                    this.eventListener.callFailed(this, e);
                    throw e;
                }
            } finally {
                this.client.dispatcher().finished(this);
            }
        }
        return (Response) invokeV.objValue;
    }

    public Response getResponseWithInterceptorChain() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.client.interceptors());
            arrayList.add(this.retryAndFollowUpInterceptor);
            arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
            arrayList.add(new CacheInterceptor(this.client.internalCache()));
            arrayList.add(new ConnectInterceptor(this.client));
            if (!this.forWebSocket) {
                arrayList.addAll(this.client.networkInterceptors());
            }
            arrayList.add(new CallServerInterceptor(this.forWebSocket));
            return new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        }
        return (Response) invokeV.objValue;
    }

    public String toLoggableString() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (isCanceled()) {
                str = "canceled ";
            } else {
                str = "";
            }
            sb.append(str);
            if (this.forWebSocket) {
                str2 = "web socket";
            } else {
                str2 = NotificationCompat.CATEGORY_CALL;
            }
            sb.append(str2);
            sb.append(" to ");
            sb.append(redactedUrl());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
