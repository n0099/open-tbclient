package com.google.gson.stream;

import com.baidu.mobstat.Config;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] jQf = new String[128];
    private static final String[] jQg;
    private String indent;
    private boolean jMC;
    private boolean jMD;
    private boolean jMG;
    private String jQh;
    private final Writer out;
    private String separator;
    private int[] jQe = new int[32];
    private int jOc = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            jQf[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        jQf[34] = "\\\"";
        jQf[92] = "\\\\";
        jQf[9] = "\\t";
        jQf[8] = "\\b";
        jQf[10] = "\\n";
        jQf[13] = "\\r";
        jQf[12] = "\\f";
        jQg = (String[]) jQf.clone();
        jQg[60] = "\\u003c";
        jQg[62] = "\\u003e";
        jQg[38] = "\\u0026";
        jQg[61] = "\\u003d";
        jQg[39] = "\\u0027";
    }

    public b(Writer writer) {
        CM(6);
        this.separator = Config.TRACE_TODAY_VISIT_SPLIT;
        this.jMC = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = Config.TRACE_TODAY_VISIT_SPLIT;
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.jMG = z;
    }

    public boolean isLenient() {
        return this.jMG;
    }

    public final void rD(boolean z) {
        this.jMD = z;
    }

    public final boolean cBL() {
        return this.jMD;
    }

    public final void rE(boolean z) {
        this.jMC = z;
    }

    public final boolean cBM() {
        return this.jMC;
    }

    public b cBx() throws IOException {
        cBO();
        return aK(1, "[");
    }

    public b cBy() throws IOException {
        return l(1, 2, "]");
    }

    public b cBz() throws IOException {
        cBO();
        return aK(3, "{");
    }

    public b cBA() throws IOException {
        return l(3, 5, "}");
    }

    private b aK(int i, String str) throws IOException {
        beforeValue();
        CM(i);
        this.out.write(str);
        return this;
    }

    private b l(int i, int i2, String str) throws IOException {
        int cBN = cBN();
        if (cBN != i2 && cBN != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.jQh != null) {
            throw new IllegalStateException("Dangling name: " + this.jQh);
        }
        this.jOc--;
        if (cBN == i2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private void CM(int i) {
        if (this.jOc == this.jQe.length) {
            int[] iArr = new int[this.jOc * 2];
            System.arraycopy(this.jQe, 0, iArr, 0, this.jOc);
            this.jQe = iArr;
        }
        int[] iArr2 = this.jQe;
        int i2 = this.jOc;
        this.jOc = i2 + 1;
        iArr2[i2] = i;
    }

    private int cBN() {
        if (this.jOc == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.jQe[this.jOc - 1];
    }

    private void CO(int i) {
        this.jQe[this.jOc - 1] = i;
    }

    public b FG(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.jQh != null) {
            throw new IllegalStateException();
        }
        if (this.jOc == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.jQh = str;
        return this;
    }

    private void cBO() throws IOException {
        if (this.jQh != null) {
            cBP();
            string(this.jQh);
            this.jQh = null;
        }
    }

    public b FH(String str) throws IOException {
        if (str == null) {
            return cBB();
        }
        cBO();
        beforeValue();
        string(str);
        return this;
    }

    public b cBB() throws IOException {
        if (this.jQh != null) {
            if (this.jMC) {
                cBO();
            } else {
                this.jQh = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public b rB(boolean z) throws IOException {
        cBO();
        beforeValue();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public b m(Boolean bool) throws IOException {
        if (bool == null) {
            return cBB();
        }
        cBO();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b eg(long j) throws IOException {
        cBO();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return cBB();
        }
        cBO();
        String obj = number.toString();
        if (!this.jMG && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.jOc == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.jOc;
        if (i > 1 || (i == 1 && this.jQe[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.jOc = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.jMD ? jQg : jQf;
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
            int i = this.jOc;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.indent);
            }
        }
    }

    private void cBP() throws IOException {
        int cBN = cBN();
        if (cBN == 5) {
            this.out.write(44);
        } else if (cBN != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        CO(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cBN()) {
            case 1:
                CO(2);
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
                CO(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.jMG) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        CO(7);
    }
}
