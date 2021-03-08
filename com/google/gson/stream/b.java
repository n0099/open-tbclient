package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes4.dex */
public class b implements Closeable, Flushable {
    private static final String[] pWv = new String[128];
    private static final String[] pWw;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pWx;
    private String pWy;
    private String separator;
    private boolean serializeNulls;
    private int[] pWu = new int[32];
    private int pUn = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pWv[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pWv[34] = "\\\"";
        pWv[92] = "\\\\";
        pWv[9] = "\\t";
        pWv[8] = "\\b";
        pWv[10] = "\\n";
        pWv[13] = "\\r";
        pWv[12] = "\\f";
        pWw = (String[]) pWv.clone();
        pWw[60] = "\\u003c";
        pWw[62] = "\\u003e";
        pWw[38] = "\\u0026";
        pWw[61] = "\\u003d";
        pWw[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pWx = writer;
    }

    public final void aaf(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void By(boolean z) {
        this.lenient = z;
    }

    public boolean eCb() {
        return this.lenient;
    }

    public final void BA(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean eCj() {
        return this.htmlSafe;
    }

    public final void BB(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean eCk() {
        return this.serializeNulls;
    }

    public b eBS() throws IOException {
        eCl();
        return cj(1, "[");
    }

    public b eBT() throws IOException {
        return t(1, 2, "]");
    }

    public b eBU() throws IOException {
        eCl();
        return cj(3, "{");
    }

    public b eBV() throws IOException {
        return t(3, 5, "}");
    }

    private b cj(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pWx.write(str);
        return this;
    }

    private b t(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pWy != null) {
            throw new IllegalStateException("Dangling name: " + this.pWy);
        }
        this.pUn--;
        if (peek == i2) {
            newline();
        }
        this.pWx.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pUn == this.pWu.length) {
            int[] iArr = new int[this.pUn * 2];
            System.arraycopy(this.pWu, 0, iArr, 0, this.pUn);
            this.pWu = iArr;
        }
        int[] iArr2 = this.pWu;
        int i2 = this.pUn;
        this.pUn = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pUn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pWu[this.pUn - 1];
    }

    private void QE(int i) {
        this.pWu[this.pUn - 1] = i;
    }

    public b aab(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pWy != null) {
            throw new IllegalStateException();
        }
        if (this.pUn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pWy = str;
        return this;
    }

    private void eCl() throws IOException {
        if (this.pWy != null) {
            eCm();
            string(this.pWy);
            this.pWy = null;
        }
    }

    public b aac(String str) throws IOException {
        if (str == null) {
            return eBW();
        }
        eCl();
        beforeValue();
        string(str);
        return this;
    }

    public b eBW() throws IOException {
        if (this.pWy != null) {
            if (this.serializeNulls) {
                eCl();
            } else {
                this.pWy = null;
                return this;
            }
        }
        beforeValue();
        this.pWx.write("null");
        return this;
    }

    public b Bx(boolean z) throws IOException {
        eCl();
        beforeValue();
        this.pWx.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return eBW();
        }
        eCl();
        beforeValue();
        this.pWx.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iT(long j) throws IOException {
        eCl();
        beforeValue();
        this.pWx.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return eBW();
        }
        eCl();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pWx.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pUn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pWx.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pWx.close();
        int i = this.pUn;
        if (i > 1 || (i == 1 && this.pWu[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pUn = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.htmlSafe ? pWw : pWv;
        this.pWx.write("\"");
        int length = str.length();
        int i2 = 0;
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pWx.write(str, i2, i - i2);
                }
                this.pWx.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pWx.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pWx.write(str, i2, length - i2);
        }
        this.pWx.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pWx.write("\n");
            int i = this.pUn;
            for (int i2 = 1; i2 < i; i2++) {
                this.pWx.write(this.indent);
            }
        }
    }

    private void eCm() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pWx.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        QE(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                QE(2);
                newline();
                return;
            case 2:
                this.pWx.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pWx.append((CharSequence) this.separator);
                QE(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        QE(7);
    }
}
