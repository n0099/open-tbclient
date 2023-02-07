package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.videocache.b.a;
import com.kwad.sdk.utils.am;
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
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes8.dex */
public final class f {
    public final Object aet;
    public final ExecutorService aeu;
    public final Map<String, g> aev;
    public final ServerSocket aew;
    public final Thread aex;
    public final com.kwad.sdk.core.videocache.c aey;
    public final int port;

    /* loaded from: classes8.dex */
    public static final class a {
        public File aeh;
        public com.kwad.sdk.core.videocache.c.b aek;
        public com.kwad.sdk.core.videocache.kwai.a aej = new com.kwad.sdk.core.videocache.kwai.g(536870912);
        public com.kwad.sdk.core.videocache.kwai.c aei = new com.kwad.sdk.core.videocache.kwai.f();
        public com.kwad.sdk.core.videocache.a.b ael = new com.kwad.sdk.core.videocache.a.a();

        public a(Context context) {
            this.aek = com.kwad.sdk.core.videocache.c.c.bE(context);
            this.aeh = n.bB(context);
        }

        private com.kwad.sdk.core.videocache.c vN() {
            return new com.kwad.sdk.core.videocache.c(this.aeh, this.aei, this.aej, this.aek, this.ael);
        }

        public final a H(long j) {
            this.aej = new com.kwad.sdk.core.videocache.kwai.g(104857600L);
            return this;
        }

        public final f vM() {
            return new f(vN(), (byte) 0);
        }
    }

    /* loaded from: classes8.dex */
    public final class b implements Runnable {
        public final Socket aez;

        public b(Socket socket) {
            this.aez = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aez);
        }
    }

    /* loaded from: classes8.dex */
    public final class c implements Runnable {
        public final CountDownLatch aeB;

        public c(CountDownLatch countDownLatch) {
            this.aeB = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aeB.countDown();
                f.this.vK();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
            }
        }
    }

    public f(com.kwad.sdk.core.videocache.c cVar) {
        this.aet = new Object();
        this.aeu = com.kwad.sdk.core.threads.b.vo();
        this.aev = new ConcurrentHashMap();
        this.aey = (com.kwad.sdk.core.videocache.c) am.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aew = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aex = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.aeu.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
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
                d c2 = d.c(socket.getInputStream());
                com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", "Request to cache proxy:" + c2);
                cG(k.decode(c2.uri)).a(c2, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            r0 = vL();
            sb.append((int) r0);
            socket = sb.toString();
            com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", ((String) r0) + vL());
            throw th;
        }
    }

    private File aZ(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.aey;
        return new File(cVar.aeh, cVar.aei.generate(str));
    }

    private String b(String str, boolean z) {
        if (aZ(str).exists()) {
            File aZ = aZ(str);
            o(aZ);
            return Uri.fromFile(aZ).toString();
        }
        return cE(str);
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
            com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private boolean cB(String str) {
        am.T(str, "Url can't be null!");
        return aZ(str).exists();
    }

    private String cE(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), k.encode(str));
    }

    private File cF(String str) {
        File file = this.aey.aeh;
        return new File(file, this.aey.aei.generate(str) + ".download");
    }

    private g cG(String str) {
        g gVar;
        synchronized (this.aet) {
            gVar = this.aev.get(str);
            if (gVar == null) {
                gVar = new g(str, this.aey);
                this.aev.put(str, gVar);
            }
        }
        return gVar;
    }

    public static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.e.b.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private void o(File file) {
        try {
            this.aey.aej.p(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.e.b.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public static void onError(Throwable th) {
        com.kwad.sdk.core.e.b.e("HttpProxyCacheServer", "HttpProxyCacheServer error");
        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aew.accept();
                com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aeu.submit(new b(accept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private int vL() {
        int i;
        synchronized (this.aet) {
            i = 0;
            for (g gVar : this.aev.values()) {
                i += gVar.vL();
            }
        }
        return i;
    }

    public final boolean a(String str, int i, a.C0639a c0639a) {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.e.b.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (cB(str)) {
            return true;
        }
        long j = 0;
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(cE(str)).openConnection();
            try {
                q.wrapHttpURLConnection(httpURLConnection);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("User-Agent", o.getUserAgent());
                httpURLConnection.setRequestProperty("BrowserUa", o.tD());
                httpURLConnection.setRequestProperty("SystemUa", o.tC());
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
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        c0639a.Qd = Log.getStackTraceString(th);
                        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        com.kwad.sdk.core.e.b.e("HttpProxyCacheServer", "downloadUrlToStream file crash", th);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                        return false;
                    } catch (Throwable th2) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
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

    public final String cA(String str) {
        return b(str, true);
    }

    public final boolean cC(String str) {
        am.T(str, "Url can't be null!");
        return cF(str).exists() || aZ(str).exists();
    }

    public final boolean cD(String str) {
        g gVar = this.aev.get(str);
        if (gVar != null) {
            gVar.shutdown();
            this.aev.remove(str);
            return true;
        }
        return false;
    }
}
