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
/* loaded from: classes8.dex */
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
        this.rsDecoder = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);
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

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, zArr, map)) == null) {
            int length = zArr.length;
            BitMatrix bitMatrix = new BitMatrix(length);
            for (int i = 0; i < length; i++) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (zArr[i][i2]) {
                        bitMatrix.set(i2, i);
                    }
                }
            }
            return decode(bitMatrix, map);
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
            int i = 0;
            for (DataBlock dataBlock : dataBlocks) {
                i += dataBlock.getNumDataCodewords();
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (DataBlock dataBlock2 : dataBlocks) {
                byte[] codewords = dataBlock2.getCodewords();
                int numDataCodewords = dataBlock2.getNumDataCodewords();
                correctErrors(codewords, numDataCodewords);
                int i3 = 0;
                while (i3 < numDataCodewords) {
                    bArr[i2] = codewords[i3];
                    i3++;
                    i2++;
                }
            }
            return DecodedBitStreamParser.decode(bArr, readVersion, errorCorrectionLevel, map);
        }
        return (DecoderResult) invokeLL.objValue;
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitMatrix)) == null) {
            return decode(bitMatrix, (Map<DecodeHintType, ?>) null);
        }
        return (DecoderResult) invokeL.objValue;
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        InterceptResult invokeLL;
        ChecksumException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitMatrix, map)) == null) {
            BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
            FormatException formatException = null;
            try {
                return decode(bitMatrixParser, map);
            } catch (ChecksumException e2) {
                e = e2;
                try {
                    bitMatrixParser.remask();
                    bitMatrixParser.setMirror(true);
                    bitMatrixParser.readVersion();
                    bitMatrixParser.readFormatInformation();
                    bitMatrixParser.mirror();
                    DecoderResult decode = decode(bitMatrixParser, map);
                    decode.setOther(new QRCodeDecoderMetaData(true));
                    return decode;
                } catch (ChecksumException | FormatException e3) {
                    if (formatException == null) {
                        if (e != null) {
                            throw e;
                        }
                        throw e3;
                    }
                    throw formatException;
                }
            } catch (FormatException e4) {
                e = null;
                formatException = e4;
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

    public DecoderResult decode(boolean[][] zArr) throws ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zArr)) == null) {
            return decode(zArr, (Map<DecodeHintType, ?>) null);
        }
        return (DecoderResult) invokeL.objValue;
    }
}
