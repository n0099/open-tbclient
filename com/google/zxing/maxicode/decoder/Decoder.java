package com.google.zxing.maxicode.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;
/* loaded from: classes7.dex */
public final class Decoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL = 0;
    public static final int EVEN = 1;
    public static final int ODD = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReedSolomonDecoder rsDecoder;

    public Decoder() {
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
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);
    }

    private void correctErrors(byte[] bArr, int i2, int i3, int i4, int i5) throws ChecksumException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = i3 + i4;
            int i7 = i5 == 0 ? 1 : 2;
            int[] iArr = new int[i6 / i7];
            for (int i8 = 0; i8 < i6; i8++) {
                if (i5 == 0 || i8 % 2 == i5 - 1) {
                    iArr[i8 / i7] = bArr[i8 + i2] & 255;
                }
            }
            try {
                this.rsDecoder.decode(iArr, i4 / i7);
                for (int i9 = 0; i9 < i3; i9++) {
                    if (i5 == 0 || i9 % 2 == i5 - 1) {
                        bArr[i9 + i2] = (byte) iArr[i9 / i7];
                    }
                }
            } catch (ReedSolomonException unused) {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitMatrix)) == null) ? decode(bitMatrix, null) : (DecoderResult) invokeL.objValue;
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitMatrix, map)) == null) {
            byte[] readCodewords = new BitMatrixParser(bitMatrix).readCodewords();
            correctErrors(readCodewords, 0, 10, 10, 0);
            int i2 = readCodewords[0] & 15;
            if (i2 == 2 || i2 == 3 || i2 == 4) {
                correctErrors(readCodewords, 20, 84, 40, 1);
                correctErrors(readCodewords, 20, 84, 40, 2);
                bArr = new byte[94];
            } else if (i2 == 5) {
                correctErrors(readCodewords, 20, 68, 56, 1);
                correctErrors(readCodewords, 20, 68, 56, 2);
                bArr = new byte[78];
            } else {
                throw FormatException.getFormatInstance();
            }
            System.arraycopy(readCodewords, 0, bArr, 0, 10);
            System.arraycopy(readCodewords, 20, bArr, 10, bArr.length - 10);
            return DecodedBitStreamParser.decode(bArr, i2);
        }
        return (DecoderResult) invokeLL.objValue;
    }
}
