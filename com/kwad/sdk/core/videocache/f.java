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
/* loaded from: classes5.dex */
public class f {
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
            this.a = o.a(context);
        }

        private com.kwad.sdk.core.videocache.c b() {
            return new com.kwad.sdk.core.videocache.c(this.a, this.b, this.c, this.d, this.e);
        }

        public a a(long j) {
            this.c = new com.kwad.sdk.core.videocache.kwai.g(j);
            return this;
        }

        public f a() {
            return new f(b());
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements Runnable {
        public final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
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
        public void run() {
            try {
                this.b.countDown();
                f.this.a();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    public f(com.kwad.sdk.core.videocache.c cVar) {
        this.a = new Object();
        this.b = com.kwad.sdk.core.i.b.l();
        this.c = new ConcurrentHashMap();
        this.g = (com.kwad.sdk.core.videocache.c) j.a(cVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.d.accept();
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Accept new socket " + accept);
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
            } catch (ProxyCacheException e) {
                e = e;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
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
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            a(new ProxyCacheException("Error closing socket input stream", e));
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
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.e), l.b(str));
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

    private g f(String str) {
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

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z) {
        if (z && d(str).exists()) {
            File d = d(str);
            a(d);
            return Uri.fromFile(d).toString();
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
    public boolean a(String str, int i) {
        BufferedInputStream bufferedInputStream;
        com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (b(str)) {
            return true;
        }
        ?? e = e(str);
        long j = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                e = (HttpURLConnection) new URL(e).openConnection();
                try {
                    com.kwad.sdk.core.network.m.a((URLConnection) e);
                    e.setRequestProperty("Accept-Language", "zh-CN");
                    e.setConnectTimeout(10000);
                    e.setReadTimeout(120000);
                    e.setUseCaches(false);
                    e.setDoInput(true);
                    e.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                    e.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    e.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.c());
                    e.setRequestProperty("BrowserUa", com.kwad.sdk.core.network.k.d());
                    e.setRequestProperty("SystemUa", com.kwad.sdk.core.network.k.a());
                    bufferedInputStream = new BufferedInputStream(e.getInputStream());
                } catch (Exception e2) {
                    e = e2;
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
                        j += read;
                    } while (j <= i);
                    break;
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                if (e != 0) {
                    e.disconnect();
                    return true;
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream2 = bufferedInputStream;
                com.kwad.sdk.core.d.a.b(e);
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "downloadUrlToStream file crash", e);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                if (e != 0) {
                    e.disconnect();
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
                if (e != 0) {
                    e.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            e = 0;
        } catch (Throwable th3) {
            th = th3;
            e = 0;
        }
    }

    public boolean b(String str) {
        j.a(str, "Url can't be null!");
        return d(str).exists();
    }

    public boolean c(String str) {
        g gVar = this.c.get(str);
        if (gVar != null) {
            gVar.a();
            this.c.remove(str);
            return true;
        }
        return false;
    }

    public File d(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.g;
        return new File(cVar.a, cVar.b.a(str));
    }
}
