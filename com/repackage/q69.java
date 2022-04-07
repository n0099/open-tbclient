package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.p69;
import java.util.Date;
/* loaded from: classes6.dex */
public final class q69 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static p69.a b;
    public static p69.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755428035, "Lcom/repackage/q69;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755428035, "Lcom/repackage/q69;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (q69.class) {
                if (!a) {
                    c79.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new r69();
                    c = new b79();
                    p69.a().c();
                    p69.a().d(c);
                    p69.a().d(b);
                    p69.a().e(context);
                    a = true;
                    return;
                }
                c79.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
