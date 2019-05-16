package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] kix = new String[128];
    private static final String[] kiy;
    private String indent;
    private boolean kfm;
    private boolean kfn;
    private boolean kfq;
    private String kiB;
    private final Writer out;
    private String separator;
    private int[] kiz = new int[32];
    private int kiA = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            kix[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        kix[34] = "\\\"";
        kix[92] = "\\\\";
        kix[9] = "\\t";
        kix[8] = "\\b";
        kix[10] = "\\n";
        kix[13] = "\\r";
        kix[12] = "\\f";
        kiy = (String[]) kix.clone();
        kiy[60] = "\\u003c";
        kiy[62] = "\\u003e";
        kiy[38] = "\\u0026";
        kiy[61] = "\\u003d";
        kiy[39] = "\\u0027";
    }

    public a(Writer writer) {
        DQ(6);
        this.separator = ":";
        this.kfm = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.kfq = z;
    }

    public boolean isLenient() {
        return this.kfq;
    }

    public final void sr(boolean z) {
        this.kfn = z;
    }

    public final boolean cJt() {
        return this.kfn;
    }

    public final void ss(boolean z) {
        this.kfm = z;
    }

    public final boolean cJu() {
        return this.kfm;
    }

    public a cJm() throws IOException {
        cJw();
        return aN(1, "[");
    }

    public a cJn() throws IOException {
        return m(1, 2, "]");
    }

    public a cJo() throws IOException {
        cJw();
        return aN(3, "{");
    }

    public a cJp() throws IOException {
        return m(3, 5, "}");
    }

    private a aN(int i, String str) throws IOException {
        beforeValue();
        DQ(i);
        this.out.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cJv = cJv();
        if (cJv != i2 && cJv != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.kiB != null) {
            throw new IllegalStateException("Dangling name: " + this.kiB);
        }
        this.kiA--;
        if (cJv == i2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private void DQ(int i) {
        if (this.kiA == this.kiz.length) {
            int[] iArr = new int[this.kiA * 2];
            System.arraycopy(this.kiz, 0, iArr, 0, this.kiA);
            this.kiz = iArr;
        }
        int[] iArr2 = this.kiz;
        int i2 = this.kiA;
        this.kiA = i2 + 1;
        iArr2[i2] = i;
    }

    private int cJv() {
        if (this.kiA == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.kiz[this.kiA - 1];
    }

    private void DR(int i) {
        this.kiz[this.kiA - 1] = i;
    }

    public a Ha(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.kiB != null) {
            throw new IllegalStateException();
        }
        if (this.kiA == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kiB = str;
        return this;
    }

    private void cJw() throws IOException {
        if (this.kiB != null) {
            cJx();
            string(this.kiB);
            this.kiB = null;
        }
    }

    public a Hb(String str) throws IOException {
        if (str == null) {
            return cJq();
        }
        cJw();
        beforeValue();
        string(str);
        return this;
    }

    public a cJq() throws IOException {
        if (this.kiB != null) {
            if (this.kfm) {
                cJw();
            } else {
                this.kiB = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public a sq(boolean z) throws IOException {
        cJw();
        beforeValue();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cJq();
        }
        cJw();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a eF(long j) throws IOException {
        cJw();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cJq();
        }
        cJw();
        String obj = number.toString();
        if (!this.kfq && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.kiA == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.kiA;
        if (i > 1 || (i == 1 && this.kiz[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.kiA = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.kfn ? kiy : kix;
        this.out.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.out.write(str, i2, i - i2);
                }
                this.out.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.out.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.out.write(str, i2, length - i2);
        }
        this.out.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.out.write("\n");
            int i = this.kiA;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.indent);
            }
        }
    }

    private void cJx() throws IOException {
        int cJv = cJv();
        if (cJv == 5) {
            this.out.write(44);
        } else if (cJv != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        DR(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cJv()) {
            case 1:
                DR(2);
                newline();
                return;
            case 2:
                this.out.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                DR(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.kfq) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        DR(7);
    }
}
