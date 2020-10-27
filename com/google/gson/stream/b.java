package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes17.dex */
public class b implements Closeable, Flushable {
    private static final String[] oWL = new String[128];
    private static final String[] oWM;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer oWN;
    private String oWO;
    private String separator;
    private boolean serializeNulls;
    private int[] oWK = new int[32];
    private int oUD = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            oWL[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        oWL[34] = "\\\"";
        oWL[92] = "\\\\";
        oWL[9] = "\\t";
        oWL[8] = "\\b";
        oWL[10] = "\\n";
        oWL[13] = "\\r";
        oWL[12] = "\\f";
        oWM = (String[]) oWL.clone();
        oWM[60] = "\\u003c";
        oWM[62] = "\\u003e";
        oWM[38] = "\\u0026";
        oWM[61] = "\\u003d";
        oWM[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.oWN = writer;
    }

    public final void XZ(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void Ao(boolean z) {
        this.lenient = z;
    }

    public boolean epB() {
        return this.lenient;
    }

    public final void Aq(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean epJ() {
        return this.htmlSafe;
    }

    public final void Ar(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean epK() {
        return this.serializeNulls;
    }

    public b eps() throws IOException {
        epL();
        return bW(1, "[");
    }

    public b ept() throws IOException {
        return u(1, 2, "]");
    }

    public b epu() throws IOException {
        epL();
        return bW(3, "{");
    }

    public b epv() throws IOException {
        return u(3, 5, "}");
    }

    private b bW(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.oWN.write(str);
        return this;
    }

    private b u(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.oWO != null) {
            throw new IllegalStateException("Dangling name: " + this.oWO);
        }
        this.oUD--;
        if (peek == i2) {
            newline();
        }
        this.oWN.write(str);
        return this;
    }

    private void push(int i) {
        if (this.oUD == this.oWK.length) {
            int[] iArr = new int[this.oUD * 2];
            System.arraycopy(this.oWK, 0, iArr, 0, this.oUD);
            this.oWK = iArr;
        }
        int[] iArr2 = this.oWK;
        int i2 = this.oUD;
        this.oUD = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.oUD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.oWK[this.oUD - 1];
    }

    private void Qa(int i) {
        this.oWK[this.oUD - 1] = i;
    }

    public b XV(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.oWO != null) {
            throw new IllegalStateException();
        }
        if (this.oUD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.oWO = str;
        return this;
    }

    private void epL() throws IOException {
        if (this.oWO != null) {
            epM();
            string(this.oWO);
            this.oWO = null;
        }
    }

    public b XW(String str) throws IOException {
        if (str == null) {
            return epw();
        }
        epL();
        beforeValue();
        string(str);
        return this;
    }

    public b epw() throws IOException {
        if (this.oWO != null) {
            if (this.serializeNulls) {
                epL();
            } else {
                this.oWO = null;
                return this;
            }
        }
        beforeValue();
        this.oWN.write("null");
        return this;
    }

    public b An(boolean z) throws IOException {
        epL();
        beforeValue();
        this.oWN.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return epw();
        }
        epL();
        beforeValue();
        this.oWN.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b hx(long j) throws IOException {
        epL();
        beforeValue();
        this.oWN.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return epw();
        }
        epL();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.oWN.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.oUD == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.oWN.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oWN.close();
        int i = this.oUD;
        if (i > 1 || (i == 1 && this.oWK[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.oUD = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? oWM : oWL;
        this.oWN.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.oWN.write(str, i2, i - i2);
                }
                this.oWN.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.oWN.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.oWN.write(str, i2, length - i2);
        }
        this.oWN.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.oWN.write("\n");
            int i = this.oUD;
            for (int i2 = 1; i2 < i; i2++) {
                this.oWN.write(this.indent);
            }
        }
    }

    private void epM() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.oWN.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Qa(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Qa(2);
                newline();
                return;
            case 2:
                this.oWN.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.oWN.append((CharSequence) this.separator);
                Qa(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Qa(7);
    }
}
