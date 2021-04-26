package d.a.h0.g.w.i;

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
    public String f46846g;

    /* renamed from: h  reason: collision with root package name */
    public b f46847h;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46848a;

        static {
            int[] iArr = new int[WebSocketEventTarget.SocketTaskState.values().length];
            f46848a = iArr;
            try {
                iArr[WebSocketEventTarget.SocketTaskState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46848a[WebSocketEventTarget.SocketTaskState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(b bVar, d.a.h0.g.i.b bVar2) {
        super(bVar2);
        this.f46847h = bVar;
    }

    public final WebSocketRequest B(String str, @NonNull d.a.h0.g.e.d.c cVar) {
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(str);
        builder.setMethod(cVar.B("method"));
        d.a.h0.g.e.d.c w = cVar.w("header");
        if (w != null) {
            for (String str2 : w.k()) {
                if (!TextUtils.isEmpty(str2) && !d.a.h0.a.g1.a.f42545d.contains(str2.toUpperCase())) {
                    builder.addHeader(str2, w.H(str2));
                }
            }
        }
        String[] D = cVar.D(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        ArrayList arrayList = new ArrayList();
        if (D != null && D.length != 0) {
            arrayList.addAll(Arrays.asList(D));
        } else {
            arrayList.add("");
        }
        builder.setProtocols(arrayList);
        builder.setConnectionLostTimeout(0);
        return builder.build();
    }

    public final void C(d.a.h0.g.e.d.c cVar, String str, String str2) {
        String format = String.format("%s:fail %s", str, str2);
        if (WebSocketEventTarget.f12429f) {
            Log.i("WebSocket", format);
        }
        d.a.h0.g.i0.b.a(cVar, false, new f(format));
    }

    public final void D(d.a.h0.g.e.d.c cVar, String str) {
        String format = String.format("%s:ok", str);
        if (WebSocketEventTarget.f12429f) {
            Log.i("WebSocket", format);
        }
        d.a.h0.g.i0.b.a(cVar, true, new f(format));
    }

    public c E(JsObject jsObject) {
        d.a.h0.g.e.d.c G = G(jsObject);
        this.f46846g = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
        int i2 = G.i("url");
        if (i2 != 7) {
            C(G, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", d.a.h0.g.d0.d.d.f(7), d.a.h0.g.d0.d.d.f(i2)));
            return this;
        }
        String B = G.B("url");
        String B2 = G.B("__plugin__");
        if (!this.f46847h.a()) {
            C(G, "connectSocket", "up to max connect count");
            return this;
        } else if (!F(B, B2)) {
            C(G, "connectSocket", String.format("invalid url \"%s\"", B));
            return this;
        } else {
            WebSocketRequest B3 = B(B, G);
            H(jsObject);
            try {
                WebSocketTask connect = WebSocketManager.INSTANCE.connect(B3, this);
                this.f46846g = connect.getTaskId();
                this.f46847h.b(connect);
                d.a.h0.g.i0.b.a(G, true, new g(this.f46846g, String.format("%s:ok", "connectSocket")));
                return this;
            } catch (Exception e2) {
                C(G, "connectSocket", e2.getMessage());
                return this;
            }
        }
    }

    public final boolean F(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (d.a.h0.a.m1.a.a.o()) {
            return true;
        }
        return str.startsWith("wss://") && d.a.h0.a.s1.a.b.c("socket", str, str2) == 0;
    }

    @NonNull
    public final d.a.h0.g.e.d.c G(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        return F == null ? new d.a.h0.g.e.d.c() : F;
    }

    public final void H(JsObject jsObject) {
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
        if (this.f46847h == null || jSONObject == null) {
            return;
        }
        this.f46847h.c(jSONObject.optString("taskID"));
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        super.onError(th, jSONObject);
        if (this.f46847h == null || jSONObject == null) {
            return;
        }
        this.f46847h.c(jSONObject.optString("taskID"));
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer jsArrayBuffer;
        d.a.h0.g.e.d.c G = G(jsObject);
        int i2 = a.f46848a[this.f12430e.ordinal()];
        if (i2 == 1) {
            C(G, "SocketTask.send", "SocketTask.readyState is not OPEN");
        } else if (i2 != 2) {
            int i3 = G.i("data");
            String str = null;
            if (i3 == 7) {
                str = G.C("data", null);
                jsArrayBuffer = null;
            } else if (i3 != 10) {
                C(G, "SocketTask.send", "invalid data type");
                return;
            } else {
                jsArrayBuffer = G.t("data", null);
            }
            if (str == null && jsArrayBuffer == null) {
                C(G, "SocketTask.send", "invalid data type");
                return;
            }
            try {
                if (str != null) {
                    WebSocketManager.INSTANCE.send(this.f46846g, str);
                } else if (jsArrayBuffer != null) {
                    WebSocketManager.INSTANCE.send(this.f46846g, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                }
                D(G, "SocketTask.send");
            } catch (Exception e2) {
                C(G, "SocketTask.send", e2.getMessage());
            }
        } else {
            C(G, "SocketTask.send", "SocketTask.readyState is CLOSED");
        }
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        d.a.h0.g.e.d.c G = G(jsObject);
        if (this.f12430e == WebSocketEventTarget.SocketTaskState.CLOSE) {
            C(G, "SocketTask.close", "SocketTask.readyState is CLOSED");
            return;
        }
        int s = G.s("code", 1000);
        String B = G.B("reason");
        try {
            if (!(s == 1000 || (s >= 3000 && s <= 4999))) {
                C(G, "SocketTask.close", d.f46849a);
                return;
            }
            try {
                WebSocketManager.INSTANCE.close(this.f46846g, s, B);
                D(G, "SocketTask.close");
            } catch (Exception e2) {
                C(G, "SocketTask.close", e2.getMessage());
            }
        } finally {
            this.f46847h.c(this.f46846g);
        }
    }
}
