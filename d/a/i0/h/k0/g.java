package d.a.i0.h.k0;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public final class g extends EventTargetImpl {

    /* renamed from: e  reason: collision with root package name */
    public final String f47252e;

    /* renamed from: f  reason: collision with root package name */
    public DatagramSocket f47253f;

    /* renamed from: g  reason: collision with root package name */
    public int f47254g;

    /* renamed from: h  reason: collision with root package name */
    public k f47255h;

    /* renamed from: i  reason: collision with root package name */
    public a f47256i;
    public ArrayList<JsFunction> j;
    public ArrayList<JsFunction> k;
    public ArrayList<JsFunction> l;
    public ArrayList<JsFunction> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(JSRuntime jsRuntime) {
        super(jsRuntime);
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.f47252e = "%s:fail %s";
        this.f47255h = new k();
        this.f47256i = new a();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
    }

    public final void A(JsFunction jsFunction, String str, String str2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(this.f47252e, Arrays.copyOf(new Object[]{str, str2}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        if (jsFunction != null) {
            jsFunction.call(new d(format));
        }
    }

    public final void B(DatagramPacket dp) {
        byte[] address;
        Intrinsics.checkNotNullParameter(dp, "dp");
        try {
            byte[] bArr = new byte[dp.getLength()];
            System.arraycopy(dp.getData(), dp.getOffset(), bArr, 0, dp.getLength());
            InetAddress address2 = dp.getAddress();
            String str = (address2 == null || (address = address2.getAddress()) == null || address.length != 4) ? "IPv6" : "IPv4";
            Iterator<JsFunction> it = this.j.iterator();
            while (it.hasNext()) {
                String inetAddress = dp.getAddress().toString();
                Intrinsics.checkNotNullExpressionValue(inetAddress, "dp.address.toString()");
                it.next().call(new e(bArr, new f(inetAddress, dp.getLength(), dp.getPort(), str)));
            }
        } catch (Throwable unused) {
            Iterator<JsFunction> it2 = this.l.iterator();
            while (it2.hasNext()) {
                A(it2.next(), "onMessage", "receive failed");
            }
        }
    }

    public final int C() {
        return this.f47254g;
    }

    public final int D() {
        for (int i2 = 49152; i2 <= 65535; i2++) {
            try {
                this.f47253f = new DatagramSocket(i2);
                z(i2);
                return i2;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public final DatagramSocket E() {
        return this.f47253f;
    }

    public final void F(String method, String error) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(error, "error");
        Iterator<JsFunction> it = this.l.iterator();
        while (it.hasNext()) {
            A(it.next(), method, error);
        }
    }

    public final void G() {
        Iterator<JsFunction> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().call();
        }
    }

    public final d.a.i0.a.y.b.a H(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        return G != null ? G : new d.a.i0.a.y.b.a();
    }

    public final void I(c cVar) {
        if (j.f47260c.c(this)) {
            return;
        }
        try {
            if (!this.f47255h.a().offer(new b(new DatagramPacket(cVar.b(), cVar.d(), cVar.c(), InetAddress.getByName(cVar.a()), cVar.e()), this))) {
                F("send", "send queue is full");
                return;
            }
            if (!this.f47255h.b()) {
                this.f47255h.c(true);
                this.f47255h.start();
            }
            if (this.f47256i.a()) {
                return;
            }
            this.f47256i.b(true);
            this.f47256i.c(this);
            G();
            this.f47256i.start();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final int bind(int i2) {
        if (i2 != -1 && !j.f47260c.d(i2)) {
            try {
                this.f47253f = new DatagramSocket(i2);
                z(i2);
                return i2;
            } catch (Throwable unused) {
                return D();
            }
        }
        return D();
    }

    @JavascriptInterface
    public final void close() {
        try {
            DatagramSocket datagramSocket = this.f47253f;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            this.f47255h.c(false);
            this.f47255h.interrupt();
            this.f47256i.b(false);
            this.f47256i.interrupt();
            j.f47260c.e(this);
            Iterator<JsFunction> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().call("success");
            }
        } catch (Throwable unused) {
            F(IntentConfig.CLOSE, "close failed");
        }
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        this.m.remove(d.a.i0.h.d.c.a.e(d.a.i0.a.y.b.a.G(jsObject)).f47099a);
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        this.l.remove(d.a.i0.h.d.c.a.e(d.a.i0.a.y.b.a.G(jsObject)).f47099a);
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        this.k.remove(d.a.i0.h.d.c.a.e(d.a.i0.a.y.b.a.G(jsObject)).f47099a);
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        this.j.remove(d.a.i0.h.d.c.a.e(d.a.i0.a.y.b.a.G(jsObject)).f47099a);
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        d.a.i0.a.y.b.a H = H(jsObject);
        if (H != null) {
            this.m.add(d.a.i0.h.d.c.a.e(H).f47099a);
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        d.a.i0.a.y.b.a H = H(jsObject);
        if (H != null) {
            this.l.add(d.a.i0.h.d.c.a.e(H).f47099a);
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        this.k.add(d.a.i0.h.d.c.a.e(d.a.i0.a.y.b.a.G(jsObject)).f47099a);
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        d.a.i0.a.y.b.a H;
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        if (j.f47260c.c(this) || (H = H(jsObject)) == null) {
            return;
        }
        this.j.add(d.a.i0.h.d.c.a.e(H).f47099a);
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        c cVar = new c();
        String D = G.D("address", "");
        Intrinsics.checkNotNullExpressionValue(D, "jsObjectMap.optString(PARAM_ADDRESS, \"\")");
        cVar.f(D);
        String C = G.C("message");
        if (C == null || C.length() == 0) {
            byte[] buffer = G.t("message").buffer();
            if (buffer != null) {
                cVar.h(G.s(CloudStabilityUBCUtils.KEY_LENGTH, buffer.length));
                cVar.i(G.r("offset"));
                cVar.g(buffer);
            }
        } else {
            Charset charset = Charsets.UTF_8;
            if (C != null) {
                byte[] bytes = C.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                cVar.g(bytes);
                Charset charset2 = Charsets.UTF_8;
                if (C == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes2 = C.getBytes(charset2);
                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                cVar.h(bytes2.length);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        cVar.j(G.s(ClientCookie.PORT_ATTR, -1));
        if (cVar.e() == -1) {
            F("send", "port is empty");
            return;
        }
        if (cVar.a().length() == 0) {
            F("send", "address is empty");
        } else {
            I(cVar);
        }
    }

    public final void z(int i2) {
        j.f47260c.a(i2);
        this.f47254g = i2;
    }
}
