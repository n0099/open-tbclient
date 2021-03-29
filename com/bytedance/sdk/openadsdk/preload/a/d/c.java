package com.bytedance.sdk.openadsdk.preload.a.d;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class c implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f30107a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f30108b;

    /* renamed from: c  reason: collision with root package name */
    public final Writer f30109c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f30110d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    public int f30111e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f30112f;

    /* renamed from: g  reason: collision with root package name */
    public String f30113g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30114h;
    public boolean i;
    public String j;
    public boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            f30107a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f30107a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f30108b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.f30113g = ":";
        this.k = true;
        if (writer != null) {
            this.f30109c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private c a(int i, char c2) throws IOException {
        m();
        a(i);
        this.f30109c.write(c2);
        return this;
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    private void k() throws IOException {
        if (this.f30112f == null) {
            return;
        }
        this.f30109c.write(10);
        int i = this.f30111e;
        for (int i2 = 1; i2 < i; i2++) {
            this.f30109c.write(this.f30112f);
        }
    }

    private void l() throws IOException {
        int a2 = a();
        if (a2 == 5) {
            this.f30109c.write(44);
        } else if (a2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        int a2 = a();
        if (a2 == 1) {
            b(2);
            k();
        } else if (a2 == 2) {
            this.f30109c.append(',');
            k();
        } else if (a2 != 4) {
            if (a2 != 6) {
                if (a2 == 7) {
                    if (!this.f30114h) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            b(7);
        } else {
            this.f30109c.append((CharSequence) this.f30113g);
            b(5);
        }
    }

    public final void b(boolean z) {
        this.f30114h = z;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f30112f = null;
            this.f30113g = ":";
            return;
        }
        this.f30112f = str;
        this.f30113g = ": ";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f30109c.close();
        int i = this.f30111e;
        if (i <= 1 && (i != 1 || this.f30110d[i - 1] == 7)) {
            this.f30111e = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public c e() throws IOException {
        return a(3, 5, '}');
    }

    public c f() throws IOException {
        if (this.j != null) {
            if (this.k) {
                j();
            } else {
                this.j = null;
                return this;
            }
        }
        m();
        this.f30109c.write(StringUtil.NULL_STRING);
        return this;
    }

    public void flush() throws IOException {
        if (this.f30111e != 0) {
            this.f30109c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public boolean g() {
        return this.f30114h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.k;
    }

    public c b() throws IOException {
        j();
        return a(1, '[');
    }

    public c d() throws IOException {
        j();
        return a(3, '{');
    }

    private c a(int i, int i2, char c2) throws IOException {
        int a2 = a();
        if (a2 != i2 && a2 != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j == null) {
            this.f30111e--;
            if (a2 == i2) {
                k();
            }
            this.f30109c.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.j);
    }

    private void b(int i) {
        this.f30110d[this.f30111e - 1] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.i ? f30108b : f30107a;
        this.f30109c.write(34);
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.f30109c.write(str, i2, i - i2);
                }
                this.f30109c.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.f30109c.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.f30109c.write(str, i2, length - i2);
        }
        this.f30109c.write(34);
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        j();
        m();
        d(str);
        return this;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public c c() throws IOException {
        return a(1, 2, ']');
    }

    private void a(int i) {
        int i2 = this.f30111e;
        int[] iArr = this.f30110d;
        if (i2 == iArr.length) {
            this.f30110d = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f30110d;
        int i3 = this.f30111e;
        this.f30111e = i3 + 1;
        iArr2[i3] = i;
    }

    private int a() {
        int i = this.f30111e;
        if (i != 0) {
            return this.f30110d[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c a(String str) throws IOException {
        if (str != null) {
            if (this.j == null) {
                if (this.f30111e != 0) {
                    this.j = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public c a(boolean z) throws IOException {
        j();
        m();
        this.f30109c.write(z ? "true" : "false");
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        j();
        m();
        this.f30109c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c a(long j) throws IOException {
        j();
        m();
        this.f30109c.write(Long.toString(j));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        String obj = number.toString();
        if (!this.f30114h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals(WalletPayViewController.DEF_CHANNEL_TITLE))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        m();
        this.f30109c.append((CharSequence) obj);
        return this;
    }
}
