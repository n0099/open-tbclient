package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mPk = new String[128];
    private static final String[] mPl;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mPo;
    private String mPp;
    private String separator;
    private boolean serializeNulls;
    private int[] mPj = new int[32];
    private int mNe = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mPk[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mPk[34] = "\\\"";
        mPk[92] = "\\\\";
        mPk[9] = "\\t";
        mPk[8] = "\\b";
        mPk[10] = "\\n";
        mPk[13] = "\\r";
        mPk[12] = "\\f";
        mPl = (String[]) mPk.clone();
        mPl[60] = "\\u003c";
        mPl[62] = "\\u003e";
        mPl[38] = "\\u0026";
        mPl[61] = "\\u003d";
        mPl[39] = "\\u0027";
    }

    public b(Writer writer) {
        MJ(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mPo = writer;
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

    public final void wk(boolean z) {
        this.lenient = z;
    }

    public boolean dBK() {
        return this.lenient;
    }

    public final void wm(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dBS() {
        return this.htmlSafe;
    }

    public final void wn(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dBT() {
        return this.serializeNulls;
    }

    public b dBC() throws IOException {
        dBU();
        return bi(1, "[");
    }

    public b dBD() throws IOException {
        return q(1, 2, "]");
    }

    public b dBE() throws IOException {
        dBU();
        return bi(3, "{");
    }

    public b dBF() throws IOException {
        return q(3, 5, "}");
    }

    private b bi(int i, String str) throws IOException {
        beforeValue();
        MJ(i);
        this.mPo.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mPp != null) {
            throw new IllegalStateException("Dangling name: " + this.mPp);
        }
        this.mNe--;
        if (peek == i2) {
            newline();
        }
        this.mPo.write(str);
        return this;
    }

    private void MJ(int i) {
        if (this.mNe == this.mPj.length) {
            int[] iArr = new int[this.mNe * 2];
            System.arraycopy(this.mPj, 0, iArr, 0, this.mNe);
            this.mPj = iArr;
        }
        int[] iArr2 = this.mPj;
        int i2 = this.mNe;
        this.mNe = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mNe == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mPj[this.mNe - 1];
    }

    private void ML(int i) {
        this.mPj[this.mNe - 1] = i;
    }

    public b QM(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mPp != null) {
            throw new IllegalStateException();
        }
        if (this.mNe == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mPp = str;
        return this;
    }

    private void dBU() throws IOException {
        if (this.mPp != null) {
            dBV();
            string(this.mPp);
            this.mPp = null;
        }
    }

    public b QN(String str) throws IOException {
        if (str == null) {
            return dBG();
        }
        dBU();
        beforeValue();
        string(str);
        return this;
    }

    public b QR(String str) throws IOException {
        if (str == null) {
            return dBG();
        }
        dBU();
        beforeValue();
        this.mPo.append((CharSequence) str);
        return this;
    }

    public b dBG() throws IOException {
        if (this.mPp != null) {
            if (this.serializeNulls) {
                dBU();
            } else {
                this.mPp = null;
                return this;
            }
        }
        beforeValue();
        this.mPo.write("null");
        return this;
    }

    public b wj(boolean z) throws IOException {
        dBU();
        beforeValue();
        this.mPo.write(z ? "true" : "false");
        return this;
    }

    public b q(Boolean bool) throws IOException {
        if (bool == null) {
            return dBG();
        }
        dBU();
        beforeValue();
        this.mPo.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gR(long j) throws IOException {
        dBU();
        beforeValue();
        this.mPo.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dBG();
        }
        dBU();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mPo.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mNe == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mPo.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mPo.close();
        int i = this.mNe;
        if (i > 1 || (i == 1 && this.mPj[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mNe = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mPl : mPk;
        this.mPo.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mPo.write(str, i2, i - i2);
                }
                this.mPo.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mPo.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mPo.write(str, i2, length - i2);
        }
        this.mPo.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mPo.write("\n");
            int i = this.mNe;
            for (int i2 = 1; i2 < i; i2++) {
                this.mPo.write(this.indent);
            }
        }
    }

    private void dBV() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mPo.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        ML(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                ML(2);
                newline();
                return;
            case 2:
                this.mPo.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mPo.append((CharSequence) this.separator);
                ML(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        ML(7);
    }
}
