package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static long f14593a;

    /* renamed from: b  reason: collision with root package name */
    private static long f14594b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f983a;

    /* renamed from: a  reason: collision with other field name */
    private final c f984a;

    /* loaded from: classes6.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f14595a;

        a(c cVar) {
            this.f14595a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.f14595a) {
                    this.f14595a.c = true;
                    this.f14595a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected int f14596a;

        public b(int i) {
            this.f14596a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f987b;
        private boolean c;

        /* renamed from: a  reason: collision with root package name */
        private volatile long f14597a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f986a = false;

        /* renamed from: b  reason: collision with root package name */
        private long f14598b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f985a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes6.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private int f14599a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f988a;

            /* renamed from: b  reason: collision with root package name */
            private int f14600b;
            private int c;

            private a() {
                this.f14599a = 256;
                this.f988a = new d[this.f14599a];
                this.f14600b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                for (int i = 0; i < this.f988a.length; i++) {
                    if (this.f988a[i] == dVar) {
                        return i;
                    }
                }
                return -1;
            }

            private void c() {
                int i = this.f14600b - 1;
                int i2 = i;
                for (int i3 = (i - 1) / 2; this.f988a[i2].f989a < this.f988a[i3].f989a; i3 = (i3 - 1) / 2) {
                    d dVar = this.f988a[i2];
                    this.f988a[i2] = this.f988a[i3];
                    this.f988a[i3] = dVar;
                    i2 = i3;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.f14600b && this.f14600b > 0) {
                    int i3 = (i2 + 1 >= this.f14600b || this.f988a[i2 + 1].f989a >= this.f988a[i2].f989a) ? i2 : i2 + 1;
                    if (this.f988a[i].f989a < this.f988a[i3].f989a) {
                        return;
                    }
                    d dVar = this.f988a[i];
                    this.f988a[i] = this.f988a[i3];
                    this.f988a[i3] = dVar;
                    i2 = (i3 * 2) + 1;
                    i = i3;
                }
            }

            public d a() {
                return this.f988a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m603a() {
                this.f988a = new d[this.f14599a];
                this.f14600b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.f14600b; i2++) {
                    if (this.f988a[i2].f14601a == i) {
                        this.f988a[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.f14600b; i2++) {
                    if (this.f988a[i2].f990a == bVar) {
                        this.f988a[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m604a(d dVar) {
                if (this.f988a.length == this.f14600b) {
                    d[] dVarArr = new d[this.f14600b * 2];
                    System.arraycopy(this.f988a, 0, dVarArr, 0, this.f14600b);
                    this.f988a = dVarArr;
                }
                d[] dVarArr2 = this.f988a;
                int i = this.f14600b;
                this.f14600b = i + 1;
                dVarArr2[i] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m605a() {
                return this.f14600b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m606a(int i) {
                for (int i2 = 0; i2 < this.f14600b; i2++) {
                    if (this.f988a[i2].f14601a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.f14600b) {
                    if (this.f988a[i].f992a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                if (i < 0 || i >= this.f14600b) {
                    return;
                }
                d[] dVarArr = this.f988a;
                d[] dVarArr2 = this.f988a;
                int i2 = this.f14600b - 1;
                this.f14600b = i2;
                dVarArr[i] = dVarArr2[i2];
                this.f988a[this.f14600b] = null;
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
            this.f985a.m604a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f987b = true;
            this.f985a.m603a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m602a() {
            return this.f986a && SystemClock.uptimeMillis() - this.f14597a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
            r8.f14597a = android.os.SystemClock.uptimeMillis();
            r8.f986a = true;
            r2.f990a.run();
            r8.f986a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b8, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
            r8.f987b = true;
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
                    if (this.f987b) {
                        return;
                    }
                    if (!this.f985a.m605a()) {
                        long a2 = g.a();
                        d a3 = this.f985a.a();
                        synchronized (a3.f991a) {
                            if (a3.f992a) {
                                this.f985a.b(0);
                            } else {
                                long j = a3.f989a - a2;
                                if (j > 0) {
                                    if (j > this.f14598b) {
                                        j = this.f14598b;
                                    }
                                    this.f14598b += 50;
                                    if (this.f14598b > 500) {
                                        this.f14598b = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException e) {
                                    }
                                } else {
                                    this.f14598b = 50L;
                                    synchronized (a3.f991a) {
                                        int a4 = this.f985a.a().f989a != a3.f989a ? this.f985a.a(a3) : 0;
                                        if (a3.f992a) {
                                            this.f985a.b(this.f985a.a(a3));
                                        } else {
                                            a3.a(a3.f989a);
                                            this.f985a.b(a4);
                                            a3.f989a = 0L;
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
        int f14601a;

        /* renamed from: a  reason: collision with other field name */
        long f989a;

        /* renamed from: a  reason: collision with other field name */
        b f990a;

        /* renamed from: a  reason: collision with other field name */
        final Object f991a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f992a;

        /* renamed from: b  reason: collision with root package name */
        private long f14602b;

        d() {
        }

        void a(long j) {
            synchronized (this.f991a) {
                this.f14602b = j;
            }
        }

        public boolean a() {
            boolean z = true;
            synchronized (this.f991a) {
                z = (this.f992a || this.f989a <= 0) ? false : false;
                this.f992a = true;
            }
            return z;
        }
    }

    static {
        f14593a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f14594b = f14593a;
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
        this.f984a = new c(str, z);
        this.f983a = new a(this.f984a);
    }

    public g(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (g.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > f14594b) {
                f14593a += elapsedRealtime - f14594b;
            }
            f14594b = elapsedRealtime;
            j = f14593a;
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
        synchronized (this.f984a) {
            if (this.f984a.f987b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = a() + j;
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.f14601a = bVar.f14596a;
            dVar.f990a = bVar;
            dVar.f989a = a2;
            this.f984a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m597a() {
        this.f984a.a();
    }

    public void a(int i) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f984a) {
            this.f984a.f985a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f984a) {
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
    public boolean m598a() {
        return this.f984a.m602a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m599a(int i) {
        boolean m606a;
        synchronized (this.f984a) {
            m606a = this.f984a.f985a.m606a(i);
        }
        return m606a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m600b() {
        synchronized (this.f984a) {
            this.f984a.f985a.m603a();
        }
    }
}
