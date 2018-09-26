package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] hQm = new String[128];
    private static final String[] hQn;
    private boolean hNB;
    private boolean hNC;
    private int[] hQo = new int[32];
    private int hQp = 0;
    private String hQq;
    private boolean hQr;
    private String hQs;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            hQm[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        hQm[34] = "\\\"";
        hQm[92] = "\\\\";
        hQm[9] = "\\t";
        hQm[8] = "\\b";
        hQm[10] = "\\n";
        hQm[13] = "\\r";
        hQm[12] = "\\f";
        hQn = (String[]) hQm.clone();
        hQn[60] = "\\u003c";
        hQn[62] = "\\u003e";
        hQn[38] = "\\u0026";
        hQn[61] = "\\u003d";
        hQn[39] = "\\u0027";
    }

    public a(Writer writer) {
        ww(6);
        this.separator = ":";
        this.hNB = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.hQq = null;
            this.separator = ":";
            return;
        }
        this.hQq = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.hQr = z;
    }

    public boolean isLenient() {
        return this.hQr;
    }

    public final void oj(boolean z) {
        this.hNC = z;
    }

    public final boolean bNk() {
        return this.hNC;
    }

    public final void ok(boolean z) {
        this.hNB = z;
    }

    public final boolean bNl() {
        return this.hNB;
    }

    public a bNc() throws IOException {
        bNn();
        return au(1, "[");
    }

    public a bNd() throws IOException {
        return i(1, 2, "]");
    }

    public a bNe() throws IOException {
        bNn();
        return au(3, "{");
    }

    public a bNf() throws IOException {
        return i(3, 5, "}");
    }

    private a au(int i, String str) throws IOException {
        ol(true);
        ww(i);
        this.out.write(str);
        return this;
    }

    private a i(int i, int i2, String str) throws IOException {
        int bNm = bNm();
        if (bNm != i2 && bNm != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.hQs != null) {
            throw new IllegalStateException("Dangling name: " + this.hQs);
        }
        this.hQp--;
        if (bNm == i2) {
            bNo();
        }
        this.out.write(str);
        return this;
    }

    private void ww(int i) {
        if (this.hQp == this.hQo.length) {
            int[] iArr = new int[this.hQp * 2];
            System.arraycopy(this.hQo, 0, iArr, 0, this.hQp);
            this.hQo = iArr;
        }
        int[] iArr2 = this.hQo;
        int i2 = this.hQp;
        this.hQp = i2 + 1;
        iArr2[i2] = i;
    }

    private int bNm() {
        if (this.hQp == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.hQo[this.hQp - 1];
    }

    private void wx(int i) {
        this.hQo[this.hQp - 1] = i;
    }

    public a xp(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.hQs != null) {
            throw new IllegalStateException();
        }
        if (this.hQp == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.hQs = str;
        return this;
    }

    private void bNn() throws IOException {
        if (this.hQs != null) {
            bNp();
            xr(this.hQs);
            this.hQs = null;
        }
    }

    public a xq(String str) throws IOException {
        if (str == null) {
            return bNg();
        }
        bNn();
        ol(false);
        xr(str);
        return this;
    }

    public a bNg() throws IOException {
        if (this.hQs != null) {
            if (this.hNB) {
                bNn();
            } else {
                this.hQs = null;
                return this;
            }
        }
        ol(false);
        this.out.write("null");
        return this;
    }

    public a oi(boolean z) throws IOException {
        bNn();
        ol(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public a di(long j) throws IOException {
        bNn();
        ol(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public a b(Number number) throws IOException {
        if (number == null) {
            return bNg();
        }
        bNn();
        String obj = number.toString();
        if (!this.hQr && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        ol(false);
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.hQp == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.hQp;
        if (i > 1 || (i == 1 && this.hQo[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.hQp = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xr(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.hNC ? hQn : hQm;
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

    private void bNo() throws IOException {
        if (this.hQq != null) {
            this.out.write("\n");
            int i = this.hQp;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.hQq);
            }
        }
    }

    private void bNp() throws IOException {
        int bNm = bNm();
        if (bNm == 5) {
            this.out.write(44);
        } else if (bNm != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        bNo();
        wx(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void ol(boolean z) throws IOException {
        switch (bNm()) {
            case 1:
                wx(2);
                bNo();
                return;
            case 2:
                this.out.append(',');
                bNo();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                wx(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.hQr) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        if (!this.hQr && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        wx(7);
    }
}
