package d.c.c.a.b.a.c;

import com.baidu.searchbox.http.response.ResponseException;
import com.bytedance.sdk.a.b.a.e.o;
import d.c.c.a.b.a.c.e;
import d.c.c.a.b.a.e;
import d.c.c.a.b.i;
import d.c.c.a.b.n;
import d.c.c.a.b.t;
import d.c.c.a.b.w;
import d.c.c.a.b.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
/* loaded from: classes5.dex */
public final class f {
    public static final /* synthetic */ boolean o = !f.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public final d.c.c.a.b.b f66148a;

    /* renamed from: b  reason: collision with root package name */
    public e.a f66149b;

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.a.b.e f66150c;

    /* renamed from: d  reason: collision with root package name */
    public final n f66151d;

    /* renamed from: e  reason: collision with root package name */
    public final i f66152e;

    /* renamed from: f  reason: collision with root package name */
    public final t f66153f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f66154g;

    /* renamed from: h  reason: collision with root package name */
    public final e f66155h;
    public int i;
    public c j;
    public boolean k;
    public boolean l;
    public boolean m;
    public e.InterfaceC1818e n;

    /* loaded from: classes5.dex */
    public static final class a extends WeakReference<f> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f66156a;

        public a(f fVar, Object obj) {
            super(fVar);
            this.f66156a = obj;
        }
    }

    public f(n nVar, d.c.c.a.b.b bVar, i iVar, t tVar, Object obj) {
        this.f66151d = nVar;
        this.f66148a = bVar;
        this.f66152e = iVar;
        this.f66153f = tVar;
        this.f66155h = new e(bVar, p(), iVar, tVar);
        this.f66154g = obj;
    }

    public final c a(int i, int i2, int i3, boolean z) throws IOException {
        Socket o2;
        Socket socket;
        c cVar;
        c cVar2;
        d.c.c.a.b.e eVar;
        boolean z2;
        boolean z3;
        e.a aVar;
        synchronized (this.f66151d) {
            if (!this.l) {
                if (this.n == null) {
                    if (!this.m) {
                        c cVar3 = this.j;
                        o2 = o();
                        socket = null;
                        if (this.j != null) {
                            cVar2 = this.j;
                            cVar = null;
                        } else {
                            cVar = cVar3;
                            cVar2 = null;
                        }
                        if (!this.k) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            d.c.c.a.b.a.b.f66124a.b(this.f66151d, this.f66148a, this, null);
                            if (this.j != null) {
                                cVar2 = this.j;
                                eVar = null;
                                z2 = true;
                            } else {
                                eVar = this.f66150c;
                            }
                        } else {
                            eVar = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException(ResponseException.CANCELED);
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        d.c.c.a.b.a.e.r(o2);
        if (cVar != null) {
            this.f66153f.p(this.f66152e, cVar);
        }
        if (z2) {
            this.f66153f.e(this.f66152e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (eVar != null || ((aVar = this.f66149b) != null && aVar.a())) {
            z3 = false;
        } else {
            this.f66149b = this.f66155h.f();
            z3 = true;
        }
        synchronized (this.f66151d) {
            if (this.m) {
                throw new IOException(ResponseException.CANCELED);
            }
            if (z3) {
                List<d.c.c.a.b.e> c2 = this.f66149b.c();
                int size = c2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    d.c.c.a.b.e eVar2 = c2.get(i4);
                    d.c.c.a.b.a.b.f66124a.b(this.f66151d, this.f66148a, this, eVar2);
                    if (this.j != null) {
                        cVar2 = this.j;
                        this.f66150c = eVar2;
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            if (!z2) {
                if (eVar == null) {
                    eVar = this.f66149b.b();
                }
                this.f66150c = eVar;
                this.i = 0;
                cVar2 = new c(this.f66151d, eVar);
                g(cVar2, false);
            }
        }
        if (z2) {
            this.f66153f.e(this.f66152e, cVar2);
            return cVar2;
        }
        cVar2.f(i, i2, i3, z, this.f66152e, this.f66153f);
        p().b(cVar2.a());
        synchronized (this.f66151d) {
            this.k = true;
            d.c.c.a.b.a.b.f66124a.j(this.f66151d, cVar2);
            if (cVar2.o()) {
                socket = d.c.c.a.b.a.b.f66124a.d(this.f66151d, this.f66148a, this);
                cVar2 = this.j;
            }
        }
        d.c.c.a.b.a.e.r(socket);
        this.f66153f.e(this.f66152e, cVar2);
        return cVar2;
    }

    public final c b(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i, i2, i3, z);
            synchronized (this.f66151d) {
                if (a2.l == 0) {
                    return a2;
                }
                if (a2.l(z2)) {
                    return a2;
                }
                m();
            }
        }
    }

    public e.InterfaceC1818e c() {
        e.InterfaceC1818e interfaceC1818e;
        synchronized (this.f66151d) {
            interfaceC1818e = this.n;
        }
        return interfaceC1818e;
    }

    public e.InterfaceC1818e d(y yVar, w.a aVar, boolean z) {
        try {
            e.InterfaceC1818e c2 = b(aVar.b(), aVar.c(), aVar.d(), yVar.u(), z).c(yVar, aVar, this);
            synchronized (this.f66151d) {
                this.n = c2;
            }
            return c2;
        } catch (IOException e2) {
            throw new com.bytedance.sdk.a.b.a.b.e(e2);
        }
    }

    public Socket e(c cVar) {
        if (o || Thread.holdsLock(this.f66151d)) {
            if (this.n == null && this.j.n.size() == 1) {
                Socket f2 = f(true, false, false);
                this.j = cVar;
                cVar.n.add(this.j.n.get(0));
                return f2;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public final Socket f(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (o || Thread.holdsLock(this.f66151d)) {
            if (z3) {
                this.n = null;
            }
            if (z2) {
                this.l = true;
            }
            c cVar = this.j;
            if (cVar != null) {
                if (z) {
                    cVar.k = true;
                }
                if (this.n == null) {
                    if (this.l || this.j.k) {
                        k(this.j);
                        if (this.j.n.isEmpty()) {
                            this.j.o = System.nanoTime();
                            if (d.c.c.a.b.a.b.f66124a.i(this.f66151d, this.j)) {
                                socket = this.j.m();
                                this.j = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.j = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new AssertionError();
    }

    public void g(c cVar, boolean z) {
        if (!o && !Thread.holdsLock(this.f66151d)) {
            throw new AssertionError();
        }
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.f66154g));
            return;
        }
        throw new IllegalStateException();
    }

    public void h(IOException iOException) {
        c cVar;
        boolean z;
        Socket f2;
        synchronized (this.f66151d) {
            cVar = null;
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f26871a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.i++;
                }
                if (oVar.f26871a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.i > 1) {
                    this.f66150c = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.j != null && (!this.j.o() || (iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                    if (this.j.l == 0) {
                        if (this.f66150c != null && iOException != null) {
                            this.f66155h.b(this.f66150c, iOException);
                        }
                        this.f66150c = null;
                    }
                    z = true;
                }
                z = false;
            }
            c cVar2 = this.j;
            f2 = f(z, false, true);
            if (this.j == null && this.k) {
                cVar = cVar2;
            }
        }
        d.c.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f66153f.p(this.f66152e, cVar);
        }
    }

    public void i(boolean z, e.InterfaceC1818e interfaceC1818e, long j, IOException iOException) {
        c cVar;
        Socket f2;
        boolean z2;
        this.f66153f.o(this.f66152e, j);
        synchronized (this.f66151d) {
            if (interfaceC1818e != null) {
                if (interfaceC1818e == this.n) {
                    if (!z) {
                        this.j.l++;
                    }
                    cVar = this.j;
                    f2 = f(z, false, true);
                    if (this.j != null) {
                        cVar = null;
                    }
                    z2 = this.l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + interfaceC1818e);
        }
        d.c.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f66153f.p(this.f66152e, cVar);
        }
        if (iOException != null) {
            this.f66153f.h(this.f66152e, iOException);
        } else if (z2) {
            this.f66153f.u(this.f66152e);
        }
    }

    public synchronized c j() {
        return this.j;
    }

    public final void k(c cVar) {
        int size = cVar.n.size();
        for (int i = 0; i < size; i++) {
            if (cVar.n.get(i).get() == this) {
                cVar.n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void l() {
        c cVar;
        Socket f2;
        synchronized (this.f66151d) {
            cVar = this.j;
            f2 = f(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.c.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f66153f.p(this.f66152e, cVar);
        }
    }

    public void m() {
        c cVar;
        Socket f2;
        synchronized (this.f66151d) {
            cVar = this.j;
            f2 = f(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.c.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f66153f.p(this.f66152e, cVar);
        }
    }

    public boolean n() {
        e.a aVar;
        return this.f66150c != null || ((aVar = this.f66149b) != null && aVar.a()) || this.f66155h.e();
    }

    public final Socket o() {
        if (o || Thread.holdsLock(this.f66151d)) {
            c cVar = this.j;
            if (cVar == null || !cVar.k) {
                return null;
            }
            return f(false, false, true);
        }
        throw new AssertionError();
    }

    public final d p() {
        return d.c.c.a.b.a.b.f66124a.c(this.f66151d);
    }

    public String toString() {
        c j = j();
        return j != null ? j.toString() : this.f66148a.toString();
    }
}
