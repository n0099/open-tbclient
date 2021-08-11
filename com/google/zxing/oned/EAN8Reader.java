package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes10.dex */
public final class EAN8Reader extends UPCEANReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] decodeMiddleCounters;

    public EAN8Reader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.decodeMiddleCounters = new int[4];
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, bitArray, iArr, sb)) == null) {
            int[] iArr2 = this.decodeMiddleCounters;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int size = bitArray.getSize();
            int i2 = iArr[1];
            for (int i3 = 0; i3 < 4 && i2 < size; i3++) {
                sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i2, UPCEANReader.L_PATTERNS) + 48));
                for (int i4 : iArr2) {
                    i2 += i4;
                }
            }
            int i5 = UPCEANReader.findGuardPattern(bitArray, i2, true, UPCEANReader.MIDDLE_PATTERN)[1];
            for (int i6 = 0; i6 < 4 && i5 < size; i6++) {
                sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i5, UPCEANReader.L_PATTERNS) + 48));
                for (int i7 : iArr2) {
                    i5 += i7;
                }
            }
            return i5;
        }
        return invokeLLL.intValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BarcodeFormat.EAN_8 : (BarcodeFormat) invokeV.objValue;
    }
}
