package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f35574a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f35575b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f35576c;

    /* renamed from: d  reason: collision with root package name */
    public static String f35577d;

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f35578e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f35579f;

    /* renamed from: g  reason: collision with root package name */
    public static char[] f35580g;
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
        f35574a = new Object();
        f35575b = new Object();
        f35578e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f35579f = new char[29];
        f35580g = new char[29];
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? j <= 0 ? "unknown" : f35578e.format(new Date(j)) : (String) invokeJ.objValue;
    }
}
