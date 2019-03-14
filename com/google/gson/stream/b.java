package com.google.gson.stream;

import com.baidu.mobstat.Config;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] jQL = new String[128];
    private static final String[] jQM;
    private boolean jNh;
    private boolean jNi;
    private boolean jNl;
    private String jQN;
    private String jQO;
    private final Writer out;
    private String separator;
    private int[] jQK = new int[32];
    private int jOH = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            jQL[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        jQL[34] = "\\\"";
        jQL[92] = "\\\\";
        jQL[9] = "\\t";
        jQL[8] = "\\b";
        jQL[10] = "\\n";
        jQL[13] = "\\r";
        jQL[12] = "\\f";
        jQM = (String[]) jQL.clone();
        jQM[60] = "\\u003c";
        jQM[62] = "\\u003e";
        jQM[38] = "\\u0026";
        jQM[61] = "\\u003d";
        jQM[39] = "\\u0027";
    }

    public b(Writer writer) {
        CW(6);
        this.separator = Config.TRACE_TODAY_VISIT_SPLIT;
        this.jNh = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.jQN = null;
            this.separator = Config.TRACE_TODAY_VISIT_SPLIT;
            return;
        }
        this.jQN = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.jNl = z;
    }

    public boolean isLenient() {
        return this.jNl;
    }

    public final void rD(boolean z) {
        this.jNi = z;
    }

    public final boolean cBU() {
        return this.jNi;
    }

    public final void rE(boolean z) {
        this.jNh = z;
    }

    public final boolean cBV() {
        return this.jNh;
    }

    public b cBE() throws IOException {
        cBX();
        return aJ(1, "[");
    }

    public b cBF() throws IOException {
        return l(1, 2, "]");
    }

    public b cBG() throws IOException {
        cBX();
        return aJ(3, "{");
    }

    public b cBH() throws IOException {
        return l(3, 5, "}");
    }

    private b aJ(int i, String str) throws IOException {
        cCa();
        CW(i);
        this.out.write(str);
        return this;
    }

    private b l(int i, int i2, String str) throws IOException {
        int cBW = cBW();
        if (cBW != i2 && cBW != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.jQO != null) {
            throw new IllegalStateException("Dangling name: " + this.jQO);
        }
        this.jOH--;
        if (cBW == i2) {
            cBY();
        }
        this.out.write(str);
        return this;
    }

    private void CW(int i) {
        if (this.jOH == this.jQK.length) {
            int[] iArr = new int[this.jOH * 2];
            System.arraycopy(this.jQK, 0, iArr, 0, this.jOH);
            this.jQK = iArr;
        }
        int[] iArr2 = this.jQK;
        int i2 = this.jOH;
        this.jOH = i2 + 1;
        iArr2[i2] = i;
    }

    private int cBW() {
        if (this.jOH == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.jQK[this.jOH - 1];
    }

    private void CY(int i) {
        this.jQK[this.jOH - 1] = i;
    }

    public b FQ(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.jQO != null) {
            throw new IllegalStateException();
        }
        if (this.jOH == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.jQO = str;
        return this;
    }

    private void cBX() throws IOException {
        if (this.jQO != null) {
            cBZ();
            FU(this.jQO);
            this.jQO = null;
        }
    }

    public b FR(String str) throws IOException {
        if (str == null) {
            return cBI();
        }
        cBX();
        cCa();
        FU(str);
        return this;
    }

    public b cBI() throws IOException {
        if (this.jQO != null) {
            if (this.jNh) {
                cBX();
            } else {
                this.jQO = null;
                return this;
            }
        }
        cCa();
        this.out.write("null");
        return this;
    }

    public b rB(boolean z) throws IOException {
        cBX();
        cCa();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public b m(Boolean bool) throws IOException {
        if (bool == null) {
            return cBI();
        }
        cBX();
        cCa();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b eh(long j) throws IOException {
        cBX();
        cCa();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return cBI();
        }
        cBX();
        String obj = number.toString();
        if (!this.jNl && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        cCa();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.jOH == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.jOH;
        if (i > 1 || (i == 1 && this.jQK[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.jOH = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void FU(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.jNi ? jQM : jQL;
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

    private void cBY() throws IOException {
        if (this.jQN != null) {
            this.out.write("\n");
            int i = this.jOH;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.jQN);
            }
        }
    }

    private void cBZ() throws IOException {
        int cBW = cBW();
        if (cBW == 5) {
            this.out.write(44);
        } else if (cBW != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        cBY();
        CY(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void cCa() throws IOException {
        switch (cBW()) {
            case 1:
                CY(2);
                cBY();
                return;
            case 2:
                this.out.append(',');
                cBY();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                CY(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.jNl) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        CY(7);
    }
}
