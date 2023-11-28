package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.ap;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public final class f {
    public final Object aAR;
    public final ExecutorService aAS;
    public final Map<String, g> aAT;
    public final ServerSocket aAU;
    public final Thread aAV;
    public final com.kwad.sdk.core.videocache.c aAW;
    public final int port;

    /* loaded from: classes10.dex */
    public static final class a {
        public File aAD;
        public com.kwad.sdk.core.videocache.d.c aAG;
        public int aAI;
        public Context context;
        public int aAJ = 0;
        public com.kwad.sdk.core.videocache.a.a aAF = new com.kwad.sdk.core.videocache.a.g(536870912);
        public com.kwad.sdk.core.videocache.a.c aAE = new com.kwad.sdk.core.videocache.a.f();
        public com.kwad.sdk.core.videocache.b.b aAH = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.context = context;
            this.aAD = o.bk(context);
        }

        public final a ak(long j) {
            this.aAF = new com.kwad.sdk.core.videocache.a.g(536870912L);
            return this;
        }

        public final a cV(int i) {
            this.aAI = i;
            return this;
        }

        public final a cW(int i) {
            this.aAJ = i;
            return this;
        }

        private com.kwad.sdk.core.videocache.c Fj() {
            return new com.kwad.sdk.core.videocache.c(this.aAD, this.aAE, this.aAF, this.aAG, this.aAH, this.aAI, this.aAJ);
        }

        public final f Fi() {
            this.aAG = com.kwad.sdk.core.videocache.d.d.j(this.context, this.aAJ);
            return new f(Fj(), (byte) 0);
        }
    }

    /* loaded from: classes10.dex */
    public final class b implements Runnable {
        public final Socket aAX;

        public b(Socket socket) {
            this.aAX = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aAX);
        }
    }

    /* loaded from: classes10.dex */
    public final class c implements Runnable {
        public final CountDownLatch aAZ;

        public c(CountDownLatch countDownLatch) {
            this.aAZ = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aAZ.countDown();
                f.this.Fg();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    public f(com.kwad.sdk.core.videocache.c cVar) {
        this.aAR = new Object();
        this.aAS = GlobalThreadPools.Ez();
        this.aAT = new ConcurrentHashMap();
        this.aAW = (com.kwad.sdk.core.videocache.c) ap.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aAU = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aAV = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.aAS.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    private String f(String str, boolean z) {
        if (T(str).exists()) {
            File T2 = T(str);
            r(T2);
            return Uri.fromFile(T2).toString();
        }
        return ej(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fg() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aAU.accept();
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aAS.submit(new b(accept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private int Fh() {
        int i;
        synchronized (this.aAR) {
            i = 0;
            for (g gVar : this.aAT.values()) {
                i += gVar.Fh();
            }
        }
        return i;
    }

    private File T(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.aAW;
        return new File(cVar.aAD, cVar.aAE.generate(str));
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    public static void d(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException unused) {
            com.kwad.sdk.core.e.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private String ej(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), l.encode(str));
    }

    private File ek(String str) {
        File file = this.aAW.aAD;
        return new File(file, this.aAW.aAE.generate(str) + ".download");
    }

    private g el(String str) {
        g gVar;
        synchronized (this.aAR) {
            gVar = this.aAT.get(str);
            if (gVar == null) {
                gVar = new g(str, this.aAW);
                this.aAT.put(str, gVar);
            }
        }
        return gVar;
    }

    public static void onError(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
    }

    private void r(File file) {
        try {
            this.aAW.aAF.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.e.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public final String ef(String str) {
        return f(str, true);
    }

    public final boolean eg(String str) {
        ap.av(str, "Url can't be null!");
        return T(str).exists();
    }

    public final boolean eh(String str) {
        ap.av(str, "Url can't be null!");
        if (!ek(str).exists() && !T(str).exists()) {
            return false;
        }
        return true;
    }

    public final boolean ei(String str) {
        g gVar = this.aAT.get(str);
        if (gVar != null) {
            gVar.shutdown();
            this.aAT.remove(str);
            return true;
        }
        return false;
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
                d b2 = d.b(socket.getInputStream());
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Request to cache proxy:" + b2);
                el(l.decode(b2.uri)).a(b2, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            r0 = Fh();
            sb.append((int) r0);
            socket = sb.toString();
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", ((String) r0) + Fh());
            throw th;
        }
    }

    public final boolean a(String str, long j, a.C0709a c0709a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (eg(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(ej(str), null, c0709a, j, adHttpResponseListener);
    }
}
