package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.c39;
import java.util.Date;
/* loaded from: classes5.dex */
public final class d39 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static c39.a b;
    public static c39.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755818201, "Lcom/repackage/d39;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755818201, "Lcom/repackage/d39;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (d39.class) {
                if (!a) {
                    p39.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new e39();
                    c = new o39();
                    c39.a().c();
                    c39.a().d(c);
                    c39.a().d(b);
                    c39.a().e(context);
                    a = true;
                    return;
                }
                p39.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
