package d.a.l0.a.h0.k;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.l0.a.e0.f.d.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.e0;
import d.a.l0.a.v2.q0;
/* loaded from: classes2.dex */
public class d extends d.a.l0.a.l0.a {
    public static final boolean s = k.f43199a;

    /* loaded from: classes2.dex */
    public static class a extends EventTargetImpl {
        @V8JavascriptField
        public d.a.l0.a.l0.b env;

        /* renamed from: d.a.l0.a.h0.k.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0669a implements Runnable {
            public RunnableC0669a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                e0.a(d.a.l0.a.g1.f.V().getActivity());
            }
        }

        public a(d.a.l0.a.l0.c cVar, String str) {
            super(cVar);
            d.a.l0.a.l0.b bVar = new d.a.l0.a.l0.b();
            this.env = bVar;
            bVar.basePath = str;
        }

        @JavascriptInterface
        public void addMask() {
            d.a.l0.a.e0.d.h("SwanAppV8DaemonEngine", "addMask");
            d.a.l0.a.e0.f.d.e.b();
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
            d.a.l0.a.e0.d.h("SwanAppV8DaemonEngine", "freeMaster");
            synchronized (d.a.l0.a.l0.d.t) {
                try {
                    try {
                        d.a.l0.a.l0.d.t.notify();
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
                Log.d("SwanAppV8DaemonEngine", "getDevToolsResponse = " + d.a.l0.a.l0.d.u);
            }
            return d.a.l0.a.l0.d.u;
        }

        @JavascriptInterface
        public void reload() {
            d.a.l0.a.e0.d.h("SwanAppV8DaemonEngine", "reload");
            q0.X(new RunnableC0669a(this));
        }

        @JavascriptInterface
        public void removeMask() {
            d.a.l0.a.e0.d.h("SwanAppV8DaemonEngine", "removeMask");
            d.a.l0.a.e0.f.d.e.c();
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
            d.a.l0.a.l0.d.u = str;
        }

        @JavascriptInterface
        public void shutdown() {
            d.a.l0.a.e0.d.h("SwanAppV8DaemonEngine", "shutdown");
            d.a.l0.a.e0.f.d.f.k().r();
            d.a.l0.a.g1.f.V().exit();
        }
    }

    public d(@NonNull String str, @NonNull d.a.l0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
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
