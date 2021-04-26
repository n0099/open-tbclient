package d.b.c.a.b.a.i;

import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.a.b.w;
import d.b.c.a.b.a.k.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public class a extends e {

    /* renamed from: c  reason: collision with root package name */
    public final d<Socket> f64717c;

    /* renamed from: d  reason: collision with root package name */
    public final d<Socket> f64718d;

    /* renamed from: e  reason: collision with root package name */
    public final d<Socket> f64719e;

    /* renamed from: f  reason: collision with root package name */
    public final d<Socket> f64720f;

    /* renamed from: g  reason: collision with root package name */
    public final c f64721g = c.a();

    /* renamed from: d.b.c.a.b.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1762a extends d.b.c.a.b.a.k.c {

        /* renamed from: a  reason: collision with root package name */
        public final Object f64722a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f64723b;

        public C1762a(Object obj, Method method) {
            this.f64722a = obj;
            this.f64723b = method;
        }

        @Override // d.b.c.a.b.a.k.c
        public List<Certificate> b(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f64723b.invoke(this.f64722a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C1762a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManager f64724a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f64725b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f64725b = method;
            this.f64724a = x509TrustManager;
        }

        @Override // d.b.c.a.b.a.k.f
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f64725b.invoke(this.f64724a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw d.b.c.a.b.a.e.g("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f64724a.equals(bVar.f64724a) && this.f64725b.equals(bVar.f64725b);
            }
            return false;
        }

        public int hashCode() {
            return this.f64724a.hashCode() + (this.f64725b.hashCode() * 31);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Method f64726a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f64727b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f64728c;

        public c(Method method, Method method2, Method method3) {
            this.f64726a = method;
            this.f64727b = method2;
            this.f64728c = method3;
        }

        public static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }

        public Object b(String str) {
            Method method = this.f64726a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f64727b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean c(Object obj) {
            if (obj != null) {
                try {
                    this.f64728c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
    }

    public a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f64717c = dVar;
        this.f64718d = dVar2;
        this.f64719e = dVar3;
        this.f64720f = dVar4;
    }

    public static e a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
            d dVar4 = new d(null, "setHostname", String.class);
            if (q()) {
                d dVar5 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                dVar = dVar5;
            } else {
                dVar = null;
                dVar2 = null;
            }
            return new a(cls2, dVar3, dVar4, dVar, dVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    public static boolean q() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public d.b.c.a.b.a.k.c b(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C1762a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public Object c(String str) {
        return this.f64721g.b(str);
    }

    @Override // d.b.c.a.b.a.i.e
    public String d(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.f64719e;
        if (dVar == null || !dVar.d(sSLSocket) || (bArr = (byte[]) this.f64719e.g(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, d.b.c.a.b.a.e.j);
    }

    @Override // d.b.c.a.b.a.i.e
    public void f(int i2, String str, Throwable th) {
        int min;
        int i3 = i2 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public void g(String str, Object obj) {
        if (this.f64721g.c(obj)) {
            return;
        }
        f(5, str, null);
    }

    @Override // d.b.c.a.b.a.i.e
    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (!d.b.c.a.b.a.e.t(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e3);
                throw iOException;
            }
            throw e3;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public void i(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.f64717c.e(sSLSocket, Boolean.TRUE);
            this.f64718d.e(sSLSocket, str);
        }
        d<Socket> dVar = this.f64720f;
        if (dVar == null || !dVar.d(sSLSocket)) {
            return;
        }
        this.f64720f.g(sSLSocket, e.n(list));
    }

    @Override // d.b.c.a.b.a.i.e
    public f k(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.k(x509TrustManager);
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public boolean m(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return o(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.m(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw d.b.c.a.b.a.e.g("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw d.b.c.a.b.a.e.g("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw d.b.c.a.b.a.e.g("unable to determine cleartext support", e);
        }
    }

    public final boolean o(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return p(str, cls, obj);
        }
    }

    public final boolean p(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.m(str);
        }
    }
}
