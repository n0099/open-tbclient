package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class fl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            int[] iArr = {1, 2, 3, 4, 5, 6};
            for (int i2 = 0; i2 < 6; i2++) {
                int i3 = iArr[i2];
                int i4 = i3 - 1;
                if (i3 == 0) {
                    throw null;
                }
                if (i4 == i) {
                    return i3;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }
}
