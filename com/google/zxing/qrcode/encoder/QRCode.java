package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
/* loaded from: classes.dex */
public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;
    private ErrorCorrectionLevel ecLevel;
    private int maskPattern = -1;
    private ByteMatrix matrix;
    private Mode mode;
    private Version version;

    public final Mode getMode() {
        return this.mode;
    }

    public final ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }

    public final Version getVersion() {
        return this.version;
    }

    public final int getMaskPattern() {
        return this.maskPattern;
    }

    public final ByteMatrix getMatrix() {
        return this.matrix;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.mode);
        sb.append("\n ecLevel: ");
        sb.append(this.ecLevel);
        sb.append("\n version: ");
        sb.append(this.version);
        sb.append("\n maskPattern: ");
        sb.append(this.maskPattern);
        if (this.matrix == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.matrix.toString());
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public final void setMode(Mode mode) {
        this.mode = mode;
    }

    public final void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.ecLevel = errorCorrectionLevel;
    }

    public final void setVersion(Version version) {
        this.version = version;
    }

    public final void setMaskPattern(int i) {
        this.maskPattern = i;
    }

    public final void setMatrix(ByteMatrix byteMatrix) {
        this.matrix = byteMatrix;
    }

    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }
}
