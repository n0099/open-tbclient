package d.b.g0.a.u0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.u0.g.a;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
import d.b.g0.a.z1.j;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46986a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f46987b = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f46988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46989f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.u0.b f46990g;

        public a(d.b.g0.a.y0.e.b bVar, JSONObject jSONObject, d.b.g0.a.u0.b bVar2) {
            this.f46988e = bVar;
            this.f46989f = jSONObject;
            this.f46990g = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g k;
            SwanAppConfigData swanAppConfigData;
            d.b.g0.a.i2.r0.b bVar = new d.b.g0.a.i2.r0.b();
            if (d.b.g0.a.m1.a.a.y(this.f46988e)) {
                k = d.b.g0.a.m1.a.a.c(this.f46988e, bVar);
            } else {
                k = e.k(this.f46988e, bVar, this.f46989f);
            }
            if (k == null || (swanAppConfigData = k.f46993b) == null || swanAppConfigData.f12274a == null) {
                d.b.g0.a.f2.a aVar = bVar.f45153a;
                if (aVar == null) {
                    aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(20L);
                    aVar.e("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                }
                d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
                d.b.g0.a.y0.e.b bVar2 = this.f46988e;
                dVar.q(h.n(bVar2 != null ? bVar2.F() : 0));
                dVar.p(aVar);
                dVar.s("appjson_config_invalid");
                dVar.r(this.f46988e);
                h.H(dVar);
            }
            this.f46990g.a(0, k);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static g a(d.b.g0.a.y0.e.b bVar, d.b.g0.a.i2.r0.b bVar2) {
            File b2 = b(bVar2);
            if (b2 == null) {
                return null;
            }
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y == null) {
                if (!d.v(b2, d(), bVar, bVar2)) {
                    d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小程序bundle解压失败!").C();
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小程序bundle解压失败! for debug");
                    d.b.g0.a.f2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f45153a == null) {
                        bVar2.f45153a = aVar;
                    }
                    return null;
                }
            } else {
                String p = y.R().p("installed_debug_bundle_md5", "");
                String b3 = d.b.g0.p.e.b(b2, false);
                if (!TextUtils.equals(p, b3)) {
                    if (!d.v(b2, d(), bVar, bVar2)) {
                        d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小程序bundle解压失败!").C();
                        d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
                        aVar2.j(5L);
                        aVar2.h(7L);
                        aVar2.e("小程序bundle解压失败! for debug");
                        d.b.g0.a.f2.e.a().f(aVar2);
                        if (bVar2 != null && bVar2.f45153a == null) {
                            bVar2.f45153a = aVar2;
                        }
                        return null;
                    }
                    y.R().A("installed_debug_bundle_md5", b3);
                }
            }
            g gVar = new g();
            File e2 = e();
            File file = new File(e2, "app.json");
            SwanAppConfigData c2 = SwanAppConfigData.c(d.b.g0.p.d.r(file), e2);
            gVar.f46992a = e2.getPath() + File.separator;
            gVar.f46993b = c2;
            d.b.g0.a.l1.b.a.e(c2, true);
            d.b.g0.a.l1.g.b.k(c2);
            d.b.g0.a.c0.c.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f46992a);
            return gVar;
        }

        public static File b(d.b.g0.a.i2.r0.b bVar) {
            File c2 = c();
            File[] listFiles = c2.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                return f(listFiles);
            }
            Context appContext = AppRuntime.getAppContext();
            d.b.g0.a.q1.b.f.d.f(appContext, c2.getPath() + " 没有测试程序包!").C();
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(5L);
            aVar.h(4L);
            aVar.e("没有小程序包! for debug, bundle files are empty");
            d.b.g0.a.f2.e.a().f(aVar);
            if (bVar != null) {
                bVar.f45153a = aVar;
                return null;
            }
            return null;
        }

        public static File c() {
            File file = new File(d.b.g0.a.y0.c.a.d().get(0).f45078a, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File d() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File e() {
            return d();
        }

        public static File f(File[] fileArr) {
            File file = null;
            for (File file2 : fileArr) {
                if (file == null || file2.lastModified() > file.lastModified()) {
                    file = file2;
                }
            }
            return file;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i);

        void onFailed();

        void onSuccess();
    }

    /* renamed from: d.b.g0.a.u0.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0861d {

        /* renamed from: a  reason: collision with root package name */
        public String f46991a;
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* loaded from: classes2.dex */
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
                if (j(str2, file.getName())) {
                    if (d.f46986a) {
                        Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                    }
                    d.b.g0.l.i.a.h().d(str, file.getName());
                    d.b.g0.p.d.f(file);
                }
            }
        }

        public static void d(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File e2 = e(str, false);
            if (e2 != null) {
                d.b.g0.p.d.f(e2);
            }
            d.b.g0.p.d.f(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            return f(str, z, null);
        }

        @Nullable
        public static File f(@Nullable String str, boolean z, @Nullable d.b.g0.a.i2.r0.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File g2 = g();
            File file = new File(g2, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.f46986a && z) {
                Context appContext = AppRuntime.getAppContext();
                d.b.g0.a.q1.b.f.d.f(appContext, g2.getPath() + " 没有小程序包!").C();
            }
            if (bVar != null) {
                d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                aVar.j(5L);
                aVar.h(4L);
                aVar.e("没有小程序包! for release, no such bundle file");
                d.b.g0.a.f2.e.a().f(aVar);
                bVar.f45153a = aVar;
            }
            return null;
        }

        public static File g() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File h(String str, String str2) {
            return i(str, str2, null);
        }

        public static File i(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.e(str2)) {
                j.f(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static boolean j(String str, String str2) {
            if (d.f46986a) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return a(str, str2) > 0;
            } catch (IllegalArgumentException e2) {
                if (d.f46986a) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e2.getMessage());
                }
                return false;
            }
        }

        public static g k(d.b.g0.a.y0.e.b bVar, d.b.g0.a.i2.r0.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File n = d.n(bVar.G(), bVar.n1(), bVar.k0(), bVar.e0(), jSONObject);
            if (!n.exists()) {
                File f2 = f(bVar.G(), true, bVar2);
                if (f2 == null) {
                    d.b.g0.a.n1.c.e.a C = d.b.g0.a.n1.c.e.a.C();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(bVar.G(), 1);
                    swanAppDeleteInfo.b(5);
                    C.M(8, swanAppDeleteInfo);
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(31L);
                    aVar.e("小程序zip和bundle不存在，兜底重置");
                    d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
                    dVar.q(h.n(bVar.F()));
                    dVar.p(aVar);
                    dVar.r(bVar);
                    h.H(dVar);
                    if (d.f46986a) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                    }
                    return null;
                }
                b(n);
                if (!d.v(f2, n, bVar, bVar2)) {
                    d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小程序bundle解压失败!").C();
                    d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
                    aVar2.j(5L);
                    aVar2.h(7L);
                    aVar2.e("小程序bundle解压失败! for release");
                    d.b.g0.a.f2.e.a().f(aVar2);
                    if (bVar2 != null && bVar2.f45153a == null) {
                        bVar2.f45153a = aVar2;
                    }
                    return null;
                }
            }
            c(bVar.G(), bVar.n1());
            g gVar = new g();
            File file = new File(n, "app.json");
            SwanAppConfigData c2 = SwanAppConfigData.c(d.h(file), n);
            if (c2 == null) {
                return null;
            }
            gVar.f46992a = h(bVar.G(), bVar.n1()).getPath() + File.separator;
            gVar.f46993b = c2;
            if (d.b.g0.a.j1.m.c.d()) {
                d.b.g0.a.l1.b.a.f(c2, true);
                d.b.g0.a.l1.g.b.l(c2);
            } else {
                d.b.g0.a.l1.b.a.e(c2, true);
                d.b.g0.a.l1.g.b.k(c2);
            }
            d.b.g0.a.c0.c.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f46992a);
            return gVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static g a(d.b.g0.a.y0.e.b bVar) {
            File d2 = d();
            d.b.g0.a.c0.d.d.d.g().h("unzipstart");
            d.u(b(), d2, bVar);
            d.b.g0.a.c0.d.d.d.g().h("unzipend");
            g gVar = new g();
            File file = new File(d2, "app.json");
            SwanAppConfigData c2 = SwanAppConfigData.c(d.b.g0.p.d.r(file), d2);
            gVar.f46992a = d2.getPath() + File.separator;
            gVar.f46993b = c2;
            d.b.g0.a.l1.b.a.e(c2, true);
            d.b.g0.a.l1.g.b.k(c2);
            d.b.g0.a.c0.c.h("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.f46992a);
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

        public static File d() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends d.b.g0.a.u0.a {

        /* renamed from: a  reason: collision with root package name */
        public String f46992a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppConfigData f46993b;
    }

    public static void c(d.b.g0.a.y0.e.b bVar, d.b.g0.a.u0.b bVar2) {
        JSONObject jSONObject;
        String A1;
        if (bVar == null || j.e(bVar.n1())) {
            jSONObject = new JSONObject();
            String u = k0.u();
            if (bVar == null) {
                A1 = StringUtil.NULL_STRING;
            } else {
                try {
                    A1 = bVar.A1();
                } catch (JSONException e2) {
                    if (f46986a) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", A1);
            jSONObject.put("stackTraceBefore", u);
        } else {
            jSONObject = null;
        }
        f46987b.execute(new a(bVar, jSONObject, bVar2));
    }

    public static File d() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String e() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File f(String str) {
        return new File(d(), str);
    }

    public static File g(String str, String str2) {
        return new File(f(str), str2);
    }

    public static synchronized String h(@NonNull File file) {
        synchronized (d.class) {
            if (file == null) {
                return "";
            }
            String path = file.getPath();
            if (f46986a) {
                Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
            }
            String str = (String) d.b.g0.a.e0.w.c.b().a(path, "");
            if (TextUtils.isEmpty(str)) {
                if (f46986a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                }
                String r = d.b.g0.p.d.r(file);
                d.b.g0.a.e0.w.c.b().c(path, r);
                if (f46986a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                }
                return r;
            }
            return str;
        }
    }

    public static File i(String str, String str2, String str3) {
        return new File(g(str, str2), i0.e(str3));
    }

    public static File j() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File k(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46986a) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(j(), str);
    }

    public static File l(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return new File(k(str), str2);
        }
        if (f46986a) {
            throw new IllegalArgumentException("plugin name or version can't be empty");
        }
        return null;
    }

    public static File m(@NonNull d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            return null;
        }
        b.a J = eVar.J();
        File n = n(eVar.getAppId(), J.n1(), J.k0(), J.e0(), null);
        if (f46986a) {
            Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + n.getPath());
            Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + n.exists());
        }
        return n;
    }

    public static File n(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File i = e.i(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? i : new File(i, str3);
    }

    public static boolean o(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        d.b.g0.a.c0.c.h("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean p(String str, String str2) {
        boolean exists = new File(g(str, str2), "app.json").exists();
        d.b.g0.a.c0.c.h("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean q(String str, String str2, String str3) {
        return o(i(str, str2, str3));
    }

    public static void r(String str, c cVar) {
        C0861d c0861d = new C0861d();
        c0861d.f46991a = str;
        d.b.g0.a.l0.g.b.a();
        new d.b.g0.a.h0.a().e(c0861d, d.b.g0.a.l0.g.b.c().getPath(), cVar);
    }

    public static void s(String str, c cVar) {
        C0861d c0861d = new C0861d();
        c0861d.f46991a = str;
        d.b.g0.a.b2.d.a.a();
        new d.b.g0.a.h0.a().e(c0861d, d.b.g0.a.b2.d.a.d().getPath(), cVar);
    }

    public static void t(C0861d c0861d, c cVar) {
        File c2 = b.c();
        new d.b.g0.a.h0.a().e(c0861d, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
    }

    public static boolean u(File file, File file2, d.b.g0.a.y0.e.b bVar) {
        return v(file, file2, bVar, null);
    }

    public static boolean v(File file, File file2, d.b.g0.a.y0.e.b bVar, d.b.g0.a.i2.r0.b bVar2) {
        boolean F;
        int i = 0;
        if (file != null && file2 != null) {
            if (file.exists() && file.length() != 0) {
                i.n().A(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                a.b f2 = d.b.g0.a.u0.g.a.f(file);
                int i2 = f2.f47011b;
                if (i2 != -1) {
                    F = d.b.g0.a.u0.g.a.a(f2.f47010a, file2, i2).f47008a;
                    i = f2.f47011b;
                } else {
                    F = d.b.g0.p.d.F(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (f46986a) {
                    d.b.g0.a.u0.g.a.d((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!F) {
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小程序bundle解压失败! PkgType=" + i);
                    if (bVar2 != null) {
                        bVar2.f45153a = aVar;
                    }
                }
                HybridUbcFlow n = i.n();
                n.A(new UbcFlowEvent("package_end_unzip"));
                n.y("app_package_version", String.valueOf(i));
                return F;
            }
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(5L);
            aVar2.h(4L);
            aVar2.e("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.f45153a = aVar2;
            }
        }
        return false;
    }

    public static synchronized boolean w(@NonNull d.b.g0.a.r1.e eVar) {
        synchronized (d.class) {
            File m = m(eVar);
            if (m == null || !m.exists()) {
                return false;
            }
            SwanAppConfigData b2 = d.b.g0.a.y0.c.a.b(m);
            if (b2 != null) {
                eVar.o0(b2);
            }
            if (d.b.g0.a.j1.m.c.d()) {
                d.b.g0.a.l1.b.a.f(b2, true);
                d.b.g0.a.l1.g.b.l(b2);
            } else {
                d.b.g0.a.l1.b.a.e(b2, true);
                d.b.g0.a.l1.g.b.k(b2);
            }
            return true;
        }
    }
}
