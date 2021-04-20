package d.c.c.a.b.a.c;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.w;
import d.c.c.a.a.k;
import d.c.c.a.a.q;
import d.c.c.a.b.a.e;
import d.c.c.a.b.a.h.e;
import d.c.c.a.b.a.h.g;
import d.c.c.a.b.a0;
import d.c.c.a.b.c;
import d.c.c.a.b.i;
import d.c.c.a.b.m;
import d.c.c.a.b.n;
import d.c.c.a.b.o;
import d.c.c.a.b.t;
import d.c.c.a.b.u;
import d.c.c.a.b.w;
import d.c.c.a.b.y;
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
/* loaded from: classes5.dex */
public final class c extends e.i implements m {

    /* renamed from: b  reason: collision with root package name */
    public final n f66035b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.c.a.b.e f66036c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f66037d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f66038e;

    /* renamed from: f  reason: collision with root package name */
    public u f66039f;

    /* renamed from: g  reason: collision with root package name */
    public w f66040g;

    /* renamed from: h  reason: collision with root package name */
    public d.c.c.a.b.a.h.e f66041h;
    public d.c.c.a.a.e i;
    public d.c.c.a.a.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<f>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(n nVar, d.c.c.a.b.e eVar) {
        this.f66035b = nVar;
        this.f66036c = eVar;
    }

    @Override // d.c.c.a.b.m
    public d.c.c.a.b.e a() {
        return this.f66036c;
    }

