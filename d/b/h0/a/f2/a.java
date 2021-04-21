package d.b.h0.a.f2;

import com.tencent.connect.common.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f45171a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f45172b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f45173c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f45174d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f45175e = "";

    /* renamed from: f  reason: collision with root package name */
    public final StringBuilder f45176f = new StringBuilder();

    /* renamed from: g  reason: collision with root package name */
    public boolean f45177g = false;

    public long a() {
        return (n() * 10000000) + (i() * 10000) + (g() * 1);
    }

    public a b(long j) {
        o(j / 10000000);
        long j2 = j % 10000000;
        j(j2 / 10000);
        h((j2 % 10000) / 1);
        return this;
    }

    public a c(String str) {
        if (str == null) {
            str = "";
        }
        this.f45174d = str;
        return this;
    }

    public String d() {
        return this.f45174d;
    }

    public a e(String str) {
        StringBuilder sb = this.f45176f;
        sb.append(str);
        sb.append("\n");
        return this;
    }

    public StringBuilder f() {
        return this.f45176f;
    }

    public long g() {
        return this.f45172b;
    }

    public a h(long j) {
        this.f45172b = l(j, 9999L, "error");
        return this;
    }

    public long i() {
        return this.f45171a;
    }

    public a j(long j) {
        this.f45171a = l(j, 999L, "feature");
        return this;
    }

    public boolean k() {
        return this.f45177g;
    }

    public final long l(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            e("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }

    public void m() {
        this.f45177g = true;
    }

    public long n() {
        return this.f45173c;
    }

    public a o(long j) {
        this.f45173c = l(j, 9L, Constants.PARAM_PLATFORM);
        return this;
    }

    public a p(String str) {
        if (str == null) {
            str = "";
        }
        this.f45175e = str;
        return this;
    }

    public String q() {
        return this.f45175e;
    }

    public String r(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(a()), Long.valueOf(n()), Long.valueOf(i()), Long.valueOf(g()), d()));
        if (i >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(n()), Long.valueOf(i()), Long.valueOf(g())));
        }
        if (i >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", f()));
        }
        return sb.toString();
    }

    public String toString() {
        return r(-100);
    }
}
