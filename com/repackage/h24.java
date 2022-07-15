package com.repackage;

import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
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
/* loaded from: classes6.dex */
public final class h24 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public DatagramSocket b;
    public int c;
    public l24 d;
    public b24 e;
    public ArrayList<JsFunction> f;
    public ArrayList<JsFunction> g;
    public ArrayList<JsFunction> h;
    public ArrayList<JsFunction> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h24(JSRuntime jsRuntime) {
        super(jsRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsRuntime};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.a = "%s:fail %s";
        this.d = new l24();
        this.e = new b24();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
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
                Iterator<JsFunction> it = this.f.iterator();
                while (it.hasNext()) {
                    String inetAddress = dp.getAddress().toString();
                    Intrinsics.checkNotNullExpressionValue(inetAddress, "dp.address.toString()");
                    it.next().call(new f24(bArr, new g24(inetAddress, dp.getLength(), dp.getPort(), str)));
                }
            } catch (Throwable unused) {
                Iterator<JsFunction> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    z(it2.next(), "onMessage", "receive failed");
                }
            }
        }
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public final int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (int i = 49152; i <= 65535; i++) {
                try {
                    this.b = new DatagramSocket(i);
                    y(i);
                    return i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (DatagramSocket) invokeV.objValue;
    }

    public final void E(String method, String error) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, method, error) == null) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(error, "error");
            Iterator<JsFunction> it = this.h.iterator();
            while (it.hasNext()) {
                z(it.next(), method, error);
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Iterator<JsFunction> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().call();
            }
        }
    }

    public final os1 G(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jsObject)) == null) {
            os1 F = os1.F(jsObject);
            return F != null ? F : new os1();
        }
        return (os1) invokeL.objValue;
    }

    public final void H(d24 d24Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, d24Var) == null) || k24.c.c(this)) {
            return;
        }
        try {
            if (!this.d.a().offer(new c24(new DatagramPacket(d24Var.b(), d24Var.d(), d24Var.c(), InetAddress.getByName(d24Var.a()), d24Var.e()), this))) {
                E("send", "send queue is full");
                return;
            }
            if (!this.d.b()) {
                this.d.c(true);
                this.d.start();
            }
            if (this.e.a()) {
                return;
            }
            this.e.b(true);
            this.e.c(this);
            F();
            this.e.start();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final int bind(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i != -1 && !k24.c.d(i)) {
                try {
                    this.b = new DatagramSocket(i);
                    y(i);
                    return i;
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
                DatagramSocket datagramSocket = this.b;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.d.c(false);
                this.d.interrupt();
                this.e.b(false);
                this.e.interrupt();
                k24.c.e(this);
                Iterator<JsFunction> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().call("success");
                }
            } catch (Throwable unused) {
                E("close", "close failed");
            }
        }
    }

    @JavascriptInterface
    public final void offCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.i.remove(ou3.e(os1.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.h.remove(ou3.e(os1.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.remove(ou3.e(os1.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void offMessageCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.f.remove(ou3.e(os1.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onCloseCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            os1 G = G(jsObject);
            if (G != null) {
                this.i.add(ou3.e(G).a);
            }
        }
    }

    @JavascriptInterface
    public final void onErrorCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            os1 G = G(jsObject);
            if (G != null) {
                this.h.add(ou3.e(G).a);
            }
        }
    }

    @JavascriptInterface
    public final void onListeningCallback(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            this.g.add(ou3.e(os1.F(jsObject)).a);
        }
    }

    @JavascriptInterface
    public final void onMessageCallback(JsObject jsObject) {
        os1 G;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            if (k24.c.c(this) || (G = G(jsObject)) == null) {
                return;
            }
            this.f.add(ou3.e(G).a);
        }
    }

    @JavascriptInterface
    public final void send(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) {
            Intrinsics.checkNotNullParameter(jsObject, "jsObject");
            os1 F = os1.F(jsObject);
            d24 d24Var = new d24();
            String C = F.C("address", "");
            Intrinsics.checkNotNullExpressionValue(C, "jsObjectMap.optString(PARAM_ADDRESS, \"\")");
            d24Var.f(C);
            String B = F.B("message");
            if (B == null || B.length() == 0) {
                byte[] buffer = F.s("message").buffer();
                if (buffer != null) {
                    d24Var.h(F.r(CloudStabilityUBCUtils.KEY_LENGTH, buffer.length));
                    d24Var.i(F.q("offset"));
                    d24Var.g(buffer);
                }
            } else {
                Charset charset = Charsets.UTF_8;
                if (B != null) {
                    byte[] bytes = B.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    d24Var.g(bytes);
                    Charset charset2 = Charsets.UTF_8;
                    if (B == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    byte[] bytes2 = B.getBytes(charset2);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                    d24Var.h(bytes2.length);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            d24Var.j(F.r(ClientCookie.PORT_ATTR, -1));
            if (d24Var.e() == -1) {
                E("send", "port is empty");
                return;
            }
            if (d24Var.a().length() == 0) {
                E("send", "address is empty");
            } else {
                H(d24Var);
            }
        }
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            k24.c.a(i);
            this.c = i;
        }
    }

    public final void z(JsFunction jsFunction, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, jsFunction, str, str2) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.a, Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            if (jsFunction != null) {
                jsFunction.call(new e24(format));
            }
        }
    }
}
