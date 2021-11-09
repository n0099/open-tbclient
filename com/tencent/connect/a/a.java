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
    public static Class<?> f69791a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f69792b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f69793c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f69794d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f69795e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f69796f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f69797g;
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
                    f69796f.invoke(f69791a, Boolean.TRUE);
                } else {
                    f69796f.invoke(f69791a, Boolean.FALSE);
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
                f69791a = Class.forName("com.tencent.stat.StatConfig");
                Class<?> cls = Class.forName("com.tencent.stat.StatService");
                f69792b = cls;
                f69793c = cls.getMethod("reportQQ", Context.class, String.class);
                f69794d = f69792b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
                f69795e = f69792b.getMethod("commitEvents", Context.class, Integer.TYPE);
                f69796f = f69791a.getMethod("setEnableStatService", Boolean.TYPE);
                b(context, qQToken);
                f69791a.getMethod("setAutoExceptionCaught", Boolean.TYPE).invoke(f69791a, Boolean.FALSE);
                f69791a.getMethod("setEnableSmartReporting", Boolean.TYPE).invoke(f69791a, Boolean.TRUE);
                f69791a.getMethod("setSendPeriodMinutes", Integer.TYPE).invoke(f69791a, 1440);
                Class<?> cls2 = Class.forName("com.tencent.stat.StatReportStrategy");
                f69791a.getMethod("setStatSendStrategy", cls2).invoke(f69791a, cls2.getField("PERIOD").get(null));
                f69792b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f69792b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
                f69797g = true;
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
            if (f69797g) {
                b(context, qQToken);
                if (qQToken.getOpenId() != null) {
                    try {
                        f69793c.invoke(f69792b, context, qQToken.getOpenId());
                    } catch (Exception e2) {
                        SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                    }
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65537, null, context, qQToken, str, strArr) == null) && f69797g) {
            b(context, qQToken);
            try {
                f69794d.invoke(f69792b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
