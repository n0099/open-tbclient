package d.a.m0.a.a1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.a.a1.h.a;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.j2.c;
import d.a.m0.a.j2.m;
import d.a.m0.a.k;
import d.a.m0.a.k2.g.h;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q0;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44469a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f44470b = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f44471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44472f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a1.b f44473g;

        public a(d.a.m0.a.f1.e.b bVar, JSONObject jSONObject, d.a.m0.a.a1.b bVar2) {
            this.f44471e = bVar;
            this.f44472f = jSONObject;
            this.f44473g = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g l;
            SwanAppConfigData swanAppConfigData;
            d.a.m0.a.v2.a1.b bVar = new d.a.m0.a.v2.a1.b();
            if (d.a.m0.a.u1.a.a.A(this.f44471e)) {
                l = d.a.m0.a.u1.a.a.c(this.f44471e, bVar);
            } else {
                l = C0620e.l(this.f44471e, bVar, this.f44472f);
            }
            if (l == null || (swanAppConfigData = l.f44476b) == null || swanAppConfigData.f11390b == null) {
                d.a.m0.a.q2.a aVar = bVar.f49137a;
                if (aVar == null) {
                    aVar = new d.a.m0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(20L);
                    aVar.e("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                }
                d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
                d.a.m0.a.f1.e.b bVar2 = this.f44471e;
                dVar.q(d.a.m0.a.j2.k.m(bVar2 != null ? bVar2.G() : 0));
                dVar.p(aVar);
                dVar.s("appjson_config_invalid");
                dVar.r(this.f44471e);
                d.a.m0.a.j2.k.L(dVar);
            }
            this.f44473g.a(0, l);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static g a(d.a.m0.a.f1.e.b bVar, d.a.m0.a.v2.a1.b bVar2) {
            File b2 = b(bVar2);
            if (b2 == null) {
                return null;
            }
            d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
            if (i2 == null) {
                if (!e.L(b2, e(), bVar, bVar2)) {
                    d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").F();
                    d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小程序bundle解压失败! for debug");
                    d.a.m0.a.q2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f49137a == null) {
                        bVar2.f49137a = aVar;
                    }
                    return null;
                }
            } else {
                String q = i2.T().q("installed_debug_bundle_md5", "");
                String b3 = d.a.m0.t.f.b(b2, false);
                if (!TextUtils.equals(q, b3)) {
                    if (!e.L(b2, e(), bVar, bVar2)) {
                        d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").F();
                        d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
                        aVar2.j(5L);
                        aVar2.h(7L);
                        aVar2.e("小程序bundle解压失败! for debug");
                        d.a.m0.a.q2.e.a().f(aVar2);
                        if (bVar2 != null && bVar2.f49137a == null) {
                            bVar2.f49137a = aVar2;
                        }
                        return null;
                    }
                    i2.T().B("installed_debug_bundle_md5", b3);
                }
            }
            g gVar = new g();
            File g2 = g();
            File file = new File(g2, "app.json");
            SwanAppConfigData b4 = d.a.m0.a.a2.n.d.b(g2.getAbsolutePath());
            gVar.f44475a = g2.getPath() + File.separator;
            gVar.f44476b = b4;
            d.a.m0.a.t1.b.a.f(b4, true);
            d.a.m0.a.t1.g.b.l(b4);
            d.a.m0.a.e0.d.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f44475a);
            return gVar;
        }

        public static File b(d.a.m0.a.v2.a1.b bVar) {
            File c2 = c();
            File[] listFiles = c2.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                return h(listFiles);
            }
            Context appContext = AppRuntime.getAppContext();
            d.a.m0.a.z1.b.f.e.g(appContext, c2.getPath() + " 没有测试程序包!").F();
            d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
            aVar.j(5L);
            aVar.h(4L);
            aVar.e("没有小程序包! for debug, bundle files are empty");
            d.a.m0.a.q2.e.a().f(aVar);
            if (bVar != null) {
                bVar.f49137a = aVar;
                return null;
            }
            return null;
        }

        public static File c() {
            File file = new File(d.a.m0.a.f1.c.a.d().get(0).f49205a, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static String d() {
            return new File(d.a.m0.a.f1.c.a.d().get(0).f49205a, "/aiapps_debug/").getAbsolutePath();
        }

        public static File e() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static String f() {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aiapps_bundle";
        }

        public static File g() {
            return e();
        }

        public static File h(File[] fileArr) {
            File file = null;
            for (File file2 : fileArr) {
                if (file == null || file2.lastModified() > file.lastModified()) {
                    file = file2;
                }
            }
            return file;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i2);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f44474a;
    }

    /* renamed from: d.a.m0.a.a1.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0620e {

        /* renamed from: d.a.m0.a.a1.e$e$a */
        /* loaded from: classes3.dex */
        public static class a implements FileFilter {
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
            }
        }

        public static long a(String str, String str2) throws IllegalArgumentException {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (TextUtils.isDigitsOnly(str) && TextUtils.isDigitsOnly(str2)) {
                    return Long.parseLong(str) - Long.parseLong(str2);
                }
                throw new IllegalArgumentException("version is not digits only");
            }
            throw new IllegalArgumentException("version null");
        }

        public static File b(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static void c(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (k(str2, file.getName())) {
                    d.a.m0.a.e0.d.h("SwanAppBundleHelper", "#deleteLowerVersionFolder del：" + file.getAbsolutePath());
                    d.a.m0.n.g.a.h().d(str, file.getName());
                    d.a.m0.t.d.i(file);
                    d.a.m0.a.l1.d.c.b(str, file.getName());
                }
            }
        }

        public static void d() {
            d.a.m0.t.d.K(e.q());
        }

        public static void e(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File f2 = f(str, false);
            if (f2 != null) {
                d.a.m0.t.d.K(f2);
            }
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str);
            d.a.m0.a.l1.d.c.a(str);
            d.a.m0.t.d.K(file);
            d.a.m0.t.d.K(new File(e.o(str)));
            int indexOf = str.indexOf("_dev");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                d.a.m0.t.d.K(new File(e.o(substring + "_dev")));
            }
        }

        @Nullable
        public static File f(String str, boolean z) {
            return g(str, z, null);
        }

        @Nullable
        public static File g(@Nullable String str, boolean z, @Nullable d.a.m0.a.v2.a1.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File h2 = h();
            File file = new File(h2, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (e.f44469a && z) {
                Context appContext = AppRuntime.getAppContext();
                d.a.m0.a.z1.b.f.e.g(appContext, h2.getPath() + " 没有小程序包!").F();
            }
            if (bVar != null) {
                d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                aVar.j(5L);
                aVar.h(4L);
                aVar.e("没有小程序包! for release, no such bundle file");
                d.a.m0.a.q2.e.a().f(aVar);
                bVar.f49137a = aVar;
            }
            return null;
        }

        public static File h() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File i(String str, String str2) {
            return j(str, str2, null);
        }

        public static File j(String str, String str2, @Nullable JSONObject jSONObject) {
            if (m.e(str2)) {
                m.f(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static boolean k(String str, String str2) {
            if (e.f44469a) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return a(str, str2) > 0;
            } catch (IllegalArgumentException e2) {
                if (e.f44469a) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e2.getMessage());
                }
                return false;
            }
        }

        public static g l(d.a.m0.a.f1.e.b bVar, d.a.m0.a.v2.a1.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File v = e.v(bVar.H(), bVar.u1(), bVar.n0(), bVar.h0(), jSONObject);
            if (!v.exists()) {
                File g2 = g(bVar.H(), true, bVar2);
                if (g2 == null) {
                    d.a.m0.a.v1.c.e.a E = d.a.m0.a.v1.c.e.a.E();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(bVar.H(), 1);
                    swanAppDeleteInfo.b(5);
                    E.O(8, swanAppDeleteInfo);
                    d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(31L);
                    aVar.e("小程序zip和bundle不存在，兜底重置");
                    d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
                    dVar.q(d.a.m0.a.j2.k.m(bVar.G()));
                    dVar.p(aVar);
                    dVar.r(bVar);
                    d.a.m0.a.j2.k.L(dVar);
                    if (e.f44469a) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                    }
                    return null;
                }
                b(v);
                if (!e.L(g2, v, bVar, bVar2)) {
                    d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").F();
                    d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
                    aVar2.j(5L);
                    aVar2.h(7L);
                    aVar2.e("小程序bundle解压失败! for release");
                    d.a.m0.a.q2.e.a().f(aVar2);
                    if (bVar2 != null && bVar2.f49137a == null) {
                        bVar2.f49137a = aVar2;
                    }
                    return null;
                }
            }
            c(bVar.H(), bVar.u1());
            g gVar = new g();
            File file = new File(v, "app.json");
            SwanAppConfigData b2 = d.a.m0.a.a2.n.d.b(v.getAbsolutePath());
            if (b2 == null) {
                return null;
            }
            gVar.f44475a = i(bVar.H(), bVar.u1()).getPath() + File.separator;
            gVar.f44476b = b2;
            d.a.m0.a.t1.b.a.f(b2, true);
            d.a.m0.a.t1.g.b.l(b2);
            d.a.m0.a.e0.d.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f44475a);
            return gVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static g a(d.a.m0.a.f1.e.b bVar) {
            File e2 = e();
            d.a.m0.a.e0.f.e.d.g().h("unzipstart");
            e.K(b(), e2, bVar);
            d.a.m0.a.e0.f.e.d.g().h("unzipend");
            g gVar = new g();
            File file = new File(e2, "app.json");
            SwanAppConfigData b2 = d.a.m0.a.a2.n.d.b(e2.getAbsolutePath());
            gVar.f44475a = e2.getPath() + File.separator;
            gVar.f44476b = b2;
            d.a.m0.a.t1.b.a.f(b2, true);
            d.a.m0.a.t1.g.b.l(b2);
            d.a.m0.a.e0.d.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f44475a);
            return gVar;
        }

        public static File b() {
            return new File(c(), "remote_debug.aiapps");
        }

        public static File c() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static String d() {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_zip";
        }

        public static File e() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static String f() {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_folder";
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends d.a.m0.a.a1.a {

        /* renamed from: a  reason: collision with root package name */
        public String f44475a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppConfigData f44476b;
    }

    public static boolean A(String str, String str2) {
        boolean exists = new File(k(str, str2), "app.json").exists();
        d.a.m0.a.e0.d.h("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean B(String str, String str2, String str3) {
        return z(p(str, str2, str3));
    }

    public static boolean C(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String g2 = o0.g(str2);
        int lastIndexOf = g2.lastIndexOf(File.separator);
        if (lastIndexOf > 0) {
            g2 = g2.substring(0, lastIndexOf);
        }
        boolean exists = new File(str, g2).exists();
        if (f44469a) {
            Log.d("SwanAppBundleHelper", "pagePath - " + g2 + ", isExist - " + exists);
        }
        return exists;
    }

    public static void D(String str, String str2) {
        c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER);
        bVar.j(str);
        bVar.l(str2);
        bVar.m();
    }

    public static void E(boolean z) {
        h.a().putBoolean("swanapps_has_done_fallback_strategy_key", z);
    }

    public static void F(String str, c cVar) {
        d dVar = new d();
        dVar.f44474a = str;
        new d.a.m0.a.k0.a().e(dVar, d.a.m0.a.p0.f.b.j().getPath(), cVar);
    }

    public static void G(String str, c cVar) {
        d dVar = new d();
        dVar.f44474a = str;
        d.a.m0.a.p0.f.c.a();
        new d.a.m0.a.k0.a().e(dVar, d.a.m0.a.p0.f.c.c().getPath(), cVar);
    }

    public static void H(String str, c cVar) {
        d dVar = new d();
        dVar.f44474a = str;
        d.a.m0.a.m2.d.a.a();
        new d.a.m0.a.k0.a().e(dVar, d.a.m0.a.m2.d.a.d().getPath(), cVar);
    }

    public static void I(d dVar, c cVar) {
        File c2 = b.c();
        new d.a.m0.a.k0.a().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
    }

    public static boolean J(File file, String str) {
        File file2 = new File(file, str);
        if (file2.exists()) {
            return true;
        }
        boolean mkdirs = file2.mkdirs();
        d.a.m0.a.e0.d.h("SwanAppBundleHelper", "#tryMkdirs del: " + file2.getAbsolutePath());
        d.a.m0.t.d.K(file2);
        return mkdirs;
    }

    public static boolean K(File file, File file2, d.a.m0.a.f1.e.b bVar) {
        return L(file, file2, bVar, null);
    }

    public static boolean L(File file, File file2, d.a.m0.a.f1.e.b bVar, d.a.m0.a.v2.a1.b bVar2) {
        boolean T;
        int i2 = 0;
        if (file != null && file2 != null) {
            if (file.exists() && file.length() != 0) {
                d.a.m0.a.r1.h.o().C(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                a.b i3 = d.a.m0.a.a1.h.a.i(file);
                int i4 = i3.f44499b;
                if (i4 != -1) {
                    T = d.a.m0.a.a1.h.a.c(i3.f44498a, file2, i4).f44496a;
                    i2 = i3.f44499b;
                } else {
                    T = d.a.m0.t.d.T(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (f44469a) {
                    d.a.m0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!T) {
                    d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小程序bundle解压失败! PkgType=" + i2);
                    if (bVar2 != null) {
                        bVar2.f49137a = aVar;
                    }
                }
                HybridUbcFlow o = d.a.m0.a.r1.h.o();
                o.C(new UbcFlowEvent("package_end_unzip"));
                o.A("app_package_version", String.valueOf(i2));
                return T;
            }
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(5L);
            aVar2.h(4L);
            aVar2.e("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.f49137a = aVar2;
            }
        }
        return false;
    }

    public static synchronized boolean M(@NonNull d.a.m0.a.a2.e eVar) {
        boolean N;
        synchronized (e.class) {
            N = N(eVar, u(eVar));
        }
        return N;
    }

    public static synchronized boolean N(@NonNull d.a.m0.a.a2.e eVar, File file) {
        synchronized (e.class) {
            if (file != null) {
                if (file.exists()) {
                    SwanAppConfigData b2 = d.a.m0.a.f1.c.a.b(file);
                    if (b2 != null) {
                        eVar.t0(b2);
                    }
                    d.a.m0.a.t1.b.a.f(b2, true);
                    d.a.m0.a.t1.g.b.l(b2);
                    return true;
                }
            }
            return false;
        }
    }

    public static void c(d.a.m0.a.f1.e.b bVar, d.a.m0.a.a1.b bVar2) {
        JSONObject jSONObject;
        String H1;
        if (bVar == null || m.e(bVar.u1())) {
            jSONObject = new JSONObject();
            String y = q0.y();
            if (bVar == null) {
                H1 = StringUtil.NULL_STRING;
            } else {
                try {
                    H1 = bVar.H1();
                } catch (JSONException e2) {
                    if (f44469a) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", H1);
            jSONObject.put("stackTraceBefore", y);
        } else {
            jSONObject = null;
        }
        f44470b.execute(new a(bVar, jSONObject, bVar2));
    }

    @WorkerThread
    public static synchronized void d(Set<String> set, Map<String, PMSAppInfo> map) {
        File[] B;
        synchronized (e.class) {
            if (map != null) {
                if (!map.isEmpty()) {
                    File o = d.a.m0.a.k2.b.o();
                    try {
                        for (Map.Entry<String, PMSAppInfo> entry : map.entrySet()) {
                            String key = entry.getKey();
                            if (!TextUtils.isEmpty(key)) {
                                if (set != null && set.contains(key)) {
                                    d.a.m0.a.e0.d.h("SwanAppBundleHelper", "删历史版本包，排除id: " + key);
                                } else {
                                    long j = entry.getValue().versionCode;
                                    File file = new File(o, key);
                                    if (file.exists() && file.isDirectory()) {
                                        for (File file2 : d.a.m0.t.d.B(file)) {
                                            if (file2 != null && Long.parseLong(file2.getName()) < j) {
                                                if (x(key)) {
                                                    break;
                                                }
                                                d.a.m0.t.d.K(file2);
                                                d.a.m0.a.e0.d.h("SwanAppBundleHelper", "删历史版本包，file=" + file2.getAbsolutePath());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        d.a.m0.a.e0.d.i("SwanAppBundleHelper", "#删历史版本包, ex=", e2);
                    }
                }
            }
        }
    }

    public static synchronized void e(String str) {
        synchronized (e.class) {
            if (w()) {
                d.a.m0.n.c.b().x("SwanAppBundleHelper", "hasDoneFallbackStrategy true");
                D(str, "repeat");
                return;
            }
            boolean z = true;
            E(true);
            D(str, IntentConfig.START);
            File g2 = g();
            if (J(g2, str)) {
                D(str, "canwrite");
                return;
            }
            d.a.m0.n.a b2 = d.a.m0.n.c.b();
            b2.x("SwanAppBundleHelper", "tryMkdirs fail. Base folder: " + g2.getAbsolutePath() + " child file:" + str);
            if (g2.exists()) {
                d.a.m0.a.e0.d.h("SwanAppBundleHelper", "#doSwanFolderFallback del: " + g2.getAbsolutePath());
                d.a.m0.t.d.K(g2);
            }
            if (!g2.exists() && g2.mkdirs() && J(g2, str)) {
                D(str, "delete");
                return;
            }
            File h2 = h();
            if (h2.exists() || !h2.mkdirs() || !J(h2, str)) {
                z = false;
            }
            D(str, "fail:" + z);
        }
    }

    @NonNull
    public static Set<String> f() {
        LinkedHashSet<d.a.m0.a.v1.c.f.c> q = d.a.m0.a.v1.c.f.e.k().q();
        HashSet hashSet = new HashSet();
        for (d.a.m0.a.v1.c.f.c cVar : q) {
            if (cVar != null) {
                String appId = cVar.getAppId();
                Set<String> i2 = cVar.i();
                if (!TextUtils.isEmpty(appId)) {
                    hashSet.add(appId);
                    if (f44469a) {
                        Log.d("SwanAppBundleHelper", "appId in running - " + appId);
                    }
                }
                if (i2.size() > 0) {
                    hashSet.addAll(i2);
                    if (f44469a) {
                        Log.d("SwanAppBundleHelper", "appId in prefetch - " + i2);
                    }
                }
            }
        }
        if (f44469a) {
            Log.d("SwanAppBundleHelper", "active apps - " + hashSet);
        }
        return hashSet;
    }

    public static File g() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static File h() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_folder_fallback");
    }

    public static String i() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File j(String str) {
        return new File(g(), str);
    }

    public static File k(String str, String str2) {
        return new File(j(str), str2);
    }

    public static String l() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_zip";
    }

    public static synchronized String m(@NonNull File file) {
        synchronized (e.class) {
            if (file == null) {
                return "";
            }
            String path = file.getPath();
            if (f44469a) {
                Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
            }
            String str = (String) d.a.m0.a.h0.u.f.b().a(path, "");
            if (TextUtils.isEmpty(str)) {
                if (f44469a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                }
                String D = d.a.m0.t.d.D(file);
                d.a.m0.a.h0.u.f.b().c(path, D);
                if (f44469a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                }
                return D;
            }
            return str;
        }
    }

    public static String n() {
        return i() + File.separator + "database";
    }

    public static String o(String str) {
        return n() + File.separator + str;
    }

    public static File p(String str, String str2, String str3) {
        return new File(k(str, str2), o0.g(str3));
    }

    public static File q() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static String r() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_plugin_workspace";
    }

    public static File s(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f44469a) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(q(), str);
    }

    public static File t(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return new File(s(str), str2);
        }
        if (f44469a) {
            throw new IllegalArgumentException("plugin name or version can't be empty");
        }
        return null;
    }

    public static File u(@NonNull d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            return null;
        }
        b.a L = eVar.L();
        File v = v(eVar.getAppId(), L.u1(), L.n0(), L.h0(), null);
        if (f44469a) {
            Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + v.getPath());
            Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + v.exists());
        }
        return v;
    }

    public static File v(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File j;
        if (d.a.m0.a.u1.a.a.G()) {
            j = b.e();
        } else if (d.a.m0.a.u1.a.a.C()) {
            j = d.a.m0.a.e0.f.d.b.d();
        } else {
            j = C0620e.j(str, str2, jSONObject);
        }
        return (!z || TextUtils.isEmpty(str3)) ? j : new File(j, str3);
    }

    public static boolean w() {
        return h.a().getBoolean("swanapps_has_done_fallback_strategy_key", false);
    }

    public static boolean x(String str) {
        return f().contains(str);
    }

    public static boolean y(File file) {
        boolean z = false;
        if (file != null && file.exists()) {
            File file2 = new File(file, "app.js");
            boolean exists = file2.exists();
            d.a.m0.a.e0.d.h("SwanAppBundleHelper", "isAppJsExist = " + exists);
            long length = exists ? file2.length() : -1L;
            d.a.m0.a.e0.d.h("SwanAppBundleHelper", "appJsSize = " + length);
            if (exists && length > 0) {
                z = true;
            }
            if (!z) {
                d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
                d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                aVar.j(5L);
                aVar.h(51L);
                dVar.p(aVar);
                dVar.l("path", file2.getAbsolutePath());
                dVar.l("appJs", "isAppJsExist =" + exists + ", appJsSize =" + length);
                dVar.l("stack", q0.z(30));
                d.a.m0.a.j2.k.L(dVar);
            }
        }
        return z;
    }

    public static boolean z(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        d.a.m0.a.e0.d.h("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }
}
