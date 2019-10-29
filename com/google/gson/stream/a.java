package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] krv = new String[128];
    private static final String[] krw;
    private String indent;
    private boolean kol;
    private boolean kom;
    private boolean kop;
    private String krA;
    private final Writer krx;
    private int[] kry = new int[32];
    private int krz = 0;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            krv[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        krv[34] = "\\\"";
        krv[92] = "\\\\";
        krv[9] = "\\t";
        krv[8] = "\\b";
        krv[10] = "\\n";
        krv[13] = "\\r";
        krv[12] = "\\f";
        krw = (String[]) krv.clone();
        krw[60] = "\\u003c";
        krw[62] = "\\u003e";
        krw[38] = "\\u0026";
        krw[61] = "\\u003d";
        krw[39] = "\\u0027";
    }

    public a(Writer writer) {
        CZ(6);
        this.separator = ":";
        this.kol = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.krx = writer;
    }

    public final void GQ(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void sq(boolean z) {
        this.kop = z;
    }

    public boolean cKG() {
        return this.kop;
    }

    public final void sr(boolean z) {
        this.kom = z;
    }

    public final boolean cKH() {
        return this.kom;
    }

    public final void ss(boolean z) {
        this.kol = z;
    }

    public final boolean cKI() {
        return this.kol;
    }

    public a cKz() throws IOException {
        cKK();
        return aO(1, "[");
    }

    public a cKA() throws IOException {
        return m(1, 2, "]");
    }

    public a cKB() throws IOException {
        cKK();
        return aO(3, "{");
    }

    public a cKC() throws IOException {
        return m(3, 5, "}");
    }

    private a aO(int i, String str) throws IOException {
        beforeValue();
        CZ(i);
        this.krx.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cKJ = cKJ();
        if (cKJ != i2 && cKJ != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.krA != null) {
            throw new IllegalStateException("Dangling name: " + this.krA);
        }
        this.krz--;
        if (cKJ == i2) {
            newline();
        }
        this.krx.write(str);
        return this;
    }

    private void CZ(int i) {
        if (this.krz == this.kry.length) {
            int[] iArr = new int[this.krz * 2];
            System.arraycopy(this.kry, 0, iArr, 0, this.krz);
            this.kry = iArr;
        }
        int[] iArr2 = this.kry;
        int i2 = this.krz;
        this.krz = i2 + 1;
        iArr2[i2] = i;
    }

    private int cKJ() {
        if (this.krz == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.kry[this.krz - 1];
    }

    private void Da(int i) {
        this.kry[this.krz - 1] = i;
    }

    public a GO(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.krA != null) {
            throw new IllegalStateException();
        }
        if (this.krz == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.krA = str;
        return this;
    }

    private void cKK() throws IOException {
        if (this.krA != null) {
            cKL();
            string(this.krA);
            this.krA = null;
        }
    }

    public a GP(String str) throws IOException {
        if (str == null) {
            return cKD();
        }
        cKK();
        beforeValue();
        string(str);
        return this;
    }

    public a cKD() throws IOException {
        if (this.krA != null) {
            if (this.kol) {
                cKK();
            } else {
                this.krA = null;
                return this;
            }
        }
        beforeValue();
        this.krx.write("null");
        return this;
    }

    public a sp(boolean z) throws IOException {
        cKK();
        beforeValue();
        this.krx.write(z ? "true" : "false");
        return this;
    }

    public a l(Boolean bool) throws IOException {
        if (bool == null) {
            return cKD();
        }
        cKK();
        beforeValue();
        this.krx.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a ek(long j) throws IOException {
        cKK();
        beforeValue();
        this.krx.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cKD();
        }
        cKK();
        String obj = number.toString();
        if (!this.kop && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.krx.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.krz == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.krx.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.krx.close();
        int i = this.krz;
        if (i > 1 || (i == 1 && this.kry[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.krz = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.kom ? krw : krv;
        this.krx.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.krx.write(str, i2, i - i2);
                }
                this.krx.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.krx.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.krx.write(str, i2, length - i2);
        }
        this.krx.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.krx.write("\n");
            int i = this.krz;
            for (int i2 = 1; i2 < i; i2++) {
                this.krx.write(this.indent);
            }
        }
    }

    private void cKL() throws IOException {
        int cKJ = cKJ();
        if (cKJ == 5) {
            this.krx.write(44);
        } else if (cKJ != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Da(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cKJ()) {
            case 1:
                Da(2);
                newline();
                return;
            case 2:
                this.krx.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.krx.append((CharSequence) this.separator);
                Da(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.kop) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Da(7);
    }
}
