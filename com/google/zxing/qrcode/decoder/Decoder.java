package com.google.zxing.qrcode.decoder;

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
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);
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

    public DecoderResult decode(boolean[][] zArr) throws ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zArr)) == null) ? decode(zArr, (Map<DecodeHintType, ?>) null) : (DecoderResult) invokeL.objValue;
    }

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, zArr, map)) == null) {
            int length = zArr.length;
            BitMatrix bitMatrix = new BitMatrix(length);
            for (int i2 = 0; i2 < length; i2++) {
                for (int i3 = 0; i3 < length; i3++) {
                    if (zArr[i2][i3]) {
                        bitMatrix.set(i3, i2);
                    }
                }
            }
            return decode(bitMatrix, map);
        }
        return (DecoderResult) invokeLL.objValue;
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitMatrix)) == null) ? decode(bitMatrix, (Map<DecodeHintType, ?>) null) : (DecoderResult) invokeL.objValue;
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        InterceptResult invokeLL;
        ChecksumException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitMatrix, map)) == null) {
            BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
            FormatException formatException = null;
            try {
                return decode(bitMatrixParser, map);
            } catch (ChecksumException e3) {
                e2 = e3;
                try {
                    bitMatrixParser.remask();
                    bitMatrixParser.setMirror(true);
                    bitMatrixParser.readVersion();
                    bitMatrixParser.readFormatInformation();
                    bitMatrixParser.mirror();
                    DecoderResult decode = decode(bitMatrixParser, map);
                    decode.setOther(new QRCodeDecoderMetaData(true));
                    return decode;
                } catch (ChecksumException | FormatException e4) {
                    if (formatException == null) {
                        if (e2 != null) {
                            throw e2;
                        }
                        throw e4;
                    }
                    throw formatException;
                }
            } catch (FormatException e5) {
                e2 = null;
                formatException = e5;
                bitMatrixParser.remask();
                bitMatrixParser.setMirror(true);
                bitMatrixParser.readVersion();
                bitMatrixParser.readFormatInformation();
                bitMatrixParser.mirror();
                DecoderResult decode2 = decode(bitMatrixParser, map);
                decode2.setOther(new QRCodeDecoderMetaData(true));
                return decode2;
            }
        }
        return (DecoderResult) invokeLL.objValue;
    }

    private DecoderResult decode(BitMatrixParser bitMatrixParser, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, bitMatrixParser, map)) == null) {
            Version readVersion = bitMatrixParser.readVersion();
            ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser.readFormatInformation().getErrorCorrectionLevel();
            DataBlock[] dataBlocks = DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), readVersion, errorCorrectionLevel);
            int i2 = 0;
            for (DataBlock dataBlock : dataBlocks) {
                i2 += dataBlock.getNumDataCodewords();
            }
            byte[] bArr = new byte[i2];
            int i3 = 0;
            for (DataBlock dataBlock2 : dataBlocks) {
                byte[] codewords = dataBlock2.getCodewords();
                int numDataCodewords = dataBlock2.getNumDataCodewords();
                correctErrors(codewords, numDataCodewords);
                int i4 = 0;
                while (i4 < numDataCodewords) {
                    bArr[i3] = codewords[i4];
                    i4++;
                    i3++;
                }
            }
            return DecodedBitStreamParser.decode(bArr, readVersion, errorCorrectionLevel, map);
        }
        return (DecoderResult) invokeLL.objValue;
    }
}
