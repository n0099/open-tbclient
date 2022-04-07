package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class ra8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, qa8 qa8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, qa8Var)) == null) {
            if (i <= 0) {
                return qa8Var.a();
            }
            if (qa8Var.c()) {
                return i + qa8Var.b();
            }
            return i + qa8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull qa8 qa8Var, int i2, @Nullable T t, @Nullable sa8 sa8Var, @Nullable ta8 ta8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), qa8Var, Integer.valueOf(i2), t, sa8Var, ta8Var})) == null) {
            if (qa8Var.a() != -1 && qa8Var.b() != -1) {
                int a = a(i2, qa8Var);
                if (sa8Var != null && t != null) {
                    if (i <= i2) {
                        if (ta8Var != 0) {
                            ta8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (ta8Var != 0) {
                            ta8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int k = gd7.k(list);
                    if (i4 >= k && (sa8Var.b() || i4 > k)) {
                        if (ta8Var != 0) {
                            ta8Var.d(i, i4, k, sa8Var, t);
                        }
                        return false;
                    }
                    sa8Var.a(i4);
                    if (sa8Var.b()) {
                        if (ta8Var != 0) {
                            ta8Var.e(i, i4, gd7.d(list, i4), sa8Var, t);
                            return true;
                        }
                        return true;
                    }
                    gd7.b(list, t, i4);
                    if (ta8Var != 0) {
                        ta8Var.c(i, i4, sa8Var, t);
                        return true;
                    }
                    return true;
                } else if (ta8Var != 0) {
                    ta8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
