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
/* loaded from: classes5.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OneDimensionalCodeWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{zArr, Integer.valueOf(i), iArr, Boolean.valueOf(z)})) == null) {
            int i2 = 0;
            for (int i3 : iArr) {
                int i4 = 0;
                while (i4 < i3) {
                    zArr[i] = z;
                    i4++;
                    i++;
                }
                i2 += i3;
                z = !z;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static BitMatrix renderResult(boolean[] zArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65538, null, zArr, i, i2, i3)) == null) {
            int length = zArr.length;
            int i4 = i3 + length;
            int max = Math.max(i, i4);
            int max2 = Math.max(1, i2);
            int i5 = max / i4;
            int i6 = (max - (length * i5)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i7 = 0;
            while (i7 < length) {
                if (zArr[i7]) {
                    bitMatrix.setRegion(i6, 0, i5, max2);
                }
                i7++;
                i6 += i5;
            }
            return bitMatrix;
        }
        return (BitMatrix) invokeLIII.objValue;
    }

    @Override // com.google.zxing.Writer
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i, i2)) == null) ? encode(str, barcodeFormat, i, i2, null) : (BitMatrix) invokeLLII.objValue;
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
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Found empty contents");
            }
            if (i >= 0 && i2 >= 0) {
                int defaultMargin = getDefaultMargin();
                if (map != null && map.containsKey(EncodeHintType.MARGIN)) {
                    defaultMargin = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                }
                return renderResult(encode(str), i, i2, defaultMargin);
            }
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
