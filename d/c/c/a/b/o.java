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
    public static final l[] f65521e = {l.m, l.o, l.n, l.p, l.r, l.q, l.i, l.k, l.j, l.l, l.f65509g, l.f65510h, l.f65507e, l.f65508f, l.f65506d};

    /* renamed from: f  reason: collision with root package name */
    public static final o f65522f;

    /* renamed from: g  reason: collision with root package name */
    public static final o f65523g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f65524a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65525b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f65526c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f65527d;

    static {
        a aVar = new a(true);
        aVar.c(f65521e);
        aVar.b(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, ad.TLS_1_0);
        aVar.a(true);
        o e2 = aVar.e();
        f65522f = e2;
        a aVar2 = new a(e2);
        aVar2.b(ad.TLS_1_0);
        aVar2.a(true);
        aVar2.e();
        f65523g = new a(false).e();
    }

    public o(a aVar) {
        this.f65524a = aVar.f65528a;
        this.f65526c = aVar.f65529b;
        this.f65527d = aVar.f65530c;
        this.f65525b = aVar.f65531d;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        o d2 = d(sSLSocket, z);
        String[] strArr = d2.f65527d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = d2.f65526c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean b() {
        return this.f65524a;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.f65524a) {
            String[] strArr = this.f65527d;
            if (strArr == null || d.c.c.a.b.a.e.B(d.c.c.a.b.a.e.p, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f65526c;
                return strArr2 == null || d.c.c.a.b.a.e.B(l.f65504b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final o d(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f65526c != null) {
            enabledCipherSuites = d.c.c.a.b.a.e.w(l.f65504b, sSLSocket.getEnabledCipherSuites(), this.f65526c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f65527d != null) {
            enabledProtocols = d.c.c.a.b.a.e.w(d.c.c.a.b.a.e.p, sSLSocket.getEnabledProtocols(), this.f65527d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int f2 = d.c.c.a.b.a.e.f(l.f65504b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && f2 != -1) {
            enabledCipherSuites = d.c.c.a.b.a.e.x(enabledCipherSuites, supportedCipherSuites[f2]);
        }
        a aVar = new a(this);
        aVar.d(enabledCipherSuites);
        aVar.f(enabledProtocols);
        return aVar.e();
    }

    public List<l> e() {
        String[] strArr = this.f65526c;
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
            boolean z = this.f65524a;
            if (z != oVar.f65524a) {
                return false;
            }
            return !z || (Arrays.equals(this.f65526c, oVar.f65526c) && Arrays.equals(this.f65527d, oVar.f65527d) && this.f65525b == oVar.f65525b);
        }
        return false;
    }

    public List<ad> f() {
        String[] strArr = this.f65527d;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean g() {
        return this.f65525b;
    }

    public int hashCode() {
        if (this.f65524a) {
            return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + Arrays.hashCode(this.f65526c)) * 31) + Arrays.hashCode(this.f65527d)) * 31) + (!this.f65525b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f65524a) {
            String obj = this.f65526c != null ? e().toString() : "[all enabled]";
            String obj2 = this.f65527d != null ? f().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f65525b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return "ConnectionSpec()";
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65528a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f65529b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f65530c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65531d;

        public a(boolean z) {
            this.f65528a = z;
        }

        public a a(boolean z) {
            if (this.f65528a) {
                this.f65531d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a b(ad... adVarArr) {
            if (this.f65528a) {
                String[] strArr = new String[adVarArr.length];
                for (int i = 0; i < adVarArr.length; i++) {
                    strArr[i] = adVarArr[i].f27185f;
                }
                f(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a c(l... lVarArr) {
            if (this.f65528a) {
                String[] strArr = new String[lVarArr.length];
                for (int i = 0; i < lVarArr.length; i++) {
                    strArr[i] = lVarArr[i].f65511a;
                }
                d(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(String... strArr) {
            if (this.f65528a) {
                if (strArr.length != 0) {
                    this.f65529b = (String[]) strArr.clone();
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
            if (this.f65528a) {
                if (strArr.length != 0) {
                    this.f65530c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(o oVar) {
            this.f65528a = oVar.f65524a;
            this.f65529b = oVar.f65526c;
            this.f65530c = oVar.f65527d;
            this.f65531d = oVar.f65525b;
        }
    }
}
