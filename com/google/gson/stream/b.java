package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] mMJ = new String[128];
    private static final String[] mMK;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mML;
    private String mMM;
    private String separator;
    private boolean serializeNulls;
    private int[] mMI = new int[32];
    private int mKD = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mMJ[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mMJ[34] = "\\\"";
        mMJ[92] = "\\\\";
        mMJ[9] = "\\t";
        mMJ[8] = "\\b";
        mMJ[10] = "\\n";
        mMJ[13] = "\\r";
        mMJ[12] = "\\f";
        mMK = (String[]) mMJ.clone();
        mMK[60] = "\\u003c";
        mMK[62] = "\\u003e";
        mMK[38] = "\\u0026";
        mMK[61] = "\\u003d";
        mMK[39] = "\\u0027";
    }

    public b(Writer writer) {
        My(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mML = writer;
    }

    public final void QC(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void vZ(boolean z) {
        this.lenient = z;
    }

    public boolean dAc() {
        return this.lenient;
    }

    public final void wb(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dAk() {
        return this.htmlSafe;
    }

    public final void wc(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dAl() {
        return this.serializeNulls;
    }

    public b dzU() throws IOException {
        dAm();
        return bj(1, "[");
    }

    public b dzV() throws IOException {
        return q(1, 2, "]");
    }

    public b dzW() throws IOException {
        dAm();
        return bj(3, "{");
    }

    public b dzX() throws IOException {
        return q(3, 5, "}");
    }

    private b bj(int i, String str) throws IOException {
        beforeValue();
        My(i);
        this.mML.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mMM != null) {
            throw new IllegalStateException("Dangling name: " + this.mMM);
        }
        this.mKD--;
        if (peek == i2) {
            newline();
        }
        this.mML.write(str);
        return this;
    }

    private void My(int i) {
        if (this.mKD == this.mMI.length) {
            int[] iArr = new int[this.mKD * 2];
            System.arraycopy(this.mMI, 0, iArr, 0, this.mKD);
            this.mMI = iArr;
        }
        int[] iArr2 = this.mMI;
        int i2 = this.mKD;
        this.mKD = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mKD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mMI[this.mKD - 1];
    }

    private void MA(int i) {
        this.mMI[this.mKD - 1] = i;
    }

    public b Qy(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mMM != null) {
            throw new IllegalStateException();
        }
        if (this.mKD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mMM = str;
        return this;
    }

    private void dAm() throws IOException {
        if (this.mMM != null) {
            dAn();
            string(this.mMM);
            this.mMM = null;
        }
    }

    public b Qz(String str) throws IOException {
        if (str == null) {
            return dzY();
        }
        dAm();
        beforeValue();
        string(str);
        return this;
    }

    public b QD(String str) throws IOException {
        if (str == null) {
            return dzY();
        }
        dAm();
        beforeValue();
        this.mML.append((CharSequence) str);
        return this;
    }

    public b dzY() throws IOException {
        if (this.mMM != null) {
            if (this.serializeNulls) {
                dAm();
            } else {
                this.mMM = null;
                return this;
            }
        }
        beforeValue();
        this.mML.write("null");
        return this;
    }

    public b vY(boolean z) throws IOException {
        dAm();
        beforeValue();
        this.mML.write(z ? "true" : "false");
        return this;
    }

    public b q(Boolean bool) throws IOException {
        if (bool == null) {
            return dzY();
        }
        dAm();
        beforeValue();
        this.mML.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gS(long j) throws IOException {
        dAm();
        beforeValue();
        this.mML.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dzY();
        }
        dAm();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mML.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mKD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mML.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mML.close();
        int i = this.mKD;
        if (i > 1 || (i == 1 && this.mMI[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mKD = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mMK : mMJ;
        this.mML.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mML.write(str, i2, i - i2);
                }
                this.mML.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mML.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mML.write(str, i2, length - i2);
        }
        this.mML.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mML.write("\n");
            int i = this.mKD;
            for (int i2 = 1; i2 < i; i2++) {
                this.mML.write(this.indent);
            }
        }
    }

    private void dAn() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mML.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        MA(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                MA(2);
                newline();
                return;
            case 2:
                this.mML.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mML.append((CharSequence) this.separator);
                MA(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        MA(7);
    }
}
