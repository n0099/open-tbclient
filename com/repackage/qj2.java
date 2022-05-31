package com.repackage;

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
/* loaded from: classes6.dex */
public class qj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pj2 a;
    public pj2 b;
    public SwanAppUtilsJavaScriptInterface c;
    public fn1 d;

    public qj2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            pj2 pj2Var = this.a;
            if (pj2Var != null) {
                pj2Var.setActivityRef(activity);
            }
            pj2 pj2Var2 = this.b;
            if (pj2Var2 != null) {
                pj2Var2.setActivityRef(activity);
            }
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.c;
            if (swanAppUtilsJavaScriptInterface != null) {
                swanAppUtilsJavaScriptInterface.setActivity(activity);
            }
            fn1 fn1Var = this.d;
            if (fn1Var != null) {
                fn1Var.g(activity);
            }
        }
    }

    public final void b(fy1 fy1Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy1Var, context, callbackHandler, unitedSchemeMainDispatcher, fn1Var) == null) {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, fy1Var);
            this.a = swanAppGlobalJsBridge;
            fy1Var.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
            SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, fy1Var);
            this.b = swanAppJsBridge;
            fy1Var.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
            fy1Var.addJavascriptInterface(new SwanAppPreloadJsBridge(fy1Var), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
            fn1Var.b(fy1Var);
        }
    }

    public final void c(@NonNull fy1 fy1Var, Context context, @NonNull fn1 fn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, fy1Var, context, fn1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, fy1Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            fy1Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            fn1Var.a(fy1Var);
        }
    }

    public final void d(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fy1Var) == null) {
            fy1Var.addJavascriptInterface(new SwanAppNativeSwanJsBridge(fy1Var), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        }
    }

    public void e(fy1 fy1Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, fy1Var, context, callbackHandler, unitedSchemeMainDispatcher) == null) || fy1Var == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        fn1 fn1Var = new fn1(context, callbackHandler, fy1Var);
        this.d = fn1Var;
        b(fy1Var, context, callbackHandler, unitedSchemeMainDispatcher, fn1Var);
        if (fy1Var instanceof r62) {
            c(fy1Var, context, this.d);
        } else {
            d(fy1Var);
        }
    }

    public void f(Context context, fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, fy1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, fy1Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            fy1Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.c.setForceShareLight(true);
        }
    }
}
