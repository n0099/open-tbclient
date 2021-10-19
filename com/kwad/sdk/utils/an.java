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
/* loaded from: classes10.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f74244a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f74245b;

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f74246c;

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f74247d;

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f74248e;

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f74249f;

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f74250g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734421, "Lcom/kwad/sdk/utils/an;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734421, "Lcom/kwad/sdk/utils/an;");
                return;
            }
        }
        f74244a = new SimpleDateFormat("MM/dd", Locale.US);
        f74245b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        f74246c = new SimpleDateFormat("MM月dd日", Locale.US);
        f74247d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
        f74248e = new SimpleDateFormat("HH:mm", Locale.US);
        f74249f = new SimpleDateFormat("MM-dd", Locale.US);
        f74250g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    }

    @Deprecated
    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str) : invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.matches(".*\\.kpg.*");
        }
        return invokeL.booleanValue;
    }
}
