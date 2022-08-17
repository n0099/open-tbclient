package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class ic8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, hc8 hc8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, hc8Var)) == null) {
            if (i <= 0) {
                return hc8Var.a();
            }
            if (hc8Var.c()) {
                return i + hc8Var.b();
            }
            return i + hc8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull hc8 hc8Var, int i2, @Nullable T t, @Nullable jc8 jc8Var, @Nullable kc8 kc8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), hc8Var, Integer.valueOf(i2), t, jc8Var, kc8Var})) == null) {
            if (hc8Var.a() != -1 && hc8Var.b() != -1) {
                int a = a(i2, hc8Var);
                if (jc8Var != null && t != null) {
                    if (i <= i2) {
                        if (kc8Var != 0) {
                            kc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (kc8Var != 0) {
                            kc8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int i5 = af7.i(list);
                    if (i4 >= i5 && (jc8Var.b() || i4 > i5)) {
                        if (kc8Var != 0) {
                            kc8Var.d(i, i4, i5, jc8Var, t);
                        }
                        return false;
                    }
                    jc8Var.a(i4);
                    if (jc8Var.b()) {
                        if (kc8Var != 0) {
                            kc8Var.e(i, i4, af7.d(list, i4), jc8Var, t);
                            return true;
                        }
                        return true;
                    }
                    af7.b(list, t, i4);
                    if (kc8Var != 0) {
                        kc8Var.c(i, i4, jc8Var, t);
                        return true;
                    }
                    return true;
                } else if (kc8Var != 0) {
                    kc8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
