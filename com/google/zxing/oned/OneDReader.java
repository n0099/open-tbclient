package com.google.zxing.oned;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            if ((map != null && map.containsKey(DecodeHintType.TRY_HARDER)) && binaryBitmap.isRotateSupported()) {
                BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
                Result doDecode = doDecode(rotateCounterClockwise, map);
                Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
                int i = 270;
                if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                    i = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % EncoderTextureDrawer.X264_WIDTH;
                }
                doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
                ResultPoint[] resultPoints = doDecode.getResultPoints();
                if (resultPoints != null) {
                    int height = rotateCounterClockwise.getHeight();
                    for (int i2 = 0; i2 < resultPoints.length; i2++) {
                        resultPoints[i2] = new ResultPoint((height - resultPoints[i2].getY()) - 1.0f, resultPoints[i2].getX());
                    }
                }
                return doDecode;
            }
            throw e;
        }
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0076 A[Catch: ReaderException -> 0x00d7, TryCatch #1 {ReaderException -> 0x00d7, blocks: (B:33:0x006d, B:35:0x0076, B:37:0x0087), top: B:53:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        Map<DecodeHintType, ?> map2;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i = height >> 1;
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, height >> (z ? 8 : 5));
        int i2 = z ? height : 15;
        BitArray bitArray2 = bitArray;
        Map<DecodeHintType, ?> map3 = map;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (i3 + 1) / 2;
            if (!((i3 & 1) == 0)) {
                i4 = -i4;
            }
            int i5 = i + (i4 * max);
            if (i5 < 0 || i5 >= height) {
                break;
            }
            try {
                bitArray2 = binaryBitmap.getBlackRow(i5, bitArray2);
                int i6 = 0;
                while (i6 < 2) {
                    try {
                        if (i6 == 1) {
                            bitArray2.reverse();
                            if (map3 != null && map3.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                                map2 = new EnumMap<>(DecodeHintType.class);
                                map2.putAll(map3);
                                map2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                                Result decodeRow = decodeRow(i5, bitArray2, map2);
                                if (i6 != 1) {
                                    decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                    ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                    if (resultPoints != null) {
                                        resultPoints[0] = new ResultPoint((width - resultPoints[0].getX()) - 1.0f, resultPoints[0].getY());
                                        resultPoints[1] = new ResultPoint((width - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                    }
                                }
                                return decodeRow;
                            }
                        }
                        Result decodeRow2 = decodeRow(i5, bitArray2, map2);
                        if (i6 != 1) {
                        }
                        return decodeRow2;
                    } catch (ReaderException e) {
                        i6++;
                        map3 = map2;
                    }
                    map2 = map3;
                }
                continue;
            } catch (NotFoundException e2) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int i2;
        boolean z;
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z2 = !bitArray.get(i);
        int i3 = 0;
        while (true) {
            if (i >= size) {
                i2 = i3;
                break;
            }
            if (bitArray.get(i) ^ z2) {
                iArr[i3] = iArr[i3] + 1;
                z = z2;
            } else {
                i2 = i3 + 1;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z2;
                i3 = i2;
            }
            i++;
            z2 = z;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += iArr[i3];
            i += iArr2[i3];
        }
        if (i2 < i) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i2 / i;
        float f3 = f * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f5 = iArr2[i4] * f2;
            float f6 = ((float) i5) > f5 ? i5 - f5 : f5 - i5;
            if (f6 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
        }
        return f4 / i2;
    }
}
