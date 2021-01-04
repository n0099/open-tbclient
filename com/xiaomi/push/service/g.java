package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static long f14592a;

    /* renamed from: b  reason: collision with root package name */
    private static long f14593b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f982a;

    /* renamed from: a  reason: collision with other field name */
    private final c f983a;

    /* loaded from: classes6.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f14594a;

        a(c cVar) {
            this.f14594a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.f14594a) {
                    this.f14594a.c = true;
                    this.f14594a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected int f14595a;

        public b(int i) {
            this.f14595a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f986b;
        private boolean c;

        /* renamed from: a  reason: collision with root package name */
        private volatile long f14596a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f985a = false;

        /* renamed from: b  reason: collision with root package name */
        private long f14597b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f984a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes6.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private int f14598a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f987a;

            /* renamed from: b  reason: collision with root package name */
            private int f14599b;
            private int c;

            private a() {
                this.f14598a = 256;
                this.f987a = new d[this.f14598a];
                this.f14599b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                for (int i = 0; i < this.f987a.length; i++) {
                    if (this.f987a[i] == dVar) {
                        return i;
                    }
                }
                return -1;
            }

            private void c() {
                int i = this.f14599b - 1;
                int i2 = i;
                for (int i3 = (i - 1) / 2; this.f987a[i2].f988a < this.f987a[i3].f988a; i3 = (i3 - 1) / 2) {
                    d dVar = this.f987a[i2];
                    this.f987a[i2] = this.f987a[i3];
                    this.f987a[i3] = dVar;
                    i2 = i3;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.f14599b && this.f14599b > 0) {
                    int i3 = (i2 + 1 >= this.f14599b || this.f987a[i2 + 1].f988a >= this.f987a[i2].f988a) ? i2 : i2 + 1;
                    if (this.f987a[i].f988a < this.f987a[i3].f988a) {
                        return;
                    }
                    d dVar = this.f987a[i];
                    this.f987a[i] = this.f987a[i3];
                    this.f987a[i3] = dVar;
                    i2 = (i3 * 2) + 1;
                    i = i3;
                }
            }

            public d a() {
                return this.f987a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m592a() {
                this.f987a = new d[this.f14598a];
                this.f14599b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.f14599b; i2++) {
                    if (this.f987a[i2].f14600a == i) {
                        this.f987a[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.f14599b; i2++) {
                    if (this.f987a[i2].f989a == bVar) {
                        this.f987a[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m593a(d dVar) {
                if (this.f987a.length == this.f14599b) {
                    d[] dVarArr = new d[this.f14599b * 2];
                    System.arraycopy(this.f987a, 0, dVarArr, 0, this.f14599b);
                    this.f987a = dVarArr;
                }
                d[] dVarArr2 = this.f987a;
                int i = this.f14599b;
                this.f14599b = i + 1;
                dVarArr2[i] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m594a() {
                return this.f14599b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m595a(int i) {
                for (int i2 = 0; i2 < this.f14599b; i2++) {
                    if (this.f987a[i2].f14600a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.f14599b) {
                    if (this.f987a[i].f991a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                if (i < 0 || i >= this.f14599b) {
                    return;
                }
                d[] dVarArr = this.f987a;
                d[] dVarArr2 = this.f987a;
                int i2 = this.f14599b - 1;
                this.f14599b = i2;
                dVarArr[i] = dVarArr2[i2];
                this.f987a[this.f14599b] = null;
                c(i);
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f984a.m593a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f986b = true;
            this.f984a.m592a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m591a() {
            return this.f985a && SystemClock.uptimeMillis() - this.f14596a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
            r8.f14596a = android.os.SystemClock.uptimeMillis();
            r8.f985a = true;
            r2.f989a.run();
            r8.f985a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b8, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
            r8.f986b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
            throw r0;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (this) {
                    if (this.f986b) {
                        return;
                    }
                    if (!this.f984a.m594a()) {
                        long a2 = g.a();
                        d a3 = this.f984a.a();
                        synchronized (a3.f990a) {
                            if (a3.f991a) {
                                this.f984a.b(0);
                            } else {
                                long j = a3.f988a - a2;
                                if (j > 0) {
                                    if (j > this.f14597b) {
                                        j = this.f14597b;
                                    }
                                    this.f14597b += 50;
                                    if (this.f14597b > 500) {
                                        this.f14597b = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException e) {
                                    }
                                } else {
                                    this.f14597b = 50L;
                                    synchronized (a3.f990a) {
                                        int a4 = this.f984a.a().f988a != a3.f988a ? this.f984a.a(a3) : 0;
                                        if (a3.f991a) {
                                            this.f984a.b(this.f984a.a(a3));
                                        } else {
                                            a3.a(a3.f988a);
                                            this.f984a.b(a4);
                                            a3.f988a = 0L;
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
                        } catch (InterruptedException e2) {
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f14600a;

        /* renamed from: a  reason: collision with other field name */
        long f988a;

        /* renamed from: a  reason: collision with other field name */
        b f989a;

        /* renamed from: a  reason: collision with other field name */
        final Object f990a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f991a;

        /* renamed from: b  reason: collision with root package name */
        private long f14601b;

        d() {
        }

        void a(long j) {
            synchronized (this.f990a) {
                this.f14601b = j;
            }
        }

        public boolean a() {
            boolean z = true;
            synchronized (this.f990a) {
                z = (this.f991a || this.f988a <= 0) ? false : false;
                this.f991a = true;
            }
            return z;
        }
    }

    static {
        f14592a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f14593b = f14592a;
    }

    public g() {
        this(false);
    }

    public g(String str) {
        this(str, false);
    }

    public g(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f983a = new c(str, z);
        this.f982a = new a(this.f983a);
    }

    public g(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (g.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > f14593b) {
                f14592a += elapsedRealtime - f14593b;
            }
            f14593b = elapsedRealtime;
            j = f14592a;
        }
        return j;
    }

    private static synchronized long b() {
        long j;
        synchronized (g.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f983a) {
            if (this.f983a.f986b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = a() + j;
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.f14600a = bVar.f14595a;
            dVar.f989a = bVar;
            dVar.f988a = a2;
            this.f983a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m586a() {
        this.f983a.a();
    }

    public void a(int i) {
        synchronized (this.f983a) {
            this.f983a.f984a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f983a) {
            this.f983a.f984a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f983a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delay < 0: " + j);
        }
        b(bVar, j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m587a() {
        return this.f983a.m591a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m588a(int i) {
        boolean m595a;
        synchronized (this.f983a) {
            m595a = this.f983a.f984a.m595a(i);
        }
        return m595a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m589b() {
        synchronized (this.f983a) {
            this.f983a.f984a.m592a();
        }
    }
}
