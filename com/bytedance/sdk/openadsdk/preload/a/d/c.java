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
    public static final String[] f29987a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f29988b;

    /* renamed from: c  reason: collision with root package name */
    public final Writer f29989c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f29990d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    public int f29991e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f29992f;

    /* renamed from: g  reason: collision with root package name */
    public String f29993g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29994h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29995i;
    public String j;
    public boolean k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f29987a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f29987a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f29988b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.f29993g = ":";
        this.k = true;
        if (writer != null) {
            this.f29989c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private c a(int i2, char c2) throws IOException {
        m();
        a(i2);
        this.f29989c.write(c2);
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
        if (this.f29992f == null) {
            return;
        }
        this.f29989c.write(10);
        int i2 = this.f29991e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f29989c.write(this.f29992f);
        }
    }

    private void l() throws IOException {
        int a2 = a();
        if (a2 == 5) {
            this.f29989c.write(44);
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
            this.f29989c.append(',');
            k();
        } else if (a2 != 4) {
            if (a2 != 6) {
                if (a2 == 7) {
                    if (!this.f29994h) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            b(7);
        } else {
            this.f29989c.append((CharSequence) this.f29993g);
            b(5);
        }
    }

    public final void b(boolean z) {
        this.f29994h = z;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f29992f = null;
            this.f29993g = ":";
            return;
        }
        this.f29992f = str;
        this.f29993g = ": ";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29989c.close();
        int i2 = this.f29991e;
        if (i2 <= 1 && (i2 != 1 || this.f29990d[i2 - 1] == 7)) {
            this.f29991e = 0;
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
        this.f29989c.write(StringUtil.NULL_STRING);
        return this;
    }

    public void flush() throws IOException {
        if (this.f29991e != 0) {
            this.f29989c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public boolean g() {
        return this.f29994h;
    }

    public final boolean h() {
        return this.f29995i;
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

    private c a(int i2, int i3, char c2) throws IOException {
        int a2 = a();
        if (a2 != i3 && a2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j == null) {
            this.f29991e--;
            if (a2 == i3) {
                k();
            }
            this.f29989c.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.j);
    }

    private void b(int i2) {
        this.f29990d[this.f29991e - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(String str) throws IOException {
        int i2;
        String str2;
        String[] strArr = this.f29995i ? f29988b : f29987a;
        this.f29989c.write(34);
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i2 = str2 == null ? i2 + 1 : 0;
                if (i3 < i2) {
                    this.f29989c.write(str, i3, i2 - i3);
                }
                this.f29989c.write(str2);
                i3 = i2 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i3 < i2) {
                }
                this.f29989c.write(str2);
                i3 = i2 + 1;
            }
        }
        if (i3 < length) {
            this.f29989c.write(str, i3, length - i3);
        }
        this.f29989c.write(34);
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
        this.f29995i = z;
    }

    public c c() throws IOException {
        return a(1, 2, ']');
    }

    private void a(int i2) {
        int i3 = this.f29991e;
        int[] iArr = this.f29990d;
        if (i3 == iArr.length) {
            this.f29990d = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f29990d;
        int i4 = this.f29991e;
        this.f29991e = i4 + 1;
        iArr2[i4] = i2;
    }

    private int a() {
        int i2 = this.f29991e;
        if (i2 != 0) {
            return this.f29990d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c a(String str) throws IOException {
        if (str != null) {
            if (this.j == null) {
                if (this.f29991e != 0) {
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
        this.f29989c.write(z ? "true" : "false");
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        j();
        m();
        this.f29989c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c a(long j) throws IOException {
        j();
        m();
        this.f29989c.write(Long.toString(j));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        String obj = number.toString();
        if (!this.f29994h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals(WalletPayViewController.DEF_CHANNEL_TITLE))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        m();
        this.f29989c.append((CharSequence) obj);
        return this;
    }
}
