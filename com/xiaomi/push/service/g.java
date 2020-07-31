package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes9.dex */
public class g {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f905a;

    /* renamed from: a  reason: collision with other field name */
    private final c f906a;

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
        private boolean f909b;
        private boolean c;
        private volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f908a = false;
        private long b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f907a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes9.dex */
        public static final class a {
            private int a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f910a;
            private int b;
            private int c;

            private a() {
                this.a = 256;
                this.f910a = new d[this.a];
                this.b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                for (int i = 0; i < this.f910a.length; i++) {
                    if (this.f910a[i] == dVar) {
                        return i;
                    }
                }
                return -1;
            }

            private void c() {
                int i = this.b - 1;
                for (int i2 = (i - 1) / 2; this.f910a[i].f911a < this.f910a[i2].f911a; i2 = (i2 - 1) / 2) {
                    d dVar = this.f910a[i];
                    this.f910a[i] = this.f910a[i2];
                    this.f910a[i2] = dVar;
                    i = i2;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.b && this.b > 0) {
                    int i3 = (i2 + 1 >= this.b || this.f910a[i2 + 1].f911a >= this.f910a[i2].f911a) ? i2 : i2 + 1;
                    if (this.f910a[i].f911a < this.f910a[i3].f911a) {
                        return;
                    }
                    d dVar = this.f910a[i];
                    this.f910a[i] = this.f910a[i3];
                    this.f910a[i3] = dVar;
                    i2 = (i3 * 2) + 1;
                    i = i3;
                }
            }

            public d a() {
                return this.f910a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m568a() {
                this.f910a = new d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f910a[i2].a == i) {
                        this.f910a[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f910a[i2].f912a == bVar) {
                        this.f910a[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m569a(d dVar) {
                if (this.f910a.length == this.b) {
                    d[] dVarArr = new d[this.b * 2];
                    System.arraycopy(this.f910a, 0, dVarArr, 0, this.b);
                    this.f910a = dVarArr;
                }
                d[] dVarArr2 = this.f910a;
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
                    if (this.f910a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f910a[i].f914a) {
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
                d[] dVarArr = this.f910a;
                d[] dVarArr2 = this.f910a;
                int i2 = this.b - 1;
                this.b = i2;
                dVarArr[i] = dVarArr2[i2];
                this.f910a[this.b] = null;
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
            this.f907a.m569a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f909b = true;
            this.f907a.m568a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m567a() {
            return this.f908a && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
            r8.a = android.os.SystemClock.uptimeMillis();
            r8.f908a = true;
            r2.f912a.run();
            r8.f908a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b8, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
            r8.f909b = true;
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
                    if (this.f909b) {
                        return;
                    }
                    if (!this.f907a.m570a()) {
                        long a2 = g.a();
                        d a3 = this.f907a.a();
                        synchronized (a3.f913a) {
                            if (a3.f914a) {
                                this.f907a.b(0);
                            } else {
                                long j = a3.f911a - a2;
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
                                    synchronized (a3.f913a) {
                                        int a4 = this.f907a.a().f911a != a3.f911a ? this.f907a.a(a3) : 0;
                                        if (a3.f914a) {
                                            this.f907a.b(this.f907a.a(a3));
                                        } else {
                                            a3.a(a3.f911a);
                                            this.f907a.b(a4);
                                            a3.f911a = 0L;
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
        long f911a;

        /* renamed from: a  reason: collision with other field name */
        b f912a;

        /* renamed from: a  reason: collision with other field name */
        final Object f913a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f914a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f913a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z = true;
            synchronized (this.f913a) {
                z = (this.f914a || this.f911a <= 0) ? false : false;
                this.f914a = true;
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
        this.f906a = new c(str, z);
        this.f905a = new a(this.f906a);
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
        synchronized (this.f906a) {
            if (this.f906a.f909b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = a() + j;
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.a = bVar.a;
            dVar.f912a = bVar;
            dVar.f911a = a2;
            this.f906a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m562a() {
        this.f906a.a();
    }

    public void a(int i) {
        synchronized (this.f906a) {
            this.f906a.f907a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f906a) {
            this.f906a.f907a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f906a) {
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
        return this.f906a.m567a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m564a(int i) {
        boolean m571a;
        synchronized (this.f906a) {
            m571a = this.f906a.f907a.m571a(i);
        }
        return m571a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m565b() {
        synchronized (this.f906a) {
            this.f906a.f907a.m568a();
        }
    }
}
