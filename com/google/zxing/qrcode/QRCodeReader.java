package com.google.zxing.qrcode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class QRCodeReader implements Reader {
    public static /* synthetic */ Interceptable $ic;
    public static final ResultPoint[] NO_POINTS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Decoder decoder;

    @Override // com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592522608, "Lcom/google/zxing/qrcode/QRCodeReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592522608, "Lcom/google/zxing/qrcode/QRCodeReader;");
                return;
            }
        }
        NO_POINTS = new ResultPoint[0];
    }

    public QRCodeReader() {
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
        this.decoder = new Decoder();
    }

    public final Decoder getDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.decoder;
        }
        return (Decoder) invokeV.objValue;
    }

    public static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitMatrix)) == null) {
            int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
            int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
            if (topLeftOnBit != null && bottomRightOnBit != null) {
                float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
                int i = topLeftOnBit[1];
                int i2 = bottomRightOnBit[1];
                int i3 = topLeftOnBit[0];
                int i4 = bottomRightOnBit[0];
                if (i3 < i4 && i < i2) {
                    int i5 = i2 - i;
                    if (i5 != i4 - i3 && (i4 = i3 + i5) >= bitMatrix.getWidth()) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    int round = Math.round(((i4 - i3) + 1) / moduleSize);
                    int round2 = Math.round((i5 + 1) / moduleSize);
                    if (round > 0 && round2 > 0) {
                        if (round2 == round) {
                            int i6 = (int) (moduleSize / 2.0f);
                            int i7 = i + i6;
                            int i8 = i3 + i6;
                            int i9 = (((int) ((round - 1) * moduleSize)) + i8) - i4;
                            if (i9 > 0) {
                                if (i9 <= i6) {
                                    i8 -= i9;
                                } else {
                                    throw NotFoundException.getNotFoundInstance();
                                }
                            }
                            int i10 = (((int) ((round2 - 1) * moduleSize)) + i7) - i2;
                            if (i10 > 0) {
                                if (i10 <= i6) {
                                    i7 -= i10;
                                } else {
                                    throw NotFoundException.getNotFoundInstance();
                                }
                            }
                            BitMatrix bitMatrix2 = new BitMatrix(round, round2);
                            for (int i11 = 0; i11 < round2; i11++) {
                                int i12 = ((int) (i11 * moduleSize)) + i7;
                                for (int i13 = 0; i13 < round; i13++) {
                                    if (bitMatrix.get(((int) (i13 * moduleSize)) + i8, i12)) {
                                        bitMatrix2.set(i13, i11);
                                    }
                                }
                            }
                            return bitMatrix2;
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (BitMatrix) invokeL.objValue;
    }

    public static float moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, iArr, bitMatrix)) == null) {
            int height = bitMatrix.getHeight();
            int width = bitMatrix.getWidth();
            int i = iArr[0];
            boolean z = true;
            int i2 = iArr[1];
            int i3 = 0;
            while (i < width && i2 < height) {
                if (z != bitMatrix.get(i, i2)) {
                    i3++;
                    if (i3 == 5) {
                        break;
                    }
                    z = !z;
                }
                i++;
                i2++;
            }
            if (i != width && i2 != height) {
                return (i - iArr[0]) / 7.0f;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLL.floatValue;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) {
            return decode(binaryBitmap, null);
        }
        return (Result) invokeL.objValue;
    }

    @Override // com.google.zxing.Reader
    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeLL;
        ResultPoint[] points;
        DecoderResult decoderResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
                decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
                points = NO_POINTS;
            } else {
                DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
                DecoderResult decode = this.decoder.decode(detect.getBits(), map);
                points = detect.getPoints();
                decoderResult = decode;
            }
            if (decoderResult.getOther() instanceof QRCodeDecoderMetaData) {
                ((QRCodeDecoderMetaData) decoderResult.getOther()).applyMirroredCorrection(points);
            }
            Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), points, BarcodeFormat.QR_CODE);
            List<byte[]> byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
                result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
            }
            String eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
            }
            if (decoderResult.hasStructuredAppend()) {
                result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResult.getStructuredAppendSequenceNumber()));
                result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResult.getStructuredAppendParity()));
            }
            return result;
        }
        return (Result) invokeLL.objValue;
    }
}
