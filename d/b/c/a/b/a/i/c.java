package d.b.c.a.b.a.i;

import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public class c extends e {

    /* renamed from: c  reason: collision with root package name */
    public final Method f69191c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f69192d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f69193e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f69194f;

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f69195g;

    /* loaded from: classes6.dex */
    public static class a implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f69196e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69197f;

        /* renamed from: g  reason: collision with root package name */
        public String f69198g;

        public a(List<String> list) {
            this.f69196e = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = d.b.c.a.b.a.e.f68986b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f69197f = true;
                return null;
            } else if (name.equals(WebSocketRequest.PARAM_KEY_PROTOCOLS) && objArr.length == 0) {
                return this.f69196e;
            } else {
                if ((name.equals("selectProtocol") || name.equals(InvoiceBuildActivity.EXTRA_PARAMS_TYPE)) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f69196e.contains(list.get(i2))) {
                            String str = (String) list.get(i2);
                            this.f69198g = str;
                            return str;
                        }
                    }
                    String str2 = this.f69196e.get(0);
                    this.f69198g = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f69198g = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }

    public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f69191c = method;
        this.f69192d = method2;
        this.f69193e = method3;
        this.f69194f = cls;
        this.f69195g = cls2;
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public String d(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f69192d.invoke(null, sSLSocket));
            if (!aVar.f69197f && aVar.f69198g == null) {
                e.j().f(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            } else if (aVar.f69197f) {
                return null;
            } else {
                return aVar.f69198g;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw d.b.c.a.b.a.e.g("unable to get selected protocol", e2);
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public void i(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.f69191c.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f69194f, this.f69195g}, new a(e.e(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw d.b.c.a.b.a.e.g("unable to set alpn", e2);
        }
    }

    @Override // d.b.c.a.b.a.i.e
    public void l(SSLSocket sSLSocket) {
        try {
            this.f69193e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw d.b.c.a.b.a.e.g("unable to remove alpn", e2);
        }
    }
}
