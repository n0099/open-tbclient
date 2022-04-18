package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class ya8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, xa8 xa8Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, xa8Var)) == null) {
            if (i <= 0) {
                return xa8Var.a();
            }
            if (xa8Var.c()) {
                return i + xa8Var.b();
            }
            return i + xa8Var.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull xa8 xa8Var, int i2, @Nullable T t, @Nullable za8 za8Var, @Nullable ab8 ab8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), xa8Var, Integer.valueOf(i2), t, za8Var, ab8Var})) == null) {
            if (xa8Var.a() != -1 && xa8Var.b() != -1) {
                int a = a(i2, xa8Var);
                if (za8Var != null && t != null) {
                    if (i <= i2) {
                        if (ab8Var != 0) {
                            ab8Var.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (ab8Var != 0) {
                            ab8Var.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int k = jd7.k(list);
                    if (i4 >= k && (za8Var.b() || i4 > k)) {
                        if (ab8Var != 0) {
                            ab8Var.d(i, i4, k, za8Var, t);
                        }
                        return false;
                    }
                    za8Var.a(i4);
                    if (za8Var.b()) {
                        if (ab8Var != 0) {
                            ab8Var.e(i, i4, jd7.d(list, i4), za8Var, t);
                            return true;
                        }
                        return true;
                    }
                    jd7.b(list, t, i4);
                    if (ab8Var != 0) {
                        ab8Var.c(i, i4, za8Var, t);
                        return true;
                    }
                    return true;
                } else if (ab8Var != 0) {
                    ab8Var.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
