package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class a implements b {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final int f62337b;

    /* renamed from: c  reason: collision with root package name */
    public final int f62338c;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f62341f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f62342g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f62343h;

    /* renamed from: i  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f62344i;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f62345j;

    /* renamed from: k  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f62346k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f62339d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f62340e = new Object();
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
                    d2.f62352c = a.this.a.read(d2.a);
                    a.this.c(d2);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f62340e) {
                            a.this.m = true;
                            a.this.f62340e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f62340e) {
                            a.this.m = true;
                            a.this.f62340e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (d2.f62352c != -1);
            synchronized (a.this.f62340e) {
                a.this.m = true;
                a.this.f62340e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.a = inputStream;
        this.f62337b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f62338c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar = this.f62343h;
        if (aVar != null) {
            if (!this.l) {
                this.f62343h = aVar.f62353d;
                aVar.f62353d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f62339d) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f62341f;
                if (aVar2 == null && this.p < this.f62338c) {
                    this.p++;
                    return new com.ss.android.socialbase.downloader.f.a(this.f62337b);
                }
                while (aVar2 == null) {
                    this.f62339d.wait();
                    if (!this.l) {
                        aVar2 = this.f62341f;
                    } else {
                        throw new p("");
                    }
                }
                this.f62343h = aVar2.f62353d;
                this.f62342g = null;
                this.f62341f = null;
                aVar2.f62353d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.f62346k;
        if (aVar2 != null) {
            this.f62346k = aVar2.f62353d;
            aVar2.f62353d = null;
            return aVar2;
        }
        synchronized (this.f62340e) {
            aVar = this.f62344i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.f62340e.wait();
                    aVar = this.f62344i;
                } while (aVar == null);
                this.f62346k = aVar.f62353d;
                this.f62345j = null;
                this.f62344i = null;
                aVar.f62353d = null;
            } else {
                this.f62346k = aVar.f62353d;
                this.f62345j = null;
                this.f62344i = null;
                aVar.f62353d = null;
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
        synchronized (this.f62339d) {
            this.l = true;
            this.f62339d.notify();
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
        synchronized (this.f62340e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f62345j;
            if (aVar2 == null) {
                this.f62345j = aVar;
                this.f62344i = aVar;
                this.f62340e.notify();
            } else {
                aVar2.f62353d = aVar;
                this.f62345j = aVar;
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
        synchronized (this.f62339d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f62342g;
            if (aVar2 == null) {
                this.f62342g = aVar;
                this.f62341f = aVar;
                this.f62339d.notify();
            } else {
                aVar2.f62353d = aVar;
                this.f62342g = aVar;
            }
        }
    }
}
