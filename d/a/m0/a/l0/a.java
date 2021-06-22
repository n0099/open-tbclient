package d.a.m0.a.l0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.m0.a.k;
import d.a.m0.a.p.b.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a implements d.a.m0.a.l0.c {
    public static final boolean r = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public V8Engine f47077e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.l0.n.b f47078f;

    /* renamed from: g  reason: collision with root package name */
    public final String f47079g;

    /* renamed from: h  reason: collision with root package name */
    public EventTarget f47080h;

    /* renamed from: i  reason: collision with root package name */
    public EventTarget f47081i;
    public Context j;
    public d.a.m0.a.l0.l.a k;
    public d.a.m0.a.l0.l.b l;
    public d.a.m0.a.l0.k.a m;
    public List<JSEvent> n;
    public boolean p;
    public int o = 0;
    public boolean q = false;

    /* renamed from: d.a.m0.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0790a implements V8Engine.V8StatusListener {
        public C0790a() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onPause() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onReady() {
            a.this.z0();
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
            a.this.w0();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f47084e;

        public c(JSEvent jSEvent) {
            this.f47084e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.u0()) {
                if (a.r) {
                    Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                }
                a.this.n.add(this.f47084e);
                return;
            }
            a.this.f47080h.dispatchEvent(this.f47084e);
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
                a.this.F(jSEvent);
            }
            a.this.n.clear();
        }
    }

    static {
        d.a.m0.a.h2.d.c();
    }

    public a(@NonNull String str, @NonNull d.a.m0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        this.f47079g = str;
        this.f47078f = bVar;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.f47080h = w();
        this.f47081i = D();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.f47078f.a(), v8ThreadDelegatePolicy, this.f47080h, this.f47081i);
        this.f47077e = v8Engine;
        if (v8ThreadDelegatePolicy instanceof d.a.m0.a.h0.l.f) {
            ((d.a.m0.a.h0.l.f) v8ThreadDelegatePolicy).d(v8Engine);
        }
        this.f47077e.setExternalV8BinFilesPath(d.a.m0.a.h2.d.a());
        this.f47077e.setFileSystemDelegatePolicy(new d.a.m0.a.l0.m.d());
        d.a.m0.a.u.e.j.d.c(this.f47077e);
        if (bVar.b() != null) {
            this.f47077e.setCodeCacheSetting(bVar.b());
        }
        this.k = new d.a.m0.a.l0.l.a(this.f47077e);
        this.m = new d.a.m0.a.l0.k.a(this.f47077e);
        this.n = new ArrayList();
        v0();
    }

    @Override // d.a.m0.a.l0.c
    public d.a.m0.a.l0.k.a A() {
        return this.m;
    }

    public void A0() {
        r(new d.a.m0.a.l0.k.b(this));
        G0(new d.a.m0.a.l0.k.c(this));
    }

    public void B0(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.f47077e.setJSCacheCallback(jSCacheCallback);
    }

    @Override // d.a.m0.a.l0.c
    public JsSerializeValue C(byte[] bArr, boolean z) {
        return this.f47077e.deserialize(bArr, z);
    }

    public void C0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.f47077e.setCodeCacheSetting(codeCacheSetting);
    }

    @NonNull
    public EventTarget D() {
        return new EventTargetImpl(this);
    }

    public void D0(Context context) {
        this.j = context;
    }

    public void E0() {
        if (this.f47077e != null) {
            l m = d.a.m0.a.c1.b.m();
            this.f47077e.setBdFileRealPath(m != null ? m.e() : null);
        }
    }

    public boolean F(JSEvent jSEvent) {
        if (r) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchEvent event: ");
            sb.append(jSEvent != null ? jSEvent.type : "");
            Log.d("SwanAppV8Engine", sb.toString());
        }
        if (this.f47080h != null && JSEvent.isValid(jSEvent)) {
            runOnJSThread(new c(jSEvent));
            return true;
        } else if (r) {
            Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
            return false;
        } else {
            return false;
        }
    }

    public void F0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        this.f47077e.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
    }

    public void G0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        this.f47077e.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
    }

    public void H0() {
        V8Engine v8Engine = this.f47077e;
        if (v8Engine != null) {
            v8Engine.setMainPackageBasePath(d.a.m0.a.g1.f.V().A());
        }
    }

    public void I0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "setUserAgent: " + str);
        }
        this.f47077e.setUserAgent(str);
    }

    @Override // d.a.m0.a.l0.c
    public byte[] N(JsSerializeValue jsSerializeValue, boolean z) {
        return this.f47077e.serialize(jsSerializeValue, z);
    }

    public final void T() {
        if (r) {
            Log.d("SwanAppV8Engine", "doPendingDispatch start.");
        }
        runOnJSThread(new d());
    }

    @Override // d.a.m0.a.h0.f.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        if (r) {
            Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
        }
        this.k.a(obj, str);
    }

    @Override // d.a.m0.a.l0.c
    public void b0(String str, String str2) {
        this.k.c(str, str2);
    }

    @Override // d.a.m0.a.l0.c
    public d.a.m0.a.l0.l.b e0() {
        if (this.l == null) {
            this.l = new d.a.m0.a.l0.l.b(this.f47077e);
        }
        return this.l;
    }

    @Override // d.a.m0.a.h0.f.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.k.b(str, valueCallback);
    }

    @Override // d.a.m0.a.h0.f.a
    public String getContainerId() {
        return this.f47079g;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return null;
    }

    @Override // d.a.m0.a.l0.c
    public String getInitBasePath() {
        return this.f47078f.getInitBasePath();
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        if (t0()) {
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

    @Override // d.a.m0.a.h0.f.a
    public boolean isDestroyed() {
        return this.p;
    }

    @Override // d.a.m0.a.h0.f.a
    public boolean isWebView() {
        return false;
    }

    public void k0() {
        if (this.p) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "finish called.");
        }
        this.p = true;
        x0();
        this.f47077e.destroyEngine(new b());
    }

    public V8Engine l0() {
        return this.f47077e;
    }

    public String m0() {
        return PreferencesUtil.LEFT_MOUNT + this.f47079g + "] : ";
    }

    public NetRequest n0() {
        return this.f47077e.getNetRequest();
    }

    public JSONArray o0() {
        V8Engine v8Engine = this.f47077e;
        if (v8Engine == null) {
            return null;
        }
        return v8Engine.getPerformanceJson();
    }

    @Override // d.a.m0.a.h0.f.a
    public void onJSLoaded() {
        d.a.m0.a.h0.u.g.N().m0(true);
    }

    public void onPause() {
        V8Engine v8Engine = this.f47077e;
        if (v8Engine != null) {
            v8Engine.onPause();
        }
        p0().f(this);
        this.o = 4;
    }

    public void onResume() {
        V8Engine v8Engine = this.f47077e;
        if (v8Engine != null) {
            v8Engine.onResume();
        }
        p0().h(this);
        this.o = 5;
    }

    @Override // d.a.m0.a.l0.c
    public EventTarget p() {
        return this.f47080h;
    }

    public final e p0() {
        return e.i();
    }

    @Override // d.a.m0.a.l0.c, d.a.m0.a.h0.f.a
    public boolean post(Runnable runnable) {
        runOnJSThread(runnable);
        return true;
    }

    @Override // d.a.m0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f47077e.postOnJSThread(runnable);
    }

    public void q0() {
        A0();
        if (r) {
            Log.d("SwanAppV8Engine", "initEngine start.");
        }
        this.f47078f.d(this);
        this.f47077e.startEngine();
        this.f47077e.addStatusHandler(new C0790a());
        if (r) {
            Log.d("SwanAppV8Engine", "initEngine end.");
        }
    }

    public void r(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        this.f47077e.addV8EngineConsole(v8EngineConsole);
    }

    public InspectorNativeClient r0(InspectorNativeChannel inspectorNativeChannel) {
        return this.f47077e.initInspector(inspectorNativeChannel);
    }

    @Override // d.a.m0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f47077e.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f47077e.runOnJSThreadDirectly(runnable);
    }

    public boolean s0() {
        return this.o == 7;
    }

    @Override // d.a.m0.a.l0.c
    public void setPreferredFramesPerSecond(short s) {
        this.f47077e.setPreferredFramesPerSecond(s);
    }

    public boolean t0() {
        return this.p;
    }

    @Override // d.a.m0.a.l0.c
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        this.k.d(jSExceptionType, str);
    }

    public boolean u0() {
        return this.q;
    }

    public final void v0() {
        p0().b(this);
        this.o = 1;
    }

    @NonNull
    public abstract EventTarget w();

    public final void w0() {
        p0().c(this);
        this.o = 7;
    }

    public final void x0() {
        p0().d(this);
        this.o = 6;
    }

    public void y0() {
        p0().e(this);
        this.o = 3;
        this.q = true;
        T();
    }

    @Override // d.a.m0.a.l0.c
    public EventTarget z() {
        return this.f47081i;
    }

    public final void z0() {
        p0().g(this);
        this.o = 2;
        this.f47078f.c(this);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        this.f47077e.postOnJSThread(runnable, j);
    }
}
