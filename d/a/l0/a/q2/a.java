package d.a.l0.a.q2;

import com.tencent.connect.common.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f47892a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f47893b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f47894c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f47895d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f47896e = "";

    /* renamed from: f  reason: collision with root package name */
    public final StringBuilder f47897f = new StringBuilder();

    /* renamed from: g  reason: collision with root package name */
    public boolean f47898g = false;

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
        this.f47895d = str;
        return this;
    }

    public String d() {
        return this.f47895d;
    }

    public a e(String str) {
        StringBuilder sb = this.f47897f;
        sb.append(str);
        sb.append("\n");
        return this;
    }

    public StringBuilder f() {
        return this.f47897f;
    }

    public long g() {
        return this.f47893b;
    }

    public a h(long j) {
        this.f47893b = l(j, 9999L, "error");
        return this;
    }

    public long i() {
        return this.f47892a;
    }

    public a j(long j) {
        this.f47892a = l(j, 999L, "feature");
        return this;
    }

    public boolean k() {
        return this.f47898g;
    }

    public final long l(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            e("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }

    public void m() {
        this.f47898g = true;
    }

    public long n() {
        return this.f47894c;
    }

    public a o(long j) {
        this.f47894c = l(j, 9L, Constants.PARAM_PLATFORM);
        return this;
    }

    public a p(String str) {
        if (str == null) {
            str = "";
        }
        this.f47896e = str;
        return this;
    }

    public String q() {
        return this.f47896e;
    }

    public String r(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(a()), Long.valueOf(n()), Long.valueOf(i()), Long.valueOf(g()), d()));
        if (i2 >= -200) {
            sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(n()), Long.valueOf(i()), Long.valueOf(g())));
        }
        if (i2 >= -100) {
            sb.append(String.format(Locale.getDefault(), "  details(%s) \n", f()));
        }
        return sb.toString();
    }

    public String toString() {
        return r(-100);
    }
}
