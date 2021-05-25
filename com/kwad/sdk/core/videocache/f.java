package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final Object f32726a;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f32727b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, g> f32728c;

    /* renamed from: d  reason: collision with root package name */
    public final ServerSocket f32729d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32730e;

    /* renamed from: f  reason: collision with root package name */
    public final Thread f32731f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c f32732g;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public File f32733a;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.d.b f32736d;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.a.a f32735c = new com.kwad.sdk.core.videocache.a.g(536870912);

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.a.c f32734b = new com.kwad.sdk.core.videocache.a.f();

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.b.b f32737e = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.f32736d = com.kwad.sdk.core.videocache.d.c.a(context);
            this.f32733a = o.a(context);
        }

        private com.kwad.sdk.core.videocache.c b() {
            return new com.kwad.sdk.core.videocache.c(this.f32733a, this.f32734b, this.f32735c, this.f32736d, this.f32737e);
        }

        public a a(long j) {
            this.f32735c = new com.kwad.sdk.core.videocache.a.g(j);
            return this;
        }

        public f a() {
            return new f(b());
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Socket f32739b;

        public b(Socket socket) {
            this.f32739b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.a(this.f32739b);
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CountDownLatch f32741b;

        public c(CountDownLatch countDownLatch) {
            this.f32741b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f32741b.countDown();
                f.this.a();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    public f(com.kwad.sdk.core.videocache.c cVar) {
        this.f32726a = new Object();
        this.f32727b = Executors.newFixedThreadPool(8);
        this.f32728c = new ConcurrentHashMap();
        this.f32732g = (com.kwad.sdk.core.videocache.c) j.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f32729d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f32730e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f32731f = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e2) {
            this.f32727b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f32729d.accept();
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Accept new socket " + accept);
                this.f32727b.submit(new b(accept));
            } catch (IOException e2) {
                a(new ProxyCacheException("Error during waiting connection", e2));
                return;
            }
        }
    }

    private void a(File file) {
        try {
            this.f32732g.f32713c.a(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.a.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    private void a(Throwable th) {
        com.kwad.sdk.core.d.a.e("HttpProxyCacheServer", "HttpProxyCacheServer error");
        com.kwad.sdk.core.d.a.a(th);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0004 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v1 ?? I:java.lang.String), (wrap: int : 0x0078: INVOKE  (r0v2 int A[REMOVE]) = (r5v0 'this' ?? I:com.kwad.sdk.core.videocache.f A[IMMUTABLE_TYPE, THIS]) type: DIRECT call: com.kwad.sdk.core.videocache.f.b():int)] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    public void a(Socket socket) {
        StringBuilder sb;
        ?? r0 = "Opened connections: ";
        try {
            try {
                d a2 = d.a(socket.getInputStream());
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Request to cache proxy:" + a2);
                f(l.c(a2.f32719a)).a(a2, socket);
                b(socket);
                sb = new StringBuilder();
            } catch (ProxyCacheException e2) {
                e = e2;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            } catch (SocketException unused) {
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                b(socket);
                sb = new StringBuilder();
            } catch (IOException e3) {
                e = e3;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            r0 = b();
            sb.append((int) r0);
            socket = sb.toString();
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", (String) socket);
        } catch (Throwable th) {
            b(socket);
            ?? sb2 = new StringBuilder();
            sb2.append(r0);
            sb2.append(b());
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", sb2.toString());
            throw th;
        }
    }

    private int b() {
        int i2;
        synchronized (this.f32726a) {
            i2 = 0;
            for (g gVar : this.f32728c.values()) {
                i2 += gVar.b();
            }
        }
        return i2;
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            a(new ProxyCacheException("Error closing socket input stream", e2));
        }
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.a.d("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private String e(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f32730e), l.b(str));
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e2) {
            a(new ProxyCacheException("Error closing socket", e2));
        }
    }

    private g f(String str) {
        g gVar;
        synchronized (this.f32726a) {
            gVar = this.f32728c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.f32732g);
                this.f32728c.put(str, gVar);
            }
        }
        return gVar;
    }

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z) {
        if (z && d(str).exists()) {
            File d2 = d(str);
            a(d2);
            return Uri.fromFile(d2).toString();
        }
        return e(str);
    }

    public boolean a(String str, int i2) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        if (b(str)) {
            return true;
        }
        long j = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(e(str)).openConnection();
            try {
                try {
                    com.kwad.sdk.core.network.l.a(httpURLConnection);
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(120000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                    httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.a());
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            byte[] bArr = new byte[1024];
            try {
                do {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j += read;
                } while (j <= i2);
                break;
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                return true;
            }
            return true;
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream2 = bufferedInputStream;
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "downloadUrlToStream file crash", e);
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused3) {
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public boolean b(String str) {
        j.a(str, "Url can't be null!");
        return d(str).exists();
    }

    public boolean c(String str) {
        g gVar = this.f32728c.get(str);
        if (gVar != null) {
            gVar.a();
            this.f32728c.remove(str);
            return true;
        }
        return false;
    }

    public File d(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.f32732g;
        return new File(cVar.f32711a, cVar.f32712b.a(str));
    }
}
