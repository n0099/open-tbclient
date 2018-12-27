package com.google.gson.stream;

import com.baidu.webkit.internal.ABTestConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {
    private static final String[] izH = new String[128];
    private static final String[] izI;
    private boolean iwd;
    private boolean iwe;
    private boolean iwh;
    private String izJ;
    private String izK;
    private final Writer out;
    private String separator;
    private int[] izG = new int[32];
    private int ixD = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            izH[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        izH[34] = "\\\"";
        izH[92] = "\\\\";
        izH[9] = "\\t";
        izH[8] = "\\b";
        izH[10] = "\\n";
        izH[13] = "\\r";
        izH[12] = "\\f";
        izI = (String[]) izH.clone();
        izI[60] = "\\u003c";
        izI[62] = "\\u003e";
        izI[38] = "\\u0026";
        izI[61] = "\\u003d";
        izI[39] = "\\u0027";
    }

    public b(Writer writer) {
        zh(6);
        this.separator = ":";
        this.iwd = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.izJ = null;
            this.separator = ":";
            return;
        }
        this.izJ = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.iwh = z;
    }

    public boolean isLenient() {
        return this.iwh;
    }

    public final void pi(boolean z) {
        this.iwe = z;
    }

    public final boolean cbU() {
        return this.iwe;
    }

    public final void pj(boolean z) {
        this.iwd = z;
    }

    public final boolean cbV() {
        return this.iwd;
    }

    public b cbE() throws IOException {
        cbX();
        return ar(1, "[");
    }

    public b cbF() throws IOException {
        return j(1, 2, "]");
    }

    public b cbG() throws IOException {
        cbX();
        return ar(3, "{");
    }

    public b cbH() throws IOException {
        return j(3, 5, "}");
    }

    private b ar(int i, String str) throws IOException {
        cca();
        zh(i);
        this.out.write(str);
        return this;
    }

    private b j(int i, int i2, String str) throws IOException {
        int cbW = cbW();
        if (cbW != i2 && cbW != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.izK != null) {
            throw new IllegalStateException("Dangling name: " + this.izK);
        }
        this.ixD--;
        if (cbW == i2) {
            cbY();
        }
        this.out.write(str);
        return this;
    }

    private void zh(int i) {
        if (this.ixD == this.izG.length) {
            int[] iArr = new int[this.ixD * 2];
            System.arraycopy(this.izG, 0, iArr, 0, this.ixD);
            this.izG = iArr;
        }
        int[] iArr2 = this.izG;
        int i2 = this.ixD;
        this.ixD = i2 + 1;
        iArr2[i2] = i;
    }

    private int cbW() {
        if (this.ixD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.izG[this.ixD - 1];
    }

    private void zj(int i) {
        this.izG[this.ixD - 1] = i;
    }

    public b zw(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.izK != null) {
            throw new IllegalStateException();
        }
        if (this.ixD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.izK = str;
        return this;
    }

    private void cbX() throws IOException {
        if (this.izK != null) {
            cbZ();
            zA(this.izK);
            this.izK = null;
        }
    }

    public b zx(String str) throws IOException {
        if (str == null) {
            return cbI();
        }
        cbX();
        cca();
        zA(str);
        return this;
    }

    public b cbI() throws IOException {
        if (this.izK != null) {
            if (this.iwd) {
                cbX();
            } else {
                this.izK = null;
                return this;
            }
        }
        cca();
        this.out.write("null");
        return this;
    }

    public b pg(boolean z) throws IOException {
        cbX();
        cca();
        this.out.write(z ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b k(Boolean bool) throws IOException {
        if (bool == null) {
            return cbI();
        }
        cbX();
        cca();
        this.out.write(bool.booleanValue() ? "true" : ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        return this;
    }

    public b dC(long j) throws IOException {
        cbX();
        cca();
        this.out.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return cbI();
        }
        cbX();
        String obj = number.toString();
        if (!this.iwh && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        cca();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.ixD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.ixD;
        if (i > 1 || (i == 1 && this.izG[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.ixD = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zA(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.iwe ? izI : izH;
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

    private void cbY() throws IOException {
        if (this.izJ != null) {
            this.out.write("\n");
            int i = this.ixD;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.izJ);
            }
        }
    }

    private void cbZ() throws IOException {
        int cbW = cbW();
        if (cbW == 5) {
            this.out.write(44);
        } else if (cbW != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        cbY();
        zj(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void cca() throws IOException {
        switch (cbW()) {
            case 1:
                zj(2);
                cbY();
                return;
            case 2:
                this.out.append(',');
                cbY();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                zj(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.iwh) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        zj(7);
    }
}
