package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.tieba.ms;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.kwad.sdk.utils.bn;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public final class b {
    public static Handler aHi = new Handler(Looper.getMainLooper());
    public static int aHs = 80;
    public static int port = 80;

    /* loaded from: classes10.dex */
    public static class a extends Thread {
        public LinkedList aHu = new LinkedList();
        public volatile boolean aHv = false;
        public Selector aHt = Selector.open();

        public a() {
            setName("Connector");
        }

        private void HE() {
            synchronized (this.aHu) {
                while (this.aHu.size() > 0) {
                    C0723b c0723b = (C0723b) this.aHu.removeFirst();
                    c0723b.aHz.register(this.aHt, 8, c0723b);
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aHt.select() > 0) {
                        HF();
                    }
                    HE();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.aHv) {
                    if (this.aHt != null) {
                        try {
                            this.aHt.close();
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
            this.aHv = true;
            Selector selector = this.aHt;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }

        private void HF() {
            Iterator<SelectionKey> it = this.aHt.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0723b c0723b = (C0723b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0723b.aHE = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bn.c(socketChannel);
                    c0723b.aHA = th;
                }
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, CONSTRUCTOR, IGET, INVOKE] complete} */
        public final void a(C0723b c0723b) {
            final SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c0723b.aHy);
                    c0723b.aHz = socketChannel;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c0723b.aHD = elapsedRealtime;
                    if (connect) {
                        c0723b.aHE = elapsedRealtime;
                        bn.c(socketChannel);
                    } else {
                        synchronized (this.aHu) {
                            this.aHu.add(c0723b);
                        }
                        if (this.aHt != null) {
                            try {
                                this.aHt.wakeup();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        bn.c(socketChannel);
                        c0723b.aHA = th;
                        try {
                            b.aHi.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bn.c(socketChannel);
                                }
                            }, c0723b.aHC);
                        } catch (Throwable unused2) {
                        }
                    } finally {
                        try {
                            b.aHi.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bn.c(socketChannel);
                                }
                            }, c0723b.aHC);
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                socketChannel = null;
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0723b {
        public Throwable aHA;
        public float aHB;
        public long aHC;
        public long aHD;
        public long aHE = 0;
        public boolean aHF = false;
        public InetSocketAddress aHy;
        public SocketChannel aHz;
        public boolean success;

        public C0723b(String str) {
            try {
                this.aHy = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aHA = th;
            }
        }

        public final void HG() {
            String str;
            if (this.aHE != 0) {
                str = Long.toString(this.aHE - this.aHD) + ms.c;
                this.aHB = (float) (this.aHE - this.aHD);
                this.success = true;
            } else {
                Throwable th = this.aHA;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.e.c.d("IpDirect_Ping", this.aHy + ZeusCrashHandler.NAME_SEPERATOR + str);
            this.aHF = true;
        }
    }

    public static c d(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.e.c.d("IpDirect_Ping", "ping:" + str);
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
            for (int i = 0; i < cVar.HH(); i++) {
                C0723b c0723b = new C0723b(str);
                c0723b.aHC = j + j2;
                linkedList.add(c0723b);
                try {
                    aVar.a(c0723b);
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
                        C0723b c0723b2 = (C0723b) it.next();
                        c0723b2.HG();
                        z &= c0723b2.success;
                        cVar.bB(z);
                        f += c0723b2.aHB;
                    }
                    com.kwad.sdk.core.e.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.i(f / ((float) linkedList.size()));
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
