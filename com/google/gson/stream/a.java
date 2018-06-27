package com.google.gson.stream;

import com.baidu.ar.util.SystemInfoUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] hPn = new String[128];
    private static final String[] hPo;
    private boolean hMD;
    private boolean hME;
    private int[] hPp = new int[32];
    private int hPq = 0;
    private String hPr;
    private boolean hPs;
    private String hPt;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            hPn[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        hPn[34] = "\\\"";
        hPn[92] = "\\\\";
        hPn[9] = "\\t";
        hPn[8] = "\\b";
        hPn[10] = "\\n";
        hPn[13] = "\\r";
        hPn[12] = "\\f";
        hPo = (String[]) hPn.clone();
        hPo[60] = "\\u003c";
        hPo[62] = "\\u003e";
        hPo[38] = "\\u0026";
        hPo[61] = "\\u003d";
        hPo[39] = "\\u0027";
    }

    public a(Writer writer) {
        wI(6);
        this.separator = SystemInfoUtil.COLON;
        this.hMD = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.hPr = null;
            this.separator = SystemInfoUtil.COLON;
            return;
        }
        this.hPr = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.hPs = z;
    }

    public boolean isLenient() {
        return this.hPs;
    }

    public final void om(boolean z) {
        this.hME = z;
    }

    public final boolean bOJ() {
        return this.hME;
    }

    public final void on(boolean z) {
        this.hMD = z;
    }

    public final boolean bOK() {
        return this.hMD;
    }

    public a bOB() throws IOException {
        bOM();
        return ar(1, "[");
    }

    public a bOC() throws IOException {
        return i(1, 2, "]");
    }

    public a bOD() throws IOException {
        bOM();
        return ar(3, "{");
    }

    public a bOE() throws IOException {
        return i(3, 5, "}");
    }

    private a ar(int i, String str) throws IOException {
        oo(true);
        wI(i);
        this.out.write(str);
        return this;
    }

    private a i(int i, int i2, String str) throws IOException {
        int bOL = bOL();
        if (bOL != i2 && bOL != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.hPt != null) {
            throw new IllegalStateException("Dangling name: " + this.hPt);
        }
        this.hPq--;
        if (bOL == i2) {
            bON();
        }
        this.out.write(str);
        return this;
    }

    private void wI(int i) {
        if (this.hPq == this.hPp.length) {
            int[] iArr = new int[this.hPq * 2];
            System.arraycopy(this.hPp, 0, iArr, 0, this.hPq);
            this.hPp = iArr;
        }
        int[] iArr2 = this.hPp;
        int i2 = this.hPq;
        this.hPq = i2 + 1;
        iArr2[i2] = i;
    }

    private int bOL() {
        if (this.hPq == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.hPp[this.hPq - 1];
    }

    private void wJ(int i) {
        this.hPp[this.hPq - 1] = i;
    }

    public a xx(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.hPt != null) {
            throw new IllegalStateException();
        }
        if (this.hPq == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.hPt = str;
        return this;
    }

    private void bOM() throws IOException {
        if (this.hPt != null) {
            bOO();
            xz(this.hPt);
            this.hPt = null;
        }
    }

    public a xy(String str) throws IOException {
        if (str == null) {
            return bOF();
        }
        bOM();
        oo(false);
        xz(str);
        return this;
    }

    public a bOF() throws IOException {
        if (this.hPt != null) {
            if (this.hMD) {
                bOM();
            } else {
                this.hPt = null;
                return this;
            }
        }
        oo(false);
        this.out.write("null");
        return this;
    }

    public a ol(boolean z) throws IOException {
        bOM();
        oo(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a dC(long j) throws IOException {
        bOM();
        oo(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return bOF();
        }
        bOM();
        String obj = number.toString();
        if (!this.hPs && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        oo(false);
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.hPq == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.hPq;
        if (i > 1 || (i == 1 && this.hPp[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.hPq = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xz(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.hME ? hPo : hPn;
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

    private void bON() throws IOException {
        if (this.hPr != null) {
            this.out.write("\n");
            int i = this.hPq;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.hPr);
            }
        }
    }

    private void bOO() throws IOException {
        int bOL = bOL();
        if (bOL == 5) {
            this.out.write(44);
        } else if (bOL != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        bON();
        wJ(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void oo(boolean z) throws IOException {
        switch (bOL()) {
            case 1:
                wJ(2);
                bON();
                return;
            case 2:
                this.out.append(',');
                bON();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                wJ(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.hPs) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        if (!this.hPs && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        wJ(7);
    }
}
