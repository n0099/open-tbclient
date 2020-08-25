package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes3.dex */
public class b implements Closeable, Flushable {
    private static final String[] nFP = new String[128];
    private static final String[] nFQ;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer nFR;
    private String nFS;
    private String separator;
    private boolean serializeNulls;
    private int[] nFO = new int[32];
    private int nDH = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            nFP[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        nFP[34] = "\\\"";
        nFP[92] = "\\\\";
        nFP[9] = "\\t";
        nFP[8] = "\\b";
        nFP[10] = "\\n";
        nFP[13] = "\\r";
        nFP[12] = "\\f";
        nFQ = (String[]) nFP.clone();
        nFQ[60] = "\\u003c";
        nFQ[62] = "\\u003e";
        nFQ[38] = "\\u0026";
        nFQ[61] = "\\u003d";
        nFQ[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.nFR = writer;
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

    public final void yo(boolean z) {
        this.lenient = z;
    }

    public boolean dXJ() {
        return this.lenient;
    }

    public final void yq(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dXR() {
        return this.htmlSafe;
    }

    public final void yr(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dXS() {
        return this.serializeNulls;
    }

    public b dXA() throws IOException {
        dXT();
        return bI(1, "[");
    }

    public b dXB() throws IOException {
        return p(1, 2, "]");
    }

    public b dXC() throws IOException {
        dXT();
        return bI(3, "{");
    }

    public b dXD() throws IOException {
        return p(3, 5, "}");
    }

    private b bI(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.nFR.write(str);
        return this;
    }

    private b p(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.nFS != null) {
            throw new IllegalStateException("Dangling name: " + this.nFS);
        }
        this.nDH--;
        if (peek == i2) {
            newline();
        }
        this.nFR.write(str);
        return this;
    }

    private void push(int i) {
        if (this.nDH == this.nFO.length) {
            int[] iArr = new int[this.nDH * 2];
            System.arraycopy(this.nFO, 0, iArr, 0, this.nDH);
            this.nFO = iArr;
        }
        int[] iArr2 = this.nFO;
        int i2 = this.nDH;
        this.nDH = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.nDH == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.nFO[this.nDH - 1];
    }

    private void MY(int i) {
        this.nFO[this.nDH - 1] = i;
    }

    public b US(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.nFS != null) {
            throw new IllegalStateException();
        }
        if (this.nDH == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nFS = str;
        return this;
    }

    private void dXT() throws IOException {
        if (this.nFS != null) {
            dXU();
            string(this.nFS);
            this.nFS = null;
        }
    }

    public b UT(String str) throws IOException {
        if (str == null) {
            return dXE();
        }
        dXT();
        beforeValue();
        string(str);
        return this;
    }

    public b dXE() throws IOException {
        if (this.nFS != null) {
            if (this.serializeNulls) {
                dXT();
            } else {
                this.nFS = null;
                return this;
            }
        }
        beforeValue();
        this.nFR.write("null");
        return this;
    }

    public b yn(boolean z) throws IOException {
        dXT();
        beforeValue();
        this.nFR.write(z ? "true" : "false");
        return this;
    }

    public b t(Boolean bool) throws IOException {
        if (bool == null) {
            return dXE();
        }
        dXT();
        beforeValue();
        this.nFR.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gz(long j) throws IOException {
        dXT();
        beforeValue();
        this.nFR.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dXE();
        }
        dXT();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.nFR.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.nDH == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.nFR.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nFR.close();
        int i = this.nDH;
        if (i > 1 || (i == 1 && this.nFO[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.nDH = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? nFQ : nFP;
        this.nFR.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.nFR.write(str, i2, i - i2);
                }
                this.nFR.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.nFR.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.nFR.write(str, i2, length - i2);
        }
        this.nFR.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.nFR.write("\n");
            int i = this.nDH;
            for (int i2 = 1; i2 < i; i2++) {
                this.nFR.write(this.indent);
            }
        }
    }

    private void dXU() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.nFR.write(44);
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
                this.nFR.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.nFR.append((CharSequence) this.separator);
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
