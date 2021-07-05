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
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f32674a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f32675b;

    /* renamed from: c  reason: collision with root package name */
    public static q f32676c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f32677d;

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f32678e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f32679f;

    /* renamed from: g  reason: collision with root package name */
    public static String f32680g;

    /* renamed from: h  reason: collision with root package name */
    public static String f32681h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile p f32682i;
    public static volatile n j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1740631616, "Lcom/fun/openid/sdk/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1740631616, "Lcom/fun/openid/sdk/p;");
                return;
            }
        }
        f32677d = new Object();
    }

    public p() {
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
                    f32675b = "1".equals(str);
                }
            } catch (Throwable unused) {
                str = "0";
                f32675b = "1".equals(str);
            }
            f32675b = "1".equals(str);
        }
    }

    public static p a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f32682i == null) {
                synchronized (p.class) {
                    f32674a = context.getApplicationContext();
                    f32682i = new p();
                }
            }
            if (j == null) {
                synchronized (p.class) {
                    f32674a = context.getApplicationContext();
                    HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
                    f32678e = handlerThread;
                    handlerThread.start();
                    f32679f = new o(f32678e.getLooper());
                    j = new n(f32674a);
                    a();
                }
            }
            return f32682i;
        }
        return (p) invokeL.objValue;
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            synchronized (f32677d) {
                Message obtainMessage = f32679f.obtainMessage();
                obtainMessage.what = 11;
                Bundle bundle = new Bundle();
                bundle.putInt("type", i2);
                if (i2 == 1 || i2 == 2) {
                    bundle.putString("appid", str);
                }
                obtainMessage.setData(bundle);
                f32679f.sendMessage(obtainMessage);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    f32677d.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    if (i2 == 0) {
                        f32681h = f32680g;
                    } else if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 4) {
                            }
                        } else if (f32680g != null) {
                            f32680g = null;
                        } else {
                            Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                        }
                    } else if (f32680g == null) {
                        Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                    }
                    f32680g = null;
                } else {
                    Log.d("VMS_IDLG_SDK_Client", "query timeout");
                }
            }
        }
    }
}
