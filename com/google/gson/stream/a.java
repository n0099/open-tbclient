package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] kqE = new String[128];
    private static final String[] kqF;
    private String indent;
    private boolean knu;
    private boolean knv;
    private boolean kny;
    private final Writer kqG;
    private int[] kqH = new int[32];
    private int kqI = 0;
    private String kqJ;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            kqE[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        kqE[34] = "\\\"";
        kqE[92] = "\\\\";
        kqE[9] = "\\t";
        kqE[8] = "\\b";
        kqE[10] = "\\n";
        kqE[13] = "\\r";
        kqE[12] = "\\f";
        kqF = (String[]) kqE.clone();
        kqF[60] = "\\u003c";
        kqF[62] = "\\u003e";
        kqF[38] = "\\u0026";
        kqF[61] = "\\u003d";
        kqF[39] = "\\u0027";
    }

    public a(Writer writer) {
        CY(6);
        this.separator = ":";
        this.knu = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.kqG = writer;
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
        this.kny = z;
    }

    public boolean cKE() {
        return this.kny;
    }

    public final void sr(boolean z) {
        this.knv = z;
    }

    public final boolean cKF() {
        return this.knv;
    }

    public final void ss(boolean z) {
        this.knu = z;
    }

    public final boolean cKG() {
        return this.knu;
    }

    public a cKx() throws IOException {
        cKI();
        return aN(1, "[");
    }

    public a cKy() throws IOException {
        return m(1, 2, "]");
    }

    public a cKz() throws IOException {
        cKI();
        return aN(3, "{");
    }

    public a cKA() throws IOException {
        return m(3, 5, "}");
    }

    private a aN(int i, String str) throws IOException {
        beforeValue();
        CY(i);
        this.kqG.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cKH = cKH();
        if (cKH != i2 && cKH != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.kqJ != null) {
            throw new IllegalStateException("Dangling name: " + this.kqJ);
        }
        this.kqI--;
        if (cKH == i2) {
            newline();
        }
        this.kqG.write(str);
        return this;
    }

    private void CY(int i) {
        if (this.kqI == this.kqH.length) {
            int[] iArr = new int[this.kqI * 2];
            System.arraycopy(this.kqH, 0, iArr, 0, this.kqI);
            this.kqH = iArr;
        }
        int[] iArr2 = this.kqH;
        int i2 = this.kqI;
        this.kqI = i2 + 1;
        iArr2[i2] = i;
    }

    private int cKH() {
        if (this.kqI == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.kqH[this.kqI - 1];
    }

    private void CZ(int i) {
        this.kqH[this.kqI - 1] = i;
    }

    public a GO(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.kqJ != null) {
            throw new IllegalStateException();
        }
        if (this.kqI == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kqJ = str;
        return this;
    }

    private void cKI() throws IOException {
        if (this.kqJ != null) {
            cKJ();
            string(this.kqJ);
            this.kqJ = null;
        }
    }

    public a GP(String str) throws IOException {
        if (str == null) {
            return cKB();
        }
        cKI();
        beforeValue();
        string(str);
        return this;
    }

    public a cKB() throws IOException {
        if (this.kqJ != null) {
            if (this.knu) {
                cKI();
            } else {
                this.kqJ = null;
                return this;
            }
        }
        beforeValue();
        this.kqG.write("null");
        return this;
    }

    public a sp(boolean z) throws IOException {
        cKI();
        beforeValue();
        this.kqG.write(z ? "true" : "false");
        return this;
    }

    public a l(Boolean bool) throws IOException {
        if (bool == null) {
            return cKB();
        }
        cKI();
        beforeValue();
        this.kqG.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a ej(long j) throws IOException {
        cKI();
        beforeValue();
        this.kqG.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cKB();
        }
        cKI();
        String obj = number.toString();
        if (!this.kny && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.kqG.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.kqI == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kqG.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.kqG.close();
        int i = this.kqI;
        if (i > 1 || (i == 1 && this.kqH[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.kqI = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.knv ? kqF : kqE;
        this.kqG.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.kqG.write(str, i2, i - i2);
                }
                this.kqG.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.kqG.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.kqG.write(str, i2, length - i2);
        }
        this.kqG.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.kqG.write("\n");
            int i = this.kqI;
            for (int i2 = 1; i2 < i; i2++) {
                this.kqG.write(this.indent);
            }
        }
    }

    private void cKJ() throws IOException {
        int cKH = cKH();
        if (cKH == 5) {
            this.kqG.write(44);
        } else if (cKH != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        CZ(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cKH()) {
            case 1:
                CZ(2);
                newline();
                return;
            case 2:
                this.kqG.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.kqG.append((CharSequence) this.separator);
                CZ(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.kny) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        CZ(7);
    }
}
