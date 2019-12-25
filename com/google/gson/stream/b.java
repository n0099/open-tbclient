package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes4.dex */
public class b implements Closeable, Flushable {
    private static final String[] mIV = new String[128];
    private static final String[] mIW;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer mIX;
    private String mIY;
    private String separator;
    private boolean serializeNulls;
    private int[] mIU = new int[32];
    private int mGL = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            mIV[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        mIV[34] = "\\\"";
        mIV[92] = "\\\\";
        mIV[9] = "\\t";
        mIV[8] = "\\b";
        mIV[10] = "\\n";
        mIV[13] = "\\r";
        mIV[12] = "\\f";
        mIW = (String[]) mIV.clone();
        mIW[60] = "\\u003c";
        mIW[62] = "\\u003e";
        mIW[38] = "\\u0026";
        mIW[61] = "\\u003d";
        mIW[39] = "\\u0027";
    }

    public b(Writer writer) {
        Mp(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.mIX = writer;
    }

    public final void Qr(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void vN(boolean z) {
        this.lenient = z;
    }

    public boolean dyX() {
        return this.lenient;
    }

    public final void vP(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean dzf() {
        return this.htmlSafe;
    }

    public final void vQ(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean dzg() {
        return this.serializeNulls;
    }

    public b dyP() throws IOException {
        dzh();
        return bd(1, "[");
    }

    public b dyQ() throws IOException {
        return o(1, 2, "]");
    }

    public b dyR() throws IOException {
        dzh();
        return bd(3, "{");
    }

    public b dyS() throws IOException {
        return o(3, 5, "}");
    }

    private b bd(int i, String str) throws IOException {
        beforeValue();
        Mp(i);
        this.mIX.write(str);
        return this;
    }

    private b o(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.mIY != null) {
            throw new IllegalStateException("Dangling name: " + this.mIY);
        }
        this.mGL--;
        if (peek == i2) {
            newline();
        }
        this.mIX.write(str);
        return this;
    }

    private void Mp(int i) {
        if (this.mGL == this.mIU.length) {
            int[] iArr = new int[this.mGL * 2];
            System.arraycopy(this.mIU, 0, iArr, 0, this.mGL);
            this.mIU = iArr;
        }
        int[] iArr2 = this.mIU;
        int i2 = this.mGL;
        this.mGL = i2 + 1;
        iArr2[i2] = i;
    }

    private int peek() {
        if (this.mGL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.mIU[this.mGL - 1];
    }

    private void Mr(int i) {
        this.mIU[this.mGL - 1] = i;
    }

    public b Qn(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.mIY != null) {
            throw new IllegalStateException();
        }
        if (this.mGL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mIY = str;
        return this;
    }

    private void dzh() throws IOException {
        if (this.mIY != null) {
            dzi();
            string(this.mIY);
            this.mIY = null;
        }
    }

    public b Qo(String str) throws IOException {
        if (str == null) {
            return dyT();
        }
        dzh();
        beforeValue();
        string(str);
        return this;
    }

    public b Qs(String str) throws IOException {
        if (str == null) {
            return dyT();
        }
        dzh();
        beforeValue();
        this.mIX.append((CharSequence) str);
        return this;
    }

    public b dyT() throws IOException {
        if (this.mIY != null) {
            if (this.serializeNulls) {
                dzh();
            } else {
                this.mIY = null;
                return this;
            }
        }
        beforeValue();
        this.mIX.write("null");
        return this;
    }

    public b vM(boolean z) throws IOException {
        dzh();
        beforeValue();
        this.mIX.write(z ? "true" : "false");
        return this;
    }

    public b q(Boolean bool) throws IOException {
        if (bool == null) {
            return dyT();
        }
        dzh();
        beforeValue();
        this.mIX.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b gN(long j) throws IOException {
        dzh();
        beforeValue();
        this.mIX.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return dyT();
        }
        dzh();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.mIX.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.mGL == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.mIX.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mIX.close();
        int i = this.mGL;
        if (i > 1 || (i == 1 && this.mIU[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.mGL = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        int i2 = 0;
        String[] strArr = this.htmlSafe ? mIW : mIV;
        this.mIX.write("\"");
        int length = str.length();
        for (i = 0; i < length; i = i + 1) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.mIX.write(str, i2, i - i2);
                }
                this.mIX.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.mIX.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.mIX.write(str, i2, length - i2);
        }
        this.mIX.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.mIX.write("\n");
            int i = this.mGL;
            for (int i2 = 1; i2 < i; i2++) {
                this.mIX.write(this.indent);
            }
        }
    }

    private void dzi() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.mIX.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        Mr(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void beforeValue() throws IOException {
        switch (peek()) {
            case 1:
                Mr(2);
                newline();
                return;
            case 2:
                this.mIX.append(',');
                newline();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.mIX.append((CharSequence) this.separator);
                Mr(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        Mr(7);
    }
}
