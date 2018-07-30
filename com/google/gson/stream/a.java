package com.google.gson.stream;

import com.baidu.ar.util.SystemInfoUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] hIl = new String[128];
    private static final String[] hIm;
    private boolean hFA;
    private boolean hFB;
    private int[] hIn = new int[32];
    private int hIo = 0;
    private String hIp;
    private boolean hIq;
    private String hIr;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            hIl[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        hIl[34] = "\\\"";
        hIl[92] = "\\\\";
        hIl[9] = "\\t";
        hIl[8] = "\\b";
        hIl[10] = "\\n";
        hIl[13] = "\\r";
        hIl[12] = "\\f";
        hIm = (String[]) hIl.clone();
        hIm[60] = "\\u003c";
        hIm[62] = "\\u003e";
        hIm[38] = "\\u0026";
        hIm[61] = "\\u003d";
        hIm[39] = "\\u0027";
    }

    public a(Writer writer) {
        vY(6);
        this.separator = SystemInfoUtil.COLON;
        this.hFA = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.hIp = null;
            this.separator = SystemInfoUtil.COLON;
            return;
        }
        this.hIp = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.hIq = z;
    }

    public boolean isLenient() {
        return this.hIq;
    }

    public final void nM(boolean z) {
        this.hFB = z;
    }

    public final boolean bKC() {
        return this.hFB;
    }

    public final void nN(boolean z) {
        this.hFA = z;
    }

    public final boolean bKD() {
        return this.hFA;
    }

    public a bKu() throws IOException {
        bKF();
        return at(1, "[");
    }

    public a bKv() throws IOException {
        return i(1, 2, "]");
    }

    public a bKw() throws IOException {
        bKF();
        return at(3, "{");
    }

    public a bKx() throws IOException {
        return i(3, 5, "}");
    }

    private a at(int i, String str) throws IOException {
        nO(true);
        vY(i);
        this.out.write(str);
        return this;
    }

    private a i(int i, int i2, String str) throws IOException {
        int bKE = bKE();
        if (bKE != i2 && bKE != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.hIr != null) {
            throw new IllegalStateException("Dangling name: " + this.hIr);
        }
        this.hIo--;
        if (bKE == i2) {
            bKG();
        }
        this.out.write(str);
        return this;
    }

    private void vY(int i) {
        if (this.hIo == this.hIn.length) {
            int[] iArr = new int[this.hIo * 2];
            System.arraycopy(this.hIn, 0, iArr, 0, this.hIo);
            this.hIn = iArr;
        }
        int[] iArr2 = this.hIn;
        int i2 = this.hIo;
        this.hIo = i2 + 1;
        iArr2[i2] = i;
    }

    private int bKE() {
        if (this.hIo == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.hIn[this.hIo - 1];
    }

    private void vZ(int i) {
        this.hIn[this.hIo - 1] = i;
    }

    public a wD(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.hIr != null) {
            throw new IllegalStateException();
        }
        if (this.hIo == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.hIr = str;
        return this;
    }

    private void bKF() throws IOException {
        if (this.hIr != null) {
            bKH();
            wF(this.hIr);
            this.hIr = null;
        }
    }

    public a wE(String str) throws IOException {
        if (str == null) {
            return bKy();
        }
        bKF();
        nO(false);
        wF(str);
        return this;
    }

    public a bKy() throws IOException {
        if (this.hIr != null) {
            if (this.hFA) {
                bKF();
            } else {
                this.hIr = null;
                return this;
            }
        }
        nO(false);
        this.out.write("null");
        return this;
    }

    public a nL(boolean z) throws IOException {
        bKF();
        nO(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a dh(long j) throws IOException {
        bKF();
        nO(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return bKy();
        }
        bKF();
        String obj = number.toString();
        if (!this.hIq && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        nO(false);
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.hIo == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.hIo;
        if (i > 1 || (i == 1 && this.hIn[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.hIo = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void wF(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.hFB ? hIm : hIl;
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

    private void bKG() throws IOException {
        if (this.hIp != null) {
            this.out.write("\n");
            int i = this.hIo;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.hIp);
            }
        }
    }

    private void bKH() throws IOException {
        int bKE = bKE();
        if (bKE == 5) {
            this.out.write(44);
        } else if (bKE != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        bKG();
        vZ(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void nO(boolean z) throws IOException {
        switch (bKE()) {
            case 1:
                vZ(2);
                bKG();
                return;
            case 2:
                this.out.append(',');
                bKG();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                vZ(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.hIq) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        if (!this.hIq && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        vZ(7);
    }
}
