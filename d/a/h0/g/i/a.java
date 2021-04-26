package d.a.h0.g.i;

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
import d.a.h0.a.k;
import d.a.h0.g.l.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a implements d.a.h0.g.i.b {
    public static final boolean r = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public V8Engine f46354e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.i.n.b f46355f;

    /* renamed from: g  reason: collision with root package name */
    public final String f46356g;

    /* renamed from: h  reason: collision with root package name */
    public EventTarget f46357h;

    /* renamed from: i  reason: collision with root package name */
    public EventTarget f46358i;
    public Context j;
    public d.a.h0.g.i.l.a k;
    public d.a.h0.g.i.l.b l;
    public d.a.h0.g.i.k.a m;
    public List<JSEvent> n;
    public boolean p;
    public int o = 0;
    public boolean q = false;

    /* renamed from: d.a.h0.g.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0937a implements V8Engine.V8StatusListener {
        public C0937a() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onPause() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onReady() {
            a.this.v0();
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
            a.this.s0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f46361e;

        public c(JSEvent jSEvent) {
            this.f46361e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.q0()) {
                if (a.r) {
                    Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                }
                a.this.n.add(this.f46361e);
                return;
            }
            a.this.f46357h.dispatchEvent(this.f46361e);
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
                a.this.Q(jSEvent);
            }
            a.this.n.clear();
        }
    }

    static {
        d.a.h0.g.i0.f.d.i();
    }

    public a(@NonNull String str, @NonNull d.a.h0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.f46356g = str;
        this.f46355f = bVar;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.f46357h = A();
        this.f46358i = C();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.f46355f.a(), v8ThreadDelegatePolicy, this.f46357h, this.f46358i);
        this.f46354e = v8Engine;
        v8Engine.setExternalV8BinFilesPath(d.a.h0.g.i0.f.d.e());
        this.f46354e.setFileSystemDelegatePolicy(new d.a.h0.g.i.m.d());
        if (bVar.b() != null) {
            this.f46354e.setCodeCacheSetting(bVar.b());
        }
        this.k = new d.a.h0.g.i.l.a(this.f46354e);
        this.m = new d.a.h0.g.i.k.a(this.f46354e);
        this.n = new ArrayList();
        r0();
    }

    @NonNull
    public abstract EventTarget A();

    public void A0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.f46354e.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
    }

    @Override // d.a.h0.g.i.b
    public JsSerializeValue B(byte[] bArr, boolean z) {
        return this.f46354e.deserialize(bArr, z);
    }

    public void B0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.f46354e.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
    }

    @NonNull
    public EventTarget C() {
        return new EventTargetImpl(this);
    }

    public void C0() {
        V8Engine v8Engine = this.f46354e;
        if (v8Engine != null) {
            v8Engine.setMainPackageBasePath(d.a.h0.a.z0.f.V().A());
        }
    }

    public void D0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "setUserAgent: " + str);
        }
        this.f46354e.setUserAgent(str);
    }

    @Override // d.a.h0.g.i.b
    public byte[] L(JsSerializeValue jsSerializeValue, boolean z) {
        return this.f46354e.serialize(jsSerializeValue, z);
    }

    public boolean Q(JSEvent jSEvent) {
        if (r) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchEvent event: ");
            sb.append(jSEvent != null ? jSEvent.type : "");
            Log.d("SwanAppV8Engine", sb.toString());
        }
        if (this.f46357h != null && JSEvent.isValid(jSEvent)) {
            runOnJSThread(new c(jSEvent));
            return true;
        } else if (r) {
            Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
            return false;
        } else {
            return false;
        }
    }

    @Override // d.a.h0.g.i.b
    public void U(String str, String str2) {
        this.k.c(str, str2);
    }

    @Override // d.a.h0.a.e0.k.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (r) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.k.a(obj, str);
    }

    @Override // d.a.h0.g.i.b
    public d.a.h0.g.i.l.b c0() {
        if (this.l == null) {
            this.l = new d.a.h0.g.i.l.b(this.f46354e);
        }
        return this.l;
    }

    @Override // d.a.h0.a.e0.k.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.k.b(str, valueCallback);
    }

    public final void g0() {
        if (r) {
            Log.d("SwanAppV8Engine", "doPendingDispatch start.");
        }
        runOnJSThread(new d());
    }

    @Override // d.a.h0.a.e0.k.a
    public String getContainerId() {
        return this.f46356g;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return null;
    }

    @Override // d.a.h0.g.i.b
    public String getInitBasePath() {
        return this.f46355f.getInitBasePath();
    }

    public void h0() {
        if (this.p) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "finish called.");
        }
        this.p = true;
        t0();
        this.f46354e.destroyEngine(new b());
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        if (p0()) {
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

    public V8Engine i0() {
        return this.f46354e;
    }

    @Override // d.a.h0.a.e0.k.a
    public boolean isDestroyed() {
        return this.p;
    }

    @Override // d.a.h0.a.e0.k.a
    public boolean isWebView() {
        return false;
    }

    public String j0() {
        return "[" + this.f46356g + "] : ";
    }

    public JSONArray k0() {
        V8Engine v8Engine = this.f46354e;
        if (v8Engine == null) {
            return null;
        }
        return v8Engine.getPerformanceJson();
    }

    public final d.a.h0.g.i.d l0() {
        return d.a.h0.g.i.d.i();
    }

    public void m0() {
        if (r) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.f46355f.c(this);
        this.f46354e.startEngine();
        this.f46354e.addStatusHandler(new C0937a());
        if (r) {
            Log.d("SwanAppV8Engine", "initEngine end.");
        }
    }

    public InspectorNativeClient n0(InspectorNativeChannel inspectorNativeChannel) {
        return this.f46354e.initInspector(inspectorNativeChannel);
    }

    @Override // d.a.h0.g.i.b
    public EventTarget o() {
        return this.f46357h;
    }

    public boolean o0() {
        return this.o == 7;
    }

    @Override // d.a.h0.a.e0.k.a
    public void onJSLoaded() {
        d.a.h0.a.e0.w.d.L().g0(true);
    }

    public void onPause() {
        V8Engine v8Engine = this.f46354e;
        if (v8Engine != null) {
            v8Engine.onPause();
        }
        l0().f(this);
        this.o = 4;
    }

    public void onResume() {
        V8Engine v8Engine = this.f46354e;
        if (v8Engine != null) {
            v8Engine.onResume();
        }
        l0().h(this);
        this.o = 5;
    }

    public boolean p0() {
        return this.p;
    }

    @Override // d.a.h0.g.i.b
    public boolean post(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    @Override // d.a.h0.g.i.b, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f46354e.postOnJSThread(runnable);
    }

    public boolean q0() {
        return this.q;
    }

    public final void r0() {
        l0().b(this);
        this.o = 1;
    }

    @Override // d.a.h0.g.i.b, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f46354e.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f46354e.runOnJSThreadDirectly(runnable);
    }

    public final void s0() {
        l0().c(this);
        this.o = 7;
    }

    @Override // d.a.h0.g.i.b
    public void setPreferredFramesPerSecond(short s) {
        this.f46354e.setPreferredFramesPerSecond(s);
    }

    public final void t0() {
        l0().d(this);
        this.o = 6;
    }

    @Override // d.a.h0.g.i.b
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.k.d(jSExceptionType, str);
    }

    public void u(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        this.f46354e.addV8EngineConsole(v8EngineConsole);
    }

    public void u0() {
        l0().e(this);
        this.o = 3;
        this.q = true;
        g0();
    }

    public final void v0() {
        l0().g(this);
        this.o = 2;
        this.f46355f.d(this);
    }

    public void w0(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f46354e.setJSCacheCallback(jSCacheCallback);
    }

    @Override // d.a.h0.g.i.b
    public EventTarget x() {
        return this.f46358i;
    }

    public void x0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f46354e.setCodeCacheSetting(codeCacheSetting);
    }

    @Override // d.a.h0.g.i.b
    public d.a.h0.g.i.k.a y() {
        return this.m;
    }

    public void y0(Context context) {
        this.j = context;
    }

    public void z0() {
        V8Engine v8Engine = this.f46354e;
        if (v8Engine != null) {
            v8Engine.setBdFileRealPath(n.n());
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.f46354e.postOnJSThread(runnable, j);
    }
}
