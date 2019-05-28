package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] kiy = new String[128];
    private static final String[] kiz;
    private String indent;
    private boolean kfn;
    private boolean kfo;
    private boolean kfr;
    private int[] kiA = new int[32];
    private int kiB = 0;
    private String kiC;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            kiy[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        kiy[34] = "\\\"";
        kiy[92] = "\\\\";
        kiy[9] = "\\t";
        kiy[8] = "\\b";
        kiy[10] = "\\n";
        kiy[13] = "\\r";
        kiy[12] = "\\f";
        kiz = (String[]) kiy.clone();
        kiz[60] = "\\u003c";
        kiz[62] = "\\u003e";
        kiz[38] = "\\u0026";
        kiz[61] = "\\u003d";
        kiz[39] = "\\u0027";
    }

    public a(Writer writer) {
        DQ(6);
        this.separator = ":";
        this.kfn = true;
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
        this.kfr = z;
    }

    public boolean isLenient() {
        return this.kfr;
    }

    public final void sr(boolean z) {
        this.kfo = z;
    }

    public final boolean cJv() {
        return this.kfo;
    }

    public final void ss(boolean z) {
        this.kfn = z;
    }

    public final boolean cJw() {
        return this.kfn;
    }

    public a cJo() throws IOException {
        cJy();
        return aN(1, "[");
    }

    public a cJp() throws IOException {
        return m(1, 2, "]");
    }

    public a cJq() throws IOException {
        cJy();
        return aN(3, "{");
    }

    public a cJr() throws IOException {
        return m(3, 5, "}");
    }

    private a aN(int i, String str) throws IOException {
        beforeValue();
        DQ(i);
        this.out.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cJx = cJx();
        if (cJx != i2 && cJx != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.kiC != null) {
            throw new IllegalStateException("Dangling name: " + this.kiC);
        }
        this.kiB--;
        if (cJx == i2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private void DQ(int i) {
        if (this.kiB == this.kiA.length) {
            int[] iArr = new int[this.kiB * 2];
            System.arraycopy(this.kiA, 0, iArr, 0, this.kiB);
            this.kiA = iArr;
        }
        int[] iArr2 = this.kiA;
        int i2 = this.kiB;
        this.kiB = i2 + 1;
        iArr2[i2] = i;
    }

    private int cJx() {
        if (this.kiB == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.kiA[this.kiB - 1];
    }

    private void DR(int i) {
        this.kiA[this.kiB - 1] = i;
    }

    public a Ha(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.kiC != null) {
            throw new IllegalStateException();
        }
        if (this.kiB == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kiC = str;
        return this;
    }

    private void cJy() throws IOException {
        if (this.kiC != null) {
            cJz();
            string(this.kiC);
            this.kiC = null;
        }
    }

    public a Hb(String str) throws IOException {
        if (str == null) {
            return cJs();
        }
        cJy();
        beforeValue();
        string(str);
        return this;
    }

    public a cJs() throws IOException {
        if (this.kiC != null) {
            if (this.kfn) {
                cJy();
            } else {
                this.kiC = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public a sq(boolean z) throws IOException {
        cJy();
        beforeValue();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cJs();
        }
        cJy();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a eF(long j) throws IOException {
        cJy();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cJs();
        }
        cJy();
        String obj = number.toString();
        if (!this.kfr && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.kiB == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.kiB;
        if (i > 1 || (i == 1 && this.kiA[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.kiB = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.kfo ? kiz : kiy;
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
            int i = this.kiB;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.indent);
            }
        }
    }

    private void cJz() throws IOException {
        int cJx = cJx();
        if (cJx == 5) {
            this.out.write(44);
        } else if (cJx != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        DR(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cJx()) {
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
                if (!this.kfr) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        DR(7);
    }
}
