package d.b.c.a.b.a.c;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.w;
import d.b.c.a.a.k;
import d.b.c.a.a.q;
import d.b.c.a.b.a.e;
import d.b.c.a.b.a.h.e;
import d.b.c.a.b.a.h.g;
import d.b.c.a.b.a0;
import d.b.c.a.b.c;
import d.b.c.a.b.i;
import d.b.c.a.b.m;
import d.b.c.a.b.n;
import d.b.c.a.b.o;
import d.b.c.a.b.t;
import d.b.c.a.b.u;
import d.b.c.a.b.w;
import d.b.c.a.b.y;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.connection.RealConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class c extends e.i implements m {

    /* renamed from: b  reason: collision with root package name */
    public final n f65181b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.c.a.b.e f65182c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f65183d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f65184e;

    /* renamed from: f  reason: collision with root package name */
    public u f65185f;

    /* renamed from: g  reason: collision with root package name */
    public w f65186g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.a.b.a.h.e f65187h;

    /* renamed from: i  reason: collision with root package name */
    public d.b.c.a.a.e f65188i;
    public d.b.c.a.a.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<f>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(n nVar, d.b.c.a.b.e eVar) {
        this.f65181b = nVar;
        this.f65182c = eVar;
    }

    @Override // d.b.c.a.b.m
    public d.b.c.a.b.e a() {
        return this.f65182c;
    }

    @Override // d.b.c.a.b.a.h.e.i
    public void b(g gVar) throws IOException {
        gVar.d(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
    }

    public e.InterfaceC1822e c(y yVar, w.a aVar, f fVar) throws SocketException {
        if (this.f65187h != null) {
            return new d.b.c.a.b.a.h.d(yVar, aVar, fVar, this.f65187h);
        }
        this.f65184e.setSoTimeout(aVar.c());
        this.f65188i.a().b(aVar.c(), TimeUnit.MILLISECONDS);
        this.j.a().b(aVar.d(), TimeUnit.MILLISECONDS);
        return new d.b.c.a.b.a.f.a(yVar, fVar, this.f65188i, this.j);
    }

    public final a0 d(int i2, int i3, a0 a0Var, s sVar) throws IOException {
        String str = "CONNECT " + d.b.c.a.b.a.e.h(sVar, true) + " HTTP/1.1";
        while (true) {
            d.b.c.a.b.a.f.a aVar = new d.b.c.a.b.a.f.a(null, null, this.f65188i, this.j);
            this.f65188i.a().b(i2, TimeUnit.MILLISECONDS);
            this.j.a().b(i3, TimeUnit.MILLISECONDS);
            aVar.g(a0Var.d(), str);
            aVar.b();
            c.a a2 = aVar.a(false);
            a2.h(a0Var);
            d.b.c.a.b.c k = a2.k();
            long c2 = e.g.c(k);
            if (c2 == -1) {
                c2 = 0;
            }
            q h2 = aVar.h(c2);
            d.b.c.a.b.a.e.A(h2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            h2.close();
            int r = k.r();
            if (r == 200) {
                if (this.f65188i.c().e() && this.j.c().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (r == 407) {
                a0 a3 = this.f65182c.a().e().a(this.f65182c, k);
                if (a3 != null) {
                    if (IntentConfig.CLOSE.equalsIgnoreCase(k.o(HTTP.CONN_DIRECTIVE))) {
                        return a3;
                    }
                    a0Var = a3;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + k.r());
            }
        }
    }

    public final void e(int i2, int i3, int i4, i iVar, t tVar) throws IOException {
        a0 p = p();
        s a2 = p.a();
        for (int i5 = 0; i5 < 21; i5++) {
            g(i2, i3, iVar, tVar);
            p = d(i3, i4, p, a2);
            if (p == null) {
                return;
            }
            d.b.c.a.b.a.e.r(this.f65183d);
            this.f65183d = null;
            this.j = null;
            this.f65188i = null;
            tVar.l(iVar, this.f65182c.c(), this.f65182c.b(), null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: IOException -> 0x00e1, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e1, blocks: (B:16:0x0075, B:18:0x007d), top: B:58:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(int i2, int i3, int i4, boolean z, i iVar, t tVar) {
        if (this.f65186g == null) {
            List<o> g2 = this.f65182c.a().g();
            b bVar = new b(g2);
            if (this.f65182c.a().j() == null) {
                if (g2.contains(o.f65539g)) {
                    String v = this.f65182c.a().a().v();
                    if (!d.b.c.a.b.a.i.e.j().m(v)) {
                        throw new com.bytedance.sdk.a.b.a.b.e(new UnknownServiceException("CLEARTEXT communication to " + v + " not permitted by network security policy"));
                    }
                } else {
                    throw new com.bytedance.sdk.a.b.a.b.e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            }
            com.bytedance.sdk.a.b.a.b.e eVar = null;
            do {
                try {
                    if (!this.f65182c.d()) {
                        e(i2, i3, i4, iVar, tVar);
                        if (this.f65183d == null) {
                            if (!this.f65182c.d() && this.f65183d == null) {
                                throw new com.bytedance.sdk.a.b.a.b.e(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                            if (this.f65187h != null) {
                                synchronized (this.f65181b) {
                                    this.m = this.f65187h.n();
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        try {
                            g(i2, i3, iVar, tVar);
                        } catch (IOException e2) {
                            e = e2;
                            d.b.c.a.b.a.e.r(this.f65184e);
                            d.b.c.a.b.a.e.r(this.f65183d);
                            this.f65184e = null;
                            this.f65183d = null;
                            this.f65188i = null;
                            this.j = null;
                            this.f65185f = null;
                            this.f65186g = null;
                            this.f65187h = null;
                            tVar.m(iVar, this.f65182c.c(), this.f65182c.b(), null, e);
                            if (eVar == null) {
                                eVar = new com.bytedance.sdk.a.b.a.b.e(e);
                            } else {
                                eVar.a(e);
                            }
                            if (!z || bVar.b(e)) {
                                throw eVar;
                            }
                            do {
                                if (!this.f65182c.d()) {
                                }
                                i(bVar, iVar, tVar);
                                tVar.l(iVar, this.f65182c.c(), this.f65182c.b(), this.f65186g);
                                if (!this.f65182c.d()) {
                                }
                                if (this.f65187h != null) {
                                }
                            } while (bVar.b(e));
                            throw eVar;
                        }
                    }
                    i(bVar, iVar, tVar);
                    tVar.l(iVar, this.f65182c.c(), this.f65182c.b(), this.f65186g);
                    if (!this.f65182c.d()) {
                    }
                    if (this.f65187h != null) {
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } while (bVar.b(e));
            throw eVar;
        }
        throw new IllegalStateException("already connected");
    }

    public final void g(int i2, int i3, i iVar, t tVar) throws IOException {
        Proxy b2 = this.f65182c.b();
        this.f65183d = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f65182c.a().d().createSocket() : new Socket(b2);
        tVar.k(iVar, this.f65182c.c(), b2);
        this.f65183d.setSoTimeout(i3);
        try {
            d.b.c.a.b.a.i.e.j().h(this.f65183d, this.f65182c.c(), i2);
            try {
                this.f65188i = k.b(k.h(this.f65183d));
                this.j = k.a(k.d(this.f65183d));
            } catch (NullPointerException e2) {
                if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f65182c.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void h(b bVar) throws IOException {
        SSLSocket sSLSocket;
        d.b.c.a.b.b a2 = this.f65182c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f65183d, a2.a().v(), a2.a().w(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            o a3 = bVar.a(sSLSocket);
            if (a3.g()) {
                d.b.c.a.b.a.i.e.j().i(sSLSocket, a2.a().v(), a2.f());
            }
            sSLSocket.startHandshake();
            u b2 = u.b(sSLSocket.getSession());
            if (a2.k().verify(a2.a().v(), sSLSocket.getSession())) {
                a2.l().e(a2.a().v(), b2.c());
                String d2 = a3.g() ? d.b.c.a.b.a.i.e.j().d(sSLSocket) : null;
                this.f65184e = sSLSocket;
                this.f65188i = k.b(k.h(sSLSocket));
                this.j = k.a(k.d(this.f65184e));
                this.f65185f = b2;
                this.f65186g = d2 != null ? com.bytedance.sdk.a.b.w.a(d2) : com.bytedance.sdk.a.b.w.HTTP_1_1;
                if (sSLSocket != null) {
                    d.b.c.a.b.a.i.e.j().l(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) b2.c().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a2.a().v() + " not verified:\n    certificate: " + d.b.c.a.b.k.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + d.b.c.a.b.a.k.e.a(x509Certificate));
        } catch (AssertionError e3) {
            e = e3;
            if (!d.b.c.a.b.a.e.t(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                d.b.c.a.b.a.i.e.j().l(sSLSocket2);
            }
            d.b.c.a.b.a.e.r(sSLSocket2);
            throw th;
        }
    }

    public final void i(b bVar, i iVar, t tVar) throws IOException {
        if (this.f65182c.a().j() == null) {
            this.f65186g = com.bytedance.sdk.a.b.w.HTTP_1_1;
            this.f65184e = this.f65183d;
            return;
        }
        tVar.n(iVar);
        h(bVar);
        tVar.f(iVar, this.f65185f);
        if (this.f65186g == com.bytedance.sdk.a.b.w.HTTP_2) {
            this.f65184e.setSoTimeout(0);
            e.h hVar = new e.h(true);
            hVar.b(this.f65184e, this.f65182c.a().a().v(), this.f65188i, this.j);
            hVar.a(this);
            d.b.c.a.b.a.h.e c2 = hVar.c();
            this.f65187h = c2;
            c2.G();
        }
    }

    public boolean j(d.b.c.a.b.b bVar, d.b.c.a.b.e eVar) {
        if (this.n.size() >= this.m || this.k || !d.b.c.a.b.a.b.f65175a.h(this.f65182c.a(), bVar)) {
            return false;
        }
        if (bVar.a().v().equals(a().a().a().v())) {
            return true;
        }
        if (this.f65187h != null && eVar != null && eVar.b().type() == Proxy.Type.DIRECT && this.f65182c.b().type() == Proxy.Type.DIRECT && this.f65182c.c().equals(eVar.c()) && eVar.a().k() == d.b.c.a.b.a.k.e.f65447a && k(bVar.a())) {
            try {
                bVar.l().e(bVar.a().v(), n().c());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean k(s sVar) {
        if (sVar.w() != this.f65182c.a().a().w()) {
            return false;
        }
        if (sVar.v().equals(this.f65182c.a().a().v())) {
            return true;
        }
        return this.f65185f != null && d.b.c.a.b.a.k.e.f65447a.d(sVar.v(), (X509Certificate) this.f65185f.c().get(0));
    }

    public boolean l(boolean z) {
        if (this.f65184e.isClosed() || this.f65184e.isInputShutdown() || this.f65184e.isOutputShutdown()) {
            return false;
        }
        d.b.c.a.b.a.h.e eVar = this.f65187h;
        if (eVar != null) {
            return !eVar.I();
        }
        if (z) {
            try {
                int soTimeout = this.f65184e.getSoTimeout();
                try {
                    this.f65184e.setSoTimeout(1);
                    return !this.f65188i.e();
                } finally {
                    this.f65184e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public Socket m() {
        return this.f65184e;
    }

    public u n() {
        return this.f65185f;
    }

    public boolean o() {
        return this.f65187h != null;
    }

    public final a0 p() {
        a0.a aVar = new a0.a();
        aVar.c(this.f65182c.a().a());
        aVar.g("Host", d.b.c.a.b.a.e.h(this.f65182c.a().a(), true));
        aVar.g("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
        aVar.g("User-Agent", d.b.c.a.b.a.g.a());
        return aVar.p();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f65182c.a().a().v());
        sb.append(":");
        sb.append(this.f65182c.a().a().w());
        sb.append(", proxy=");
        sb.append(this.f65182c.b());
        sb.append(" hostAddress=");
        sb.append(this.f65182c.c());
        sb.append(" cipherSuite=");
        u uVar = this.f65185f;
        sb.append(uVar != null ? uVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f65186g);
        sb.append('}');
        return sb.toString();
    }

    @Override // d.b.c.a.b.a.h.e.i
    public void a(d.b.c.a.b.a.h.e eVar) {
        synchronized (this.f65181b) {
            this.m = eVar.n();
        }
    }
}
