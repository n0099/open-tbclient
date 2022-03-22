package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class a implements b {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43272b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43273c;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f43276f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f43277g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f43278h;
    public com.ss.android.socialbase.downloader.f.a i;
    public com.ss.android.socialbase.downloader.f.a j;
    public com.ss.android.socialbase.downloader.f.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f43274d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f43275e = new Object();
    public final Runnable q = new Runnable() { // from class: com.ss.android.socialbase.downloader.e.a.1
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.f.a d2;
            Process.setThreadPriority(10);
            do {
                try {
                    d2 = a.this.d();
                    d2.f43284c = a.this.a.read(d2.a);
                    a.this.c(d2);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f43275e) {
                            a.this.m = true;
                            a.this.f43275e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f43275e) {
                            a.this.m = true;
                            a.this.f43275e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (d2.f43284c != -1);
            synchronized (a.this.f43275e) {
                a.this.m = true;
                a.this.f43275e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.a = inputStream;
        this.f43272b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.f43273c = i2;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar = this.f43278h;
        if (aVar != null) {
            if (!this.l) {
                this.f43278h = aVar.f43285d;
                aVar.f43285d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f43274d) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f43276f;
                if (aVar2 == null && this.p < this.f43273c) {
                    this.p++;
                    return new com.ss.android.socialbase.downloader.f.a(this.f43272b);
                }
                while (aVar2 == null) {
                    this.f43274d.wait();
                    if (!this.l) {
                        aVar2 = this.f43276f;
                    } else {
                        throw new p("");
                    }
                }
                this.f43278h = aVar2.f43285d;
                this.f43277g = null;
                this.f43276f = null;
                aVar2.f43285d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f43285d;
            aVar2.f43285d = null;
            return aVar2;
        }
        synchronized (this.f43275e) {
            aVar = this.i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.f43275e.wait();
                    aVar = this.i;
                } while (aVar == null);
                this.k = aVar.f43285d;
                this.j = null;
                this.i = null;
                aVar.f43285d = null;
            } else {
                this.k = aVar.f43285d;
                this.j = null;
                this.i = null;
                aVar.f43285d = null;
            }
        }
        return aVar;
    }

    private void f() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException((int) RevenueServerConst.GetUserYbDetailsRequest, "async reader closed!");
            }
            f.a(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private void c() throws Throwable {
        this.o = com.ss.android.socialbase.downloader.downloader.c.q().submit(this.q);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        synchronized (this.f43274d) {
            this.l = true;
            this.f43274d.notify();
        }
        Future future = this.o;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.f43275e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.i = aVar;
                this.f43275e.notify();
            } else {
                aVar2.f43285d = aVar;
                this.j = aVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() throws BaseException, InterruptedException {
        return e();
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.f43274d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f43277g;
            if (aVar2 == null) {
                this.f43277g = aVar;
                this.f43276f = aVar;
                this.f43274d.notify();
            } else {
                aVar2.f43285d = aVar;
                this.f43277g = aVar;
            }
        }
    }
}
