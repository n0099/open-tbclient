package d.b.c.a.b.a.c;

import com.baidu.searchbox.http.response.ResponseException;
import com.bytedance.sdk.a.b.a.e.o;
import d.b.c.a.b.a.c.e;
import d.b.c.a.b.a.e;
import d.b.c.a.b.i;
import d.b.c.a.b.n;
import d.b.c.a.b.t;
import d.b.c.a.b.w;
import d.b.c.a.b.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
/* loaded from: classes5.dex */
public final class f {
    public static final /* synthetic */ boolean o = !f.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public final d.b.c.a.b.b f64514a;

    /* renamed from: b  reason: collision with root package name */
    public e.a f64515b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.a.b.e f64516c;

    /* renamed from: d  reason: collision with root package name */
    public final n f64517d;

    /* renamed from: e  reason: collision with root package name */
    public final i f64518e;

    /* renamed from: f  reason: collision with root package name */
    public final t f64519f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f64520g;

    /* renamed from: h  reason: collision with root package name */
    public final e f64521h;

    /* renamed from: i  reason: collision with root package name */
    public int f64522i;
    public c j;
    public boolean k;
    public boolean l;
    public boolean m;
    public e.InterfaceC1758e n;

    /* loaded from: classes5.dex */
    public static final class a extends WeakReference<f> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f64523a;

