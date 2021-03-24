package d.c.c.a.b;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.bytedance.sdk.a.b.ad;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: e  reason: collision with root package name */
    public static final l[] f65520e = {l.m, l.o, l.n, l.p, l.r, l.q, l.i, l.k, l.j, l.l, l.f65508g, l.f65509h, l.f65506e, l.f65507f, l.f65505d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f65521f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f65522g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f65523a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65524b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f65525c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f65526d;

    static {
        a aVar = new a(true);
        aVar.c(f65520e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f65521f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f65522g = new a(false).e();
    }

    public o(a aVar) {
        this.f65523a = aVar.f65527a;
        this.f65525c = aVar.f65528b;
        this.f65526d = aVar.f65529c;
        this.f65524b = aVar.f65530d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f65526d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f65525c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f65523a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f65523a) {
            String[] strArr = this.f65526d;
            if (strArr == null || d.c.c.a.b.a.e.B(d.c.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f65525c;
                return strArr2 == null || d.c.c.a.b.a.e.B(l.f65503b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f65525c != null) {
            enabledCipherSuites = d.c.c.a.b.a.e.w(l.f65503b, sSLSocket.getEnabledCipherSuites(), this.f65525c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f65526d != null) {
            enabledProtocols = d.c.c.a.b.a.e.w(d.c.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f65526d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.c.c.a.b.a.e.f(l.f65503b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.c.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f65525c;
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
            boolean z = this.f65523a;
            if (z != oVar.f65523a) {
                return false;
            }
            return !z || (Arrays.equals(this.f65525c, oVar.f65525c) && Arrays.equals(this.f65526d, oVar.f65526d) && this.f65524b == oVar.f65524b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f65526d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f65524b;
    }

    public int hashCode() {
        if (this.f65523a) {
            return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + Arrays.hashCode(this.f65525c)) * 31) + Arrays.hashCode(this.f65526d)) * 31) + (!this.f65524b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f65523a) {
            String obj = this.f65525c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f65526d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f65524b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65527a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f65528b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f65529c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65530d;

        public a(boolean z) {
            this.f65527a = z;
        }

        public a a(boolean z) {
            if (this.f65527a) {
                this.f65530d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f65527a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f27184f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f65527a) {
                String[] strArr = new String[lVarArr.length];
                for (int i = 0; i < lVarArr.length; i++) {
                    strArr[i] = lVarArr[i].f65510a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f65527a) {
                if (strArr.length != 0) {
                    this.f65528b = (String[]) strArr.clone();
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
            if (this.f65527a) {
                if (strArr.length != 0) {
                    this.f65529c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f65527a = oVar.f65523a;
            this.f65528b = oVar.f65525c;
            this.f65529c = oVar.f65526d;
            this.f65530d = oVar.f65524b;
        }
    }
}
