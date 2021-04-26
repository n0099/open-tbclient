package d.a.h0.a.f2;

import com.tencent.connect.common.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f42482a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f42483b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f42484c = 2;

    /* renamed from: d  reason: collision with root package name */
    public String f42485d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f42486e = "";

    /* renamed from: f  reason: collision with root package name */
    public final StringBuilder f42487f = new StringBuilder();

    /* renamed from: g  reason: collision with root package name */
    public boolean f42488g = false;

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
        this.f42485d = str;
        return this;
    }

    public String d() {
        return this.f42485d;
    }

    public a e(String str) {
        StringBuilder sb = this.f42487f;
        sb.append(str);
        sb.append("\n");
        return this;
    }

    public StringBuilder f() {
        return this.f42487f;
    }

    public long g() {
        return this.f42483b;
    }

    public a h(long j) {
        this.f42483b = l(j, 9999L, "error");
        return this;
    }

    public long i() {
        return this.f42482a;
    }

    public a j(long j) {
        this.f42482a = l(j, 999L, "feature");
        return this;
    }

    public boolean k() {
        return this.f42488g;
    }

    public final long l(long j, long j2, String str) {
        boolean z = j < 0 || j > j2;
        if (z) {
            e("illegalFallback " + str + "::" + j);
        }
        return z ? j2 : j;
    }

    public void m() {
        this.f42488g = true;
    }

    public long n() {
        return this.f42484c;
    }

    public a o(long j) {
        this.f42484c = l(j, 9L, Constants.PARAM_PLATFORM);
        return this;
    }

    public a p(String str) {
        if (str == null) {
            str = "";
        }
        this.f42486e = str;
        return this;
    }

    public String q() {
        return this.f42486e;
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
