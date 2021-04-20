package d.g.d.d;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes6.dex */
public class b implements Closeable, Flushable {
    public static final String[] n = new String[128];
    public static final String[] o;

    /* renamed from: e  reason: collision with root package name */
    public final Writer f67117e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f67118f = new int[32];

    /* renamed from: g  reason: collision with root package name */
    public int f67119g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f67120h;
    public String i;
    public boolean j;
    public boolean k;
    public String l;
    public boolean m;

    static {
        for (int i = 0; i <= 31; i++) {
            n[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = n;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        o = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        E(6);
        this.i = ":";
        this.m = true;
        if (writer != null) {
            this.f67117e = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final void A() throws IOException {
        if (this.f67120h == null) {
            return;
        }
        this.f67117e.write("\n");
        int i = this.f67119g;
        for (int i2 = 1; i2 < i; i2++) {
            this.f67117e.write(this.f67120h);
        }
    }

    public b B() throws IOException {
        if (this.l != null) {
            if (this.m) {
                Q();
            } else {
                this.l = null;
                return this;
            }
        }
        o();
        this.f67117e.write(StringUtil.NULL_STRING);
        return this;
    }

    public final b C(int i, String str) throws IOException {
        o();
        E(i);
        this.f67117e.write(str);
        return this;
    }

    public final int D() {
        int i = this.f67119g;
        if (i != 0) {
            return this.f67118f[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void E(int i) {
        int i2 = this.f67119g;
        int[] iArr = this.f67118f;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f67118f = iArr2;
        }
        int[] iArr3 = this.f67118f;
        int i3 = this.f67119g;
        this.f67119g = i3 + 1;
        iArr3[i3] = i;
    }

    public final void F(int i) {
        this.f67118f[this.f67119g - 1] = i;
    }

    public final void G(boolean z) {
        this.k = z;
    }

    public final void H(String str) {
        if (str.length() == 0) {
            this.f67120h = null;
            this.i = ":";
            return;
        }
        this.f67120h = str;
        this.i = ": ";
    }

    public final void I(boolean z) {
        this.j = z;
    }

    public final void J(boolean z) {
        this.m = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.k ? o : n;
        this.f67117e.write("\"");
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.f67117e.write(str, i2, i - i2);
                }
                this.f67117e.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.f67117e.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.f67117e.write(str, i2, length - i2);
        }
        this.f67117e.write("\"");
    }

    public b L(long j) throws IOException {
        Q();
        o();
        this.f67117e.write(Long.toString(j));
        return this;
    }

    public b M(Boolean bool) throws IOException {
        if (bool == null) {
            return B();
        }
        Q();
        o();
        this.f67117e.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b N(Number number) throws IOException {
        if (number == null) {
            return B();
        }
        Q();
        String obj = number.toString();
        if (!this.j && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals(WalletPayViewController.DEF_CHANNEL_TITLE))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        o();
        this.f67117e.append((CharSequence) obj);
        return this;
    }

    public b O(String str) throws IOException {
        if (str == null) {
            return B();
        }
        Q();
        o();
        K(str);
        return this;
    }

    public b P(boolean z) throws IOException {
        Q();
        o();
        this.f67117e.write(z ? "true" : "false");
        return this;
    }

    public final void Q() throws IOException {
        if (this.l != null) {
            n();
            K(this.l);
            this.l = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f67117e.close();
        int i = this.f67119g;
        if (i <= 1 && (i != 1 || this.f67118f[i - 1] == 7)) {
            this.f67119g = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void flush() throws IOException {
        if (this.f67119g != 0) {
            this.f67117e.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void n() throws IOException {
        int D = D();
        if (D == 5) {
            this.f67117e.write(44);
        } else if (D != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        A();
        F(4);
    }

    public final void o() throws IOException {
        int D = D();
        if (D == 1) {
            F(2);
            A();
        } else if (D == 2) {
            this.f67117e.append(',');
            A();
        } else if (D != 4) {
            if (D != 6) {
                if (D == 7) {
                    if (!this.j) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            F(7);
        } else {
            this.f67117e.append((CharSequence) this.i);
            F(5);
        }
    }

    public b q() throws IOException {
        Q();
        C(1, "[");
        return this;
    }

    public b r() throws IOException {
        Q();
        C(3, StringUtil.ARRAY_START);
        return this;
    }

    public final b s(int i, int i2, String str) throws IOException {
        int D = D();
        if (D != i2 && D != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.l == null) {
            this.f67119g--;
            if (D == i2) {
                A();
            }
            this.f67117e.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.l);
    }

    public b t() throws IOException {
        s(1, 2, "]");
        return this;
    }

    public b v() throws IOException {
        s(3, 5, "}");
        return this;
    }

    public final boolean w() {
        return this.m;
    }

    public final boolean x() {
        return this.k;
    }

    public boolean y() {
        return this.j;
    }

    public b z(String str) throws IOException {
        if (str != null) {
            if (this.l == null) {
                if (this.f67119g != 0) {
                    this.l = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }
}
