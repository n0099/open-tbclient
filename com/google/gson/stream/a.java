package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public class a implements Closeable, Flushable {
    private static final String[] kqM = new String[128];
    private static final String[] kqN;
    private String indent;
    private boolean knC;
    private boolean knD;
    private boolean knG;
    private final Writer kqO;
    private int[] kqP = new int[32];
    private int kqQ = 0;
    private String kqR;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            kqM[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        kqM[34] = "\\\"";
        kqM[92] = "\\\\";
        kqM[9] = "\\t";
        kqM[8] = "\\b";
        kqM[10] = "\\n";
        kqM[13] = "\\r";
        kqM[12] = "\\f";
        kqN = (String[]) kqM.clone();
        kqN[60] = "\\u003c";
        kqN[62] = "\\u003e";
        kqN[38] = "\\u0026";
        kqN[61] = "\\u003d";
        kqN[39] = "\\u0027";
    }

    public a(Writer writer) {
        Ez(6);
        this.separator = ":";
        this.knC = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.kqO = writer;
    }

    public final void HZ(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void sI(boolean z) {
        this.knG = z;
    }

    public boolean cMV() {
        return this.knG;
    }

    public final void sJ(boolean z) {
        this.knD = z;
    }

    public final boolean cMW() {
        return this.knD;
    }

    public final void sK(boolean z) {
        this.knC = z;
    }

    public final boolean cMX() {
        return this.knC;
    }

    public a cMO() throws IOException {
        cMZ();
        return aN(1, "[");
    }

    public a cMP() throws IOException {
        return m(1, 2, "]");
    }

    public a cMQ() throws IOException {
        cMZ();
        return aN(3, "{");
    }

    public a cMR() throws IOException {
        return m(3, 5, "}");
    }

    private a aN(int i, String str) throws IOException {
        beforeValue();
        Ez(i);
        this.kqO.write(str);
        return this;
    }

    private a m(int i, int i2, String str) throws IOException {
        int cMY = cMY();
        if (cMY != i2 && cMY != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.kqR != null) {
            throw new IllegalStateException("Dangling name: " + this.kqR);
        }
        this.kqQ--;
        if (cMY == i2) {
            newline();
        }
        this.kqO.write(str);
        return this;
    }

    private void Ez(int i) {
        if (this.kqQ == this.kqP.length) {
            int[] iArr = new int[this.kqQ * 2];
            System.arraycopy(this.kqP, 0, iArr, 0, this.kqQ);
            this.kqP = iArr;
        }
        int[] iArr2 = this.kqP;
        int i2 = this.kqQ;
        this.kqQ = i2 + 1;
        iArr2[i2] = i;
    }

    private int cMY() {
        if (this.kqQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.kqP[this.kqQ - 1];
    }

    private void EA(int i) {
        this.kqP[this.kqQ - 1] = i;
    }

    public a HX(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.kqR != null) {
            throw new IllegalStateException();
        }
        if (this.kqQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kqR = str;
        return this;
    }

    private void cMZ() throws IOException {
        if (this.kqR != null) {
            cNa();
            string(this.kqR);
            this.kqR = null;
        }
    }

    public a HY(String str) throws IOException {
        if (str == null) {
            return cMS();
        }
        cMZ();
        beforeValue();
        string(str);
        return this;
    }

    public a cMS() throws IOException {
        if (this.kqR != null) {
            if (this.knC) {
                cMZ();
            } else {
                this.kqR = null;
                return this;
            }
        }
        beforeValue();
        this.kqO.write("null");
        return this;
    }

    public a sH(boolean z) throws IOException {
        cMZ();
        beforeValue();
        this.kqO.write(z ? "true" : "false");
        return this;
    }

    public a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cMS();
        }
        cMZ();
        beforeValue();
        this.kqO.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public a eN(long j) throws IOException {
        cMZ();
        beforeValue();
        this.kqO.write(Long.toString(j));
        return this;
    }

    public a a(Number number) throws IOException {
        if (number == null) {
            return cMS();
        }
        cMZ();
        String obj = number.toString();
        if (!this.knG && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.kqO.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.kqQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.kqO.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.kqO.close();
        int i = this.kqQ;
        if (i > 1 || (i == 1 && this.kqP[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.kqQ = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.knD ? kqN : kqM;
        this.kqO.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.kqO.write(str, i2, i - i2);
                }
                this.kqO.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.kqO.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.kqO.write(str, i2, length - i2);
        }
        this.kqO.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.kqO.write("\n");
            int i = this.kqQ;
            for (int i2 = 1; i2 < i; i2++) {
                this.kqO.write(this.indent);
            }
        }
    }

    private void cNa() throws IOException {
        int cMY = cMY();
        if (cMY == 5) {
            this.kqO.write(44);
        } else if (cMY != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        EA(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (cMY()) {
            case 1:
                EA(2);
                newline();
                return;
            case 2:
                this.kqO.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.kqO.append((CharSequence) this.separator);
                EA(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.knG) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        EA(7);
    }
}
