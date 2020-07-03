package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b implements Closeable, Flushable {
    private static final String[] ndj = new String[128];
    private static final String[] ndk;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer ndl;
    private String ndm;
    private String separator;
    private boolean serializeNulls;
    private int[] ndi = new int[32];
    private int nbb = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            ndj[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        ndj[34] = "\\\"";
        ndj[92] = "\\\\";
        ndj[9] = "\\t";
        ndj[8] = "\\b";
        ndj[10] = "\\n";
        ndj[13] = "\\r";
        ndj[12] = "\\f";
        ndk = (String[]) ndj.clone();
        ndk[60] = "\\u003c";
        ndk[62] = "\\u003e";
        ndk[38] = "\\u0026";
        ndk[61] = "\\u003d";
        ndk[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.ndl = writer;
    }

    public final void Rf(String str) {
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

    public boolean dIi() {
        return this.lenient;
    }

    public final void wU(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dIq() {
        return this.htmlSafe;
    }

    public final void wV(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dIr() {
        return this.serializeNulls;
    }

    public b dHZ() throws IOException {
        dIs();
        return bJ(1, "[");
    }

    public b dIa() throws IOException {
        return q(1, 2, "]");
    }

    public b dIb() throws IOException {
        dIs();
        return bJ(3, "{");
    }

    public b dIc() throws IOException {
        return q(3, 5, "}");
    }

    private b bJ(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.ndl.write(str);
        return this;
    }

    private b q(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.ndm != null) {
            throw new IllegalStateException("Dangling name: " + this.ndm);
        }
        this.nbb--;
        if (peek == i2) {
            newline();
        }
        this.ndl.write(str);
        return this;
    }

    private void push(int i) {
        if (this.nbb == this.ndi.length) {
            int[] iArr = new int[this.nbb * 2];
            System.arraycopy(this.ndi, 0, iArr, 0, this.nbb);
            this.ndi = iArr;
        }
        int[] iArr2 = this.ndi;
        int i2 = this.nbb;
        this.nbb = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.nbb == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.ndi[this.nbb - 1];
    }

    private void JZ(int i) {
        this.ndi[this.nbb - 1] = i;
    }

    public b Rb(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.ndm != null) {
            throw new IllegalStateException();
        }
        if (this.nbb == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ndm = str;
        return this;
    }

    private void dIs() throws IOException {
        if (this.ndm != null) {
            dIt();
            string(this.ndm);
            this.ndm = null;
        }
    }

    public b Rc(String str) throws IOException {
        if (str == null) {
            return dId();
        }
        dIs();
        beforeValue();
        string(str);
        return this;
    }

    public b dId() throws IOException {
        if (this.ndm != null) {
            if (this.serializeNulls) {
                dIs();
            } else {
                this.ndm = null;
                return this;
            }
        }
        beforeValue();
        this.ndl.write("null");
        return this;
    }

    public b wR(boolean z) throws IOException {
        dIs();
        beforeValue();
        this.ndl.write(z ? "true" : "false");
        return this;
    }

    public b p(Boolean bool) throws IOException {
        if (bool == null) {
            return dId();
        }
        dIs();
        beforeValue();
        this.ndl.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b fZ(long j) throws IOException {
        dIs();
        beforeValue();
        this.ndl.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dId();
        }
        dIs();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.ndl.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.nbb == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ndl.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ndl.close();
        int i = this.nbb;
        if (i > 1 || (i == 1 && this.ndi[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.nbb = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? ndk : ndj;
        this.ndl.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.ndl.write(str, i2, i - i2);
                }
                this.ndl.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.ndl.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.ndl.write(str, i2, length - i2);
        }
        this.ndl.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.ndl.write("\n");
            int i = this.nbb;
            for (int i2 = 1; i2 < i; i2++) {
                this.ndl.write(this.indent);
            }
        }
    }

    private void dIt() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.ndl.write(44);
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
                this.ndl.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.ndl.append((CharSequence) this.separator);
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
