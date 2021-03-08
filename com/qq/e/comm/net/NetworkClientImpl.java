package com.qq.e.comm.net;

import android.net.http.Headers;
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
/* loaded from: classes4.dex */
public class NetworkClientImpl implements NetworkClient {

    /* renamed from: a  reason: collision with root package name */
    private static final NetworkClient f7580a = new NetworkClientImpl();
    private PriorityBlockingQueue<Runnable> c = new PriorityBlockingQueue<>(15);
    private final ExecutorService b = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.c);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final NetworkClient.Priority f7582a;

        public NetFutureTask(Callable<T> callable, NetworkClient.Priority priority) {
            super(callable);
            this.f7582a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            if (netFutureTask == null) {
                return 1;
            }
            return this.f7582a.value() - netFutureTask.f7582a.value();
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((NetFutureTask) ((NetFutureTask) obj));
        }

        public boolean equals(Object obj) {
            return obj != null && obj.getClass() == getClass() && compareTo((NetFutureTask) ((NetFutureTask) obj)) == 0;
        }

        public int hashCode() {
            return this.f7582a.value();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class TaskCallable implements Callable<Response> {

        /* renamed from: a  reason: collision with root package name */
        private Request f7583a;
        private NetworkCallBack b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.f7583a = request;
            this.b = networkCallBack;
        }

        private void a(HttpURLConnection httpURLConnection) {
            for (Map.Entry<String, String> entry : this.f7583a.getHeaders().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setRequestProperty("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
            if (this.f7583a.getConnectionTimeOut() > 0) {
                httpURLConnection.setConnectTimeout(this.f7583a.getConnectionTimeOut());
            } else {
                httpURLConnection.setConnectTimeout(30000);
            }
            if (this.f7583a.getSocketTimeOut() > 0) {
                httpURLConnection.setReadTimeout(this.f7583a.getSocketTimeOut());
            } else {
                httpURLConnection.setReadTimeout(30000);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Response call() throws Exception {
            Response response;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f7583a.getUrlWithParas()).openConnection();
                a(httpURLConnection);
                switch (this.f7583a.getMethod()) {
                    case POST:
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setChunkedStreamingMode(0);
                        byte[] postData = this.f7583a.getPostData();
                        if (postData != null && postData.length > 0) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            bufferedOutputStream.write(postData);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            break;
                        }
                        break;
                }
                response = this.f7583a.initResponse(NetworkClientImpl.followRedirect(httpURLConnection));
                e = null;
            } catch (Exception e) {
                e = e;
                response = null;
            }
            if (e == null) {
                if (this.b != null) {
                    this.b.onResponse(this.f7583a, response);
                }
                if (this.f7583a.isAutoClose()) {
                    response.close();
                }
            } else if (this.b == null) {
                throw e;
            } else {
                GDTLogger.w("NetworkClientException", e);
                this.b.onException(e);
                if (response != null) {
                    response.close();
                }
            }
            return response;
        }
    }

    private NetworkClientImpl() {
    }

    public static HttpURLConnection followRedirect(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        HttpURLConnection httpURLConnection2;
        if (httpURLConnection == null) {
            return null;
        }
        int i = 0;
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        try {
            str = httpURLConnection.getRequestProperty("User-Agent");
            httpURLConnection2 = httpURLConnection;
        } catch (Exception e) {
            str = null;
            httpURLConnection2 = httpURLConnection;
        }
        while (i < 3) {
            httpURLConnection2.connect();
            int responseCode = httpURLConnection2.getResponseCode();
            if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                break;
            }
            String headerField = httpURLConnection2.getHeaderField(Headers.LOCATION);
            httpURLConnection2.disconnect();
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(headerField).openConnection();
            httpURLConnection3.setConnectTimeout(connectTimeout);
            httpURLConnection3.setReadTimeout(readTimeout);
            if (str != null) {
                httpURLConnection3.setRequestProperty("User-Agent", str);
            }
            i++;
            httpURLConnection2 = httpURLConnection3;
        }
        if (i == 3) {
            throw new IOException("HttpURLConnection exceed max redirect 3 " + httpURLConnection2.getURL());
        }
        return httpURLConnection2;
    }

    public static NetworkClient getInstance() {
        return f7580a;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request) {
        return submit(request, NetworkClient.Priority.Mid);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request, NetworkClient.Priority priority) {
        NetFutureTask netFutureTask = new NetFutureTask(new TaskCallable(request), priority);
        this.b.execute(netFutureTask);
        GDTLogger.d("QueueSize:" + this.c.size());
        return netFutureTask;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, NetworkClient.Priority.Mid, networkCallBack);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack) {
        submit(request, priority, networkCallBack, this.b);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack, Executor executor) {
        if (executor == null) {
            GDTLogger.e("Submit failed for no executor");
            return;
        }
        executor.execute(new NetFutureTask(new TaskCallable(request, networkCallBack), priority));
        GDTLogger.d("QueueSize:" + this.c.size());
    }
}
