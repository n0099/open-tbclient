package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mFX = new String[128];
    private static final String[] mFY;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mFZ;
    private String mGa;
    private String separator;
    private boolean serializeNulls;
    private int[] mFW = new int[32];
    private int mDO = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mFX[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mFX[34] = "\\\"";
        mFX[92] = "\\\\";
        mFX[9] = "\\t";
        mFX[8] = "\\b";
        mFX[10] = "\\n";
        mFX[13] = "\\r";
        mFX[12] = "\\f";
        mFY = (String[]) mFX.clone();
        mFY[60] = "\\u003c";
        mFY[62] = "\\u003e";
        mFY[38] = "\\u0026";
        mFY[61] = "\\u003d";
        mFY[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mFZ = writer;
    }

    public final void Qs(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void wu(boolean z) {
        this.lenient = z;
    }

    public boolean dDs() {
        return this.lenient;
    }

    public final void ww(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dDA() {
        return this.htmlSafe;
    }

    public final void wx(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dDB() {
        return this.serializeNulls;
    }

    public b dDj() throws IOException {
        dDC();
        return bC(1, "[");
    }

    public b dDk() throws IOException {
        return q(1, 2, "]");
    }

    public b dDl() throws IOException {
        dDC();
        return bC(3, "{");
    }

    public b dDm() throws IOException {
        return q(3, 5, "}");
    }

    private b bC(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.mFZ.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mGa != null) {
            throw new IllegalStateException("Dangling name: " + this.mGa);
        }
        this.mDO--;
        if (peek == i2) {
            newline();
        }
        this.mFZ.write(str);
        return this;
    }

    private void push(int i) {
        if (this.mDO == this.mFW.length) {
            int[] iArr = new int[this.mDO * 2];
            System.arraycopy(this.mFW, 0, iArr, 0, this.mDO);
            this.mFW = iArr;
        }
        int[] iArr2 = this.mFW;
        int i2 = this.mDO;
        this.mDO = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mDO == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mFW[this.mDO - 1];
    }

    private void IQ(int i) {
        this.mFW[this.mDO - 1] = i;
    }

    public b Qo(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mGa != null) {
            throw new IllegalStateException();
        }
        if (this.mDO == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mGa = str;
        return this;
    }

    private void dDC() throws IOException {
        if (this.mGa != null) {
            dDD();
            string(this.mGa);
            this.mGa = null;
        }
    }

    public b Qp(String str) throws IOException {
        if (str == null) {
            return dDn();
        }
        dDC();
        beforeValue();
        string(str);
        return this;
    }

    public b dDn() throws IOException {
        if (this.mGa != null) {
            if (this.serializeNulls) {
                dDC();
            } else {
                this.mGa = null;
                return this;
            }
        }
        beforeValue();
        this.mFZ.write("null");
        return this;
    }

    public b wt(boolean z) throws IOException {
        dDC();
        beforeValue();
        this.mFZ.write(z ? "true" : "false");
        return this;
    }

    public b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dDn();
        }
        dDC();
        beforeValue();
        this.mFZ.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b fU(long j) throws IOException {
        dDC();
        beforeValue();
        this.mFZ.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dDn();
        }
        dDC();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mFZ.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mDO == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mFZ.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mFZ.close();
        int i = this.mDO;
        if (i > 1 || (i == 1 && this.mFW[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mDO = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mFY : mFX;
        this.mFZ.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mFZ.write(str, i2, i - i2);
                }
                this.mFZ.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mFZ.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mFZ.write(str, i2, length - i2);
        }
        this.mFZ.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mFZ.write("\n");
            int i = this.mDO;
            for (int i2 = 1; i2 < i; i2++) {
                this.mFZ.write(this.indent);
            }
        }
    }

    private void dDD() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mFZ.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        IQ(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                IQ(2);
                newline();
                return;
            case 2:
                this.mFZ.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mFZ.append((CharSequence) this.separator);
                IQ(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        IQ(7);
    }
}
