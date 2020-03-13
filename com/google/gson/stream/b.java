package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mNE = new String[128];
    private static final String[] mNF;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mNG;
    private String mNH;
    private String separator;
    private boolean serializeNulls;
    private int[] mND = new int[32];
    private int mLy = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mNE[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mNE[34] = "\\\"";
        mNE[92] = "\\\\";
        mNE[9] = "\\t";
        mNE[8] = "\\b";
        mNE[10] = "\\n";
        mNE[13] = "\\r";
        mNE[12] = "\\f";
        mNF = (String[]) mNE.clone();
        mNF[60] = "\\u003c";
        mNF[62] = "\\u003e";
        mNF[38] = "\\u0026";
        mNF[61] = "\\u003d";
        mNF[39] = "\\u0027";
    }

    public b(Writer writer) {
        MD(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mNG = writer;
    }

    public final void QQ(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void wd(boolean z) {
        this.lenient = z;
    }

    public boolean dBn() {
        return this.lenient;
    }

    public final void wf(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dBv() {
        return this.htmlSafe;
    }

    public final void wg(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dBw() {
        return this.serializeNulls;
    }

    public b dBf() throws IOException {
        dBx();
        return bi(1, "[");
    }

    public b dBg() throws IOException {
        return q(1, 2, "]");
    }

    public b dBh() throws IOException {
        dBx();
        return bi(3, "{");
    }

    public b dBi() throws IOException {
        return q(3, 5, "}");
    }

    private b bi(int i, String str) throws IOException {
        beforeValue();
        MD(i);
        this.mNG.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mNH != null) {
            throw new IllegalStateException("Dangling name: " + this.mNH);
        }
        this.mLy--;
        if (peek == i2) {
            newline();
        }
        this.mNG.write(str);
        return this;
    }

    private void MD(int i) {
        if (this.mLy == this.mND.length) {
            int[] iArr = new int[this.mLy * 2];
            System.arraycopy(this.mND, 0, iArr, 0, this.mLy);
            this.mND = iArr;
        }
        int[] iArr2 = this.mND;
        int i2 = this.mLy;
        this.mLy = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mLy == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mND[this.mLy - 1];
    }

    private void MF(int i) {
        this.mND[this.mLy - 1] = i;
    }

    public b QM(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mNH != null) {
            throw new IllegalStateException();
        }
        if (this.mLy == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mNH = str;
        return this;
    }

    private void dBx() throws IOException {
        if (this.mNH != null) {
            dBy();
            string(this.mNH);
            this.mNH = null;
        }
    }

    public b QN(String str) throws IOException {
        if (str == null) {
            return dBj();
        }
        dBx();
        beforeValue();
        string(str);
        return this;
    }

    public b QR(String str) throws IOException {
        if (str == null) {
            return dBj();
        }
        dBx();
        beforeValue();
        this.mNG.append((CharSequence) str);
        return this;
    }

    public b dBj() throws IOException {
        if (this.mNH != null) {
            if (this.serializeNulls) {
                dBx();
            } else {
                this.mNH = null;
                return this;
            }
        }
        beforeValue();
        this.mNG.write("null");
        return this;
    }

    public b wc(boolean z) throws IOException {
        dBx();
        beforeValue();
        this.mNG.write(z ? "true" : "false");
        return this;
    }

    public b q(Boolean bool) throws IOException {
        if (bool == null) {
            return dBj();
        }
        dBx();
        beforeValue();
        this.mNG.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gQ(long j) throws IOException {
        dBx();
        beforeValue();
        this.mNG.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dBj();
        }
        dBx();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mNG.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mLy == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mNG.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mNG.close();
        int i = this.mLy;
        if (i > 1 || (i == 1 && this.mND[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mLy = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mNF : mNE;
        this.mNG.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mNG.write(str, i2, i - i2);
                }
                this.mNG.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mNG.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mNG.write(str, i2, length - i2);
        }
        this.mNG.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mNG.write("\n");
            int i = this.mLy;
            for (int i2 = 1; i2 < i; i2++) {
                this.mNG.write(this.indent);
            }
        }
    }

    private void dBy() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mNG.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        MF(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                MF(2);
                newline();
                return;
            case 2:
                this.mNG.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mNG.append((CharSequence) this.separator);
                MF(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        MF(7);
    }
}
