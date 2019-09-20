package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] ktj = new String[128];
    private static final String[] ktk;
    private String indent;
    private boolean kpZ;
    private boolean kqa;
    private boolean kqd;
    private final Writer ktl;
    private int[] ktm = new int[32];
    private int ktn = 0;
    private String kto;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            ktj[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        ktj[34] = "\\\"";
        ktj[92] = "\\\\";
        ktj[9] = "\\t";
        ktj[8] = "\\b";
        ktj[10] = "\\n";
        ktj[13] = "\\r";
        ktj[12] = "\\f";
        ktk = (String[]) ktj.clone();
        ktk[60] = "\\u003c";
        ktk[62] = "\\u003e";
        ktk[38] = "\\u0026";
        ktk[61] = "\\u003d";
        ktk[39] = "\\u0027";
    }

    public a(Writer writer) {
        ED(6);
        this.separator = ":";
        this.kpZ = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.ktl = writer;
    }

    public final void Iz(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void sL(boolean z) {
        this.kqd = z;
    }

    public boolean cNJ() {
        return this.kqd;
    }

    public final void sM(boolean z) {
        this.kqa = z;
    }

    public final boolean cNK() {
        return this.kqa;
    }

    public final void sN(boolean z) {
        this.kpZ = z;
    }

    public final boolean cNL() {
        return this.kpZ;
    }

    public a cNC() throws IOException {
        cNN();
        return aN(1, "[");
    }

    public a cND() throws IOException {
        return m(1, 2, "]");
    }

    public a cNE() throws IOException {
        cNN();
        return aN(3, "{");
    }

    public a cNF() throws IOException {
        return m(3, 5, "}");
    }

    private a aN(int i, String str) throws IOException {
        beforeValue();
        ED(i);
        this.ktl.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cNM = cNM();
        if (cNM != i2 && cNM != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.kto != null) {
            throw new IllegalStateException("Dangling name: " + this.kto);
        }
        this.ktn--;
        if (cNM == i2) {
            newline();
        }
        this.ktl.write(str);
        return this;
    }

    private void ED(int i) {
        if (this.ktn == this.ktm.length) {
            int[] iArr = new int[this.ktn * 2];
            System.arraycopy(this.ktm, 0, iArr, 0, this.ktn);
            this.ktm = iArr;
        }
        int[] iArr2 = this.ktm;
        int i2 = this.ktn;
        this.ktn = i2 + 1;
        iArr2[i2] = i;
    }

    private int cNM() {
        if (this.ktn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.ktm[this.ktn - 1];
    }

    private void EE(int i) {
        this.ktm[this.ktn - 1] = i;
    }

    public a Ix(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.kto != null) {
            throw new IllegalStateException();
        }
        if (this.ktn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kto = str;
        return this;
    }

    private void cNN() throws IOException {
        if (this.kto != null) {
            cNO();
            string(this.kto);
            this.kto = null;
        }
    }

    public a Iy(String str) throws IOException {
        if (str == null) {
            return cNG();
        }
        cNN();
        beforeValue();
        string(str);
        return this;
    }

    public a cNG() throws IOException {
        if (this.kto != null) {
            if (this.kpZ) {
                cNN();
            } else {
                this.kto = null;
                return this;
            }
        }
        beforeValue();
        this.ktl.write("null");
        return this;
    }

    public a sK(boolean z) throws IOException {
        cNN();
        beforeValue();
        this.ktl.write(z ? "true" : "false");
        return this;
    }

    public a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cNG();
        }
        cNN();
        beforeValue();
        this.ktl.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a eQ(long j) throws IOException {
        cNN();
        beforeValue();
        this.ktl.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cNG();
        }
        cNN();
        String obj = number.toString();
        if (!this.kqd && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.ktl.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.ktn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ktl.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ktl.close();
        int i = this.ktn;
        if (i > 1 || (i == 1 && this.ktm[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.ktn = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.kqa ? ktk : ktj;
        this.ktl.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.ktl.write(str, i2, i - i2);
                }
                this.ktl.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.ktl.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.ktl.write(str, i2, length - i2);
        }
        this.ktl.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.ktl.write("\n");
            int i = this.ktn;
            for (int i2 = 1; i2 < i; i2++) {
                this.ktl.write(this.indent);
            }
        }
    }

    private void cNO() throws IOException {
        int cNM = cNM();
        if (cNM == 5) {
            this.ktl.write(44);
        } else if (cNM != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        EE(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cNM()) {
            case 1:
                EE(2);
                newline();
                return;
            case 2:
                this.ktl.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.ktl.append((CharSequence) this.separator);
                EE(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.kqd) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        EE(7);
    }
}
