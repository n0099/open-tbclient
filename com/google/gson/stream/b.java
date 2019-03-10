package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] jQT = new String[128];
    private static final String[] jQU;
    private boolean jNp;
    private boolean jNq;
    private boolean jNt;
    private String jQV;
    private String jQW;
    private final Writer out;
    private String separator;
    private int[] jQS = new int[32];
    private int jOP = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            jQT[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        jQT[34] = "\\\"";
        jQT[92] = "\\\\";
        jQT[9] = "\\t";
        jQT[8] = "\\b";
        jQT[10] = "\\n";
        jQT[13] = "\\r";
        jQT[12] = "\\f";
        jQU = (String[]) jQT.clone();
        jQU[60] = "\\u003c";
        jQU[62] = "\\u003e";
        jQU[38] = "\\u0026";
        jQU[61] = "\\u003d";
        jQU[39] = "\\u0027";
    }

    public b(Writer writer) {
        CW(6);
        this.separator = ":";
        this.jNp = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.jQV = null;
            this.separator = ":";
            return;
        }
        this.jQV = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.jNt = z;
    }

    public boolean isLenient() {
        return this.jNt;
    }

    public final void rD(boolean z) {
        this.jNq = z;
    }

    public final boolean cBR() {
        return this.jNq;
    }

    public final void rE(boolean z) {
        this.jNp = z;
    }

    public final boolean cBS() {
        return this.jNp;
    }

    public b cBB() throws IOException {
        cBU();
        return aJ(1, "[");
    }

    public b cBC() throws IOException {
        return l(1, 2, "]");
    }

    public b cBD() throws IOException {
        cBU();
        return aJ(3, "{");
    }

    public b cBE() throws IOException {
        return l(3, 5, "}");
    }

    private b aJ(int i, String str) throws IOException {
        cBX();
        CW(i);
        this.out.write(str);
        return this;
    }

    private b l(int i, int i2, String str) throws IOException {
        int cBT = cBT();
        if (cBT != i2 && cBT != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.jQW != null) {
            throw new IllegalStateException("Dangling name: " + this.jQW);
        }
        this.jOP--;
        if (cBT == i2) {
            cBV();
        }
        this.out.write(str);
        return this;
    }

    private void CW(int i) {
        if (this.jOP == this.jQS.length) {
            int[] iArr = new int[this.jOP * 2];
            System.arraycopy(this.jQS, 0, iArr, 0, this.jOP);
            this.jQS = iArr;
        }
        int[] iArr2 = this.jQS;
        int i2 = this.jOP;
        this.jOP = i2 + 1;
        iArr2[i2] = i;
    }

    private int cBT() {
        if (this.jOP == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.jQS[this.jOP - 1];
    }

    private void CY(int i) {
        this.jQS[this.jOP - 1] = i;
    }

    public b FS(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.jQW != null) {
            throw new IllegalStateException();
        }
        if (this.jOP == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.jQW = str;
        return this;
    }

    private void cBU() throws IOException {
        if (this.jQW != null) {
            cBW();
            FW(this.jQW);
            this.jQW = null;
        }
    }

    public b FT(String str) throws IOException {
        if (str == null) {
            return cBF();
        }
        cBU();
        cBX();
        FW(str);
        return this;
    }

    public b cBF() throws IOException {
        if (this.jQW != null) {
            if (this.jNp) {
                cBU();
            } else {
                this.jQW = null;
                return this;
            }
        }
        cBX();
        this.out.write("null");
        return this;
    }

    public b rB(boolean z) throws IOException {
        cBU();
        cBX();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public b m(Boolean bool) throws IOException {
        if (bool == null) {
            return cBF();
        }
        cBU();
        cBX();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b eh(long j) throws IOException {
        cBU();
        cBX();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return cBF();
        }
        cBU();
        String obj = number.toString();
        if (!this.jNt && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        cBX();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.jOP == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.jOP;
        if (i > 1 || (i == 1 && this.jQS[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.jOP = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void FW(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.jNq ? jQU : jQT;
        this.out.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.out.write(str, i2, i - i2);
                }
                this.out.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.out.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.out.write(str, i2, length - i2);
        }
        this.out.write("\"");
    }

    private void cBV() throws IOException {
        if (this.jQV != null) {
            this.out.write("\n");
            int i = this.jOP;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.jQV);
            }
        }
    }

    private void cBW() throws IOException {
        int cBT = cBT();
        if (cBT == 5) {
            this.out.write(44);
        } else if (cBT != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        cBV();
        CY(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void cBX() throws IOException {
        switch (cBT()) {
            case 1:
                CY(2);
                cBV();
                return;
            case 2:
                this.out.append(',');
                cBV();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                CY(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.jNt) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        CY(7);
    }
}
