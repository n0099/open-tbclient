package d.b.i0.c3.j0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.wallet.router.RouterCallback;
import d.b.b.e.p.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.n.a f53453a;

    /* renamed from: b  reason: collision with root package name */
    public String f53454b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53455c = false;

    public b(String str) {
        e(str, false);
    }

    public void a() {
        e c2;
        if (this.f53453a == null || (c2 = c()) == null || c2.f53466f == null) {
            return;
        }
        long e2 = this.f53453a.e();
        if (e2 > 3000) {
            d dVar = c2.f53466f;
            dVar.f53457a += e2;
            dVar.f53458b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e c2;
        if (this.f53453a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f53464d;
            if (dVar == null) {
                return;
            }
            dVar.f53458b++;
            if (z2) {
                dVar.f53457a += j2;
                dVar.f53460d += j;
            } else {
                dVar.f53459c++;
            }
        } else {
            d dVar2 = c2.f53465e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f53458b++;
            if (z2) {
                dVar2.f53457a += j3;
                dVar2.f53460d += j;
            } else {
                dVar2.f53459c++;
            }
            j2 = j3;
        }
        this.f53453a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f53454b == "frsStat") {
            if (!z2 || j2 > 3000) {
                d.b.b.e.n.a aVar = new d.b.b.e.n.a("dbg");
                aVar.b("act", "frs");
                aVar.b("result", z2 ? "0" : "1");
                aVar.b("isHttp", z ? "1" : "0");
                aVar.b("timeCost", String.valueOf(j2));
                aVar.b(RouterCallback.KEY_ERROR_CODE, String.valueOf(i));
                aVar.b("errMsg", str);
                aVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", aVar);
            }
        }
    }

    public final e c() {
        return c.e(this.f53454b, d(), this.f53455c);
    }

    public final String d() {
        int I = j.I();
        return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? g.f3874b : I == 2 ? "2G" : "N";
    }

    public void e(String str, boolean z) {
        this.f53454b = str;
        this.f53455c = z;
        this.f53453a = new d.b.b.e.n.a("dbg");
        c.c(str, d(), z);
    }

    public void f() {
        this.f53453a.g();
    }
}
