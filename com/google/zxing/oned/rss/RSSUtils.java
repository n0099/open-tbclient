package com.google.zxing.oned.rss;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class RSSUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RSSUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int combins(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            int i4 = i2 - i3;
            if (i4 > i3) {
                i4 = i3;
                i3 = i4;
            }
            int i5 = 1;
            int i6 = 1;
            while (i2 > i3) {
                i5 *= i2;
                if (i6 <= i4) {
                    i5 /= i6;
                    i6++;
                }
                i2--;
            }
            while (i6 <= i4) {
                i5 /= i6;
                i6++;
            }
            return i5;
        }
        return invokeII.intValue;
    }

    public static int getRSSvalue(int[] iArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{iArr, Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
            return invokeCommon.intValue;
        }
        int[] iArr2 = iArr;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int length = iArr2.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = length - 1;
            if (i5 >= i8) {
                return i6;
            }
            int i9 = 1 << i5;
            i7 |= i9;
            int i10 = 1;
            while (i10 < iArr2[i5]) {
                int i11 = i3 - i10;
                int i12 = length - i5;
                int i13 = i12 - 2;
                int combins = combins(i11 - 1, i13);
                if (z && i7 == 0) {
                    int i14 = i12 - 1;
                    if (i11 - i14 >= i14) {
                        combins -= combins(i11 - i12, i13);
                    }
                }
                if (i12 - 1 > 1) {
                    int i15 = 0;
                    for (int i16 = i11 - i13; i16 > i2; i16--) {
                        i15 += combins((i11 - i16) - 1, i12 - 3);
                    }
                    combins -= i15 * (i8 - i5);
                } else if (i11 > i2) {
                    combins--;
                }
                i6 += combins;
                i10++;
                i7 &= ~i9;
                iArr2 = iArr;
            }
            i3 -= i10;
            i5++;
            iArr2 = iArr;
        }
    }
}
