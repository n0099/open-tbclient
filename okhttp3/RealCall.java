package okhttp3;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.data.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;
/* loaded from: classes9.dex */
public final class RealCall implements Call {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient client;
    @Nullable
    public EventListener eventListener;
    public boolean executed;
    public final boolean forWebSocket;
    public final Request originalRequest;
    public final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    public final AsyncTimeout timeout;

    /* loaded from: classes9.dex */
    public final class AsyncCall extends NamedRunnable {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callback responseCallback;
        public final /* synthetic */ RealCall this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1225419907, "Lokhttp3/RealCall$AsyncCall;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1225419907, "Lokhttp3/RealCall$AsyncCall;");
                }
            }
        }

        public RealCall get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.this$0;
            }
            return (RealCall) invokeV.objValue;
        }

        public String host() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.this$0.originalRequest.url().host();
            }
            return (String) invokeV.objValue;
        }

        public Request request() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.this$0.originalRequest;
            }
            return (Request) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncCall(RealCall realCall, Callback callback) {
            super("OkHttp %s", realCall.redactedUrl());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {realCall, callback};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = realCall;
            this.responseCallback = callback;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Throwable th;
            boolean z;
            IOException e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.eventListener.callThreadSwitchEnd(this.this$0);
                this.this$0.timeout.enter();
                try {
                    try {
                        z = true;
                        try {
                            this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain());
                        } catch (IOException e2) {
                            e = e2;
                            IOException timeoutExit = this.this$0.timeoutExit(e);
                            if (z) {
                                Platform platform = Platform.get();
                                platform.log(4, "Callback failure for " + this.this$0.toLoggableString(), timeoutExit);
                            } else {
                                this.this$0.eventListener.callFailed(this.this$0, timeoutExit);
                                this.responseCallback.onFailure(this.this$0, timeoutExit);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            this.this$0.cancel();
                            if (!z) {
                                this.responseCallback.onFailure(this.this$0, new IOException("canceled due to " + th));
                            }
                            throw th;
                        }
                    } finally {
                        this.this$0.client.dispatcher().finished(this);
                    }
                } catch (IOException e3) {
                    e = e3;
                    z = false;
                } catch (Throwable th3) {
                    th = th3;
                    z = false;
                }
            }
        }

        public void executeOn(ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, executorService) == null) {
                this.this$0.eventListener.callThreadSwitchInQueue(this.this$0);
                try {
                    try {
                        executorService.execute(this);
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        this.this$0.eventListener.callFailed(this.this$0, interruptedIOException);
                        this.responseCallback.onFailure(this.this$0, interruptedIOException);
                        this.this$0.client.dispatcher().finished(this);
                    }
                } catch (Throwable th) {
                    this.this$0.client.dispatcher().finished(this);
                    throw th;
                }
            }
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
        AsyncTimeout asyncTimeout = new AsyncTimeout(this) { // from class: okhttp3.RealCall.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RealCall this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // okio.AsyncTimeout
            public void timedOut() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.cancel();
                }
            }
        };
        this.timeout = asyncTimeout;
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    @Nullable
    public IOException timeoutExit(@Nullable IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, iOException)) == null) {
            if (!this.timeout.exit()) {
                return iOException;
            }
            InterruptedIOException interruptedIOException = new InterruptedIOException(a.O);
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return (IOException) invokeL.objValue;
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

    @Override // okhttp3.Call
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.timeout;
        }
        return (Timeout) invokeV.objValue;
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
            this.eventListener.callThreadSwitchStart(this);
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
            this.timeout.enter();
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
                    IOException timeoutExit = timeoutExit(e);
                    this.eventListener.callFailed(this, timeoutExit);
                    throw timeoutExit;
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
            Response proceed = new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            if (!this.retryAndFollowUpInterceptor.isCanceled()) {
                return proceed;
            }
            Util.closeQuietly(proceed);
            throw new IOException("Canceled");
        }
        return (Response) invokeV.objValue;
    }

    public String toLoggableString() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
