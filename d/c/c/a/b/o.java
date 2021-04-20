package d.c.c.a.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.a.b.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final l[] f66366e = {l.m, l.o, l.n, l.p, l.r, l.q, l.i, l.k, l.j, l.l, l.f66354g, l.f66355h, l.f66352e, l.f66353f, l.f66351d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f66367f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f66368g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f66369a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f66370b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f66371c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f66372d;

    static {
        a aVar = new a(true);
        aVar.c(f66366e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f66367f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f66368g = new a(false).e();
    }

    public o(a aVar) {
        this.f66369a = aVar.f66373a;
        this.f66371c = aVar.f66374b;
        this.f66372d = aVar.f66375c;
        this.f66370b = aVar.f66376d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f66372d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f66371c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f66369a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f66369a) {
            String[] strArr = this.f66372d;
            if (strArr == null || d.c.c.a.b.a.e.B(d.c.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f66371c;
                return strArr2 == null || d.c.c.a.b.a.e.B(l.f66349b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f66371c != null) {
            enabledCipherSuites = d.c.c.a.b.a.e.w(l.f66349b, sSLSocket.getEnabledCipherSuites(), this.f66371c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f66372d != null) {
            enabledProtocols = d.c.c.a.b.a.e.w(d.c.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f66372d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.c.c.a.b.a.e.f(l.f66349b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.c.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f66371c;
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
            boolean z = this.f66369a;
            if (z != oVar.f66369a) {
                return false;
            }
            return !z || (Arrays.equals(this.f66371c, oVar.f66371c) && Arrays.equals(this.f66372d, oVar.f66372d) && this.f66370b == oVar.f66370b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f66372d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f66370b;
    }

    public int hashCode() {
        if (this.f66369a) {
            return ((((527 + Arrays.hashCode(this.f66371c)) * 31) + Arrays.hashCode(this.f66372d)) * 31) + (!this.f66370b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f66369a) {
            String obj = this.f66371c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f66372d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f66370b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f66373a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f66374b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f66375c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66376d;

        public a(boolean z) {
            this.f66373a = z;
        }

        public a a(boolean z) {
            if (this.f66373a) {
                this.f66376d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f66373a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f26870f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f66373a) {
                String[] strArr = new String[lVarArr.length];
                for (int i = 0; i < lVarArr.length; i++) {
                    strArr[i] = lVarArr[i].f66356a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f66373a) {
                if (strArr.length != 0) {
                    this.f66374b = (String[]) strArr.clone();
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
            if (this.f66373a) {
                if (strArr.length != 0) {
                    this.f66375c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f66373a = oVar.f66369a;
            this.f66374b = oVar.f66371c;
            this.f66375c = oVar.f66372d;
            this.f66376d = oVar.f66370b;
        }
    }
}
