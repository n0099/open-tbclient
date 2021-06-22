package d.a.c.h.j.h;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f42932b;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<String, PluginStatus> f42933a = new LinkedHashMap<>(10);

    public static a b() {
        if (f42932b == null) {
            synchronized (a.class) {
                if (f42932b == null) {
                    f42932b = new a();
                }
            }
        }
        return f42932b;
    }

    public List<PluginStatus> a() {
        ArrayList arrayList;
        PluginStatus value;
        synchronized (this.f42933a) {
            arrayList = new ArrayList(this.f42933a.size());
            for (Map.Entry<String, PluginStatus> entry : this.f42933a.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.f2253g == PluginPackageManager.PluginStatus.ERROR) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public PluginStatus c(String str) {
        PluginStatus pluginStatus;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f42933a) {
            pluginStatus = this.f42933a.get(str);
            if (pluginStatus == null) {
                pluginStatus = new PluginStatus();
                pluginStatus.f2251e = str;
                this.f42933a.put(str, pluginStatus);
            }
        }
        return pluginStatus;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, String str2, String str3) {
        String string;
        String string2;
        PluginStatus c2;
        int i2 = 1;
        if ("rom_size".equals(str2)) {
            string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
            string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
        } else if ("plugin_install_retry_timeout".equals(str2) || "plugin_install_timeout".equals(str2)) {
            return;
        } else {
            if (str3 != null) {
                String lowerCase = str3.toLowerCase(Locale.getDefault());
                if (!lowerCase.contains("no_space_left_on_device") && !lowerCase.contains("no space left on device")) {
                    if (!lowerCase.contains("read-only_file_system") && !lowerCase.contains("read-only file system")) {
                        if (!lowerCase.contains("permission_denied") && !lowerCase.contains("permission denied")) {
                            if (!lowerCase.contains("fsync_failed") && !lowerCase.contains("fsync failed")) {
                                string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
                                string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
                            } else {
                                string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
                                string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
                                i2 = 5;
                            }
                        } else {
                            string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_need_restart);
                            string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_need_restart);
                            i2 = 4;
                        }
                    } else {
                        string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_need_restart);
                        string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_need_restart);
                        i2 = 3;
                    }
                } else {
                    string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_rom_too_small);
                    string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_rom_too_small);
                }
            } else {
                string = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
                string2 = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
            }
            c2 = c(str);
            if (c2 == null) {
                c2 = new PluginStatus();
            }
            c2.f2253g = PluginPackageManager.PluginStatus.ERROR;
            c2.f2255i = string;
            c2.j = string2;
            c2.f2254h = i2;
            c2.k = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, c2));
        }
        i2 = 2;
        c2 = c(str);
        if (c2 == null) {
        }
        c2.f2253g = PluginPackageManager.PluginStatus.ERROR;
        c2.f2255i = string;
        c2.j = string2;
        c2.f2254h = i2;
        c2.k = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, c2));
    }

    public void e(String str) {
        PluginStatus c2 = b().c(str);
        if (c2 != null) {
            c2.f2253g = PluginPackageManager.PluginStatus.NROMAL;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, c2));
    }

    public void f(String str) {
        PluginStatus c2 = c(str);
        if (c2 == null) {
            c2 = new PluginStatus();
        }
        c2.f2253g = PluginPackageManager.PluginStatus.ERROR;
        c2.f2254h = 100;
        c2.f2255i = BdBaseApplication.getInst().getString(R.string.pluginstatus_tip_unknown);
        c2.j = BdBaseApplication.getInst().getString(R.string.pluginstatus_resolve_unknown);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, c2));
    }
}
