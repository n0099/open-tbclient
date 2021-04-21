package d.b.j0.d3.j0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.wallet.router.RouterCallback;
import d.b.c.e.p.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.e.n.a f55318a;

    /* renamed from: b  reason: collision with root package name */
    public String f55319b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55320c = false;

    public b(String str) {
        e(str, false);
    }

    public void a() {
        e c2;
        if (this.f55318a == null || (c2 = c()) == null || c2.f55331f == null) {
            return;
        }
        long e2 = this.f55318a.e();
        if (e2 > 3000) {
            d dVar = c2.f55331f;
            dVar.f55322a += e2;
            dVar.f55323b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e c2;
        if (this.f55318a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f55329d;
            if (dVar == null) {
                return;
            }
            dVar.f55323b++;
            if (z2) {
                dVar.f55322a += j2;
                dVar.f55325d += j;
            } else {
                dVar.f55324c++;
            }
        } else {
            d dVar2 = c2.f55330e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f55323b++;
            if (z2) {
                dVar2.f55322a += j3;
                dVar2.f55325d += j;
            } else {
                dVar2.f55324c++;
            }
            j2 = j3;
        }
        this.f55318a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f55319b == "frsStat") {
            if (!z2 || j2 > 3000) {
                d.b.c.e.n.a aVar = new d.b.c.e.n.a("dbg");
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
        return c.e(this.f55319b, d(), this.f55320c);
    }

    public final String d() {
        int I = j.I();
        return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? g.f3909b : I == 2 ? "2G" : "N";
    }

    public void e(String str, boolean z) {
        this.f55319b = str;
        this.f55320c = z;
        this.f55318a = new d.b.c.e.n.a("dbg");
        c.c(str, d(), z);
    }

    public void f() {
        this.f55318a.g();
    }
}
