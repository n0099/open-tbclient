package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] phJ = new String[128];
    private static final String[] phK;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer phL;
    private String phM;
    private String separator;
    private boolean serializeNulls;
    private int[] phI = new int[32];
    private int pfB = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            phJ[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        phJ[34] = "\\\"";
        phJ[92] = "\\\\";
        phJ[9] = "\\t";
        phJ[8] = "\\b";
        phJ[10] = "\\n";
        phJ[13] = "\\r";
        phJ[12] = "\\f";
        phK = (String[]) phJ.clone();
        phK[60] = "\\u003c";
        phK[62] = "\\u003e";
        phK[38] = "\\u0026";
        phK[61] = "\\u003d";
        phK[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.phL = writer;
    }

    public final void Yo(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void AG(boolean z) {
        this.lenient = z;
    }

    public boolean etq() {
        return this.lenient;
    }

    public final void AI(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean ety() {
        return this.htmlSafe;
    }

    public final void AJ(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean etz() {
        return this.serializeNulls;
    }

    public b eth() throws IOException {
        etA();
        return bZ(1, "[");
    }

    public b eti() throws IOException {
        return t(1, 2, "]");
    }

    public b etj() throws IOException {
        etA();
        return bZ(3, "{");
    }

    public b etk() throws IOException {
        return t(3, 5, "}");
    }

    private b bZ(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.phL.write(str);
        return this;
    }

    private b t(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.phM != null) {
            throw new IllegalStateException("Dangling name: " + this.phM);
        }
        this.pfB--;
        if (peek == i2) {
            newline();
        }
        this.phL.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pfB == this.phI.length) {
            int[] iArr = new int[this.pfB * 2];
            System.arraycopy(this.phI, 0, iArr, 0, this.pfB);
            this.phI = iArr;
        }
        int[] iArr2 = this.phI;
        int i2 = this.pfB;
        this.pfB = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pfB == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.phI[this.pfB - 1];
    }

    private void QY(int i) {
        this.phI[this.pfB - 1] = i;
    }

    public b Yk(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.phM != null) {
            throw new IllegalStateException();
        }
        if (this.pfB == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.phM = str;
        return this;
    }

    private void etA() throws IOException {
        if (this.phM != null) {
            etB();
            string(this.phM);
            this.phM = null;
        }
    }

    public b Yl(String str) throws IOException {
        if (str == null) {
            return etl();
        }
        etA();
        beforeValue();
        string(str);
        return this;
    }

    public b etl() throws IOException {
        if (this.phM != null) {
            if (this.serializeNulls) {
                etA();
            } else {
                this.phM = null;
                return this;
            }
        }
        beforeValue();
        this.phL.write("null");
        return this;
    }

    public b AF(boolean z) throws IOException {
        etA();
        beforeValue();
        this.phL.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return etl();
        }
        etA();
        beforeValue();
        this.phL.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b hW(long j) throws IOException {
        etA();
        beforeValue();
        this.phL.write(Long.toString(j));
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
        this.phL.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pfB == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.phL.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.phL.close();
        int i = this.pfB;
        if (i > 1 || (i == 1 && this.phI[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pfB = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? phK : phJ;
        this.phL.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.phL.write(str, i2, i - i2);
                }
                this.phL.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.phL.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.phL.write(str, i2, length - i2);
        }
        this.phL.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.phL.write("\n");
            int i = this.pfB;
            for (int i2 = 1; i2 < i; i2++) {
                this.phL.write(this.indent);
            }
        }
    }

    private void etB() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.phL.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        QY(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                QY(2);
                newline();
                return;
            case 2:
                this.phL.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.phL.append((CharSequence) this.separator);
                QY(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        QY(7);
    }
}
