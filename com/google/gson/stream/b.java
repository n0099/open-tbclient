package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] iAP = new String[128];
    private static final String[] iAQ;
    private String iAR;
    private String iAS;
    private boolean ixl;
    private boolean ixm;
    private boolean ixp;
    private final Writer out;
    private String separator;
    private int[] iAO = new int[32];
    private int iyL = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            iAP[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        iAP[34] = "\\\"";
        iAP[92] = "\\\\";
        iAP[9] = "\\t";
        iAP[8] = "\\b";
        iAP[10] = "\\n";
        iAP[13] = "\\r";
        iAP[12] = "\\f";
        iAQ = (String[]) iAP.clone();
        iAQ[60] = "\\u003c";
        iAQ[62] = "\\u003e";
        iAQ[38] = "\\u0026";
        iAQ[61] = "\\u003d";
        iAQ[39] = "\\u0027";
    }

    public b(Writer writer) {
        zj(6);
        this.separator = ":";
        this.ixl = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.iAR = null;
            this.separator = ":";
            return;
        }
        this.iAR = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.ixp = z;
    }

    public boolean isLenient() {
        return this.ixp;
    }

    public final void pj(boolean z) {
        this.ixm = z;
    }

    public final boolean ccC() {
        return this.ixm;
    }

    public final void pk(boolean z) {
        this.ixl = z;
    }

    public final boolean ccD() {
        return this.ixl;
    }

    public b ccm() throws IOException {
        ccF();
        return at(1, "[");
    }

    public b ccn() throws IOException {
        return j(1, 2, "]");
    }

    public b cco() throws IOException {
        ccF();
        return at(3, "{");
    }

    public b ccp() throws IOException {
        return j(3, 5, "}");
    }

    private b at(int i, String str) throws IOException {
        ccI();
        zj(i);
        this.out.write(str);
        return this;
    }

    private b j(int i, int i2, String str) throws IOException {
        int ccE = ccE();
        if (ccE != i2 && ccE != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.iAS != null) {
            throw new IllegalStateException("Dangling name: " + this.iAS);
        }
        this.iyL--;
        if (ccE == i2) {
            ccG();
        }
        this.out.write(str);
        return this;
    }

    private void zj(int i) {
        if (this.iyL == this.iAO.length) {
            int[] iArr = new int[this.iyL * 2];
            System.arraycopy(this.iAO, 0, iArr, 0, this.iyL);
            this.iAO = iArr;
        }
        int[] iArr2 = this.iAO;
        int i2 = this.iyL;
        this.iyL = i2 + 1;
        iArr2[i2] = i;
    }

    private int ccE() {
        if (this.iyL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.iAO[this.iyL - 1];
    }

    private void zl(int i) {
        this.iAO[this.iyL - 1] = i;
    }

    public b zM(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.iAS != null) {
            throw new IllegalStateException();
        }
        if (this.iyL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.iAS = str;
        return this;
    }

    private void ccF() throws IOException {
        if (this.iAS != null) {
            ccH();
            zQ(this.iAS);
            this.iAS = null;
        }
    }

    public b zN(String str) throws IOException {
        if (str == null) {
            return ccq();
        }
        ccF();
        ccI();
        zQ(str);
        return this;
    }

    public b ccq() throws IOException {
        if (this.iAS != null) {
            if (this.ixl) {
                ccF();
            } else {
                this.iAS = null;
                return this;
            }
        }
        ccI();
        this.out.write("null");
        return this;
    }

    public b ph(boolean z) throws IOException {
        ccF();
        ccI();
        this.out.write(z ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b k(Boolean bool) throws IOException {
        if (bool == null) {
            return ccq();
        }
        ccF();
        ccI();
        this.out.write(bool.booleanValue() ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b dC(long j) throws IOException {
        ccF();
        ccI();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return ccq();
        }
        ccF();
        String obj = number.toString();
        if (!this.ixp && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        ccI();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.iyL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.iyL;
        if (i > 1 || (i == 1 && this.iAO[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.iyL = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zQ(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.ixm ? iAQ : iAP;
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

    private void ccG() throws IOException {
        if (this.iAR != null) {
            this.out.write("\n");
            int i = this.iyL;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.iAR);
            }
        }
    }

    private void ccH() throws IOException {
        int ccE = ccE();
        if (ccE == 5) {
            this.out.write(44);
        } else if (ccE != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        ccG();
        zl(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void ccI() throws IOException {
        switch (ccE()) {
            case 1:
                zl(2);
                ccG();
                return;
            case 2:
                this.out.append(',');
                ccG();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                zl(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.ixp) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        zl(7);
    }
}
