package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(a.a(str, str2))) {
                y.c("hmsSdk", "getAndroidId(): to getConfigByType()");
                return c(context, str, str2);
            }
            return a.a(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
                y.f("hmsSdk", "getChannel(): Invalid type: " + str2);
                return "";
            }
            return d(context, str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static String c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            if (a.b(str, str2)) {
                if (TextUtils.isEmpty(b.d())) {
                    i.c().b().b(f.a(context));
                }
                return b.d();
            }
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public static String d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(c.d(str, str2))) {
                l b = i.c().b();
                if (TextUtils.isEmpty(b.h())) {
                    String b2 = f.b(context);
                    if (!s0.a("channel", b2, 256)) {
                        b2 = "";
                    }
                    b.f(b2);
                }
                return b.h();
            }
            return c.d(str, str2);
        }
        return (String) invokeLLL.objValue;
    }
}
