package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes8.dex */
public class a implements b {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58550b;

    /* renamed from: c  reason: collision with root package name */
    public final int f58551c;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f58554f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f58555g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f58556h;

    /* renamed from: i  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f58557i;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f58558j;
    public com.ss.android.socialbase.downloader.f.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f58552d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f58553e = new Object();
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
                    d2.f58564c = a.this.a.read(d2.a);
                    a.this.c(d2);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f58553e) {
                            a.this.m = true;
                            a.this.f58553e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f58553e) {
                            a.this.m = true;
                            a.this.f58553e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (d2.f58564c != -1);
            synchronized (a.this.f58553e) {
                a.this.m = true;
                a.this.f58553e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.a = inputStream;
        this.f58550b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f58551c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar = this.f58556h;
        if (aVar != null) {
            if (!this.l) {
                this.f58556h = aVar.f58565d;
                aVar.f58565d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f58552d) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f58554f;
                if (aVar2 == null && this.p < this.f58551c) {
                    this.p++;
                    return new com.ss.android.socialbase.downloader.f.a(this.f58550b);
                }
                while (aVar2 == null) {
                    this.f58552d.wait();
                    if (!this.l) {
                        aVar2 = this.f58554f;
                    } else {
                        throw new p("");
                    }
                }
                this.f58556h = aVar2.f58565d;
                this.f58555g = null;
                this.f58554f = null;
                aVar2.f58565d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f58565d;
            aVar2.f58565d = null;
            return aVar2;
        }
        synchronized (this.f58553e) {
            aVar = this.f58557i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.f58553e.wait();
                    aVar = this.f58557i;
                } while (aVar == null);
                this.k = aVar.f58565d;
                this.f58558j = null;
                this.f58557i = null;
                aVar.f58565d = null;
            } else {
                this.k = aVar.f58565d;
                this.f58558j = null;
                this.f58557i = null;
                aVar.f58565d = null;
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
        synchronized (this.f58552d) {
            this.l = true;
            this.f58552d.notify();
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
        synchronized (this.f58553e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f58558j;
            if (aVar2 == null) {
                this.f58558j = aVar;
                this.f58557i = aVar;
                this.f58553e.notify();
            } else {
                aVar2.f58565d = aVar;
                this.f58558j = aVar;
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
        synchronized (this.f58552d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f58555g;
            if (aVar2 == null) {
                this.f58555g = aVar;
                this.f58554f = aVar;
                this.f58552d.notify();
            } else {
                aVar2.f58565d = aVar;
                this.f58555g = aVar;
            }
        }
    }
}
