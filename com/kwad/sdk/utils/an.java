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
public class an {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f66629a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f66630b;

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f66631c;

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f66632d;

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f66633e;

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f66634f;

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f66635g;
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
        f66629a = new SimpleDateFormat("MM/dd", Locale.US);
        f66630b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        f66631c = new SimpleDateFormat("MM月dd日", Locale.US);
        f66632d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
        f66633e = new SimpleDateFormat("HH:mm", Locale.US);
        f66634f = new SimpleDateFormat("MM-dd", Locale.US);
        f66635g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
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
