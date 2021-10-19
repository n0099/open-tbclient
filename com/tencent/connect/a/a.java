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
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f76431a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f76432b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f76433c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f76434d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f76435e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f76436f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f76437g;
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
                    f76436f.invoke(f76431a, Boolean.TRUE);
                } else {
                    f76436f.invoke(f76431a, Boolean.FALSE);
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
                f76431a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f76432b = cls;
                f76433c = cls.getMethod("reportQQ", Context.class, String.class);
                f76434d = f76432b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f76435e = f76432b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f76436f = f76431a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                f76431a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f76431a, Boolean.FALSE);
                f76431a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f76431a, Boolean.TRUE);
                f76431a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f76431a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                f76431a.getMethod("setStatSendStrategy", cls2).invoke(f76431a, cls2.getField("PERIOD").get(null));
                f76432b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f76432b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f76437g = true;
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
            if (f76437g) {
                b(context, qQToken);
                if (qQToken.getOpenId() != null) {
                    try {
                        f76433c.invoke(f76432b, context, qQToken.getOpenId());
                    } catch (Exception e2) {
                        SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                    }
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f76437g) {
            b(context, qQToken);
            try {
                f76434d.invoke(f76432b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
