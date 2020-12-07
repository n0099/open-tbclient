package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] pwS = new String[128];
    private static final String[] pwT;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pwU;
    private String pwV;
    private String separator;
    private boolean serializeNulls;
    private int[] pwR = new int[32];
    private int puK = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pwS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pwS[34] = "\\\"";
        pwS[92] = "\\\\";
        pwS[9] = "\\t";
        pwS[8] = "\\b";
        pwS[10] = "\\n";
        pwS[13] = "\\r";
        pwS[12] = "\\f";
        pwT = (String[]) pwS.clone();
        pwT[60] = "\\u003c";
        pwT[62] = "\\u003e";
        pwT[38] = "\\u0026";
        pwT[61] = "\\u003d";
        pwT[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pwU = writer;
    }

    public final void ZJ(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void Bd(boolean z) {
        this.lenient = z;
    }

    public boolean eyW() {
        return this.lenient;
    }

    public final void Bf(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean eze() {
        return this.htmlSafe;
    }

    public final void Bg(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean ezf() {
        return this.serializeNulls;
    }

    public b eyN() throws IOException {
        ezg();
        return ca(1, "[");
    }

    public b eyO() throws IOException {
        return u(1, 2, "]");
    }

    public b eyP() throws IOException {
        ezg();
        return ca(3, "{");
    }

    public b eyQ() throws IOException {
        return u(3, 5, "}");
    }

    private b ca(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pwU.write(str);
        return this;
    }

    private b u(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pwV != null) {
            throw new IllegalStateException("Dangling name: " + this.pwV);
        }
        this.puK--;
        if (peek == i2) {
            newline();
        }
        this.pwU.write(str);
        return this;
    }

    private void push(int i) {
        if (this.puK == this.pwR.length) {
            int[] iArr = new int[this.puK * 2];
            System.arraycopy(this.pwR, 0, iArr, 0, this.puK);
            this.pwR = iArr;
        }
        int[] iArr2 = this.pwR;
        int i2 = this.puK;
        this.puK = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.puK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pwR[this.puK - 1];
    }

    private void Ry(int i) {
        this.pwR[this.puK - 1] = i;
    }

    public b ZF(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pwV != null) {
            throw new IllegalStateException();
        }
        if (this.puK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pwV = str;
        return this;
    }

    private void ezg() throws IOException {
        if (this.pwV != null) {
            ezh();
            string(this.pwV);
            this.pwV = null;
        }
    }

    public b ZG(String str) throws IOException {
        if (str == null) {
            return eyR();
        }
        ezg();
        beforeValue();
        string(str);
        return this;
    }

    public b eyR() throws IOException {
        if (this.pwV != null) {
            if (this.serializeNulls) {
                ezg();
            } else {
                this.pwV = null;
                return this;
            }
        }
        beforeValue();
        this.pwU.write("null");
        return this;
    }

    public b Bc(boolean z) throws IOException {
        ezg();
        beforeValue();
        this.pwU.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return eyR();
        }
        ezg();
        beforeValue();
        this.pwU.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iC(long j) throws IOException {
        ezg();
        beforeValue();
        this.pwU.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return eyR();
        }
        ezg();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pwU.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.puK == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pwU.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pwU.close();
        int i = this.puK;
        if (i > 1 || (i == 1 && this.pwR[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.puK = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? pwT : pwS;
        this.pwU.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pwU.write(str, i2, i - i2);
                }
                this.pwU.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pwU.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pwU.write(str, i2, length - i2);
        }
        this.pwU.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pwU.write("\n");
            int i = this.puK;
            for (int i2 = 1; i2 < i; i2++) {
                this.pwU.write(this.indent);
            }
        }
    }

    private void ezh() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pwU.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Ry(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Ry(2);
                newline();
                return;
            case 2:
                this.pwU.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pwU.append((CharSequence) this.separator);
                Ry(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Ry(7);
    }
}
