package d.b.b.e.n.j;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import d.b.b.e.p.j;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, int i, String str2, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, int i2) {
        if (BdBaseApplication.getInst().isSmallFlow()) {
            d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "network_monitor_a");
            statsItem.b("cmd", String.valueOf(i));
            statsItem.b("url", str2);
            statsItem.b("issuccess", z ? "1" : "0");
            statsItem.b("ishttp", z2 ? "1" : "0");
            statsItem.b("nettype", j.m());
            statsItem.b("connt", String.valueOf(j));
            statsItem.b("rwt", String.valueOf(j2));
            statsItem.b("parset", String.valueOf(j3));
            statsItem.b("fbt", String.valueOf(j4));
            statsItem.b("abt", String.valueOf(j5));
            statsItem.b("salno", String.valueOf(i2));
            BdStatisticsManager.getInstance().performance(str, statsItem);
        }
    }
}
