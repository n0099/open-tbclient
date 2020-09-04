package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes3.dex */
public class b implements Closeable, Flushable {
    private static final String[] nGh = new String[128];
    private static final String[] nGi;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer nGj;
    private String nGk;
    private String separator;
    private boolean serializeNulls;
    private int[] nGg = new int[32];
    private int nDZ = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            nGh[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        nGh[34] = "\\\"";
        nGh[92] = "\\\\";
        nGh[9] = "\\t";
        nGh[8] = "\\b";
        nGh[10] = "\\n";
        nGh[13] = "\\r";
        nGh[12] = "\\f";
        nGi = (String[]) nGh.clone();
        nGi[60] = "\\u003c";
        nGi[62] = "\\u003e";
        nGi[38] = "\\u0026";
        nGi[61] = "\\u003d";
        nGi[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.nGj = writer;
    }

    public final void UW(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void yq(boolean z) {
        this.lenient = z;
    }

    public boolean dXS() {
        return this.lenient;
    }

    public final void ys(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dYa() {
        return this.htmlSafe;
    }

    public final void yt(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dYb() {
        return this.serializeNulls;
    }

    public b dXJ() throws IOException {
        dYc();
        return bH(1, "[");
    }

    public b dXK() throws IOException {
        return p(1, 2, "]");
    }

    public b dXL() throws IOException {
        dYc();
        return bH(3, "{");
    }

    public b dXM() throws IOException {
        return p(3, 5, "}");
    }

    private b bH(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.nGj.write(str);
        return this;
    }

    private b p(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.nGk != null) {
            throw new IllegalStateException("Dangling name: " + this.nGk);
        }
        this.nDZ--;
        if (peek == i2) {
            newline();
        }
        this.nGj.write(str);
        return this;
    }

    private void push(int i) {
        if (this.nDZ == this.nGg.length) {
            int[] iArr = new int[this.nDZ * 2];
            System.arraycopy(this.nGg, 0, iArr, 0, this.nDZ);
            this.nGg = iArr;
        }
        int[] iArr2 = this.nGg;
        int i2 = this.nDZ;
        this.nDZ = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.nDZ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.nGg[this.nDZ - 1];
    }

    private void MY(int i) {
        this.nGg[this.nDZ - 1] = i;
    }

    public b US(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.nGk != null) {
            throw new IllegalStateException();
        }
        if (this.nDZ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nGk = str;
        return this;
    }

    private void dYc() throws IOException {
        if (this.nGk != null) {
            dYd();
            string(this.nGk);
            this.nGk = null;
        }
    }

    public b UT(String str) throws IOException {
        if (str == null) {
            return dXN();
        }
        dYc();
        beforeValue();
        string(str);
        return this;
    }

    public b dXN() throws IOException {
        if (this.nGk != null) {
            if (this.serializeNulls) {
                dYc();
            } else {
                this.nGk = null;
                return this;
            }
        }
        beforeValue();
        this.nGj.write("null");
        return this;
    }

    public b yp(boolean z) throws IOException {
        dYc();
        beforeValue();
        this.nGj.write(z ? "true" : "false");
        return this;
    }

    public b t(Boolean bool) throws IOException {
        if (bool == null) {
            return dXN();
        }
        dYc();
        beforeValue();
        this.nGj.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gB(long j) throws IOException {
        dYc();
        beforeValue();
        this.nGj.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dXN();
        }
        dYc();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.nGj.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.nDZ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nGj.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nGj.close();
        int i = this.nDZ;
        if (i > 1 || (i == 1 && this.nGg[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.nDZ = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? nGi : nGh;
        this.nGj.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.nGj.write(str, i2, i - i2);
                }
                this.nGj.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.nGj.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.nGj.write(str, i2, length - i2);
        }
        this.nGj.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.nGj.write("\n");
            int i = this.nDZ;
            for (int i2 = 1; i2 < i; i2++) {
                this.nGj.write(this.indent);
            }
        }
    }

    private void dYd() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.nGj.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        MY(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                MY(2);
                newline();
                return;
            case 2:
                this.nGj.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.nGj.append((CharSequence) this.separator);
                MY(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        MY(7);
    }
}
