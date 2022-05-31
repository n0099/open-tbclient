package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.CustomJsCodeCacheHandler;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
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
import com.repackage.zx1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class p62 implements r62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public V8Engine a;
    public m72 b;
    public final String c;
    public EventTarget d;
    public EventTarget e;
    public Context f;
    public d72 g;
    public e72 h;
    public a72 i;
    public List<JSEvent> j;
    public int k;
    public boolean l;
    public boolean m;

    /* loaded from: classes6.dex */
    public class a extends CustomJsCodeCacheHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.CustomJsCodeCacheHandler
        public String getJsCodeCacheFilePath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                float b = zx1.b.b() * 1024.0f;
                if (b <= 0.0f || ((float) file.length()) >= b) {
                    return str + "_cache";
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements V8Engine.V8StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p62 a;

        public b(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p62Var;
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
                ro1.f(this.a.a);
                this.a.B0();
            }
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements V8ExecuteCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p62 a;

        public c(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p62Var;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
        public void onExecuted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (p62.n) {
                    Log.d("SwanAppV8Engine", "finish onExecuted.");
                }
                this.a.y0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSEvent a;
        public final /* synthetic */ p62 b;

        public d(p62 p62Var, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p62Var, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p62Var;
            this.a = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.w0()) {
                    if (p62.n) {
                        Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                    }
                    this.b.j.add(this.a);
                    return;
                }
                this.b.d.dispatchEvent(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p62 a;

        public e(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (JSEvent jSEvent : this.a.j) {
                    if (p62.n) {
                        Log.d("SwanAppV8Engine", "doPendingDispatch event type: " + jSEvent.type);
                    }
                    this.a.dispatchEvent(jSEvent);
                }
                this.a.j.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755458043, "Lcom/repackage/p62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755458043, "Lcom/repackage/p62;");
                return;
            }
        }
        n = rf1.a;
        a53.c();
    }

    public p62(@NonNull String str, @NonNull m72 m72Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, m72Var, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.m = false;
        this.c = str;
        this.b = m72Var;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.d = w();
        this.e = C();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.b.a(), v8ThreadDelegatePolicy, this.d, this.e);
        this.a = v8Engine;
        if (v8ThreadDelegatePolicy instanceof i12) {
            ((i12) v8ThreadDelegatePolicy).d(v8Engine);
        }
        this.a.setExternalV8BinFilesPath(a53.a());
        this.a.setFileSystemDelegatePolicy(new i72());
        if (m72Var.b() != null) {
            this.a.setCodeCacheSetting(m72Var.b());
        }
        this.g = new d72(this.a);
        this.i = new a72(this.a);
        this.j = new ArrayList();
        x0();
    }

    @Override // com.repackage.r62
    public a72 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (a72) invokeV.objValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r0().e(this);
            this.k = 3;
            this.m = true;
            F();
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r0().g(this);
            this.k = 2;
            this.b.c(this);
        }
    }

    @NonNull
    public EventTarget C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new EventTargetImpl(this) : (EventTarget) invokeV.objValue;
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r(new b72(this));
            I0(new c72(this));
        }
    }

    @Override // com.repackage.r62
    public JsSerializeValue D(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, bArr, z)) == null) ? this.a.deserialize(bArr, z) : (JsSerializeValue) invokeLZ.objValue;
    }

    public void D0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, codeCacheSetting) == null) {
            this.a.setCodeCacheSetting(codeCacheSetting);
        }
    }

    public void E0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.f = context;
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (n) {
                Log.d("SwanAppV8Engine", "doPendingDispatch start.");
            }
            runOnJSThread(new e(this));
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a == null) {
            return;
        }
        wg1 m = pi2.m();
        this.a.setBdFileRealPath(m != null ? m.e() : null);
    }

    public void G0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, v8FileSystemDelegatePolicy) == null) {
            this.a.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
        }
    }

    public void H0(JsCodeCacheCallback jsCodeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jsCodeCacheCallback) == null) {
            this.a.setJsCodeCacheCallback(jsCodeCacheCallback);
        }
    }

    public void I0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, javaScriptExceptionDelegate) == null) {
            this.a.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
        }
    }

    public void J0() {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (v8Engine = this.a) == null) {
            return;
        }
        v8Engine.setMainPackageBasePath(uk2.U().z());
    }

    public void K0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (n) {
            Log.d("SwanAppV8Engine", "setUserAgent: " + str);
        }
        this.a.setUserAgent(str);
    }

    @Override // com.repackage.r62
    public byte[] O(JsSerializeValue jsSerializeValue, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, jsSerializeValue, z)) == null) ? this.a.serialize(jsSerializeValue, z) : (byte[]) invokeLZ.objValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.l) {
            return;
        }
        if (n) {
            Log.d("SwanAppV8Engine", "finish called.");
        }
        this.l = true;
        z0();
        this.a.destroyEngine(new c(this));
    }

    @Override // com.repackage.fy1
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, obj, str) == null) {
            if (n) {
                Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
            }
            this.g.a(obj, str);
        }
    }

    @Override // com.repackage.r62
    public void b0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            this.g.c(str, str2);
        }
    }

    @Override // com.repackage.fy1
    public void continueTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (u62.class) {
                if (!isDestroyed()) {
                    hw1.i("SwanAppV8Engine", "continueTimer: for=" + this);
                    onResume();
                }
            }
        }
    }

    @Override // com.repackage.r62
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSEvent)) == null) {
            if (n) {
                StringBuilder sb = new StringBuilder();
                sb.append("dispatchEvent event: ");
                sb.append(jSEvent != null ? jSEvent.type : "");
                Log.d("SwanAppV8Engine", sb.toString());
            }
            if (this.d != null && JSEvent.isValid(jSEvent)) {
                runOnJSThread(new d(this, jSEvent));
                return true;
            } else if (n) {
                Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.fy1
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, valueCallback) == null) {
            this.g.b(str, valueCallback);
        }
    }

    @Override // com.repackage.r62
    public e72 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.h == null) {
                this.h = new e72(this.a);
            }
            return this.h;
        }
        return (e72) invokeV.objValue;
    }

    @Override // com.repackage.fy1
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f : (Context) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.r62
    public String getInitBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.b.getInitBasePath() : (String) invokeV.objValue;
    }

    @Override // com.repackage.fy1
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? uk2.U().z() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            if (v0()) {
                if (n) {
                    Log.e("SwanAppV8Engine", Log.getStackTraceString(new Exception("engine isFinishing.")));
                    return;
                }
                return;
            }
            String quote = TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2);
            evaluateJavascript(str + "(" + quote + ");", null);
            if (n) {
                Log.d("SwanAppV8Engine", "handleSchemeDispatchCallback callback " + str + " ,params: " + str2);
            }
        }
    }

    @Override // com.repackage.fy1
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // com.repackage.fy1
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public V8Engine n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.a : (V8Engine) invokeV.objValue;
    }

    public String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.c + "] : ";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.fy1
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            b62.U().w0(true);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            V8Engine v8Engine = this.a;
            if (v8Engine != null) {
                v8Engine.onPause();
            }
            r0().f(this);
            this.k = 4;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            V8Engine v8Engine = this.a;
            if (v8Engine != null) {
                v8Engine.onResume();
            }
            r0().h(this);
            this.k = 5;
        }
    }

    @Override // com.repackage.r62
    public EventTarget p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.d : (EventTarget) invokeV.objValue;
    }

    public NetRequest p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.a.getNetRequest() : (NetRequest) invokeV.objValue;
    }

    @Override // com.repackage.r62
    public boolean post(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, runnable)) == null) {
            runOnJSThread(runnable);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.r62, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, runnable) == null) || runnable == null) {
            return;
        }
        this.a.postOnJSThread(runnable);
    }

    public JSONArray q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            V8Engine v8Engine = this.a;
            if (v8Engine == null) {
                return null;
            }
            return v8Engine.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    public void r(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, v8EngineConsole) == null) {
            this.a.addV8EngineConsole(v8EngineConsole);
        }
    }

    public final u62 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? u62.i() : (u62) invokeV.objValue;
    }

    @Override // com.repackage.r62, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, runnable) == null) || runnable == null) {
            return;
        }
        this.a.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, runnable) == null) || runnable == null) {
            return;
        }
        this.a.runOnJSThreadDirectly(runnable);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.a.setMemSetMemoryEnable(true);
            C0();
            if (n) {
                Log.d("SwanAppV8Engine", "initEngine start.");
            }
            this.b.d(this);
            boolean a2 = zx1.b.a();
            if (a2) {
                this.a.setCustomJsCodeCacheHandler(new a(this));
            }
            if (n) {
                Log.i("SwanAppV8Engine", "customCodeCache:" + a2 + ", limitSize=" + zx1.b.b() + ", rank=" + zx1.b.c());
            }
            this.a.startEngine();
            this.a.addStatusHandler(new b(this));
            if (n) {
                Log.d("SwanAppV8Engine", "initEngine end.");
            }
        }
    }

    @Override // com.repackage.r62
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Short.valueOf(s)}) == null) {
            this.a.setPreferredFramesPerSecond(s);
        }
    }

    @Override // com.repackage.fy1
    public void suspendTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            synchronized (u62.class) {
                if (!isDestroyed()) {
                    hw1.i("SwanAppV8Engine", "suspendTimer: for=" + this);
                    onPause();
                }
            }
        }
    }

    public InspectorNativeClient t0(InspectorNativeChannel inspectorNativeChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, inspectorNativeChannel)) == null) ? this.a.initInspector(inspectorNativeChannel) : (InspectorNativeClient) invokeL.objValue;
    }

    @Override // com.repackage.r62
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, jSExceptionType, str) == null) {
            this.g.d(jSExceptionType, str);
        }
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.k == 7 : invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @NonNull
    public abstract EventTarget w();

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // com.repackage.r62
    public EventTarget x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.e : (EventTarget) invokeV.objValue;
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            r0().b(this);
            this.k = 1;
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            r0().c(this);
            this.k = 7;
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            r0().d(this);
            this.k = 6;
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048616, this, runnable, j) == null) || runnable == null) {
            return;
        }
        this.a.postOnJSThread(runnable, j);
    }
}
