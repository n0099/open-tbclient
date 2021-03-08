package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static long f8563a;
    private static long b;
    private static long c;

    /* renamed from: a  reason: collision with other field name */
    private final a f903a;

    /* renamed from: a  reason: collision with other field name */
    private final c f904a;

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f8564a;

        a(c cVar) {
            this.f8564a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.f8564a) {
                    this.f8564a.c = true;
                    this.f8564a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected int f8565a;

        public b(int i) {
            this.f8565a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        private boolean f907b;
        private boolean c;

        /* renamed from: a  reason: collision with root package name */
        private volatile long f8566a = 0;

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f906a = false;
        private long b = 50;

        /* renamed from: a  reason: collision with other field name */
        private a f905a = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private int f8567a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f908a;
            private int b;
            private int c;

            private a() {
                this.f8567a = 256;
                this.f908a = new d[this.f8567a];
                this.b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                for (int i = 0; i < this.f908a.length; i++) {
                    if (this.f908a[i] == dVar) {
                        return i;
                    }
                }
                return -1;
            }

            private void c() {
                int i = this.b - 1;
                int i2 = i;
                for (int i3 = (i - 1) / 2; this.f908a[i2].f909a < this.f908a[i3].f909a; i3 = (i3 - 1) / 2) {
                    d dVar = this.f908a[i2];
                    this.f908a[i2] = this.f908a[i3];
                    this.f908a[i3] = dVar;
                    i2 = i3;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.b && this.b > 0) {
                    int i3 = (i2 + 1 >= this.b || this.f908a[i2 + 1].f909a >= this.f908a[i2].f909a) ? i2 : i2 + 1;
                    if (this.f908a[i].f909a < this.f908a[i3].f909a) {
                        return;
                    }
                    d dVar = this.f908a[i];
                    this.f908a[i] = this.f908a[i3];
                    this.f908a[i3] = dVar;
                    i2 = (i3 * 2) + 1;
                    i = i3;
                }
            }

            public d a() {
                return this.f908a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m577a() {
                this.f908a = new d[this.f8567a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f908a[i2].f8568a == i) {
                        this.f908a[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f908a[i2].f910a == bVar) {
                        this.f908a[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m578a(d dVar) {
                if (this.f908a.length == this.b) {
                    d[] dVarArr = new d[this.b * 2];
                    System.arraycopy(this.f908a, 0, dVarArr, 0, this.b);
                    this.f908a = dVarArr;
                }
                d[] dVarArr2 = this.f908a;
                int i = this.b;
                this.b = i + 1;
                dVarArr2[i] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m579a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m580a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f908a[i2].f8568a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f908a[i].f912a) {
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
                d[] dVarArr = this.f908a;
                d[] dVarArr2 = this.f908a;
                int i2 = this.b - 1;
                this.b = i2;
                dVarArr[i] = dVarArr2[i2];
                this.f908a[this.b] = null;
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
            this.f905a.m578a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f907b = true;
            this.f905a.m577a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m576a() {
            return this.f906a && SystemClock.uptimeMillis() - this.f8566a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
            r8.f8566a = android.os.SystemClock.uptimeMillis();
            r8.f906a = true;
            r2.f910a.run();
            r8.f906a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b8, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
            r8.f907b = true;
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
                    if (this.f907b) {
                        return;
                    }
                    if (!this.f905a.m579a()) {
                        long a2 = g.a();
                        d a3 = this.f905a.a();
                        synchronized (a3.f911a) {
                            if (a3.f912a) {
                                this.f905a.b(0);
                            } else {
                                long j = a3.f909a - a2;
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
                                    synchronized (a3.f911a) {
                                        int a4 = this.f905a.a().f909a != a3.f909a ? this.f905a.a(a3) : 0;
                                        if (a3.f912a) {
                                            this.f905a.b(this.f905a.a(a3));
                                        } else {
                                            a3.a(a3.f909a);
                                            this.f905a.b(a4);
                                            a3.f909a = 0L;
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
    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f8568a;

        /* renamed from: a  reason: collision with other field name */
        long f909a;

        /* renamed from: a  reason: collision with other field name */
        b f910a;

        /* renamed from: a  reason: collision with other field name */
        final Object f911a = new Object();

        /* renamed from: a  reason: collision with other field name */
        boolean f912a;
        private long b;

        d() {
        }

        void a(long j) {
            synchronized (this.f911a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z = true;
            synchronized (this.f911a) {
                z = (this.f912a || this.f909a <= 0) ? false : false;
                this.f912a = true;
            }
            return z;
        }
    }

    static {
        f8563a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        b = f8563a;
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
        this.f904a = new c(str, z);
        this.f903a = new a(this.f904a);
    }

    public g(boolean z) {
        this("Timer-" + b(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (g.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > b) {
                f8563a += elapsedRealtime - b;
            }
            b = elapsedRealtime;
            j = f8563a;
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
        synchronized (this.f904a) {
            if (this.f904a.f907b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = a() + j;
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.f8568a = bVar.f8565a;
            dVar.f910a = bVar;
            dVar.f909a = a2;
            this.f904a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m571a() {
        this.f904a.a();
    }

    public void a(int i) {
        synchronized (this.f904a) {
            this.f904a.f905a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f904a) {
            this.f904a.f905a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f904a) {
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
    public boolean m572a() {
        return this.f904a.m576a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m573a(int i) {
        boolean m580a;
        synchronized (this.f904a) {
            m580a = this.f904a.f905a.m580a(i);
        }
        return m580a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m574b() {
        synchronized (this.f904a) {
            this.f904a.f905a.m577a();
        }
    }
}
