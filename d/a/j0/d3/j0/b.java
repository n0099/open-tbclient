package d.a.j0.d3.j0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.wallet.router.RouterCallback;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.n.a f53157a;

    /* renamed from: b  reason: collision with root package name */
    public String f53158b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53159c = false;

    public b(String str) {
        e(str, false);
    }

    public void a() {
        e c2;
        if (this.f53157a == null || (c2 = c()) == null || c2.f53170f == null) {
            return;
        }
        long e2 = this.f53157a.e();
        if (e2 > 3000) {
            d dVar = c2.f53170f;
            dVar.f53161a += e2;
            dVar.f53162b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i2, String str, long j, long j2, long j3) {
        e c2;
        if (this.f53157a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f53168d;
            if (dVar == null) {
                return;
            }
            dVar.f53162b++;
            if (z2) {
                dVar.f53161a += j2;
                dVar.f53164d += j;
            } else {
                dVar.f53163c++;
            }
        } else {
            d dVar2 = c2.f53169e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f53162b++;
            if (z2) {
                dVar2.f53161a += j3;
                dVar2.f53164d += j;
            } else {
                dVar2.f53163c++;
            }
            j2 = j3;
        }
        this.f53157a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f53158b == "frsStat") {
            if (!z2 || j2 > 3000) {
                d.a.c.e.n.a aVar = new d.a.c.e.n.a("dbg");
                aVar.b("act", "frs");
                aVar.b("result", z2 ? "0" : "1");
                aVar.b("isHttp", z ? "1" : "0");
                aVar.b("timeCost", String.valueOf(j2));
                aVar.b(RouterCallback.KEY_ERROR_CODE, String.valueOf(i2));
                aVar.b("errMsg", str);
                aVar.b("down", String.valueOf(j));
                BdStatisticsManager.getInstance().debug("frs", aVar);
            }
        }
    }

    public final e c() {
        return c.e(this.f53158b, d(), this.f53159c);
    }

    public final String d() {
        int I = j.I();
        return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? g.f3962b : I == 2 ? "2G" : "N";
    }

    public void e(String str, boolean z) {
        this.f53158b = str;
        this.f53159c = z;
        this.f53157a = new d.a.c.e.n.a("dbg");
        c.c(str, d(), z);
    }

    public void f() {
        this.f53157a.g();
    }
}
