package d.a.n0.h.k0;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class g extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f50054e;

    /* renamed from: f  reason: collision with root package name */
    public DatagramSocket f50055f;

    /* renamed from: g  reason: collision with root package name */
    public int f50056g;

    /* renamed from: h  reason: collision with root package name */
    public k f50057h;

    /* renamed from: i  reason: collision with root package name */
    public a f50058i;
    public ArrayList<JsFunction> j;
    public ArrayList<JsFunction> k;
    public ArrayList<JsFunction> l;
    public ArrayList<JsFunction> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(JSRuntime jsRuntime) {
        super(jsRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsRuntime};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.f50054e = "%s:fail %s";
        this.f50057h = new k();
        this.f50058i = new a();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
    }

    public final void A(DatagramPacket dp) {
        byte[] address;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dp) == null) {
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
                    z(it2.next(), "onMessage", "receive failed");
                }
            }
        }
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50056g : invokeV.intValue;
    }

    public final int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (int i2 = 49152; i2 <= 65535; i2++) {
                try {
                    this.f50055f = new DatagramSocket(i2);
                    y(i2);
                    return i2;
                } catch (Throwable unused) {
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final DatagramSocket D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50055f : (DatagramSocket) invokeV.objValue;
    }

    public final void E(String method, String error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, method, error) == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(error, "error");
            Iterator<JsFunction> it = this.l.iterator();
            while (it.hasNext()) {
                z(it.next(), method, error);
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Iterator<JsFunction> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().call();
            }
        }
    }

    public final d.a.n0.a.y.b.a G(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsObject)) == null) {
            d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
            return G != null ? G : new d.a.n0.a.y.b.a();
        }
        return (d.a.n0.a.y.b.a) invokeL.objValue;
    }

    public final void H(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || j.f50062c.c(this)) {
            return;
        }
        try {
            if (!this.f50057h.a().offer(new b(new DatagramPacket(cVar.b(), cVar.d(), cVar.c(), InetAddress.getByName(cVar.a()), cVar.e()), this))) {
                E("send", "send queue is full");
                return;
            }
            if (!this.f50057h.b()) {
                this.f50057h.c(true);
                this.f50057h.start();
            }
            if (this.f50058i.a()) {
                return;
            }
            this.f50058i.b(true);
            this.f50058i.c(this);
            F();
            this.f50058i.start();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final int bind(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 != -1 && !j.f50062c.d(i2)) {
                try {
                    this.f50055f = new DatagramSocket(i2);
                    y(i2);
                    return i2;
                } catch (Throwable unused) {
                    return C();
                }
            }
            return C();
        }
        return invokeI.intValue;
    }

    @JavascriptInterface
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                DatagramSocket datagramSocket = this.f50055f;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.f50057h.c(false);
                this.f50057h.interrupt();
                this.f50058i.b(false);
                this.f50058i.interrupt();
                j.f50062c.e(this);
                Iterator<JsFunction> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().call("success");
                }
            } catch (Throwable unused) {
                E(IntentConfig.CLOSE, "close failed");
            }
        }
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.m.remove(d.a.n0.h.d.c.a.e(d.a.n0.a.y.b.a.G(jsObject)).f49901a);
        }
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.l.remove(d.a.n0.h.d.c.a.e(d.a.n0.a.y.b.a.G(jsObject)).f49901a);
        }
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.k.remove(d.a.n0.h.d.c.a.e(d.a.n0.a.y.b.a.G(jsObject)).f49901a);
        }
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.j.remove(d.a.n0.h.d.c.a.e(d.a.n0.a.y.b.a.G(jsObject)).f49901a);
        }
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            d.a.n0.a.y.b.a G = G(jsObject);
            if (G != null) {
                this.m.add(d.a.n0.h.d.c.a.e(G).f49901a);
            }
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            d.a.n0.a.y.b.a G = G(jsObject);
            if (G != null) {
                this.l.add(d.a.n0.h.d.c.a.e(G).f49901a);
            }
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.k.add(d.a.n0.h.d.c.a.e(d.a.n0.a.y.b.a.G(jsObject)).f49901a);
        }
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        d.a.n0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            if (j.f50062c.c(this) || (G = G(jsObject)) == null) {
                return;
            }
            this.j.add(d.a.n0.h.d.c.a.e(G).f49901a);
        }
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
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
                E("send", "port is empty");
                return;
            }
            if (cVar.a().length() == 0) {
                E("send", "address is empty");
            } else {
                H(cVar);
            }
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            j.f50062c.a(i2);
            this.f50056g = i2;
        }
    }

    public final void z(JsFunction jsFunction, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, jsFunction, str, str2) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.f50054e, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (jsFunction != null) {
                jsFunction.call(new d(format));
            }
        }
    }
}
