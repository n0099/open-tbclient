package com.google.zxing.aztec;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class AztecReader implements Reader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AztecReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062 A[LOOP:0: B:35:0x0060->B:36:0x0062, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    @Override // com.google.zxing.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        InterceptResult invokeLL;
        ResultPoint[] resultPointArr;
        ResultPoint[] resultPointArr2;
        FormatException formatException;
        ResultPoint[] resultPointArr3;
        List<byte[]> byteSegments;
        String eCLevel;
        ResultPointCallback resultPointCallback;
        AztecDetectorResult detect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            Detector detector = new Detector(binaryBitmap.getBlackMatrix());
            DecoderResult decoderResult = null;
            try {
                detect = detector.detect(false);
                resultPointArr = detect.getPoints();
            } catch (FormatException e2) {
                e = e2;
                resultPointArr = null;
            } catch (NotFoundException e3) {
                e = e3;
                resultPointArr = null;
            }
            try {
                resultPointArr2 = resultPointArr;
                formatException = null;
                decoderResult = new Decoder().decode(detect);
                e = null;
            } catch (FormatException e4) {
                e = e4;
                resultPointArr2 = resultPointArr;
                formatException = e;
                e = null;
                if (decoderResult == null) {
                }
                resultPointArr3 = resultPointArr2;
                if (map != null) {
                    while (r11 < r0) {
                    }
                }
                Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                }
                return result;
            } catch (NotFoundException e5) {
                e = e5;
                resultPointArr2 = resultPointArr;
                formatException = null;
                if (decoderResult == null) {
                }
                resultPointArr3 = resultPointArr2;
                if (map != null) {
                }
                Result result2 = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                }
                return result2;
            }
            if (decoderResult == null) {
                try {
                    AztecDetectorResult detect2 = detector.detect(true);
                    resultPointArr2 = detect2.getPoints();
                    decoderResult = new Decoder().decode(detect2);
                } catch (FormatException | NotFoundException e6) {
                    if (e == null) {
                        if (formatException != null) {
                            throw formatException;
                        }
                        throw e6;
                    }
                    throw e;
                }
            }
            resultPointArr3 = resultPointArr2;
            if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
                for (ResultPoint resultPoint : resultPointArr3) {
                    resultPointCallback.foundPossibleResultPoint(resultPoint);
                }
            }
            Result result22 = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
                result22.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
                result22.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
            }
            return result22;
        }
        return (Result) invokeLL.objValue;
    }
}
