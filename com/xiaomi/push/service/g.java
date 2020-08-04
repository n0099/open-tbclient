package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes9.dex */
public class g {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f908a;

    /* renamed from: a  reason: collision with other field name */
    private final c f909a;

    /* loaded from: classes9.dex */
    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected void finalize() {
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

    /* loaded from: classes9.dex */
    public static abstract class b implements Runnable {
        protected int a;

        public b(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f912b;
        private boolean c;
        private volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f911a = false;
        private long b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f910a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes9.dex */
        public static final class a {
            private int a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f913a;
            private int b;
            private int c;

            private a() {
                this.a = 256;
                this.f913a = new d[this.a];
                this.b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                for (int i = 0; i < this.f913a.length; i++) {
                    if (this.f913a[i] == dVar) {
                        return i;
                    }
                }
                return -1;
            }

            private void c() {
                int i = this.b - 1;
                for (int i2 = (i - 1) / 2; this.f913a[i].f914a < this.f913a[i2].f914a; i2 = (i2 - 1) / 2) {
                    d dVar = this.f913a[i];
                    this.f913a[i] = this.f913a[i2];
                    this.f913a[i2] = dVar;
                    i = i2;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.b && this.b > 0) {
                    int i3 = (i2 + 1 >= this.b || this.f913a[i2 + 1].f914a >= this.f913a[i2].f914a) ? i2 : i2 + 1;
                    if (this.f913a[i].f914a < this.f913a[i3].f914a) {
                        return;
                    }
                    d dVar = this.f913a[i];
                    this.f913a[i] = this.f913a[i3];
                    this.f913a[i3] = dVar;
                    i2 = (i3 * 2) + 1;
                    i = i3;
                }
            }

            public d a() {
                return this.f913a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m568a() {
                this.f913a = new d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f913a[i2].a == i) {
                        this.f913a[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f913a[i2].f915a == bVar) {
                        this.f913a[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m569a(d dVar) {
                if (this.f913a.length == this.b) {
                    d[] dVarArr = new d[this.b * 2];
                    System.arraycopy(this.f913a, 0, dVarArr, 0, this.b);
                    this.f913a = dVarArr;
                }
                d[] dVarArr2 = this.f913a;
                int i = this.b;
                this.b = i + 1;
                dVarArr2[i] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m570a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m571a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f913a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f913a[i].f917a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                if (i < 0 || i >= this.b) {
                    return;
                }
                d[] dVarArr = this.f913a;
                d[] dVarArr2 = this.f913a;
                int i2 = this.b - 1;
                this.b = i2;
                dVarArr[i] = dVarArr2[i2];
                this.f913a[this.b] = null;
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
            this.f910a.m569a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f912b = true;
            this.f910a.m568a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m567a() {
            return this.f911a && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
            r8.a = android.os.SystemClock.uptimeMillis();
            r8.f911a = true;
            r2.f915a.run();
            r8.f911a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b8, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
            r8.f912b = true;
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
                    if (this.f912b) {
                        return;
                    }
                    if (!this.f910a.m570a()) {
                        long a2 = g.a();
                        d a3 = this.f910a.a();
                        synchronized (a3.f916a) {
                            if (a3.f917a) {
                                this.f910a.b(0);
                            } else {
                                long j = a3.f914a - a2;
                                if (j > 0) {
                                    if (j > this.b) {
                                        j = this.b;
                                    }
                                    this.b += 50;
                                    if (this.b > 500) {
                                        this.b = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException e) {
                                    }
                                } else {
                                    this.b = 50L;
                                    synchronized (a3.f916a) {
                                        int a4 = this.f910a.a().f914a != a3.f914a ? this.f910a.a(a3) : 0;
                                        if (a3.f917a) {
                                            this.f910a.b(this.f910a.a(a3));
                                        } else {
                                            a3.a(a3.f914a);
                                            this.f910a.b(a4);
                                            a3.f914a = 0L;
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
    /* loaded from: classes9.dex */
    public static class d {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f914a;

        /* renamed from: a  reason: collision with other field name */
        b f915a;

        /* renamed from: a  reason: collision with other field name */
        final Object f916a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f917a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f916a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z = true;
            synchronized (this.f916a) {
                z = (this.f917a || this.f914a <= 0) ? false : false;
                this.f917a = true;
            }
            return z;
        }
    }

    static {
        a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        b = a;
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
        this.f909a = new c(str, z);
        this.f908a = new a(this.f909a);
    }

    public g(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (g.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > b) {
                a += elapsedRealtime - b;
            }
            b = elapsedRealtime;
            j = a;
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
        synchronized (this.f909a) {
            if (this.f909a.f912b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = a() + j;
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.a = bVar.a;
            dVar.f915a = bVar;
            dVar.f914a = a2;
            this.f909a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m562a() {
        this.f909a.a();
    }

    public void a(int i) {
        synchronized (this.f909a) {
            this.f909a.f910a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f909a) {
            this.f909a.f910a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f909a) {
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
    public boolean m563a() {
        return this.f909a.m567a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m564a(int i) {
        boolean m571a;
        synchronized (this.f909a) {
            m571a = this.f909a.f910a.m571a(i);
        }
        return m571a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m565b() {
        synchronized (this.f909a) {
            this.f909a.f910a.m568a();
        }
    }
}
