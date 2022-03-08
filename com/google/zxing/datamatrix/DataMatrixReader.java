package com.google.zxing.datamatrix;

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
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class DataMatrixReader implements Reader {
    public static /* synthetic */ Interceptable $ic;
    public static final ResultPoint[] NO_POINTS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Decoder decoder;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1290661392, "Lcom/google/zxing/datamatrix/DataMatrixReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1290661392, "Lcom/google/zxing/datamatrix/DataMatrixReader;");
                return;
            }
        }
        NO_POINTS = new ResultPoint[0];
    }

    public DataMatrixReader() {
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
        this.decoder = new Decoder();
    }

    public static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitMatrix)) == null) {
            int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
            int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
            if (topLeftOnBit != null && bottomRightOnBit != null) {
                int moduleSize = moduleSize(topLeftOnBit, bitMatrix);
                int i2 = topLeftOnBit[1];
                int i3 = bottomRightOnBit[1];
                int i4 = topLeftOnBit[0];
                int i5 = ((bottomRightOnBit[0] - i4) + 1) / moduleSize;
                int i6 = ((i3 - i2) + 1) / moduleSize;
                if (i5 > 0 && i6 > 0) {
                    int i7 = moduleSize / 2;
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    BitMatrix bitMatrix2 = new BitMatrix(i5, i6);
                    for (int i10 = 0; i10 < i6; i10++) {
                        int i11 = (i10 * moduleSize) + i8;
                        for (int i12 = 0; i12 < i5; i12++) {
                            if (bitMatrix.get((i12 * moduleSize) + i9, i11)) {
                                bitMatrix2.set(i12, i10);
                            }
                        }
                    }
                    return bitMatrix2;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (BitMatrix) invokeL.objValue;
    }

    public static int moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, iArr, bitMatrix)) == null) {
            int width = bitMatrix.getWidth();
            int i2 = iArr[0];
            int i3 = iArr[1];
            while (i2 < width && bitMatrix.get(i2, i3)) {
                i2++;
            }
            if (i2 != width) {
                int i4 = i2 - iArr[0];
                if (i4 != 0) {
                    return i4;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLL.intValue;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) ? decode(binaryBitmap, null) : (Result) invokeL.objValue;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeLL;
        ResultPoint[] points;
        DecoderResult decoderResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
                decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()));
                points = NO_POINTS;
            } else {
                DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect();
                DecoderResult decode = this.decoder.decode(detect.getBits());
                points = detect.getPoints();
                decoderResult = decode;
            }
            Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), points, BarcodeFormat.DATA_MATRIX);
            List<byte[]> byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
                result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
            }
            String eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
            }
            return result;
        }
        return (Result) invokeLL.objValue;
    }
}
