package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.w69;
import java.util.Date;
/* loaded from: classes7.dex */
public final class x69 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static w69.a b;
    public static w69.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755219498, "Lcom/repackage/x69;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755219498, "Lcom/repackage/x69;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (x69.class) {
                if (!a) {
                    j79.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new y69();
                    c = new i79();
                    w69.a().c();
                    w69.a().d(c);
                    w69.a().d(b);
                    w69.a().e(context);
                    a = true;
                    return;
                }
                j79.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
