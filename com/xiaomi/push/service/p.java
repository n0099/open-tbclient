package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes8.dex */
public class p {
    public static long a;
    public static long b;
    public static long c;

    /* renamed from: a  reason: collision with other field name */
    public final a f992a;

    /* renamed from: a  reason: collision with other field name */
    public final c f993a;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static abstract class b implements Runnable {
        public int a;

        public b(int i) {
            this.a = i;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends Thread {

        /* renamed from: b  reason: collision with other field name */
        public boolean f996b;
        public boolean c;
        public volatile long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f995a = false;
        public long b = 50;

        /* renamed from: a  reason: collision with other field name */
        public a f994a = new a();

        /* loaded from: classes8.dex */
        public static final class a {
            public int a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f997a;
            public int b;
            public int c;

            public a() {
                this.a = 256;
                this.f997a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f997a;
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
                b bVar = dVar.f999a;
                int i = bVar.a;
                if (i == 8) {
                    XMPushService.d dVar2 = (XMPushService.d) bVar;
                    if (dVar2.a().f375a != null) {
                        dVar2.a().f375a.f902b = System.currentTimeMillis();
                        dVar2.a().f375a.b = a(dVar);
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
                    d[] dVarArr = this.f997a;
                    if (dVarArr[i].f998a >= dVarArr[i2].f998a) {
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
                        d[] dVarArr = this.f997a;
                        if (dVarArr[i4].f998a < dVarArr[i2].f998a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f997a;
                    if (dVarArr2[i].f998a < dVarArr2[i2].f998a) {
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
                return this.f997a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m752a() {
                this.f997a = new d[this.a];
                this.b = 0;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f997a;
                    if (dVarArr[i2].a == i) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d[] dVarArr = this.f997a;
                    if (dVarArr[i2].f999a == bVar) {
                        dVarArr[i2].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m753a(d dVar) {
                d[] dVarArr = this.f997a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f997a = dVarArr2;
                }
                d[] dVarArr3 = this.f997a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
                b(dVar);
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m754a() {
                return this.b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m755a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f997a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f997a[i].f1001a) {
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
                d[] dVarArr = this.f997a;
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
            this.f994a.m753a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f996b = true;
            this.f994a.m752a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m751a() {
            return this.f995a && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f995a = true;
            r2.f999a.run();
            r10.f995a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a6, code lost:
            r10.f996b = true;
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
                    if (this.f996b) {
                        return;
                    }
                    if (!this.f994a.m754a()) {
                        long a2 = p.a();
                        d a3 = this.f994a.a();
                        synchronized (a3.f1000a) {
                            if (a3.f1001a) {
                                this.f994a.b(0);
                            } else {
                                long j = a3.f998a - a2;
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
                                    synchronized (a3.f1000a) {
                                        int a4 = this.f994a.a().f998a != a3.f998a ? this.f994a.a(a3) : 0;
                                        if (a3.f1001a) {
                                            this.f994a.b(this.f994a.a(a3));
                                        } else {
                                            a3.a(a3.f998a);
                                            this.f994a.b(a4);
                                            a3.f998a = 0L;
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

    /* loaded from: classes8.dex */
    public static class d {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f998a;

        /* renamed from: a  reason: collision with other field name */
        public b f999a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f1000a = new Object();

        /* renamed from: a  reason: collision with other field name */
        public boolean f1001a;
        public long b;

        public void a(long j) {
            synchronized (this.f1000a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1000a) {
                z = !this.f1001a && this.f998a > 0;
                this.f1001a = true;
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
        this.f993a = cVar;
        this.f992a = new a(cVar);
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
        synchronized (this.f993a) {
            if (this.f993a.f996b) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.a = bVar.a;
            dVar.f999a = bVar;
            dVar.f998a = a2;
            this.f993a.a(dVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m746a() {
        com.xiaomi.channel.commonutils.logger.b.m101a("quit. finalizer:" + this.f992a);
        this.f993a.a();
    }

    public void a(int i) {
        synchronized (this.f993a) {
            this.f993a.f994a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f993a) {
            this.f993a.f994a.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f993a) {
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
    public boolean m747a() {
        return this.f993a.m751a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m748a(int i) {
        boolean m755a;
        synchronized (this.f993a) {
            m755a = this.f993a.f994a.m755a(i);
        }
        return m755a;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m749b() {
        synchronized (this.f993a) {
            this.f993a.f994a.m752a();
        }
    }
}
