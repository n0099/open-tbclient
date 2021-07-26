package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f38876a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f38877b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f38878c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f38879d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f38880e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f38881f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f38882g;
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
                    f38881f.invoke(f38876a, Boolean.TRUE);
                } else {
                    f38881f.invoke(f38876a, Boolean.FALSE);
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
                f38876a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f38877b = cls;
                f38878c = cls.getMethod("reportQQ", Context.class, String.class);
                f38879d = f38877b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f38880e = f38877b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f38881f = f38876a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                f38876a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f38876a, Boolean.FALSE);
                f38876a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f38876a, Boolean.TRUE);
                f38876a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f38876a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                f38876a.getMethod("setStatSendStrategy", cls2).invoke(f38876a, cls2.getField("PERIOD").get(null));
                f38877b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f38877b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f38882g = true;
            } catch (Exception e2) {
                SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
            }
        }
    }

    public static void d(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, qQToken) == null) {
            if (!TextUtils.isEmpty(qQToken.getOpenId())) {
                d.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
            }
            if (f38882g) {
                b(context, qQToken);
                if (qQToken.getOpenId() != null) {
                    try {
                        f38878c.invoke(f38877b, context, qQToken.getOpenId());
                    } catch (Exception e2) {
                        SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                    }
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f38882g) {
            b(context, qQToken);
            try {
                f38879d.invoke(f38877b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
