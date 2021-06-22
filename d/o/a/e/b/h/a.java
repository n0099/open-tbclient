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
    public final InputStream f71131a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71132b;

    /* renamed from: c  reason: collision with root package name */
    public final int f71133c;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.e.b.i.a f71136f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.i.a f71137g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.i.a f71138h;

    /* renamed from: i  reason: collision with root package name */
    public d.o.a.e.b.i.a f71139i;
    public d.o.a.e.b.i.a j;
    public d.o.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f71134d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f71135e = new Object();
    public final Runnable q = new RunnableC1952a();

    /* renamed from: d.o.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1952a implements Runnable {
        public RunnableC1952a() {
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
                    k.f71145c = a.this.f71131a.read(k.f71143a);
                    a.this.j(k);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f71135e) {
                            a.this.m = true;
                            a.this.f71135e.notify();
                            e.C(a.this.f71131a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f71135e) {
                            a.this.m = true;
                            a.this.f71135e.notify();
                            e.C(a.this.f71131a);
                            throw th2;
                        }
                    }
                }
            } while (k.f71145c != -1);
            synchronized (a.this.f71135e) {
                a.this.m = true;
                a.this.f71135e.notify();
            }
            e.C(a.this.f71131a);
        }
    }

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.f71131a = inputStream;
        this.f71132b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f71133c = i3;
        i();
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws BaseException, InterruptedException {
        return l();
    }

    public final void g(d.o.a.e.b.i.a aVar) {
        synchronized (this.f71134d) {
            d.o.a.e.b.i.a aVar2 = this.f71137g;
            if (aVar2 == null) {
                this.f71137g = aVar;
                this.f71136f = aVar;
                this.f71134d.notify();
            } else {
                aVar2.f71146d = aVar;
                this.f71137g = aVar;
            }
        }
    }

    public final void i() throws Throwable {
        this.o = d.B0().submit(this.q);
    }

    public final void j(d.o.a.e.b.i.a aVar) {
        synchronized (this.f71135e) {
            d.o.a.e.b.i.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.f71139i = aVar;
                this.f71135e.notify();
            } else {
                aVar2.f71146d = aVar;
                this.j = aVar;
            }
        }
    }

    public final d.o.a.e.b.i.a k() throws p, InterruptedException {
        d.o.a.e.b.i.a aVar = this.f71138h;
        if (aVar != null) {
            if (!this.l) {
                this.f71138h = aVar.f71146d;
                aVar.f71146d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f71134d) {
            if (!this.l) {
                d.o.a.e.b.i.a aVar2 = this.f71136f;
                if (aVar2 == null && this.p < this.f71133c) {
                    this.p++;
                    return new d.o.a.e.b.i.a(this.f71132b);
                }
                while (aVar2 == null) {
                    this.f71134d.wait();
                    if (!this.l) {
                        aVar2 = this.f71136f;
                    } else {
                        throw new p("");
                    }
                }
                this.f71138h = aVar2.f71146d;
                this.f71137g = null;
                this.f71136f = null;
                aVar2.f71146d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    public final d.o.a.e.b.i.a l() throws BaseException, InterruptedException {
        d.o.a.e.b.i.a aVar;
        d.o.a.e.b.i.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f71146d;
            aVar2.f71146d = null;
            return aVar2;
        }
        synchronized (this.f71135e) {
            aVar = this.f71139i;
            if (aVar == null) {
                while (!this.m) {
                    this.f71135e.wait();
                    aVar = this.f71139i;
                    if (aVar != null) {
                    }
                }
                m();
                throw null;
            }
            this.k = aVar.f71146d;
            this.j = null;
            this.f71139i = null;
            aVar.f71146d = null;
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
        synchronized (this.f71134d) {
            this.l = true;
            this.f71134d.notify();
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
