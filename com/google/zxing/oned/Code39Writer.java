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
/* loaded from: classes3.dex */
public final class Code39Writer extends OneDimensionalCodeWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Code39Writer() {
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

    public static void toIntArray(int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i2, iArr) == null) {
            for (int i3 = 0; i3 < 9; i3++) {
                int i4 = 1;
                if (((1 << (8 - i3)) & i2) != 0) {
                    i4 = 2;
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
            if (barcodeFormat == BarcodeFormat.CODE_39) {
                return super.encode(str, barcodeFormat, i2, i3, map);
            }
            throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
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
                int i2 = length + 25;
                for (int i3 = 0; i3 < length; i3++) {
                    int indexOf = Code39Reader.ALPHABET_STRING.indexOf(str.charAt(i3));
                    if (indexOf >= 0) {
                        toIntArray(Code39Reader.CHARACTER_ENCODINGS[indexOf], iArr);
                        for (int i4 = 0; i4 < 9; i4++) {
                            i2 += iArr[i4];
                        }
                    } else {
                        throw new IllegalArgumentException("Bad contents: " + str);
                    }
                }
                boolean[] zArr = new boolean[i2];
                toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
                int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
                int[] iArr2 = {1};
                int appendPattern2 = appendPattern + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr2, false);
                for (int i5 = 0; i5 < length; i5++) {
                    toIntArray(Code39Reader.CHARACTER_ENCODINGS[Code39Reader.ALPHABET_STRING.indexOf(str.charAt(i5))], iArr);
                    int appendPattern3 = appendPattern2 + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true);
                    appendPattern2 = appendPattern3 + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern3, iArr2, false);
                }
                toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
                OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true);
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        return (boolean[]) invokeL.objValue;
    }
}
