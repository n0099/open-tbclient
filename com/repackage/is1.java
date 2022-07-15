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
/* loaded from: classes6.dex */
public class is1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755607990, "Lcom/repackage/is1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755607990, "Lcom/repackage/is1;");
                return;
            }
        }
        a = rg1.a;
        b = new String[]{"swan", "swanAPI", "utils"};
    }

    @NonNull
    public static Pair<Boolean, gs1> a(ho1 ho1Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ho1Var, str)) == null) {
            hs1 hs1Var = new hs1();
            boolean b2 = b(str, ho1Var.a().h());
            if (b2) {
                hs1Var.b = 402;
            }
            return new Pair<>(Boolean.valueOf(b2), hs1Var);
        }
        return (Pair) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean b(String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, callbackHandler)) == null) {
            if (!(callbackHandler instanceof pm1)) {
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
                String d0 = ((pm1) callbackHandler).d0();
                if ("ai_apps_widget".equals(d0)) {
                    z = c(str);
                } else if ("ai_apps_ad_landing".equals(d0)) {
                    z = !y03.a(str);
                } else {
                    if (!"swan_app_alliance_login_widget".equals(d0) && !"swan_app_alliance_choose_address_widget".equals(d0) && a) {
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
                    if (y03.g(str2 + "/" + substring)) {
                        return false;
                    }
                }
                return true;
            }
            return !y03.g(str);
        }
        return invokeL.booleanValue;
    }
}
