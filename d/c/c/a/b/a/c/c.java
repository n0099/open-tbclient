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
    public final n f65190b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.c.a.b.e f65191c;

    /* renamed from: d  reason: collision with root package name */
    public Socket f65192d;

    /* renamed from: e  reason: collision with root package name */
    public Socket f65193e;

    /* renamed from: f  reason: collision with root package name */
    public u f65194f;

    /* renamed from: g  reason: collision with root package name */
    public w f65195g;

    /* renamed from: h  reason: collision with root package name */
    public d.c.c.a.b.a.h.e f65196h;
    public d.c.c.a.a.e i;
    public d.c.c.a.a.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<f>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(n nVar, d.c.c.a.b.e eVar) {
        this.f65190b = nVar;
        this.f65191c = eVar;
    }

    @Override // d.c.c.a.b.m
    public d.c.c.a.b.e a() {
        return this.f65191c;
    }

    @Override // d.c.c.a.b.a.h.e.i
    public void b(g gVar) throws IOException {
        gVar.d(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
    }

    public e.InterfaceC1787e c(y yVar, w.a aVar, f fVar) throws SocketException {
        if (this.f65196h != null) {
            return new d.c.c.a.b.a.h.d(yVar, aVar, fVar, this.f65196h);
        }
        this.f65193e.setSoTimeout(aVar.c());
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
                a0 a3 = this.f65191c.a().e().a(this.f65191c, k);
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
            d.c.c.a.b.a.e.r(this.f65192d);
            this.f65192d = null;
            this.j = null;
            this.i = null;
            tVar.l(iVar, this.f65191c.c(), this.f65191c.b(), null);
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
        if (this.f65195g == null) {
            List<o> g2 = this.f65191c.a().g();
            b bVar = new b(g2);
            if (this.f65191c.a().j() == null) {
                if (g2.contains(o.f65523g)) {
                    String v = this.f65191c.a().a().v();
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
                    if (!this.f65191c.d()) {
                        e(i, i2, i3, iVar, tVar);
                        if (this.f65192d == null) {
                            if (!this.f65191c.d() && this.f65192d == null) {
                                throw new com.bytedance.sdk.a.b.a.b.e(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                            if (this.f65196h != null) {
                                synchronized (this.f65190b) {
                                    this.m = this.f65196h.n();
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
                            d.c.c.a.b.a.e.r(this.f65193e);
                            d.c.c.a.b.a.e.r(this.f65192d);
                            this.f65193e = null;
                            this.f65192d = null;
                            this.i = null;
                            this.j = null;
                            this.f65194f = null;
                            this.f65195g = null;
                            this.f65196h = null;
                            tVar.m(iVar, this.f65191c.c(), this.f65191c.b(), null, e);
                            if (eVar == null) {
                                eVar = new com.bytedance.sdk.a.b.a.b.e(e);
                            } else {
                                eVar.a(e);
                            }
                            if (!z || bVar.b(e)) {
                                throw eVar;
                            }
                            do {
                                if (!this.f65191c.d()) {
                                }
                                i(bVar, iVar, tVar);
                                tVar.l(iVar, this.f65191c.c(), this.f65191c.b(), this.f65195g);
                                if (!this.f65191c.d()) {
                                }
                                if (this.f65196h != null) {
                                }
                            } while (bVar.b(e));
                            throw eVar;
                        }
                    }
                    i(bVar, iVar, tVar);
                    tVar.l(iVar, this.f65191c.c(), this.f65191c.b(), this.f65195g);
                    if (!this.f65191c.d()) {
                    }
                    if (this.f65196h != null) {
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
        Proxy b2 = this.f65191c.b();
        this.f65192d = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f65191c.a().d().createSocket() : new Socket(b2);
        tVar.k(iVar, this.f65191c.c(), b2);
        this.f65192d.setSoTimeout(i2);
        try {
            d.c.c.a.b.a.i.e.j().h(this.f65192d, this.f65191c.c(), i);
            try {
                this.i = k.b(k.h(this.f65192d));
                this.j = k.a(k.d(this.f65192d));
            } catch (NullPointerException e2) {
                if (RealConnection.NPE_THROW_WITH_NULL.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f65191c.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void h(b bVar) throws IOException {
        SSLSocket sSLSocket;
        d.c.c.a.b.b a2 = this.f65191c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.f65192d, a2.a().v(), a2.a().w(), true);
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
                this.f65193e = sSLSocket;
                this.i = k.b(k.h(sSLSocket));
                this.j = k.a(k.d(this.f65193e));
                this.f65194f = b2;
                this.f65195g = d2 != null ? com.bytedance.sdk.a.b.w.a(d2) : com.bytedance.sdk.a.b.w.HTTP_1_1;
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
        if (this.f65191c.a().j() == null) {
            this.f65195g = com.bytedance.sdk.a.b.w.HTTP_1_1;
            this.f65193e = this.f65192d;
            return;
        }
        tVar.n(iVar);
        h(bVar);
        tVar.f(iVar, this.f65194f);
        if (this.f65195g == com.bytedance.sdk.a.b.w.HTTP_2) {
            this.f65193e.setSoTimeout(0);
            e.h hVar = new e.h(true);
            hVar.b(this.f65193e, this.f65191c.a().a().v(), this.i, this.j);
            hVar.a(this);
            d.c.c.a.b.a.h.e c2 = hVar.c();
            this.f65196h = c2;
            c2.G();
        }
    }

    public boolean j(d.c.c.a.b.b bVar, d.c.c.a.b.e eVar) {
        if (this.n.size() >= this.m || this.k || !d.c.c.a.b.a.b.f65184a.h(this.f65191c.a(), bVar)) {
            return false;
        }
        if (bVar.a().v().equals(a().a().a().v())) {
            return true;
        }
        if (this.f65196h != null && eVar != null && eVar.b().type() == Proxy.Type.DIRECT && this.f65191c.b().type() == Proxy.Type.DIRECT && this.f65191c.c().equals(eVar.c()) && eVar.a().k() == d.c.c.a.b.a.k.e.f65436a && k(bVar.a())) {
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
        if (sVar.w() != this.f65191c.a().a().w()) {
            return false;
        }
        if (sVar.v().equals(this.f65191c.a().a().v())) {
            return true;
        }
        return this.f65194f != null && d.c.c.a.b.a.k.e.f65436a.d(sVar.v(), (X509Certificate) this.f65194f.c().get(0));
    }

    public boolean l(boolean z) {
        if (this.f65193e.isClosed() || this.f65193e.isInputShutdown() || this.f65193e.isOutputShutdown()) {
            return false;
        }
        d.c.c.a.b.a.h.e eVar = this.f65196h;
        if (eVar != null) {
            return !eVar.I();
        }
        if (z) {
            try {
                int soTimeout = this.f65193e.getSoTimeout();
                try {
                    this.f65193e.setSoTimeout(1);
                    return !this.i.e();
                } finally {
                    this.f65193e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public Socket m() {
        return this.f65193e;
    }

    public u n() {
        return this.f65194f;
    }

    public boolean o() {
        return this.f65196h != null;
    }

    public final a0 p() {
        a0.a aVar = new a0.a();
        aVar.c(this.f65191c.a().a());
        aVar.g("Host", d.c.c.a.b.a.e.h(this.f65191c.a().a(), true));
        aVar.g("Proxy-Connection", HTTP.CONN_KEEP_ALIVE);
        aVar.g("User-Agent", d.c.c.a.b.a.g.a());
        return aVar.p();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f65191c.a().a().v());
        sb.append(":");
        sb.append(this.f65191c.a().a().w());
        sb.append(", proxy=");
        sb.append(this.f65191c.b());
        sb.append(" hostAddress=");
        sb.append(this.f65191c.c());
        sb.append(" cipherSuite=");
        u uVar = this.f65194f;
        sb.append(uVar != null ? uVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f65195g);
        sb.append('}');
        return sb.toString();
    }

    @Override // d.c.c.a.b.a.h.e.i
    public void a(d.c.c.a.b.a.h.e eVar) {
        synchronized (this.f65190b) {
            this.m = eVar.n();
        }
    }
}
