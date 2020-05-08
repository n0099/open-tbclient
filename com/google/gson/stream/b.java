package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mmc = new String[128];
    private static final String[] mmd;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mme;
    private String mmf;
    private String separator;
    private boolean serializeNulls;
    private int[] mmb = new int[32];
    private int mjU = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mmc[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mmc[34] = "\\\"";
        mmc[92] = "\\\\";
        mmc[9] = "\\t";
        mmc[8] = "\\b";
        mmc[10] = "\\n";
        mmc[13] = "\\r";
        mmc[12] = "\\f";
        mmd = (String[]) mmc.clone();
        mmd[60] = "\\u003c";
        mmd[62] = "\\u003e";
        mmd[38] = "\\u0026";
        mmd[61] = "\\u003d";
        mmd[39] = "\\u0027";
    }

    public b(Writer writer) {
        Id(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mme = writer;
    }

    public final void OE(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void vW(boolean z) {
        this.lenient = z;
    }

    public boolean dwa() {
        return this.lenient;
    }

    public final void vY(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dwi() {
        return this.htmlSafe;
    }

    public final void vZ(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dwj() {
        return this.serializeNulls;
    }

    public b dvR() throws IOException {
        dwk();
        return bx(1, "[");
    }

    public b dvS() throws IOException {
        return q(1, 2, "]");
    }

    public b dvT() throws IOException {
        dwk();
        return bx(3, "{");
    }

    public b dvU() throws IOException {
        return q(3, 5, "}");
    }

    private b bx(int i, String str) throws IOException {
        beforeValue();
        Id(i);
        this.mme.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mmf != null) {
            throw new IllegalStateException("Dangling name: " + this.mmf);
        }
        this.mjU--;
        if (peek == i2) {
            newline();
        }
        this.mme.write(str);
        return this;
    }

    private void Id(int i) {
        if (this.mjU == this.mmb.length) {
            int[] iArr = new int[this.mjU * 2];
            System.arraycopy(this.mmb, 0, iArr, 0, this.mjU);
            this.mmb = iArr;
        }
        int[] iArr2 = this.mmb;
        int i2 = this.mjU;
        this.mjU = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mjU == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mmb[this.mjU - 1];
    }

    private void If(int i) {
        this.mmb[this.mjU - 1] = i;
    }

    public b OA(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mmf != null) {
            throw new IllegalStateException();
        }
        if (this.mjU == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mmf = str;
        return this;
    }

    private void dwk() throws IOException {
        if (this.mmf != null) {
            dwl();
            string(this.mmf);
            this.mmf = null;
        }
    }

    public b OB(String str) throws IOException {
        if (str == null) {
            return dvV();
        }
        dwk();
        beforeValue();
        string(str);
        return this;
    }

    public b dvV() throws IOException {
        if (this.mmf != null) {
            if (this.serializeNulls) {
                dwk();
            } else {
                this.mmf = null;
                return this;
            }
        }
        beforeValue();
        this.mme.write("null");
        return this;
    }

    public b vV(boolean z) throws IOException {
        dwk();
        beforeValue();
        this.mme.write(z ? "true" : "false");
        return this;
    }

    public b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dvV();
        }
        dwk();
        beforeValue();
        this.mme.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b fU(long j) throws IOException {
        dwk();
        beforeValue();
        this.mme.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dvV();
        }
        dwk();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mme.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mjU == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mme.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mme.close();
        int i = this.mjU;
        if (i > 1 || (i == 1 && this.mmb[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mjU = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mmd : mmc;
        this.mme.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mme.write(str, i2, i - i2);
                }
                this.mme.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mme.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mme.write(str, i2, length - i2);
        }
        this.mme.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mme.write("\n");
            int i = this.mjU;
            for (int i2 = 1; i2 < i; i2++) {
                this.mme.write(this.indent);
            }
        }
    }

    private void dwl() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mme.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        If(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                If(2);
                newline();
                return;
            case 2:
                this.mme.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mme.append((CharSequence) this.separator);
                If(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        If(7);
    }
}
