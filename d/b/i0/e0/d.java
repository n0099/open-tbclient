package d.b.i0.e0;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f54221a;

    public static final d c() {
        if (f54221a == null) {
            synchronized (d.class) {
                if (f54221a == null) {
                    f54221a = new d();
                }
            }
        }
        return f54221a;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
        statsItem.b("workflow", "dnsproxy_error");
        if (!TextUtils.isEmpty(str)) {
            statsItem.b("reason", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            statsItem.b("comment", str2);
        }
        BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
    }

    public void b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
        statsItem.b("workflow", "dnsproxy_event");
        if (!TextUtils.isEmpty(str)) {
            statsItem.b("key", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            statsItem.b("reason", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            statsItem.b("comment", str3);
        }
        BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
    }
}
