package d.o.a.e.b.h;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import d.o.a.e.b.g.d;
import d.o.a.e.b.l.e;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f67198a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67199b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67200c;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.e.b.i.a f67203f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.i.a f67204g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.i.a f67205h;

    /* renamed from: i  reason: collision with root package name */
    public d.o.a.e.b.i.a f67206i;
    public d.o.a.e.b.i.a j;
    public d.o.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f67201d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f67202e = new Object();
    public final Runnable q = new RunnableC1885a();

    /* renamed from: d.o.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1885a implements Runnable {
        public RunnableC1885a() {
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
                    k.f67212c = a.this.f67198a.read(k.f67210a);
                    a.this.j(k);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f67202e) {
                            a.this.m = true;
                            a.this.f67202e.notify();
                            e.C(a.this.f67198a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f67202e) {
                            a.this.m = true;
                            a.this.f67202e.notify();
                            e.C(a.this.f67198a);
                            throw th2;
                        }
                    }
                }
            } while (k.f67212c != -1);
            synchronized (a.this.f67202e) {
                a.this.m = true;
                a.this.f67202e.notify();
            }
            e.C(a.this.f67198a);
        }
    }

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.f67198a = inputStream;
        this.f67199b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f67200c = i3;
        i();
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws BaseException, InterruptedException {
        return l();
    }

    public final void g(d.o.a.e.b.i.a aVar) {
        synchronized (this.f67201d) {
            d.o.a.e.b.i.a aVar2 = this.f67204g;
            if (aVar2 == null) {
                this.f67204g = aVar;
                this.f67203f = aVar;
                this.f67201d.notify();
            } else {
                aVar2.f67213d = aVar;
                this.f67204g = aVar;
            }
        }
    }

    public final void i() throws Throwable {
        this.o = d.B0().submit(this.q);
    }

    public final void j(d.o.a.e.b.i.a aVar) {
        synchronized (this.f67202e) {
            d.o.a.e.b.i.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.f67206i = aVar;
                this.f67202e.notify();
            } else {
                aVar2.f67213d = aVar;
                this.j = aVar;
            }
        }
    }

    public final d.o.a.e.b.i.a k() throws p, InterruptedException {
        d.o.a.e.b.i.a aVar = this.f67205h;
        if (aVar != null) {
            if (!this.l) {
                this.f67205h = aVar.f67213d;
                aVar.f67213d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f67201d) {
            if (!this.l) {
                d.o.a.e.b.i.a aVar2 = this.f67203f;
                if (aVar2 == null && this.p < this.f67200c) {
                    this.p++;
                    return new d.o.a.e.b.i.a(this.f67199b);
                }
                while (aVar2 == null) {
                    this.f67201d.wait();
                    if (!this.l) {
                        aVar2 = this.f67203f;
                    } else {
                        throw new p("");
                    }
                }
                this.f67205h = aVar2.f67213d;
                this.f67204g = null;
                this.f67203f = null;
                aVar2.f67213d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    public final d.o.a.e.b.i.a l() throws BaseException, InterruptedException {
        d.o.a.e.b.i.a aVar;
        d.o.a.e.b.i.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f67213d;
            aVar2.f67213d = null;
            return aVar2;
        }
        synchronized (this.f67202e) {
            aVar = this.f67206i;
            if (aVar == null) {
                while (!this.m) {
                    this.f67202e.wait();
                    aVar = this.f67206i;
                    if (aVar != null) {
                    }
                }
                m();
                throw null;
            }
            this.k = aVar.f67213d;
            this.j = null;
            this.f67206i = null;
            aVar.f67213d = null;
        }
        return aVar;
    }

    public final void m() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException(1068, "async reader closed!");
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
        synchronized (this.f67201d) {
            this.l = true;
            this.f67201d.notify();
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
