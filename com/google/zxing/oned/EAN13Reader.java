package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes11.dex */
public final class EAN13Reader extends UPCEANReader {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] FIRST_DIGIT_ENCODINGS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] decodeMiddleCounters;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1018915730, "Lcom/google/zxing/oned/EAN13Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1018915730, "Lcom/google/zxing/oned/EAN13Reader;");
                return;
            }
        }
        FIRST_DIGIT_ENCODINGS = new int[]{0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    }

    public EAN13Reader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.decodeMiddleCounters = new int[4];
    }

    public static void determineFirstDigit(StringBuilder sb, int i2) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, sb, i2) == null) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i2 == FIRST_DIGIT_ENCODINGS[i3]) {
                    sb.insert(0, (char) (i3 + 48));
                    return;
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
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
            int i3 = 0;
            for (int i4 = 0; i4 < 6 && i2 < size; i4++) {
                int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i2, UPCEANReader.L_AND_G_PATTERNS);
                sb.append((char) ((decodeDigit % 10) + 48));
                for (int i5 : iArr2) {
                    i2 += i5;
                }
                if (decodeDigit >= 10) {
                    i3 |= 1 << (5 - i4);
                }
            }
            determineFirstDigit(sb, i3);
            int i6 = UPCEANReader.findGuardPattern(bitArray, i2, true, UPCEANReader.MIDDLE_PATTERN)[1];
            for (int i7 = 0; i7 < 6 && i6 < size; i7++) {
                sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i6, UPCEANReader.L_PATTERNS) + 48));
                for (int i8 : iArr2) {
                    i6 += i8;
                }
            }
            return i6;
        }
        return invokeLLL.intValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BarcodeFormat.EAN_13 : (BarcodeFormat) invokeV.objValue;
    }
}
