package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] inC = new String[128];
    private static final String[] inD;
    private boolean ijW;
    private boolean ijX;
    private boolean ika;
    private String inE;
    private String inF;
    private final Writer out;
    private String separator;
    private int[] inB = new int[32];
    private int ilw = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            inC[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        inC[34] = "\\\"";
        inC[92] = "\\\\";
        inC[9] = "\\t";
        inC[8] = "\\b";
        inC[10] = "\\n";
        inC[13] = "\\r";
        inC[12] = "\\f";
        inD = (String[]) inC.clone();
        inD[60] = "\\u003c";
        inD[62] = "\\u003e";
        inD[38] = "\\u0026";
        inD[61] = "\\u003d";
        inD[39] = "\\u0027";
    }

    public b(Writer writer) {
        ye(6);
        this.separator = ":";
        this.ijW = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.inE = null;
            this.separator = ":";
            return;
        }
        this.inE = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.ika = z;
    }

    public boolean isLenient() {
        return this.ika;
    }

    public final void oQ(boolean z) {
        this.ijX = z;
    }

    public final boolean bZB() {
        return this.ijX;
    }

    public final void oR(boolean z) {
        this.ijW = z;
    }

    public final boolean bZC() {
        return this.ijW;
    }

    public b bZl() throws IOException {
        bZE();
        return au(1, "[");
    }

    public b bZm() throws IOException {
        return k(1, 2, "]");
    }

    public b bZn() throws IOException {
        bZE();
        return au(3, "{");
    }

    public b bZo() throws IOException {
        return k(3, 5, "}");
    }

    private b au(int i, String str) throws IOException {
        bZH();
        ye(i);
        this.out.write(str);
        return this;
    }

    private b k(int i, int i2, String str) throws IOException {
        int bZD = bZD();
        if (bZD != i2 && bZD != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.inF != null) {
            throw new IllegalStateException("Dangling name: " + this.inF);
        }
        this.ilw--;
        if (bZD == i2) {
            bZF();
        }
        this.out.write(str);
        return this;
    }

    private void ye(int i) {
        if (this.ilw == this.inB.length) {
            int[] iArr = new int[this.ilw * 2];
            System.arraycopy(this.inB, 0, iArr, 0, this.ilw);
            this.inB = iArr;
        }
        int[] iArr2 = this.inB;
        int i2 = this.ilw;
        this.ilw = i2 + 1;
        iArr2[i2] = i;
    }

    private int bZD() {
        if (this.ilw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.inB[this.ilw - 1];
    }

    private void yg(int i) {
        this.inB[this.ilw - 1] = i;
    }

    public b yL(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.inF != null) {
            throw new IllegalStateException();
        }
        if (this.ilw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.inF = str;
        return this;
    }

    private void bZE() throws IOException {
        if (this.inF != null) {
            bZG();
            yP(this.inF);
            this.inF = null;
        }
    }

    public b yM(String str) throws IOException {
        if (str == null) {
            return bZp();
        }
        bZE();
        bZH();
        yP(str);
        return this;
    }

    public b bZp() throws IOException {
        if (this.inF != null) {
            if (this.ijW) {
                bZE();
            } else {
                this.inF = null;
                return this;
            }
        }
        bZH();
        this.out.write("null");
        return this;
    }

    public b oO(boolean z) throws IOException {
        bZE();
        bZH();
        this.out.write(z ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b k(Boolean bool) throws IOException {
        if (bool == null) {
            return bZp();
        }
        bZE();
        bZH();
        this.out.write(bool.booleanValue() ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b dv(long j) throws IOException {
        bZE();
        bZH();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return bZp();
        }
        bZE();
        String obj = number.toString();
        if (!this.ika && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        bZH();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.ilw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.ilw;
        if (i > 1 || (i == 1 && this.inB[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.ilw = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void yP(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.ijX ? inD : inC;
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

    private void bZF() throws IOException {
        if (this.inE != null) {
            this.out.write("\n");
            int i = this.ilw;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.inE);
            }
        }
    }

    private void bZG() throws IOException {
        int bZD = bZD();
        if (bZD == 5) {
            this.out.write(44);
        } else if (bZD != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        bZF();
        yg(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void bZH() throws IOException {
        switch (bZD()) {
            case 1:
                yg(2);
                bZF();
                return;
            case 2:
                this.out.append(',');
                bZF();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                yg(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.ika) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        yg(7);
    }
}
