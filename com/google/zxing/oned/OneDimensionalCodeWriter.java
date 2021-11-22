package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
/* loaded from: classes11.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OneDimensionalCodeWriter() {
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

    public static int appendPattern(boolean[] zArr, int i2, int[] iArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{zArr, Integer.valueOf(i2), iArr, Boolean.valueOf(z)})) == null) {
            int i3 = 0;
            for (int i4 : iArr) {
                int i5 = 0;
                while (i5 < i4) {
                    zArr[i2] = z;
                    i5++;
                    i2++;
                }
                i3 += i4;
                z = !z;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static BitMatrix renderResult(boolean[] zArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65538, null, zArr, i2, i3, i4)) == null) {
            int length = zArr.length;
            int i5 = i4 + length;
            int max = Math.max(i2, i5);
            int max2 = Math.max(1, i3);
            int i6 = max / i5;
            int i7 = (max - (length * i6)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i8 = 0;
            while (i8 < length) {
                if (zArr[i8]) {
                    bitMatrix.setRegion(i7, 0, i6, max2);
                }
                i8++;
                i7 += i6;
            }
            return bitMatrix;
        }
        return (BitMatrix) invokeLIII.objValue;
    }

    @Override // com.google.zxing.Writer
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i2, i3)) == null) ? encode(str, barcodeFormat, i2, i3, null) : (BitMatrix) invokeLLII.objValue;
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 10;
        }
        return invokeV.intValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Found empty contents");
            }
            if (i2 >= 0 && i3 >= 0) {
                int defaultMargin = getDefaultMargin();
                if (map != null && map.containsKey(EncodeHintType.MARGIN)) {
                    defaultMargin = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                }
                return renderResult(encode(str), i2, i3, defaultMargin);
            }
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
