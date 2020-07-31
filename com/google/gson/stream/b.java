package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes10.dex */
public class b implements Closeable, Flushable {
    private static final String[] nlW = new String[128];
    private static final String[] nlX;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer nlY;
    private String nlZ;
    private String separator;
    private boolean serializeNulls;
    private int[] nlV = new int[32];
    private int njO = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            nlW[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        nlW[34] = "\\\"";
        nlW[92] = "\\\\";
        nlW[9] = "\\t";
        nlW[8] = "\\b";
        nlW[10] = "\\n";
        nlW[13] = "\\r";
        nlW[12] = "\\f";
        nlX = (String[]) nlW.clone();
        nlX[60] = "\\u003c";
        nlX[62] = "\\u003e";
        nlX[38] = "\\u0026";
        nlX[61] = "\\u003d";
        nlX[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.nlY = writer;
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

    public boolean dLH() {
        return this.lenient;
    }

    public final void xz(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dLP() {
        return this.htmlSafe;
    }

    public final void xA(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dLQ() {
        return this.serializeNulls;
    }

    public b dLy() throws IOException {
        dLR();
        return bK(1, "[");
    }

    public b dLz() throws IOException {
        return q(1, 2, "]");
    }

    public b dLA() throws IOException {
        dLR();
        return bK(3, "{");
    }

    public b dLB() throws IOException {
        return q(3, 5, "}");
    }

    private b bK(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.nlY.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.nlZ != null) {
            throw new IllegalStateException("Dangling name: " + this.nlZ);
        }
        this.njO--;
        if (peek == i2) {
            newline();
        }
        this.nlY.write(str);
        return this;
    }

    private void push(int i) {
        if (this.njO == this.nlV.length) {
            int[] iArr = new int[this.njO * 2];
            System.arraycopy(this.nlV, 0, iArr, 0, this.njO);
            this.nlV = iArr;
        }
        int[] iArr2 = this.nlV;
        int i2 = this.njO;
        this.njO = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.njO == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.nlV[this.njO - 1];
    }

    private void Ku(int i) {
        this.nlV[this.njO - 1] = i;
    }

    public b RO(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.nlZ != null) {
            throw new IllegalStateException();
        }
        if (this.njO == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nlZ = str;
        return this;
    }

    private void dLR() throws IOException {
        if (this.nlZ != null) {
            dLS();
            string(this.nlZ);
            this.nlZ = null;
        }
    }

    public b RP(String str) throws IOException {
        if (str == null) {
            return dLC();
        }
        dLR();
        beforeValue();
        string(str);
        return this;
    }

    public b dLC() throws IOException {
        if (this.nlZ != null) {
            if (this.serializeNulls) {
                dLR();
            } else {
                this.nlZ = null;
                return this;
            }
        }
        beforeValue();
        this.nlY.write("null");
        return this;
    }

    public b xw(boolean z) throws IOException {
        dLR();
        beforeValue();
        this.nlY.write(z ? "true" : "false");
        return this;
    }

    public b r(Boolean bool) throws IOException {
        if (bool == null) {
            return dLC();
        }
        dLR();
        beforeValue();
        this.nlY.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gm(long j) throws IOException {
        dLR();
        beforeValue();
        this.nlY.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dLC();
        }
        dLR();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.nlY.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.njO == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nlY.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nlY.close();
        int i = this.njO;
        if (i > 1 || (i == 1 && this.nlV[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.njO = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? nlX : nlW;
        this.nlY.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.nlY.write(str, i2, i - i2);
                }
                this.nlY.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.nlY.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.nlY.write(str, i2, length - i2);
        }
        this.nlY.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.nlY.write("\n");
            int i = this.njO;
            for (int i2 = 1; i2 < i; i2++) {
                this.nlY.write(this.indent);
            }
        }
    }

    private void dLS() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.nlY.write(44);
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
                this.nlY.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.nlY.append((CharSequence) this.separator);
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
