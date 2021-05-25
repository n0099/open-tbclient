package d.r.b.a.a.m;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.StatisticsReport;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.m.c.a.d.a;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.m.c.a.b f68141a;

    public a(d.r.b.a.a.m.c.a.b bVar) {
        this.f68141a = bVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        a.C1908a c1908a = new a.C1908a();
        c1908a.b(this.f68141a);
        c1908a.d(str);
        c1908a.c(str2);
        c1908a.e(str3);
        c1908a.f(str4);
        c1908a.j(str5);
        c1908a.i(str6);
        c1908a.g(str7);
        c1908a.h(str8);
        String k = c1908a.a().k();
        d.b("PayEventReporter", "report event:" + str + " content:" + k);
        StatisticsReport.f38238e.a().c(k);
    }
}
