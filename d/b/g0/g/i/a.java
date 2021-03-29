package d.b.g0.g.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.b.g0.a.k;
import d.b.g0.g.l.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a implements d.b.g0.g.i.b {
    public static final boolean r = k.f45051a;

    /* renamed from: e  reason: collision with root package name */
    public V8Engine f48160e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.i.n.b f48161f;

    /* renamed from: g  reason: collision with root package name */
    public final String f48162g;

    /* renamed from: h  reason: collision with root package name */
    public EventTarget f48163h;
    public EventTarget i;
    public Context j;
    public d.b.g0.g.i.l.a k;
    public d.b.g0.g.i.l.b l;
    public d.b.g0.g.i.k.a m;
    public List<JSEvent> n;
    public boolean p;
    public int o = 0;
    public boolean q = false;

    /* renamed from: d.b.g0.g.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0966a implements V8Engine.V8StatusListener {
        public C0966a() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onPause() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onReady() {
            a.this.u0();
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onResume() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements V8ExecuteCallback {
        public b() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
        public void onExecuted() {
            if (a.r) {
                Log.d("SwanAppV8Engine", "finish onExecuted.");
            }
            a.this.r0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f48166e;

        public c(JSEvent jSEvent) {
            this.f48166e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.p0()) {
                if (a.r) {
                    Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                }
                a.this.n.add(this.f48166e);
                return;
            }
            a.this.f48163h.dispatchEvent(this.f48166e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (JSEvent jSEvent : a.this.n) {
                if (a.r) {
                    Log.d("SwanAppV8Engine", "doPendingDispatch event type: " + jSEvent.type);
                }
                a.this.c0(jSEvent);
            }
            a.this.n.clear();
        }
    }

    static {
        d.b.g0.g.i0.f.d.i();
    }

    public a(@NonNull String str, @NonNull d.b.g0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.f48162g = str;
        this.f48161f = bVar;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.f48163h = G();
        this.i = M();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.f48161f.a(), v8ThreadDelegatePolicy, this.f48163h, this.i);
        this.f48160e = v8Engine;
        v8Engine.setExternalV8BinFilesPath(d.b.g0.g.i0.f.d.e());
        this.f48160e.setFileSystemDelegatePolicy(new d.b.g0.g.i.m.d());
        if (bVar.b() != null) {
            this.f48160e.setCodeCacheSetting(bVar.b());
        }
        this.k = new d.b.g0.g.i.l.a(this.f48160e);
        this.m = new d.b.g0.g.i.k.a(this.f48160e);
        this.n = new ArrayList();
        q0();
    }

    public void A0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.f48160e.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
    }

    public void B0() {
        V8Engine v8Engine = this.f48160e;
        if (v8Engine != null) {
            v8Engine.setMainPackageBasePath(d.b.g0.a.z0.f.V().h());
        }
    }

    public void C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "setUserAgent: " + str);
        }
        this.f48160e.setUserAgent(str);
    }

    @NonNull
    public abstract EventTarget G();

    @NonNull
    public EventTarget M() {
        return new EventTargetImpl(this);
    }

    @Override // d.b.g0.g.i.b
    public void N(String str, String str2) {
        this.k.c(str, str2);
    }

    @Override // d.b.g0.g.i.b
    public d.b.g0.g.i.l.b V() {
        if (this.l == null) {
            this.l = new d.b.g0.g.i.l.b(this.f48160e);
        }
        return this.l;
    }

    @Override // d.b.g0.g.i.b
    public EventTarget Z() {
        return this.i;
    }

    @Override // d.b.g0.g.i.b
    public d.b.g0.g.i.k.a a0() {
        return this.m;
    }

    @Override // d.b.g0.a.e0.k.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (r) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.k.a(obj, str);
    }

    public boolean c0(JSEvent jSEvent) {
        if (r) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchEvent event: ");
            sb.append(jSEvent != null ? jSEvent.type : "");
            Log.d("SwanAppV8Engine", sb.toString());
        }
        if (this.f48163h != null && JSEvent.isValid(jSEvent)) {
            runOnJSThread(new c(jSEvent));
            return true;
        } else if (r) {
            Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
            return false;
        } else {
            return false;
        }
    }

    @Override // d.b.g0.g.i.b
    public JsSerializeValue d0(byte[] bArr, boolean z) {
        return this.f48160e.deserialize(bArr, z);
    }

    public final void e0() {
        if (r) {
            Log.d("SwanAppV8Engine", "doPendingDispatch start.");
        }
        runOnJSThread(new d());
    }

    @Override // d.b.g0.a.e0.k.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.k.b(str, valueCallback);
    }

    public void g0() {
        if (this.p) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "finish called.");
        }
        this.p = true;
        s0();
        this.f48160e.destroyEngine(new b());
    }

    @Override // d.b.g0.a.e0.k.a
    public String getContainerId() {
        return this.f48162g;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return null;
    }

    @Override // d.b.g0.g.i.b
    public String getInitBasePath() {
        return this.f48161f.getInitBasePath();
    }

    public V8Engine h0() {
        return this.f48160e;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        if (o0()) {
            if (r) {
                Log.e("SwanAppV8Engine", Log.getStackTraceString(new Exception("engine isFinishing.")));
                return;
            }
            return;
        }
        String quote = TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2);
        evaluateJavascript(str + "(" + quote + ");", null);
        if (r) {
            Log.d("SwanAppV8Engine", "handleSchemeDispatchCallback callback " + str + " ,params: " + str2);
        }
    }

    public String i0() {
        return "[" + this.f48162g + "] : ";
    }

    @Override // d.b.g0.a.e0.k.a
    public boolean isDestroyed() {
        return this.p;
    }

    @Override // d.b.g0.a.e0.k.a
    public boolean isWebView() {
        return false;
    }

    public JSONArray j0() {
        V8Engine v8Engine = this.f48160e;
        if (v8Engine == null) {
            return null;
        }
        return v8Engine.getPerformanceJson();
    }

    public final d.b.g0.g.i.d k0() {
        return d.b.g0.g.i.d.i();
    }

    public void l0() {
        if (r) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.f48161f.d(this);
        this.f48160e.startEngine();
        this.f48160e.addStatusHandler(new C0966a());
        if (r) {
            Log.d("SwanAppV8Engine", "initEngine end.");
        }
    }

    public InspectorNativeClient m0(InspectorNativeChannel inspectorNativeChannel) {
        return this.f48160e.initInspector(inspectorNativeChannel);
    }

    public boolean n0() {
        return this.o == 7;
    }

    public boolean o0() {
        return this.p;
    }

    @Override // d.b.g0.a.e0.k.a
    public void onJSLoaded() {
        d.b.g0.a.e0.w.d.L().g0(true);
    }

    public void onPause() {
        V8Engine v8Engine = this.f48160e;
        if (v8Engine != null) {
            v8Engine.onPause();
        }
        k0().f(this);
        this.o = 4;
    }

    public void onResume() {
        V8Engine v8Engine = this.f48160e;
        if (v8Engine != null) {
            v8Engine.onResume();
        }
        k0().h(this);
        this.o = 5;
    }

    public boolean p0() {
        return this.q;
    }

    @Override // d.b.g0.g.i.b
    public boolean post(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    @Override // d.b.g0.g.i.b, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f48160e.postOnJSThread(runnable);
    }

    public final void q0() {
        k0().b(this);
        this.o = 1;
    }

    public final void r0() {
        k0().c(this);
        this.o = 7;
    }

    @Override // d.b.g0.g.i.b, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f48160e.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f48160e.runOnJSThreadDirectly(runnable);
    }

    public final void s0() {
        k0().d(this);
        this.o = 6;
    }

    @Override // d.b.g0.g.i.b
    public void setPreferredFramesPerSecond(short s) {
        this.f48160e.setPreferredFramesPerSecond(s);
    }

    @Override // d.b.g0.g.i.b
    public EventTarget t() {
        return this.f48163h;
    }

    public void t0() {
        k0().e(this);
        this.o = 3;
        this.q = true;
        e0();
    }

    @Override // d.b.g0.g.i.b
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.k.d(jSExceptionType, str);
    }

    public void u(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        this.f48160e.addV8EngineConsole(v8EngineConsole);
    }

    public final void u0() {
        k0().g(this);
        this.o = 2;
        this.f48161f.c(this);
    }

    public void v0(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f48160e.setJSCacheCallback(jSCacheCallback);
    }

    public void w0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f48160e.setCodeCacheSetting(codeCacheSetting);
    }

    public void x0(Context context) {
        this.j = context;
    }

    @Override // d.b.g0.g.i.b
    public byte[] y(JsSerializeValue jsSerializeValue, boolean z) {
        return this.f48160e.serialize(jsSerializeValue, z);
    }

    public void y0() {
        V8Engine v8Engine = this.f48160e;
        if (v8Engine != null) {
            v8Engine.setBdFileRealPath(n.n());
        }
    }

    public void z0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.f48160e.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.f48160e.postOnJSThread(runnable, j);
    }
}
