package d.a.l0.h.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.l0.a.a1.e;
import d.a.l0.a.a1.h.a;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.r1.h;
import d.a.l0.t.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47670a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f47671b = Executors.newSingleThreadExecutor();

    /* renamed from: d.a.l0.h.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1050a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f47672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a1.b f47673f;

        public RunnableC1050a(d.a.l0.a.f1.e.b bVar, d.a.l0.a.a1.b bVar2) {
            this.f47672e = bVar;
            this.f47673f = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c j;
            d.a.l0.a.v2.a1.b bVar = new d.a.l0.a.v2.a1.b();
            if (this.f47672e.m0() && (d.a.l0.a.u1.a.a.w() || a.f47670a)) {
                j = b.a(this.f47672e, bVar);
            } else {
                j = d.j(this.f47672e, bVar);
            }
            this.f47673f.a(0, j);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static c a(d.a.l0.a.f1.e.b bVar, d.a.l0.a.v2.a1.b bVar2) {
            File b2 = b(bVar2);
            if (b2 == null) {
                return null;
            }
            e i2 = e.i();
            String b3 = f.b(b2, false);
            File d2 = d(b3);
            if (i2 == null) {
                if (!a.i(b2, d2, bVar, bVar2)) {
                    d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").F();
                    d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! for debug");
                    d.a.l0.a.q2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f45355a == null) {
                        bVar2.f45355a = aVar;
                    }
                    return null;
                }
            } else if (!TextUtils.equals(i2.T().q("installed_debug_game_bundle_md5", ""), b3)) {
                if (!a.i(b2, d2, bVar, bVar2)) {
                    d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").F();
                    d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
                    aVar2.j(5L);
                    aVar2.h(7L);
                    aVar2.e("小游戏bundle解压失败! for debug");
                    d.a.l0.a.q2.e.a().f(aVar2);
                    if (bVar2 != null && bVar2.f45355a == null) {
                        bVar2.f45355a = aVar2;
                    }
                    return null;
                }
                i2.T().B("installed_debug_game_bundle_md5", b3);
            }
            c cVar = new c();
            File file = new File(d2, "game.json");
            d.a.l0.h.c0.a.a a2 = d.a.l0.h.c0.a.a.a(d.a.l0.t.d.D(file));
            if (a2 == null) {
                return null;
            }
            cVar.f47674a = d2.getPath() + File.separator;
            cVar.f47676c = a2;
            if (!TextUtils.isEmpty(a2.f47260e)) {
                cVar.f47675b = cVar.f47674a + a2.f47260e + File.separator;
                d.a.l0.h.z.f.a().d(true);
                d.a.l0.h.z.f.a().e(cVar.f47675b);
                d.a.l0.h.z.f.a().f(a2.f47260e);
            } else {
                d.a.l0.h.z.f.a().d(false);
            }
            if (a.f47670a) {
                Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.f47674a);
                Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.f47675b);
            }
            return cVar;
        }

        public static File b(d.a.l0.a.v2.a1.b bVar) {
            File c2 = c();
            File[] listFiles = c2.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                return e(listFiles);
            }
            Context appContext = AppRuntime.getAppContext();
            d.a.l0.a.z1.b.f.e.g(appContext, c2.getPath() + " 没有测试程序包!").F();
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(5L);
            aVar.h(4L);
            aVar.e("没有小游戏包! for debug, bundle files are empty");
            d.a.l0.a.q2.e.a().f(aVar);
            if (bVar != null) {
                bVar.f45355a = aVar;
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
    public static class c extends d.a.l0.a.a1.a {

        /* renamed from: a  reason: collision with root package name */
        public String f47674a;

        /* renamed from: b  reason: collision with root package name */
        public String f47675b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.l0.h.c0.a.a f47676c;
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: d.a.l0.h.s.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C1051a implements FileFilter {
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
            }
        }

        @SuppressLint({"BDThrowableCheck"})
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
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new C1051a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (i(str2, file.getName())) {
                    if (a.f47670a) {
                        Log.i("SwanGameBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                    }
                    d.a.l0.n.g.a.h().d(str, file.getName());
                    d.a.l0.t.d.i(file);
                }
            }
        }

        public static void d(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File e2 = e(str, false);
            if (e2 != null) {
                d.a.l0.t.d.K(e2);
            }
            d.a.l0.t.d.K(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f(str, z, null);
        }

        public static File f(String str, boolean z, d.a.l0.a.v2.a1.b bVar) {
            File g2;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = g().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.f47670a && z) {
                    d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").F();
                }
                d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                aVar.j(5L);
                aVar.h(4L);
                aVar.e("没有小游戏包! for release, bundle files are empty");
                d.a.l0.a.q2.e.a().f(aVar);
                if (bVar != null) {
                    bVar.f45355a = aVar;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.f47670a && z) {
                d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), g2.getPath() + " 没有小游戏包!").F();
            }
            d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
            aVar2.j(5L);
            aVar2.h(4L);
            aVar2.e("没有小游戏包! for release, no such bundle file");
            d.a.l0.a.q2.e.a().f(aVar2);
            if (bVar != null) {
                bVar.f45355a = aVar2;
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
            if (a.f47670a) {
                Log.i("SwanGameBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return a(str, str2) > 0;
            } catch (IllegalArgumentException e2) {
                if (a.f47670a) {
                    Log.e("SwanGameBundleHelper", "比较版本号Exception：" + e2.getMessage());
                }
                return false;
            }
        }

        public static c j(d.a.l0.a.f1.e.b bVar, d.a.l0.a.v2.a1.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File h2 = h(bVar.H(), bVar.u1());
            if (!h2.exists()) {
                File f2 = f(bVar.H(), true, bVar2);
                if (f2 == null) {
                    d.a.l0.a.v1.c.e.a E = d.a.l0.a.v1.c.e.a.E();
                    SwanAppDeleteInfo swanAppDeleteInfo = new SwanAppDeleteInfo(bVar.H(), 1);
                    swanAppDeleteInfo.b(5);
                    E.O(8, swanAppDeleteInfo);
                    return null;
                }
                b(h2);
                if (!a.i(f2, h2, bVar, bVar2)) {
                    d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").F();
                    d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! for release");
                    d.a.l0.a.q2.e.a().f(aVar);
                    if (bVar2 != null && bVar2.f45355a == null) {
                        bVar2.f45355a = aVar;
                    }
                    return null;
                }
            }
            c(bVar.H(), bVar.u1());
            c cVar = new c();
            File file = new File(h2, "game.json");
            d.a.l0.h.c0.a.a a2 = d.a.l0.h.c0.a.a.a(d.a.l0.t.d.D(file));
            if (a2 == null) {
                return null;
            }
            cVar.f47674a = h2.getPath() + File.separator;
            cVar.f47676c = a2;
            if (!TextUtils.isEmpty(a2.f47260e)) {
                cVar.f47675b = cVar.f47674a + File.separator + a2.f47260e + File.separator;
                d.a.l0.h.z.f.a().d(true);
                d.a.l0.h.z.f.a().e(cVar.f47675b);
                d.a.l0.h.z.f.a().f(a2.f47260e);
            } else {
                d.a.l0.h.z.f.a().d(false);
            }
            if (a.f47670a) {
                Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.f47674a);
                Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.f47675b);
            }
            return cVar;
        }
    }

    public static void c(d.a.l0.a.f1.e.b bVar, d.a.l0.a.a1.b bVar2) {
        f47671b.execute(new RunnableC1050a(bVar, bVar2));
    }

    public static File d() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File e(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void f(String str, e.c cVar) {
        e.d dVar = new e.d();
        dVar.f40690a = str;
        d.a.l0.h.m.b.b.a();
        new d.a.l0.a.k0.a().e(dVar, d.a.l0.h.m.b.b.c().getPath(), cVar);
    }

    public static void g(String str, e.c cVar) {
        e.d dVar = new e.d();
        dVar.f40690a = str;
        d.a.l0.h.p.a.b.a();
        new d.a.l0.a.k0.a().e(dVar, d.a.l0.h.p.a.b.c().getPath(), cVar);
    }

    public static void h(e.d dVar, e.c cVar) {
        File c2 = b.c();
        new d.a.l0.a.k0.a().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
    }

    public static boolean i(File file, File file2, d.a.l0.a.f1.e.b bVar, d.a.l0.a.v2.a1.b bVar2) {
        boolean T;
        int i2 = 0;
        if (file != null && file2 != null) {
            if (file.exists() && file.length() != 0) {
                h.o().C(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                a.b i3 = d.a.l0.a.a1.h.a.i(file);
                int i4 = i3.f40715b;
                if (i4 != -1) {
                    T = d.a.l0.a.a1.h.a.c(i3.f40714a, file2, i4).f40712a;
                    i2 = i3.f40715b;
                } else {
                    T = d.a.l0.t.d.T(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (f47670a) {
                    d.a.l0.a.a1.h.a.g((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!T) {
                    d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(7L);
                    aVar.e("小游戏bundle解压失败! PkgType=" + i2);
                    if (bVar2 != null) {
                        bVar2.f45355a = aVar;
                    }
                }
                HybridUbcFlow o = h.o();
                o.C(new UbcFlowEvent("package_end_unzip"));
                o.A("app_package_version", String.valueOf(i2));
                return T;
            }
            d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
            aVar2.j(5L);
            aVar2.h(4L);
            aVar2.e("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.f45355a = aVar2;
            }
        }
        return false;
    }
}
