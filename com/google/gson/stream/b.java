package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] pwU = new String[128];
    private static final String[] pwV;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pwW;
    private String pwX;
    private String separator;
    private boolean serializeNulls;
    private int[] pwT = new int[32];
    private int puM = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pwU[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pwU[34] = "\\\"";
        pwU[92] = "\\\\";
        pwU[9] = "\\t";
        pwU[8] = "\\b";
        pwU[10] = "\\n";
        pwU[13] = "\\r";
        pwU[12] = "\\f";
        pwV = (String[]) pwU.clone();
        pwV[60] = "\\u003c";
        pwV[62] = "\\u003e";
        pwV[38] = "\\u0026";
        pwV[61] = "\\u003d";
        pwV[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pwW = writer;
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

    public boolean eyX() {
        return this.lenient;
    }

    public final void Bf(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean ezf() {
        return this.htmlSafe;
    }

    public final void Bg(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean ezg() {
        return this.serializeNulls;
    }

    public b eyO() throws IOException {
        ezh();
        return ca(1, "[");
    }

    public b eyP() throws IOException {
        return u(1, 2, "]");
    }

    public b eyQ() throws IOException {
        ezh();
        return ca(3, "{");
    }

    public b eyR() throws IOException {
        return u(3, 5, "}");
    }

    private b ca(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pwW.write(str);
        return this;
    }

    private b u(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pwX != null) {
            throw new IllegalStateException("Dangling name: " + this.pwX);
        }
        this.puM--;
        if (peek == i2) {
            newline();
        }
        this.pwW.write(str);
        return this;
    }

    private void push(int i) {
        if (this.puM == this.pwT.length) {
            int[] iArr = new int[this.puM * 2];
            System.arraycopy(this.pwT, 0, iArr, 0, this.puM);
            this.pwT = iArr;
        }
        int[] iArr2 = this.pwT;
        int i2 = this.puM;
        this.puM = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.puM == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pwT[this.puM - 1];
    }

    private void Ry(int i) {
        this.pwT[this.puM - 1] = i;
    }

    public b ZF(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pwX != null) {
            throw new IllegalStateException();
        }
        if (this.puM == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pwX = str;
        return this;
    }

    private void ezh() throws IOException {
        if (this.pwX != null) {
            ezi();
            string(this.pwX);
            this.pwX = null;
        }
    }

    public b ZG(String str) throws IOException {
        if (str == null) {
            return eyS();
        }
        ezh();
        beforeValue();
        string(str);
        return this;
    }

    public b eyS() throws IOException {
        if (this.pwX != null) {
            if (this.serializeNulls) {
                ezh();
            } else {
                this.pwX = null;
                return this;
            }
        }
        beforeValue();
        this.pwW.write("null");
        return this;
    }

    public b Bc(boolean z) throws IOException {
        ezh();
        beforeValue();
        this.pwW.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return eyS();
        }
        ezh();
        beforeValue();
        this.pwW.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iC(long j) throws IOException {
        ezh();
        beforeValue();
        this.pwW.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return eyS();
        }
        ezh();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pwW.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.puM == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pwW.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pwW.close();
        int i = this.puM;
        if (i > 1 || (i == 1 && this.pwT[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.puM = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? pwV : pwU;
        this.pwW.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pwW.write(str, i2, i - i2);
                }
                this.pwW.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pwW.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pwW.write(str, i2, length - i2);
        }
        this.pwW.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pwW.write("\n");
            int i = this.puM;
            for (int i2 = 1; i2 < i; i2++) {
                this.pwW.write(this.indent);
            }
        }
    }

    private void ezi() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pwW.write(44);
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
                this.pwW.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pwW.append((CharSequence) this.separator);
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
