package d.a.l0.a.l0;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.l0.a.l0.a {
    public static final boolean s = k.f43199a;
    public static final Object t = new Object();
    public static String u = "";

    /* loaded from: classes2.dex */
    public static class a extends EventTargetImpl {

        /* renamed from: e  reason: collision with root package name */
        public c f43303e;
        @V8JavascriptField
        public b env;

        /* renamed from: f  reason: collision with root package name */
        public d.a.l0.a.r0.e f43304f;

        public a(c cVar, String str) {
            super(cVar);
            this.f43303e = cVar;
            b bVar = new b();
            this.env = bVar;
            bVar.basePath = str;
        }

        @JavascriptInterface
        public String getAPIs(int i2) {
            if (d.s) {
                String d2 = d.a.l0.a.u1.a.a.p() ? d.a.l0.a.v2.j.d(i2, true) : "";
                Log.d("SwanAppV8Engine", "getAPIs res:" + d2);
                return d2;
            }
            String d3 = d.a.l0.a.v2.j.d(i2, true);
            if (d.s) {
                Log.d("SwanAppV8Engine", "getAPIs description:" + d3);
            }
            if (TextUtils.isEmpty(d3)) {
                if (!d.s) {
                    d.a.l0.a.v2.a.c(d.a.l0.a.v2.j.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i2), d3, Boolean.TRUE)));
                } else {
                    d.a.l0.a.v2.j.g();
                    throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i2), d3));
                }
            } else {
                d.a.l0.a.v2.a.d();
            }
            return d3;
        }

        @JavascriptInterface
        public String getDevToolsResponse() {
            if (d.s) {
                Log.d("SwanAppV8Engine", "getDevToolsResponse = " + d.u);
            }
            return d.u;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            return d.a.l0.a.d1.b.b.a(this.f43303e);
        }

        @JavascriptInterface
        public d.a.l0.a.r0.e getFileSystemManager() {
            if (this.f43304f == null) {
                this.f43304f = new d.a.l0.a.r0.e((d.a.l0.a.l0.a) this.f43303e);
            }
            return this.f43304f;
        }

        @JavascriptInterface
        public JSONObject getNACanIUseMap() {
            JSONObject jSONObject = new JSONObject();
            d.K0(jSONObject);
            d.a.l0.a.e0.d.h("SwanAppV8Engine", "getNACanIUseMap - " + jSONObject.toString());
            return jSONObject;
        }

        @JavascriptInterface
        public boolean lockMaster() {
            d.a.l0.a.e0.d.h("SwanAppV8Engine", "lockMaster");
            synchronized (d.t) {
                try {
                    try {
                        d.t.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            if (d.s) {
                Log.d("SwanAppV8Engine", "setDevToolsResponse = " + str);
            }
            d.u = str;
        }
    }

    public d(@NonNull String str, @NonNull d.a.l0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
    }

    public static void K0(@NonNull JSONObject jSONObject) {
        if (d.a.l0.a.l2.b.l().o()) {
            try {
                jSONObject.put("swanCookie", new JSONObject());
            } catch (JSONException e2) {
                if (s) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // d.a.l0.a.l0.c, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Override // d.a.l0.a.l0.a
    @NonNull
    public EventTarget w() {
        a aVar = new a(this, this.f43294f.getInitBasePath());
        aVar.env.config = d.a.l0.a.m2.c.a.b();
        return aVar;
    }
}
