package d.a.o0.a.d1.b;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.l0.c;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.d1.a f44447a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.d1.a f44448b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppUtilsJavaScriptInterface f44449c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.u.a f44450d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            d.a.o0.a.d1.a aVar = this.f44447a;
            if (aVar != null) {
                aVar.setActivityRef(activity);
            }
            d.a.o0.a.d1.a aVar2 = this.f44448b;
            if (aVar2 != null) {
                aVar2.setActivityRef(activity);
            }
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.f44449c;
            if (swanAppUtilsJavaScriptInterface != null) {
                swanAppUtilsJavaScriptInterface.setActivity(activity);
            }
            d.a.o0.a.u.a aVar3 = this.f44450d;
            if (aVar3 != null) {
                aVar3.i(activity);
            }
        }
    }

    public final void b(d.a.o0.a.h0.f.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull d.a.o0.a.u.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, context, callbackHandler, unitedSchemeMainDispatcher, aVar2) == null) {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
            this.f44447a = swanAppGlobalJsBridge;
            aVar.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
            SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
            this.f44448b = swanAppJsBridge;
            aVar.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
            aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
            aVar2.b(aVar);
        }
    }

    public final void c(@NonNull d.a.o0.a.h0.f.a aVar, Context context, @NonNull d.a.o0.a.u.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, context, aVar2) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
            this.f44449c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            aVar.addJavascriptInterface(this.f44449c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            aVar2.a(aVar);
        }
    }

    public final void d(d.a.o0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        }
    }

    public void e(d.a.o0.a.h0.f.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, aVar, context, callbackHandler, unitedSchemeMainDispatcher) == null) || aVar == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        d.a.o0.a.u.a aVar2 = new d.a.o0.a.u.a(context, callbackHandler, aVar);
        this.f44450d = aVar2;
        b(aVar, context, callbackHandler, unitedSchemeMainDispatcher, aVar2);
        if (aVar instanceof c) {
            c(aVar, context, this.f44450d);
        } else {
            d(aVar);
        }
    }

    public void f(Context context, d.a.o0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, aVar) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
            this.f44449c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            aVar.addJavascriptInterface(this.f44449c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.f44449c.setForceShareLight(true);
        }
    }
}
