package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes23.dex */
public class b implements Closeable, Flushable {
    private static final String[] nQd = new String[128];
    private static final String[] nQe;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer nQf;
    private String nQg;
    private String separator;
    private boolean serializeNulls;
    private int[] nQc = new int[32];
    private int nNV = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            nQd[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        nQd[34] = "\\\"";
        nQd[92] = "\\\\";
        nQd[9] = "\\t";
        nQd[8] = "\\b";
        nQd[10] = "\\n";
        nQd[13] = "\\r";
        nQd[12] = "\\f";
        nQe = (String[]) nQd.clone();
        nQe[60] = "\\u003c";
        nQe[62] = "\\u003e";
        nQe[38] = "\\u0026";
        nQe[61] = "\\u003d";
        nQe[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.nQf = writer;
    }

    public final void Vy(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void yz(boolean z) {
        this.lenient = z;
    }

    public boolean ebQ() {
        return this.lenient;
    }

    public final void yB(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean ebY() {
        return this.htmlSafe;
    }

    public final void yC(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean ebZ() {
        return this.serializeNulls;
    }

    public b ebH() throws IOException {
        eca();
        return bL(1, "[");
    }

    public b ebI() throws IOException {
        return q(1, 2, "]");
    }

    public b ebJ() throws IOException {
        eca();
        return bL(3, "{");
    }

    public b ebK() throws IOException {
        return q(3, 5, "}");
    }

    private b bL(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.nQf.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.nQg != null) {
            throw new IllegalStateException("Dangling name: " + this.nQg);
        }
        this.nNV--;
        if (peek == i2) {
            newline();
        }
        this.nQf.write(str);
        return this;
    }

    private void push(int i) {
        if (this.nNV == this.nQc.length) {
            int[] iArr = new int[this.nNV * 2];
            System.arraycopy(this.nQc, 0, iArr, 0, this.nNV);
            this.nQc = iArr;
        }
        int[] iArr2 = this.nQc;
        int i2 = this.nNV;
        this.nNV = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.nNV == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.nQc[this.nNV - 1];
    }

    private void ND(int i) {
        this.nQc[this.nNV - 1] = i;
    }

    public b Vu(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.nQg != null) {
            throw new IllegalStateException();
        }
        if (this.nNV == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nQg = str;
        return this;
    }

    private void eca() throws IOException {
        if (this.nQg != null) {
            ecb();
            string(this.nQg);
            this.nQg = null;
        }
    }

    public b Vv(String str) throws IOException {
        if (str == null) {
            return ebL();
        }
        eca();
        beforeValue();
        string(str);
        return this;
    }

    public b ebL() throws IOException {
        if (this.nQg != null) {
            if (this.serializeNulls) {
                eca();
            } else {
                this.nQg = null;
                return this;
            }
        }
        beforeValue();
        this.nQf.write("null");
        return this;
    }

    public b yy(boolean z) throws IOException {
        eca();
        beforeValue();
        this.nQf.write(z ? "true" : "false");
        return this;
    }

    public b u(Boolean bool) throws IOException {
        if (bool == null) {
            return ebL();
        }
        eca();
        beforeValue();
        this.nQf.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gP(long j) throws IOException {
        eca();
        beforeValue();
        this.nQf.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return ebL();
        }
        eca();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.nQf.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.nNV == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nQf.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nQf.close();
        int i = this.nNV;
        if (i > 1 || (i == 1 && this.nQc[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.nNV = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? nQe : nQd;
        this.nQf.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.nQf.write(str, i2, i - i2);
                }
                this.nQf.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.nQf.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.nQf.write(str, i2, length - i2);
        }
        this.nQf.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.nQf.write("\n");
            int i = this.nNV;
            for (int i2 = 1; i2 < i; i2++) {
                this.nQf.write(this.indent);
            }
        }
    }

    private void ecb() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.nQf.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        ND(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                ND(2);
                newline();
                return;
            case 2:
                this.nQf.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.nQf.append((CharSequence) this.separator);
                ND(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        ND(7);
    }
}
