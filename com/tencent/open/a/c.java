package com.tencent.open.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f38897a = 62;

    /* renamed from: b  reason: collision with root package name */
    public static int f38898b = 60;

    /* renamed from: c  reason: collision with root package name */
    public static String f38899c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f38900d;

    /* renamed from: e  reason: collision with root package name */
    public static String f38901e;

    /* renamed from: f  reason: collision with root package name */
    public static long f38902f;

    /* renamed from: g  reason: collision with root package name */
    public static int f38903g;

    /* renamed from: h  reason: collision with root package name */
    public static int f38904h;

    /* renamed from: i  reason: collision with root package name */
    public static int f38905i;
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
        f38900d = "Tencent" + File.separator + "msflogs" + File.separator + "com" + File.separator + "tencent" + File.separator + "mobileqq" + File.separator;
        f38901e = ".log";
        f38902f = 8388608L;
        f38903g = 262144;
        f38904h = 1024;
        f38905i = 10000;
        j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
    }
}
