package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f76730a;

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerThread f76731b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f76732c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1612095120, "Lcom/vivo/push/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1612095120, "Lcom/vivo/push/w;");
                return;
            }
        }
        f76730a = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f76731b = handlerThread;
        handlerThread.start();
        f76732c = new x(f76731b.getLooper());
    }

    public static void a(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, vVar) == null) {
            if (vVar == null) {
                com.vivo.push.util.p.a("PushClientThread", "client thread error, task is null!");
                return;
            }
            int a2 = vVar.a();
            Message message = new Message();
            message.what = a2;
            message.obj = vVar;
            f76732c.sendMessageDelayed(message, 0L);
        }
    }

    public static void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            f76730a.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            f76732c.removeCallbacks(runnable);
            f76732c.postDelayed(runnable, 15000L);
        }
    }
}
