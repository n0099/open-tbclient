package d.o.a.e.b.h;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import d.o.a.e.b.g.d;
import d.o.a.e.b.l.e;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f68004a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68005b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68006c;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.e.b.i.a f68009f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.i.a f68010g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.i.a f68011h;
    public d.o.a.e.b.i.a i;
    public d.o.a.e.b.i.a j;
    public d.o.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f68007d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f68008e = new Object();
    public final Runnable q = new RunnableC1882a();

    /* renamed from: d.o.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1882a implements Runnable {
        public RunnableC1882a() {
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
                    k.f68017c = a.this.f68004a.read(k.f68015a);
                    a.this.j(k);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f68008e) {
                            a.this.m = true;
                            a.this.f68008e.notify();
                            e.C(a.this.f68004a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f68008e) {
                            a.this.m = true;
                            a.this.f68008e.notify();
                            e.C(a.this.f68004a);
                            throw th2;
                        }
                    }
                }
            } while (k.f68017c != -1);
            synchronized (a.this.f68008e) {
                a.this.m = true;
                a.this.f68008e.notify();
            }
            e.C(a.this.f68004a);
        }
    }

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f68004a = inputStream;
        this.f68005b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.f68006c = i2;
        i();
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws BaseException, InterruptedException {
        return l();
    }

    public final void g(d.o.a.e.b.i.a aVar) {
        synchronized (this.f68007d) {
            d.o.a.e.b.i.a aVar2 = this.f68010g;
            if (aVar2 == null) {
                this.f68010g = aVar;
                this.f68009f = aVar;
                this.f68007d.notify();
            } else {
                aVar2.f68018d = aVar;
                this.f68010g = aVar;
            }
        }
    }

    public final void i() throws Throwable {
        this.o = d.B0().submit(this.q);
    }

    public final void j(d.o.a.e.b.i.a aVar) {
        synchronized (this.f68008e) {
            d.o.a.e.b.i.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.i = aVar;
                this.f68008e.notify();
            } else {
                aVar2.f68018d = aVar;
                this.j = aVar;
            }
        }
    }

    public final d.o.a.e.b.i.a k() throws p, InterruptedException {
        d.o.a.e.b.i.a aVar = this.f68011h;
        if (aVar != null) {
            if (!this.l) {
                this.f68011h = aVar.f68018d;
                aVar.f68018d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f68007d) {
            if (!this.l) {
                d.o.a.e.b.i.a aVar2 = this.f68009f;
                if (aVar2 == null && this.p < this.f68006c) {
                    this.p++;
                    return new d.o.a.e.b.i.a(this.f68005b);
                }
                while (aVar2 == null) {
                    this.f68007d.wait();
                    if (!this.l) {
                        aVar2 = this.f68009f;
                    } else {
                        throw new p("");
                    }
                }
                this.f68011h = aVar2.f68018d;
                this.f68010g = null;
                this.f68009f = null;
                aVar2.f68018d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    public final d.o.a.e.b.i.a l() throws BaseException, InterruptedException {
        d.o.a.e.b.i.a aVar;
        d.o.a.e.b.i.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f68018d;
            aVar2.f68018d = null;
            return aVar2;
        }
        synchronized (this.f68008e) {
            aVar = this.i;
            if (aVar == null) {
                while (!this.m) {
                    this.f68008e.wait();
                    aVar = this.i;
                    if (aVar != null) {
                    }
                }
                m();
                throw null;
            }
            this.k = aVar.f68018d;
            this.j = null;
            this.i = null;
            aVar.f68018d = null;
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
        synchronized (this.f68007d) {
            this.l = true;
            this.f68007d.notify();
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
