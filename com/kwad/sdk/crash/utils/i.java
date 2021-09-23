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
    public static final Object f73034a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f73035b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f73036c;

    /* renamed from: d  reason: collision with root package name */
    public static String f73037d;

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f73038e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f73039f;

    /* renamed from: g  reason: collision with root package name */
    public static char[] f73040g;
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
        f73034a = new Object();
        f73035b = new Object();
        f73038e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f73039f = new char[29];
        f73040g = new char[29];
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) ? j2 <= 0 ? "unknown" : f73038e.format(new Date(j2)) : (String) invokeJ.objValue;
    }
}
