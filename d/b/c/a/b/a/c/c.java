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
    public final n f65224b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.c.a.b.e f65225c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f65226d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f65227e;

    /* renamed from: f  reason: collision with root package name */
    public u f65228f;

    /* renamed from: g  reason: collision with root package name */
    public w f65229g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.a.b.a.h.e f65230h;

    /* renamed from: i  reason: collision with root package name */
    public d.b.c.a.a.e f65231i;
    public d.b.c.a.a.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<f>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(n nVar, d.b.c.a.b.e eVar) {
        this.f65224b = nVar;
        this.f65225c = eVar;
    }

    @Override // d.b.c.a.b.m
    public d.b.c.a.b.e a() {
        return this.f65225c;
    }

    @Override // d.b.c.a.b.a.h.e.i
    public void b(g gVar) throws IOException {
        gVar.d(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
    }

    public e.InterfaceC1826e c(y yVar, w.a aVar, f fVar) throws SocketException {
        if (this.f65230h != null) {
            return new d.b.c.a.b.a.h.d(yVar, aVar, fVar, this.f65230h);
        }
        this.f65227e.setSoTimeout(aVar.c());
        this.f65231i.a().b(aVar.c(), TimeUnit.MILLISECONDS);
        this.j.a().b(aVar.d(), TimeUnit.MILLISECONDS);
        return new d.b.c.a.b.a.f.a(yVar, fVar, this.f65231i, this.j);
    }

    public final a0 d(int i2, int i3, a0 a0Var, s sVar) throws IOException {
        String str = "CONNECT " + d.b.c.a.b.a.e.h(sVar, true) + " HTTP/1.1";
        while (true) {
            d.b.c.a.b.a.f.a aVar = new d.b.c.a.b.a.f.a(null, null, this.f65231i, this.j);
            this.f65231i.a().b(i2, TimeUnit.MILLISECONDS);
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
                if (this.f65231i.c().e() && this.j.c().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (r == 407) {
                a0 a3 = this.f65225c.a().e().a(this.f65225c, k);
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
            d.b.c.a.b.a.e.r(this.f65226d);
            this.f65226d = null;
            this.j = null;
            this.f65231i = null;
            tVar.l(iVar, this.f65225c.c(), this.f65225c.b(), null);
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
        if (this.f65229g == null) {
            List<o> g2 = this.f65225c.a().g();
            b bVar = new b(g2);
            if (this.f65225c.a().j() == null) {
                if (g2.contains(o.f65582g)) {
                    String v = this.f65225c.a().a().v();
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
                    if (!this.f65225c.d()) {
                        e(i2, i3, i4, iVar, tVar);
                        if (this.f65226d == null) {
                            if (!this.f65225c.d() && this.f65226d == null) {
                                throw new com.bytedance.sdk.a.b.a.b.e(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                            if (this.f65230h != null) {
                                synchronized (this.f65224b) {
                                    this.m = this.f65230h.n();
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
                            d.b.c.a.b.a.e.r(this.f65227e);
                            d.b.c.a.b.a.e.r(this.f65226d);
                            this.f65227e = null;
                            this.f65226d = null;
                            this.f65231i = null;
                            this.j = null;
                            this.f65228f = null;
                            this.f65229g = null;
                            this.f65230h = null;
                            tVar.m(iVar, this.f65225c.c(), this.f65225c.b(), null, e);
                            if (eVar == null) {
                                eVar = new com.bytedance.sdk.a.b.a.b.e(e);
                            } else {
                                eVar.a(e);
                            }
                            if (!z || bVar.b(e)) {
                                throw eVar;
                            }
                            do {
                                if (!this.f65225c.d()) {
                                }
                                i(bVar, iVar, tVar);
                                tVar.l(iVar, this.f65225c.c(), this.f65225c.b(), this.f65229g);
                                if (!this.f65225c.d()) {
                                }
                                if (this.f65230h != null) {
                                }
                            } while (bVar.b(e));
                            throw eVar;
                        }
                    }
                    i(bVar, iVar, tVar);
                    tVar.l(iVar, this.f65225c.c(), this.f65225c.b(), this.f65229g);
                    if (!this.f65225c.d()) {
                    }
                    if (this.f65230h != null) {
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
        Proxy b2 = this.f65225c.b();
        this.f65226d = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f65225c.a().d().createSocket() : new Socket(b2);
        tVar.k(iVar, this.f65225c.c(), b2);
        this.f65226d.setSoTimeout(i3);
        try {
            d.b.c.a.b.a.i.e.j().h(this.f65226d, this.f65225c.c(), i2);
            try {
                this.f65231i = k.b(k.h(this.f65226d));
                this.j = k.a(k.d(this.f65226d));
            } catch (NullPointerException e2) {
                if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f65225c.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void h(b bVar) throws IOException {
        SSLSocket sSLSocket;
        d.b.c.a.b.b a2 = this.f65225c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f65226d, a2.a().v(), a2.a().w(), true);
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
                this.f65227e = sSLSocket;
                this.f65231i = k.b(k.h(sSLSocket));
                this.j = k.a(k.d(this.f65227e));
                this.f65228f = b2;
                this.f65229g = d2 != null ? com.bytedance.sdk.a.b.w.a(d2) : com.bytedance.sdk.a.b.w.HTTP_1_1;
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
        if (this.f65225c.a().j() == null) {
            this.f65229g = com.bytedance.sdk.a.b.w.HTTP_1_1;
            this.f65227e = this.f65226d;
            return;
        }
        tVar.n(iVar);
        h(bVar);
        tVar.f(iVar, this.f65228f);
        if (this.f65229g == com.bytedance.sdk.a.b.w.HTTP_2) {
            this.f65227e.setSoTimeout(0);
            e.h hVar = new e.h(true);
            hVar.b(this.f65227e, this.f65225c.a().a().v(), this.f65231i, this.j);
            hVar.a(this);
            d.b.c.a.b.a.h.e c2 = hVar.c();
            this.f65230h = c2;
            c2.G();
        }
    }

    public boolean j(d.b.c.a.b.b bVar, d.b.c.a.b.e eVar) {
        if (this.n.size() >= this.m || this.k || !d.b.c.a.b.a.b.f65218a.h(this.f65225c.a(), bVar)) {
            return false;
        }
        if (bVar.a().v().equals(a().a().a().v())) {
            return true;
        }
        if (this.f65230h != null && eVar != null && eVar.b().type() == Proxy.Type.DIRECT && this.f65225c.b().type() == Proxy.Type.DIRECT && this.f65225c.c().equals(eVar.c()) && eVar.a().k() == d.b.c.a.b.a.k.e.f65490a && k(bVar.a())) {
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
        if (sVar.w() != this.f65225c.a().a().w()) {
            return false;
        }
        if (sVar.v().equals(this.f65225c.a().a().v())) {
            return true;
        }
        return this.f65228f != null && d.b.c.a.b.a.k.e.f65490a.d(sVar.v(), (X509Certificate) this.f65228f.c().get(0));
    }

    public boolean l(boolean z) {
        if (this.f65227e.isClosed() || this.f65227e.isInputShutdown() || this.f65227e.isOutputShutdown()) {
            return false;
        }
        d.b.c.a.b.a.h.e eVar = this.f65230h;
        if (eVar != null) {
            return !eVar.I();
        }
        if (z) {
            try {
                int soTimeout = this.f65227e.getSoTimeout();
                try {
                    this.f65227e.setSoTimeout(1);
                    return !this.f65231i.e();
                } finally {
                    this.f65227e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public Socket m() {
        return this.f65227e;
    }

    public u n() {
        return this.f65228f;
    }

    public boolean o() {
        return this.f65230h != null;
    }

    public final a0 p() {
        a0.a aVar = new a0.a();
        aVar.c(this.f65225c.a().a());
        aVar.g("Host", d.b.c.a.b.a.e.h(this.f65225c.a().a(), true));
        aVar.g("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
        aVar.g("User-Agent", d.b.c.a.b.a.g.a());
        return aVar.p();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f65225c.a().a().v());
        sb.append(":");
        sb.append(this.f65225c.a().a().w());
        sb.append(", proxy=");
        sb.append(this.f65225c.b());
        sb.append(" hostAddress=");
        sb.append(this.f65225c.c());
        sb.append(" cipherSuite=");
        u uVar = this.f65228f;
        sb.append(uVar != null ? uVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f65229g);
        sb.append('}');
        return sb.toString();
    }

    @Override // d.b.c.a.b.a.h.e.i
    public void a(d.b.c.a.b.a.h.e eVar) {
        synchronized (this.f65224b) {
            this.m = eVar.n();
        }
    }
}
