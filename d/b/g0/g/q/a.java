package d.b.g0.g.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.u0.d;
import d.b.g0.a.u0.g.a;
import d.b.g0.g.x.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48933a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f48934b = Executors.newSingleThreadExecutor();

    /* renamed from: d.b.g0.g.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1000a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f48935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.u0.b f48936f;

        public RunnableC1000a(d.b.g0.a.y0.e.b bVar, d.b.g0.a.u0.b bVar2) {
            this.f48935e = bVar;
            this.f48936f = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c j;
            d.b.g0.a.i2.r0.b bVar = new d.b.g0.a.i2.r0.b();
            if (this.f48935e.j0() && (d.b.g0.a.m1.a.a.u() || a.f48933a)) {
                j = b.a(this.f48935e, bVar);
            } else {
                j = d.j(this.f48935e, bVar);
            }
            this.f48936f.a(0, j);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static c a(d.b.g0.a.y0.e.b bVar, d.b.g0.a.i2.r0.b bVar2) {
            File b2 = b(bVar2);
            if (b2 == null) {
                return null;
            }
            e y = e.y();
            String b3 = d.b.g0.p.e.b(b2, false);
            File d2 = d(b3);
            if (y == null) {
                if (!a.i(b2, d2, bVar, bVar2)) {
                    d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小游戏bundle解压失败!").C();
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! for debug");
                    d.b.g0.a.f2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f45153a == null) {
                        bVar2.f45153a = aVar;
                    }
                    return null;
                }
            } else if (!TextUtils.equals(y.R().p("installed_debug_game_bundle_md5", ""), b3)) {
                if (!a.i(b2, d2, bVar, bVar2)) {
                    d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小游戏bundle解压失败!").C();
                    d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
                    aVar2.j(5L);
                    aVar2.h(7L);
                    aVar2.e("小游戏bundle解压失败! for debug");
                    d.b.g0.a.f2.e.a().f(aVar2);
                    if (bVar2 != null && bVar2.f45153a == null) {
                        bVar2.f45153a = aVar2;
                    }
                    return null;
                }
                y.R().A("installed_debug_game_bundle_md5", b3);
            }
            c cVar = new c();
            File file = new File(d2, "game.json");
            d.b.g0.g.z.a.a a2 = d.b.g0.g.z.a.a.a(d.b.g0.p.d.r(file));
            if (a2 == null) {
                return null;
            }
            cVar.f48937a = d2.getPath() + File.separator;
            cVar.f48939c = a2;
            if (!TextUtils.isEmpty(a2.f49090e)) {
                cVar.f48938b = cVar.f48937a + a2.f49090e + File.separator;
                f.a().d(true);
                f.a().e(cVar.f48938b);
                f.a().f(a2.f49090e);
            } else {
                f.a().d(false);
            }
            if (a.f48933a) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + cVar.f48937a);
                Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + cVar.f48938b);
            }
            return cVar;
        }

        public static File b(d.b.g0.a.i2.r0.b bVar) {
            File c2 = c();
            File[] listFiles = c2.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                return e(listFiles);
            }
            Context appContext = AppRuntime.getAppContext();
            d.b.g0.a.q1.b.f.d.f(appContext, c2.getPath() + " 没有测试程序包!").C();
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(5L);
            aVar.h(4L);
            aVar.e("没有小游戏包! for debug, bundle files are empty");
            d.b.g0.a.f2.e.a().f(aVar);
            if (bVar != null) {
                bVar.f45153a = aVar;
                return null;
            }
            return null;
        }

        public static File c() {
            File e2 = a.e("aigames_debug");
            if (!e2.exists()) {
                e2.mkdirs();
            }
            return e2;
        }

        public static File d(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File e(File[] fileArr) {
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
    public static class c extends d.b.g0.a.u0.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48937a;

        /* renamed from: b  reason: collision with root package name */
        public String f48938b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.g0.g.z.a.a f48939c;
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: d.b.g0.g.q.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C1001a implements FileFilter {
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
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new C1001a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (i(str2, file.getName())) {
                    if (a.f48933a) {
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
            d.b.g0.p.d.f(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f(str, z, null);
        }

        public static File f(String str, boolean z, d.b.g0.a.i2.r0.b bVar) {
            File g2;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = g().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.f48933a && z) {
                    d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").C();
                }
                d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                aVar.j(5L);
                aVar.h(4L);
                aVar.e("没有小游戏包! for release, bundle files are empty");
                d.b.g0.a.f2.e.a().f(aVar);
                if (bVar != null) {
                    bVar.f45153a = aVar;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.f48933a && z) {
                d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").C();
            }
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(5L);
            aVar2.h(4L);
            aVar2.e("没有小游戏包! for release, no such bundle file");
            d.b.g0.a.f2.e.a().f(aVar2);
            if (bVar != null) {
                bVar.f45153a = aVar2;
            }
            return null;
        }

        public static File g() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File h(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static boolean i(String str, String str2) {
            if (a.f48933a) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return a(str, str2) > 0;
            } catch (IllegalArgumentException e2) {
                if (a.f48933a) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e2.getMessage());
                }
                return false;
            }
        }

        public static c j(d.b.g0.a.y0.e.b bVar, d.b.g0.a.i2.r0.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File h2 = h(bVar.G(), bVar.n1());
            if (!h2.exists()) {
                File f2 = f(bVar.G(), true, bVar2);
                if (f2 == null) {
                    d.b.g0.a.n1.c.e.a C = d.b.g0.a.n1.c.e.a.C();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(bVar.G(), 1);
                    swanAppDeleteInfo.b(5);
                    C.M(8, swanAppDeleteInfo);
                    return null;
                }
                b(h2);
                if (!a.i(f2, h2, bVar, bVar2)) {
                    d.b.g0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小游戏bundle解压失败!").C();
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! for release");
                    d.b.g0.a.f2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f45153a == null) {
                        bVar2.f45153a = aVar;
                    }
                    return null;
                }
            }
            c(bVar.G(), bVar.n1());
            c cVar = new c();
            File file = new File(h2, "game.json");
            d.b.g0.g.z.a.a a2 = d.b.g0.g.z.a.a.a(d.b.g0.p.d.r(file));
            if (a2 == null) {
                return null;
            }
            cVar.f48937a = h2.getPath() + File.separator;
            cVar.f48939c = a2;
            if (!TextUtils.isEmpty(a2.f49090e)) {
                cVar.f48938b = cVar.f48937a + File.separator + a2.f49090e + File.separator;
                f.a().d(true);
                f.a().e(cVar.f48938b);
                f.a().f(a2.f49090e);
            } else {
                f.a().d(false);
            }
            if (a.f48933a) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + cVar.f48937a);
                Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + cVar.f48938b);
            }
            return cVar;
        }
    }

    public static void c(d.b.g0.a.y0.e.b bVar, d.b.g0.a.u0.b bVar2) {
        f48934b.execute(new RunnableC1000a(bVar, bVar2));
    }

    public static File d() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File e(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void f(String str, d.c cVar) {
        d.C0861d c0861d = new d.C0861d();
        c0861d.f46991a = str;
        d.b.g0.g.k.a.b.a();
        new d.b.g0.a.h0.a().e(c0861d, d.b.g0.g.k.a.b.c().getPath(), cVar);
    }

    public static void g(String str, d.c cVar) {
        d.C0861d c0861d = new d.C0861d();
        c0861d.f46991a = str;
        d.b.g0.g.n.a.b.a();
        new d.b.g0.a.h0.a().e(c0861d, d.b.g0.g.n.a.b.c().getPath(), cVar);
    }

    public static void h(d.C0861d c0861d, d.c cVar) {
        File c2 = b.c();
        new d.b.g0.a.h0.a().e(c0861d, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
    }

    public static boolean i(File file, File file2, d.b.g0.a.y0.e.b bVar, d.b.g0.a.i2.r0.b bVar2) {
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
                if (f48933a) {
                    d.b.g0.a.u0.g.a.d((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!F) {
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! PkgType=" + i);
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
            aVar2.e("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.f45153a = aVar2;
            }
        }
        return false;
    }
}
