package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.b49;
import java.util.Date;
/* loaded from: classes5.dex */
public final class c49 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static b49.a b;
    public static b49.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755847031, "Lcom/repackage/c49;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755847031, "Lcom/repackage/c49;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (c49.class) {
                if (!a) {
                    o49.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new d49();
                    c = new n49();
                    b49.a().c();
                    b49.a().d(c);
                    b49.a().d(b);
                    b49.a().e(context);
                    a = true;
                    return;
                }
                o49.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
