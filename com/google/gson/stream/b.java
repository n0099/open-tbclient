package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes17.dex */
public class b implements Closeable, Flushable {
    private static final String[] ofw = new String[128];
    private static final String[] ofx;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer ofy;
    private String ofz;
    private String separator;
    private boolean serializeNulls;
    private int[] ofv = new int[32];
    private int odn = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            ofw[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        ofw[34] = "\\\"";
        ofw[92] = "\\\\";
        ofw[9] = "\\t";
        ofw[8] = "\\b";
        ofw[10] = "\\n";
        ofw[13] = "\\r";
        ofw[12] = "\\f";
        ofx = (String[]) ofw.clone();
        ofx[60] = "\\u003c";
        ofx[62] = "\\u003e";
        ofx[38] = "\\u0026";
        ofx[61] = "\\u003d";
        ofx[39] = "\\u0027";
    }

    public b(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.ofy = writer;
    }

    public final void Wm(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void zg(boolean z) {
        this.lenient = z;
    }

    public boolean efB() {
        return this.lenient;
    }

    public final void zi(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean efJ() {
        return this.htmlSafe;
    }

    public final void zj(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean efK() {
        return this.serializeNulls;
    }

    public b efs() throws IOException {
        efL();
        return bV(1, "[");
    }

    public b eft() throws IOException {
        return r(1, 2, "]");
    }

    public b efu() throws IOException {
        efL();
        return bV(3, "{");
    }

    public b efv() throws IOException {
        return r(3, 5, "}");
    }

    private b bV(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.ofy.write(str);
        return this;
    }

    private b r(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.ofz != null) {
            throw new IllegalStateException("Dangling name: " + this.ofz);
        }
        this.odn--;
        if (peek == i2) {
            newline();
        }
        this.ofy.write(str);
        return this;
    }

    private void push(int i) {
        if (this.odn == this.ofv.length) {
            int[] iArr = new int[this.odn * 2];
            System.arraycopy(this.ofv, 0, iArr, 0, this.odn);
            this.ofv = iArr;
        }
        int[] iArr2 = this.ofv;
        int i2 = this.odn;
        this.odn = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.odn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.ofv[this.odn - 1];
    }

    private void Oj(int i) {
        this.ofv[this.odn - 1] = i;
    }

    public b Wi(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.ofz != null) {
            throw new IllegalStateException();
        }
        if (this.odn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ofz = str;
        return this;
    }

    private void efL() throws IOException {
        if (this.ofz != null) {
            efM();
            string(this.ofz);
            this.ofz = null;
        }
    }

    public b Wj(String str) throws IOException {
        if (str == null) {
            return efw();
        }
        efL();
        beforeValue();
        string(str);
        return this;
    }

    public b efw() throws IOException {
        if (this.ofz != null) {
            if (this.serializeNulls) {
                efL();
            } else {
                this.ofz = null;
                return this;
            }
        }
        beforeValue();
        this.ofy.write("null");
        return this;
    }

    public b zf(boolean z) throws IOException {
        efL();
        beforeValue();
        this.ofy.write(z ? "true" : "false");
        return this;
    }

    public b v(Boolean bool) throws IOException {
        if (bool == null) {
            return efw();
        }
        efL();
        beforeValue();
        this.ofy.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b hh(long j) throws IOException {
        efL();
        beforeValue();
        this.ofy.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return efw();
        }
        efL();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.ofy.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.odn == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.ofy.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ofy.close();
        int i = this.odn;
        if (i > 1 || (i == 1 && this.ofv[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.odn = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? ofx : ofw;
        this.ofy.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.ofy.write(str, i2, i - i2);
                }
                this.ofy.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.ofy.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.ofy.write(str, i2, length - i2);
        }
        this.ofy.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.ofy.write("\n");
            int i = this.odn;
            for (int i2 = 1; i2 < i; i2++) {
                this.ofy.write(this.indent);
            }
        }
    }

    private void efM() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.ofy.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Oj(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Oj(2);
                newline();
                return;
            case 2:
                this.ofy.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.ofy.append((CharSequence) this.separator);
                Oj(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Oj(7);
    }
}
