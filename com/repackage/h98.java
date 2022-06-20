package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class h98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, g98 g98Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, g98Var)) == null) {
            if (i <= 0) {
                return g98Var.a();
            }
            if (g98Var.c()) {
                return i + g98Var.b();
            }
            return i + g98Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull g98 g98Var, int i2, @Nullable T t, @Nullable i98 i98Var, @Nullable j98 j98Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), g98Var, Integer.valueOf(i2), t, i98Var, j98Var})) == null) {
            if (g98Var.a() != -1 && g98Var.b() != -1) {
                int a = a(i2, g98Var);
                if (i98Var != null && t != null) {
                    if (i <= i2) {
                        if (j98Var != 0) {
                            j98Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (j98Var != 0) {
                            j98Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = oc7.i(list);
                    if (i4 >= i5 && (i98Var.b() || i4 > i5)) {
                        if (j98Var != 0) {
                            j98Var.d(i, i4, i5, i98Var, t);
                        }
                        return false;
                    }
                    i98Var.a(i4);
                    if (i98Var.b()) {
                        if (j98Var != 0) {
                            j98Var.e(i, i4, oc7.d(list, i4), i98Var, t);
                            return true;
                        }
                        return true;
                    }
                    oc7.b(list, t, i4);
                    if (j98Var != 0) {
                        j98Var.c(i, i4, i98Var, t);
                        return true;
                    }
                    return true;
                } else if (j98Var != 0) {
                    j98Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
