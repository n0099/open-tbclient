package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes3.dex */
public final class AztecWriter implements Writer {
    private static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        int i3;
        Charset charset;
        Charset charset2 = DEFAULT_CHARSET;
        int i4 = 33;
        int i5 = 0;
        if (map != null) {
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
            }
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                i4 = Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                i5 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                i3 = i4;
                charset = charset2;
                return encode(str, barcodeFormat, i, i2, charset, i3, i5);
            }
        }
        i3 = i4;
        charset = charset2;
        return encode(str, barcodeFormat, i, i2, charset, i3, i5);
    }

    private static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat != BarcodeFormat.AZTEC) {
            throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
        }
        return renderResult(Encoder.encode(str.getBytes(charset), i3, i4), i, i2);
    }

    private static BitMatrix renderResult(AztecCode aztecCode, int i, int i2) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int max = Math.max(i, width);
        int max2 = Math.max(i2, height);
        int min = Math.min(max / width, max2 / height);
        int i3 = (max - (width * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i4 = (max2 - (height * min)) / 2;
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < width) {
                if (matrix.get(i7, i5)) {
                    bitMatrix.setRegion(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i4 += min;
        }
        return bitMatrix;
    }
}
