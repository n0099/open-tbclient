package com.google.zxing.aztec;

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
/* loaded from: classes5.dex */
public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[LOOP:0: B:14:0x0042->B:15:0x0044, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    @Override // com.google.zxing.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        ResultPoint[] resultPointArr2;
        NotFoundException notFoundException;
        DecoderResult decoderResult;
        DecoderResult decoderResult2;
        List<byte[]> byteSegments;
        String eCLevel;
        ResultPointCallback resultPointCallback;
        FormatException formatException = null;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        try {
            AztecDetectorResult detect = detector.detect(false);
            resultPointArr = detect.getPoints();
            try {
                decoderResult = new Decoder().decode(detect);
                resultPointArr2 = resultPointArr;
                notFoundException = null;
            } catch (FormatException e) {
                e = e;
                resultPointArr2 = resultPointArr;
                notFoundException = null;
                FormatException formatException2 = e;
                decoderResult = null;
                formatException = formatException2;
                if (decoderResult == null) {
                }
                if (map != null) {
                    while (r1 < r2) {
                    }
                }
                Result result = new Result(decoderResult2.getText(), decoderResult2.getRawBytes(), decoderResult2.getNumBits(), resultPointArr2, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult2.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult2.getECLevel();
                if (eCLevel != null) {
                }
                return result;
            } catch (NotFoundException e2) {
                e = e2;
                resultPointArr2 = resultPointArr;
                notFoundException = e;
                decoderResult = null;
                if (decoderResult == null) {
                }
                if (map != null) {
                }
                Result result2 = new Result(decoderResult2.getText(), decoderResult2.getRawBytes(), decoderResult2.getNumBits(), resultPointArr2, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult2.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult2.getECLevel();
                if (eCLevel != null) {
                }
                return result2;
            }
        } catch (FormatException e3) {
            e = e3;
            resultPointArr = null;
        } catch (NotFoundException e4) {
            e = e4;
            resultPointArr = null;
        }
        if (decoderResult == null) {
            try {
                AztecDetectorResult detect2 = detector.detect(true);
                resultPointArr2 = detect2.getPoints();
                decoderResult2 = new Decoder().decode(detect2);
            } catch (FormatException | NotFoundException e5) {
                if (notFoundException != null) {
                    throw notFoundException;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        } else {
            decoderResult2 = decoderResult;
        }
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (ResultPoint resultPoint : resultPointArr2) {
                resultPointCallback.foundPossibleResultPoint(resultPoint);
            }
        }
        Result result22 = new Result(decoderResult2.getText(), decoderResult2.getRawBytes(), decoderResult2.getNumBits(), resultPointArr2, BarcodeFormat.AZTEC, System.currentTimeMillis());
        byteSegments = decoderResult2.getByteSegments();
        if (byteSegments != null) {
            result22.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        eCLevel = decoderResult2.getECLevel();
        if (eCLevel != null) {
            result22.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result22;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
