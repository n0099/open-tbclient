package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class cj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<dj0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755795416, "Lcom/repackage/cj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755795416, "Lcom/repackage/cj0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static dj0 a(@NonNull oi0 oi0Var) {
        InterceptResult invokeL;
        dj0 dj0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, oi0Var)) == null) {
            WeakReference<dj0> weakReference = a.get(oi0Var.e());
            if (weakReference == null || (dj0Var = weakReference.get()) == null) {
                dj0 dj0Var2 = new dj0(oi0Var);
                a.put(oi0Var.e(), new WeakReference<>(dj0Var2));
                return dj0Var2;
            }
            return dj0Var;
        }
        return (dj0) invokeL.objValue;
    }

    public static void b(@NonNull oi0 oi0Var) {
        WeakReference<dj0> remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, oi0Var) == null) || (remove = a.remove(oi0Var.e())) == null) {
            return;
        }
        remove.clear();
    }
}
