package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] pPB = new String[128];
    private static final String[] pPC;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pPD;
    private String pPE;
    private String separator;
    private boolean serializeNulls;
    private int[] pPA = new int[32];
    private int pNt = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pPB[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pPB[34] = "\\\"";
        pPB[92] = "\\\\";
        pPB[9] = "\\t";
        pPB[8] = "\\b";
        pPB[10] = "\\n";
        pPB[13] = "\\r";
        pPB[12] = "\\f";
        pPC = (String[]) pPB.clone();
        pPC[60] = "\\u003c";
        pPC[62] = "\\u003e";
        pPC[38] = "\\u0026";
        pPC[61] = "\\u003d";
        pPC[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pPD = writer;
    }

    public final void ZU(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void Bl(boolean z) {
        this.lenient = z;
    }

    public boolean eDn() {
        return this.lenient;
    }

    public final void Bn(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean eDv() {
        return this.htmlSafe;
    }

    public final void Bo(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean eDw() {
        return this.serializeNulls;
    }

    public b eDe() throws IOException {
        eDx();
        return cb(1, "[");
    }

    public b eDf() throws IOException {
        return v(1, 2, "]");
    }

    public b eDg() throws IOException {
        eDx();
        return cb(3, "{");
    }

    public b eDh() throws IOException {
        return v(3, 5, "}");
    }

    private b cb(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pPD.write(str);
        return this;
    }

    private b v(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pPE != null) {
            throw new IllegalStateException("Dangling name: " + this.pPE);
        }
        this.pNt--;
        if (peek == i2) {
            newline();
        }
        this.pPD.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pNt == this.pPA.length) {
            int[] iArr = new int[this.pNt * 2];
            System.arraycopy(this.pPA, 0, iArr, 0, this.pNt);
            this.pPA = iArr;
        }
        int[] iArr2 = this.pPA;
        int i2 = this.pNt;
        this.pNt = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pNt == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pPA[this.pNt - 1];
    }

    private void RL(int i) {
        this.pPA[this.pNt - 1] = i;
    }

    public b ZQ(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pPE != null) {
            throw new IllegalStateException();
        }
        if (this.pNt == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pPE = str;
        return this;
    }

    private void eDx() throws IOException {
        if (this.pPE != null) {
            eDy();
            string(this.pPE);
            this.pPE = null;
        }
    }

    public b ZR(String str) throws IOException {
        if (str == null) {
            return eDi();
        }
        eDx();
        beforeValue();
        string(str);
        return this;
    }

    public b eDi() throws IOException {
        if (this.pPE != null) {
            if (this.serializeNulls) {
                eDx();
            } else {
                this.pPE = null;
                return this;
            }
        }
        beforeValue();
        this.pPD.write("null");
        return this;
    }

    public b Bk(boolean z) throws IOException {
        eDx();
        beforeValue();
        this.pPD.write(z ? "true" : "false");
        return this;
    }

    public b w(Boolean bool) throws IOException {
        if (bool == null) {
            return eDi();
        }
        eDx();
        beforeValue();
        this.pPD.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iQ(long j) throws IOException {
        eDx();
        beforeValue();
        this.pPD.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return eDi();
        }
        eDx();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pPD.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pNt == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pPD.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pPD.close();
        int i = this.pNt;
        if (i > 1 || (i == 1 && this.pPA[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pNt = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.htmlSafe ? pPC : pPB;
        this.pPD.write("\"");
        int length = str.length();
        int i2 = 0;
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pPD.write(str, i2, i - i2);
                }
                this.pPD.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pPD.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pPD.write(str, i2, length - i2);
        }
        this.pPD.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pPD.write("\n");
            int i = this.pNt;
            for (int i2 = 1; i2 < i; i2++) {
                this.pPD.write(this.indent);
            }
        }
    }

    private void eDy() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pPD.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        RL(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                RL(2);
                newline();
                return;
            case 2:
                this.pPD.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pPD.append((CharSequence) this.separator);
                RL(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        RL(7);
    }
}
