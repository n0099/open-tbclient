package d.a.l0.a.e0.f.d;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import d.a.l0.a.k;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41422a = k.f43199a;

    public static String d(JsObject jsObject) {
        if (jsObject == null) {
            return f("params is null");
        }
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null) {
            return f("paramsMap is null");
        }
        String C = G.C("taskId");
        int r = G.r("code");
        String C2 = G.C("reason");
        if (TextUtils.isEmpty(C)) {
            return f("taskId is empty");
        }
        try {
            WebSocketManager.INSTANCE.close(C, r, C2);
        } catch (Exception e2) {
            if (f41422a) {
                e2.printStackTrace();
            }
        }
        return i(0, "close success", null);
    }

    public static String e(JsObject jsObject) {
        if (jsObject == null) {
            return f("params is null");
        }
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null) {
            return f("paramsMap is null");
        }
        String C = G.C("url");
        if (TextUtils.isEmpty(C)) {
            return f("url is null");
        }
        d.a.l0.a.y.b.a x = G.x("header");
        String[] E = G.E(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(C);
        builder.setHeaders(k(x));
        if (E != null && E.length > 0) {
            builder.setProtocols(Arrays.asList(E));
        }
        WebSocketTask connect = WebSocketManager.INSTANCE.connect(builder.build(), l(G));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taskId", connect.getTaskId());
        } catch (JSONException e2) {
            if (f41422a) {
                e2.printStackTrace();
            }
        }
        return i(0, "connect success", jSONObject);
    }

    public static String f(String str) {
        return i(202, str, null);
    }

    public static String g(Object obj) {
        JSONObject jSONObject = new JSONObject();
        if (obj != null) {
            try {
                jSONObject.put("errMsg", String.valueOf(obj));
            } catch (Exception e2) {
                if (f41422a) {
                    e2.printStackTrace();
                }
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (f41422a) {
            Log.d("WebSocketHelper", "getOnErrorParam - " + jSONObject2);
        }
        return jSONObject2;
    }

    public static String h(Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof String) {
                jSONObject.put("dataType", "string");
                jSONObject.put("data", obj);
            } else if (obj instanceof ByteBuffer) {
                jSONObject.put("dataType", "arrayBuffer");
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                jSONObject.put("data", Base64.encodeToString(bArr, 2));
            }
        } catch (Exception e2) {
            if (f41422a) {
                e2.printStackTrace();
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (f41422a) {
            Log.d("WebSocketHelper", "getOnMessageParam - " + jSONObject2);
        }
        return jSONObject2;
    }

    public static String i(int i2, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("reason", i2);
            jSONObject2.put("message", str);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
        } catch (JSONException e2) {
            if (f41422a) {
                e2.printStackTrace();
            }
        }
        String jSONObject3 = jSONObject2.toString();
        if (f41422a) {
            Log.d("WebSocketHelper", "getResultMsg - " + jSONObject3);
        }
        return jSONObject3;
    }

    public static JsFunction j(@NonNull d.a.l0.a.y.b.a aVar, @NonNull String str, boolean z) {
        JsFunction v = aVar.v(str);
        if (v != null) {
            v.setReleaseMode(z);
        }
        return v;
    }

    public static Map<String, String> k(d.a.l0.a.y.b.a aVar) {
        HashMap hashMap = new HashMap();
        if (aVar != null) {
            for (String str : aVar.k()) {
                hashMap.put(str, aVar.C(str));
            }
        }
        return hashMap;
    }

    public static IWebSocketListener l(@NonNull d.a.l0.a.y.b.a aVar) {
        return new a(j(aVar, "onOpen", true), j(aVar, "onMessage", false), j(aVar, "onClose", true), j(aVar, "onError", false));
    }

    public static String m(JsObject jsObject) {
        if (jsObject == null) {
            return f("params is null");
        }
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null) {
            return f("paramsMap is null");
        }
        String C = G.C("taskId");
        String C2 = G.C("data");
        if (TextUtils.isEmpty(C)) {
            return f("taskId is empty");
        }
        try {
            WebSocketManager.INSTANCE.send(C, C2);
        } catch (Exception e2) {
            if (f41422a) {
                e2.printStackTrace();
            }
        }
        return i(0, "send success", null);
    }

    /* loaded from: classes2.dex */
    public static class a implements IWebSocketListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JsFunction f41423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JsFunction f41424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JsFunction f41425g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JsFunction f41426h;

        public a(JsFunction jsFunction, JsFunction jsFunction2, JsFunction jsFunction3, JsFunction jsFunction4) {
            this.f41423e = jsFunction;
            this.f41424f = jsFunction2;
            this.f41425g = jsFunction3;
            this.f41426h = jsFunction4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            if (g.f41422a) {
                Log.d("WebSocketHelper", "onClose - " + jSONObject2);
            }
            JsFunction jsFunction = this.f41425g;
            if (jsFunction != null) {
                jsFunction.call(jSONObject2);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            if (g.f41422a) {
                Log.d("WebSocketHelper", "onError throwable - " + th);
                Log.d("WebSocketHelper", "onError jsonObject - " + jSONObject2);
            }
            JsFunction jsFunction = this.f41426h;
            if (jsFunction != null) {
                jsFunction.call(g.g(th));
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            JsFunction jsFunction = this.f41424f;
            if (jsFunction != null) {
                jsFunction.call(g.h(str));
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> map) {
            JsFunction jsFunction = this.f41423e;
            if (jsFunction != null) {
                jsFunction.call();
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            JsFunction jsFunction = this.f41424f;
            if (jsFunction != null) {
                jsFunction.call(g.h(byteBuffer));
            }
        }
    }
}
