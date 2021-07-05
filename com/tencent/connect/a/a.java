package com.tencent.connect.a;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f41690a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f41691b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f41692c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f41693d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f41694e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f41695f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f41696g;
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
                    f41695f.invoke(f41690a, Boolean.TRUE);
                } else {
                    f41695f.invoke(f41690a, Boolean.FALSE);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, context, qQToken) == null) {
            String str = "Aqc" + qQToken.getAppId();
            try {
                f41690a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f41691b = cls;
                f41692c = cls.getMethod("reportQQ", Context.class, String.class);
                f41693d = f41691b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f41694e = f41691b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f41695f = f41690a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                f41690a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f41690a, Boolean.FALSE);
                f41690a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f41690a, Boolean.TRUE);
                f41690a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f41690a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                f41690a.getMethod("setStatSendStrategy", cls2).invoke(f41690a, cls2.getField("PERIOD").get(null));
                f41691b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f41691b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f41696g = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(Context context, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, qQToken) == null) && f41696g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f41692c.invoke(f41691b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f41696g) {
            b(context, qQToken);
            try {
                f41693d.invoke(f41691b, context, str, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
