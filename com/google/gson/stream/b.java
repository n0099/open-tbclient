package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] mlY = new String[128];
    private static final String[] mlZ;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mma;
    private String mmb;
    private String separator;
    private boolean serializeNulls;
    private int[] mlX = new int[32];
    private int mjQ = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mlY[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mlY[34] = "\\\"";
        mlY[92] = "\\\\";
        mlY[9] = "\\t";
        mlY[8] = "\\b";
        mlY[10] = "\\n";
        mlY[13] = "\\r";
        mlY[12] = "\\f";
        mlZ = (String[]) mlY.clone();
        mlZ[60] = "\\u003c";
        mlZ[62] = "\\u003e";
        mlZ[38] = "\\u0026";
        mlZ[61] = "\\u003d";
        mlZ[39] = "\\u0027";
    }

    public b(Writer writer) {
        Id(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mma = writer;
    }

    public final void OB(String str) {
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

    public boolean dwd() {
        return this.lenient;
    }

    public final void vY(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dwl() {
        return this.htmlSafe;
    }

    public final void vZ(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dwm() {
        return this.serializeNulls;
    }

    public b dvU() throws IOException {
        dwn();
        return bx(1, "[");
    }

    public b dvV() throws IOException {
        return q(1, 2, "]");
    }

    public b dvW() throws IOException {
        dwn();
        return bx(3, "{");
    }

    public b dvX() throws IOException {
        return q(3, 5, "}");
    }

    private b bx(int i, String str) throws IOException {
        beforeValue();
        Id(i);
        this.mma.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mmb != null) {
            throw new IllegalStateException("Dangling name: " + this.mmb);
        }
        this.mjQ--;
        if (peek == i2) {
            newline();
        }
        this.mma.write(str);
        return this;
    }

    private void Id(int i) {
        if (this.mjQ == this.mlX.length) {
            int[] iArr = new int[this.mjQ * 2];
            System.arraycopy(this.mlX, 0, iArr, 0, this.mjQ);
            this.mlX = iArr;
        }
        int[] iArr2 = this.mlX;
        int i2 = this.mjQ;
        this.mjQ = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mjQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mlX[this.mjQ - 1];
    }

    private void If(int i) {
        this.mlX[this.mjQ - 1] = i;
    }

    public b Ox(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mmb != null) {
            throw new IllegalStateException();
        }
        if (this.mjQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mmb = str;
        return this;
    }

    private void dwn() throws IOException {
        if (this.mmb != null) {
            dwo();
            string(this.mmb);
            this.mmb = null;
        }
    }

    public b Oy(String str) throws IOException {
        if (str == null) {
            return dvY();
        }
        dwn();
        beforeValue();
        string(str);
        return this;
    }

    public b dvY() throws IOException {
        if (this.mmb != null) {
            if (this.serializeNulls) {
                dwn();
            } else {
                this.mmb = null;
                return this;
            }
        }
        beforeValue();
        this.mma.write("null");
        return this;
    }

    public b vV(boolean z) throws IOException {
        dwn();
        beforeValue();
        this.mma.write(z ? "true" : "false");
        return this;
    }

    public b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dvY();
        }
        dwn();
        beforeValue();
        this.mma.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b fU(long j) throws IOException {
        dwn();
        beforeValue();
        this.mma.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dvY();
        }
        dwn();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mma.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mjQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mma.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mma.close();
        int i = this.mjQ;
        if (i > 1 || (i == 1 && this.mlX[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mjQ = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mlZ : mlY;
        this.mma.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mma.write(str, i2, i - i2);
                }
                this.mma.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mma.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mma.write(str, i2, length - i2);
        }
        this.mma.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mma.write("\n");
            int i = this.mjQ;
            for (int i2 = 1; i2 < i; i2++) {
                this.mma.write(this.indent);
            }
        }
    }

    private void dwo() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mma.write(44);
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
                this.mma.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mma.append((CharSequence) this.separator);
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
