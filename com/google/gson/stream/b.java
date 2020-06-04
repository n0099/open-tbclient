package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mHh = new String[128];
    private static final String[] mHi;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mHj;
    private String mHk;
    private String separator;
    private boolean serializeNulls;
    private int[] mHg = new int[32];
    private int mEY = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mHh[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mHh[34] = "\\\"";
        mHh[92] = "\\\\";
        mHh[9] = "\\t";
        mHh[8] = "\\b";
        mHh[10] = "\\n";
        mHh[13] = "\\r";
        mHh[12] = "\\f";
        mHi = (String[]) mHh.clone();
        mHi[60] = "\\u003c";
        mHi[62] = "\\u003e";
        mHi[38] = "\\u0026";
        mHi[61] = "\\u003d";
        mHi[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mHj = writer;
    }

    public final void Qt(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void ww(boolean z) {
        this.lenient = z;
    }

    public boolean dDG() {
        return this.lenient;
    }

    public final void wy(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dDO() {
        return this.htmlSafe;
    }

    public final void wz(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dDP() {
        return this.serializeNulls;
    }

    public b dDx() throws IOException {
        dDQ();
        return bC(1, "[");
    }

    public b dDy() throws IOException {
        return q(1, 2, "]");
    }

    public b dDz() throws IOException {
        dDQ();
        return bC(3, "{");
    }

    public b dDA() throws IOException {
        return q(3, 5, "}");
    }

    private b bC(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.mHj.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mHk != null) {
            throw new IllegalStateException("Dangling name: " + this.mHk);
        }
        this.mEY--;
        if (peek == i2) {
            newline();
        }
        this.mHj.write(str);
        return this;
    }

    private void push(int i) {
        if (this.mEY == this.mHg.length) {
            int[] iArr = new int[this.mEY * 2];
            System.arraycopy(this.mHg, 0, iArr, 0, this.mEY);
            this.mHg = iArr;
        }
        int[] iArr2 = this.mHg;
        int i2 = this.mEY;
        this.mEY = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mEY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mHg[this.mEY - 1];
    }

    private void IS(int i) {
        this.mHg[this.mEY - 1] = i;
    }

    public b Qp(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mHk != null) {
            throw new IllegalStateException();
        }
        if (this.mEY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mHk = str;
        return this;
    }

    private void dDQ() throws IOException {
        if (this.mHk != null) {
            dDR();
            string(this.mHk);
            this.mHk = null;
        }
    }

    public b Qq(String str) throws IOException {
        if (str == null) {
            return dDB();
        }
        dDQ();
        beforeValue();
        string(str);
        return this;
    }

    public b dDB() throws IOException {
        if (this.mHk != null) {
            if (this.serializeNulls) {
                dDQ();
            } else {
                this.mHk = null;
                return this;
            }
        }
        beforeValue();
        this.mHj.write("null");
        return this;
    }

    public b wv(boolean z) throws IOException {
        dDQ();
        beforeValue();
        this.mHj.write(z ? "true" : "false");
        return this;
    }

    public b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dDB();
        }
        dDQ();
        beforeValue();
        this.mHj.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b fU(long j) throws IOException {
        dDQ();
        beforeValue();
        this.mHj.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dDB();
        }
        dDQ();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mHj.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mEY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mHj.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mHj.close();
        int i = this.mEY;
        if (i > 1 || (i == 1 && this.mHg[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mEY = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mHi : mHh;
        this.mHj.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mHj.write(str, i2, i - i2);
                }
                this.mHj.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mHj.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mHj.write(str, i2, length - i2);
        }
        this.mHj.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mHj.write("\n");
            int i = this.mEY;
            for (int i2 = 1; i2 < i; i2++) {
                this.mHj.write(this.indent);
            }
        }
    }

    private void dDR() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mHj.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        IS(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                IS(2);
                newline();
                return;
            case 2:
                this.mHj.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mHj.append((CharSequence) this.separator);
                IS(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        IS(7);
    }
}
