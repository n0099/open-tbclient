package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mNr = new String[128];
    private static final String[] mNs;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mNt;
    private String mNu;
    private String separator;
    private boolean serializeNulls;
    private int[] mNq = new int[32];
    private int mLl = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mNr[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mNr[34] = "\\\"";
        mNr[92] = "\\\\";
        mNr[9] = "\\t";
        mNr[8] = "\\b";
        mNr[10] = "\\n";
        mNr[13] = "\\r";
        mNr[12] = "\\f";
        mNs = (String[]) mNr.clone();
        mNs[60] = "\\u003c";
        mNs[62] = "\\u003e";
        mNs[38] = "\\u0026";
        mNs[61] = "\\u003d";
        mNs[39] = "\\u0027";
    }

    public b(Writer writer) {
        MD(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mNt = writer;
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

    public boolean dBk() {
        return this.lenient;
    }

    public final void wf(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dBs() {
        return this.htmlSafe;
    }

    public final void wg(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dBt() {
        return this.serializeNulls;
    }

    public b dBc() throws IOException {
        dBu();
        return bi(1, "[");
    }

    public b dBd() throws IOException {
        return q(1, 2, "]");
    }

    public b dBe() throws IOException {
        dBu();
        return bi(3, "{");
    }

    public b dBf() throws IOException {
        return q(3, 5, "}");
    }

    private b bi(int i, String str) throws IOException {
        beforeValue();
        MD(i);
        this.mNt.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mNu != null) {
            throw new IllegalStateException("Dangling name: " + this.mNu);
        }
        this.mLl--;
        if (peek == i2) {
            newline();
        }
        this.mNt.write(str);
        return this;
    }

    private void MD(int i) {
        if (this.mLl == this.mNq.length) {
            int[] iArr = new int[this.mLl * 2];
            System.arraycopy(this.mNq, 0, iArr, 0, this.mLl);
            this.mNq = iArr;
        }
        int[] iArr2 = this.mNq;
        int i2 = this.mLl;
        this.mLl = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mLl == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mNq[this.mLl - 1];
    }

    private void MF(int i) {
        this.mNq[this.mLl - 1] = i;
    }

    public b QL(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mNu != null) {
            throw new IllegalStateException();
        }
        if (this.mLl == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mNu = str;
        return this;
    }

    private void dBu() throws IOException {
        if (this.mNu != null) {
            dBv();
            string(this.mNu);
            this.mNu = null;
        }
    }

    public b QM(String str) throws IOException {
        if (str == null) {
            return dBg();
        }
        dBu();
        beforeValue();
        string(str);
        return this;
    }

    public b QQ(String str) throws IOException {
        if (str == null) {
            return dBg();
        }
        dBu();
        beforeValue();
        this.mNt.append((CharSequence) str);
        return this;
    }

    public b dBg() throws IOException {
        if (this.mNu != null) {
            if (this.serializeNulls) {
                dBu();
            } else {
                this.mNu = null;
                return this;
            }
        }
        beforeValue();
        this.mNt.write("null");
        return this;
    }

    public b wc(boolean z) throws IOException {
        dBu();
        beforeValue();
        this.mNt.write(z ? "true" : "false");
        return this;
    }

    public b q(Boolean bool) throws IOException {
        if (bool == null) {
            return dBg();
        }
        dBu();
        beforeValue();
        this.mNt.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gQ(long j) throws IOException {
        dBu();
        beforeValue();
        this.mNt.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dBg();
        }
        dBu();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mNt.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mLl == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mNt.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mNt.close();
        int i = this.mLl;
        if (i > 1 || (i == 1 && this.mNq[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mLl = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mNs : mNr;
        this.mNt.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mNt.write(str, i2, i - i2);
                }
                this.mNt.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mNt.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mNt.write(str, i2, length - i2);
        }
        this.mNt.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mNt.write("\n");
            int i = this.mLl;
            for (int i2 = 1; i2 < i; i2++) {
                this.mNt.write(this.indent);
            }
        }
    }

    private void dBv() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mNt.write(44);
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
                this.mNt.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mNt.append((CharSequence) this.separator);
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
