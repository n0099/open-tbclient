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
/* loaded from: classes6.dex */
public final class f {
    public static final /* synthetic */ boolean o = !f.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public final d.b.c.a.b.b f69078a;

    /* renamed from: b  reason: collision with root package name */
    public e.a f69079b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.a.b.e f69080c;

    /* renamed from: d  reason: collision with root package name */
    public final n f69081d;

    /* renamed from: e  reason: collision with root package name */
    public final i f69082e;

    /* renamed from: f  reason: collision with root package name */
    public final t f69083f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f69084g;

    /* renamed from: h  reason: collision with root package name */
    public final e f69085h;

    /* renamed from: i  reason: collision with root package name */
    public int f69086i;
    public c j;
    public boolean k;
    public boolean l;
    public boolean m;
    public e.InterfaceC1888e n;

    /* loaded from: classes6.dex */
    public static final class a extends WeakReference<f> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f69087a;

        public a(f fVar, Object obj) {
            super(fVar);
            this.f69087a = obj;
        }
    }

    public f(n nVar, d.b.c.a.b.b bVar, i iVar, t tVar, Object obj) {
        this.f69081d = nVar;
        this.f69078a = bVar;
        this.f69082e = iVar;
        this.f69083f = tVar;
        this.f69085h = new e(bVar, p(), iVar, tVar);
        this.f69084g = obj;
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
        synchronized (this.f69081d) {
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
                            d.b.c.a.b.a.b.f69053a.b(this.f69081d, this.f69078a, this, null);
                            if (this.j != null) {
                                cVar2 = this.j;
                                eVar = null;
                                z2 = true;
                            } else {
                                eVar = this.f69080c;
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
            this.f69083f.p(this.f69082e, cVar);
        }
        if (z2) {
            this.f69083f.e(this.f69082e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (eVar != null || ((aVar = this.f69079b) != null && aVar.a())) {
            z3 = false;
        } else {
            this.f69079b = this.f69085h.f();
            z3 = true;
        }
        synchronized (this.f69081d) {
            if (this.m) {
                throw new IOException(ResponseException.CANCELED);
            }
            if (z3) {
                List<d.b.c.a.b.e> c2 = this.f69079b.c();
                int size = c2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    d.b.c.a.b.e eVar2 = c2.get(i5);
                    d.b.c.a.b.a.b.f69053a.b(this.f69081d, this.f69078a, this, eVar2);
                    if (this.j != null) {
                        cVar2 = this.j;
                        this.f69080c = eVar2;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (eVar == null) {
                    eVar = this.f69079b.b();
                }
                this.f69080c = eVar;
                this.f69086i = 0;
                cVar2 = new c(this.f69081d, eVar);
                g(cVar2, false);
            }
        }
        if (z2) {
            this.f69083f.e(this.f69082e, cVar2);
            return cVar2;
        }
        cVar2.f(i2, i3, i4, z, this.f69082e, this.f69083f);
        p().b(cVar2.a());
        synchronized (this.f69081d) {
            this.k = true;
            d.b.c.a.b.a.b.f69053a.j(this.f69081d, cVar2);
            if (cVar2.o()) {
                socket = d.b.c.a.b.a.b.f69053a.d(this.f69081d, this.f69078a, this);
                cVar2 = this.j;
            }
        }
        d.b.c.a.b.a.e.r(socket);
        this.f69083f.e(this.f69082e, cVar2);
        return cVar2;
    }

    public final c b(int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i2, i3, i4, z);
            synchronized (this.f69081d) {
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

    public e.InterfaceC1888e c() {
        e.InterfaceC1888e interfaceC1888e;
        synchronized (this.f69081d) {
            interfaceC1888e = this.n;
        }
        return interfaceC1888e;
    }

    public e.InterfaceC1888e d(y yVar, w.a aVar, boolean z) {
        try {
            e.InterfaceC1888e c2 = b(aVar.b(), aVar.c(), aVar.d(), yVar.u(), z).c(yVar, aVar, this);
            synchronized (this.f69081d) {
                this.n = c2;
            }
            return c2;
        } catch (IOException e2) {
            throw new com.bytedance.sdk.a.b.a.b.e(e2);
        }
    }

    public Socket e(c cVar) {
        if (o || Thread.holdsLock(this.f69081d)) {
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
        if (o || Thread.holdsLock(this.f69081d)) {
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
                            if (d.b.c.a.b.a.b.f69053a.i(this.f69081d, this.j)) {
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
        if (!o && !Thread.holdsLock(this.f69081d)) {
            throw new AssertionError();
        }
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.f69084g));
            return;
        }
        throw new IllegalStateException();
    }

    public void h(IOException iOException) {
        c cVar;
        boolean z;
        Socket f2;
        synchronized (this.f69081d) {
            cVar = null;
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f27044a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.f69086i++;
                }
                if (oVar.f27044a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.f69086i > 1) {
                    this.f69080c = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.j != null && (!this.j.o() || (iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                    if (this.j.l == 0) {
                        if (this.f69080c != null && iOException != null) {
                            this.f69085h.b(this.f69080c, iOException);
                        }
                        this.f69080c = null;
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
            this.f69083f.p(this.f69082e, cVar);
        }
    }

    public void i(boolean z, e.InterfaceC1888e interfaceC1888e, long j, IOException iOException) {
        c cVar;
        Socket f2;
        boolean z2;
        this.f69083f.o(this.f69082e, j);
        synchronized (this.f69081d) {
            if (interfaceC1888e != null) {
                if (interfaceC1888e == this.n) {
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
            throw new IllegalStateException("expected " + this.n + " but was " + interfaceC1888e);
        }
        d.b.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f69083f.p(this.f69082e, cVar);
        }
        if (iOException != null) {
            this.f69083f.h(this.f69082e, iOException);
        } else if (z2) {
            this.f69083f.u(this.f69082e);
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
        synchronized (this.f69081d) {
            cVar = this.j;
            f2 = f(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.b.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f69083f.p(this.f69082e, cVar);
        }
    }

    public void m() {
        c cVar;
        Socket f2;
        synchronized (this.f69081d) {
            cVar = this.j;
            f2 = f(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        d.b.c.a.b.a.e.r(f2);
        if (cVar != null) {
            this.f69083f.p(this.f69082e, cVar);
        }
    }

    public boolean n() {
        e.a aVar;
        return this.f69080c != null || ((aVar = this.f69079b) != null && aVar.a()) || this.f69085h.e();
    }

    public final Socket o() {
        if (o || Thread.holdsLock(this.f69081d)) {
            c cVar = this.j;
            if (cVar == null || !cVar.k) {
                return null;
            }
            return f(false, false, true);
        }
        throw new AssertionError();
    }

    public final d p() {
        return d.b.c.a.b.a.b.f69053a.c(this.f69081d);
    }

    public String toString() {
        c j = j();
        return j != null ? j.toString() : this.f69078a.toString();
    }
}
