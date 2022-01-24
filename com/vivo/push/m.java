package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public static final Handler a;

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f60758b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f60759c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1612095430, "Lcom/vivo/push/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1612095430, "Lcom/vivo/push/m;");
                return;
            }
        }
        a = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f60758b = handlerThread;
        handlerThread.start();
        f60759c = new n(f60758b.getLooper());
    }

    public static void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, lVar) == null) {
            if (lVar == null) {
                com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
                return;
            }
            int a2 = lVar.a();
            Message message = new Message();
            message.what = a2;
            message.obj = lVar;
            f60759c.sendMessageDelayed(message, 0L);
        }
    }

    public static void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            a.post(runnable);
        }
    }

    public static void c(Runnable runnable) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) || (handler = f60759c) == null) {
            return;
        }
        handler.post(runnable);
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            f60759c.removeCallbacks(runnable);
            f60759c.postDelayed(runnable, 15000L);
        }
    }
}
