package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 2;

    /* renamed from: a  reason: collision with other field name */
    public static Context f4a;

    /* renamed from: a  reason: collision with other field name */
    public static LoggerInterface f5a;

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f6a;

    /* renamed from: a  reason: collision with other field name */
    public static String f7a;

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap<Integer, Long> f8a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f9a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f10a;
    public static final HashMap<Integer, String> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements LoggerInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b.f7a;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Log.v(this.a, str);
            }
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
                Log.v(this.a, str, th);
            }
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
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
        f7a = "XMPush-" + Process.myPid();
        f5a = new a();
        f8a = new HashMap<>();
        b = new HashMap<>();
        f6a = -1;
        f9a = new AtomicInteger(1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : invokeV.intValue;
    }

    public static Integer a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (a <= 1) {
                Integer valueOf = Integer.valueOf(f9a.incrementAndGet());
                f8a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                b.put(valueOf, str);
                LoggerInterface loggerInterface = f5a;
                loggerInterface.log(str + " starts");
                return valueOf;
            }
            return f6a;
        }
        return (Integer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m108a(String str) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            return PreferencesUtil.LEFT_MOUNT + str + "] " + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            if (i < 0 || i > 5) {
                a(2, "set log level as " + i);
            }
            a = i;
        }
    }

    public static void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i, str) == null) || i < a) {
            return;
        }
        f5a.log(str);
    }

    public static void a(int i, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65544, null, i, str, th) == null) || i < a) {
            return;
        }
        f5a.log(str, th);
    }

    public static void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65545, null, i, th) == null) || i < a) {
            return;
        }
        f5a.log("", th);
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            f4a = context;
            if (l.m575a(context)) {
                f10a = true;
            }
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, loggerInterface) == null) {
            f5a = loggerInterface;
        }
    }

    public static void a(Integer num) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, num) == null) && a <= 1 && f8a.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - f8a.remove(num).longValue();
            LoggerInterface loggerInterface = f5a;
            loggerInterface.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m109a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            a(2, m108a(str));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m110a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            a(2, b(str, str2));
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, th) == null) {
            a(4, m108a(str), th);
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
            a(0, m108a(str));
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            a(1, m108a(str));
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            a(4, m108a(str));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            if (f10a) {
                m109a(str);
            } else {
                Log.i(f7a, m108a(str));
            }
        }
    }
}
