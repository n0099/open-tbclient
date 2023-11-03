package com.google.zxing;

import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes10.dex */
public abstract class LuminanceSource {
    public final int height;
    public final int width;

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i, byte[] bArr);

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        char c;
        int i = this.width;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder(this.height * (i + 1));
        for (int i2 = 0; i2 < this.height; i2++) {
            bArr = getRow(i2, bArr);
            for (int i3 = 0; i3 < this.width; i3++) {
                int i4 = bArr[i3] & 255;
                if (i4 < 64) {
                    c = '#';
                } else if (i4 < 128) {
                    c = '+';
                } else if (i4 < 192) {
                    c = IStringUtil.EXTENSION_SEPARATOR;
                } else {
                    c = WebvttCueParser.CHAR_SPACE;
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
