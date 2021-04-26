package d.r.b.a.a.m;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.StatisticsReport;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.m.c.a.d.a;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.m.c.a.b f67412a;

    public a(d.r.b.a.a.m.c.a.b bVar) {
        this.f67412a = bVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        a.C1840a c1840a = new a.C1840a();
        c1840a.b(this.f67412a);
        c1840a.d(str);
        c1840a.c(str2);
        c1840a.e(str3);
        c1840a.f(str4);
        c1840a.j(str5);
        c1840a.i(str6);
        c1840a.g(str7);
        c1840a.h(str8);
        String k = c1840a.a().k();
        d.b("PayEventReporter", "report event:" + str + " content:" + k);
        StatisticsReport.f39064e.a().c(k);
    }
}
