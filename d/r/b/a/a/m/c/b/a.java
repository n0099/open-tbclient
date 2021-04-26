package d.r.b.a.a.m.c.b;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.StatisticsReport;
import d.r.b.a.a.m.c.b.c;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f67441b = "a";

    /* renamed from: a  reason: collision with root package name */
    public int f67442a = 2;

    public final boolean a(String str, String str2) {
        return b(str, str2);
    }

    public final boolean b(String str, String str2) {
        c.a a2 = c.a(str, str2);
        int i2 = a2.f67447b;
        String str3 = a2.f67448c;
        return a2.f67446a;
    }

    public final String c() {
        if (StatisticsReport.f39064e.a().d()) {
            return d();
        }
        return e();
    }

    public abstract String d();

    public abstract String e();

    public abstract boolean f(String str, String str2, int i2);

    public boolean g(String str) {
        String str2 = f67441b;
        d.r.b.a.a.m.c.d.d.d(str2, "to send content = " + str);
        return h(str);
    }

    public final boolean h(String str) {
        return f(c(), str, this.f67442a);
    }
}
