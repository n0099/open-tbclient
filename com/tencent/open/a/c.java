package com.tencent.open.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f41883a = 62;

    /* renamed from: b  reason: collision with root package name */
    public static int f41884b = 60;

    /* renamed from: c  reason: collision with root package name */
    public static String f41885c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f41886d;

    /* renamed from: e  reason: collision with root package name */
    public static String f41887e;

    /* renamed from: f  reason: collision with root package name */
    public static long f41888f;

    /* renamed from: g  reason: collision with root package name */
    public static int f41889g;

    /* renamed from: h  reason: collision with root package name */
    public static int f41890h;

    /* renamed from: i  reason: collision with root package name */
    public static int f41891i;
    public static String j;
    public static String k;
    public static String l;
    public static int m;
    public static long n;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039279911, "Lcom/tencent/open/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039279911, "Lcom/tencent/open/a/c;");
                return;
            }
        }
        f41886d = "Tencent" + File.separator + "msflogs" + File.separator + "com" + File.separator + "tencent" + File.separator + "mobileqq" + File.separator;
        f41887e = ".log";
        f41888f = 8388608L;
        f41889g = 262144;
        f41890h = 1024;
        f41891i = 10000;
        j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
    }
}
