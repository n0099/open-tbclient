package d.b.h0.m0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class m extends j {
    public void b(h hVar) {
        int i;
        if (k.d().g()) {
            d.b.b.e.n.a a2 = j.a();
            a2.b("action", "time");
            a2.b("ishttp", hVar.s ? "1" : "0");
            a2.b("issuccess", hVar.f50321b ? "1" : "0");
            a2.b("nettype", k.d().f());
            a2.b("wt", String.valueOf(hVar.p));
            a2.b("qt", String.valueOf(hVar.f50325f));
            a2.b("connt", String.valueOf(hVar.f50326g));
            a2.b("rwt", String.valueOf(hVar.f50327h));
            a2.b("fbt", String.valueOf(hVar.i));
            a2.b("abt", String.valueOf(hVar.j));
            a2.b("dect", String.valueOf(hVar.k));
            a2.b("parset", String.valueOf(hVar.l));
            a2.b("tqt", String.valueOf(hVar.n));
            a2.b("rendert", String.valueOf(hVar.o));
            a2.b("ss", String.valueOf(hVar.q));
            a2.b("hs", String.valueOf(hVar.r));
            if (hVar.s && (i = hVar.t) != 0) {
                a2.b("salno", String.valueOf(i));
                long j = hVar.u;
                if (j != 0) {
                    a2.b("scosttime", String.valueOf(j));
                }
            }
            if (hVar.s) {
                a2.b("hrtn", String.valueOf(hVar.w));
                a2.b("hrtt", String.valueOf(hVar.x));
            }
            int i2 = hVar.v;
            if (i2 != 0) {
                a2.c("errcode", Integer.valueOf(i2));
            }
            if (hVar.y) {
                a2.b(Config.PLATFORM_TYPE, "1");
            } else {
                a2.b("sysct", String.valueOf(hVar.f50322c));
                a2.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.f50324e));
                a2.b("lt", String.valueOf(hVar.f50323d));
                a2.b("df", String.valueOf(hVar.m));
            }
            if (hVar.s) {
                a2.b("c_logid", String.valueOf(hVar.A));
                long j2 = hVar.z;
                if (j2 != 0) {
                    a2.b("seq_id", String.valueOf(4294967295L & j2));
                }
            } else {
                a2.b("seq_id", String.valueOf(4294967295L & hVar.z));
            }
            HashMap<String, String> hashMap = hVar.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hVar.E.entrySet()) {
                    a2.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.f50340a, a2);
        }
    }

    public void c(h hVar, int i) {
        if (k.d().g() && hVar.D > 0) {
            d.b.b.e.n.a a2 = j.a();
            a2.b("action", "time");
            a2.b("pct", String.valueOf(hVar.D));
            if (i == 0) {
                a2.b("pct_type", String.valueOf(100));
            } else if (i != 40) {
                return;
            } else {
                a2.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.f50340a, a2);
        }
    }

    public void d(h hVar, boolean z) {
        int i;
        if (k.d().g()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    d.b.b.e.n.a a2 = j.a();
                    a2.b("action", "time");
                    if (z) {
                        a2.b("put", String.valueOf(hVar.B));
                    } else {
                        a2.b("pdt", String.valueOf(hVar.C));
                    }
                    a2.b("ishttp", hVar.s ? "1" : "0");
                    a2.b("issuccess", hVar.f50321b ? "1" : "0");
                    a2.b("nettype", k.d().f());
                    a2.b("qt", String.valueOf(hVar.f50325f));
                    a2.b("connt", String.valueOf(hVar.f50326g));
                    a2.b("rwt", String.valueOf(hVar.f50327h));
                    a2.b("dect", String.valueOf(hVar.k));
                    a2.b("parset", String.valueOf(hVar.l));
                    a2.b("rendert", String.valueOf(hVar.o));
                    a2.b("ss", String.valueOf(hVar.q));
                    a2.b("hs", String.valueOf(hVar.r));
                    if (hVar.s && (i = hVar.t) != 0) {
                        a2.b("salno", String.valueOf(i));
                        long j = hVar.u;
                        if (j != 0) {
                            a2.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = hVar.v;
                    if (i2 != 0) {
                        a2.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.f50340a, a2);
                }
            }
        }
    }

    public void e(b bVar) {
        if (bVar != null && k.d().g()) {
            d.b.b.e.n.a a2 = j.a();
            a2.b("action", "fluency");
            a2.b("fps", String.valueOf(bVar.b()));
            BdStatisticsManager.getInstance().performance(this.f50340a, a2);
            d.b.b.e.n.a a3 = j.a();
            a3.b("action", "mem");
            a3.b("memp", String.valueOf(k.d().c()));
            BdStatisticsManager.getInstance().performance(this.f50340a, a3);
        }
    }
}
