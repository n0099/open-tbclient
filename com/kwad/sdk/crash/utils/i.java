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
    public static final Object a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f58208b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f58209c;

    /* renamed from: d  reason: collision with root package name */
    public static String f58210d;

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f58211e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f58212f;

    /* renamed from: g  reason: collision with root package name */
    public static char[] f58213g;
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
        f58208b = new Object();
        f58211e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f58212f = new char[29];
        f58213g = new char[29];
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) ? j2 <= 0 ? "unknown" : f58211e.format(new Date(j2)) : (String) invokeJ.objValue;
    }
}
