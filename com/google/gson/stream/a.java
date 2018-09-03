package com.google.gson.stream;

import com.baidu.ar.util.SystemInfoUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] hHS = new String[128];
    private static final String[] hHT;
    private boolean hFh;
    private boolean hFi;
    private int[] hHU = new int[32];
    private int hHV = 0;
    private String hHW;
    private boolean hHX;
    private String hHY;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            hHS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        hHS[34] = "\\\"";
        hHS[92] = "\\\\";
        hHS[9] = "\\t";
        hHS[8] = "\\b";
        hHS[10] = "\\n";
        hHS[13] = "\\r";
        hHS[12] = "\\f";
        hHT = (String[]) hHS.clone();
        hHT[60] = "\\u003c";
        hHT[62] = "\\u003e";
        hHT[38] = "\\u0026";
        hHT[61] = "\\u003d";
        hHT[39] = "\\u0027";
    }

    public a(Writer writer) {
        vX(6);
        this.separator = SystemInfoUtil.COLON;
        this.hFh = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.hHW = null;
            this.separator = SystemInfoUtil.COLON;
            return;
        }
        this.hHW = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.hHX = z;
    }

    public boolean isLenient() {
        return this.hHX;
    }

    public final void nM(boolean z) {
        this.hFi = z;
    }

    public final boolean bKt() {
        return this.hFi;
    }

    public final void nN(boolean z) {
        this.hFh = z;
    }

    public final boolean bKu() {
        return this.hFh;
    }

    public a bKl() throws IOException {
        bKw();
        return at(1, "[");
    }

    public a bKm() throws IOException {
        return i(1, 2, "]");
    }

    public a bKn() throws IOException {
        bKw();
        return at(3, "{");
    }

    public a bKo() throws IOException {
        return i(3, 5, "}");
    }

    private a at(int i, String str) throws IOException {
        nO(true);
        vX(i);
        this.out.write(str);
        return this;
    }

    private a i(int i, int i2, String str) throws IOException {
        int bKv = bKv();
        if (bKv != i2 && bKv != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.hHY != null) {
            throw new IllegalStateException("Dangling name: " + this.hHY);
        }
        this.hHV--;
        if (bKv == i2) {
            bKx();
        }
        this.out.write(str);
        return this;
    }

    private void vX(int i) {
        if (this.hHV == this.hHU.length) {
            int[] iArr = new int[this.hHV * 2];
            System.arraycopy(this.hHU, 0, iArr, 0, this.hHV);
            this.hHU = iArr;
        }
        int[] iArr2 = this.hHU;
        int i2 = this.hHV;
        this.hHV = i2 + 1;
        iArr2[i2] = i;
    }

    private int bKv() {
        if (this.hHV == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.hHU[this.hHV - 1];
    }

    private void vY(int i) {
        this.hHU[this.hHV - 1] = i;
    }

    public a wE(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.hHY != null) {
            throw new IllegalStateException();
        }
        if (this.hHV == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.hHY = str;
        return this;
    }

    private void bKw() throws IOException {
        if (this.hHY != null) {
            bKy();
            wG(this.hHY);
            this.hHY = null;
        }
    }

    public a wF(String str) throws IOException {
        if (str == null) {
            return bKp();
        }
        bKw();
        nO(false);
        wG(str);
        return this;
    }

    public a bKp() throws IOException {
        if (this.hHY != null) {
            if (this.hFh) {
                bKw();
            } else {
                this.hHY = null;
                return this;
            }
        }
        nO(false);
        this.out.write("null");
        return this;
    }

    public a nL(boolean z) throws IOException {
        bKw();
        nO(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a dg(long j) throws IOException {
        bKw();
        nO(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public a b(Number number) throws IOException {
        if (number == null) {
            return bKp();
        }
        bKw();
        String obj = number.toString();
        if (!this.hHX && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        nO(false);
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.hHV == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.hHV;
        if (i > 1 || (i == 1 && this.hHU[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.hHV = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void wG(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.hFi ? hHT : hHS;
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

    private void bKx() throws IOException {
        if (this.hHW != null) {
            this.out.write("\n");
            int i = this.hHV;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.hHW);
            }
        }
    }

    private void bKy() throws IOException {
        int bKv = bKv();
        if (bKv == 5) {
            this.out.write(44);
        } else if (bKv != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        bKx();
        vY(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void nO(boolean z) throws IOException {
        switch (bKv()) {
            case 1:
                vY(2);
                bKx();
                return;
            case 2:
                this.out.append(',');
                bKx();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                vY(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.hHX) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        if (!this.hHX && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        vY(7);
    }
}
