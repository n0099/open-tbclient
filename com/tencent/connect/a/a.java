package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f60391b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f60392c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f60393d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f60394e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f60395f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f60396g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1680817425, "Lcom/tencent/connect/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1680817425, "Lcom/tencent/connect/a/a;");
        }
    }

    public static boolean a(Context context, QQToken qQToken) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, qQToken)) == null) ? g.a(context, qQToken.getAppId()).b("Common_ta_enable") : invokeLL.booleanValue;
    }

    public static void b(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, qQToken) == null) {
            try {
                if (a(context, qQToken)) {
                    f60395f.invoke(a, Boolean.TRUE);
                } else {
                    f60395f.invoke(a, Boolean.FALSE);
                }
            } catch (Exception e2) {
                SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
            }
        }
    }

    public static void c(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, qQToken) == null) {
            String str = "Aqc" + qQToken.getAppId();
            try {
                a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f60391b = cls;
                f60392c = cls.getMethod("reportQQ", Context.class, String.class);
                f60393d = f60391b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f60394e = f60391b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f60395f = a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(a, Boolean.FALSE);
                a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(a, Boolean.TRUE);
                a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                a.getMethod("setStatSendStrategy", cls2).invoke(a, cls2.getField("PERIOD").get(null));
                f60391b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f60391b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f60396g = true;
            } catch (Exception e2) {
                SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
            }
        }
    }

    public static void d(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, qQToken) == null) {
            if (!TextUtils.isEmpty(qQToken.getOpenId())) {
                d.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
            }
            if (f60396g) {
                b(context, qQToken);
                if (qQToken.getOpenId() != null) {
                    try {
                        f60392c.invoke(f60391b, context, qQToken.getOpenId());
                    } catch (Exception e2) {
                        SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                    }
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f60396g) {
            b(context, qQToken);
            try {
                f60393d.invoke(f60391b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
