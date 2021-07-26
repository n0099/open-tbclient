package d.a.o0.h.y.h;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.games.network.websocket.WebSocketEventTarget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends WebSocketEventTarget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f50894g;

    /* renamed from: h  reason: collision with root package name */
    public b f50895h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50896a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-138554680, "Ld/a/o0/h/y/h/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-138554680, "Ld/a/o0/h/y/h/c$a;");
                    return;
                }
            }
            int[] iArr = new int[WebSocketEventTarget.SocketTaskState.values().length];
            f50896a = iArr;
            try {
                iArr[WebSocketEventTarget.SocketTaskState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50896a[WebSocketEventTarget.SocketTaskState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, d.a.o0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
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
        this.f50895h = bVar;
    }

    public final void A(d.a.o0.a.y.b.a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, aVar, str, str2) == null) {
            String format = String.format("%s:fail %s", str, str2);
            if (WebSocketEventTarget.f11926f) {
                Log.i("WebSocket", format);
            }
            d.a.o0.h.m0.c.a(aVar, false, new f(format));
        }
    }

    public final void B(d.a.o0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str) == null) {
            String format = String.format("%s:ok", str);
            if (WebSocketEventTarget.f11926f) {
                Log.i("WebSocket", format);
            }
            d.a.o0.h.m0.c.a(aVar, true, new f(format));
        }
    }

    public c C(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            d.a.o0.a.y.b.a E = E(jsObject);
            this.f50894g = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
            int i2 = E.i("url");
            if (i2 != 7) {
                A(E, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", d.a.o0.h.g0.f.d.f(7), d.a.o0.h.g0.f.d.f(i2)));
                return this;
            }
            String C = E.C("url");
            String C2 = E.C("__plugin__");
            if (!this.f50895h.a()) {
                A(E, "connectSocket", "up to max connect count");
                return this;
            } else if (!D(C, C2)) {
                A(E, "connectSocket", String.format("invalid url \"%s\"", C));
                return this;
            } else {
                WebSocketRequest z = z(C, E);
                F(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(z, this);
                    this.f50894g = connect.getTaskId();
                    this.f50895h.b(connect);
                    d.a.o0.h.m0.c.a(E, true, new g(this.f50894g, String.format("%s:ok", "connectSocket")));
                    return this;
                } catch (Exception e2) {
                    A(E, "connectSocket", e2.getMessage());
                    return this;
                }
            }
        }
        return (c) invokeL.objValue;
    }

    public final boolean D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (d.a.o0.a.u1.a.a.q()) {
                return true;
            }
            return str.startsWith("wss://") && d.a.o0.a.b2.a.b.c("socket", str, str2) == 0;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public final d.a.o0.a.y.b.a E(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jsObject)) == null) {
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            return G == null ? new d.a.o0.a.y.b.a() : G;
        }
        return (d.a.o0.a.y.b.a) invokeL.objValue;
    }

    public final void F(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            close(null);
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            super.onClose(jSONObject);
            if (this.f50895h == null || jSONObject == null) {
                return;
            }
            this.f50895h.c(jSONObject.optString("taskID"));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, th, jSONObject) == null) {
            super.onError(th, jSONObject);
            if (this.f50895h == null || jSONObject == null) {
                return;
            }
            this.f50895h.c(jSONObject.optString("taskID"));
        }
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer jsArrayBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) {
            d.a.o0.a.y.b.a E = E(jsObject);
            int i2 = a.f50896a[this.f11927e.ordinal()];
            if (i2 == 1) {
                A(E, "SocketTask.send", "SocketTask.readyState is not OPEN");
            } else if (i2 != 2) {
                int i3 = E.i("data");
                String str = null;
                if (i3 == 7) {
                    str = E.D("data", null);
                    jsArrayBuffer = null;
                } else if (i3 != 10) {
                    A(E, "SocketTask.send", "invalid data type");
                    return;
                } else {
                    jsArrayBuffer = E.u("data", null);
                }
                if (str == null && jsArrayBuffer == null) {
                    A(E, "SocketTask.send", "invalid data type");
                    return;
                }
                try {
                    if (str != null) {
                        WebSocketManager.INSTANCE.send(this.f50894g, str);
                    } else if (jsArrayBuffer != null) {
                        WebSocketManager.INSTANCE.send(this.f50894g, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                    }
                    B(E, "SocketTask.send");
                } catch (Exception e2) {
                    A(E, "SocketTask.send", e2.getMessage());
                }
            } else {
                A(E, "SocketTask.send", "SocketTask.readyState is CLOSED");
            }
        }
    }

    public final WebSocketRequest z(String str, @NonNull d.a.o0.a.y.b.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, aVar)) == null) {
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(str);
            builder.setMethod(aVar.C("method"));
            d.a.o0.a.y.b.a x = aVar.x("header");
            if (x != null) {
                for (String str2 : x.k()) {
                    if (!TextUtils.isEmpty(str2) && !d.a.o0.a.n1.a.f46822d.contains(str2.toUpperCase(Locale.US))) {
                        builder.addHeader(str2, x.I(str2));
                    }
                }
            }
            String[] E = aVar.E(WebSocketRequest.PARAM_KEY_PROTOCOLS);
            ArrayList arrayList = new ArrayList();
            if (E != null && E.length != 0) {
                arrayList.addAll(Arrays.asList(E));
            } else {
                arrayList.add("");
            }
            builder.setProtocols(arrayList);
            builder.setConnectionLostTimeout(0);
            return builder.build();
        }
        return (WebSocketRequest) invokeLL.objValue;
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            d.a.o0.a.y.b.a E = E(jsObject);
            if (this.f11927e == WebSocketEventTarget.SocketTaskState.CLOSE) {
                A(E, "SocketTask.close", "SocketTask.readyState is CLOSED");
                return;
            }
            int s = E.s("code", 1000);
            String C = E.C("reason");
            try {
                if (!(s == 1000 || (s >= 3000 && s <= 4999))) {
                    A(E, "SocketTask.close", d.f50897a);
                    return;
                }
                try {
                    WebSocketManager.INSTANCE.close(this.f50894g, s, C);
                    B(E, "SocketTask.close");
                } catch (Exception e2) {
                    A(E, "SocketTask.close", e2.getMessage());
                }
            } finally {
                this.f50895h.c(this.f50894g);
            }
        }
    }
}
