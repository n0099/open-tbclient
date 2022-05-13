package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class ta8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, sa8 sa8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, sa8Var)) == null) {
            if (i <= 0) {
                return sa8Var.a();
            }
            if (sa8Var.c()) {
                return i + sa8Var.b();
            }
            return i + sa8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull sa8 sa8Var, int i2, @Nullable T t, @Nullable ua8 ua8Var, @Nullable va8 va8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), sa8Var, Integer.valueOf(i2), t, ua8Var, va8Var})) == null) {
            if (sa8Var.a() != -1 && sa8Var.b() != -1) {
                int a = a(i2, sa8Var);
                if (ua8Var != null && t != null) {
                    if (i <= i2) {
                        if (va8Var != 0) {
                            va8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (va8Var != 0) {
                            va8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = pd7.i(list);
                    if (i4 >= i5 && (ua8Var.b() || i4 > i5)) {
                        if (va8Var != 0) {
                            va8Var.d(i, i4, i5, ua8Var, t);
                        }
                        return false;
                    }
                    ua8Var.a(i4);
                    if (ua8Var.b()) {
                        if (va8Var != 0) {
                            va8Var.e(i, i4, pd7.d(list, i4), ua8Var, t);
                            return true;
                        }
                        return true;
                    }
                    pd7.b(list, t, i4);
                    if (va8Var != 0) {
                        va8Var.c(i, i4, ua8Var, t);
                        return true;
                    }
                    return true;
                } else if (va8Var != 0) {
                    va8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
