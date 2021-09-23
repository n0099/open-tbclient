package com.qq.e.comm.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class NetworkClientImpl implements NetworkClient {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final NetworkClient f75710a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f75711b;

    /* renamed from: c  reason: collision with root package name */
    public PriorityBlockingQueue<Runnable> f75712c;

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f75713a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(141572811, "Lcom/qq/e/comm/net/NetworkClientImpl$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(141572811, "Lcom/qq/e/comm/net/NetworkClientImpl$1;");
                    return;
                }
            }
            int[] iArr = new int[Request.Method.values().length];
            f75713a = iArr;
            try {
                iArr[Request.Method.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f75713a[Request.Method.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final NetworkClient.Priority f75714a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetFutureTask(Callable<T> callable, NetworkClient.Priority priority) {
            super(callable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callable, priority};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Callable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75714a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, netFutureTask)) == null) {
                if (netFutureTask == null) {
                    return 1;
                }
                return this.f75714a.value() - netFutureTask.f75714a.value();
            }
            return invokeL.intValue;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((NetFutureTask) ((NetFutureTask) obj));
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? obj != null && obj.getClass() == NetFutureTask.class && compareTo((NetFutureTask) ((NetFutureTask) obj)) == 0 : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75714a.value() : invokeV.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class TaskCallable implements Callable<Response> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Request f75715a;

        /* renamed from: b  reason: collision with root package name */
        public NetworkCallBack f75716b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TaskCallable(Request request) {
            this(request, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Request) objArr2[0], (NetworkCallBack) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request, networkCallBack};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f75715a = request;
            this.f75716b = networkCallBack;
        }

        private Response a() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f75715a.getUrlWithParas()).openConnection();
                a(httpURLConnection);
                if (AnonymousClass1.f75713a[this.f75715a.getMethod().ordinal()] == 1) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setChunkedStreamingMode(0);
                    byte[] postData = this.f75715a.getPostData();
                    if (postData != null && postData.length > 0) {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        try {
                            bufferedOutputStream.write(postData);
                            bufferedOutputStream.flush();
                        } finally {
                            bufferedOutputStream.close();
                        }
                    }
                }
                return this.f75715a.initResponse(NetworkClientImpl.followRedirect(httpURLConnection));
            }
            return (Response) invokeV.objValue;
        }

        private void a(HttpURLConnection httpURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, httpURLConnection) == null) {
                for (Map.Entry<String, String> entry : this.f75715a.getHeaders().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setRequestProperty("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + PreferencesUtil.RIGHT_MOUNT);
                if (this.f75715a.getConnectionTimeOut() > 0) {
                    httpURLConnection.setConnectTimeout(this.f75715a.getConnectionTimeOut());
                } else {
                    httpURLConnection.setConnectTimeout(30000);
                }
                if (this.f75715a.getSocketTimeOut() > 0) {
                    httpURLConnection.setReadTimeout(this.f75715a.getSocketTimeOut());
                } else {
                    httpURLConnection.setReadTimeout(30000);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
            if (r4.f75715a.isAutoClose() != false) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
            if (r1 != null) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
            return r1;
         */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Response call() throws Exception {
            InterceptResult invokeV;
            Response response;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (Response) invokeV.objValue;
            }
            Exception exc = null;
            try {
                response = a();
            } catch (Exception e2) {
                response = null;
                exc = e2;
            }
            if (exc == null) {
                NetworkCallBack networkCallBack = this.f75716b;
                if (networkCallBack != null) {
                    networkCallBack.onResponse(this.f75715a, response);
                }
            } else if (this.f75716b == null) {
                throw exc;
            } else {
                GDTLogger.w("网络异常", exc);
                this.f75716b.onException(exc);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1903761160, "Lcom/qq/e/comm/net/NetworkClientImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1903761160, "Lcom/qq/e/comm/net/NetworkClientImpl;");
                return;
            }
        }
        f75710a = new NetworkClientImpl();
    }

    public NetworkClientImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75712c = new PriorityBlockingQueue<>(15);
        this.f75711b = new ThreadPoolExecutor(5, 10, 180L, TimeUnit.SECONDS, this.f75712c);
    }

    public static HttpURLConnection followRedirect(HttpURLConnection httpURLConnection) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpURLConnection)) == null) {
            String str = null;
            if (httpURLConnection == null) {
                return null;
            }
            int i2 = 0;
            int connectTimeout = httpURLConnection.getConnectTimeout();
            int readTimeout = httpURLConnection.getReadTimeout();
            try {
                str = httpURLConnection.getRequestProperty("User-Agent");
            } catch (Exception unused) {
            }
            while (i2 < 3) {
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                    break;
                }
                String headerField = httpURLConnection.getHeaderField("location");
                httpURLConnection.disconnect();
                httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
                httpURLConnection.setConnectTimeout(connectTimeout);
                httpURLConnection.setReadTimeout(readTimeout);
                if (str != null) {
                    httpURLConnection.setRequestProperty("User-Agent", str);
                }
                i2++;
            }
            if (i2 != 3) {
                return httpURLConnection;
            }
            throw new IOException("HttpURLConnection exceed max redirect 3 " + httpURLConnection.getURL());
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public static NetworkClient getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f75710a : (NetworkClient) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) ? submit(request, NetworkClient.Priority.Mid) : (Future) invokeL.objValue;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request, NetworkClient.Priority priority) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, priority)) == null) {
            NetFutureTask netFutureTask = new NetFutureTask(new TaskCallable(request), priority);
            this.f75711b.execute(netFutureTask);
            GDTLogger.d("QueueSize:" + this.f75712c.size());
            return netFutureTask;
        }
        return (Future) invokeLL.objValue;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkCallBack networkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, request, networkCallBack) == null) {
            submit(request, NetworkClient.Priority.Mid, networkCallBack);
        }
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, request, priority, networkCallBack) == null) {
            submit(request, priority, networkCallBack, this.f75711b);
        }
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack, Executor executor) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, request, priority, networkCallBack, executor) == null) {
            if (executor == null) {
                str = "Submit failed for no executor";
            } else {
                executor.execute(new NetFutureTask(new TaskCallable(request, networkCallBack), priority));
                str = "QueueSize:" + this.f75712c.size();
            }
            GDTLogger.d(str);
        }
    }
}
