package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    public static final int MAX_DEPTH = 4;
    public static final int MIN_DIMENSION_TO_RECUR = 100;
    public final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        boolean z;
        float f2;
        float f3;
        int i4;
        int i5;
        if (i3 > 4) {
            return;
        }
        try {
            Result decode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getText().equals(decode.getText())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(translateResultPoints(decode, i, i2));
            }
            ResultPoint[] resultPoints = decode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f4 = width;
            float f5 = height;
            float f6 = 0.0f;
            float f7 = 0.0f;
            for (ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    float x = resultPoint.getX();
                    float y = resultPoint.getY();
                    if (x < f4) {
                        f4 = x;
                    }
                    if (y < f5) {
                        f5 = y;
                    }
                    if (x > f6) {
                        f6 = x;
                    }
                    if (y > f7) {
                        f7 = y;
                    }
                }
            }
            if (f4 > 100.0f) {
                f2 = f6;
                f3 = f5;
                i4 = height;
                i5 = width;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f4, height), map, list, i, i2, i3 + 1);
            } else {
                f2 = f6;
                f3 = f5;
                i4 = height;
                i5 = width;
            }
            if (f3 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, i5, (int) f3), map, list, i, i2, i3 + 1);
            }
            float f8 = f2;
            if (f8 < i5 - 100) {
                int i6 = (int) f8;
                doDecodeMultiple(binaryBitmap.crop(i6, 0, i5 - i6, i4), map, list, i + i6, i2, i3 + 1);
            }
            if (f7 < i4 - 100) {
                int i7 = (int) f7;
                doDecodeMultiple(binaryBitmap.crop(0, i7, i5, i4 - i7), map, list, i, i2 + i7, i3 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    public static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
