package d.a.m0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class e extends m {
    @Override // d.a.m0.m0.m
    public void b(h hVar) {
        int i2;
        if (k.d().g()) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "time_t");
            f(a2, hVar);
            a2.b("ishttp", hVar.s ? "1" : "0");
            a2.b("issuccess", hVar.f53214b ? "1" : "0");
            a2.b("nettype", k.d().f());
            a2.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.f53217e));
            a2.b("wt", String.valueOf(hVar.p));
            a2.b("qt", String.valueOf(hVar.f53218f));
            a2.b("connt", String.valueOf(hVar.f53219g));
            a2.b("rwt", String.valueOf(hVar.f53220h));
            a2.b("dect", String.valueOf(hVar.k));
            a2.b("parset", String.valueOf(hVar.l));
            a2.b("rendert", String.valueOf(hVar.o));
            a2.b("ss", String.valueOf(hVar.q));
            a2.b("hs", String.valueOf(hVar.r));
            if (hVar.s && (i2 = hVar.t) != 0) {
                a2.b("salno", String.valueOf(i2));
                long j = hVar.u;
                if (j != 0) {
                    a2.b("scosttime", String.valueOf(j));
                }
            }
            int i3 = hVar.v;
            if (i3 != 0) {
                a2.c("errcode", Integer.valueOf(i3));
            }
            if (hVar.s) {
                a2.b("c_logid", String.valueOf(hVar.A));
            } else {
                a2.b("seq_id", String.valueOf(hVar.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.f53234a, a2);
        }
    }

    @Override // d.a.m0.m0.m
    public void c(h hVar, int i2) {
        if (k.d().g() && hVar.D > 0) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("action", "time_t");
            f(a2, hVar);
            a2.b("pct", String.valueOf(hVar.D));
            if (i2 == 0) {
                a2.b("pct_type", String.valueOf(100));
            } else if (i2 != 40) {
                return;
            } else {
                a2.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.f53234a, a2);
        }
    }

    @Override // d.a.m0.m0.m
    public void d(h hVar, boolean z) {
        int i2;
        if (k.d().g()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    d.a.c.e.n.a a2 = j.a();
                    a2.b("action", "time_t");
                    f(a2, hVar);
                    if (z) {
                        a2.b("put", String.valueOf(hVar.B));
                    } else {
                        a2.b("pdt", String.valueOf(hVar.C));
                    }
                    a2.b("ishttp", hVar.s ? "1" : "0");
                    a2.b("issuccess", hVar.f53214b ? "1" : "0");
                    a2.b("nettype", k.d().f());
                    a2.b("qt", String.valueOf(hVar.f53218f));
                    a2.b("connt", String.valueOf(hVar.f53219g));
                    a2.b("rwt", String.valueOf(hVar.f53220h));
                    a2.b("dect", String.valueOf(hVar.k));
                    a2.b("parset", String.valueOf(hVar.l));
                    a2.b("rendert", String.valueOf(hVar.o));
                    a2.b("ss", String.valueOf(hVar.q));
                    a2.b("hs", String.valueOf(hVar.r));
                    if (hVar.s && (i2 = hVar.t) != 0) {
                        a2.b("salno", String.valueOf(i2));
                        long j = hVar.u;
                        if (j != 0) {
                            a2.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i3 = hVar.v;
                    if (i3 != 0) {
                        a2.c("errcode", Integer.valueOf(i3));
                    }
                    BdStatisticsManager.getInstance().performance(this.f53234a, a2);
                }
            }
        }
    }

    public final void f(d.a.c.e.n.a aVar, h hVar) {
        if (hVar instanceof d) {
            aVar.c("ptype", Integer.valueOf(((d) hVar).F));
        }
    }
}
