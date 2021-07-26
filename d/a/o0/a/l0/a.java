package d.a.o0.a.l0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.p.b.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a implements d.a.o0.a.l0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public V8Engine f46429e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.a.l0.n.b f46430f;

    /* renamed from: g  reason: collision with root package name */
    public final String f46431g;

    /* renamed from: h  reason: collision with root package name */
    public EventTarget f46432h;

    /* renamed from: i  reason: collision with root package name */
    public EventTarget f46433i;
    public Context j;
    public d.a.o0.a.l0.l.a k;
    public d.a.o0.a.l0.l.b l;
    public d.a.o0.a.l0.k.a m;
    public List<JSEvent> n;
    public int o;
    public boolean p;
    public boolean q;

    /* renamed from: d.a.o0.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0808a implements V8Engine.V8StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46434a;

        public C0808a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46434a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f46434a.z0();
            }
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements V8ExecuteCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46435a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46435a = aVar;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
        public void onExecuted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a.r) {
                    Log.d("SwanAppV8Engine", "finish onExecuted.");
                }
                this.f46435a.w0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f46436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46437f;

        public c(a aVar, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46437f = aVar;
            this.f46436e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f46437f.u0()) {
                    if (a.r) {
                        Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                    }
                    this.f46437f.n.add(this.f46436e);
                    return;
                }
                this.f46437f.f46432h.dispatchEvent(this.f46436e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46438e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46438e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (JSEvent jSEvent : this.f46438e.n) {
                    if (a.r) {
                        Log.d("SwanAppV8Engine", "doPendingDispatch event type: " + jSEvent.type);
                    }
                    this.f46438e.F(jSEvent);
                }
                this.f46438e.n.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(513655950, "Ld/a/o0/a/l0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(513655950, "Ld/a/o0/a/l0/a;");
                return;
            }
        }
        r = k.f46335a;
        d.a.o0.a.h2.d.c();
    }

    public a(@NonNull String str, @NonNull d.a.o0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.q = false;
        this.f46431g = str;
        this.f46430f = bVar;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.f46432h = w();
        this.f46433i = D();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.f46430f.a(), v8ThreadDelegatePolicy, this.f46432h, this.f46433i);
        this.f46429e = v8Engine;
        if (v8ThreadDelegatePolicy instanceof d.a.o0.a.h0.l.f) {
            ((d.a.o0.a.h0.l.f) v8ThreadDelegatePolicy).d(v8Engine);
        }
        this.f46429e.setExternalV8BinFilesPath(d.a.o0.a.h2.d.a());
        this.f46429e.setFileSystemDelegatePolicy(new d.a.o0.a.l0.m.d());
        d.a.o0.a.u.e.j.d.c(this.f46429e);
        if (bVar.b() != null) {
            this.f46429e.setCodeCacheSetting(bVar.b());
        }
        this.k = new d.a.o0.a.l0.l.a(this.f46429e);
        this.m = new d.a.o0.a.l0.k.a(this.f46429e);
        this.n = new ArrayList();
        v0();
    }

    @Override // d.a.o0.a.l0.c
    public d.a.o0.a.l0.k.a A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (d.a.o0.a.l0.k.a) invokeV.objValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r(new d.a.o0.a.l0.k.b(this));
            G0(new d.a.o0.a.l0.k.c(this));
        }
    }

    public void B0(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSCacheCallback) == null) {
            this.f46429e.setJSCacheCallback(jSCacheCallback);
        }
    }

    @Override // d.a.o0.a.l0.c
    public JsSerializeValue C(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, bArr, z)) == null) ? this.f46429e.deserialize(bArr, z) : (JsSerializeValue) invokeLZ.objValue;
    }

    public void C0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, codeCacheSetting) == null) {
            this.f46429e.setCodeCacheSetting(codeCacheSetting);
        }
    }

    @NonNull
    public EventTarget D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new EventTargetImpl(this) : (EventTarget) invokeV.objValue;
    }

    public void D0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.j = context;
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f46429e == null) {
            return;
        }
        l m = d.a.o0.a.c1.b.m();
        this.f46429e.setBdFileRealPath(m != null ? m.e() : null);
    }

    public boolean F(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSEvent)) == null) {
            if (r) {
                StringBuilder sb = new StringBuilder();
                sb.append("dispatchEvent event: ");
                sb.append(jSEvent != null ? jSEvent.type : "");
                Log.d("SwanAppV8Engine", sb.toString());
            }
            if (this.f46432h != null && JSEvent.isValid(jSEvent)) {
                runOnJSThread(new c(this, jSEvent));
                return true;
            } else if (r) {
                Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void F0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v8FileSystemDelegatePolicy) == null) {
            this.f46429e.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
        }
    }

    public void G0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, javaScriptExceptionDelegate) == null) {
            this.f46429e.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
        }
    }

    public void H0() {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (v8Engine = this.f46429e) == null) {
            return;
        }
        v8Engine.setMainPackageBasePath(d.a.o0.a.g1.f.V().A());
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "setUserAgent: " + str);
        }
        this.f46429e.setUserAgent(str);
    }

    @Override // d.a.o0.a.l0.c
    public byte[] N(JsSerializeValue jsSerializeValue, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, jsSerializeValue, z)) == null) ? this.f46429e.serialize(jsSerializeValue, z) : (byte[]) invokeLZ.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (r) {
                Log.d("SwanAppV8Engine", "doPendingDispatch start.");
            }
            runOnJSThread(new d(this));
        }
    }

    @Override // d.a.o0.a.h0.f.a
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, obj, str) == null) {
            if (r) {
                Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
            }
            this.k.a(obj, str);
        }
    }

    @Override // d.a.o0.a.l0.c
    public void b0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.k.c(str, str2);
        }
    }

    @Override // d.a.o0.a.l0.c
    public d.a.o0.a.l0.l.b e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.l == null) {
                this.l = new d.a.o0.a.l0.l.b(this.f46429e);
            }
            return this.l;
        }
        return (d.a.o0.a.l0.l.b) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.f.a
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, valueCallback) == null) {
            this.k.b(str, valueCallback);
        }
    }

    @Override // d.a.o0.a.h0.f.a
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f46431g : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.l0.c
    public String getInitBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f46430f.getInitBasePath() : (String) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.p) {
            return;
        }
        if (r) {
            Log.d("SwanAppV8Engine", "finish called.");
        }
        this.p = true;
        x0();
        this.f46429e.destroyEngine(new b(this));
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) {
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
    }

    @Override // d.a.o0.a.h0.f.a
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // d.a.o0.a.h0.f.a
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public V8Engine l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f46429e : (V8Engine) invokeV.objValue;
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.f46431g + "] : ";
        }
        return (String) invokeV.objValue;
    }

    public NetRequest n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f46429e.getNetRequest() : (NetRequest) invokeV.objValue;
    }

    public JSONArray o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            V8Engine v8Engine = this.f46429e;
            if (v8Engine == null) {
                return null;
            }
            return v8Engine.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.f.a
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            d.a.o0.a.h0.u.g.N().m0(true);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            V8Engine v8Engine = this.f46429e;
            if (v8Engine != null) {
                v8Engine.onPause();
            }
            p0().f(this);
            this.o = 4;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            V8Engine v8Engine = this.f46429e;
            if (v8Engine != null) {
                v8Engine.onResume();
            }
            p0().h(this);
            this.o = 5;
        }
    }

    @Override // d.a.o0.a.l0.c
    public EventTarget p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f46432h : (EventTarget) invokeV.objValue;
    }

    public final e p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? e.i() : (e) invokeV.objValue;
    }

    @Override // d.a.o0.a.l0.c, d.a.o0.a.h0.f.a
    public boolean post(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, runnable)) == null) {
            runOnJSThread(runnable);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.o0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f46429e.postOnJSThread(runnable);
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            A0();
            if (r) {
                Log.d("SwanAppV8Engine", "initEngine start.");
            }
            this.f46430f.d(this);
            this.f46429e.startEngine();
            this.f46429e.addStatusHandler(new C0808a(this));
            if (r) {
                Log.d("SwanAppV8Engine", "initEngine end.");
            }
        }
    }

    public void r(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, v8EngineConsole) == null) {
            this.f46429e.addV8EngineConsole(v8EngineConsole);
        }
    }

    public InspectorNativeClient r0(InspectorNativeChannel inspectorNativeChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, inspectorNativeChannel)) == null) ? this.f46429e.initInspector(inspectorNativeChannel) : (InspectorNativeClient) invokeL.objValue;
    }

    @Override // d.a.o0.a.l0.c, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f46429e.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, runnable) == null) || runnable == null) {
            return;
        }
        this.f46429e.runOnJSThreadDirectly(runnable);
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.o == 7 : invokeV.booleanValue;
    }

    @Override // d.a.o0.a.l0.c
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f46429e.setPreferredFramesPerSecond(s);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.p : invokeV.booleanValue;
    }

    @Override // d.a.o0.a.l0.c
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, jSExceptionType, str) == null) {
            this.k.d(jSExceptionType, str);
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            p0().b(this);
            this.o = 1;
        }
    }

    @NonNull
    public abstract EventTarget w();

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            p0().c(this);
            this.o = 7;
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            p0().d(this);
            this.o = 6;
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            p0().e(this);
            this.o = 3;
            this.q = true;
            T();
        }
    }

    @Override // d.a.o0.a.l0.c
    public EventTarget z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f46433i : (EventTarget) invokeV.objValue;
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            p0().g(this);
            this.o = 2;
            this.f46430f.c(this);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048613, this, runnable, j) == null) || runnable == null) {
            return;
        }
        this.f46429e.postOnJSThread(runnable, j);
    }
}
