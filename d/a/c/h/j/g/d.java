package d.a.c.h.j.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettingIOService;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f42818g;

    /* renamed from: b  reason: collision with root package name */
    public Messenger f42820b;

    /* renamed from: e  reason: collision with root package name */
    public f f42823e;

    /* renamed from: a  reason: collision with root package name */
    public PluginSettings f42819a = new PluginSettings();

    /* renamed from: c  reason: collision with root package name */
    public Messenger f42821c = new Messenger(new b(this, null));

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f42822d = new c();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Message> f42824f = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f42825a;

        public a(f fVar) {
            this.f42825a = fVar;
        }

        @Override // d.a.c.h.j.g.f
        public void a(PluginSettings pluginSettings) {
            if (pluginSettings != null) {
                d.this.f42819a = pluginSettings;
            }
            f fVar = this.f42825a;
            if (fVar != null) {
                fVar.a(pluginSettings);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Serializable serializable;
            try {
                switch (message.what) {
                    case 5:
                        Bundle data = message.getData();
                        if (data != null && (serializable = data.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                            d.this.f42819a = (PluginSettings) data.getSerializable("plugin_settings");
                        }
                        if (d.this.f42823e != null) {
                            d.this.f42823e.a(d.this.f42819a);
                            d.this.f42823e = null;
                            return;
                        }
                        return;
                    case 6:
                        Bundle data2 = message.getData();
                        if (data2 != null) {
                            boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                            String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                            PluginSetting findPluginSetting = d.this.f42819a.findPluginSetting(string);
                            if (findPluginSetting != null && findPluginSetting.forbidden != z) {
                                findPluginSetting.forbidden = z;
                            }
                            if (z) {
                                return;
                            }
                            PluginCenter.getInstance().launch(string);
                            return;
                        }
                        return;
                    case 7:
                        Bundle data3 = message.getData();
                        if (data3 != null) {
                            d.this.f42819a.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            return;
                        }
                        return;
                    case 8:
                        Bundle data4 = message.getData();
                        if (data4 != null) {
                            d.this.f42819a.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                            return;
                        }
                        return;
                    case 9:
                        Bundle data5 = message.getData();
                        if (data5 != null) {
                            boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                            PluginSetting findPluginSetting2 = d.this.f42819a.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            if (findPluginSetting2 != null && findPluginSetting2.enable != z2) {
                                findPluginSetting2.enable = z2;
                            }
                            boolean z3 = false;
                            if (findPluginSetting2.isPatch && TextUtils.isEmpty(findPluginSetting2.replaceMethodClasses)) {
                                z3 = true;
                            }
                            if (findPluginSetting2 == null || !findPluginSetting2.enable || TextUtils.isEmpty(findPluginSetting2.requireLoad) || !findPluginSetting2.requireLoad.equals("0") || z3) {
                                return;
                            }
                            PluginCenter.getInstance().launch(findPluginSetting2.packageName);
                            return;
                        }
                        return;
                    case 10:
                        Bundle data6 = message.getData();
                        if (data6 != null) {
                            String string2 = data6.getString("key_version");
                            if ((!TextUtils.isEmpty(string2) || TextUtils.isEmpty(d.this.f42819a.getContainerVersion())) && ((TextUtils.isEmpty(string2) || !TextUtils.isEmpty(d.this.f42819a.getContainerVersion())) && (TextUtils.isEmpty(string2) || TextUtils.isEmpty(d.this.f42819a.getContainerVersion()) || string2.equals(d.this.f42819a.getContainerVersion())))) {
                                return;
                            }
                            d.this.f42819a.setContainerSetting(string2);
                            return;
                        }
                        return;
                    case 11:
                        Bundle data7 = message.getData();
                        if (data7 != null) {
                            int i2 = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                            PluginSetting findPluginSetting3 = d.this.f42819a.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            if (findPluginSetting3 == null || findPluginSetting3.installStatus == i2) {
                                return;
                            }
                            findPluginSetting3.installStatus = i2;
                            return;
                        }
                        return;
                    case 12:
                        Bundle data8 = message.getData();
                        if (data8 != null) {
                            d.this.f42819a.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f42820b = new Messenger(iBinder);
            d.this.t();
            if (d.this.f42824f.size() > 0) {
                Iterator it = d.this.f42824f.iterator();
                while (it.hasNext()) {
                    try {
                        d.this.f42820b.send((Message) it.next());
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
                d.this.f42824f.clear();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.f42820b = null;
            d.this.f42824f.clear();
        }
    }

    public static d k() {
        if (f42818g == null) {
            synchronized (d.class) {
                if (f42818g == null) {
                    f42818g = new d();
                }
            }
        }
        return f42818g;
    }

    public void A(String str) {
        PluginSetting h2 = h(str);
        if (h2 == null || !h2.forbidden) {
            return;
        }
        h2.forbidden = false;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, false);
        s(6, bundle);
    }

    public void B(String str, PluginSetting pluginSetting, boolean z) {
        if (this.f42819a.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            d.a.c.h.j.g.c.b().h(this.f42819a.m9clone(), null);
        }
    }

    public void C(String str) {
        if (this.f42819a.findPluginSetting(str) == null) {
            return;
        }
        q(str);
        w("");
    }

    public void D(String str) {
        if (this.f42819a.findPluginSetting(str) == null) {
            return;
        }
        q(str);
        w("");
    }

    public String g(int i2) {
        PluginSetting findPluginSettingByCmd = this.f42819a.findPluginSettingByCmd(i2);
        if (findPluginSettingByCmd != null) {
            return findPluginSettingByCmd.packageName;
        }
        return null;
    }

    public PluginSetting h(String str) {
        return this.f42819a.findPluginSetting(str);
    }

    public void i(String str) {
        PluginSetting h2 = h(str);
        if (h2 == null || h2.forbidden) {
            return;
        }
        h2.forbidden = true;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
        s(6, bundle);
    }

    public void j(String str) {
        PluginSetting h2 = h(str);
        if (h2 != null) {
            h2.enable = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, true);
            s(9, bundle);
        }
    }

    public PluginSettings l() {
        return this.f42819a;
    }

    public void m(String str, PluginSetting pluginSetting) {
        if (this.f42819a.insertOrUpdatePluginSetting(str, pluginSetting)) {
            r();
        }
    }

    public boolean n(String str) {
        PluginSetting h2 = h(str);
        if (h2 == null) {
            return true;
        }
        return h2.forbidden;
    }

    public final boolean o() {
        List<ActivityManager.RunningServiceInfo> list;
        try {
            list = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
        } catch (Exception unused) {
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("loc", d.class.getName() + "-isPluginIOServiceStart-getRunningServices");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            list = null;
        }
        if (list != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : list) {
                if (runningServiceInfo != null && runningServiceInfo.service != null && PluginSettingIOService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void p(f fVar) {
        d.a.c.h.j.g.c.b().g(new a(fVar));
        if (this.f42820b == null || !o()) {
            d.a.c.e.m.f.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f42822d, 1);
        }
    }

    public void q(String str) {
        if (this.f42819a.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            s(7, bundle);
        }
    }

    public final void r() {
        Message obtain = Message.obtain((Handler) null, 4);
        Bundle bundle = new Bundle();
        bundle.putSerializable("plugin_settings", this.f42819a.m9clone());
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.f42820b != null && o()) {
                    this.f42820b.send(obtain);
                }
                this.f42824f.add(obtain);
                d.a.c.e.m.f.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f42822d, 1);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void s(int i2, Bundle bundle) {
        Message obtain = Message.obtain((Handler) null, i2);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.f42820b != null && o()) {
                    this.f42820b.send(obtain);
                }
                this.f42824f.add(obtain);
                d.a.c.e.m.f.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.f42822d, 1);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void t() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.f42821c;
                this.f42820b.send(obtain);
            } catch (RemoteException unused) {
            } catch (Throwable unused2) {
                d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", d.class.getName() + "-sendMsgConnect");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
        }
    }

    public void u(String str, String str2, boolean z) {
        PluginSetting h2 = h(str);
        if (h2 != null) {
            h2.setAbandon_apk_path(str2);
            if (z) {
                d.a.c.h.j.g.c.b().h(this.f42819a.m9clone(), null);
            }
        }
    }

    public void v(boolean z) {
        if (this.f42819a.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            s(8, bundle);
        }
    }

    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.f42819a.getContainerVersion()) || !this.f42819a.getContainerVersion().equals(str)) {
            this.f42819a.setContainerSetting(str);
            Bundle bundle = new Bundle();
            bundle.putString("key_version", str);
            s(10, bundle);
        }
    }

    public void x(String str) {
        String forbiddenFeatures = this.f42819a.getForbiddenFeatures();
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(forbiddenFeatures)) {
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
            this.f42819a.setForbiddenFeatures(str);
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
            s(12, bundle);
        }
    }

    public void y(String str, int i2) {
        PluginSetting h2 = h(str);
        if (h2 == null || h2.installStatus == i2) {
            return;
        }
        h2.installStatus = i2;
        Bundle bundle = new Bundle();
        bundle.putInt(PluginSettingIOService.KEY_INSTALL_STATUS, i2);
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        s(11, bundle);
    }

    public void z(String str, boolean z) {
        PluginSetting h2 = h(str);
        if (h2 == null || h2.enable == z) {
            return;
        }
        h2.enable = z;
        Bundle bundle = new Bundle();
        bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
        bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
        s(9, bundle);
    }
}
