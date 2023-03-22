package com.kwad.sdk.ip.direct;

import android.os.SystemClock;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.kwad.sdk.utils.bd;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public final class b {
    public static int aiY = 80;
    public static int port = 80;

    /* loaded from: classes8.dex */
    public static class a extends Thread {
        public LinkedList aja = new LinkedList();
        public volatile boolean ajb = false;
        public Selector aiZ = Selector.open();

        public a() {
            setName("Connector");
        }

        private void xK() {
            synchronized (this.aja) {
                while (this.aja.size() > 0) {
                    C0639b c0639b = (C0639b) this.aja.removeFirst();
                    c0639b.ajd.register(this.aiZ, 8, c0639b);
                }
            }
        }

        private void xL() {
            Iterator<SelectionKey> it = this.aiZ.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0639b c0639b = (C0639b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0639b.ajh = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bd.b(socketChannel);
                    c0639b.aje = th;
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0035 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0005 */
        /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.nio.channels.Selector */
        /* JADX WARN: Multi-variable type inference failed */
        public final void a(C0639b c0639b) {
            SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c0639b.ajc);
                    c0639b.ajd = socketChannel;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c0639b.ajg = elapsedRealtime;
                    if (connect) {
                        c0639b.ajh = elapsedRealtime;
                        bd.b(socketChannel);
                        c0639b = c0639b;
                    } else {
                        synchronized (this.aja) {
                            this.aja.add(c0639b);
                        }
                        if (this.aiZ == null) {
                            return;
                        }
                        try {
                            Selector selector = this.aiZ;
                            selector.wakeup();
                            c0639b = selector;
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bd.b(socketChannel);
                    c0639b.aje = th;
                }
            } catch (Throwable th2) {
                th = th2;
                socketChannel = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aiZ.select() > 0) {
                        xL();
                    }
                    xK();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.ajb) {
                    if (this.aiZ != null) {
                        try {
                            this.aiZ.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        public final void shutdown() {
            this.ajb = true;
            Selector selector = this.aiZ;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0639b {
        public InetSocketAddress ajc;
        public SocketChannel ajd;
        public Throwable aje;
        public float ajf;
        public long ajg;
        public long ajh = 0;
        public boolean aji = false;
        public boolean success;

        public C0639b(String str) {
            try {
                this.ajc = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aje = th;
            }
        }

        public final void xM() {
            String str;
            if (this.ajh != 0) {
                str = Long.toString(this.ajh - this.ajg) + "ms";
                this.ajf = (float) (this.ajh - this.ajg);
                this.success = true;
            } else {
                Throwable th = this.aje;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.e.b.d("IpDirect_Ping", this.ajc + ZeusCrashHandler.NAME_SEPERATOR + str);
            this.aji = true;
        }
    }

    public static c d(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.e.b.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < cVar.xN(); i++) {
                C0639b c0639b = new C0639b(str);
                linkedList.add(c0639b);
                try {
                    aVar.a(c0639b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    float f = 0.0f;
                    Iterator it = linkedList.iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        C0639b c0639b2 = (C0639b) it.next();
                        c0639b2.xM();
                        z &= c0639b2.success;
                        cVar.aU(z);
                        f += c0639b2.ajf;
                    }
                    com.kwad.sdk.core.e.b.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.g(f / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
