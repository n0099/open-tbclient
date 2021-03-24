package d.b.i0.c3.j0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.wallet.router.RouterCallback;
import d.b.b.e.p.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.n.a f53452a;

    /* renamed from: b  reason: collision with root package name */
    public String f53453b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53454c = false;

    public b(String str) {
        e(str, false);
    }

    public void a() {
        e c2;
        if (this.f53452a == null || (c2 = c()) == null || c2.f53465f == null) {
            return;
        }
        long e2 = this.f53452a.e();
        if (e2 > 3000) {
            d dVar = c2.f53465f;
            dVar.f53456a += e2;
            dVar.f53457b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e c2;
        if (this.f53452a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f53463d;
            if (dVar == null) {
                return;
            }
            dVar.f53457b++;
            if (z2) {
                dVar.f53456a += j2;
                dVar.f53459d += j;
            } else {
                dVar.f53458c++;
            }
        } else {
            d dVar2 = c2.f53464e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f53457b++;
            if (z2) {
                dVar2.f53456a += j3;
                dVar2.f53459d += j;
            } else {
                dVar2.f53458c++;
            }
            j2 = j3;
        }
        this.f53452a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f53453b == "frsStat") {
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
        return c.e(this.f53453b, d(), this.f53454c);
    }

    public final String d() {
        int I = j.I();
        return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? g.f3873b : I == 2 ? "2G" : "N";
    }

    public void e(String str, boolean z) {
        this.f53453b = str;
        this.f53454c = z;
        this.f53452a = new d.b.b.e.n.a("dbg");
        c.c(str, d(), z);
    }

    public void f() {
        this.f53452a.g();
    }
}
