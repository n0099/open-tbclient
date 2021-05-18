package d.r.b.a.a.m.c.b;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.StatisticsReport;
import d.r.b.a.a.m.c.b.c;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f68127b = "a";

    /* renamed from: a  reason: collision with root package name */
    public int f68128a = 2;

    public final boolean a(String str, String str2) {
        return b(str, str2);
    }

    public final boolean b(String str, String str2) {
        c.a a2 = c.a(str, str2);
        int i2 = a2.f68133b;
        String str3 = a2.f68134c;
        return a2.f68132a;
    }

    public final String c() {
        if (StatisticsReport.f38309e.a().d()) {
            return d();
        }
        return e();
    }

    public abstract String d();

    public abstract String e();

    public abstract boolean f(String str, String str2, int i2);

    public boolean g(String str) {
        String str2 = f68127b;
        d.r.b.a.a.m.c.d.d.d(str2, "to send content = " + str);
        return h(str);
    }

    public final boolean h(String str) {
        return f(c(), str, this.f68128a);
    }
}
