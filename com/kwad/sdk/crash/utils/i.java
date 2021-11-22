package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f66425a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f66426b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f66427c;

    /* renamed from: d  reason: collision with root package name */
    public static String f66428d;

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f66429e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f66430f;

    /* renamed from: g  reason: collision with root package name */
    public static char[] f66431g;
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
        f66425a = new Object();
        f66426b = new Object();
        f66429e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f66430f = new char[29];
        f66431g = new char[29];
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? j <= 0 ? "unknown" : f66429e.format(new Date(j)) : (String) invokeJ.objValue;
    }
}
