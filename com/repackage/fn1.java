package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.api.module.network.SwanApiNetworkV8Module;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes5.dex */
public class fn1 implements in1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Context a;
    @NonNull
    public CallbackHandler b;
    public WeakReference<Activity> c;
    public fy1 d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755702168, "Lcom/repackage/fn1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755702168, "Lcom/repackage/fn1;");
                return;
            }
        }
        e = rf1.a;
    }

    public fn1(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, callbackHandler, fy1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = callbackHandler;
        this.d = fy1Var;
    }

    public void a(@NonNull fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fy1Var) == null) {
            fy1Var.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
        }
    }

    public final void b(@NonNull fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy1Var) == null) {
            if (fy1Var instanceof r62) {
                c((r62) fy1Var);
            } else {
                d(fy1Var);
            }
        }
    }

    public final void c(@NonNull r62 r62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r62Var) == null) {
            e(r62Var, SwanApi$$ModulesProvider.getV8ApiModules(this), oi2.s().b(this));
        }
    }

    public final void d(@NonNull fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fy1Var) == null) {
            e(fy1Var, SwanApi$$ModulesProvider.getWebviewApiModules(this), oi2.s().c(this));
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void e(@NonNull fy1 fy1Var, Map<String, Object> map, Map<String, Object> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, fy1Var, map, map2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (map2 != null) {
                if (map == null) {
                    map = map2;
                } else {
                    try {
                        map.putAll(map2);
                    } catch (Exception e2) {
                        if (e) {
                            e2.printStackTrace();
                            throw new RuntimeException("doBindSwanApis fail: " + e2.getMessage());
                        }
                        return;
                    }
                }
            }
            if (map == null) {
                if (e) {
                    throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
                }
                return;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    if (e) {
                        throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                    }
                } else if (value == null) {
                    if (e) {
                        throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                    }
                } else {
                    fy1Var.addJavascriptInterface(value, key);
                    if (e) {
                        String str = fy1Var instanceof r62 ? "V8" : "Webview";
                        Log.d("Api-Binder", "doBindSwanApis(" + str + "): bound " + key);
                    }
                }
            }
            if (e) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 5) {
                    Log.w("Api-Binder", "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms");
                }
            }
        }
    }

    @NonNull
    public final Context f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            WeakReference<Activity> weakReference = this.c;
            Activity activity = weakReference != null ? weakReference.get() : null;
            return activity == null ? this.a : activity;
        }
        return (Context) invokeV.objValue;
    }

    public void g(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, activity) == null) || activity == null) {
            return;
        }
        this.c = new WeakReference<>(activity);
    }

    @Override // com.repackage.in1
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f() : (Context) invokeV.objValue;
    }

    @Override // com.repackage.in1
    @NonNull
    public fy1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (fy1) invokeV.objValue;
    }

    @Override // com.repackage.in1
    @NonNull
    public CallbackHandler i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (CallbackHandler) invokeV.objValue;
    }
}
