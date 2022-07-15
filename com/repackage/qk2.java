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
/* loaded from: classes7.dex */
public class qk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pk2 a;
    public pk2 b;
    public SwanAppUtilsJavaScriptInterface c;
    public fo1 d;

    public qk2() {
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
            pk2 pk2Var = this.a;
            if (pk2Var != null) {
                pk2Var.setActivityRef(activity);
            }
            pk2 pk2Var2 = this.b;
            if (pk2Var2 != null) {
                pk2Var2.setActivityRef(activity);
            }
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.c;
            if (swanAppUtilsJavaScriptInterface != null) {
                swanAppUtilsJavaScriptInterface.setActivity(activity);
            }
            fo1 fo1Var = this.d;
            if (fo1Var != null) {
                fo1Var.i(activity);
            }
        }
    }

    public final void b(fz1 fz1Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull fo1 fo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fz1Var, context, callbackHandler, unitedSchemeMainDispatcher, fo1Var) == null) {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, fz1Var);
            this.a = swanAppGlobalJsBridge;
            fz1Var.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
            SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, fz1Var);
            this.b = swanAppJsBridge;
            fz1Var.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
            fz1Var.addJavascriptInterface(new SwanAppPreloadJsBridge(fz1Var), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
            fo1Var.b(fz1Var);
        }
    }

    public final void c(@NonNull fz1 fz1Var, Context context, @NonNull fo1 fo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, fz1Var, context, fo1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, fz1Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            fz1Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            fo1Var.a(fz1Var);
        }
    }

    public final void d(fz1 fz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fz1Var) == null) {
            fz1Var.addJavascriptInterface(new SwanAppNativeSwanJsBridge(fz1Var), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        }
    }

    public void e(fz1 fz1Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, fz1Var, context, callbackHandler, unitedSchemeMainDispatcher) == null) || fz1Var == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        fo1 fo1Var = new fo1(context, callbackHandler, fz1Var);
        this.d = fo1Var;
        b(fz1Var, context, callbackHandler, unitedSchemeMainDispatcher, fo1Var);
        if (fz1Var instanceof r72) {
            c(fz1Var, context, this.d);
        } else {
            d(fz1Var);
        }
    }

    public void f(Context context, fz1 fz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, fz1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, fz1Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            fz1Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.c.setForceShareLight(true);
        }
    }
}
