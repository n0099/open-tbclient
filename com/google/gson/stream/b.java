package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] ipn = new String[128];
    private static final String[] ipo;
    private boolean ilH;
    private boolean ilI;
    private boolean ilL;
    private String ipp;
    private String ipq;
    private final Writer out;
    private String separator;
    private int[] ipm = new int[32];
    private int ini = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            ipn[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        ipn[34] = "\\\"";
        ipn[92] = "\\\\";
        ipn[9] = "\\t";
        ipn[8] = "\\b";
        ipn[10] = "\\n";
        ipn[13] = "\\r";
        ipn[12] = "\\f";
        ipo = (String[]) ipn.clone();
        ipo[60] = "\\u003c";
        ipo[62] = "\\u003e";
        ipo[38] = "\\u0026";
        ipo[61] = "\\u003d";
        ipo[39] = "\\u0027";
    }

    public b(Writer writer) {
        yx(6);
        this.separator = ":";
        this.ilH = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.ipp = null;
            this.separator = ":";
            return;
        }
        this.ipp = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.ilL = z;
    }

    public boolean isLenient() {
        return this.ilL;
    }

    public final void pd(boolean z) {
        this.ilI = z;
    }

    public final boolean bYY() {
        return this.ilI;
    }

    public final void pe(boolean z) {
        this.ilH = z;
    }

    public final boolean bYZ() {
        return this.ilH;
    }

    public b bYI() throws IOException {
        bZb();
        return aq(1, "[");
    }

    public b bYJ() throws IOException {
        return k(1, 2, "]");
    }

    public b bYK() throws IOException {
        bZb();
        return aq(3, "{");
    }

    public b bYL() throws IOException {
        return k(3, 5, "}");
    }

    private b aq(int i, String str) throws IOException {
        bZe();
        yx(i);
        this.out.write(str);
        return this;
    }

    private b k(int i, int i2, String str) throws IOException {
        int bZa = bZa();
        if (bZa != i2 && bZa != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.ipq != null) {
            throw new IllegalStateException("Dangling name: " + this.ipq);
        }
        this.ini--;
        if (bZa == i2) {
            bZc();
        }
        this.out.write(str);
        return this;
    }

    private void yx(int i) {
        if (this.ini == this.ipm.length) {
            int[] iArr = new int[this.ini * 2];
            System.arraycopy(this.ipm, 0, iArr, 0, this.ini);
            this.ipm = iArr;
        }
        int[] iArr2 = this.ipm;
        int i2 = this.ini;
        this.ini = i2 + 1;
        iArr2[i2] = i;
    }

    private int bZa() {
        if (this.ini == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.ipm[this.ini - 1];
    }

    private void yz(int i) {
        this.ipm[this.ini - 1] = i;
    }

    public b yQ(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.ipq != null) {
            throw new IllegalStateException();
        }
        if (this.ini == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ipq = str;
        return this;
    }

    private void bZb() throws IOException {
        if (this.ipq != null) {
            bZd();
            yU(this.ipq);
            this.ipq = null;
        }
    }

    public b yR(String str) throws IOException {
        if (str == null) {
            return bYM();
        }
        bZb();
        bZe();
        yU(str);
        return this;
    }

    public b bYM() throws IOException {
        if (this.ipq != null) {
            if (this.ilH) {
                bZb();
            } else {
                this.ipq = null;
                return this;
            }
        }
        bZe();
        this.out.write("null");
        return this;
    }

    public b pb(boolean z) throws IOException {
        bZb();
        bZe();
        this.out.write(z ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b k(Boolean bool) throws IOException {
        if (bool == null) {
            return bYM();
        }
        bZb();
        bZe();
        this.out.write(bool.booleanValue() ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b dq(long j) throws IOException {
        bZb();
        bZe();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return bYM();
        }
        bZb();
        String obj = number.toString();
        if (!this.ilL && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        bZe();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.ini == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.ini;
        if (i > 1 || (i == 1 && this.ipm[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.ini = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void yU(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.ilI ? ipo : ipn;
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

    private void bZc() throws IOException {
        if (this.ipp != null) {
            this.out.write("\n");
            int i = this.ini;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.ipp);
            }
        }
    }

    private void bZd() throws IOException {
        int bZa = bZa();
        if (bZa == 5) {
            this.out.write(44);
        } else if (bZa != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        bZc();
        yz(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void bZe() throws IOException {
        switch (bZa()) {
            case 1:
                yz(2);
                bZc();
                return;
            case 2:
                this.out.append(',');
                bZc();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                yz(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.ilL) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        yz(7);
    }
}
