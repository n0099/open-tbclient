package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes7.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static long f41317a;

    /* renamed from: b  reason: collision with root package name */
    public static long f41318b;

    /* renamed from: c  reason: collision with root package name */
    public static long f41319c;

    /* renamed from: a  reason: collision with other field name */
    public final a f947a;

    /* renamed from: a  reason: collision with other field name */
    public final c f948a;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final c f41320a;

        public a(c cVar) {
            this.f41320a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.f41320a) {
                    this.f41320a.f41324c = true;
                    this.f41320a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f41321a;

        public b(int i) {
            this.f41321a = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        public boolean f951b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41324c;

        /* renamed from: a  reason: collision with root package name */
        public volatile long f41322a = 0;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f950a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f41323b = 50;

        /* renamed from: a  reason: collision with other field name */
        public a f949a = new a();

        /* loaded from: classes7.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public int f41325a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f952a;

            /* renamed from: b  reason: collision with root package name */
            public int f41326b;

            /* renamed from: c  reason: collision with root package name */
            public int f41327c;

            public a() {
                this.f41325a = 256;
                this.f952a = new d[256];
                this.f41326b = 0;
                this.f41327c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f952a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void c() {
                int i = this.f41326b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f952a;
                    if (dVarArr[i].f953a >= dVarArr[i2].f953a) {
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
                    int i3 = this.f41326b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f952a;
                        if (dVarArr[i4].f953a < dVarArr[i2].f953a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f952a;
                    if (dVarArr2[i].f953a < dVarArr2[i2].f953a) {
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
                return this.f952a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m611a() {
                this.f952a = new d[this.f41325a];
                this.f41326b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.f41326b; i2++) {
                    d[] dVarArr = this.f952a;
                    if (dVarArr[i2].f41328a == i) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.f41326b; i2++) {
                    d[] dVarArr = this.f952a;
                    if (dVarArr[i2].f954a == bVar) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m612a(d dVar) {
                d[] dVarArr = this.f952a;
                int length = dVarArr.length;
                int i = this.f41326b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f952a = dVarArr2;
                }
                d[] dVarArr3 = this.f952a;
                int i2 = this.f41326b;
                this.f41326b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m613a() {
                return this.f41326b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m614a(int i) {
                for (int i2 = 0; i2 < this.f41326b; i2++) {
                    if (this.f952a[i2].f41328a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.f41326b) {
                    if (this.f952a[i].f956a) {
                        this.f41327c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.f41326b)) {
                    return;
                }
                d[] dVarArr = this.f952a;
                int i3 = i2 - 1;
                this.f41326b = i3;
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
            this.f949a.m612a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f951b = true;
            this.f949a.m611a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m610a() {
            return this.f950a && SystemClock.uptimeMillis() - this.f41322a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
            r10.f41322a = android.os.SystemClock.uptimeMillis();
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
                    if (!this.f949a.m613a()) {
                        long a2 = h.a();
                        d a3 = this.f949a.a();
                        synchronized (a3.f955a) {
                            if (a3.f956a) {
                                this.f949a.b(0);
                            } else {
                                long j = a3.f953a - a2;
                                if (j > 0) {
                                    if (j > this.f41323b) {
                                        j = this.f41323b;
                                    }
                                    long j2 = this.f41323b + 50;
                                    this.f41323b = j2;
                                    if (j2 > 500) {
                                        this.f41323b = 500L;
                                    }
                                    wait(j);
                                } else {
                                    this.f41323b = 50L;
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
                    } else if (this.f41324c) {
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
        public int f41328a;

        /* renamed from: a  reason: collision with other field name */
        public long f953a;

        /* renamed from: a  reason: collision with other field name */
        public b f954a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f955a = new Object();

        /* renamed from: a  reason: collision with other field name */
        public boolean f956a;

        /* renamed from: b  reason: collision with root package name */
        public long f41329b;

        public void a(long j) {
            synchronized (this.f955a) {
                this.f41329b = j;
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
        f41317a = elapsedRealtime;
        f41318b = elapsedRealtime;
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
            if (elapsedRealtime > f41318b) {
                f41317a += elapsedRealtime - f41318b;
            }
            f41318b = elapsedRealtime;
            j = f41317a;
        }
        return j;
    }

    public static synchronized long b() {
        long j;
        synchronized (h.class) {
            j = f41319c;
            f41319c = 1 + j;
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
            dVar.f41328a = bVar.f41321a;
            dVar.f954a = bVar;
            dVar.f953a = a2;
            this.f948a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m605a() {
        com.xiaomi.channel.commonutils.logger.b.m55a("quit. finalizer:" + this.f947a);
        this.f948a.a();
    }

    public void a(int i) {
        synchronized (this.f948a) {
            this.f948a.f949a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f948a) {
            this.f948a.f949a.a(i, bVar);
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
    public boolean m606a() {
        return this.f948a.m610a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m607a(int i) {
        boolean m614a;
        synchronized (this.f948a) {
            m614a = this.f948a.f949a.m614a(i);
        }
        return m614a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m608b() {
        synchronized (this.f948a) {
            this.f948a.f949a.m611a();
        }
    }
}
