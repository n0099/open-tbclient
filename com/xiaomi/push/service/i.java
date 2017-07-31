package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes2.dex */
public class i {
    private static long a;
    private static long b;
    private static long c;
    private final c d;
    private final a e;

    /* loaded from: classes2.dex */
    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.a) {
                    this.a.e = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b implements Runnable {
        protected int a;

        public b(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c extends Thread {
        private boolean d;
        private boolean e;
        private volatile long a = 0;
        private volatile boolean b = false;
        private long c = 50;
        private a f = new a();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static final class a {
            private int a;
            private d[] b;
            private int c;
            private int d;

            private a() {
                this.a = 256;
                this.b = new d[this.a];
                this.c = 0;
                this.d = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int b(d dVar) {
                for (int i = 0; i < this.b.length; i++) {
                    if (this.b[i] == dVar) {
                        return i;
                    }
                }
                return -1;
            }

            private void d(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.c && this.c > 0) {
                    int i3 = (i2 + 1 >= this.c || this.b[i2 + 1].c >= this.b[i2].c) ? i2 : i2 + 1;
                    if (this.b[i].c < this.b[i3].c) {
                        return;
                    }
                    d dVar = this.b[i];
                    this.b[i] = this.b[i3];
                    this.b[i3] = dVar;
                    i2 = (i3 * 2) + 1;
                    i = i3;
                }
            }

            private void e() {
                int i = this.c - 1;
                for (int i2 = (i - 1) / 2; this.b[i].c < this.b[i2].c; i2 = (i2 - 1) / 2) {
                    d dVar = this.b[i];
                    this.b[i] = this.b[i2];
                    this.b[i2] = dVar;
                    i = i2;
                }
            }

            public d a() {
                return this.b[0];
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].d == bVar) {
                        this.b[i2].a();
                    }
                }
                d();
            }

            public void a(d dVar) {
                if (this.b.length == this.c) {
                    d[] dVarArr = new d[this.c * 2];
                    System.arraycopy(this.b, 0, dVarArr, 0, this.c);
                    this.b = dVarArr;
                }
                d[] dVarArr2 = this.b;
                int i = this.c;
                this.c = i + 1;
                dVarArr2[i] = dVar;
                e();
            }

            public boolean a(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        this.b[i2].a();
                    }
                }
                d();
            }

            public boolean b() {
                return this.c == 0;
            }

            public void c() {
                this.b = new d[this.a];
                this.c = 0;
            }

            public void c(int i) {
                if (i < 0 || i >= this.c) {
                    return;
                }
                d[] dVarArr = this.b;
                d[] dVarArr2 = this.b;
                int i2 = this.c - 1;
                this.c = i2;
                dVarArr[i] = dVarArr2[i2];
                this.b[this.c] = null;
                d(i);
            }

            public void d() {
                int i = 0;
                while (i < this.c) {
                    if (this.b[i].b) {
                        this.d++;
                        c(i);
                        i--;
                    }
                    i++;
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f.a(dVar);
            notify();
        }

        public synchronized void a() {
            this.d = true;
            this.f.c();
            notify();
        }

        public boolean b() {
            return this.b && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
            r8.a = android.os.SystemClock.uptimeMillis();
            r8.b = true;
            r2.d.run();
            r8.b = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b8, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ba, code lost:
            r8.d = true;
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
                    if (this.d) {
                        return;
                    }
                    if (!this.f.b()) {
                        long a2 = i.a();
                        d a3 = this.f.a();
                        synchronized (a3.a) {
                            if (a3.b) {
                                this.f.c(0);
                            } else {
                                long j = a3.c - a2;
                                if (j > 0) {
                                    if (j > this.c) {
                                        j = this.c;
                                    }
                                    this.c += 50;
                                    if (this.c > 500) {
                                        this.c = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException e) {
                                    }
                                } else {
                                    this.c = 50L;
                                    synchronized (a3.a) {
                                        int b = this.f.a().c != a3.c ? this.f.b(a3) : 0;
                                        if (a3.b) {
                                            this.f.c(this.f.b(a3));
                                        } else {
                                            a3.a(a3.c);
                                            this.f.c(b);
                                            a3.c = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.e) {
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
    /* loaded from: classes2.dex */
    public static class d {
        final Object a = new Object();
        boolean b;
        long c;
        b d;
        int e;
        private long f;

        d() {
        }

        void a(long j) {
            synchronized (this.a) {
                this.f = j;
            }
        }

        public boolean a() {
            boolean z = true;
            synchronized (this.a) {
                z = (this.b || this.c <= 0) ? false : false;
                this.b = true;
            }
            return z;
        }
    }

    static {
        a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        b = a;
    }

    public i() {
        this(false);
    }

    public i(String str) {
        this(str, false);
    }

    public i(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.d = new c(str, z);
        this.e = new a(this.d);
    }

    public i(boolean z) {
        this("Timer-" + e(), z);
    }

    static synchronized long a() {
        long j;
        synchronized (i.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > b) {
                a += elapsedRealtime - b;
            }
            b = elapsedRealtime;
            j = a;
        }
        return j;
    }

    private void b(b bVar, long j) {
        synchronized (this.d) {
            if (this.d.d) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = a() + j;
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.e = bVar.a;
            dVar.d = bVar;
            dVar.c = a2;
            this.d.a(dVar);
        }
    }

    private static synchronized long e() {
        long j;
        synchronized (i.class) {
            j = c;
            c = 1 + j;
        }
        return j;
    }

    public void a(int i, b bVar) {
        synchronized (this.d) {
            this.d.f.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.d) {
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

    public boolean a(int i) {
        boolean a2;
        synchronized (this.d) {
            a2 = this.d.f.a(i);
        }
        return a2;
    }

    public void b() {
        this.d.a();
    }

    public void b(int i) {
        synchronized (this.d) {
            this.d.f.b(i);
        }
    }

    public void c() {
        synchronized (this.d) {
            this.d.f.c();
        }
    }

    public boolean d() {
        return this.d.b();
    }
}
