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
    public static boolean f42913b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f42914c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f42915d = new c();

    /* renamed from: a  reason: collision with root package name */
    public volatile d.b.c.i.a f42916a;

    public static void a() {
        if (!f42914c && d.b.c.i.a.m()) {
            f42914c = true;
            NPSPackageManager.getInstance().downloadAllBundles();
        }
    }

    public static void b() {
        if (f42913b) {
            return;
        }
        f42913b = true;
        NPSPackageManager.getInstance().fetchBundleInfo();
    }

    public static c d() {
        return f42915d;
    }

    public static void j() {
        a();
    }

    public RequestParams.Channel c() {
        i();
        return this.f42916a.l();
    }

    public String e() {
        return g(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME);
    }

    public d.b.c.i.a f() {
        i();
        return this.f42916a;
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
        if (this.f42916a == null) {
            this.f42916a = new d.b.c.i.a();
        }
    }
}
