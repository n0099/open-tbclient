package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes10.dex */
public class p {
    public static long a;
    public static long b;
    public static long c;

    /* renamed from: a  reason: collision with other field name */
    public final a f988a;

    /* renamed from: a  reason: collision with other field name */
    public final c f989a;

    /* loaded from: classes10.dex */
    public static final class a {
        public final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.a) {
                    this.a.c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b implements Runnable {
        public int a;

        public b(int i) {
            this.a = i;
        }
    }

    /* loaded from: classes10.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        public boolean f992b;
        public boolean c;
        public volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f991a = false;
        public long b = 50;

        /* renamed from: a  reason: collision with other field name */
        public a f990a = new a();

        /* loaded from: classes10.dex */
        public static final class a {
            public int a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f993a;
            public int b;
            public int c;

            public a() {
                this.a = 256;
                this.f993a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f993a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void b(d dVar) {
                Intent a;
                b bVar = dVar.f995a;
                int i = bVar.a;
                if (i == 8) {
                    XMPushService.d dVar2 = (XMPushService.d) bVar;
                    if (dVar2.a().f371a != null) {
                        dVar2.a().f371a.f898b = System.currentTimeMillis();
                        dVar2.a().f371a.b = a(dVar);
                    }
                } else if (i == 15 && (a = ((XMPushService.i) bVar).a()) != null && "10".equals(a.getStringExtra("ext_chid"))) {
                    a.putExtra("enqueue", System.currentTimeMillis());
                    a.putExtra("num", a(dVar));
                }
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f993a;
                    if (dVarArr[i].f994a >= dVarArr[i2].f994a) {
                        return;
                    }
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f993a;
                        if (dVarArr[i4].f994a < dVarArr[i2].f994a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f993a;
                    if (dVarArr2[i].f994a < dVarArr2[i2].f994a) {
                        return;
                    }
                    d dVar = dVarArr2[i];
                    dVarArr2[i] = dVarArr2[i2];
                    dVarArr2[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public d a() {
                return this.f993a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m841a() {
                this.f993a = new d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f993a;
                    if (dVarArr[i2].a == i) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f993a;
                    if (dVarArr[i2].f995a == bVar) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m842a(d dVar) {
                d[] dVarArr = this.f993a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f993a = dVarArr2;
                }
                d[] dVarArr3 = this.f993a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
                b(dVar);
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m843a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m844a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f993a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f993a[i].f997a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                d[] dVarArr = this.f993a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f990a.m842a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f992b = true;
            this.f990a.m841a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m840a() {
            return this.f991a && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f991a = true;
            r2.f995a.run();
            r10.f991a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a6, code lost:
            r10.f992b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a9, code lost:
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (this) {
                    if (this.f992b) {
                        return;
                    }
                    if (!this.f990a.m843a()) {
                        long a2 = p.a();
                        d a3 = this.f990a.a();
                        synchronized (a3.f996a) {
                            if (a3.f997a) {
                                this.f990a.b(0);
                            } else {
                                long j = a3.f994a - a2;
                                if (j > 0) {
                                    if (j > this.b) {
                                        j = this.b;
                                    }
                                    long j2 = this.b + 50;
                                    this.b = j2;
                                    if (j2 > 500) {
                                        this.b = 500L;
                                    }
                                    wait(j);
                                } else {
                                    this.b = 50L;
                                    synchronized (a3.f996a) {
                                        int a4 = this.f990a.a().f994a != a3.f994a ? this.f990a.a(a3) : 0;
                                        if (a3.f997a) {
                                            this.f990a.b(this.f990a.a(a3));
                                        } else {
                                            a3.a(a3.f994a);
                                            this.f990a.b(a4);
                                            a3.f994a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.c) {
                        return;
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f994a;

        /* renamed from: a  reason: collision with other field name */
        public b f995a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f996a = new Object();

        /* renamed from: a  reason: collision with other field name */
        public boolean f997a;
        public long b;

        public void a(long j) {
            synchronized (this.f996a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f996a) {
                z = !this.f997a && this.f994a > 0;
                this.f997a = true;
            }
            return z;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        a = elapsedRealtime;
        b = elapsedRealtime;
    }

    public p() {
        this(false);
    }

    public p(String str) {
        this(str, false);
    }

    public p(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f989a = cVar;
        this.f988a = new a(cVar);
    }

    public p(boolean z) {
        this("Timer-" + b(), z);
    }

    public static synchronized long a() {
        long j;
        synchronized (p.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > b) {
                a += elapsedRealtime - b;
            }
            b = elapsedRealtime;
            j = a;
        }
        return j;
    }

    public static synchronized long b() {
        long j;
        synchronized (p.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f989a) {
            if (this.f989a.f992b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.a = bVar.a;
            dVar.f995a = bVar;
            dVar.f994a = a2;
            this.f989a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m835a() {
        com.xiaomi.channel.commonutils.logger.b.m190a("quit. finalizer:" + this.f988a);
        this.f989a.a();
    }

    public void a(int i) {
        synchronized (this.f989a) {
            this.f989a.f990a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f989a) {
            this.f989a.f990a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f989a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m836a() {
        return this.f989a.m840a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m837a(int i) {
        boolean m844a;
        synchronized (this.f989a) {
            m844a = this.f989a.f990a.m844a(i);
        }
        return m844a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m838b() {
        synchronized (this.f989a) {
            this.f989a.f990a.m841a();
        }
    }
}
