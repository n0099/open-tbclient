package d.b.c.a.b.a.i;

import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public final class b extends e {

    /* renamed from: c  reason: collision with root package name */
    public final Method f69293c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f69294d;

    public b(Method method, Method method2) {
        this.f69293c = method;
        this.f69294d = method2;
    }

    public static b o() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public String d(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f69294d.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (str.equals("")) {
                    return null;
                }
                return str;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw d.b.c.a.b.a.e.g("unable to get selected protocols", e2);
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public void i(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> e2 = e.e(list);
            this.f69293c.invoke(sSLParameters, e2.toArray(new String[e2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw d.b.c.a.b.a.e.g("unable to set ssl parameters", e3);
        }
    }
}
