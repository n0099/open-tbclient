package d.r.b.a.a.m;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.StatisticsReport;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.m.c.a.e.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.m.c.a.b f67413a;

    public b(d.r.b.a.a.m.c.a.b bVar) {
        this.f67413a = bVar;
    }

    public void a(String str) {
        a.C1841a c1841a = new a.C1841a();
        c1841a.b(this.f67413a);
        c1841a.d(str);
        String e2 = c1841a.a().e();
        d.b("UiEventReporter", "report event:" + str + " content:" + e2);
        StatisticsReport.f39064e.a().c(e2);
    }

    public void b(String str, String str2) {
        a.C1841a c1841a = new a.C1841a();
        c1841a.b(this.f67413a);
        c1841a.d(str);
        c1841a.c(str2);
        String e2 = c1841a.a().e();
        d.b("UiEventReporter", "report event:" + str + " content:" + e2 + " amount:" + str2);
        StatisticsReport.f39064e.a().c(e2);
    }
}
