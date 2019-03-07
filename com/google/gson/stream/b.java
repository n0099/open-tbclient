package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] jQA = new String[128];
    private static final String[] jQB;
    private boolean jMW;
    private boolean jMX;
    private boolean jNa;
    private String jQC;
    private String jQD;
    private final Writer out;
    private String separator;
    private int[] jQz = new int[32];
    private int jOw = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            jQA[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        jQA[34] = "\\\"";
        jQA[92] = "\\\\";
        jQA[9] = "\\t";
        jQA[8] = "\\b";
        jQA[10] = "\\n";
        jQA[13] = "\\r";
        jQA[12] = "\\f";
        jQB = (String[]) jQA.clone();
        jQB[60] = "\\u003c";
        jQB[62] = "\\u003e";
        jQB[38] = "\\u0026";
        jQB[61] = "\\u003d";
        jQB[39] = "\\u0027";
    }

    public b(Writer writer) {
        CV(6);
        this.separator = ":";
        this.jMW = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.jQC = null;
            this.separator = ":";
            return;
        }
        this.jQC = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.jNa = z;
    }

    public boolean isLenient() {
        return this.jNa;
    }

    public final void rD(boolean z) {
        this.jMX = z;
    }

    public final boolean cBH() {
        return this.jMX;
    }

    public final void rE(boolean z) {
        this.jMW = z;
    }

    public final boolean cBI() {
        return this.jMW;
    }

    public b cBr() throws IOException {
        cBK();
        return aJ(1, "[");
    }

    public b cBs() throws IOException {
        return l(1, 2, "]");
    }

    public b cBt() throws IOException {
        cBK();
        return aJ(3, "{");
    }

    public b cBu() throws IOException {
        return l(3, 5, "}");
    }

    private b aJ(int i, String str) throws IOException {
        cBN();
        CV(i);
        this.out.write(str);
        return this;
    }

    private b l(int i, int i2, String str) throws IOException {
        int cBJ = cBJ();
        if (cBJ != i2 && cBJ != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.jQD != null) {
            throw new IllegalStateException("Dangling name: " + this.jQD);
        }
        this.jOw--;
        if (cBJ == i2) {
            cBL();
        }
        this.out.write(str);
        return this;
    }

    private void CV(int i) {
        if (this.jOw == this.jQz.length) {
            int[] iArr = new int[this.jOw * 2];
            System.arraycopy(this.jQz, 0, iArr, 0, this.jOw);
            this.jQz = iArr;
        }
        int[] iArr2 = this.jQz;
        int i2 = this.jOw;
        this.jOw = i2 + 1;
        iArr2[i2] = i;
    }

    private int cBJ() {
        if (this.jOw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.jQz[this.jOw - 1];
    }

    private void CX(int i) {
        this.jQz[this.jOw - 1] = i;
    }

    public b FP(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.jQD != null) {
            throw new IllegalStateException();
        }
        if (this.jOw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.jQD = str;
        return this;
    }

    private void cBK() throws IOException {
        if (this.jQD != null) {
            cBM();
            FT(this.jQD);
            this.jQD = null;
        }
    }

    public b FQ(String str) throws IOException {
        if (str == null) {
            return cBv();
        }
        cBK();
        cBN();
        FT(str);
        return this;
    }

    public b cBv() throws IOException {
        if (this.jQD != null) {
            if (this.jMW) {
                cBK();
            } else {
                this.jQD = null;
                return this;
            }
        }
        cBN();
        this.out.write("null");
        return this;
    }

    public b rB(boolean z) throws IOException {
        cBK();
        cBN();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public b m(Boolean bool) throws IOException {
        if (bool == null) {
            return cBv();
        }
        cBK();
        cBN();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b eh(long j) throws IOException {
        cBK();
        cBN();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return cBv();
        }
        cBK();
        String obj = number.toString();
        if (!this.jNa && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        cBN();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.jOw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.jOw;
        if (i > 1 || (i == 1 && this.jQz[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.jOw = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void FT(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.jMX ? jQB : jQA;
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

    private void cBL() throws IOException {
        if (this.jQC != null) {
            this.out.write("\n");
            int i = this.jOw;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.jQC);
            }
        }
    }

    private void cBM() throws IOException {
        int cBJ = cBJ();
        if (cBJ == 5) {
            this.out.write(44);
        } else if (cBJ != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        cBL();
        CX(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void cBN() throws IOException {
        switch (cBJ()) {
            case 1:
                CX(2);
                cBL();
                return;
            case 2:
                this.out.append(',');
                cBL();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                CX(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.jNa) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        CX(7);
    }
}
