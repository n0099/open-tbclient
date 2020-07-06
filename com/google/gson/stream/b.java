package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] ndm = new String[128];
    private static final String[] ndn;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer ndo;
    private String ndp;
    private String separator;
    private boolean serializeNulls;
    private int[] ndl = new int[32];
    private int nbe = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            ndm[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        ndm[34] = "\\\"";
        ndm[92] = "\\\\";
        ndm[9] = "\\t";
        ndm[8] = "\\b";
        ndm[10] = "\\n";
        ndm[13] = "\\r";
        ndm[12] = "\\f";
        ndn = (String[]) ndm.clone();
        ndn[60] = "\\u003c";
        ndn[62] = "\\u003e";
        ndn[38] = "\\u0026";
        ndn[61] = "\\u003d";
        ndn[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.ndo = writer;
    }

    public final void Rg(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void wS(boolean z) {
        this.lenient = z;
    }

    public boolean dIm() {
        return this.lenient;
    }

    public final void wU(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dIu() {
        return this.htmlSafe;
    }

    public final void wV(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dIv() {
        return this.serializeNulls;
    }

    public b dId() throws IOException {
        dIw();
        return bJ(1, "[");
    }

    public b dIe() throws IOException {
        return q(1, 2, "]");
    }

    public b dIf() throws IOException {
        dIw();
        return bJ(3, "{");
    }

    public b dIg() throws IOException {
        return q(3, 5, "}");
    }

    private b bJ(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.ndo.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.ndp != null) {
            throw new IllegalStateException("Dangling name: " + this.ndp);
        }
        this.nbe--;
        if (peek == i2) {
            newline();
        }
        this.ndo.write(str);
        return this;
    }

    private void push(int i) {
        if (this.nbe == this.ndl.length) {
            int[] iArr = new int[this.nbe * 2];
            System.arraycopy(this.ndl, 0, iArr, 0, this.nbe);
            this.ndl = iArr;
        }
        int[] iArr2 = this.ndl;
        int i2 = this.nbe;
        this.nbe = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.nbe == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.ndl[this.nbe - 1];
    }

    private void JZ(int i) {
        this.ndl[this.nbe - 1] = i;
    }

    public b Rc(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.ndp != null) {
            throw new IllegalStateException();
        }
        if (this.nbe == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ndp = str;
        return this;
    }

    private void dIw() throws IOException {
        if (this.ndp != null) {
            dIx();
            string(this.ndp);
            this.ndp = null;
        }
    }

    public b Rd(String str) throws IOException {
        if (str == null) {
            return dIh();
        }
        dIw();
        beforeValue();
        string(str);
        return this;
    }

    public b dIh() throws IOException {
        if (this.ndp != null) {
            if (this.serializeNulls) {
                dIw();
            } else {
                this.ndp = null;
                return this;
            }
        }
        beforeValue();
        this.ndo.write("null");
        return this;
    }

    public b wR(boolean z) throws IOException {
        dIw();
        beforeValue();
        this.ndo.write(z ? "true" : "false");
        return this;
    }

    public b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dIh();
        }
        dIw();
        beforeValue();
        this.ndo.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b fZ(long j) throws IOException {
        dIw();
        beforeValue();
        this.ndo.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dIh();
        }
        dIw();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.ndo.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.nbe == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ndo.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ndo.close();
        int i = this.nbe;
        if (i > 1 || (i == 1 && this.ndl[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.nbe = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? ndn : ndm;
        this.ndo.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.ndo.write(str, i2, i - i2);
                }
                this.ndo.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.ndo.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.ndo.write(str, i2, length - i2);
        }
        this.ndo.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.ndo.write("\n");
            int i = this.nbe;
            for (int i2 = 1; i2 < i; i2++) {
                this.ndo.write(this.indent);
            }
        }
    }

    private void dIx() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.ndo.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        JZ(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                JZ(2);
                newline();
                return;
            case 2:
                this.ndo.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.ndo.append((CharSequence) this.separator);
                JZ(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        JZ(7);
    }
}
