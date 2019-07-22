package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] kpG = new String[128];
    private static final String[] kpH;
    private String indent;
    private boolean kmA;
    private boolean kmw;
    private boolean kmx;
    private final Writer kpI;
    private int[] kpJ = new int[32];
    private int kpK = 0;
    private String kpL;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            kpG[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        kpG[34] = "\\\"";
        kpG[92] = "\\\\";
        kpG[9] = "\\t";
        kpG[8] = "\\b";
        kpG[10] = "\\n";
        kpG[13] = "\\r";
        kpG[12] = "\\f";
        kpH = (String[]) kpG.clone();
        kpH[60] = "\\u003c";
        kpH[62] = "\\u003e";
        kpH[38] = "\\u0026";
        kpH[61] = "\\u003d";
        kpH[39] = "\\u0027";
    }

    public a(Writer writer) {
        Ex(6);
        this.separator = ":";
        this.kmw = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.kpI = writer;
    }

    public final void HY(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void sH(boolean z) {
        this.kmA = z;
    }

    public boolean cMA() {
        return this.kmA;
    }

    public final void sI(boolean z) {
        this.kmx = z;
    }

    public final boolean cMB() {
        return this.kmx;
    }

    public final void sJ(boolean z) {
        this.kmw = z;
    }

    public final boolean cMC() {
        return this.kmw;
    }

    public a cMt() throws IOException {
        cME();
        return aN(1, "[");
    }

    public a cMu() throws IOException {
        return m(1, 2, "]");
    }

    public a cMv() throws IOException {
        cME();
        return aN(3, "{");
    }

    public a cMw() throws IOException {
        return m(3, 5, "}");
    }

    private a aN(int i, String str) throws IOException {
        beforeValue();
        Ex(i);
        this.kpI.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cMD = cMD();
        if (cMD != i2 && cMD != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.kpL != null) {
            throw new IllegalStateException("Dangling name: " + this.kpL);
        }
        this.kpK--;
        if (cMD == i2) {
            newline();
        }
        this.kpI.write(str);
        return this;
    }

    private void Ex(int i) {
        if (this.kpK == this.kpJ.length) {
            int[] iArr = new int[this.kpK * 2];
            System.arraycopy(this.kpJ, 0, iArr, 0, this.kpK);
            this.kpJ = iArr;
        }
        int[] iArr2 = this.kpJ;
        int i2 = this.kpK;
        this.kpK = i2 + 1;
        iArr2[i2] = i;
    }

    private int cMD() {
        if (this.kpK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.kpJ[this.kpK - 1];
    }

    private void Ey(int i) {
        this.kpJ[this.kpK - 1] = i;
    }

    public a HW(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.kpL != null) {
            throw new IllegalStateException();
        }
        if (this.kpK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kpL = str;
        return this;
    }

    private void cME() throws IOException {
        if (this.kpL != null) {
            cMF();
            string(this.kpL);
            this.kpL = null;
        }
    }

    public a HX(String str) throws IOException {
        if (str == null) {
            return cMx();
        }
        cME();
        beforeValue();
        string(str);
        return this;
    }

    public a cMx() throws IOException {
        if (this.kpL != null) {
            if (this.kmw) {
                cME();
            } else {
                this.kpL = null;
                return this;
            }
        }
        beforeValue();
        this.kpI.write("null");
        return this;
    }

    public a sG(boolean z) throws IOException {
        cME();
        beforeValue();
        this.kpI.write(z ? "true" : "false");
        return this;
    }

    public a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cMx();
        }
        cME();
        beforeValue();
        this.kpI.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a eN(long j) throws IOException {
        cME();
        beforeValue();
        this.kpI.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cMx();
        }
        cME();
        String obj = number.toString();
        if (!this.kmA && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.kpI.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.kpK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kpI.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.kpI.close();
        int i = this.kpK;
        if (i > 1 || (i == 1 && this.kpJ[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.kpK = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.kmx ? kpH : kpG;
        this.kpI.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.kpI.write(str, i2, i - i2);
                }
                this.kpI.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.kpI.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.kpI.write(str, i2, length - i2);
        }
        this.kpI.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.kpI.write("\n");
            int i = this.kpK;
            for (int i2 = 1; i2 < i; i2++) {
                this.kpI.write(this.indent);
            }
        }
    }

    private void cMF() throws IOException {
        int cMD = cMD();
        if (cMD == 5) {
            this.kpI.write(44);
        } else if (cMD != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Ey(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cMD()) {
            case 1:
                Ey(2);
                newline();
                return;
            case 2:
                this.kpI.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.kpI.append((CharSequence) this.separator);
                Ey(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.kmA) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Ey(7);
    }
}
