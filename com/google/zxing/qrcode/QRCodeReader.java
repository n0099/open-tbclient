package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    protected final Decoder getDecoder() {
        return this.decoder;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        DecoderResult decode;
        ResultPoint[] points;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            decode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            points = NO_POINTS;
        } else {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            decode = this.decoder.decode(detect.getBits(), map);
            points = detect.getPoints();
        }
        Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
        List<byte[]> byteSegments = decode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
        }
        int round = Math.round(((i4 - i3) + 1) / moduleSize);
        int round2 = Math.round(((i2 - i) + 1) / moduleSize);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = (int) (moduleSize / 2.0f);
        int i6 = i + i5;
        int i7 = i3 + i5;
        int i8 = (((int) ((round - 1) * moduleSize)) + i7) - (i4 - 1);
        int i9 = i8 > 0 ? i7 - i8 : i7;
        int i10 = (((int) ((round2 - 1) * moduleSize)) + i6) - (i2 - 1);
        int i11 = i10 > 0 ? i6 - i10 : i6;
        BitMatrix bitMatrix2 = new BitMatrix(round, round2);
        for (int i12 = 0; i12 < round2; i12++) {
            int i13 = i11 + ((int) (i12 * moduleSize));
            for (int i14 = 0; i14 < round; i14++) {
                if (bitMatrix.get(((int) (i14 * moduleSize)) + i9, i13)) {
                    bitMatrix2.set(i14, i12);
                }
            }
        }
        return bitMatrix2;
    }

    private static float moduleSize(int[] iArr, BitMatrix bitMatrix) {
        boolean z;
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        boolean z2 = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < width && i2 < height) {
            if (z2 != bitMatrix.get(i3, i2)) {
                int i5 = i4 + 1;
                if (i5 == 5) {
                    break;
                }
                z = !z2;
                i4 = i5;
            } else {
                z = z2;
            }
            i3++;
            i2++;
            z2 = z;
        }
        if (i3 == width || i2 == height) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i3 - iArr[0]) / 7.0f;
    }
}
