package d.b.c.a.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.a.b.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final l[] f69415e = {l.m, l.o, l.n, l.p, l.r, l.q, l.f69404i, l.k, l.j, l.l, l.f69402g, l.f69403h, l.f69400e, l.f69401f, l.f69399d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f69416f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f69417g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f69418a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f69419b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f69420c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f69421d;

    static {
        a aVar = new a(true);
        aVar.c(f69415e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f69416f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f69417g = new a(false).e();
    }

    public o(a aVar) {
        this.f69418a = aVar.f69422a;
        this.f69420c = aVar.f69423b;
        this.f69421d = aVar.f69424c;
        this.f69419b = aVar.f69425d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f69421d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f69420c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f69418a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f69418a) {
            String[] strArr = this.f69421d;
            if (strArr == null || d.b.c.a.b.a.e.B(d.b.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f69420c;
                return strArr2 == null || d.b.c.a.b.a.e.B(l.f69397b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f69420c != null) {
            enabledCipherSuites = d.b.c.a.b.a.e.w(l.f69397b, sSLSocket.getEnabledCipherSuites(), this.f69420c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f69421d != null) {
            enabledProtocols = d.b.c.a.b.a.e.w(d.b.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f69421d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.b.c.a.b.a.e.f(l.f69397b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.b.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f69420c;
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
            boolean z = this.f69418a;
            if (z != oVar.f69418a) {
                return false;
            }
            return !z || (Arrays.equals(this.f69420c, oVar.f69420c) && Arrays.equals(this.f69421d, oVar.f69421d) && this.f69419b == oVar.f69419b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f69421d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f69419b;
    }

    public int hashCode() {
        if (this.f69418a) {
            return ((((527 + Arrays.hashCode(this.f69420c)) * 31) + Arrays.hashCode(this.f69421d)) * 31) + (!this.f69419b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f69418a) {
            String obj = this.f69420c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f69421d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f69419b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f69422a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f69423b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f69424c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f69425d;

        public a(boolean z) {
            this.f69422a = z;
        }

        public a a(boolean z) {
            if (this.f69422a) {
                this.f69425d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f69422a) {
                String[] strArr = new String[adVarArr.length];
                for (int i2 = 0; i2 < adVarArr.length; i2++) {
                    strArr[i2] = adVarArr[i2].f27051f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f69422a) {
                String[] strArr = new String[lVarArr.length];
                for (int i2 = 0; i2 < lVarArr.length; i2++) {
                    strArr[i2] = lVarArr[i2].f69405a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f69422a) {
                if (strArr.length != 0) {
                    this.f69423b = (String[]) strArr.clone();
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
            if (this.f69422a) {
                if (strArr.length != 0) {
                    this.f69424c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f69422a = oVar.f69418a;
            this.f69423b = oVar.f69420c;
            this.f69424c = oVar.f69421d;
            this.f69425d = oVar.f69419b;
        }
    }
}
