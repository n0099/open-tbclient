package d.r.b.a.a.m;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.StatisticsReport;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.m.c.a.d.a;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.m.c.a.b f68098a;

    public a(d.r.b.a.a.m.c.a.b bVar) {
        this.f68098a = bVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        a.C1904a c1904a = new a.C1904a();
        c1904a.b(this.f68098a);
        c1904a.d(str);
        c1904a.c(str2);
        c1904a.e(str3);
        c1904a.f(str4);
        c1904a.j(str5);
        c1904a.i(str6);
        c1904a.g(str7);
        c1904a.h(str8);
        String k = c1904a.a().k();
        d.b("PayEventReporter", "report event:" + str + " content:" + k);
        StatisticsReport.f38309e.a().c(k);
    }
}
