package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class ca8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ba8 ba8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ba8Var)) == null) {
            if (i <= 0) {
                return ba8Var.a();
            }
            if (ba8Var.c()) {
                return i + ba8Var.b();
            }
            return i + ba8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ba8 ba8Var, int i2, @Nullable T t, @Nullable da8 da8Var, @Nullable ea8 ea8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ba8Var, Integer.valueOf(i2), t, da8Var, ea8Var})) == null) {
            if (ba8Var.a() != -1 && ba8Var.b() != -1) {
                int a = a(i2, ba8Var);
                if (da8Var != null && t != null) {
                    if (i <= i2) {
                        if (ea8Var != 0) {
                            ea8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (ea8Var != 0) {
                            ea8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = gd7.i(list);
                    if (i4 >= i5 && (da8Var.b() || i4 > i5)) {
                        if (ea8Var != 0) {
                            ea8Var.d(i, i4, i5, da8Var, t);
                        }
                        return false;
                    }
                    da8Var.a(i4);
                    if (da8Var.b()) {
                        if (ea8Var != 0) {
                            ea8Var.e(i, i4, gd7.d(list, i4), da8Var, t);
                            return true;
                        }
                        return true;
                    }
                    gd7.b(list, t, i4);
                    if (ea8Var != 0) {
                        ea8Var.c(i, i4, da8Var, t);
                        return true;
                    }
                    return true;
                } else if (ea8Var != 0) {
                    ea8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
