package com.google.gson.stream;

import com.baidu.mobstat.Config;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] jQe = new String[128];
    private static final String[] jQf;
    private String indent;
    private boolean jMB;
    private boolean jMC;
    private boolean jMF;
    private String jQg;
    private final Writer out;
    private String separator;
    private int[] jQd = new int[32];
    private int jOb = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            jQe[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        jQe[34] = "\\\"";
        jQe[92] = "\\\\";
        jQe[9] = "\\t";
        jQe[8] = "\\b";
        jQe[10] = "\\n";
        jQe[13] = "\\r";
        jQe[12] = "\\f";
        jQf = (String[]) jQe.clone();
        jQf[60] = "\\u003c";
        jQf[62] = "\\u003e";
        jQf[38] = "\\u0026";
        jQf[61] = "\\u003d";
        jQf[39] = "\\u0027";
    }

    public b(Writer writer) {
        CM(6);
        this.separator = Config.TRACE_TODAY_VISIT_SPLIT;
        this.jMB = true;
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
        this.jMF = z;
    }

    public boolean isLenient() {
        return this.jMF;
    }

    public final void rD(boolean z) {
        this.jMC = z;
    }

    public final boolean cBL() {
        return this.jMC;
    }

    public final void rE(boolean z) {
        this.jMB = z;
    }

    public final boolean cBM() {
        return this.jMB;
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
        if (this.jQg != null) {
            throw new IllegalStateException("Dangling name: " + this.jQg);
        }
        this.jOb--;
        if (cBN == i2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private void CM(int i) {
        if (this.jOb == this.jQd.length) {
            int[] iArr = new int[this.jOb * 2];
            System.arraycopy(this.jQd, 0, iArr, 0, this.jOb);
            this.jQd = iArr;
        }
        int[] iArr2 = this.jQd;
        int i2 = this.jOb;
        this.jOb = i2 + 1;
        iArr2[i2] = i;
    }

    private int cBN() {
        if (this.jOb == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.jQd[this.jOb - 1];
    }

    private void CO(int i) {
        this.jQd[this.jOb - 1] = i;
    }

    public b FG(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.jQg != null) {
            throw new IllegalStateException();
        }
        if (this.jOb == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.jQg = str;
        return this;
    }

    private void cBO() throws IOException {
        if (this.jQg != null) {
            cBP();
            string(this.jQg);
            this.jQg = null;
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
        if (this.jQg != null) {
            if (this.jMB) {
                cBO();
            } else {
                this.jQg = null;
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
        if (!this.jMF && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.jOb == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.jOb;
        if (i > 1 || (i == 1 && this.jQd[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.jOb = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.jMC ? jQf : jQe;
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
            int i = this.jOb;
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
                if (!this.jMF) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        CO(7);
    }
}
