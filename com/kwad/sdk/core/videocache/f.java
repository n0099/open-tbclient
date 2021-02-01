package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.kwai.video.player.KsMediaMeta;
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
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f9489a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f9490b;
    private final Map<String, g> c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final com.kwad.sdk.core.videocache.c g;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private File f9491a;
        private com.kwad.sdk.core.videocache.d.b d;
        private com.kwad.sdk.core.videocache.a.a c = new com.kwad.sdk.core.videocache.a.g(KsMediaMeta.AV_CH_STEREO_LEFT);

        /* renamed from: b  reason: collision with root package name */
        private com.kwad.sdk.core.videocache.a.c f9492b = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b e = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.d = com.kwad.sdk.core.videocache.d.c.a(context);
            this.f9491a = o.a(context);
        }

        private com.kwad.sdk.core.videocache.c b() {
            return new com.kwad.sdk.core.videocache.c(this.f9491a, this.f9492b, this.c, this.d, this.e);
        }

        public a a(long j) {
            this.c = new com.kwad.sdk.core.videocache.a.g(j);
            return this;
        }

        public f a() {
            return new f(b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Socket f9494b;

        public b(Socket socket) {
            this.f9494b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.a(this.f9494b);
        }
    }

    /* loaded from: classes3.dex */
    private final class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CountDownLatch f9496b;

        public c(CountDownLatch countDownLatch) {
            this.f9496b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f9496b.countDown();
                f.this.a();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
        }
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.f9489a = new Object();
        this.f9490b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        this.g = (com.kwad.sdk.core.videocache.c) j.a(cVar);
        try {
            this.d = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.e = this.d.getLocalPort();
            i.a("127.0.0.1", this.e);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f = new Thread(new c(countDownLatch));
            this.f.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.f9490b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.d.accept();
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Accept new socket " + accept);
                this.f9490b.submit(new b(accept));
            } catch (IOException e) {
                a(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.d("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    private void a(Throwable th) {
        com.kwad.sdk.core.d.a.d("HttpProxyCacheServer", "HttpProxyCacheServer error");
        com.kwad.sdk.core.d.a.a(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        try {
            try {
                d a2 = d.a(socket.getInputStream());
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Request to cache proxy:" + a2);
                f(l.c(a2.f9484a)).a(a2, socket);
                b(socket);
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Opened connections: " + b());
            } catch (ProxyCacheException e) {
                e = e;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Opened connections: " + b());
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                b(socket);
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Opened connections: " + b());
            } catch (IOException e3) {
                e = e3;
                a(new ProxyCacheException("Error processing request", e));
                b(socket);
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Opened connections: " + b());
            }
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Opened connections: " + b());
            throw th;
        }
    }

    private int b() {
        int i;
        synchronized (this.f9489a) {
            i = 0;
            for (g gVar : this.c.values()) {
                i = gVar.b() + i;
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
        } catch (SocketException e) {
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
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.c("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
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
        synchronized (this.f9489a) {
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        Exception e;
        boolean z;
        if (b(str)) {
            return true;
        }
        long j = 0;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(e(str)).openConnection();
            try {
                httpURLConnection2.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.a());
                bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                try {
                    byte[] bArr = new byte[1024];
                    do {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j += read;
                    } while (j <= i);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        z = true;
                    } else {
                        z = true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = httpURLConnection2;
                    try {
                        com.kwad.sdk.core.d.a.a(e);
                        com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "downloadUrlToStream file crash", e);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            z = false;
                        } else {
                            z = false;
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                httpURLConnection = httpURLConnection2;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                bufferedInputStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            httpURLConnection = null;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
        return z;
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
        return new File(this.g.f9481a, this.g.f9482b.a(str));
    }
}
