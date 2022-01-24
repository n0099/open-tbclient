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
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class f {
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f56317b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, g> f56318c;

    /* renamed from: d  reason: collision with root package name */
    public final ServerSocket f56319d;

    /* renamed from: e  reason: collision with root package name */
    public final int f56320e;

    /* renamed from: f  reason: collision with root package name */
    public final Thread f56321f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c f56322g;

    /* loaded from: classes3.dex */
    public static final class a {
        public File a;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.c.b f56325d;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.kwai.a f56324c = new com.kwad.sdk.core.videocache.kwai.g(536870912);

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.kwai.c f56323b = new com.kwad.sdk.core.videocache.kwai.f();

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.a.b f56326e = new com.kwad.sdk.core.videocache.a.a();

        public a(Context context) {
            this.f56325d = com.kwad.sdk.core.videocache.c.c.a(context);
            this.a = o.a(context);
        }

        private com.kwad.sdk.core.videocache.c b() {
            return new com.kwad.sdk.core.videocache.c(this.a, this.f56323b, this.f56324c, this.f56325d, this.f56326e);
        }

        public a a(long j2) {
            this.f56324c = new com.kwad.sdk.core.videocache.kwai.g(j2);
            return this;
        }

        public f a() {
            return new f(b());
        }
    }

    /* loaded from: classes3.dex */
    public final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Socket f56327b;

        public b(Socket socket) {
            this.f56327b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.f56327b);
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CountDownLatch f56328b;

        public c(CountDownLatch countDownLatch) {
            this.f56328b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f56328b.countDown();
                f.this.a();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    public f(com.kwad.sdk.core.videocache.c cVar) {
        this.a = new Object();
        this.f56317b = com.kwad.sdk.core.i.b.l();
        this.f56318c = new ConcurrentHashMap();
        this.f56322g = (com.kwad.sdk.core.videocache.c) j.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f56319d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f56320e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f56321f = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e2) {
            this.f56317b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f56319d.accept();
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Accept new socket " + accept);
                this.f56317b.submit(new b(accept));
            } catch (IOException e2) {
                a(new ProxyCacheException("Error during waiting connection", e2));
                return;
            }
        }
    }

    private void a(File file) {
        try {
            this.f56322g.f56308c.a(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.a.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    private void a(Throwable th) {
        com.kwad.sdk.core.d.a.e("HttpProxyCacheServer", "HttpProxyCacheServer error");
        com.kwad.sdk.core.d.a.b(th);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0004 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v1 ?? I:java.lang.String), (wrap: int : 0x007c: INVOKE  (r0v2 int A[REMOVE]) = (r5v0 'this' ?? I:com.kwad.sdk.core.videocache.f A[IMMUTABLE_TYPE, THIS]) type: DIRECT call: com.kwad.sdk.core.videocache.f.b():int)] */
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
                f(l.c(a2.a)).a(a2, socket);
                b(socket);
                sb = new StringBuilder();
            } catch (ProxyCacheException e2) {
                e = e2;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            } catch (SocketException e3) {
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e3.printStackTrace();
                b(socket);
                sb = new StringBuilder();
            } catch (IOException e4) {
                e = e4;
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
        synchronized (this.a) {
            i2 = 0;
            for (g gVar : this.f56318c.values()) {
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
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f56320e), l.b(str));
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
        synchronized (this.a) {
            gVar = this.f56318c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.f56322g);
                this.f56318c.put(str, gVar);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00be */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0026 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    public boolean a(String str, int i2) {
        BufferedInputStream bufferedInputStream;
        com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (b(str)) {
            return true;
        }
        ?? e2 = e(str);
        long j2 = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                e2 = (HttpURLConnection) new URL(e2).openConnection();
                try {
                    com.kwad.sdk.core.network.m.a((URLConnection) e2);
                    e2.setRequestProperty("Accept-Language", "zh-CN");
                    e2.setConnectTimeout(10000);
                    e2.setReadTimeout(120000);
                    e2.setUseCaches(false);
                    e2.setDoInput(true);
                    e2.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                    e2.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    e2.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.c());
                    e2.setRequestProperty("BrowserUa", com.kwad.sdk.core.network.k.d());
                    e2.setRequestProperty("SystemUa", com.kwad.sdk.core.network.k.a());
                    bufferedInputStream = new BufferedInputStream(e2.getInputStream());
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                try {
                    do {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j2 += read;
                    } while (j2 <= i2);
                    break;
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                if (e2 != 0) {
                    e2.disconnect();
                    return true;
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                bufferedInputStream2 = bufferedInputStream;
                com.kwad.sdk.core.d.a.b(e);
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "downloadUrlToStream file crash", e);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                if (e2 != 0) {
                    e2.disconnect();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                if (e2 != 0) {
                    e2.disconnect();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e2 = 0;
        } catch (Throwable th3) {
            th = th3;
            e2 = 0;
        }
    }

    public boolean b(String str) {
        j.a(str, "Url can't be null!");
        return d(str).exists();
    }

    public boolean c(String str) {
        g gVar = this.f56318c.get(str);
        if (gVar != null) {
            gVar.a();
            this.f56318c.remove(str);
            return true;
        }
        return false;
    }

    public File d(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.f56322g;
        return new File(cVar.a, cVar.f56307b.a(str));
    }
}
