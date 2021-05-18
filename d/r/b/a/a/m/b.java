package d.r.b.a.a.m;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.StatisticsReport;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.m.c.a.e.a;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.m.c.a.b f68099a;

    public b(d.r.b.a.a.m.c.a.b bVar) {
        this.f68099a = bVar;
    }

    public void a(String str) {
        a.C1905a c1905a = new a.C1905a();
        c1905a.b(this.f68099a);
        c1905a.d(str);
        String e2 = c1905a.a().e();
        d.b("UiEventReporter", "report event:" + str + " content:" + e2);
        StatisticsReport.f38309e.a().c(e2);
    }

    public void b(String str, String str2) {
        a.C1905a c1905a = new a.C1905a();
        c1905a.b(this.f68099a);
        c1905a.d(str);
        c1905a.c(str2);
        String e2 = c1905a.a().e();
        d.b("UiEventReporter", "report event:" + str + " content:" + e2 + " amount:" + str2);
        StatisticsReport.f38309e.a().c(e2);
    }
}
