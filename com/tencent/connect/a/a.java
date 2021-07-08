package com.tencent.connect.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f38704a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f38705b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f38706c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f38707d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f38708e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f38709f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f38710g;
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, qQToken)) == null) ? f.a(context, qQToken.getAppId()).b("Common_ta_enable") : invokeLL.booleanValue;
    }

    public static void b(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, qQToken) == null) {
            try {
                if (a(context, qQToken)) {
                    f38709f.invoke(f38704a, Boolean.TRUE);
                } else {
                    f38709f.invoke(f38704a, Boolean.FALSE);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, qQToken) == null) {
            String str = "Aqc" + qQToken.getAppId();
            try {
                f38704a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f38705b = cls;
                f38706c = cls.getMethod("reportQQ", Context.class, String.class);
                f38707d = f38705b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f38708e = f38705b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f38709f = f38704a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                f38704a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f38704a, Boolean.FALSE);
                f38704a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f38704a, Boolean.TRUE);
                f38704a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f38704a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                f38704a.getMethod("setStatSendStrategy", cls2).invoke(f38704a, cls2.getField("PERIOD").get(null));
                f38705b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f38705b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f38710g = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, qQToken) == null) && f38710g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f38706c.invoke(f38705b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f38710g) {
            b(context, qQToken);
            try {
                f38707d.invoke(f38705b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