    @Override // d.c.c.a.b.a.h.e.i
    public void b(g gVar) throws IOException {
        gVar.d(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
    }

    public e.InterfaceC1815e c(y yVar, w.a aVar, f fVar) throws SocketException {
        if (this.f66041h != null) {
            return new d.c.c.a.b.a.h.d(yVar, aVar, fVar, this.f66041h);
        }
        this.f66038e.setSoTimeout(aVar.c());
        this.i.a().b(aVar.c(), TimeUnit.MILLISECONDS);
        this.j.a().b(aVar.d(), TimeUnit.MILLISECONDS);
        return new d.c.c.a.b.a.f.a(yVar, fVar, this.i, this.j);
    }

    public final a0 d(int i, int i2, a0 a0Var, s sVar) throws IOException {
        String str = "CONNECT " + d.c.c.a.b.a.e.h(sVar, true) + " HTTP/1.1";
        while (true) {
            d.c.c.a.b.a.f.a aVar = new d.c.c.a.b.a.f.a(null, null, this.i, this.j);
            this.i.a().b(i, TimeUnit.MILLISECONDS);
            this.j.a().b(i2, TimeUnit.MILLISECONDS);
            aVar.g(a0Var.d(), str);
            aVar.b();
            c.a a2 = aVar.a(false);
            a2.h(a0Var);
            d.c.c.a.b.c k = a2.k();
            long c2 = e.g.c(k);
            if (c2 == -1) {
                c2 = 0;
            }
            q h2 = aVar.h(c2);
            d.c.c.a.b.a.e.A(h2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            h2.close();
            int r = k.r();
            if (r == 200) {
                if (this.i.c().e() && this.j.c().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (r == 407) {
                a0 a3 = this.f66036c.a().e().a(this.f66036c, k);
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

    public final void e(int i, int i2, int i3, i iVar, t tVar) throws IOException {
        a0 p = p();
        s a2 = p.a();
        for (int i4 = 0; i4 < 21; i4++) {
            g(i, i2, iVar, tVar);
            p = d(i2, i3, p, a2);
            if (p == null) {
                return;
            }
            d.c.c.a.b.a.e.r(this.f66037d);
            this.f66037d = null;
            this.j = null;
            this.i = null;
            tVar.l(iVar, this.f66036c.c(), this.f66036c.b(), null);
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
    public void f(int i, int i2, int i3, boolean z, i iVar, t tVar) {
        if (this.f66040g == null) {
            List<o> g2 = this.f66036c.a().g();
            b bVar = new b(g2);
            if (this.f66036c.a().j() == null) {
                if (g2.contains(o.f66368g)) {
                    String v = this.f66036c.a().a().v();
                    if (!d.c.c.a.b.a.i.e.j().m(v)) {
                        throw new com.bytedance.sdk.a.b.a.b.e(new UnknownServiceException("CLEARTEXT communication to " + v + " not permitted by network security policy"));
                    }
                } else {
                    throw new com.bytedance.sdk.a.b.a.b.e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            }
            com.bytedance.sdk.a.b.a.b.e eVar = null;
            do {
                try {
                    if (!this.f66036c.d()) {
                        e(i, i2, i3, iVar, tVar);
                        if (this.f66037d == null) {
                            if (!this.f66036c.d() && this.f66037d == null) {
                                throw new com.bytedance.sdk.a.b.a.b.e(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                            if (this.f66041h != null) {
                                synchronized (this.f66035b) {
                                    this.m = this.f66041h.n();
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        try {
                            g(i, i2, iVar, tVar);
                        } catch (IOException e2) {
                            e = e2;
                            d.c.c.a.b.a.e.r(this.f66038e);
                            d.c.c.a.b.a.e.r(this.f66037d);
                            this.f66038e = null;
                            this.f66037d = null;
                            this.i = null;
                            this.j = null;
                            this.f66039f = null;
                            this.f66040g = null;
                            this.f66041h = null;
                            tVar.m(iVar, this.f66036c.c(), this.f66036c.b(), null, e);
                            if (eVar == null) {
                                eVar = new com.bytedance.sdk.a.b.a.b.e(e);
                            } else {
                                eVar.a(e);
                            }
                            if (!z || bVar.b(e)) {
                                throw eVar;
                            }
                            do {
                                if (!this.f66036c.d()) {
                                }
                                i(bVar, iVar, tVar);
                                tVar.l(iVar, this.f66036c.c(), this.f66036c.b(), this.f66040g);
                                if (!this.f66036c.d()) {
                                }
                                if (this.f66041h != null) {
                                }
                            } while (bVar.b(e));
                            throw eVar;
                        }
                    }
                    i(bVar, iVar, tVar);
                    tVar.l(iVar, this.f66036c.c(), this.f66036c.b(), this.f66040g);
                    if (!this.f66036c.d()) {
                    }
                    if (this.f66041h != null) {
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } while (bVar.b(e));
            throw eVar;
        }
        throw new IllegalStateException("already connected");
    }

    public final void g(int i, int i2, i iVar, t tVar) throws IOException {
        Proxy b2 = this.f66036c.b();
        this.f66037d = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f66036c.a().d().createSocket() : new Socket(b2);
        tVar.k(iVar, this.f66036c.c(), b2);
        this.f66037d.setSoTimeout(i2);
        try {
            d.c.c.a.b.a.i.e.j().h(this.f66037d, this.f66036c.c(), i);
            try {
                this.i = k.b(k.h(this.f66037d));
                this.j = k.a(k.d(this.f66037d));
            } catch (NullPointerException e2) {
                if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f66036c.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void h(b bVar) throws IOException {
        SSLSocket sSLSocket;
        d.c.c.a.b.b a2 = this.f66036c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f66037d, a2.a().v(), a2.a().w(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            o a3 = bVar.a(sSLSocket);
            if (a3.g()) {
                d.c.c.a.b.a.i.e.j().i(sSLSocket, a2.a().v(), a2.f());
            }
            sSLSocket.startHandshake();
            u b2 = u.b(sSLSocket.getSession());
            if (a2.k().verify(a2.a().v(), sSLSocket.getSession())) {
                a2.l().e(a2.a().v(), b2.c());
                String d2 = a3.g() ? d.c.c.a.b.a.i.e.j().d(sSLSocket) : null;
                this.f66038e = sSLSocket;
                this.i = k.b(k.h(sSLSocket));
                this.j = k.a(k.d(this.f66038e));
                this.f66039f = b2;
                this.f66040g = d2 != null ? com.bytedance.sdk.a.b.w.a(d2) : com.bytedance.sdk.a.b.w.HTTP_1_1;
                if (sSLSocket != null) {
                    d.c.c.a.b.a.i.e.j().l(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) b2.c().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a2.a().v() + " not verified:\n    certificate: " + d.c.c.a.b.k.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + d.c.c.a.b.a.k.e.a(x509Certificate));
        } catch (AssertionError e3) {
            e = e3;
            if (!d.c.c.a.b.a.e.t(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                d.c.c.a.b.a.i.e.j().l(sSLSocket2);
            }
            d.c.c.a.b.a.e.r(sSLSocket2);
            throw th;
        }
    }

    public final void i(b bVar, i iVar, t tVar) throws IOException {
        if (this.f66036c.a().j() == null) {
            this.f66040g = com.bytedance.sdk.a.b.w.HTTP_1_1;
            this.f66038e = this.f66037d;
            return;
        }
        tVar.n(iVar);
        h(bVar);
        tVar.f(iVar, this.f66039f);
        if (this.f66040g == com.bytedance.sdk.a.b.w.HTTP_2) {
            this.f66038e.setSoTimeout(0);
            e.h hVar = new e.h(true);
            hVar.b(this.f66038e, this.f66036c.a().a().v(), this.i, this.j);
            hVar.a(this);
            d.c.c.a.b.a.h.e c2 = hVar.c();
            this.f66041h = c2;
            c2.G();
        }
    }

    public boolean j(d.c.c.a.b.b bVar, d.c.c.a.b.e eVar) {
        if (this.n.size() >= this.m || this.k || !d.c.c.a.b.a.b.f66029a.h(this.f66036c.a(), bVar)) {
            return false;
        }
        if (bVar.a().v().equals(a().a().a().v())) {
            return true;
        }
        if (this.f66041h != null && eVar != null && eVar.b().type() == Proxy.Type.DIRECT && this.f66036c.b().type() == Proxy.Type.DIRECT && this.f66036c.c().equals(eVar.c()) && eVar.a().k() == d.c.c.a.b.a.k.e.f66281a && k(bVar.a())) {
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
        if (sVar.w() != this.f66036c.a().a().w()) {
            return false;
        }
        if (sVar.v().equals(this.f66036c.a().a().v())) {
            return true;
        }
        return this.f66039f != null && d.c.c.a.b.a.k.e.f66281a.d(sVar.v(), (X509Certificate) this.f66039f.c().get(0));
    }

    public boolean l(boolean z) {
        if (this.f66038e.isClosed() || this.f66038e.isInputShutdown() || this.f66038e.isOutputShutdown()) {
            return false;
        }
        d.c.c.a.b.a.h.e eVar = this.f66041h;
        if (eVar != null) {
            return !eVar.I();
        }
        if (z) {
            try {
                int soTimeout = this.f66038e.getSoTimeout();
                try {
                    this.f66038e.setSoTimeout(1);
                    return !this.i.e();
                } finally {
                    this.f66038e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public Socket m() {
        return this.f66038e;
    }

    public u n() {
        return this.f66039f;
    }

    public boolean o() {
        return this.f66041h != null;
    }

    public final a0 p() {
        a0.a aVar = new a0.a();
        aVar.c(this.f66036c.a().a());
        aVar.g("Host", d.c.c.a.b.a.e.h(this.f66036c.a().a(), true));
        aVar.g("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
        aVar.g("User-Agent", d.c.c.a.b.a.g.a());
        return aVar.p();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f66036c.a().a().v());
        sb.append(":");
        sb.append(this.f66036c.a().a().w());
        sb.append(", proxy=");
        sb.append(this.f66036c.b());
        sb.append(" hostAddress=");
        sb.append(this.f66036c.c());
        sb.append(" cipherSuite=");
        u uVar = this.f66039f;
        sb.append(uVar != null ? uVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f66040g);
        sb.append('}');
        return sb.toString();
    }

    @Override // d.c.c.a.b.a.h.e.i
    public void a(d.c.c.a.b.a.h.e eVar) {
        synchronized (this.f66035b) {
            this.m = eVar.n();
        }
    }
}
