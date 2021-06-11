package d.o.a.e.b.h;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import d.o.a.e.b.g.d;
import d.o.a.e.b.l.e;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f71027a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71028b;

    /* renamed from: c  reason: collision with root package name */
    public final int f71029c;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.e.b.i.a f71032f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.i.a f71033g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.i.a f71034h;

    /* renamed from: i  reason: collision with root package name */
    public d.o.a.e.b.i.a f71035i;
    public d.o.a.e.b.i.a j;
    public d.o.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f71030d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f71031e = new Object();
    public final Runnable q = new RunnableC1949a();

    /* renamed from: d.o.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1949a implements Runnable {
        public RunnableC1949a() {
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            d.o.a.e.b.i.a k;
            Process.setThreadPriority(10);
            do {
                try {
                    k = a.this.k();
                    k.f71041c = a.this.f71027a.read(k.f71039a);
                    a.this.j(k);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f71031e) {
                            a.this.m = true;
                            a.this.f71031e.notify();
                            e.C(a.this.f71027a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f71031e) {
                            a.this.m = true;
                            a.this.f71031e.notify();
                            e.C(a.this.f71027a);
                            throw th2;
                        }
                    }
                }
            } while (k.f71041c != -1);
            synchronized (a.this.f71031e) {
                a.this.m = true;
                a.this.f71031e.notify();
            }
            e.C(a.this.f71027a);
        }
    }

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.f71027a = inputStream;
        this.f71028b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f71029c = i3;
        i();
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws BaseException, InterruptedException {
        return l();
    }

    public final void g(d.o.a.e.b.i.a aVar) {
        synchronized (this.f71030d) {
            d.o.a.e.b.i.a aVar2 = this.f71033g;
            if (aVar2 == null) {
                this.f71033g = aVar;
                this.f71032f = aVar;
                this.f71030d.notify();
            } else {
                aVar2.f71042d = aVar;
                this.f71033g = aVar;
            }
        }
    }

    public final void i() throws Throwable {
        this.o = d.B0().submit(this.q);
    }

    public final void j(d.o.a.e.b.i.a aVar) {
        synchronized (this.f71031e) {
            d.o.a.e.b.i.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.f71035i = aVar;
                this.f71031e.notify();
            } else {
                aVar2.f71042d = aVar;
                this.j = aVar;
            }
        }
    }

    public final d.o.a.e.b.i.a k() throws p, InterruptedException {
        d.o.a.e.b.i.a aVar = this.f71034h;
        if (aVar != null) {
            if (!this.l) {
                this.f71034h = aVar.f71042d;
                aVar.f71042d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f71030d) {
            if (!this.l) {
                d.o.a.e.b.i.a aVar2 = this.f71032f;
                if (aVar2 == null && this.p < this.f71029c) {
                    this.p++;
                    return new d.o.a.e.b.i.a(this.f71028b);
                }
                while (aVar2 == null) {
                    this.f71030d.wait();
                    if (!this.l) {
                        aVar2 = this.f71032f;
                    } else {
                        throw new p("");
                    }
                }
                this.f71034h = aVar2.f71042d;
                this.f71033g = null;
                this.f71032f = null;
                aVar2.f71042d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    public final d.o.a.e.b.i.a l() throws BaseException, InterruptedException {
        d.o.a.e.b.i.a aVar;
        d.o.a.e.b.i.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f71042d;
            aVar2.f71042d = null;
            return aVar2;
        }
        synchronized (this.f71031e) {
            aVar = this.f71035i;
            if (aVar == null) {
                while (!this.m) {
                    this.f71031e.wait();
                    aVar = this.f71035i;
                    if (aVar != null) {
                    }
                }
                m();
                throw null;
            }
            this.k = aVar.f71042d;
            this.j = null;
            this.f71035i = null;
            aVar.f71042d = null;
        }
        return aVar;
    }

    public final void m() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException((int) RevenueServerConst.GetUserYbDetailsRequest, "async reader closed!");
            }
            e.A(th, "async_read");
            throw null;
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    @Override // d.o.a.e.b.h.b
    public void a(d.o.a.e.b.i.a aVar) {
        g(aVar);
    }

    @Override // d.o.a.e.b.h.b
    public void b() {
        synchronized (this.f71030d) {
            this.l = true;
            this.f71030d.notify();
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
}
