package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {
    private static final String[] pNT = new String[128];
    private static final String[] pNU;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer pNV;
    private String pNW;
    private String separator;
    private boolean serializeNulls;
    private int[] pNS = new int[32];
    private int pLL = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            pNT[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        pNT[34] = "\\\"";
        pNT[92] = "\\\\";
        pNT[9] = "\\t";
        pNT[8] = "\\b";
        pNT[10] = "\\n";
        pNT[13] = "\\r";
        pNT[12] = "\\f";
        pNU = (String[]) pNT.clone();
        pNU[60] = "\\u003c";
        pNU[62] = "\\u003e";
        pNU[38] = "\\u0026";
        pNU[61] = "\\u003d";
        pNU[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.pNV = writer;
    }

    public final void ZT(String str) {
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

    public boolean eCJ() {
        return this.lenient;
    }

    public final void Bn(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean eCR() {
        return this.htmlSafe;
    }

    public final void Bo(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean eCS() {
        return this.serializeNulls;
    }

    public b eCA() throws IOException {
        eCT();
        return cb(1, "[");
    }

    public b eCB() throws IOException {
        return v(1, 2, "]");
    }

    public b eCC() throws IOException {
        eCT();
        return cb(3, "{");
    }

    public b eCD() throws IOException {
        return v(3, 5, "}");
    }

    private b cb(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.pNV.write(str);
        return this;
    }

    private b v(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.pNW != null) {
            throw new IllegalStateException("Dangling name: " + this.pNW);
        }
        this.pLL--;
        if (peek == i2) {
            newline();
        }
        this.pNV.write(str);
        return this;
    }

    private void push(int i) {
        if (this.pLL == this.pNS.length) {
            int[] iArr = new int[this.pLL * 2];
            System.arraycopy(this.pNS, 0, iArr, 0, this.pLL);
            this.pNS = iArr;
        }
        int[] iArr2 = this.pNS;
        int i2 = this.pLL;
        this.pLL = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.pLL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.pNS[this.pLL - 1];
    }

    private void Rv(int i) {
        this.pNS[this.pLL - 1] = i;
    }

    public b ZP(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.pNW != null) {
            throw new IllegalStateException();
        }
        if (this.pLL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pNW = str;
        return this;
    }

    private void eCT() throws IOException {
        if (this.pNW != null) {
            eCU();
            string(this.pNW);
            this.pNW = null;
        }
    }

    public b ZQ(String str) throws IOException {
        if (str == null) {
            return eCE();
        }
        eCT();
        beforeValue();
        string(str);
        return this;
    }

    public b eCE() throws IOException {
        if (this.pNW != null) {
            if (this.serializeNulls) {
                eCT();
            } else {
                this.pNW = null;
                return this;
            }
        }
        beforeValue();
        this.pNV.write("null");
        return this;
    }

    public b Bk(boolean z) throws IOException {
        eCT();
        beforeValue();
        this.pNV.write(z ? "true" : "false");
        return this;
    }

    public b w(Boolean bool) throws IOException {
        if (bool == null) {
            return eCE();
        }
        eCT();
        beforeValue();
        this.pNV.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b iN(long j) throws IOException {
        eCT();
        beforeValue();
        this.pNV.write(Long.toString(j));
        return this;
    }

    public b b(Number number) throws IOException {
        if (number == null) {
            return eCE();
        }
        eCT();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.pNV.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.pLL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.pNV.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pNV.close();
        int i = this.pLL;
        if (i > 1 || (i == 1 && this.pNS[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.pLL = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.htmlSafe ? pNU : pNT;
        this.pNV.write("\"");
        int length = str.length();
        int i2 = 0;
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.pNV.write(str, i2, i - i2);
                }
                this.pNV.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.pNV.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.pNV.write(str, i2, length - i2);
        }
        this.pNV.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.pNV.write("\n");
            int i = this.pLL;
            for (int i2 = 1; i2 < i; i2++) {
                this.pNV.write(this.indent);
            }
        }
    }

    private void eCU() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.pNV.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Rv(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Rv(2);
                newline();
                return;
            case 2:
                this.pNV.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.pNV.append((CharSequence) this.separator);
                Rv(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Rv(7);
    }
}
