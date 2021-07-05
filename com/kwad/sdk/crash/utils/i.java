package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f37015a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f37016b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f37017c;

    /* renamed from: d  reason: collision with root package name */
    public static String f37018d;

    /* renamed from: e  reason: collision with root package name */
    public static SimpleDateFormat f37019e;

    /* renamed from: f  reason: collision with root package name */
    public static char[] f37020f;

    /* renamed from: g  reason: collision with root package name */
    public static char[] f37021g;
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
        f37015a = new Object();
        f37016b = new Object();
        f37019e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f37020f = new char[29];
        f37021g = new char[29];
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? j <= 0 ? "unknown" : f37019e.format(new Date(j)) : (String) invokeJ.objValue;
    }
}
