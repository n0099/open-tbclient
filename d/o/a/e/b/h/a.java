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
    public final InputStream f67006a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67007b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67008c;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.e.b.i.a f67011f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.i.a f67012g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.i.a f67013h;
    public d.o.a.e.b.i.a i;
    public d.o.a.e.b.i.a j;
    public d.o.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f67009d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f67010e = new Object();
    public final Runnable q = new RunnableC1846a();

    /* renamed from: d.o.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1846a implements Runnable {
        public RunnableC1846a() {
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
                    k.f67019c = a.this.f67006a.read(k.f67017a);
                    a.this.j(k);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f67010e) {
                            a.this.m = true;
                            a.this.f67010e.notify();
                            e.C(a.this.f67006a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f67010e) {
                            a.this.m = true;
                            a.this.f67010e.notify();
                            e.C(a.this.f67006a);
                            throw th2;
                        }
                    }
                }
            } while (k.f67019c != -1);
            synchronized (a.this.f67010e) {
                a.this.m = true;
                a.this.f67010e.notify();
            }
            e.C(a.this.f67006a);
        }
    }

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f67006a = inputStream;
        this.f67007b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.f67008c = i2;
        i();
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws BaseException, InterruptedException {
        return l();
    }

    public final void g(d.o.a.e.b.i.a aVar) {
        synchronized (this.f67009d) {
            d.o.a.e.b.i.a aVar2 = this.f67012g;
            if (aVar2 == null) {
                this.f67012g = aVar;
                this.f67011f = aVar;
                this.f67009d.notify();
            } else {
                aVar2.f67020d = aVar;
                this.f67012g = aVar;
            }
        }
    }

    public final void i() throws Throwable {
        this.o = d.B0().submit(this.q);
    }

    public final void j(d.o.a.e.b.i.a aVar) {
        synchronized (this.f67010e) {
            d.o.a.e.b.i.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.i = aVar;
                this.f67010e.notify();
            } else {
                aVar2.f67020d = aVar;
                this.j = aVar;
            }
        }
    }

    public final d.o.a.e.b.i.a k() throws p, InterruptedException {
        d.o.a.e.b.i.a aVar = this.f67013h;
        if (aVar != null) {
            if (!this.l) {
                this.f67013h = aVar.f67020d;
                aVar.f67020d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f67009d) {
            if (!this.l) {
                d.o.a.e.b.i.a aVar2 = this.f67011f;
                if (aVar2 == null && this.p < this.f67008c) {
                    this.p++;
                    return new d.o.a.e.b.i.a(this.f67007b);
                }
                while (aVar2 == null) {
                    this.f67009d.wait();
                    if (!this.l) {
                        aVar2 = this.f67011f;
                    } else {
                        throw new p("");
                    }
                }
                this.f67013h = aVar2.f67020d;
                this.f67012g = null;
                this.f67011f = null;
                aVar2.f67020d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    public final d.o.a.e.b.i.a l() throws BaseException, InterruptedException {
        d.o.a.e.b.i.a aVar;
        d.o.a.e.b.i.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f67020d;
            aVar2.f67020d = null;
            return aVar2;
        }
        synchronized (this.f67010e) {
            aVar = this.i;
            if (aVar == null) {
                while (!this.m) {
                    this.f67010e.wait();
                    aVar = this.i;
                    if (aVar != null) {
                    }
                }
                m();
                throw null;
            }
            this.k = aVar.f67020d;
            this.j = null;
            this.i = null;
            aVar.f67020d = null;
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
        synchronized (this.f67009d) {
            this.l = true;
            this.f67009d.notify();
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
