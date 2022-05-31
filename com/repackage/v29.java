package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.u29;
import java.util.Date;
/* loaded from: classes7.dex */
public final class v29 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static u29.a b;
    public static u29.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755282924, "Lcom/repackage/v29;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755282924, "Lcom/repackage/v29;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (v29.class) {
                if (!a) {
                    h39.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new w29();
                    c = new g39();
                    u29.a().c();
                    u29.a().d(c);
                    u29.a().d(b);
                    u29.a().e(context);
                    a = true;
                    return;
                }
                h39.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
