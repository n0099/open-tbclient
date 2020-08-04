package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes10.dex */
public class b implements Closeable, Flushable {
    private static final String[] nlY = new String[128];
    private static final String[] nlZ;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer nma;
    private String nmb;
    private String separator;
    private boolean serializeNulls;
    private int[] nlX = new int[32];
    private int njQ = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            nlY[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        nlY[34] = "\\\"";
        nlY[92] = "\\\\";
        nlY[9] = "\\t";
        nlY[8] = "\\b";
        nlY[10] = "\\n";
        nlY[13] = "\\r";
        nlY[12] = "\\f";
        nlZ = (String[]) nlY.clone();
        nlZ[60] = "\\u003c";
        nlZ[62] = "\\u003e";
        nlZ[38] = "\\u0026";
        nlZ[61] = "\\u003d";
        nlZ[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.nma = writer;
    }

    public final void RS(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void xx(boolean z) {
        this.lenient = z;
    }

    public boolean dLI() {
        return this.lenient;
    }

    public final void xz(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dLQ() {
        return this.htmlSafe;
    }

    public final void xA(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dLR() {
        return this.serializeNulls;
    }

    public b dLz() throws IOException {
        dLS();
        return bK(1, "[");
    }

    public b dLA() throws IOException {
        return q(1, 2, "]");
    }

    public b dLB() throws IOException {
        dLS();
        return bK(3, "{");
    }

    public b dLC() throws IOException {
        return q(3, 5, "}");
    }

    private b bK(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.nma.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.nmb != null) {
            throw new IllegalStateException("Dangling name: " + this.nmb);
        }
        this.njQ--;
        if (peek == i2) {
            newline();
        }
        this.nma.write(str);
        return this;
    }

    private void push(int i) {
        if (this.njQ == this.nlX.length) {
            int[] iArr = new int[this.njQ * 2];
            System.arraycopy(this.nlX, 0, iArr, 0, this.njQ);
            this.nlX = iArr;
        }
        int[] iArr2 = this.nlX;
        int i2 = this.njQ;
        this.njQ = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.njQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.nlX[this.njQ - 1];
    }

    private void Ku(int i) {
        this.nlX[this.njQ - 1] = i;
    }

    public b RO(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.nmb != null) {
            throw new IllegalStateException();
        }
        if (this.njQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nmb = str;
        return this;
    }

    private void dLS() throws IOException {
        if (this.nmb != null) {
            dLT();
            string(this.nmb);
            this.nmb = null;
        }
    }

    public b RP(String str) throws IOException {
        if (str == null) {
            return dLD();
        }
        dLS();
        beforeValue();
        string(str);
        return this;
    }

    public b dLD() throws IOException {
        if (this.nmb != null) {
            if (this.serializeNulls) {
                dLS();
            } else {
                this.nmb = null;
                return this;
            }
        }
        beforeValue();
        this.nma.write("null");
        return this;
    }

    public b xw(boolean z) throws IOException {
        dLS();
        beforeValue();
        this.nma.write(z ? "true" : "false");
        return this;
    }

    public b r(Boolean bool) throws IOException {
        if (bool == null) {
            return dLD();
        }
        dLS();
        beforeValue();
        this.nma.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gm(long j) throws IOException {
        dLS();
        beforeValue();
        this.nma.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dLD();
        }
        dLS();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.nma.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.njQ == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nma.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nma.close();
        int i = this.njQ;
        if (i > 1 || (i == 1 && this.nlX[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.njQ = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? nlZ : nlY;
        this.nma.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.nma.write(str, i2, i - i2);
                }
                this.nma.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.nma.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.nma.write(str, i2, length - i2);
        }
        this.nma.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.nma.write("\n");
            int i = this.njQ;
            for (int i2 = 1; i2 < i; i2++) {
                this.nma.write(this.indent);
            }
        }
    }

    private void dLT() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.nma.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Ku(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Ku(2);
                newline();
                return;
            case 2:
                this.nma.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.nma.append((CharSequence) this.separator);
                Ku(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Ku(7);
    }
}
