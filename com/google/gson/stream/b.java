package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] pVg = new String[128];
    private static final String[] pVh;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pVi;
    private String pVj;
    private String separator;
    private boolean serializeNulls;
    private int[] pVf = new int[32];
    private int pSY = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pVg[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pVg[34] = "\\\"";
        pVg[92] = "\\\\";
        pVg[9] = "\\t";
        pVg[8] = "\\b";
        pVg[10] = "\\n";
        pVg[13] = "\\r";
        pVg[12] = "\\f";
        pVh = (String[]) pVg.clone();
        pVh[60] = "\\u003c";
        pVh[62] = "\\u003e";
        pVh[38] = "\\u0026";
        pVh[61] = "\\u003d";
        pVh[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pVi = writer;
    }

    public final void ZO(String str) {
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

    public boolean eBN() {
        return this.lenient;
    }

    public final void BC(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean eBV() {
        return this.htmlSafe;
    }

    public final void BD(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean eBW() {
        return this.serializeNulls;
    }

    public b eBE() throws IOException {
        eBX();
        return cj(1, "[");
    }

    public b eBF() throws IOException {
        return t(1, 2, "]");
    }

    public b eBG() throws IOException {
        eBX();
        return cj(3, "{");
    }

    public b eBH() throws IOException {
        return t(3, 5, "}");
    }

    private b cj(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pVi.write(str);
        return this;
    }

    private b t(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pVj != null) {
            throw new IllegalStateException("Dangling name: " + this.pVj);
        }
        this.pSY--;
        if (peek == i2) {
            newline();
        }
        this.pVi.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pSY == this.pVf.length) {
            int[] iArr = new int[this.pSY * 2];
            System.arraycopy(this.pVf, 0, iArr, 0, this.pSY);
            this.pVf = iArr;
        }
        int[] iArr2 = this.pVf;
        int i2 = this.pSY;
        this.pSY = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pSY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pVf[this.pSY - 1];
    }

    private void Qz(int i) {
        this.pVf[this.pSY - 1] = i;
    }

    public b ZK(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pVj != null) {
            throw new IllegalStateException();
        }
        if (this.pSY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pVj = str;
        return this;
    }

    private void eBX() throws IOException {
        if (this.pVj != null) {
            eBY();
            string(this.pVj);
            this.pVj = null;
        }
    }

    public b ZL(String str) throws IOException {
        if (str == null) {
            return eBI();
        }
        eBX();
        beforeValue();
        string(str);
        return this;
    }

    public b eBI() throws IOException {
        if (this.pVj != null) {
            if (this.serializeNulls) {
                eBX();
            } else {
                this.pVj = null;
                return this;
            }
        }
        beforeValue();
        this.pVi.write("null");
        return this;
    }

    public b Bz(boolean z) throws IOException {
        eBX();
        beforeValue();
        this.pVi.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return eBI();
        }
        eBX();
        beforeValue();
        this.pVi.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iT(long j) throws IOException {
        eBX();
        beforeValue();
        this.pVi.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return eBI();
        }
        eBX();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pVi.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pSY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pVi.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pVi.close();
        int i = this.pSY;
        if (i > 1 || (i == 1 && this.pVf[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pSY = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.htmlSafe ? pVh : pVg;
        this.pVi.write("\"");
        int length = str.length();
        int i2 = 0;
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pVi.write(str, i2, i - i2);
                }
                this.pVi.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pVi.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pVi.write(str, i2, length - i2);
        }
        this.pVi.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pVi.write("\n");
            int i = this.pSY;
            for (int i2 = 1; i2 < i; i2++) {
                this.pVi.write(this.indent);
            }
        }
    }

    private void eBY() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pVi.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Qz(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Qz(2);
                newline();
                return;
            case 2:
                this.pVi.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pVi.append((CharSequence) this.separator);
                Qz(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Qz(7);
    }
}
