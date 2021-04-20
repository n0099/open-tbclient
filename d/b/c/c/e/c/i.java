package d.b.c.c.e.c;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.internal.ETAG;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    public static void a(String str, int i, int i2, String str2, int i3, String str3) {
        b(str, i, -1L, i2, str2, i3, str3);
    }

    public static void b(String str, int i, long j, int i2, String str2, int i3, String str3) {
        StringBuilder sb = new StringBuilder(50);
        if (i != 0 && i2 != 0) {
            sb.append("cmd = ");
            sb.append(i);
            sb.append(TrackUI.SEPERATOR);
            sb.append("sequence = ");
            sb.append(i2);
            sb.append(TrackUI.SEPERATOR);
        }
        sb.append(str3);
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add("lib");
            linkedList.add(str);
            if (i != 0) {
                linkedList.add("cmd");
                linkedList.add(Integer.valueOf(i));
            }
            if (!TextUtils.isEmpty(str2)) {
                linkedList.add("act");
                linkedList.add(str2);
            }
            if (i3 != 0) {
                linkedList.add("result");
                linkedList.add(Integer.valueOf(i3));
            }
            if (!TextUtils.isEmpty(str3)) {
                linkedList.add("comment");
                linkedList.add(str3);
            }
            BdStatisticsManager.getInstance().newDebug("socket", j, i2 == 0 ? null : String.valueOf(i2 & 4294967295L), linkedList.toArray());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void c(String str, Message<?> message, int i, String str2, int i2, String str3) {
        long j;
        int i3;
        if (message != null) {
            i3 = message.getCmd();
            j = message.getClientLogID();
        } else {
            j = 0;
            i3 = 0;
        }
        b(str, i3, j, i, str2, i2, str3);
    }

    public static void d() {
        try {
            BdStatisticsManager.getInstance().debug("socket", "url", d.b.c.e.r.h.j().q(), "dns_cost", Long.valueOf(d.b.c.e.r.h.j().h()), TiebaStatic.CON_COST, Long.valueOf(d.b.c.e.r.h.j().g()), "remote_ip", d.b.c.e.r.h.j().o(), ETAG.KEY_LOCAL_DNS, d.b.c.e.r.h.j().m(), "local_dns_bak", d.b.c.e.r.h.j().n(), "net", BdStatisticsManager.getInstance().getCurNetworkType());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void e() {
        try {
            d.b.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imconn");
            statsItem.b(TiebaStatic.CON_COST, String.valueOf(d.b.c.e.r.h.j().g()));
            statsItem.b("nettype", d.b.c.e.n.d.a(BdBaseApplication.getInst()));
            BdStatisticsManager.getInstance().performance("im", statsItem);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
