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
    public static Class<?> f76077a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f76078b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f76079c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f76080d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f76081e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f76082f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f76083g;
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
                    f76082f.invoke(f76077a, Boolean.TRUE);
                } else {
                    f76082f.invoke(f76077a, Boolean.FALSE);
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
                f76077a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f76078b = cls;
                f76079c = cls.getMethod("reportQQ", Context.class, String.class);
                f76080d = f76078b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f76081e = f76078b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f76082f = f76077a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                f76077a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f76077a, Boolean.FALSE);
                f76077a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f76077a, Boolean.TRUE);
                f76077a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f76077a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                f76077a.getMethod("setStatSendStrategy", cls2).invoke(f76077a, cls2.getField("PERIOD").get(null));
                f76078b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f76078b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f76083g = true;
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
            if (f76083g) {
                b(context, qQToken);
                if (qQToken.getOpenId() != null) {
                    try {
                        f76079c.invoke(f76078b, context, qQToken.getOpenId());
                    } catch (Exception e2) {
                        SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                    }
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f76083g) {
            b(context, qQToken);
            try {
                f76080d.invoke(f76078b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
