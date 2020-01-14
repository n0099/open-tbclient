package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] mMO = new String[128];
    private static final String[] mMP;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mMQ;
    private String mMR;
    private String separator;
    private boolean serializeNulls;
    private int[] mMN = new int[32];
    private int mKI = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mMO[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mMO[34] = "\\\"";
        mMO[92] = "\\\\";
        mMO[9] = "\\t";
        mMO[8] = "\\b";
        mMO[10] = "\\n";
        mMO[13] = "\\r";
        mMO[12] = "\\f";
        mMP = (String[]) mMO.clone();
        mMP[60] = "\\u003c";
        mMP[62] = "\\u003e";
        mMP[38] = "\\u0026";
        mMP[61] = "\\u003d";
        mMP[39] = "\\u0027";
    }

    public b(Writer writer) {
        My(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mMQ = writer;
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

    public boolean dAe() {
        return this.lenient;
    }

    public final void wb(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dAm() {
        return this.htmlSafe;
    }

    public final void wc(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dAn() {
        return this.serializeNulls;
    }

    public b dzW() throws IOException {
        dAo();
        return bj(1, "[");
    }

    public b dzX() throws IOException {
        return q(1, 2, "]");
    }

    public b dzY() throws IOException {
        dAo();
        return bj(3, "{");
    }

    public b dzZ() throws IOException {
        return q(3, 5, "}");
    }

    private b bj(int i, String str) throws IOException {
        beforeValue();
        My(i);
        this.mMQ.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mMR != null) {
            throw new IllegalStateException("Dangling name: " + this.mMR);
        }
        this.mKI--;
        if (peek == i2) {
            newline();
        }
        this.mMQ.write(str);
        return this;
    }

    private void My(int i) {
        if (this.mKI == this.mMN.length) {
            int[] iArr = new int[this.mKI * 2];
            System.arraycopy(this.mMN, 0, iArr, 0, this.mKI);
            this.mMN = iArr;
        }
        int[] iArr2 = this.mMN;
        int i2 = this.mKI;
        this.mKI = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mKI == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mMN[this.mKI - 1];
    }

    private void MA(int i) {
        this.mMN[this.mKI - 1] = i;
    }

    public b Qy(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mMR != null) {
            throw new IllegalStateException();
        }
        if (this.mKI == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mMR = str;
        return this;
    }

    private void dAo() throws IOException {
        if (this.mMR != null) {
            dAp();
            string(this.mMR);
            this.mMR = null;
        }
    }

    public b Qz(String str) throws IOException {
        if (str == null) {
            return dAa();
        }
        dAo();
        beforeValue();
        string(str);
        return this;
    }

    public b QD(String str) throws IOException {
        if (str == null) {
            return dAa();
        }
        dAo();
        beforeValue();
        this.mMQ.append((CharSequence) str);
        return this;
    }

    public b dAa() throws IOException {
        if (this.mMR != null) {
            if (this.serializeNulls) {
                dAo();
            } else {
                this.mMR = null;
                return this;
            }
        }
        beforeValue();
        this.mMQ.write("null");
        return this;
    }

    public b vY(boolean z) throws IOException {
        dAo();
        beforeValue();
        this.mMQ.write(z ? "true" : "false");
        return this;
    }

    public b q(Boolean bool) throws IOException {
        if (bool == null) {
            return dAa();
        }
        dAo();
        beforeValue();
        this.mMQ.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gS(long j) throws IOException {
        dAo();
        beforeValue();
        this.mMQ.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dAa();
        }
        dAo();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mMQ.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mKI == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mMQ.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mMQ.close();
        int i = this.mKI;
        if (i > 1 || (i == 1 && this.mMN[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mKI = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mMP : mMO;
        this.mMQ.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mMQ.write(str, i2, i - i2);
                }
                this.mMQ.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mMQ.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mMQ.write(str, i2, length - i2);
        }
        this.mMQ.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mMQ.write("\n");
            int i = this.mKI;
            for (int i2 = 1; i2 < i; i2++) {
                this.mMQ.write(this.indent);
            }
        }
    }

    private void dAp() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mMQ.write(44);
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
                this.mMQ.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mMQ.append((CharSequence) this.separator);
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
