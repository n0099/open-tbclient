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
public class bw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755812652, "Lcom/repackage/bw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755812652, "Lcom/repackage/bw2;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends hv2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bundle, cls) == null) {
            Iterator<gw2> it = iw2.k().q().iterator();
            while (it.hasNext()) {
                gw2 next = it.next();
                if (next != null && next.S()) {
                    b(next.b, bundle, cls, null);
                }
            }
        }
    }

    public static void b(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends hv2> cls, @Nullable ov2 ov2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, swanAppProcessInfo, bundle, cls, ov2Var) == null) {
            if (a) {
                Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = iw2.k().d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (ov2Var != null) {
                bundle2.putString("ai_apps_observer_id", ov2Var.b());
                lv2.b().e(ov2Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            xv2 e = xv2.e();
            zv2 zv2Var = new zv2(obtain);
            zv2Var.b(swanAppProcessInfo);
            e.h(zv2Var);
        }
    }

    public static void c(@Nullable Bundle bundle, @NonNull Class<? extends hv2> cls, @Nullable ov2 ov2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bundle, cls, ov2Var) == null) {
            cw2.P().W(bundle, cls, ov2Var);
        }
    }
}
