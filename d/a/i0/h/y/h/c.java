package d.a.i0.h.y.h;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.games.network.websocket.WebSocketEventTarget;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends WebSocketEventTarget {

    /* renamed from: g  reason: collision with root package name */
    public String f47588g;

    /* renamed from: h  reason: collision with root package name */
    public b f47589h;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47590a;

        static {
            int[] iArr = new int[WebSocketEventTarget.SocketTaskState.values().length];
            f47590a = iArr;
            try {
                iArr[WebSocketEventTarget.SocketTaskState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47590a[WebSocketEventTarget.SocketTaskState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(b bVar, d.a.i0.a.l0.c cVar) {
        super(cVar);
        this.f47589h = bVar;
    }

    public final WebSocketRequest A(String str, @NonNull d.a.i0.a.y.b.a aVar) {
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(str);
        builder.setMethod(aVar.C("method"));
        d.a.i0.a.y.b.a x = aVar.x("header");
        if (x != null) {
            for (String str2 : x.k()) {
                if (!TextUtils.isEmpty(str2) && !d.a.i0.a.n1.a.f43512d.contains(str2.toUpperCase(Locale.US))) {
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

    public final void B(d.a.i0.a.y.b.a aVar, String str, String str2) {
        String format = String.format("%s:fail %s", str, str2);
        if (WebSocketEventTarget.f11771f) {
            Log.i("WebSocket", format);
        }
        d.a.i0.h.m0.c.a(aVar, false, new f(format));
    }

    public final void C(d.a.i0.a.y.b.a aVar, String str) {
        String format = String.format("%s:ok", str);
        if (WebSocketEventTarget.f11771f) {
            Log.i("WebSocket", format);
        }
        d.a.i0.h.m0.c.a(aVar, true, new f(format));
    }

    public c D(JsObject jsObject) {
        d.a.i0.a.y.b.a F = F(jsObject);
        this.f47588g = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
        int i2 = F.i("url");
        if (i2 != 7) {
            B(F, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", d.a.i0.h.g0.f.d.f(7), d.a.i0.h.g0.f.d.f(i2)));
            return this;
        }
        String C = F.C("url");
        String C2 = F.C("__plugin__");
        if (!this.f47589h.a()) {
            B(F, "connectSocket", "up to max connect count");
            return this;
        } else if (!E(C, C2)) {
            B(F, "connectSocket", String.format("invalid url \"%s\"", C));
            return this;
        } else {
            WebSocketRequest A = A(C, F);
            G(jsObject);
            try {
                WebSocketTask connect = WebSocketManager.INSTANCE.connect(A, this);
                this.f47588g = connect.getTaskId();
                this.f47589h.b(connect);
                d.a.i0.h.m0.c.a(F, true, new g(this.f47588g, String.format("%s:ok", "connectSocket")));
                return this;
            } catch (Exception e2) {
                B(F, "connectSocket", e2.getMessage());
                return this;
            }
        }
    }

    public final boolean E(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (d.a.i0.a.u1.a.a.q()) {
            return true;
        }
        return str.startsWith("wss://") && d.a.i0.a.b2.a.b.c("socket", str, str2) == 0;
    }

    @NonNull
    public final d.a.i0.a.y.b.a F(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        return G == null ? new d.a.i0.a.y.b.a() : G;
    }

    public final void G(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }

    @JavascriptInterface
    public void close() {
        close(null);
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        super.onClose(jSONObject);
        if (this.f47589h == null || jSONObject == null) {
            return;
        }
        this.f47589h.c(jSONObject.optString("taskID"));
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        super.onError(th, jSONObject);
        if (this.f47589h == null || jSONObject == null) {
            return;
        }
        this.f47589h.c(jSONObject.optString("taskID"));
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer jsArrayBuffer;
        d.a.i0.a.y.b.a F = F(jsObject);
        int i2 = a.f47590a[this.f11772e.ordinal()];
        if (i2 == 1) {
            B(F, "SocketTask.send", "SocketTask.readyState is not OPEN");
        } else if (i2 != 2) {
            int i3 = F.i("data");
            String str = null;
            if (i3 == 7) {
                str = F.D("data", null);
                jsArrayBuffer = null;
            } else if (i3 != 10) {
                B(F, "SocketTask.send", "invalid data type");
                return;
            } else {
                jsArrayBuffer = F.u("data", null);
            }
            if (str == null && jsArrayBuffer == null) {
                B(F, "SocketTask.send", "invalid data type");
                return;
            }
            try {
                if (str != null) {
                    WebSocketManager.INSTANCE.send(this.f47588g, str);
                } else if (jsArrayBuffer != null) {
                    WebSocketManager.INSTANCE.send(this.f47588g, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                }
                C(F, "SocketTask.send");
            } catch (Exception e2) {
                B(F, "SocketTask.send", e2.getMessage());
            }
        } else {
            B(F, "SocketTask.send", "SocketTask.readyState is CLOSED");
        }
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        d.a.i0.a.y.b.a F = F(jsObject);
        if (this.f11772e == WebSocketEventTarget.SocketTaskState.CLOSE) {
            B(F, "SocketTask.close", "SocketTask.readyState is CLOSED");
            return;
        }
        int s = F.s("code", 1000);
        String C = F.C("reason");
        try {
            if (!(s == 1000 || (s >= 3000 && s <= 4999))) {
                B(F, "SocketTask.close", d.f47591a);
                return;
            }
            try {
                WebSocketManager.INSTANCE.close(this.f47588g, s, C);
                C(F, "SocketTask.close");
            } catch (Exception e2) {
                B(F, "SocketTask.close", e2.getMessage());
            }
        } finally {
            this.f47589h.c(this.f47588g);
        }
    }
}
