package com.google.zxing.pdf417.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;
/* loaded from: classes8.dex */
public final class PDF417CodewordDecoder {
    public static /* synthetic */ Interceptable $ic;
    public static final float[][] RATIOS_TABLE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        int i;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(423460673, "Lcom/google/zxing/pdf417/decoder/PDF417CodewordDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(423460673, "Lcom/google/zxing/pdf417/decoder/PDF417CodewordDecoder;");
                return;
            }
        }
        RATIOS_TABLE = (float[][]) Array.newInstance(float.class, PDF417Common.SYMBOL_TABLE.length, 8);
        int i2 = 0;
        while (true) {
            int[] iArr = PDF417Common.SYMBOL_TABLE;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                int i4 = i3 & 1;
                int i5 = 0;
                while (i5 < 8) {
                    float f = 0.0f;
                    while (true) {
                        i = i3 & 1;
                        if (i == i4) {
                            f += 1.0f;
                            i3 >>= 1;
                        }
                    }
                    RATIOS_TABLE[i2][(8 - i5) - 1] = f / 17.0f;
                    i5++;
                    i4 = i;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public PDF417CodewordDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getBitValue(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iArr)) == null) {
            long j = 0;
            for (int i = 0; i < iArr.length; i++) {
                for (int i2 = 0; i2 < iArr[i]; i2++) {
                    int i3 = 1;
                    long j2 = j << 1;
                    if (i % 2 != 0) {
                        i3 = 0;
                    }
                    j = j2 | i3;
                }
            }
            return (int) j;
        }
        return invokeL.intValue;
    }

    public static int getDecodedCodewordValue(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr)) == null) {
            int bitValue = getBitValue(iArr);
            if (PDF417Common.getCodeword(bitValue) == -1) {
                return -1;
            }
            return bitValue;
        }
        return invokeL.intValue;
    }

    public static int getDecodedValue(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iArr)) == null) {
            int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
            if (decodedCodewordValue != -1) {
                return decodedCodewordValue;
            }
            return getClosestDecodedValue(iArr);
        }
        return invokeL.intValue;
    }

    public static int getClosestDecodedValue(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iArr)) == null) {
            int sum = MathUtils.sum(iArr);
            float[] fArr = new float[8];
            for (int i = 0; i < 8; i++) {
                fArr[i] = iArr[i] / sum;
            }
            float f = Float.MAX_VALUE;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                float[][] fArr2 = RATIOS_TABLE;
                if (i3 < fArr2.length) {
                    float f2 = 0.0f;
                    float[] fArr3 = fArr2[i3];
                    for (int i4 = 0; i4 < 8; i4++) {
                        float f3 = fArr3[i4] - fArr[i4];
                        f2 += f3 * f3;
                        if (f2 >= f) {
                            break;
                        }
                    }
                    if (f2 < f) {
                        i2 = PDF417Common.SYMBOL_TABLE[i3];
                        f = f2;
                    }
                    i3++;
                } else {
                    return i2;
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    public static int[] sampleBitCounts(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, iArr)) == null) {
            float sum = MathUtils.sum(iArr);
            int[] iArr2 = new int[8];
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 17; i3++) {
                if (iArr[i2] + i <= (sum / 34.0f) + ((i3 * sum) / 17.0f)) {
                    i += iArr[i2];
                    i2++;
                }
                iArr2[i2] = iArr2[i2] + 1;
            }
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }
}
