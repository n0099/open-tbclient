package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f58789b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f58790c;

    /* renamed from: d  reason: collision with root package name */
    public static String f58791d;

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f58792e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f58793f;

    /* renamed from: g  reason: collision with root package name */
    public static char[] f58794g;
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
        a = new Object();
        f58789b = new Object();
        f58792e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f58793f = new char[29];
        f58794g = new char[29];
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) ? j2 <= 0 ? "unknown" : f58792e.format(new Date(j2)) : (String) invokeJ.objValue;
    }
}
