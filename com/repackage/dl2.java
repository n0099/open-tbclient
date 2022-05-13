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
/* loaded from: classes5.dex */
public class dl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cl2 a;
    public cl2 b;
    public SwanAppUtilsJavaScriptInterface c;
    public so1 d;

    public dl2() {
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
            cl2 cl2Var = this.a;
            if (cl2Var != null) {
                cl2Var.setActivityRef(activity);
            }
            cl2 cl2Var2 = this.b;
            if (cl2Var2 != null) {
                cl2Var2.setActivityRef(activity);
            }
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.c;
            if (swanAppUtilsJavaScriptInterface != null) {
                swanAppUtilsJavaScriptInterface.setActivity(activity);
            }
            so1 so1Var = this.d;
            if (so1Var != null) {
                so1Var.g(activity);
            }
        }
    }

    public final void b(sz1 sz1Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull so1 so1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sz1Var, context, callbackHandler, unitedSchemeMainDispatcher, so1Var) == null) {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, sz1Var);
            this.a = swanAppGlobalJsBridge;
            sz1Var.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
            SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, sz1Var);
            this.b = swanAppJsBridge;
            sz1Var.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
            sz1Var.addJavascriptInterface(new SwanAppPreloadJsBridge(sz1Var), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
            so1Var.b(sz1Var);
        }
    }

    public final void c(@NonNull sz1 sz1Var, Context context, @NonNull so1 so1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, sz1Var, context, so1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, sz1Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            sz1Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            so1Var.a(sz1Var);
        }
    }

    public final void d(sz1 sz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sz1Var) == null) {
            sz1Var.addJavascriptInterface(new SwanAppNativeSwanJsBridge(sz1Var), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        }
    }

    public void e(sz1 sz1Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, sz1Var, context, callbackHandler, unitedSchemeMainDispatcher) == null) || sz1Var == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        so1 so1Var = new so1(context, callbackHandler, sz1Var);
        this.d = so1Var;
        b(sz1Var, context, callbackHandler, unitedSchemeMainDispatcher, so1Var);
        if (sz1Var instanceof e82) {
            c(sz1Var, context, this.d);
        } else {
            d(sz1Var);
        }
    }

    public void f(Context context, sz1 sz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, sz1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, sz1Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            sz1Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.c.setForceShareLight(true);
        }
    }
}
