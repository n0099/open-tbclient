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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f69792a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f69793b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f69794c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f69795d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f69796e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f69797f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f69798g;
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
                    f69797f.invoke(f69792a, Boolean.TRUE);
                } else {
                    f69797f.invoke(f69792a, Boolean.FALSE);
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
                f69792a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f69793b = cls;
                f69794c = cls.getMethod("reportQQ", Context.class, String.class);
                f69795d = f69793b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f69796e = f69793b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f69797f = f69792a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                f69792a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f69792a, Boolean.FALSE);
                f69792a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f69792a, Boolean.TRUE);
                f69792a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f69792a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                f69792a.getMethod("setStatSendStrategy", cls2).invoke(f69792a, cls2.getField("PERIOD").get(null));
                f69793b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f69793b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f69798g = true;
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
            if (f69798g) {
                b(context, qQToken);
                if (qQToken.getOpenId() != null) {
                    try {
                        f69794c.invoke(f69793b, context, qQToken.getOpenId());
                    } catch (Exception e2) {
                        SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                    }
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f69798g) {
            b(context, qQToken);
            try {
                f69795d.invoke(f69793b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
