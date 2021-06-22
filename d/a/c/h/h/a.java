package d.a.c.h.h;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import d.a.c.h.j.g.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f42864b;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f42865a = new HashMap<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f42864b == null) {
                synchronized (a.class) {
                    if (f42864b == null) {
                        f42864b = new a();
                    }
                }
            }
            aVar = f42864b;
        }
        return aVar;
    }

    public final void a(d.a.c.e.n.a aVar) {
        if (aVar == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : this.f42865a.entrySet()) {
            aVar.b(entry.getKey() + "_count", String.valueOf(entry.getValue()));
        }
        this.f42865a.clear();
    }

    public final d.a.c.e.n.a c() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public void d(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = d.k().h(str2);
        }
        int i2 = pluginSetting != null ? pluginSetting.install_fail_count : 0;
        j(str, null, str2, "failContent_" + i2 + "-callFrom_" + str3);
    }

    public void e(String str, String str2, PluginSetting pluginSetting, String str3) {
        if (pluginSetting == null) {
            pluginSetting = d.k().h(str2);
        }
        int i2 = pluginSetting != null ? pluginSetting.install_fail_count : 0;
        j(str, str3, str2, "failContent_" + i2);
    }

    public boolean f() {
        return BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false);
    }

    public void g(String str) {
        j(str, null, null, null);
    }

    public void h(String str, int i2) {
        j(str, null, null, "count_" + i2);
    }

    public void i(String str, String str2) {
        j(str, null, str2, null);
    }

    public final void j(String str, String str2, String str3, String str4) {
        d.a.c.e.n.a c2 = c();
        if (str != null) {
            c2.b("workflow", str);
        }
        if (str2 != null) {
            c2.b("reason", str2);
        }
        if (str3 != null) {
            c2.b("pname", str3);
        }
        if (str4 != null) {
            c2.b("comment", str4);
        }
        c2.c("pid", Integer.valueOf(Process.myPid()));
        PluginSettings l = d.k().l();
        if (l != null) {
            c2.b("pver", l.getContainerVersion());
        }
        c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(c2.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", c2);
    }

    public void k(String str, long j) {
        l(str, j, 0);
    }

    public void l(String str, long j, int i2) {
        m(str, j, i2, null);
    }

    public void m(String str, long j, int i2, String str2) {
        d.a.c.e.n.a c2 = c();
        c2.b("workflow", str + "_cost");
        c2.c("cost", Long.valueOf(j));
        if (i2 != 0) {
            c2.c("count", Integer.valueOf(i2));
        }
        if (str2 != null) {
            c2.b("pname", str2);
        }
        c2.c("pid", Integer.valueOf(Process.myPid()));
        PluginSettings l = d.k().l();
        if (l != null) {
            c2.b("pver", l.getContainerVersion());
        }
        c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", c2);
    }

    public void n(String str, long j, String str2) {
        m(str, j, 0, str2);
    }

    public void o(String str, String str2, String str3, String str4) {
        d.a.c.e.n.a c2 = c();
        if (str != null) {
            c2.b("workflow", str + "_debug");
        }
        if (str2 != null) {
            c2.b("reason", str2);
        }
        if (str3 != null) {
            c2.b("pname", str3);
        }
        if (str4 != null) {
            c2.b("comment", str4);
        }
        c2.c("pid", Integer.valueOf(Process.myPid()));
        PluginSettings l = d.k().l();
        if (l != null) {
            c2.b("pver", l.getContainerVersion());
        }
        c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(c2.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", c2);
    }

    public void p(String str, String str2, String str3, String str4) {
        j(str, str3, str2, str4);
    }

    public void q(String str, String str2, String str3) {
        r(str, str2, str3, null);
    }

    public void r(String str, String str2, String str3, String str4) {
        d.a.c.e.n.a c2 = c();
        if (str != null) {
            c2.b("workflow", str + "_failure");
        }
        if (str2 != null) {
            c2.b("reason", str2);
        }
        if (str3 != null) {
            c2.b("pname", str3);
        }
        a(c2);
        if (str4 != null) {
            c2.b("comment", str4);
        }
        c2.c("pid", Integer.valueOf(Process.myPid()));
        PluginSettings l = d.k().l();
        if (l != null) {
            c2.b("pver", l.getContainerVersion());
        }
        c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdLog.e(c2.toString());
        BdStatisticsManager.getInstance().debug("pluginproxy", c2);
    }

    public void s(String str) {
        if (str == null) {
            return;
        }
        Integer num = this.f42865a.get(str);
        if (num == null) {
            num = 0;
        }
        this.f42865a.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public void t(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        s(str);
    }

    public void u(boolean z) {
        EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
    }

    public void v() {
        if (this.f42865a.size() == 0) {
            return;
        }
        d.a.c.e.n.a c2 = c();
        a(c2);
        c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", c2);
    }
}
