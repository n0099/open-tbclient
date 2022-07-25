package com.fun.openid.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.identifier.IdentifierIdClient;
/* loaded from: classes4.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public static boolean b;
    public static s c;
    public static Object d;
    public static HandlerThread e;
    public static Handler f;
    public static String g;
    public static String h;
    public static volatile q i;
    public static volatile o j;
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
        d = new Object();
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
                    str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, IdentifierIdClient.SYS_IDENTIFIERID_SUPPORTED, "unknown");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "0";
                    b = "1".equals(str);
                }
            } catch (Throwable unused) {
                str = "0";
                b = "1".equals(str);
            }
            b = "1".equals(str);
        }
    }

    public static q a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (i == null) {
                synchronized (q.class) {
                    a = context.getApplicationContext();
                    i = new q();
                }
            }
            if (j == null) {
                synchronized (q.class) {
                    a = context.getApplicationContext();
                    HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                    e = handlerThread;
                    handlerThread.start();
                    f = new p(e.getLooper());
                    j = new o(a);
                    a();
                }
            }
            return i;
        }
        return (q) invokeL.objValue;
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            synchronized (d) {
                Message obtainMessage = f.obtainMessage();
                obtainMessage.what = 11;
                Bundle bundle = new Bundle();
                bundle.putInt("type", i2);
                if (i2 == 1 || i2 == 2) {
                    bundle.putString("appid", str);
                }
                obtainMessage.setData(bundle);
                f.sendMessage(obtainMessage);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    d.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    if (i2 == 0) {
                        h = g;
                    } else if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 4) {
                            }
                        } else if (g != null) {
                            g = null;
                        } else {
                            Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                        }
                    } else if (g == null) {
                        Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                    }
                    g = null;
                } else {
                    Log.d("VMS_IDLG_SDK_Client", "query timeout");
                }
            }
        }
    }
}
