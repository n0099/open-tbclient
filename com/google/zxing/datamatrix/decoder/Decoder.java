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
/* loaded from: classes5.dex */
public final class Decoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReedSolomonDecoder rsDecoder;

    public Decoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);
    }

    private void correctErrors(byte[] bArr, int i) throws ChecksumException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, bArr, i) == null) {
            int length = bArr.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = bArr[i2] & 255;
            }
            try {
                this.rsDecoder.decode(iArr, bArr.length - i);
                for (int i3 = 0; i3 < i; i3++) {
                    bArr[i3] = (byte) iArr[i3];
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
            for (int i = 0; i < length; i++) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (zArr[i][i2]) {
                        bitMatrix.set(i2, i);
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
            int i = 0;
            for (DataBlock dataBlock : dataBlocks) {
                i += dataBlock.getNumDataCodewords();
            }
            byte[] bArr = new byte[i];
            int length = dataBlocks.length;
            for (int i2 = 0; i2 < length; i2++) {
                DataBlock dataBlock2 = dataBlocks[i2];
                byte[] codewords = dataBlock2.getCodewords();
                int numDataCodewords = dataBlock2.getNumDataCodewords();
                correctErrors(codewords, numDataCodewords);
                for (int i3 = 0; i3 < numDataCodewords; i3++) {
                    bArr[(i3 * length) + i2] = codewords[i3];
                }
            }
            return DecodedBitStreamParser.decode(bArr);
        }
        return (DecoderResult) invokeL.objValue;
    }
}
