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
    public final InputStream f66512a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66513b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66514c;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.e.b.i.a f66517f;

    /* renamed from: g  reason: collision with root package name */
    public d.o.a.e.b.i.a f66518g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.i.a f66519h;

    /* renamed from: i  reason: collision with root package name */
    public d.o.a.e.b.i.a f66520i;
    public d.o.a.e.b.i.a j;
    public d.o.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;

    /* renamed from: d  reason: collision with root package name */
    public final Object f66515d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public final Object f66516e = new Object();
    public final Runnable q = new RunnableC1821a();

    /* renamed from: d.o.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1821a implements Runnable {
        public RunnableC1821a() {
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
                    k.f66526c = a.this.f66512a.read(k.f66524a);
                    a.this.j(k);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f66516e) {
                            a.this.m = true;
                            a.this.f66516e.notify();
                            e.C(a.this.f66512a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f66516e) {
                            a.this.m = true;
                            a.this.f66516e.notify();
                            e.C(a.this.f66512a);
                            throw th2;
                        }
                    }
                }
            } while (k.f66526c != -1);
            synchronized (a.this.f66516e) {
                a.this.m = true;
                a.this.f66516e.notify();
            }
            e.C(a.this.f66512a);
        }
    }

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.f66512a = inputStream;
        this.f66513b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f66514c = i3;
        i();
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws BaseException, InterruptedException {
        return l();
    }

    public final void g(d.o.a.e.b.i.a aVar) {
        synchronized (this.f66515d) {
            d.o.a.e.b.i.a aVar2 = this.f66518g;
            if (aVar2 == null) {
                this.f66518g = aVar;
                this.f66517f = aVar;
                this.f66515d.notify();
            } else {
                aVar2.f66527d = aVar;
                this.f66518g = aVar;
            }
        }
    }

    public final void i() throws Throwable {
        this.o = d.B0().submit(this.q);
    }

    public final void j(d.o.a.e.b.i.a aVar) {
        synchronized (this.f66516e) {
            d.o.a.e.b.i.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.f66520i = aVar;
                this.f66516e.notify();
            } else {
                aVar2.f66527d = aVar;
                this.j = aVar;
            }
        }
    }

    public final d.o.a.e.b.i.a k() throws p, InterruptedException {
        d.o.a.e.b.i.a aVar = this.f66519h;
        if (aVar != null) {
            if (!this.l) {
                this.f66519h = aVar.f66527d;
                aVar.f66527d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f66515d) {
            if (!this.l) {
                d.o.a.e.b.i.a aVar2 = this.f66517f;
                if (aVar2 == null && this.p < this.f66514c) {
                    this.p++;
                    return new d.o.a.e.b.i.a(this.f66513b);
                }
                while (aVar2 == null) {
                    this.f66515d.wait();
                    if (!this.l) {
                        aVar2 = this.f66517f;
                    } else {
                        throw new p("");
                    }
                }
                this.f66519h = aVar2.f66527d;
                this.f66518g = null;
                this.f66517f = null;
                aVar2.f66527d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    public final d.o.a.e.b.i.a l() throws BaseException, InterruptedException {
        d.o.a.e.b.i.a aVar;
        d.o.a.e.b.i.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.f66527d;
            aVar2.f66527d = null;
            return aVar2;
        }
        synchronized (this.f66516e) {
            aVar = this.f66520i;
            if (aVar == null) {
                while (!this.m) {
                    this.f66516e.wait();
                    aVar = this.f66520i;
                    if (aVar != null) {
                    }
                }
                m();
                throw null;
            }
            this.k = aVar.f66527d;
            this.j = null;
            this.f66520i = null;
            aVar.f66527d = null;
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
        synchronized (this.f66515d) {
            this.l = true;
            this.f66515d.notify();
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
