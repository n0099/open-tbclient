package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] pVG = new String[128];
    private static final String[] pVH;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pVI;
    private String pVJ;
    private String separator;
    private boolean serializeNulls;
    private int[] pVF = new int[32];
    private int pTy = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pVG[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pVG[34] = "\\\"";
        pVG[92] = "\\\\";
        pVG[9] = "\\t";
        pVG[8] = "\\b";
        pVG[10] = "\\n";
        pVG[13] = "\\r";
        pVG[12] = "\\f";
        pVH = (String[]) pVG.clone();
        pVH[60] = "\\u003c";
        pVH[62] = "\\u003e";
        pVH[38] = "\\u0026";
        pVH[61] = "\\u003d";
        pVH[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pVI = writer;
    }

    public final void aaa(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void BA(boolean z) {
        this.lenient = z;
    }

    public boolean eBV() {
        return this.lenient;
    }

    public final void BC(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean eCd() {
        return this.htmlSafe;
    }

    public final void BD(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean eCe() {
        return this.serializeNulls;
    }

    public b eBM() throws IOException {
        eCf();
        return cj(1, "[");
    }

    public b eBN() throws IOException {
        return t(1, 2, "]");
    }

    public b eBO() throws IOException {
        eCf();
        return cj(3, "{");
    }

    public b eBP() throws IOException {
        return t(3, 5, "}");
    }

    private b cj(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pVI.write(str);
        return this;
    }

    private b t(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pVJ != null) {
            throw new IllegalStateException("Dangling name: " + this.pVJ);
        }
        this.pTy--;
        if (peek == i2) {
            newline();
        }
        this.pVI.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pTy == this.pVF.length) {
            int[] iArr = new int[this.pTy * 2];
            System.arraycopy(this.pVF, 0, iArr, 0, this.pTy);
            this.pVF = iArr;
        }
        int[] iArr2 = this.pVF;
        int i2 = this.pTy;
        this.pTy = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pTy == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pVF[this.pTy - 1];
    }

    private void QA(int i) {
        this.pVF[this.pTy - 1] = i;
    }

    public b ZW(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pVJ != null) {
            throw new IllegalStateException();
        }
        if (this.pTy == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pVJ = str;
        return this;
    }

    private void eCf() throws IOException {
        if (this.pVJ != null) {
            eCg();
            string(this.pVJ);
            this.pVJ = null;
        }
    }

    public b ZX(String str) throws IOException {
        if (str == null) {
            return eBQ();
        }
        eCf();
        beforeValue();
        string(str);
        return this;
    }

    public b eBQ() throws IOException {
        if (this.pVJ != null) {
            if (this.serializeNulls) {
                eCf();
            } else {
                this.pVJ = null;
                return this;
            }
        }
        beforeValue();
        this.pVI.write("null");
        return this;
    }

    public b Bz(boolean z) throws IOException {
        eCf();
        beforeValue();
        this.pVI.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return eBQ();
        }
        eCf();
        beforeValue();
        this.pVI.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iT(long j) throws IOException {
        eCf();
        beforeValue();
        this.pVI.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return eBQ();
        }
        eCf();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pVI.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pTy == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pVI.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pVI.close();
        int i = this.pTy;
        if (i > 1 || (i == 1 && this.pVF[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pTy = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.htmlSafe ? pVH : pVG;
        this.pVI.write("\"");
        int length = str.length();
        int i2 = 0;
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pVI.write(str, i2, i - i2);
                }
                this.pVI.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pVI.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pVI.write(str, i2, length - i2);
        }
        this.pVI.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pVI.write("\n");
            int i = this.pTy;
            for (int i2 = 1; i2 < i; i2++) {
                this.pVI.write(this.indent);
            }
        }
    }

    private void eCg() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pVI.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        QA(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                QA(2);
                newline();
                return;
            case 2:
                this.pVI.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pVI.append((CharSequence) this.separator);
                QA(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        QA(7);
    }
}
