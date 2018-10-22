package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] inD = new String[128];
    private static final String[] inE;
    private boolean ijX;
    private boolean ijY;
    private boolean ikb;
    private String inF;
    private String inG;
    private final Writer out;
    private String separator;
    private int[] inC = new int[32];
    private int ilx = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            inD[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        inD[34] = "\\\"";
        inD[92] = "\\\\";
        inD[9] = "\\t";
        inD[8] = "\\b";
        inD[10] = "\\n";
        inD[13] = "\\r";
        inD[12] = "\\f";
        inE = (String[]) inD.clone();
        inE[60] = "\\u003c";
        inE[62] = "\\u003e";
        inE[38] = "\\u0026";
        inE[61] = "\\u003d";
        inE[39] = "\\u0027";
    }

    public b(Writer writer) {
        ye(6);
        this.separator = ":";
        this.ijX = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.inF = null;
            this.separator = ":";
            return;
        }
        this.inF = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.ikb = z;
    }

    public boolean isLenient() {
        return this.ikb;
    }

    public final void oQ(boolean z) {
        this.ijY = z;
    }

    public final boolean bZB() {
        return this.ijY;
    }

    public final void oR(boolean z) {
        this.ijX = z;
    }

    public final boolean bZC() {
        return this.ijX;
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
        if (this.inG != null) {
            throw new IllegalStateException("Dangling name: " + this.inG);
        }
        this.ilx--;
        if (bZD == i2) {
            bZF();
        }
        this.out.write(str);
        return this;
    }

    private void ye(int i) {
        if (this.ilx == this.inC.length) {
            int[] iArr = new int[this.ilx * 2];
            System.arraycopy(this.inC, 0, iArr, 0, this.ilx);
            this.inC = iArr;
        }
        int[] iArr2 = this.inC;
        int i2 = this.ilx;
        this.ilx = i2 + 1;
        iArr2[i2] = i;
    }

    private int bZD() {
        if (this.ilx == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.inC[this.ilx - 1];
    }

    private void yg(int i) {
        this.inC[this.ilx - 1] = i;
    }

    public b yL(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.inG != null) {
            throw new IllegalStateException();
        }
        if (this.ilx == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.inG = str;
        return this;
    }

    private void bZE() throws IOException {
        if (this.inG != null) {
            bZG();
            yP(this.inG);
            this.inG = null;
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
        if (this.inG != null) {
            if (this.ijX) {
                bZE();
            } else {
                this.inG = null;
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
        if (!this.ikb && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        bZH();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.ilx == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.ilx;
        if (i > 1 || (i == 1 && this.inC[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.ilx = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void yP(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.ijY ? inE : inD;
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
        if (this.inF != null) {
            this.out.write("\n");
            int i = this.ilx;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.inF);
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
                if (!this.ikb) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        yg(7);
    }
}
