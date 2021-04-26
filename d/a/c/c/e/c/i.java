package d.a.c.c.e.c;

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
    public static void a(String str, int i2, int i3, String str2, int i4, String str3) {
        b(str, i2, -1L, i3, str2, i4, str3);
    }

    public static void b(String str, int i2, long j, int i3, String str2, int i4, String str3) {
        StringBuilder sb = new StringBuilder(50);
        if (i2 != 0 && i3 != 0) {
            sb.append("cmd = ");
            sb.append(i2);
            sb.append(TrackUI.SEPERATOR);
            sb.append("sequence = ");
            sb.append(i3);
            sb.append(TrackUI.SEPERATOR);
        }
        sb.append(str3);
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add("lib");
            linkedList.add(str);
            if (i2 != 0) {
                linkedList.add("cmd");
                linkedList.add(Integer.valueOf(i2));
            }
            if (!TextUtils.isEmpty(str2)) {
                linkedList.add("act");
                linkedList.add(str2);
            }
            if (i4 != 0) {
                linkedList.add("result");
                linkedList.add(Integer.valueOf(i4));
            }
            if (!TextUtils.isEmpty(str3)) {
                linkedList.add("comment");
                linkedList.add(str3);
            }
            BdStatisticsManager.getInstance().newDebug("socket", j, i3 == 0 ? null : String.valueOf(i3 & 4294967295L), linkedList.toArray());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void c(String str, Message<?> message, int i2, String str2, int i3, String str3) {
        long j;
        int i4;
        if (message != null) {
            i4 = message.getCmd();
            j = message.getClientLogID();
        } else {
            j = 0;
            i4 = 0;
        }
        b(str, i4, j, i2, str2, i3, str3);
    }

    public static void d() {
        try {
            BdStatisticsManager.getInstance().debug("socket", "url", d.a.c.e.r.h.j().q(), "dns_cost", Long.valueOf(d.a.c.e.r.h.j().h()), TiebaStatic.CON_COST, Long.valueOf(d.a.c.e.r.h.j().g()), "remote_ip", d.a.c.e.r.h.j().o(), ETAG.KEY_LOCAL_DNS, d.a.c.e.r.h.j().m(), "local_dns_bak", d.a.c.e.r.h.j().n(), "net", BdStatisticsManager.getInstance().getCurNetworkType());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void e() {
        try {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "imconn");
            statsItem.b(TiebaStatic.CON_COST, String.valueOf(d.a.c.e.r.h.j().g()));
            statsItem.b("nettype", d.a.c.e.n.d.a(BdBaseApplication.getInst()));
            BdStatisticsManager.getInstance().performance("im", statsItem);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
