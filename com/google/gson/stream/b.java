package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mNt = new String[128];
    private static final String[] mNu;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mNv;
    private String mNw;
    private String separator;
    private boolean serializeNulls;
    private int[] mNs = new int[32];
    private int mLn = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mNt[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mNt[34] = "\\\"";
        mNt[92] = "\\\\";
        mNt[9] = "\\t";
        mNt[8] = "\\b";
        mNt[10] = "\\n";
        mNt[13] = "\\r";
        mNt[12] = "\\f";
        mNu = (String[]) mNt.clone();
        mNu[60] = "\\u003c";
        mNu[62] = "\\u003e";
        mNu[38] = "\\u0026";
        mNu[61] = "\\u003d";
        mNu[39] = "\\u0027";
    }

    public b(Writer writer) {
        MD(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mNv = writer;
    }

    public final void QP(String str) {
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

    public boolean dBm() {
        return this.lenient;
    }

    public final void wf(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dBu() {
        return this.htmlSafe;
    }

    public final void wg(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dBv() {
        return this.serializeNulls;
    }

    public b dBe() throws IOException {
        dBw();
        return bi(1, "[");
    }

    public b dBf() throws IOException {
        return q(1, 2, "]");
    }

    public b dBg() throws IOException {
        dBw();
        return bi(3, "{");
    }

    public b dBh() throws IOException {
        return q(3, 5, "}");
    }

    private b bi(int i, String str) throws IOException {
        beforeValue();
        MD(i);
        this.mNv.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mNw != null) {
            throw new IllegalStateException("Dangling name: " + this.mNw);
        }
        this.mLn--;
        if (peek == i2) {
            newline();
        }
        this.mNv.write(str);
        return this;
    }

    private void MD(int i) {
        if (this.mLn == this.mNs.length) {
            int[] iArr = new int[this.mLn * 2];
            System.arraycopy(this.mNs, 0, iArr, 0, this.mLn);
            this.mNs = iArr;
        }
        int[] iArr2 = this.mNs;
        int i2 = this.mLn;
        this.mLn = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mLn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mNs[this.mLn - 1];
    }

    private void MF(int i) {
        this.mNs[this.mLn - 1] = i;
    }

    public b QL(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mNw != null) {
            throw new IllegalStateException();
        }
        if (this.mLn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mNw = str;
        return this;
    }

    private void dBw() throws IOException {
        if (this.mNw != null) {
            dBx();
            string(this.mNw);
            this.mNw = null;
        }
    }

    public b QM(String str) throws IOException {
        if (str == null) {
            return dBi();
        }
        dBw();
        beforeValue();
        string(str);
        return this;
    }

    public b QQ(String str) throws IOException {
        if (str == null) {
            return dBi();
        }
        dBw();
        beforeValue();
        this.mNv.append((CharSequence) str);
        return this;
    }

    public b dBi() throws IOException {
        if (this.mNw != null) {
            if (this.serializeNulls) {
                dBw();
            } else {
                this.mNw = null;
                return this;
            }
        }
        beforeValue();
        this.mNv.write("null");
        return this;
    }

    public b wc(boolean z) throws IOException {
        dBw();
        beforeValue();
        this.mNv.write(z ? "true" : "false");
        return this;
    }

    public b q(Boolean bool) throws IOException {
        if (bool == null) {
            return dBi();
        }
        dBw();
        beforeValue();
        this.mNv.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gQ(long j) throws IOException {
        dBw();
        beforeValue();
        this.mNv.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dBi();
        }
        dBw();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mNv.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mLn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mNv.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mNv.close();
        int i = this.mLn;
        if (i > 1 || (i == 1 && this.mNs[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mLn = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mNu : mNt;
        this.mNv.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mNv.write(str, i2, i - i2);
                }
                this.mNv.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mNv.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mNv.write(str, i2, length - i2);
        }
        this.mNv.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mNv.write("\n");
            int i = this.mLn;
            for (int i2 = 1; i2 < i; i2++) {
                this.mNv.write(this.indent);
            }
        }
    }

    private void dBx() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mNv.write(44);
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
                this.mNv.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mNv.append((CharSequence) this.separator);
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
