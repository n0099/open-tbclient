package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes2.dex */
public class at {
    public static /* synthetic */ Interceptable $ic;
    public static final SimpleDateFormat a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f59603b;

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f59604c;

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f59605d;

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f59606e;

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f59607f;

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f59608g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734607, "Lcom/kwad/sdk/utils/at;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734607, "Lcom/kwad/sdk/utils/at;");
                return;
            }
        }
        a = new SimpleDateFormat("MM/dd", Locale.US);
        f59603b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        f59604c = new SimpleDateFormat("MM月dd日", Locale.US);
        f59605d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
        f59606e = new SimpleDateFormat("HH:mm", Locale.US);
        f59607f = new SimpleDateFormat("MM-dd", Locale.US);
        f59608g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    }

    @Deprecated
    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str) : invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? !TextUtils.isEmpty(str) && str.equals(str2) : invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches(".*\\.kpg.*");
        }
        return invokeL.booleanValue;
    }
}
