package com.kwad.sdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Integer.valueOf(i2)})) == null) {
            int i3 = z ? 1 : 0;
            if (z2) {
                i3 |= 2;
            }
            if (z3) {
                i3 |= 4;
            }
            if (z4) {
                i3 |= 8;
            }
            if (z5) {
                i3 |= 16;
            }
            if (z6) {
                i3 |= 32;
            }
            return i2 == 2 ? i3 | 64 : i3;
        }
        return invokeCommon.intValue;
    }
}
