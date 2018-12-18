package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] iwx = new String[128];
    private static final String[] iwy;
    private boolean isT;
    private boolean isU;
    private boolean isX;
    private String iwA;
    private String iwz;
    private final Writer out;
    private String separator;
    private int[] iww = new int[32];
    private int iut = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            iwx[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        iwx[34] = "\\\"";
        iwx[92] = "\\\\";
        iwx[9] = "\\t";
        iwx[8] = "\\b";
        iwx[10] = "\\n";
        iwx[13] = "\\r";
        iwx[12] = "\\f";
        iwy = (String[]) iwx.clone();
        iwy[60] = "\\u003c";
        iwy[62] = "\\u003e";
        iwy[38] = "\\u0026";
        iwy[61] = "\\u003d";
        iwy[39] = "\\u0027";
    }

    public b(Writer writer) {
        yU(6);
        this.separator = ":";
        this.isT = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.iwz = null;
            this.separator = ":";
            return;
        }
        this.iwz = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.isX = z;
    }

    public boolean isLenient() {
        return this.isX;
    }

    public final void pf(boolean z) {
        this.isU = z;
    }

    public final boolean cbd() {
        return this.isU;
    }

    public final void pg(boolean z) {
        this.isT = z;
    }

    public final boolean cbe() {
        return this.isT;
    }

    public b caN() throws IOException {
        cbg();
        return aq(1, "[");
    }

    public b caO() throws IOException {
        return j(1, 2, "]");
    }

    public b caP() throws IOException {
        cbg();
        return aq(3, "{");
    }

    public b caQ() throws IOException {
        return j(3, 5, "}");
    }

    private b aq(int i, String str) throws IOException {
        cbj();
        yU(i);
        this.out.write(str);
        return this;
    }

    private b j(int i, int i2, String str) throws IOException {
        int cbf = cbf();
        if (cbf != i2 && cbf != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.iwA != null) {
            throw new IllegalStateException("Dangling name: " + this.iwA);
        }
        this.iut--;
        if (cbf == i2) {
            cbh();
        }
        this.out.write(str);
        return this;
    }

    private void yU(int i) {
        if (this.iut == this.iww.length) {
            int[] iArr = new int[this.iut * 2];
            System.arraycopy(this.iww, 0, iArr, 0, this.iut);
            this.iww = iArr;
        }
        int[] iArr2 = this.iww;
        int i2 = this.iut;
        this.iut = i2 + 1;
        iArr2[i2] = i;
    }

    private int cbf() {
        if (this.iut == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.iww[this.iut - 1];
    }

    private void yW(int i) {
        this.iww[this.iut - 1] = i;
    }

    public b zt(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.iwA != null) {
            throw new IllegalStateException();
        }
        if (this.iut == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.iwA = str;
        return this;
    }

    private void cbg() throws IOException {
        if (this.iwA != null) {
            cbi();
            zx(this.iwA);
            this.iwA = null;
        }
    }

    public b zu(String str) throws IOException {
        if (str == null) {
            return caR();
        }
        cbg();
        cbj();
        zx(str);
        return this;
    }

    public b caR() throws IOException {
        if (this.iwA != null) {
            if (this.isT) {
                cbg();
            } else {
                this.iwA = null;
                return this;
            }
        }
        cbj();
        this.out.write("null");
        return this;
    }

    public b pd(boolean z) throws IOException {
        cbg();
        cbj();
        this.out.write(z ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b k(Boolean bool) throws IOException {
        if (bool == null) {
            return caR();
        }
        cbg();
        cbj();
        this.out.write(bool.booleanValue() ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b dx(long j) throws IOException {
        cbg();
        cbj();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return caR();
        }
        cbg();
        String obj = number.toString();
        if (!this.isX && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        cbj();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.iut == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.iut;
        if (i > 1 || (i == 1 && this.iww[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.iut = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zx(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.isU ? iwy : iwx;
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

    private void cbh() throws IOException {
        if (this.iwz != null) {
            this.out.write("\n");
            int i = this.iut;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.iwz);
            }
        }
    }

    private void cbi() throws IOException {
        int cbf = cbf();
        if (cbf == 5) {
            this.out.write(44);
        } else if (cbf != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        cbh();
        yW(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void cbj() throws IOException {
        switch (cbf()) {
            case 1:
                yW(2);
                cbh();
                return;
            case 2:
                this.out.append(',');
                cbh();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                yW(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.isX) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        yW(7);
    }
}
