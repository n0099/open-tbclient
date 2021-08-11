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
    public static final SimpleDateFormat f73510a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f73511b;

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f73512c;

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f73513d;

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f73514e;

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f73515f;

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f73516g;
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
        f73510a = new SimpleDateFormat("MM/dd", Locale.US);
        f73511b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        f73512c = new SimpleDateFormat("MM月dd日", Locale.US);
        f73513d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
        f73514e = new SimpleDateFormat("HH:mm", Locale.US);
        f73515f = new SimpleDateFormat("MM-dd", Locale.US);
        f73516g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
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
