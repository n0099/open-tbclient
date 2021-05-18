package d.a.k0.d3.j0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.wallet.router.RouterCallback;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.n.a f53864a;

    /* renamed from: b  reason: collision with root package name */
    public String f53865b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53866c = false;

    public b(String str) {
        e(str, false);
    }

    public void a() {
        e c2;
        if (this.f53864a == null || (c2 = c()) == null || c2.f53877f == null) {
            return;
        }
        long e2 = this.f53864a.e();
        if (e2 > 3000) {
            d dVar = c2.f53877f;
            dVar.f53868a += e2;
            dVar.f53869b++;
            c.b(c2, 10);
        }
    }

    public void b(boolean z, boolean z2, int i2, String str, long j, long j2, long j3) {
        e c2;
        if (this.f53864a == null || (c2 = c()) == null) {
            return;
        }
        if (z) {
            d dVar = c2.f53875d;
            if (dVar == null) {
                return;
            }
            dVar.f53869b++;
            if (z2) {
                dVar.f53868a += j2;
                dVar.f53871d += j;
            } else {
                dVar.f53870c++;
            }
        } else {
            d dVar2 = c2.f53876e;
            if (dVar2 == null) {
                return;
            }
            dVar2.f53869b++;
            if (z2) {
                dVar2.f53868a += j3;
                dVar2.f53871d += j;
            } else {
                dVar2.f53870c++;
            }
            j2 = j3;
        }
        this.f53864a = null;
        if (z2) {
            c.b(c2, 10);
        }
        if (this.f53865b == "frsStat") {
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
        return c.e(this.f53865b, d(), this.f53866c);
    }

    public final String d() {
        int I = j.I();
        return I == 0 ? "N" : I == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : I == 3 ? g.f3963b : I == 2 ? "2G" : "N";
    }

    public void e(String str, boolean z) {
        this.f53865b = str;
        this.f53866c = z;
        this.f53864a = new d.a.c.e.n.a("dbg");
        c.c(str, d(), z);
    }

    public void f() {
        this.f53864a.g();
    }
}