        public a(f fVar, Object obj) {
            super(fVar);
            this.f64523a = obj;
        }
    }

    public f(n nVar, d.b.c.a.b.b bVar, i iVar, t tVar, Object obj) {
        this.f64517d = nVar;
        this.f64514a = bVar;
        this.f64518e = iVar;
        this.f64519f = tVar;
        this.f64521h = new e(bVar, p(), iVar, tVar);
        this.f64520g = obj;
    }

    public final c a(int i2, int i3, int i4, boolean z) throws IOException {
        Socket o2;
        Socket socket;
        c cVar;
        c cVar2;
        d.b.c.a.b.e eVar;
        boolean z2;
        boolean z3;
        e.a aVar;
        synchronized (this.f64517d) {
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
                            d.b.c.a.b.a.b.f64489a.b(this.f64517d, this.f64514a, this, null);
                            if (this.j != null) {
                                cVar2 = this.j;
                                eVar = null;
                                z2 = true;
                            } else {
                                eVar = this.f64516c;
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
        d.b.c.a.b.a.e.r(o2);
        if (cVar != null) {
            this.f64519f.p(this.f64518e, cVar);
        }
        if (z2) {
            this.f64519f.e(this.f64518e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (eVar != null || ((aVar = this.f64515b) != null && aVar.a())) {
            z3 = false;
        } else {
            this.f64515b = this.f64521h.f();
            z3 = true;
        }
        synchronized (this.f64517d) {
            if (this.m) {
                throw new IOException(ResponseException.CANCELED);
            }
            if (z3) {
                List<d.b.c.a.b.e> c2 = this.f64515b.c();
                int size = c2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    d.b.c.a.b.e eVar2 = c2.get(i5);
                    d.b.c.a.b.a.b.f64489a.b(this.f64517d, this.f64514a, this, eVar2);
                    if (this.j != null) {
                        cVar2 = this.j;
                        this.f64516c = eVar2;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (eVar == null) {
                    eVar = this.f64515b.b();
                }
                this.f64516c = eVar;
                this.f64522i = 0;
                cVar2 = new c(this.f64517d, eVar);
                g(cVar2, false);
            }
        }
        if (z2) {
            this.f64519f.e(this.f64518e, cVar2);
            return cVar2;
        }
        cVar2.f(i2, i3, i4, z, this.f64518e, this.f64519f);
        p().b(cVar2.a());
        synchronized (this.f64517d) {
            this.k = true;
            d.b.c.a.b.a.b.f64489a.j(this.f64517d, cVar2);
            if (cVar2.o()) {
                socket = d.b.c.a.b.a.b.f64489a.d(this.f64517d, this.f64514a, this);
                cVar2 = this.j;
            }
        }
        d.b.c.a.b.a.e.r(socket);
        this.f64519f.e(this.f64518e, cVar2);
        return cVar2;
    }

    public final c b(int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i2, i3, i4, z);
            synchronized (this.f64517d) {
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

    public e.InterfaceC1758e c() {
        e.InterfaceC1758e interfaceC1758e;
        synchronized (this.f64517d) {
            interfaceC1758e = this.n;
        }
        return interfaceC1758e;
    }

    public e.InterfaceC1758e d(y yVar, w.a aVar, boolean z) {
        try {
            e.InterfaceC1758e c2 = b(aVar.b(), aVar.c(), aVar.d(), yVar.u(), z).c(yVar, aVar, this);
            synchronized (this.f64517d) {
                this.n = c2;
            }
            return c2;
        } catch (IOException e2) {
            throw new com.bytedance.sdk.a.b.a.b.e(e2);
        }
    }

    public Socket e(c cVar) {
        if (o || Thread.holdsLock(this.f64517d)) {
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
        if (o || Thread.holdsLock(this.f64517d)) {
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
                            if (d.b.c.a.b.a.b.f64489a.i(this.f64517d, this.j)) {
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
        if (!o && !Thread.holdsLock(this.f64517d)) {
            throw new AssertionError();
        }
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.f64520g));
            return;
        }
        throw new IllegalStateException();
    }

    public void h(IOException iOException) {
        c cVar;
        boolean z;
        Socket f2;
        synchronized (this.f64517d) {
            cVar = null;
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f27685a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.f64522i++;
                }
                if (oVar.f27685a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.f64522i > 1) {
                    this.f64516c = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.j != null && (!this.j.o() || (iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                    if (this.j.l == 0) {
                        if (this.f64516c != null && iOException != null) {
                            this.f64521h.b(this.f64516c, iOException);
                        }
                        this.f64516c = null;
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
        d.b.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f64519f.p(this.f64518e, cVar);
        }
    }

    public void i(boolean z, e.InterfaceC1758e interfaceC1758e, long j, IOException iOException) {
        c cVar;
        Socket f2;
        boolean z2;
        this.f64519f.o(this.f64518e, j);
        synchronized (this.f64517d) {
            if (interfaceC1758e != null) {
                if (interfaceC1758e == this.n) {
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
            throw new IllegalStateException("expected " + this.n + " but was " + interfaceC1758e);
        }
        d.b.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f64519f.p(this.f64518e, cVar);
        }
        if (iOException != null) {
            this.f64519f.h(this.f64518e, iOException);
        } else if (z2) {
            this.f64519f.u(this.f64518e);
        }
    }

    public synchronized c j() {
        return this.j;
    }

    public final void k(c cVar) {
        int size = cVar.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.n.get(i2).get() == this) {
                cVar.n.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void l() {
        c cVar;
        Socket f2;
        synchronized (this.f64517d) {
            cVar = this.j;
            f2 = f(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.b.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f64519f.p(this.f64518e, cVar);
        }
    }

    public void m() {
        c cVar;
        Socket f2;
        synchronized (this.f64517d) {
            cVar = this.j;
            f2 = f(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.b.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f64519f.p(this.f64518e, cVar);
        }
    }

    public boolean n() {
        e.a aVar;
        return this.f64516c != null || ((aVar = this.f64515b) != null && aVar.a()) || this.f64521h.e();
    }

    public final Socket o() {
        if (o || Thread.holdsLock(this.f64517d)) {
            c cVar = this.j;
            if (cVar == null || !cVar.k) {
                return null;
            }
            return f(false, false, true);
        }
        throw new AssertionError();
    }

    public final d p() {
        return d.b.c.a.b.a.b.f64489a.c(this.f64517d);
    }

    public String toString() {
        c j = j();
        return j != null ? j.toString() : this.f64514a.toString();
    }
}
