package d.b.h0.g.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.h0.a.j1.i;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.u0.d;
import d.b.h0.a.u0.g.a;
import d.b.h0.g.x.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49262a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f49263b = Executors.newSingleThreadExecutor();

    /* renamed from: d.b.h0.g.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1020a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f49264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.u0.b f49265f;

        public RunnableC1020a(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
            this.f49264e = bVar;
            this.f49265f = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c j;
            d.b.h0.a.i2.r0.b bVar = new d.b.h0.a.i2.r0.b();
            if (this.f49264e.j0() && (d.b.h0.a.m1.a.a.u() || a.f49262a)) {
                j = b.a(this.f49264e, bVar);
            } else {
                j = d.j(this.f49264e, bVar);
            }
            this.f49265f.a(0, j);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static c a(d.b.h0.a.y0.e.b bVar, d.b.h0.a.i2.r0.b bVar2) {
            File b2 = b(bVar2);
            if (b2 == null) {
                return null;
            }
            e y = e.y();
            String b3 = d.b.h0.p.e.b(b2, false);
            File d2 = d(b3);
            if (y == null) {
                if (!a.i(b2, d2, bVar, bVar2)) {
                    d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小游戏bundle解压失败!").C();
                    d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! for debug");
                    d.b.h0.a.f2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f45482a == null) {
                        bVar2.f45482a = aVar;
                    }
                    return null;
                }
            } else if (!TextUtils.equals(y.R().p("installed_debug_game_bundle_md5", ""), b3)) {
                if (!a.i(b2, d2, bVar, bVar2)) {
                    d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小游戏bundle解压失败!").C();
                    d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
                    aVar2.j(5L);
                    aVar2.h(7L);
                    aVar2.e("小游戏bundle解压失败! for debug");
                    d.b.h0.a.f2.e.a().f(aVar2);
                    if (bVar2 != null && bVar2.f45482a == null) {
                        bVar2.f45482a = aVar2;
                    }
                    return null;
                }
                y.R().A("installed_debug_game_bundle_md5", b3);
            }
            c cVar = new c();
            File file = new File(d2, "game.json");
            d.b.h0.g.z.a.a a2 = d.b.h0.g.z.a.a.a(d.b.h0.p.d.r(file));
            if (a2 == null) {
                return null;
            }
            cVar.f49266a = d2.getPath() + File.separator;
            cVar.f49268c = a2;
            if (!TextUtils.isEmpty(a2.f49419e)) {
                cVar.f49267b = cVar.f49266a + a2.f49419e + File.separator;
                f.a().d(true);
                f.a().e(cVar.f49267b);
                f.a().f(a2.f49419e);
            } else {
                f.a().d(false);
            }
            if (a.f49262a) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + cVar.f49266a);
                Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + cVar.f49267b);
            }
            return cVar;
        }

        public static File b(d.b.h0.a.i2.r0.b bVar) {
            File c2 = c();
            File[] listFiles = c2.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                return e(listFiles);
            }
            Context appContext = AppRuntime.getAppContext();
            d.b.h0.a.q1.b.f.d.f(appContext, c2.getPath() + " 没有测试程序包!").C();
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(5L);
            aVar.h(4L);
            aVar.e("没有小游戏包! for debug, bundle files are empty");
            d.b.h0.a.f2.e.a().f(aVar);
            if (bVar != null) {
                bVar.f45482a = aVar;
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
    public static class c extends d.b.h0.a.u0.a {

        /* renamed from: a  reason: collision with root package name */
        public String f49266a;

        /* renamed from: b  reason: collision with root package name */
        public String f49267b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.h0.g.z.a.a f49268c;
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: d.b.h0.g.q.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C1021a implements FileFilter {
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
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new C1021a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (i(str2, file.getName())) {
                    if (a.f49262a) {
                        Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                    }
                    d.b.h0.l.i.a.h().d(str, file.getName());
                    d.b.h0.p.d.f(file);
                }
            }
        }

        public static void d(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File e2 = e(str, false);
            if (e2 != null) {
                d.b.h0.p.d.f(e2);
            }
            d.b.h0.p.d.f(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f(str, z, null);
        }

        public static File f(String str, boolean z, d.b.h0.a.i2.r0.b bVar) {
            File g2;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = g().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.f49262a && z) {
                    d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").C();
                }
                d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
                aVar.j(5L);
                aVar.h(4L);
                aVar.e("没有小游戏包! for release, bundle files are empty");
                d.b.h0.a.f2.e.a().f(aVar);
                if (bVar != null) {
                    bVar.f45482a = aVar;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.f49262a && z) {
                d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").C();
            }
            d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
            aVar2.j(5L);
            aVar2.h(4L);
            aVar2.e("没有小游戏包! for release, no such bundle file");
            d.b.h0.a.f2.e.a().f(aVar2);
            if (bVar != null) {
                bVar.f45482a = aVar2;
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
            if (a.f49262a) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return a(str, str2) > 0;
            } catch (IllegalArgumentException e2) {
                if (a.f49262a) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e2.getMessage());
                }
                return false;
            }
        }

        public static c j(d.b.h0.a.y0.e.b bVar, d.b.h0.a.i2.r0.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File h2 = h(bVar.G(), bVar.n1());
            if (!h2.exists()) {
                File f2 = f(bVar.G(), true, bVar2);
                if (f2 == null) {
                    d.b.h0.a.n1.c.e.a C = d.b.h0.a.n1.c.e.a.C();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(bVar.G(), 1);
                    swanAppDeleteInfo.b(5);
                    C.M(8, swanAppDeleteInfo);
                    return null;
                }
                b(h2);
                if (!a.i(f2, h2, bVar, bVar2)) {
                    d.b.h0.a.q1.b.f.d.f(AppRuntime.getAppContext(), "小游戏bundle解压失败!").C();
                    d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! for release");
                    d.b.h0.a.f2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f45482a == null) {
                        bVar2.f45482a = aVar;
                    }
                    return null;
                }
            }
            c(bVar.G(), bVar.n1());
            c cVar = new c();
            File file = new File(h2, "game.json");
            d.b.h0.g.z.a.a a2 = d.b.h0.g.z.a.a.a(d.b.h0.p.d.r(file));
            if (a2 == null) {
                return null;
            }
            cVar.f49266a = h2.getPath() + File.separator;
            cVar.f49268c = a2;
            if (!TextUtils.isEmpty(a2.f49419e)) {
                cVar.f49267b = cVar.f49266a + File.separator + a2.f49419e + File.separator;
                f.a().d(true);
                f.a().e(cVar.f49267b);
                f.a().f(a2.f49419e);
            } else {
                f.a().d(false);
            }
            if (a.f49262a) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + cVar.f49266a);
                Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + cVar.f49267b);
            }
            return cVar;
        }
    }

    public static void c(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        f49263b.execute(new RunnableC1020a(bVar, bVar2));
    }

    public static File d() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File e(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void f(String str, d.c cVar) {
        d.C0881d c0881d = new d.C0881d();
        c0881d.f47320a = str;
        d.b.h0.g.k.a.b.a();
        new d.b.h0.a.h0.a().e(c0881d, d.b.h0.g.k.a.b.c().getPath(), cVar);
    }

    public static void g(String str, d.c cVar) {
        d.C0881d c0881d = new d.C0881d();
        c0881d.f47320a = str;
        d.b.h0.g.n.a.b.a();
        new d.b.h0.a.h0.a().e(c0881d, d.b.h0.g.n.a.b.c().getPath(), cVar);
    }

    public static void h(d.C0881d c0881d, d.c cVar) {
        File c2 = b.c();
        new d.b.h0.a.h0.a().e(c0881d, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
    }

    public static boolean i(File file, File file2, d.b.h0.a.y0.e.b bVar, d.b.h0.a.i2.r0.b bVar2) {
        boolean F;
        int i = 0;
        if (file != null && file2 != null) {
            if (file.exists() && file.length() != 0) {
                i.n().A(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                a.b f2 = d.b.h0.a.u0.g.a.f(file);
                int i2 = f2.f47340b;
                if (i2 != -1) {
                    F = d.b.h0.a.u0.g.a.a(f2.f47339a, file2, i2).f47337a;
                    i = f2.f47340b;
                } else {
                    F = d.b.h0.p.d.F(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (f49262a) {
                    d.b.h0.a.u0.g.a.d((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!F) {
                    d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! PkgType=" + i);
                    if (bVar2 != null) {
                        bVar2.f45482a = aVar;
                    }
                }
                HybridUbcFlow n = i.n();
                n.A(new UbcFlowEvent("package_end_unzip"));
                n.y("app_package_version", String.valueOf(i));
                return F;
            }
            d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
            aVar2.j(5L);
            aVar2.h(4L);
            aVar2.e("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.f45482a = aVar2;
            }
        }
        return false;
    }
}
