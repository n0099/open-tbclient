package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755220707, "Lcom/repackage/vs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755220707, "Lcom/repackage/vs1;");
                return;
            }
        }
        a = eh1.a;
        b = new String[]{"swan", "swanAPI", "utils"};
    }

    @NonNull
    public static Pair<Boolean, ts1> a(uo1 uo1Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, uo1Var, str)) == null) {
            us1 us1Var = new us1();
            boolean b2 = b(str, uo1Var.a().i());
            if (b2) {
                us1Var.b = 402;
            }
            return new Pair<>(Boolean.valueOf(b2), us1Var);
        }
        return (Pair) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean b(String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, callbackHandler)) == null) {
            if (!(callbackHandler instanceof cn1)) {
                if (a) {
                    Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                if (a) {
                    throw new RuntimeException("whitelistName is empty");
                }
                return false;
            } else {
                String e0 = ((cn1) callbackHandler).e0();
                if ("ai_apps_widget".equals(e0)) {
                    z = c(str);
                } else if ("ai_apps_ad_landing".equals(e0)) {
                    z = !l13.a(str);
                } else {
                    if (!"swan_app_alliance_login_widget".equals(e0) && !"swan_app_alliance_choose_address_widget".equals(e0) && a) {
                        Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
                    }
                    return false;
                }
                if (a) {
                    Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(@NonNull String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int indexOf = str.indexOf("/");
            if (indexOf < 0) {
                return true;
            }
            if (str.startsWith("swan")) {
                String substring = str.substring(indexOf + 1);
                for (String str2 : b) {
                    if (l13.g(str2 + "/" + substring)) {
                        return false;
                    }
                }
                return true;
            }
            return !l13.g(str);
        }
        return invokeL.booleanValue;
    }
}
