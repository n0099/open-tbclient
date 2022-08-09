package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class jc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, ic8 ic8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, ic8Var)) == null) {
            if (i <= 0) {
                return ic8Var.a();
            }
            if (ic8Var.c()) {
                return i + ic8Var.b();
            }
            return i + ic8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull ic8 ic8Var, int i2, @Nullable T t, @Nullable kc8 kc8Var, @Nullable lc8 lc8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), ic8Var, Integer.valueOf(i2), t, kc8Var, lc8Var})) == null) {
            if (ic8Var.a() != -1 && ic8Var.b() != -1) {
                int a = a(i2, ic8Var);
                if (kc8Var != null && t != null) {
                    if (i <= i2) {
                        if (lc8Var != 0) {
                            lc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (lc8Var != 0) {
                            lc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = bf7.i(list);
                    if (i4 >= i5 && (kc8Var.b() || i4 > i5)) {
                        if (lc8Var != 0) {
                            lc8Var.d(i, i4, i5, kc8Var, t);
                        }
                        return false;
                    }
                    kc8Var.a(i4);
                    if (kc8Var.b()) {
                        if (lc8Var != 0) {
                            lc8Var.e(i, i4, bf7.d(list, i4), kc8Var, t);
                            return true;
                        }
                        return true;
                    }
                    bf7.b(list, t, i4);
                    if (lc8Var != 0) {
                        lc8Var.c(i, i4, kc8Var, t);
                        return true;
                    }
                    return true;
                } else if (lc8Var != 0) {
                    lc8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
