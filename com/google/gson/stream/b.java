package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] iAO = new String[128];
    private static final String[] iAP;
    private String iAQ;
    private String iAR;
    private boolean ixk;
    private boolean ixl;
    private boolean ixo;
    private final Writer out;
    private String separator;
    private int[] iAN = new int[32];
    private int iyK = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            iAO[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        iAO[34] = "\\\"";
        iAO[92] = "\\\\";
        iAO[9] = "\\t";
        iAO[8] = "\\b";
        iAO[10] = "\\n";
        iAO[13] = "\\r";
        iAO[12] = "\\f";
        iAP = (String[]) iAO.clone();
        iAP[60] = "\\u003c";
        iAP[62] = "\\u003e";
        iAP[38] = "\\u0026";
        iAP[61] = "\\u003d";
        iAP[39] = "\\u0027";
    }

    public b(Writer writer) {
        zj(6);
        this.separator = ":";
        this.ixk = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.iAQ = null;
            this.separator = ":";
            return;
        }
        this.iAQ = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.ixo = z;
    }

    public boolean isLenient() {
        return this.ixo;
    }

    public final void pj(boolean z) {
        this.ixl = z;
    }

    public final boolean ccC() {
        return this.ixl;
    }

    public final void pk(boolean z) {
        this.ixk = z;
    }

    public final boolean ccD() {
        return this.ixk;
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
        if (this.iAR != null) {
            throw new IllegalStateException("Dangling name: " + this.iAR);
        }
        this.iyK--;
        if (ccE == i2) {
            ccG();
        }
        this.out.write(str);
        return this;
    }

    private void zj(int i) {
        if (this.iyK == this.iAN.length) {
            int[] iArr = new int[this.iyK * 2];
            System.arraycopy(this.iAN, 0, iArr, 0, this.iyK);
            this.iAN = iArr;
        }
        int[] iArr2 = this.iAN;
        int i2 = this.iyK;
        this.iyK = i2 + 1;
        iArr2[i2] = i;
    }

    private int ccE() {
        if (this.iyK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.iAN[this.iyK - 1];
    }

    private void zl(int i) {
        this.iAN[this.iyK - 1] = i;
    }

    public b zM(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.iAR != null) {
            throw new IllegalStateException();
        }
        if (this.iyK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.iAR = str;
        return this;
    }

    private void ccF() throws IOException {
        if (this.iAR != null) {
            ccH();
            zQ(this.iAR);
            this.iAR = null;
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
        if (this.iAR != null) {
            if (this.ixk) {
                ccF();
            } else {
                this.iAR = null;
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
        if (!this.ixo && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        ccI();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.iyK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.iyK;
        if (i > 1 || (i == 1 && this.iAN[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.iyK = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zQ(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.ixl ? iAP : iAO;
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
        if (this.iAQ != null) {
            this.out.write("\n");
            int i = this.iyK;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.iAQ);
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
                if (!this.ixo) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        zl(7);
    }
}
