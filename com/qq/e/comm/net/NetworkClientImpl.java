package com.qq.e.comm.net;

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
/* loaded from: classes7.dex */
public class NetworkClientImpl implements NetworkClient {

    /* renamed from: a  reason: collision with root package name */
    public static final NetworkClient f35558a = new NetworkClientImpl();

    /* renamed from: c  reason: collision with root package name */
    public PriorityBlockingQueue<Runnable> f35560c = new PriorityBlockingQueue<>(15);

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f35559b = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.f35560c);

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35561a;

        static {
            int[] iArr = new int[Request.Method.values().length];
            f35561a = iArr;
            try {
                iArr[Request.Method.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35561a[Request.Method.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {

        /* renamed from: a  reason: collision with root package name */
        public final NetworkClient.Priority f35562a;

        public NetFutureTask(Callable<T> callable, NetworkClient.Priority priority) {
            super(callable);
            this.f35562a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            if (netFutureTask == null) {
                return 1;
            }
            return this.f35562a.value() - netFutureTask.f35562a.value();
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((NetFutureTask) ((NetFutureTask) obj));
        }

        public boolean equals(Object obj) {
            return obj != null && obj.getClass() == NetFutureTask.class && compareTo((NetFutureTask) ((NetFutureTask) obj)) == 0;
        }

        public int hashCode() {
            return this.f35562a.value();
        }
    }

    /* loaded from: classes7.dex */
    public static class TaskCallable implements Callable<Response> {

        /* renamed from: a  reason: collision with root package name */
        public Request f35563a;

        /* renamed from: b  reason: collision with root package name */
        public NetworkCallBack f35564b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.f35563a = request;
            this.f35564b = networkCallBack;
        }

        private void a(HttpURLConnection httpURLConnection) {
            for (Map.Entry<String, String> entry : this.f35563a.getHeaders().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setRequestProperty("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
            if (this.f35563a.getConnectionTimeOut() > 0) {
                httpURLConnection.setConnectTimeout(this.f35563a.getConnectionTimeOut());
            } else {
                httpURLConnection.setConnectTimeout(30000);
            }
            if (this.f35563a.getSocketTimeOut() > 0) {
                httpURLConnection.setReadTimeout(this.f35563a.getSocketTimeOut());
            } else {
                httpURLConnection.setReadTimeout(30000);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
            if (r6.f35563a.isAutoClose() != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
            if (r1 != null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
            return r1;
         */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Response call() throws Exception {
            Response response;
            Exception exc = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f35563a.getUrlWithParas()).openConnection();
                a(httpURLConnection);
                if (AnonymousClass1.f35561a[this.f35563a.getMethod().ordinal()] == 1) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setChunkedStreamingMode(0);
                    byte[] postData = this.f35563a.getPostData();
                    if (postData != null && postData.length > 0) {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        bufferedOutputStream.write(postData);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    }
                }
                response = this.f35563a.initResponse(NetworkClientImpl.followRedirect(httpURLConnection));
            } catch (Exception e2) {
                response = null;
                exc = e2;
            }
            if (exc == null) {
                NetworkCallBack networkCallBack = this.f35564b;
                if (networkCallBack != null) {
                    networkCallBack.onResponse(this.f35563a, response);
                }
            } else if (this.f35564b == null) {
                throw exc;
            } else {
                GDTLogger.w("NetworkClientException", exc);
                this.f35564b.onException(exc);
            }
        }
    }

    public static HttpURLConnection followRedirect(HttpURLConnection httpURLConnection) throws IOException {
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

    public static NetworkClient getInstance() {
        return f35558a;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request) {
        return submit(request, NetworkClient.Priority.Mid);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request, NetworkClient.Priority priority) {
        NetFutureTask netFutureTask = new NetFutureTask(new TaskCallable(request), priority);
        this.f35559b.execute(netFutureTask);
        GDTLogger.d("QueueSize:" + this.f35560c.size());
        return netFutureTask;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, NetworkClient.Priority.Mid, networkCallBack);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack) {
        submit(request, priority, networkCallBack, this.f35559b);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack, Executor executor) {
        if (executor == null) {
            GDTLogger.e("Submit failed for no executor");
            return;
        }
        executor.execute(new NetFutureTask(new TaskCallable(request, networkCallBack), priority));
        GDTLogger.d("QueueSize:" + this.f35560c.size());
    }
}
