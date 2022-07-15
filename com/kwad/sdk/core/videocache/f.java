package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.videocache.b.a;
import com.kwad.sdk.utils.aj;
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
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class f {
    public final Object a;
    public final ExecutorService b;
    public final Map<String, g> c;
    public final ServerSocket d;
    public final int e;
    public final Thread f;
    public final com.kwad.sdk.core.videocache.c g;

    /* loaded from: classes5.dex */
    public static final class a {
        public File a;
        public com.kwad.sdk.core.videocache.c.b d;
        public com.kwad.sdk.core.videocache.kwai.a c = new com.kwad.sdk.core.videocache.kwai.g(536870912);
        public com.kwad.sdk.core.videocache.kwai.c b = new com.kwad.sdk.core.videocache.kwai.f();
        public com.kwad.sdk.core.videocache.a.b e = new com.kwad.sdk.core.videocache.a.a();

        public a(Context context) {
            this.d = com.kwad.sdk.core.videocache.c.c.a(context);
            this.a = n.a(context);
        }

        private com.kwad.sdk.core.videocache.c b() {
            return new com.kwad.sdk.core.videocache.c(this.a, this.b, this.c, this.d, this.e);
        }

        public final a a(long j) {
            this.c = new com.kwad.sdk.core.videocache.kwai.g(104857600L);
            return this;
        }

        public final f a() {
            return new f(b(), (byte) 0);
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements Runnable {
        public final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.b);
        }
    }

    /* loaded from: classes5.dex */
    public final class c implements Runnable {
        public final CountDownLatch b;

        public c(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.b.countDown();
                f.this.a();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.a(th);
            }
        }
    }

    public f(com.kwad.sdk.core.videocache.c cVar) {
        this.a = new Object();
        this.b = com.kwad.sdk.core.threads.b.h();
        this.c = new ConcurrentHashMap();
        this.g = (com.kwad.sdk.core.videocache.c) aj.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    private String a(String str, boolean z) {
        if (f(str).exists()) {
            File f = f(str);
            a(f);
            return Uri.fromFile(f).toString();
        }
        return e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.d.accept();
                com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", "Accept new socket " + accept);
                this.b.submit(new b(accept));
            } catch (IOException e) {
                a(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.b.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public static void a(Throwable th) {
        com.kwad.sdk.core.d.b.e("HttpProxyCacheServer", "HttpProxyCacheServer error");
        com.kwad.sdk.core.d.b.b(th);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0004 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    public void a(Socket socket) {
        StringBuilder sb;
        ?? r0 = "Opened connections: ";
        try {
            try {
                d a2 = d.a(socket.getInputStream());
                com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", "Request to cache proxy:" + a2);
                h(k.c(a2.a)).a(a2, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            r0 = b();
            sb.append((int) r0);
            socket = sb.toString();
            com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", (String) socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", ((String) r0) + b());
            throw th;
        }
    }

    private boolean a(String str, int i, a.C0548a c0548a) {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (d(str)) {
            return true;
        }
        long j = 0;
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(e(str)).openConnection();
            try {
                p.a(httpURLConnection);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.n.c());
                httpURLConnection.setRequestProperty("BrowserUa", com.kwad.sdk.core.network.n.d());
                httpURLConnection.setRequestProperty("SystemUa", com.kwad.sdk.core.network.n.a());
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[1024];
                    do {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j += read;
                    } while (j <= i);
                    com.kwad.sdk.crash.utils.b.a(bufferedInputStream2);
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        com.kwad.sdk.core.d.b.b(th);
                        com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", "downloadUrlToStream file crash", th);
                        com.kwad.sdk.crash.utils.b.a(bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                        return false;
                    } catch (Throwable th2) {
                        com.kwad.sdk.crash.utils.b.a(bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    private int b() {
        int i;
        synchronized (this.a) {
            i = 0;
            for (g gVar : this.c.values()) {
                i += gVar.b();
            }
        }
        return i;
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
            com.kwad.sdk.core.d.b.a("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            a(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    public static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private boolean d(String str) {
        aj.a(str, "Url can't be null!");
        return f(str).exists();
    }

    private String e(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.e), k.b(str));
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            a(new ProxyCacheException("Error closing socket", e));
        }
    }

    private File f(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.g;
        return new File(cVar.a, cVar.b.a(str));
    }

    private File g(String str) {
        File file = this.g.a;
        return new File(file, this.g.b.a(str) + ".download");
    }

    private g h(String str) {
        g gVar;
        synchronized (this.a) {
            gVar = this.c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.g);
                this.c.put(str, gVar);
            }
        }
        return gVar;
    }

    public final String a(String str) {
        return a(str, true);
    }

    public final boolean a(String str, int i) {
        return a(str, i, null);
    }

    public final boolean b(String str) {
        aj.a(str, "Url can't be null!");
        return g(str).exists() || f(str).exists();
    }

    public final boolean c(String str) {
        g gVar = this.c.get(str);
        if (gVar != null) {
            gVar.a();
            this.c.remove(str);
            return true;
        }
        return false;
    }
}
