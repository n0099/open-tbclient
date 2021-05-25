package d.b.c.a.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.a.b.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final l[] f65580e = {l.m, l.o, l.n, l.p, l.r, l.q, l.f65569i, l.k, l.j, l.l, l.f65567g, l.f65568h, l.f65565e, l.f65566f, l.f65564d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f65581f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f65582g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f65583a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65584b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f65585c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f65586d;

    static {
        a aVar = new a(true);
        aVar.c(f65580e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f65581f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f65582g = new a(false).e();
    }

    public o(a aVar) {
        this.f65583a = aVar.f65587a;
        this.f65585c = aVar.f65588b;
        this.f65586d = aVar.f65589c;
        this.f65584b = aVar.f65590d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f65586d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f65585c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f65583a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f65583a) {
            String[] strArr = this.f65586d;
            if (strArr == null || d.b.c.a.b.a.e.B(d.b.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f65585c;
                return strArr2 == null || d.b.c.a.b.a.e.B(l.f65562b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f65585c != null) {
            enabledCipherSuites = d.b.c.a.b.a.e.w(l.f65562b, sSLSocket.getEnabledCipherSuites(), this.f65585c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f65586d != null) {
            enabledProtocols = d.b.c.a.b.a.e.w(d.b.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f65586d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.b.c.a.b.a.e.f(l.f65562b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.b.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f65585c;
        if (strArr != null) {
            return l.c(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            if (obj == this) {
                return true;
            }
            o oVar = (o) obj;
            boolean z = this.f65583a;
            if (z != oVar.f65583a) {
                return false;
            }
            return !z || (Arrays.equals(this.f65585c, oVar.f65585c) && Arrays.equals(this.f65586d, oVar.f65586d) && this.f65584b == oVar.f65584b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f65586d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f65584b;
    }

    public int hashCode() {
        if (this.f65583a) {
            return ((((527 + Arrays.hashCode(this.f65585c)) * 31) + Arrays.hashCode(this.f65586d)) * 31) + (!this.f65584b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f65583a) {
            String obj = this.f65585c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f65586d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f65584b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65587a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f65588b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f65589c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65590d;

        public a(boolean z) {
            this.f65587a = z;
        }

        public a a(boolean z) {
            if (this.f65587a) {
                this.f65590d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f65587a) {
                String[] strArr = new String[adVarArr.length];
                for (int i2 = 0; i2 < adVarArr.length; i2++) {
                    strArr[i2] = adVarArr[i2].f26866f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f65587a) {
                String[] strArr = new String[lVarArr.length];
                for (int i2 = 0; i2 < lVarArr.length; i2++) {
                    strArr[i2] = lVarArr[i2].f65570a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f65587a) {
                if (strArr.length != 0) {
                    this.f65588b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public o e() {
            return new o(this);
        }

        public a f(String... strArr) {
            if (this.f65587a) {
                if (strArr.length != 0) {
                    this.f65589c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f65587a = oVar.f65583a;
            this.f65588b = oVar.f65585c;
            this.f65589c = oVar.f65586d;
            this.f65590d = oVar.f65584b;
        }
    }
}
