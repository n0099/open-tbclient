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
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
/* loaded from: classes7.dex */
public final class UPCEReader extends UPCEANReader {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] CHECK_DIGIT_ENCODINGS;
    public static final int[] MIDDLE_END_PATTERN;
    public static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] decodeMiddleCounters;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-203135087, "Lcom/google/zxing/oned/UPCEReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-203135087, "Lcom/google/zxing/oned/UPCEReader;");
                return;
            }
        }
        CHECK_DIGIT_ENCODINGS = new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37};
        MIDDLE_END_PATTERN = new int[]{1, 1, 1, 1, 1, 1};
        NUMSYS_AND_CHECK_DIGIT_PATTERNS = new int[][]{new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    }

    public UPCEReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.decodeMiddleCounters = new int[4];
    }

    public static String convertUPCEtoUPCA(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            char[] cArr = new char[6];
            str.getChars(1, 7, cArr, 0);
            StringBuilder sb = new StringBuilder(12);
            sb.append(str.charAt(0));
            char c = cArr[5];
            switch (c) {
                case '0':
                case '1':
                case '2':
                    sb.append(cArr, 0, 2);
                    sb.append(c);
                    sb.append("0000");
                    sb.append(cArr, 2, 3);
                    break;
                case '3':
                    sb.append(cArr, 0, 3);
                    sb.append("00000");
                    sb.append(cArr, 3, 2);
                    break;
                case '4':
                    sb.append(cArr, 0, 4);
                    sb.append("00000");
                    sb.append(cArr[4]);
                    break;
                default:
                    sb.append(cArr, 0, 5);
                    sb.append("0000");
                    sb.append(c);
                    break;
            }
            sb.append(str.charAt(7));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void determineNumSysAndCheckDigit(StringBuilder sb, int i) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, sb, i) == null) {
            for (int i2 = 0; i2 <= 1; i2++) {
                for (int i3 = 0; i3 < 10; i3++) {
                    if (i == NUMSYS_AND_CHECK_DIGIT_PATTERNS[i2][i3]) {
                        sb.insert(0, (char) (i2 + 48));
                        sb.append((char) (i3 + 48));
                        return;
                    }
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public boolean checkChecksum(String str) throws FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.checkChecksum(convertUPCEtoUPCA(str)) : invokeL.booleanValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int[] decodeEnd(BitArray bitArray, int i) throws NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitArray, i)) == null) ? UPCEANReader.findGuardPattern(bitArray, i, true, MIDDLE_END_PATTERN) : (int[]) invokeLI.objValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bitArray, iArr, sb)) == null) {
            int[] iArr2 = this.decodeMiddleCounters;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int size = bitArray.getSize();
            int i = iArr[1];
            int i2 = 0;
            for (int i3 = 0; i3 < 6 && i < size; i3++) {
                int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i, UPCEANReader.L_AND_G_PATTERNS);
                sb.append((char) ((decodeDigit % 10) + 48));
                for (int i4 : iArr2) {
                    i += i4;
                }
                if (decodeDigit >= 10) {
                    i2 |= 1 << (5 - i3);
                }
            }
            determineNumSysAndCheckDigit(sb, i2);
            return i;
        }
        return invokeLLL.intValue;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BarcodeFormat.UPC_E : (BarcodeFormat) invokeV.objValue;
    }
}
