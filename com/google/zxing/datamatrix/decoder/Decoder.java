package com.google.zxing.datamatrix.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
/* loaded from: classes11.dex */
public final class Decoder {
    public static /* synthetic */ Interceptable $ic;
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
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);
    }

    private void correctErrors(byte[] bArr, int i2) throws ChecksumException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, bArr, i2) == null) {
            int length = bArr.length;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = bArr[i3] & 255;
            }
            try {
                this.rsDecoder.decode(iArr, bArr.length - i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    bArr[i4] = (byte) iArr[i4];
                }
            } catch (ReedSolomonException unused) {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public DecoderResult decode(boolean[][] zArr) throws FormatException, ChecksumException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zArr)) == null) {
            int length = zArr.length;
            BitMatrix bitMatrix = new BitMatrix(length);
            for (int i2 = 0; i2 < length; i2++) {
                for (int i3 = 0; i3 < length; i3++) {
                    if (zArr[i2][i3]) {
                        bitMatrix.set(i3, i2);
                    }
                }
            }
            return decode(bitMatrix);
        }
        return (DecoderResult) invokeL.objValue;
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws FormatException, ChecksumException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitMatrix)) == null) {
            BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
            DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), bitMatrixParser.getVersion());
            int i2 = 0;
            for (DataBlock dataBlock : dataBlocks) {
                i2 += dataBlock.getNumDataCodewords();
            }
            byte[] bArr = new byte[i2];
            int length = dataBlocks.length;
            for (int i3 = 0; i3 < length; i3++) {
                DataBlock dataBlock2 = dataBlocks[i3];
                byte[] codewords = dataBlock2.getCodewords();
                int numDataCodewords = dataBlock2.getNumDataCodewords();
                correctErrors(codewords, numDataCodewords);
                for (int i4 = 0; i4 < numDataCodewords; i4++) {
                    bArr[(i4 * length) + i3] = codewords[i4];
                }
            }
            return DecodedBitStreamParser.decode(bArr);
        }
        return (DecoderResult) invokeL.objValue;
    }
}
