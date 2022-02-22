package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class a implements b {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60200b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60201c;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60204f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60205g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60206h;

    /* renamed from: i  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60207i;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60208j;
    public com.ss.android.socialbase.downloader.f.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f60202d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f60203e = new Object();
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
                    d2.f60214c = a.this.a.read(d2.a);
                    a.this.c(d2);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f60203e) {
                            a.this.m = true;
                            a.this.f60203e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f60203e) {
                            a.this.m = true;
                            a.this.f60203e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (d2.f60214c != -1);
            synchronized (a.this.f60203e) {
                a.this.m = true;
                a.this.f60203e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.a = inputStream;
        this.f60200b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f60201c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar = this.f60206h;
        if (aVar != null) {
            if (!this.l) {
                this.f60206h = aVar.f60215d;
                aVar.f60215d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f60202d) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f60204f;
                if (aVar2 == null && this.p < this.f60201c) {
                    this.p++;
                    return new com.ss.android.socialbase.downloader.f.a(this.f60200b);
                }
                while (aVar2 == null) {
                    this.f60202d.wait();
                    if (!this.l) {
                        aVar2 = this.f60204f;
                    } else {
                        throw new p("");
                    }
                }
                this.f60206h = aVar2.f60215d;
                this.f60205g = null;
                this.f60204f = null;
                aVar2.f60215d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f60215d;
            aVar2.f60215d = null;
            return aVar2;
        }
        synchronized (this.f60203e) {
            aVar = this.f60207i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.f60203e.wait();
                    aVar = this.f60207i;
                } while (aVar == null);
                this.k = aVar.f60215d;
                this.f60208j = null;
                this.f60207i = null;
                aVar.f60215d = null;
            } else {
                this.k = aVar.f60215d;
                this.f60208j = null;
                this.f60207i = null;
                aVar.f60215d = null;
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
        synchronized (this.f60202d) {
            this.l = true;
            this.f60202d.notify();
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
        synchronized (this.f60203e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f60208j;
            if (aVar2 == null) {
                this.f60208j = aVar;
                this.f60207i = aVar;
                this.f60203e.notify();
            } else {
                aVar2.f60215d = aVar;
                this.f60208j = aVar;
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
        synchronized (this.f60202d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f60205g;
            if (aVar2 == null) {
                this.f60205g = aVar;
                this.f60204f = aVar;
                this.f60202d.notify();
            } else {
                aVar2.f60215d = aVar;
                this.f60205g = aVar;
            }
        }
    }
}
