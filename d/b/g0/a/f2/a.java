package d.b.g0.a.f2;

import com.tencent.connect.common.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f44450a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f44451b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f44452c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f44453d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f44454e = "";

    /* renamed from: f  reason: collision with root package name */
    public final StringBuilder f44455f = new StringBuilder();

    /* renamed from: g  reason: collision with root package name */
    public boolean f44456g = false;

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
        this.f44453d = str;
        return this;
    }

    public String d() {
        return this.f44453d;
    }

    public a e(String str) {
        StringBuilder sb = this.f44455f;
        sb.append(str);
        sb.append("\n");
        return this;
    }

    public StringBuilder f() {
        return this.f44455f;
    }

    public long g() {
        return this.f44451b;
    }

    public a h(long j) {
        this.f44451b = l(j, 9999L, "error");
        return this;
    }

    public long i() {
        return this.f44450a;
    }

    public a j(long j) {
        this.f44450a = l(j, 999L, "feature");
        return this;
    }

    public boolean k() {
        return this.f44456g;
    }

    public final long l(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            e("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }

    public void m() {
        this.f44456g = true;
    }

    public long n() {
        return this.f44452c;
    }

    public a o(long j) {
        this.f44452c = l(j, 9L, Constants.PARAM_PLATFORM);
        return this;
    }

    public a p(String str) {
        if (str == null) {
            str = "";
        }
        this.f44454e = str;
        return this;
    }

    public String q() {
        return this.f44454e;
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
