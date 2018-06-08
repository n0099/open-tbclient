package com.google.gson.stream;

import com.baidu.ar.util.SystemInfoUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] hLh = new String[128];
    private static final String[] hLi;
    private boolean hIx;
    private boolean hIy;
    private int[] hLj = new int[32];
    private int hLk = 0;
    private String hLl;
    private boolean hLm;
    private String hLn;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            hLh[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        hLh[34] = "\\\"";
        hLh[92] = "\\\\";
        hLh[9] = "\\t";
        hLh[8] = "\\b";
        hLh[10] = "\\n";
        hLh[13] = "\\r";
        hLh[12] = "\\f";
        hLi = (String[]) hLh.clone();
        hLi[60] = "\\u003c";
        hLi[62] = "\\u003e";
        hLi[38] = "\\u0026";
        hLi[61] = "\\u003d";
        hLi[39] = "\\u0027";
    }

    public a(Writer writer) {
        wz(6);
        this.separator = SystemInfoUtil.COLON;
        this.hIx = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.hLl = null;
            this.separator = SystemInfoUtil.COLON;
            return;
        }
        this.hLl = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.hLm = z;
    }

    public boolean isLenient() {
        return this.hLm;
    }

    public final void of(boolean z) {
        this.hIy = z;
    }

    public final boolean bOh() {
        return this.hIy;
    }

    public final void og(boolean z) {
        this.hIx = z;
    }

    public final boolean bOi() {
        return this.hIx;
    }

    public a bNZ() throws IOException {
        bOk();
        return au(1, "[");
    }

    public a bOa() throws IOException {
        return i(1, 2, "]");
    }

    public a bOb() throws IOException {
        bOk();
        return au(3, "{");
    }

    public a bOc() throws IOException {
        return i(3, 5, "}");
    }

    private a au(int i, String str) throws IOException {
        oh(true);
        wz(i);
        this.out.write(str);
        return this;
    }

    private a i(int i, int i2, String str) throws IOException {
        int bOj = bOj();
        if (bOj != i2 && bOj != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.hLn != null) {
            throw new IllegalStateException("Dangling name: " + this.hLn);
        }
        this.hLk--;
        if (bOj == i2) {
            bOl();
        }
        this.out.write(str);
        return this;
    }

    private void wz(int i) {
        if (this.hLk == this.hLj.length) {
            int[] iArr = new int[this.hLk * 2];
            System.arraycopy(this.hLj, 0, iArr, 0, this.hLk);
            this.hLj = iArr;
        }
        int[] iArr2 = this.hLj;
        int i2 = this.hLk;
        this.hLk = i2 + 1;
        iArr2[i2] = i;
    }

    private int bOj() {
        if (this.hLk == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.hLj[this.hLk - 1];
    }

    private void wA(int i) {
        this.hLj[this.hLk - 1] = i;
    }

    public a xz(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.hLn != null) {
            throw new IllegalStateException();
        }
        if (this.hLk == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.hLn = str;
        return this;
    }

    private void bOk() throws IOException {
        if (this.hLn != null) {
            bOm();
            xB(this.hLn);
            this.hLn = null;
        }
    }

    public a xA(String str) throws IOException {
        if (str == null) {
            return bOd();
        }
        bOk();
        oh(false);
        xB(str);
        return this;
    }

    public a bOd() throws IOException {
        if (this.hLn != null) {
            if (this.hIx) {
                bOk();
            } else {
                this.hLn = null;
                return this;
            }
        }
        oh(false);
        this.out.write("null");
        return this;
    }

    public a oe(boolean z) throws IOException {
        bOk();
        oh(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a dE(long j) throws IOException {
        bOk();
        oh(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return bOd();
        }
        bOk();
        String obj = number.toString();
        if (!this.hLm && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        oh(false);
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.hLk == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.hLk;
        if (i > 1 || (i == 1 && this.hLj[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.hLk = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xB(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.hIy ? hLi : hLh;
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

    private void bOl() throws IOException {
        if (this.hLl != null) {
            this.out.write("\n");
            int i = this.hLk;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.hLl);
            }
        }
    }

    private void bOm() throws IOException {
        int bOj = bOj();
        if (bOj == 5) {
            this.out.write(44);
        } else if (bOj != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        bOl();
        wA(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void oh(boolean z) throws IOException {
        switch (bOj()) {
            case 1:
                wA(2);
                bOl();
                return;
            case 2:
                this.out.append(',');
                bOl();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                wA(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.hLm) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        if (!this.hLm && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        wA(7);
    }
}
