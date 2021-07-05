package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
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
/* loaded from: classes7.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f42719a = 2;

    /* renamed from: a  reason: collision with other field name */
    public static Context f23a;

    /* renamed from: a  reason: collision with other field name */
    public static LoggerInterface f24a;

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f25a;

    /* renamed from: a  reason: collision with other field name */
    public static String f26a;

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap<Integer, Long> f27a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f28a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f29a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<Integer, String> f42720b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements LoggerInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f42721a;

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
            this.f42721a = b.f26a;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Log.v(this.f42721a, str);
            }
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
                Log.v(this.f42721a, str, th);
            }
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f42721a = str;
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
        f26a = "XMPush-" + Process.myPid();
        f24a = new a();
        f27a = new HashMap<>();
        f42720b = new HashMap<>();
        f25a = -1;
        f28a = new AtomicInteger(1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f42719a : invokeV.intValue;
    }

    public static Integer a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f42719a <= 1) {
                Integer valueOf = Integer.valueOf(f28a.incrementAndGet());
                f27a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                f42720b.put(valueOf, str);
                LoggerInterface loggerInterface = f24a;
                loggerInterface.log(str + " starts");
                return valueOf;
            }
            return f25a;
        }
        return (Integer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m69a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
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
            f42719a = i2;
        }
    }

    public static void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i2, str) == null) || i2 < f42719a) {
            return;
        }
        f24a.log(str);
    }

    public static void a(int i2, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65544, null, i2, str, th) == null) || i2 < f42719a) {
            return;
        }
        f24a.log(str, th);
    }

    public static void a(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65545, null, i2, th) == null) || i2 < f42719a) {
            return;
        }
        f24a.log("", th);
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            f23a = context;
            if (l.m536a(context)) {
                f29a = true;
            }
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, loggerInterface) == null) {
            f24a = loggerInterface;
        }
    }

    public static void a(Integer num) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, num) == null) && f42719a <= 1 && f27a.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - f27a.remove(num).longValue();
            LoggerInterface loggerInterface = f24a;
            loggerInterface.log(f42720b.remove(num) + " ends in " + currentTimeMillis + " ms");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m70a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            a(2, m69a(str));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m71a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            a(2, b(str, str2));
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, th) == null) {
            a(4, m69a(str), th);
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
            a(0, m69a(str));
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            a(1, m69a(str));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            a(4, m69a(str));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            if (f29a) {
                m70a(str);
            } else {
                Log.i(f26a, m69a(str));
            }
        }
    }
}
