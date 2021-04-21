package d.p.a.e.b.h;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import d.p.a.e.b.g.d;
import d.p.a.e.b.l.e;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f68151a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68152b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68153c;

    /* renamed from: f  reason: collision with root package name */
    public d.p.a.e.b.i.a f68156f;

    /* renamed from: g  reason: collision with root package name */
    public d.p.a.e.b.i.a f68157g;

    /* renamed from: h  reason: collision with root package name */
    public d.p.a.e.b.i.a f68158h;
    public d.p.a.e.b.i.a i;
    public d.p.a.e.b.i.a j;
    public d.p.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f68154d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f68155e = new Object();
    public final Runnable q = new RunnableC1886a();

    /* renamed from: d.p.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1886a implements Runnable {
        public RunnableC1886a() {
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            d.p.a.e.b.i.a k;
            Process.setThreadPriority(10);
            do {
                try {
                    k = a.this.k();
                    k.f68164c = a.this.f68151a.read(k.f68162a);
                    a.this.j(k);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f68155e) {
                            a.this.m = true;
                            a.this.f68155e.notify();
                            e.C(a.this.f68151a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f68155e) {
                            a.this.m = true;
                            a.this.f68155e.notify();
                            e.C(a.this.f68151a);
                            throw th2;
                        }
                    }
                }
            } while (k.f68164c != -1);
            synchronized (a.this.f68155e) {
                a.this.m = true;
                a.this.f68155e.notify();
            }
            e.C(a.this.f68151a);
        }
    }

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f68151a = inputStream;
        this.f68152b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.f68153c = i2;
        i();
    }

    @Override // d.p.a.e.b.h.b
    public d.p.a.e.b.i.a a() throws BaseException, InterruptedException {
        return l();
    }

    public final void g(d.p.a.e.b.i.a aVar) {
        synchronized (this.f68154d) {
            d.p.a.e.b.i.a aVar2 = this.f68157g;
            if (aVar2 == null) {
                this.f68157g = aVar;
                this.f68156f = aVar;
                this.f68154d.notify();
            } else {
                aVar2.f68165d = aVar;
                this.f68157g = aVar;
            }
        }
    }

    public final void i() throws Throwable {
        this.o = d.B0().submit(this.q);
    }

    public final void j(d.p.a.e.b.i.a aVar) {
        synchronized (this.f68155e) {
            d.p.a.e.b.i.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.i = aVar;
                this.f68155e.notify();
            } else {
                aVar2.f68165d = aVar;
                this.j = aVar;
            }
        }
    }

    public final d.p.a.e.b.i.a k() throws p, InterruptedException {
        d.p.a.e.b.i.a aVar = this.f68158h;
        if (aVar != null) {
            if (!this.l) {
                this.f68158h = aVar.f68165d;
                aVar.f68165d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f68154d) {
            if (!this.l) {
                d.p.a.e.b.i.a aVar2 = this.f68156f;
                if (aVar2 == null && this.p < this.f68153c) {
                    this.p++;
                    return new d.p.a.e.b.i.a(this.f68152b);
                }
                while (aVar2 == null) {
                    this.f68154d.wait();
                    if (!this.l) {
                        aVar2 = this.f68156f;
                    } else {
                        throw new p("");
                    }
                }
                this.f68158h = aVar2.f68165d;
                this.f68157g = null;
                this.f68156f = null;
                aVar2.f68165d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    public final d.p.a.e.b.i.a l() throws BaseException, InterruptedException {
        d.p.a.e.b.i.a aVar;
        d.p.a.e.b.i.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f68165d;
            aVar2.f68165d = null;
            return aVar2;
        }
        synchronized (this.f68155e) {
            aVar = this.i;
            if (aVar == null) {
                while (!this.m) {
                    this.f68155e.wait();
                    aVar = this.i;
                    if (aVar != null) {
                    }
                }
                m();
                throw null;
            }
            this.k = aVar.f68165d;
            this.j = null;
            this.i = null;
            aVar.f68165d = null;
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

    @Override // d.p.a.e.b.h.b
    public void a(d.p.a.e.b.i.a aVar) {
        g(aVar);
    }

    @Override // d.p.a.e.b.h.b
    public void b() {
        synchronized (this.f68154d) {
            this.l = true;
            this.f68154d.notify();
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
