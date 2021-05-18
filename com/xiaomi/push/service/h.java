package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes7.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static long f38203a;

    /* renamed from: b  reason: collision with root package name */
    public static long f38204b;

    /* renamed from: c  reason: collision with root package name */
    public static long f38205c;

    /* renamed from: a  reason: collision with other field name */
    public final a f947a;

    /* renamed from: a  reason: collision with other field name */
    public final c f948a;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final c f38206a;

        public a(c cVar) {
            this.f38206a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.f38206a) {
                    this.f38206a.f38210c = true;
                    this.f38206a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f38207a;

        public b(int i2) {
            this.f38207a = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        public boolean f951b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38210c;

        /* renamed from: a  reason: collision with root package name */
        public volatile long f38208a = 0;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f950a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f38209b = 50;

        /* renamed from: a  reason: collision with other field name */
        public a f949a = new a();

        /* loaded from: classes7.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public int f38211a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f952a;

            /* renamed from: b  reason: collision with root package name */
            public int f38212b;

            /* renamed from: c  reason: collision with root package name */
            public int f38213c;

            public a() {
                this.f38211a = 256;
                this.f952a = new d[256];
                this.f38212b = 0;
                this.f38213c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.f952a;
                    if (i2 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i2] == dVar) {
                        return i2;
                    }
                    i2++;
                }
            }

            private void c() {
                int i2 = this.f38212b - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f952a;
                    if (dVarArr[i2].f953a >= dVarArr[i3].f953a) {
                        return;
                    }
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i3];
                    dVarArr[i3] = dVar;
                    int i4 = i3;
                    i3 = (i3 - 1) / 2;
                    i2 = i4;
                }
            }

            private void c(int i2) {
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f38212b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f952a;
                        if (dVarArr[i5].f953a < dVarArr[i3].f953a) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f952a;
                    if (dVarArr2[i2].f953a < dVarArr2[i3].f953a) {
                        return;
                    }
                    d dVar = dVarArr2[i2];
                    dVarArr2[i2] = dVarArr2[i3];
                    dVarArr2[i3] = dVar;
                    int i6 = i3;
                    i3 = (i3 * 2) + 1;
                    i2 = i6;
                }
            }

            public d a() {
                return this.f952a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m613a() {
                this.f952a = new d[this.f38211a];
                this.f38212b = 0;
            }

            public void a(int i2) {
                for (int i3 = 0; i3 < this.f38212b; i3++) {
                    d[] dVarArr = this.f952a;
                    if (dVarArr[i3].f38214a == i2) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            public void a(int i2, b bVar) {
                for (int i3 = 0; i3 < this.f38212b; i3++) {
                    d[] dVarArr = this.f952a;
                    if (dVarArr[i3].f954a == bVar) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m614a(d dVar) {
                d[] dVarArr = this.f952a;
                int length = dVarArr.length;
                int i2 = this.f38212b;
                if (length == i2) {
                    d[] dVarArr2 = new d[i2 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                    this.f952a = dVarArr2;
                }
                d[] dVarArr3 = this.f952a;
                int i3 = this.f38212b;
                this.f38212b = i3 + 1;
                dVarArr3[i3] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m615a() {
                return this.f38212b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m616a(int i2) {
                for (int i3 = 0; i3 < this.f38212b; i3++) {
                    if (this.f952a[i3].f38214a == i2) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i2 = 0;
                while (i2 < this.f38212b) {
                    if (this.f952a[i2].f956a) {
                        this.f38213c++;
                        b(i2);
                        i2--;
                    }
                    i2++;
                }
            }

            public void b(int i2) {
                int i3;
                if (i2 < 0 || i2 >= (i3 = this.f38212b)) {
                    return;
                }
                d[] dVarArr = this.f952a;
                int i4 = i3 - 1;
                this.f38212b = i4;
                dVarArr[i2] = dVarArr[i4];
                dVarArr[i4] = null;
                c(i2);
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f949a.m614a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f951b = true;
            this.f949a.m613a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m612a() {
            return this.f950a && SystemClock.uptimeMillis() - this.f38208a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
            r10.f38208a = android.os.SystemClock.uptimeMillis();
            r10.f950a = true;
            r2.f954a.run();
            r10.f950a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a6, code lost:
            r10.f951b = true;
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
                    if (this.f951b) {
                        return;
                    }
                    if (!this.f949a.m615a()) {
                        long a2 = h.a();
                        d a3 = this.f949a.a();
                        synchronized (a3.f955a) {
                            if (a3.f956a) {
                                this.f949a.b(0);
                            } else {
                                long j = a3.f953a - a2;
                                if (j > 0) {
                                    if (j > this.f38209b) {
                                        j = this.f38209b;
                                    }
                                    long j2 = this.f38209b + 50;
                                    this.f38209b = j2;
                                    if (j2 > 500) {
                                        this.f38209b = 500L;
                                    }
                                    wait(j);
                                } else {
                                    this.f38209b = 50L;
                                    synchronized (a3.f955a) {
                                        int a4 = this.f949a.a().f953a != a3.f953a ? this.f949a.a(a3) : 0;
                                        if (a3.f956a) {
                                            this.f949a.b(this.f949a.a(a3));
                                        } else {
                                            a3.a(a3.f953a);
                                            this.f949a.b(a4);
                                            a3.f953a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.f38210c) {
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

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f38214a;

        /* renamed from: a  reason: collision with other field name */
        public long f953a;

        /* renamed from: a  reason: collision with other field name */
        public b f954a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f955a = new Object();

        /* renamed from: a  reason: collision with other field name */
        public boolean f956a;

        /* renamed from: b  reason: collision with root package name */
        public long f38215b;

        public void a(long j) {
            synchronized (this.f955a) {
                this.f38215b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f955a) {
                z = !this.f956a && this.f953a > 0;
                this.f956a = true;
            }
            return z;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f38203a = elapsedRealtime;
        f38204b = elapsedRealtime;
    }

    public h() {
        this(false);
    }

    public h(String str) {
        this(str, false);
    }

    public h(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f948a = cVar;
        this.f947a = new a(cVar);
    }

    public h(boolean z) {
        this("Timer-" + b(), z);
    }

    public static synchronized long a() {
        long j;
        synchronized (h.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > f38204b) {
                f38203a += elapsedRealtime - f38204b;
            }
            f38204b = elapsedRealtime;
            j = f38203a;
        }
        return j;
    }

    public static synchronized long b() {
        long j;
        synchronized (h.class) {
            j = f38205c;
            f38205c = 1 + j;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.f948a) {
            if (this.f948a.f951b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.f38214a = bVar.f38207a;
            dVar.f954a = bVar;
            dVar.f953a = a2;
            this.f948a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m607a() {
        com.xiaomi.channel.commonutils.logger.b.m57a("quit. finalizer:" + this.f947a);
        this.f948a.a();
    }

    public void a(int i2) {
        synchronized (this.f948a) {
            this.f948a.f949a.a(i2);
        }
    }

    public void a(int i2, b bVar) {
        synchronized (this.f948a) {
            this.f948a.f949a.a(i2, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f948a) {
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
    public boolean m608a() {
        return this.f948a.m612a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m609a(int i2) {
        boolean m616a;
        synchronized (this.f948a) {
            m616a = this.f948a.f949a.m616a(i2);
        }
        return m616a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m610b() {
        synchronized (this.f948a) {
            this.f948a.f949a.m613a();
        }
    }
}
