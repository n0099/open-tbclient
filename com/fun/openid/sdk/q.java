package com.fun.openid.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.identifier.IdentifierIdClient;
/* loaded from: classes6.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38671b;

    /* renamed from: c  reason: collision with root package name */
    public static s f38672c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f38673d;

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f38674e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f38675f;

    /* renamed from: g  reason: collision with root package name */
    public static String f38676g;

    /* renamed from: h  reason: collision with root package name */
    public static String f38677h;
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
        f38673d = new Object();
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
                    str = (String) cls.getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class, String.class).invoke(cls, IdentifierIdClient.SYS_IDENTIFIERID_SUPPORTED, "unknown");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "0";
                    f38671b = "1".equals(str);
                }
            } catch (Throwable unused) {
                str = "0";
                f38671b = "1".equals(str);
            }
            f38671b = "1".equals(str);
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
                    f38674e = handlerThread;
                    handlerThread.start();
                    f38675f = new p(f38674e.getLooper());
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
            synchronized (f38673d) {
                Message obtainMessage = f38675f.obtainMessage();
                obtainMessage.what = 11;
                Bundle bundle = new Bundle();
                bundle.putInt("type", i2);
                if (i2 == 1 || i2 == 2) {
                    bundle.putString("appid", str);
                }
                obtainMessage.setData(bundle);
                f38675f.sendMessage(obtainMessage);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    f38673d.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    if (i2 == 0) {
                        f38677h = f38676g;
                    } else if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 4) {
                            }
                        } else if (f38676g != null) {
                            f38676g = null;
                        } else {
                            Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                        }
                    } else if (f38676g == null) {
                        Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                    }
                    f38676g = null;
                } else {
                    Log.d("VMS_IDLG_SDK_Client", "query timeout");
                }
            }
        }
    }
}
