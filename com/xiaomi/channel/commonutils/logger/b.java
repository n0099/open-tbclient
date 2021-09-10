package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.l;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f77237a = 2;

    /* renamed from: a  reason: collision with other field name */
    public static Context f27a;

    /* renamed from: a  reason: collision with other field name */
    public static LoggerInterface f28a;

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f29a;

    /* renamed from: a  reason: collision with other field name */
    public static String f30a;

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap<Integer, Long> f31a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f32a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f33a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<Integer, String> f77238b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements LoggerInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f77239a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f77239a = b.f30a;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
            }
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f77239a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1966532215, "Lcom/xiaomi/channel/commonutils/logger/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1966532215, "Lcom/xiaomi/channel/commonutils/logger/b;");
                return;
            }
        }
        f30a = "XMPush-" + Process.myPid();
        f28a = new a();
        f31a = new HashMap<>();
        f77238b = new HashMap<>();
        f29a = -1;
        f32a = new AtomicInteger(1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f77237a : invokeV.intValue;
    }

    public static Integer a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f77237a <= 1) {
                Integer valueOf = Integer.valueOf(f32a.incrementAndGet());
                f31a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                f77238b.put(valueOf, str);
                LoggerInterface loggerInterface = f28a;
                loggerInterface.log(str + " starts");
                return valueOf;
            }
            return f29a;
        }
        return (Integer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m72a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return b() + str;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            return PreferencesUtil.LEFT_MOUNT + str + "] " + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2) == null) {
            if (i2 < 0 || i2 > 5) {
                a(2, "set log level as " + i2);
            }
            f77237a = i2;
        }
    }

    public static void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i2, str) == null) || i2 < f77237a) {
            return;
        }
        f28a.log(str);
    }

    public static void a(int i2, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65544, null, i2, str, th) == null) || i2 < f77237a) {
            return;
        }
        f28a.log(str, th);
    }

    public static void a(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65545, null, i2, th) == null) || i2 < f77237a) {
            return;
        }
        f28a.log("", th);
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            f27a = context;
            if (l.m539a(context)) {
                f33a = true;
            }
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, loggerInterface) == null) {
            f28a = loggerInterface;
        }
    }

    public static void a(Integer num) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, num) == null) && f77237a <= 1 && f31a.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - f31a.remove(num).longValue();
            LoggerInterface loggerInterface = f28a;
            loggerInterface.log(f77238b.remove(num) + " ends in " + currentTimeMillis + " ms");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m73a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            a(2, m72a(str));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m74a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            a(2, b(str, str2));
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, th) == null) {
            a(4, m72a(str), th);
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, th) == null) {
            a(4, th);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return "[Tid:" + Thread.currentThread().getId() + "] ";
        }
        return (String) invokeV.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) {
            return b() + a(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            a(0, m72a(str));
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            a(1, m72a(str));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            a(4, m72a(str));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            if (f33a) {
                m73a(str);
            } else {
                m72a(str);
            }
        }
    }
}
