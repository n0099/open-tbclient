package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.r59;
import java.util.Date;
/* loaded from: classes7.dex */
public final class s59 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static r59.a b;
    public static r59.a c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755369414, "Lcom/repackage/s59;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755369414, "Lcom/repackage/s59;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (s59.class) {
                if (!a) {
                    e69.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    b = new t59();
                    c = new d69();
                    r59.a().c();
                    r59.a().d(c);
                    r59.a().d(b);
                    r59.a().e(context);
                    a = true;
                    return;
                }
                e69.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
