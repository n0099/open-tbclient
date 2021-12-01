package com.tencent.open.log;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 60;

    /* renamed from: b  reason: collision with root package name */
    public static int f62360b = 60;

    /* renamed from: c  reason: collision with root package name */
    public static String f62361c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f62362d;

    /* renamed from: e  reason: collision with root package name */
    public static String f62363e;

    /* renamed from: f  reason: collision with root package name */
    public static long f62364f;

    /* renamed from: g  reason: collision with root package name */
    public static int f62365g;

    /* renamed from: h  reason: collision with root package name */
    public static int f62366h;

    /* renamed from: i  reason: collision with root package name */
    public static int f62367i;

    /* renamed from: j  reason: collision with root package name */
    public static String f62368j;

    /* renamed from: k  reason: collision with root package name */
    public static String f62369k;
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
        f62362d = "Tencent" + File.separator + "msflogs" + File.separator + "com" + File.separator + "tencent" + File.separator + "mobileqq" + File.separator;
        f62363e = ".log";
        f62364f = 8388608L;
        f62365g = 262144;
        f62366h = 1024;
        f62367i = 10000;
        f62368j = "debug.file.blockcount";
        f62369k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = Constants.APP_SPECIFIC_ROOT + File.separator + "logs";
    }
}
