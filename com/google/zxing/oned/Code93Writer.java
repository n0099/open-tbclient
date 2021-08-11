package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
/* loaded from: classes10.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Code93Writer() {
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
            int length = iArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i2 + 1;
                zArr[i2] = iArr[i3] != 0;
                i3++;
                i2 = i4;
            }
            return 9;
        }
        return invokeCommon.intValue;
    }

    public static int computeChecksumIndex(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            int i3 = 0;
            int i4 = 1;
            for (int length = str.length() - 1; length >= 0; length--) {
                i3 += Code93Reader.ALPHABET_STRING.indexOf(str.charAt(length)) * i4;
                i4++;
                if (i4 > i2) {
                    i4 = 1;
                }
            }
            return i3 % 47;
        }
        return invokeLI.intValue;
    }

    public static void toIntArray(int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i2, iArr) == null) {
            for (int i3 = 0; i3 < 9; i3++) {
                int i4 = 1;
                if (((1 << (8 - i3)) & i2) == 0) {
                    i4 = 0;
                }
                iArr[i3] = i4;
            }
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            if (barcodeFormat == BarcodeFormat.CODE_93) {
                return super.encode(str, barcodeFormat, i2, i3, map);
            }
            throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int length = str.length();
            if (length <= 80) {
                int[] iArr = new int[9];
                boolean[] zArr = new boolean[((str.length() + 2 + 2) * 9) + 1];
                toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
                int appendPattern = appendPattern(zArr, 0, iArr, true);
                for (int i2 = 0; i2 < length; i2++) {
                    toIntArray(Code93Reader.CHARACTER_ENCODINGS[Code93Reader.ALPHABET_STRING.indexOf(str.charAt(i2))], iArr);
                    appendPattern += appendPattern(zArr, appendPattern, iArr, true);
                }
                int computeChecksumIndex = computeChecksumIndex(str, 20);
                toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex], iArr);
                int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, iArr, true);
                toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(str + Code93Reader.ALPHABET_STRING.charAt(computeChecksumIndex), 15)], iArr);
                int appendPattern3 = appendPattern2 + appendPattern(zArr, appendPattern2, iArr, true);
                toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
                zArr[appendPattern3 + appendPattern(zArr, appendPattern3, iArr, true)] = true;
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        return (boolean[]) invokeL.objValue;
    }
}
