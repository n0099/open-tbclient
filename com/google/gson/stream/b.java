package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes17.dex */
public class b implements Closeable, Flushable {
    private static final String[] pgg = new String[128];
    private static final String[] pgh;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pgi;
    private String pgj;
    private String separator;
    private boolean serializeNulls;
    private int[] pgf = new int[32];
    private int pdY = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pgg[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pgg[34] = "\\\"";
        pgg[92] = "\\\\";
        pgg[9] = "\\t";
        pgg[8] = "\\b";
        pgg[10] = "\\n";
        pgg[13] = "\\r";
        pgg[12] = "\\f";
        pgh = (String[]) pgg.clone();
        pgh[60] = "\\u003c";
        pgh[62] = "\\u003e";
        pgh[38] = "\\u0026";
        pgh[61] = "\\u003d";
        pgh[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pgi = writer;
    }

    public final void YD(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void Az(boolean z) {
        this.lenient = z;
    }

    public boolean etq() {
        return this.lenient;
    }

    public final void AB(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean ety() {
        return this.htmlSafe;
    }

    public final void AC(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean etz() {
        return this.serializeNulls;
    }

    public b eth() throws IOException {
        etA();
        return cb(1, "[");
    }

    public b eti() throws IOException {
        return u(1, 2, "]");
    }

    public b etj() throws IOException {
        etA();
        return cb(3, "{");
    }

    public b etk() throws IOException {
        return u(3, 5, "}");
    }

    private b cb(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pgi.write(str);
        return this;
    }

    private b u(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pgj != null) {
            throw new IllegalStateException("Dangling name: " + this.pgj);
        }
        this.pdY--;
        if (peek == i2) {
            newline();
        }
        this.pgi.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pdY == this.pgf.length) {
            int[] iArr = new int[this.pdY * 2];
            System.arraycopy(this.pgf, 0, iArr, 0, this.pdY);
            this.pgf = iArr;
        }
        int[] iArr2 = this.pgf;
        int i2 = this.pdY;
        this.pdY = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pdY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pgf[this.pdY - 1];
    }

    private void Qv(int i) {
        this.pgf[this.pdY - 1] = i;
    }

    public b Yz(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pgj != null) {
            throw new IllegalStateException();
        }
        if (this.pdY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pgj = str;
        return this;
    }

    private void etA() throws IOException {
        if (this.pgj != null) {
            etB();
            string(this.pgj);
            this.pgj = null;
        }
    }

    public b YA(String str) throws IOException {
        if (str == null) {
            return etl();
        }
        etA();
        beforeValue();
        string(str);
        return this;
    }

    public b etl() throws IOException {
        if (this.pgj != null) {
            if (this.serializeNulls) {
                etA();
            } else {
                this.pgj = null;
                return this;
            }
        }
        beforeValue();
        this.pgi.write("null");
        return this;
    }

    public b Ay(boolean z) throws IOException {
        etA();
        beforeValue();
        this.pgi.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return etl();
        }
        etA();
        beforeValue();
        this.pgi.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b hT(long j) throws IOException {
        etA();
        beforeValue();
        this.pgi.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return etl();
        }
        etA();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pgi.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pdY == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pgi.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pgi.close();
        int i = this.pdY;
        if (i > 1 || (i == 1 && this.pgf[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pdY = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? pgh : pgg;
        this.pgi.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pgi.write(str, i2, i - i2);
                }
                this.pgi.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pgi.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pgi.write(str, i2, length - i2);
        }
        this.pgi.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pgi.write("\n");
            int i = this.pdY;
            for (int i2 = 1; i2 < i; i2++) {
                this.pgi.write(this.indent);
            }
        }
    }

    private void etB() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pgi.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Qv(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Qv(2);
                newline();
                return;
            case 2:
                this.pgi.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pgi.append((CharSequence) this.separator);
                Qv(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Qv(7);
    }
}
