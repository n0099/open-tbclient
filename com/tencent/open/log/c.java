package com.tencent.open.log;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.io.File;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f76748a = 60;

    /* renamed from: b  reason: collision with root package name */
    public static int f76749b = 60;

    /* renamed from: c  reason: collision with root package name */
    public static String f76750c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f76751d;

    /* renamed from: e  reason: collision with root package name */
    public static String f76752e;

    /* renamed from: f  reason: collision with root package name */
    public static long f76753f;

    /* renamed from: g  reason: collision with root package name */
    public static int f76754g;

    /* renamed from: h  reason: collision with root package name */
    public static int f76755h;

    /* renamed from: i  reason: collision with root package name */
    public static int f76756i;

    /* renamed from: j  reason: collision with root package name */
    public static String f76757j;
    public static String k;
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
        f76751d = "Tencent" + File.separator + "msflogs" + File.separator + "com" + File.separator + "tencent" + File.separator + "mobileqq" + File.separator;
        f76752e = ".log";
        f76753f = 8388608L;
        f76754g = 262144;
        f76755h = 1024;
        f76756i = 10000;
        f76757j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = Constants.APP_SPECIFIC_ROOT + File.separator + "logs";
    }
}
