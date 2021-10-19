package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes10.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f73069a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f73070b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f73071c;

    /* renamed from: d  reason: collision with root package name */
    public static String f73072d;

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f73073e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f73074f;

    /* renamed from: g  reason: collision with root package name */
    public static char[] f73075g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639243283, "Lcom/kwad/sdk/crash/utils/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639243283, "Lcom/kwad/sdk/crash/utils/i;");
                return;
            }
        }
        f73069a = new Object();
        f73070b = new Object();
        f73073e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f73074f = new char[29];
        f73075g = new char[29];
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) ? j2 <= 0 ? "unknown" : f73073e.format(new Date(j2)) : (String) invokeJ.objValue;
    }
}
