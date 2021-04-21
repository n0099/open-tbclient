package d.c.c.a.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.a.b.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final l[] f66461e = {l.m, l.o, l.n, l.p, l.r, l.q, l.i, l.k, l.j, l.l, l.f66449g, l.f66450h, l.f66447e, l.f66448f, l.f66446d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f66462f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f66463g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f66464a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f66465b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f66466c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f66467d;

    static {
        a aVar = new a(true);
        aVar.c(f66461e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f66462f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f66463g = new a(false).e();
    }

    public o(a aVar) {
        this.f66464a = aVar.f66468a;
        this.f66466c = aVar.f66469b;
        this.f66467d = aVar.f66470c;
        this.f66465b = aVar.f66471d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f66467d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f66466c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f66464a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f66464a) {
            String[] strArr = this.f66467d;
            if (strArr == null || d.c.c.a.b.a.e.B(d.c.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f66466c;
                return strArr2 == null || d.c.c.a.b.a.e.B(l.f66444b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f66466c != null) {
            enabledCipherSuites = d.c.c.a.b.a.e.w(l.f66444b, sSLSocket.getEnabledCipherSuites(), this.f66466c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f66467d != null) {
            enabledProtocols = d.c.c.a.b.a.e.w(d.c.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f66467d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.c.c.a.b.a.e.f(l.f66444b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.c.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f66466c;
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
            boolean z = this.f66464a;
            if (z != oVar.f66464a) {
                return false;
            }
            return !z || (Arrays.equals(this.f66466c, oVar.f66466c) && Arrays.equals(this.f66467d, oVar.f66467d) && this.f66465b == oVar.f66465b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f66467d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f66465b;
    }

    public int hashCode() {
        if (this.f66464a) {
            return ((((527 + Arrays.hashCode(this.f66466c)) * 31) + Arrays.hashCode(this.f66467d)) * 31) + (!this.f66465b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f66464a) {
            String obj = this.f66466c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f66467d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f66465b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f66468a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f66469b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f66470c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66471d;

        public a(boolean z) {
            this.f66468a = z;
        }

        public a a(boolean z) {
            if (this.f66468a) {
                this.f66471d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f66468a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f26878f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f66468a) {
                String[] strArr = new String[lVarArr.length];
                for (int i = 0; i < lVarArr.length; i++) {
                    strArr[i] = lVarArr[i].f66451a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f66468a) {
                if (strArr.length != 0) {
                    this.f66469b = (String[]) strArr.clone();
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
            if (this.f66468a) {
                if (strArr.length != 0) {
                    this.f66470c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f66468a = oVar.f66464a;
            this.f66469b = oVar.f66466c;
            this.f66470c = oVar.f66467d;
            this.f66471d = oVar.f66465b;
        }
    }
}
