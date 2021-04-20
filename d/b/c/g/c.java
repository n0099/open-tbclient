package d.b.c.g;

import android.app.Application;
import com.baidu.nps.main.manager.Configurations;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.pms.init.RequestParams;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f42673b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f42674c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f42675d = new c();

    /* renamed from: a  reason: collision with root package name */
    public volatile d.b.c.i.a f42676a;

    public static void a() {
        if (!f42674c && d.b.c.i.a.m()) {
            f42674c = true;
            NPSPackageManager.getInstance().downloadAllBundles();
        }
    }

    public static void b() {
        if (f42673b) {
            return;
        }
        f42673b = true;
        NPSPackageManager.getInstance().fetchBundleInfo();
    }

    public static c d() {
        return f42675d;
    }

    public static void j() {
        a();
    }

    public RequestParams.Channel c() {
        i();
        return this.f42676a.l();
    }

    public String e() {
        return g(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME);
    }

    public d.b.c.i.a f() {
        i();
        return this.f42676a;
    }

    public String g(String str) {
        BundleInfo bundleInfo;
        try {
            return (NPSPackageManager.getInstance().getBundleStatus(str) == 43 && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str)) != null) ? String.valueOf(bundleInfo.getVersionCode()) : "0";
        } catch (Throwable unused) {
            return "0";
        }
    }

    public void h(Application application) {
        i();
        Configurations.Builder builder = new Configurations.Builder();
        builder.debug(false);
        NPSManager.getInstance().init(application, builder.build(), false);
    }

    public final synchronized void i() {
        if (this.f42676a == null) {
            this.f42676a = new d.b.c.i.a();
        }
    }
}
