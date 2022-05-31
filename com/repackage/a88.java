package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class a88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, z78 z78Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, z78Var)) == null) {
            if (i <= 0) {
                return z78Var.a();
            }
            if (z78Var.c()) {
                return i + z78Var.b();
            }
            return i + z78Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull z78 z78Var, int i2, @Nullable T t, @Nullable b88 b88Var, @Nullable c88 c88Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), z78Var, Integer.valueOf(i2), t, b88Var, c88Var})) == null) {
            if (z78Var.a() != -1 && z78Var.b() != -1) {
                int a = a(i2, z78Var);
                if (b88Var != null && t != null) {
                    if (i <= i2) {
                        if (c88Var != 0) {
                            c88Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (c88Var != 0) {
                            c88Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = db7.i(list);
                    if (i4 >= i5 && (b88Var.b() || i4 > i5)) {
                        if (c88Var != 0) {
                            c88Var.d(i, i4, i5, b88Var, t);
                        }
                        return false;
                    }
                    b88Var.a(i4);
                    if (b88Var.b()) {
                        if (c88Var != 0) {
                            c88Var.e(i, i4, db7.d(list, i4), b88Var, t);
                            return true;
                        }
                        return true;
                    }
                    db7.b(list, t, i4);
                    if (c88Var != 0) {
                        c88Var.c(i, i4, b88Var, t);
                        return true;
                    }
                    return true;
                } else if (c88Var != 0) {
                    c88Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
