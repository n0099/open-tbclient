package d.b.c.a.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.a.b.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final l[] f69311e = {l.m, l.o, l.n, l.p, l.r, l.q, l.f69300i, l.k, l.j, l.l, l.f69298g, l.f69299h, l.f69296e, l.f69297f, l.f69295d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f69312f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f69313g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f69314a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f69315b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f69316c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f69317d;

    static {
        a aVar = new a(true);
        aVar.c(f69311e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f69312f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f69313g = new a(false).e();
    }

    public o(a aVar) {
        this.f69314a = aVar.f69318a;
        this.f69316c = aVar.f69319b;
        this.f69317d = aVar.f69320c;
        this.f69315b = aVar.f69321d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f69317d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f69316c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f69314a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f69314a) {
            String[] strArr = this.f69317d;
            if (strArr == null || d.b.c.a.b.a.e.B(d.b.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f69316c;
                return strArr2 == null || d.b.c.a.b.a.e.B(l.f69293b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f69316c != null) {
            enabledCipherSuites = d.b.c.a.b.a.e.w(l.f69293b, sSLSocket.getEnabledCipherSuites(), this.f69316c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f69317d != null) {
            enabledProtocols = d.b.c.a.b.a.e.w(d.b.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f69317d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.b.c.a.b.a.e.f(l.f69293b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.b.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f69316c;
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
            boolean z = this.f69314a;
            if (z != oVar.f69314a) {
                return false;
            }
            return !z || (Arrays.equals(this.f69316c, oVar.f69316c) && Arrays.equals(this.f69317d, oVar.f69317d) && this.f69315b == oVar.f69315b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f69317d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f69315b;
    }

    public int hashCode() {
        if (this.f69314a) {
            return ((((527 + Arrays.hashCode(this.f69316c)) * 31) + Arrays.hashCode(this.f69317d)) * 31) + (!this.f69315b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f69314a) {
            String obj = this.f69316c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f69317d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f69315b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f69318a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f69319b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f69320c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f69321d;

        public a(boolean z) {
            this.f69318a = z;
        }

        public a a(boolean z) {
            if (this.f69318a) {
                this.f69321d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f69318a) {
                String[] strArr = new String[adVarArr.length];
                for (int i2 = 0; i2 < adVarArr.length; i2++) {
                    strArr[i2] = adVarArr[i2].f26969f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f69318a) {
                String[] strArr = new String[lVarArr.length];
                for (int i2 = 0; i2 < lVarArr.length; i2++) {
                    strArr[i2] = lVarArr[i2].f69301a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f69318a) {
                if (strArr.length != 0) {
                    this.f69319b = (String[]) strArr.clone();
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
            if (this.f69318a) {
                if (strArr.length != 0) {
                    this.f69320c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f69318a = oVar.f69314a;
            this.f69319b = oVar.f69316c;
            this.f69320c = oVar.f69317d;
            this.f69321d = oVar.f69315b;
        }
    }
}
