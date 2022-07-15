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
public class fj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<gj0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755706043, "Lcom/repackage/fj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755706043, "Lcom/repackage/fj0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static gj0 a(@NonNull si0 si0Var) {
        InterceptResult invokeL;
        gj0 gj0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, si0Var)) == null) {
            WeakReference<gj0> weakReference = a.get(si0Var.d());
            if (weakReference == null || (gj0Var = weakReference.get()) == null) {
                gj0 gj0Var2 = new gj0(si0Var);
                a.put(si0Var.d(), new WeakReference<>(gj0Var2));
                return gj0Var2;
            }
            return gj0Var;
        }
        return (gj0) invokeL.objValue;
    }

    public static void b(@NonNull si0 si0Var) {
        WeakReference<gj0> remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, si0Var) == null) || (remove = a.remove(si0Var.d())) == null) {
            return;
        }
        remove.clear();
    }
}
