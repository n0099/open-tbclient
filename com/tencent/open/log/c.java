package com.tencent.open.log;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.io.File;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f70098a = 60;

    /* renamed from: b  reason: collision with root package name */
    public static int f70099b = 60;

    /* renamed from: c  reason: collision with root package name */
    public static String f70100c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f70101d;

    /* renamed from: e  reason: collision with root package name */
    public static String f70102e;

    /* renamed from: f  reason: collision with root package name */
    public static long f70103f;

    /* renamed from: g  reason: collision with root package name */
    public static int f70104g;

    /* renamed from: h  reason: collision with root package name */
    public static int f70105h;

    /* renamed from: i  reason: collision with root package name */
    public static int f70106i;
    public static String j;
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
        f70101d = "Tencent" + File.separator + "msflogs" + File.separator + "com" + File.separator + "tencent" + File.separator + "mobileqq" + File.separator;
        f70102e = ".log";
        f70103f = 8388608L;
        f70104g = 262144;
        f70105h = 1024;
        f70106i = 10000;
        j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = Constants.APP_SPECIFIC_ROOT + File.separator + "logs";
    }
}
