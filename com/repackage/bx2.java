package com.repackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class bx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755811691, "Lcom/repackage/bx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755811691, "Lcom/repackage/bx2;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends hw2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bundle, cls) == null) {
            Iterator<gx2> it = ix2.k().q().iterator();
            while (it.hasNext()) {
                gx2 next = it.next();
                if (next != null && next.T()) {
                    b(next.b, bundle, cls, null);
                }
            }
        }
    }

    public static void b(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends hw2> cls, @Nullable ow2 ow2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, swanAppProcessInfo, bundle, cls, ow2Var) == null) {
            if (a) {
                Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = ix2.k().d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (ow2Var != null) {
                bundle2.putString("ai_apps_observer_id", ow2Var.b());
                lw2.b().e(ow2Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            xw2 e = xw2.e();
            zw2 zw2Var = new zw2(obtain);
            zw2Var.b(swanAppProcessInfo);
            e.h(zw2Var);
        }
    }

    public static void c(@Nullable Bundle bundle, @NonNull Class<? extends hw2> cls, @Nullable ow2 ow2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bundle, cls, ow2Var) == null) {
            cx2.Q().X(bundle, cls, ow2Var);
        }
    }
}
