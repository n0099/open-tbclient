package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes4.dex */
public class b implements Closeable, Flushable {
    private static final String[] pLb = new String[128];
    private static final String[] pLc;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pLd;
    private String pLe;
    private String separator;
    private boolean serializeNulls;
    private int[] pLa = new int[32];
    private int pIT = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pLb[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pLb[34] = "\\\"";
        pLb[92] = "\\\\";
        pLb[9] = "\\t";
        pLb[8] = "\\b";
        pLb[10] = "\\n";
        pLb[13] = "\\r";
        pLb[12] = "\\f";
        pLc = (String[]) pLb.clone();
        pLc[60] = "\\u003c";
        pLc[62] = "\\u003e";
        pLc[38] = "\\u0026";
        pLc[61] = "\\u003d";
        pLc[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pLd = writer;
    }

    public final void YN(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void Bh(boolean z) {
        this.lenient = z;
    }

    public boolean ezv() {
        return this.lenient;
    }

    public final void Bj(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean ezD() {
        return this.htmlSafe;
    }

    public final void Bk(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean ezE() {
        return this.serializeNulls;
    }

    public b ezm() throws IOException {
        ezF();
        return cc(1, "[");
    }

    public b ezn() throws IOException {
        return v(1, 2, "]");
    }

    public b ezo() throws IOException {
        ezF();
        return cc(3, "{");
    }

    public b ezp() throws IOException {
        return v(3, 5, "}");
    }

    private b cc(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pLd.write(str);
        return this;
    }

    private b v(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pLe != null) {
            throw new IllegalStateException("Dangling name: " + this.pLe);
        }
        this.pIT--;
        if (peek == i2) {
            newline();
        }
        this.pLd.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pIT == this.pLa.length) {
            int[] iArr = new int[this.pIT * 2];
            System.arraycopy(this.pLa, 0, iArr, 0, this.pIT);
            this.pLa = iArr;
        }
        int[] iArr2 = this.pLa;
        int i2 = this.pIT;
        this.pIT = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pIT == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pLa[this.pIT - 1];
    }

    private void Qe(int i) {
        this.pLa[this.pIT - 1] = i;
    }

    public b YJ(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pLe != null) {
            throw new IllegalStateException();
        }
        if (this.pIT == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pLe = str;
        return this;
    }

    private void ezF() throws IOException {
        if (this.pLe != null) {
            ezG();
            string(this.pLe);
            this.pLe = null;
        }
    }

    public b YK(String str) throws IOException {
        if (str == null) {
            return ezq();
        }
        ezF();
        beforeValue();
        string(str);
        return this;
    }

    public b ezq() throws IOException {
        if (this.pLe != null) {
            if (this.serializeNulls) {
                ezF();
            } else {
                this.pLe = null;
                return this;
            }
        }
        beforeValue();
        this.pLd.write("null");
        return this;
    }

    public b Bg(boolean z) throws IOException {
        ezF();
        beforeValue();
        this.pLd.write(z ? "true" : "false");
        return this;
    }

    public b w(Boolean bool) throws IOException {
        if (bool == null) {
            return ezq();
        }
        ezF();
        beforeValue();
        this.pLd.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iQ(long j) throws IOException {
        ezF();
        beforeValue();
        this.pLd.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return ezq();
        }
        ezF();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pLd.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pIT == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pLd.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pLd.close();
        int i = this.pIT;
        if (i > 1 || (i == 1 && this.pLa[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pIT = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.htmlSafe ? pLc : pLb;
        this.pLd.write("\"");
        int length = str.length();
        int i2 = 0;
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pLd.write(str, i2, i - i2);
                }
                this.pLd.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pLd.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pLd.write(str, i2, length - i2);
        }
        this.pLd.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pLd.write("\n");
            int i = this.pIT;
            for (int i2 = 1; i2 < i; i2++) {
                this.pLd.write(this.indent);
            }
        }
    }

    private void ezG() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pLd.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Qe(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Qe(2);
                newline();
                return;
            case 2:
                this.pLd.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pLd.append((CharSequence) this.separator);
                Qe(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Qe(7);
    }
}
