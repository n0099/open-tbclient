package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755707872, "Lcom/repackage/fh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755707872, "Lcom/repackage/fh3;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            k63 k63Var = new k63();
            k63Var.a = "swan";
            k63Var.b = str;
            k63Var.g = str2;
            if (TextUtils.equals(str, "click")) {
                k63Var.e = str3;
            }
            k63Var.f = str5;
            k63Var.a("source", str4);
            if (a) {
                Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + k63Var.f());
            }
            a63.x("1372", k63Var);
        }
    }
}
