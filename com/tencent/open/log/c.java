package com.tencent.open.log;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.io.File;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 60;

    /* renamed from: b  reason: collision with root package name */
    public static int f62941b = 60;

    /* renamed from: c  reason: collision with root package name */
    public static String f62942c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f62943d;

    /* renamed from: e  reason: collision with root package name */
    public static String f62944e;

    /* renamed from: f  reason: collision with root package name */
    public static long f62945f;

    /* renamed from: g  reason: collision with root package name */
    public static int f62946g;

    /* renamed from: h  reason: collision with root package name */
    public static int f62947h;

    /* renamed from: i  reason: collision with root package name */
    public static int f62948i;

    /* renamed from: j  reason: collision with root package name */
    public static String f62949j;

    /* renamed from: k  reason: collision with root package name */
    public static String f62950k;
    public static String l;
    public static int m;
    public static long n;
    public static String o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1617044260, "Lcom/tencent/open/log/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1617044260, "Lcom/tencent/open/log/c;");
                return;
            }
        }
        f62943d = "Tencent" + File.separator + "msflogs" + File.separator + "com" + File.separator + "tencent" + File.separator + "mobileqq" + File.separator;
        f62944e = ".log";
        f62945f = 8388608L;
        f62946g = 262144;
        f62947h = 1024;
        f62948i = 10000;
        f62949j = "debug.file.blockcount";
        f62950k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = Constants.APP_SPECIFIC_ROOT + File.separator + "logs";
    }
}
