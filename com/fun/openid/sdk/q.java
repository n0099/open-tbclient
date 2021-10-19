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
    public static Context f70396a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f70397b;

    /* renamed from: c  reason: collision with root package name */
    public static s f70398c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f70399d;

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f70400e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f70401f;

    /* renamed from: g  reason: collision with root package name */
    public static String f70402g;

    /* renamed from: h  reason: collision with root package name */
    public static String f70403h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile q f70404i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile o f70405j;
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
        f70399d = new Object();
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
                    f70397b = "1".equals(str);
                }
            } catch (Throwable unused) {
                str = "0";
                f70397b = "1".equals(str);
            }
            f70397b = "1".equals(str);
        }
    }

    public static q a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f70404i == null) {
                synchronized (q.class) {
                    f70396a = context.getApplicationContext();
                    f70404i = new q();
                }
            }
            if (f70405j == null) {
                synchronized (q.class) {
                    f70396a = context.getApplicationContext();
                    HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                    f70400e = handlerThread;
                    handlerThread.start();
                    f70401f = new p(f70400e.getLooper());
                    f70405j = new o(f70396a);
                    a();
                }
            }
            return f70404i;
        }
        return (q) invokeL.objValue;
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            synchronized (f70399d) {
                Message obtainMessage = f70401f.obtainMessage();
                obtainMessage.what = 11;
                Bundle bundle = new Bundle();
                bundle.putInt("type", i2);
                if (i2 == 1 || i2 == 2) {
                    bundle.putString("appid", str);
                }
                obtainMessage.setData(bundle);
                f70401f.sendMessage(obtainMessage);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    f70399d.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 4) {
                                }
                            } else if (f70402g != null) {
                                f70402g = null;
                            }
                        } else if (f70402g != null) {
                        }
                    }
                    f70403h = f70402g;
                    f70402g = null;
                }
            }
        }
    }
}
