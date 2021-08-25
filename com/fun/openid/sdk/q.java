package com.fun.openid.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f69862a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f69863b;

    /* renamed from: c  reason: collision with root package name */
    public static s f69864c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f69865d;

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f69866e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f69867f;

    /* renamed from: g  reason: collision with root package name */
    public static String f69868g;

    /* renamed from: h  reason: collision with root package name */
    public static String f69869h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile q f69870i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile o f69871j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1740631585, "Lcom/fun/openid/sdk/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1740631585, "Lcom/fun/openid/sdk/q;");
                return;
            }
        }
        f69865d = new Object();
    }

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", "unknown");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "0";
                    f69863b = "1".equals(str);
                }
            } catch (Throwable unused) {
                str = "0";
                f69863b = "1".equals(str);
            }
            f69863b = "1".equals(str);
        }
    }

    public static q a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f69870i == null) {
                synchronized (q.class) {
                    f69862a = context.getApplicationContext();
                    f69870i = new q();
                }
            }
            if (f69871j == null) {
                synchronized (q.class) {
                    f69862a = context.getApplicationContext();
                    HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                    f69866e = handlerThread;
                    handlerThread.start();
                    f69867f = new p(f69866e.getLooper());
                    f69871j = new o(f69862a);
                    a();
                }
            }
            return f69870i;
        }
        return (q) invokeL.objValue;
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            synchronized (f69865d) {
                Message obtainMessage = f69867f.obtainMessage();
                obtainMessage.what = 11;
                Bundle bundle = new Bundle();
                bundle.putInt("type", i2);
                if (i2 == 1 || i2 == 2) {
                    bundle.putString("appid", str);
                }
                obtainMessage.setData(bundle);
                f69867f.sendMessage(obtainMessage);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    f69865d.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 4) {
                                }
                            } else if (f69868g != null) {
                                f69868g = null;
                            }
                        } else if (f69868g != null) {
                        }
                    }
                    f69869h = f69868g;
                    f69868g = null;
                }
            }
        }
    }
}
