package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] kiB = new String[128];
    private static final String[] kiC;
    private String indent;
    private boolean kfq;
    private boolean kfr;
    private boolean kfu;
    private int[] kiD = new int[32];
    private int kiE = 0;
    private String kiF;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            kiB[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        kiB[34] = "\\\"";
        kiB[92] = "\\\\";
        kiB[9] = "\\t";
        kiB[8] = "\\b";
        kiB[10] = "\\n";
        kiB[13] = "\\r";
        kiB[12] = "\\f";
        kiC = (String[]) kiB.clone();
        kiC[60] = "\\u003c";
        kiC[62] = "\\u003e";
        kiC[38] = "\\u0026";
        kiC[61] = "\\u003d";
        kiC[39] = "\\u0027";
    }

    public a(Writer writer) {
        DQ(6);
        this.separator = ":";
        this.kfq = true;
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
        this.kfu = z;
    }

    public boolean isLenient() {
        return this.kfu;
    }

    public final void ss(boolean z) {
        this.kfr = z;
    }

    public final boolean cJu() {
        return this.kfr;
    }

    public final void st(boolean z) {
        this.kfq = z;
    }

    public final boolean cJv() {
        return this.kfq;
    }

    public a cJn() throws IOException {
        cJx();
        return aN(1, "[");
    }

    public a cJo() throws IOException {
        return m(1, 2, "]");
    }

    public a cJp() throws IOException {
        cJx();
        return aN(3, "{");
    }

    public a cJq() throws IOException {
        return m(3, 5, "}");
    }

    private a aN(int i, String str) throws IOException {
        beforeValue();
        DQ(i);
        this.out.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cJw = cJw();
        if (cJw != i2 && cJw != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.kiF != null) {
            throw new IllegalStateException("Dangling name: " + this.kiF);
        }
        this.kiE--;
        if (cJw == i2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private void DQ(int i) {
        if (this.kiE == this.kiD.length) {
            int[] iArr = new int[this.kiE * 2];
            System.arraycopy(this.kiD, 0, iArr, 0, this.kiE);
            this.kiD = iArr;
        }
        int[] iArr2 = this.kiD;
        int i2 = this.kiE;
        this.kiE = i2 + 1;
        iArr2[i2] = i;
    }

    private int cJw() {
        if (this.kiE == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.kiD[this.kiE - 1];
    }

    private void DR(int i) {
        this.kiD[this.kiE - 1] = i;
    }

    public a Hc(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.kiF != null) {
            throw new IllegalStateException();
        }
        if (this.kiE == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kiF = str;
        return this;
    }

    private void cJx() throws IOException {
        if (this.kiF != null) {
            cJy();
            string(this.kiF);
            this.kiF = null;
        }
    }

    public a Hd(String str) throws IOException {
        if (str == null) {
            return cJr();
        }
        cJx();
        beforeValue();
        string(str);
        return this;
    }

    public a cJr() throws IOException {
        if (this.kiF != null) {
            if (this.kfq) {
                cJx();
            } else {
                this.kiF = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public a sr(boolean z) throws IOException {
        cJx();
        beforeValue();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cJr();
        }
        cJx();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a eF(long j) throws IOException {
        cJx();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cJr();
        }
        cJx();
        String obj = number.toString();
        if (!this.kfu && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.kiE == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.kiE;
        if (i > 1 || (i == 1 && this.kiD[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.kiE = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.kfr ? kiC : kiB;
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
            int i = this.kiE;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.indent);
            }
        }
    }

    private void cJy() throws IOException {
        int cJw = cJw();
        if (cJw == 5) {
            this.out.write(44);
        } else if (cJw != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        DR(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cJw()) {
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
                if (!this.kfu) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        DR(7);
    }
}
