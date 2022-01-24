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
    public final int f60033b;

    /* renamed from: c  reason: collision with root package name */
    public final int f60034c;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60037f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60038g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60039h;

    /* renamed from: i  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60040i;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f60041j;
    public com.ss.android.socialbase.downloader.f.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f60035d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f60036e = new Object();
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
                    d2.f60047c = a.this.a.read(d2.a);
                    a.this.c(d2);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f60036e) {
                            a.this.m = true;
                            a.this.f60036e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f60036e) {
                            a.this.m = true;
                            a.this.f60036e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (d2.f60047c != -1);
            synchronized (a.this.f60036e) {
                a.this.m = true;
                a.this.f60036e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.a = inputStream;
        this.f60033b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f60034c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar = this.f60039h;
        if (aVar != null) {
            if (!this.l) {
                this.f60039h = aVar.f60048d;
                aVar.f60048d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f60035d) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f60037f;
                if (aVar2 == null && this.p < this.f60034c) {
                    this.p++;
                    return new com.ss.android.socialbase.downloader.f.a(this.f60033b);
                }
                while (aVar2 == null) {
                    this.f60035d.wait();
                    if (!this.l) {
                        aVar2 = this.f60037f;
                    } else {
                        throw new p("");
                    }
                }
                this.f60039h = aVar2.f60048d;
                this.f60038g = null;
                this.f60037f = null;
                aVar2.f60048d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f60048d;
            aVar2.f60048d = null;
            return aVar2;
        }
        synchronized (this.f60036e) {
            aVar = this.f60040i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.f60036e.wait();
                    aVar = this.f60040i;
                } while (aVar == null);
                this.k = aVar.f60048d;
                this.f60041j = null;
                this.f60040i = null;
                aVar.f60048d = null;
            } else {
                this.k = aVar.f60048d;
                this.f60041j = null;
                this.f60040i = null;
                aVar.f60048d = null;
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
        synchronized (this.f60035d) {
            this.l = true;
            this.f60035d.notify();
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
        synchronized (this.f60036e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f60041j;
            if (aVar2 == null) {
                this.f60041j = aVar;
                this.f60040i = aVar;
                this.f60036e.notify();
            } else {
                aVar2.f60048d = aVar;
                this.f60041j = aVar;
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
        synchronized (this.f60035d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f60038g;
            if (aVar2 == null) {
                this.f60038g = aVar;
                this.f60037f = aVar;
                this.f60035d.notify();
            } else {
                aVar2.f60048d = aVar;
                this.f60038g = aVar;
            }
        }
    }
}
