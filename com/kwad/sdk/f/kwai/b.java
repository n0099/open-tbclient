package com.kwad.sdk.f.kwai;

import android.os.SystemClock;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class b {
    public static int a = 80;
    public static int b = 80;

    /* loaded from: classes5.dex */
    public static class a extends Thread {
        public LinkedList b = new LinkedList();
        public volatile boolean c = false;
        public Selector a = Selector.open();

        public a() {
            setName("Connector");
        }

        private void b() {
            synchronized (this.b) {
                while (this.b.size() > 0) {
                    C0552b c0552b = (C0552b) this.b.removeFirst();
                    c0552b.b.register(this.a, 8, c0552b);
                }
            }
        }

        private void c() {
            Iterator<SelectionKey> it = this.a.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0552b c0552b = (C0552b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0552b.e = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    socketChannel.close();
                    c0552b.c = th;
                }
            }
        }

        public final void a() {
            this.c = true;
            this.a.wakeup();
        }

        public final void a(C0552b c0552b) {
            SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c0552b.a);
                    c0552b.b = socketChannel;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c0552b.d = elapsedRealtime;
                    if (connect) {
                        c0552b.e = elapsedRealtime;
                        socketChannel.close();
                        return;
                    }
                    synchronized (this.b) {
                        this.b.add(c0552b);
                    }
                    this.a.wakeup();
                } catch (Throwable th) {
                    th = th;
                    if (socketChannel != null) {
                        try {
                            socketChannel.close();
                        } catch (IOException unused) {
                        }
                    }
                    c0552b.c = th;
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
                    if (this.a.select() > 0) {
                        c();
                    }
                    b();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.c) {
                    this.a.close();
                    return;
                }
                continue;
            }
        }
    }

    /* renamed from: com.kwad.sdk.f.kwai.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0552b {
        public InetSocketAddress a;
        public SocketChannel b;
        public Throwable c;
        public long d;
        public long e = 0;
        public boolean f = false;
        public float g;
        public boolean h;

        public C0552b(String str) {
            try {
                this.a = new InetSocketAddress(InetAddress.getByName(str), b.b);
            } catch (Throwable th) {
                this.c = th;
            }
        }

        public final void a() {
            String str;
            if (this.e != 0) {
                str = Long.toString(this.e - this.d) + "ms";
                this.g = (float) (this.e - this.d);
                this.h = true;
            } else {
                Throwable th = this.c;
                if (th != null) {
                    str = th.toString();
                    this.h = false;
                } else {
                    this.h = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.d.b.a("IpDirect_Ping", this.a + ZeusCrashHandler.NAME_SEPERATOR + str);
            this.f = true;
        }
    }

    public static c a(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.b.a("IpDirect_Ping", "ping:" + str);
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
        aVar.start();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cVar.a(); i++) {
            C0552b c0552b = new C0552b(str);
            linkedList.add(c0552b);
            aVar.a(c0552b);
        }
        try {
            Thread.sleep(j + j2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        aVar.a();
        try {
            aVar.join();
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        float f = 0.0f;
        Iterator it = linkedList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            C0552b c0552b2 = (C0552b) it.next();
            c0552b2.a();
            z &= c0552b2.h;
            cVar.a(z);
            f += c0552b2.g;
        }
        com.kwad.sdk.core.d.b.a("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
        cVar.a(f / ((float) linkedList.size()));
        com.kwad.sdk.core.d.b.a("IpDirect_Ping", cVar.toString() + "*" + Thread.currentThread().getName());
        return cVar;
    }
}
