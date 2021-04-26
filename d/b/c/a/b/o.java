package d.b.c.a.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.a.b.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final l[] f64851e = {l.m, l.o, l.n, l.p, l.r, l.q, l.f64840i, l.k, l.j, l.l, l.f64838g, l.f64839h, l.f64836e, l.f64837f, l.f64835d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f64852f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f64853g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f64854a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f64855b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f64856c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f64857d;

    static {
        a aVar = new a(true);
        aVar.c(f64851e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f64852f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f64853g = new a(false).e();
    }

    public o(a aVar) {
        this.f64854a = aVar.f64858a;
        this.f64856c = aVar.f64859b;
        this.f64857d = aVar.f64860c;
        this.f64855b = aVar.f64861d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f64857d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f64856c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f64854a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f64854a) {
            String[] strArr = this.f64857d;
            if (strArr == null || d.b.c.a.b.a.e.B(d.b.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f64856c;
                return strArr2 == null || d.b.c.a.b.a.e.B(l.f64833b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f64856c != null) {
            enabledCipherSuites = d.b.c.a.b.a.e.w(l.f64833b, sSLSocket.getEnabledCipherSuites(), this.f64856c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f64857d != null) {
            enabledProtocols = d.b.c.a.b.a.e.w(d.b.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f64857d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.b.c.a.b.a.e.f(l.f64833b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.b.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f64856c;
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
            boolean z = this.f64854a;
            if (z != oVar.f64854a) {
                return false;
            }
            return !z || (Arrays.equals(this.f64856c, oVar.f64856c) && Arrays.equals(this.f64857d, oVar.f64857d) && this.f64855b == oVar.f64855b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f64857d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f64855b;
    }

    public int hashCode() {
        if (this.f64854a) {
            return ((((527 + Arrays.hashCode(this.f64856c)) * 31) + Arrays.hashCode(this.f64857d)) * 31) + (!this.f64855b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f64854a) {
            String obj = this.f64856c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f64857d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f64855b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f64858a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f64859b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f64860c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64861d;

        public a(boolean z) {
            this.f64858a = z;
        }

        public a a(boolean z) {
            if (this.f64858a) {
                this.f64861d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f64858a) {
                String[] strArr = new String[adVarArr.length];
                for (int i2 = 0; i2 < adVarArr.length; i2++) {
                    strArr[i2] = adVarArr[i2].f27692f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f64858a) {
                String[] strArr = new String[lVarArr.length];
                for (int i2 = 0; i2 < lVarArr.length; i2++) {
                    strArr[i2] = lVarArr[i2].f64841a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f64858a) {
                if (strArr.length != 0) {
                    this.f64859b = (String[]) strArr.clone();
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
            if (this.f64858a) {
                if (strArr.length != 0) {
                    this.f64860c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f64858a = oVar.f64854a;
            this.f64859b = oVar.f64856c;
            this.f64860c = oVar.f64857d;
            this.f64861d = oVar.f64855b;
        }
    }
}
