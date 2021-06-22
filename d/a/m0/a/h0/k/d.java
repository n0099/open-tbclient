package d.a.m0.a.h0.k;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.m0.a.e0.f.d.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.e0;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class d extends d.a.m0.a.l0.a {
    public static final boolean s = k.f46983a;

    /* loaded from: classes3.dex */
    public static class a extends EventTargetImpl {
        @V8JavascriptField
        public d.a.m0.a.l0.b env;

        /* renamed from: d.a.m0.a.h0.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0728a implements Runnable {
            public RunnableC0728a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                e0.a(d.a.m0.a.g1.f.V().getActivity());
            }
        }

        public a(d.a.m0.a.l0.c cVar, String str) {
            super(cVar);
            d.a.m0.a.l0.b bVar = new d.a.m0.a.l0.b();
            this.env = bVar;
            bVar.basePath = str;
        }

        @JavascriptInterface
        public void addMask() {
            d.a.m0.a.e0.d.h("SwanAppV8DaemonEngine", "addMask");
            d.a.m0.a.e0.f.d.e.b();
        }

        @JavascriptInterface
        public String closeConnect(JsObject jsObject) {
            if (d.s) {
                Log.d("SwanAppV8DaemonEngine", "closeConnect params = " + jsObject);
            }
            return g.d(jsObject);
        }

        @JavascriptInterface
        public String connectDevTool(JsObject jsObject) {
            if (d.s) {
                Log.d("SwanAppV8DaemonEngine", "connectDevTool params = " + jsObject);
            }
            return g.e(jsObject);
        }

        @JavascriptInterface
        public boolean freeMaster() {
            d.a.m0.a.e0.d.h("SwanAppV8DaemonEngine", "freeMaster");
            synchronized (d.a.m0.a.l0.d.t) {
                try {
                    try {
                        d.a.m0.a.l0.d.t.notify();
                    } catch (IllegalMonitorStateException e2) {
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
        public String getDevToolsResponse() {
            if (d.s) {
                Log.d("SwanAppV8DaemonEngine", "getDevToolsResponse = " + d.a.m0.a.l0.d.u);
            }
            return d.a.m0.a.l0.d.u;
        }

        @JavascriptInterface
        public void reload() {
            d.a.m0.a.e0.d.h("SwanAppV8DaemonEngine", "reload");
            q0.X(new RunnableC0728a(this));
        }

        @JavascriptInterface
        public void removeMask() {
            d.a.m0.a.e0.d.h("SwanAppV8DaemonEngine", "removeMask");
            d.a.m0.a.e0.f.d.e.c();
        }

        @JavascriptInterface
        public String sendMsgToDevTool(JsObject jsObject) {
            if (d.s) {
                Log.d("SwanAppV8DaemonEngine", "sendMsgToDevTool params = " + jsObject);
            }
            return g.m(jsObject);
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            if (d.s) {
                Log.d("SwanAppV8DaemonEngine", "setDevToolsResponse = " + str);
            }
            d.a.m0.a.l0.d.u = str;
        }

        @JavascriptInterface
        public void shutdown() {
            d.a.m0.a.e0.d.h("SwanAppV8DaemonEngine", "shutdown");
            d.a.m0.a.e0.f.d.f.k().r();
            d.a.m0.a.g1.f.V().exit();
        }
    }

    public d(@NonNull String str, @NonNull d.a.m0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // d.a.m0.a.l0.c, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Override // d.a.m0.a.l0.a
    @NonNull
    public EventTarget w() {
        a aVar = new a(this, this.f47078f.getInitBasePath());
        aVar.env.config = d.a.m0.a.m2.c.a.b();
        return aVar;
    }
}
