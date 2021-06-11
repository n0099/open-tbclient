package d.a.l0.a.m2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.a1.e;
import d.a.l0.a.e0.d;
import d.a.l0.a.h0.m.i;
import d.a.l0.a.h0.m.l;
import d.a.l0.a.j2.c;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.m2.f.b;
import d.a.l0.a.v1.b.f;
import d.a.l0.a.v2.l0;
import d.a.l0.a.v2.q;
import java.io.File;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47172a = k.f46875a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f47174f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47175g;

        public a(int i2, long j, int i3) {
            this.f47173e = i2;
            this.f47174f = j;
            this.f47175g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION);
            bVar.k(String.valueOf(this.f47173e));
            bVar.l(String.valueOf(this.f47174f));
            bVar.j(String.valueOf(this.f47175g));
            bVar.m();
        }
    }

    /* renamed from: d.a.l0.a.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0801b extends ProviderDelegation {
        @Nullable
        public static SwanCoreVersion b(Bundle bundle, int i2) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            if (i2 == 1) {
                return (SwanCoreVersion) bundle.getParcelable("aiapps_game_core");
            }
            return (SwanCoreVersion) bundle.getParcelable("aiapps_swan_core");
        }

        public SwanCoreVersion a(int i2) {
            SwanCoreVersion e2 = b.e(i2);
            if (e2.a()) {
                return e2;
            }
            d.a.l0.a.m2.e.b.b().f(i2);
            return b.e(i2);
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_swan_core", a(0));
            bundle2.putParcelable("aiapps_game_core", a(1));
            return bundle2;
        }
    }

    public static void a() {
        d.a.l0.a.m2.f.a.b(0);
        d.a.l0.a.m2.e.a.b(0);
        d.a.l0.a.m2.f.a.b(1);
        d.a.l0.a.m2.e.a.b(1);
    }

    public static void b(File file, List<Long> list) {
        File[] listFiles;
        if (file == null) {
            return;
        }
        d.h("SwanAppSwanCoreManager", "deleteOldSwanCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (f47172a) {
                    Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores versionFolder: " + file2);
                }
                if (!k(file2, list)) {
                    if (f47172a) {
                        Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores deleteFolder: " + file2);
                    }
                    d.a.l0.t.d.i(file2);
                }
            }
        }
    }

    public static boolean c() {
        return d.a.l0.a.m2.d.a.e();
    }

    public static File d(int i2) {
        File b2;
        if (i2 == 1 && (b2 = d.a.l0.a.c1.b.g().b()) != null) {
            return new File(b2, "game_core");
        }
        return new File(e.g(), "swan_core");
    }

    public static SwanCoreVersion e(int i2) {
        boolean z = i2 == 0;
        if (j() && z) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = d.a.l0.a.m2.d.a.c().getPath();
            swanCoreVersion.swanCoreType = 2;
            long b2 = d.a.l0.a.m2.d.a.b();
            swanCoreVersion.swanCoreVersionCode = b2;
            swanCoreVersion.swanCoreVersionName = l0.d(b2);
            boolean a2 = swanCoreVersion.a();
            if (f47172a) {
                Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode-debugCoreAvailable:" + a2);
            }
            if (a2) {
                return swanCoreVersion;
            }
            q(false);
        }
        SwanCoreVersion m = d.a.l0.a.m2.e.a.m(i2);
        SwanCoreVersion d2 = d.a.l0.a.m2.f.a.d(i2);
        if (f47172a) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVerName=" + m.swanCoreVersionName + ", presetVerCode=" + m.swanCoreVersionCode + ", remoteVerName=" + d2.swanCoreVersionName + ", remoteVerCode=" + d2.swanCoreVersionCode);
        }
        return (m.swanCoreVersionCode >= d2.swanCoreVersionCode || !d2.a()) ? m : d2;
    }

    public static long f(int i2) {
        SwanCoreVersion e2 = e(i2);
        if (e2 != null) {
            return e2.swanCoreVersionCode;
        }
        return 0L;
    }

    @Nullable
    public static SwanCoreVersion g(int i2) {
        if (ProcessUtils.isMainProcess()) {
            return e(i2);
        }
        f b2 = d.a.l0.a.v1.b.d.b(C0801b.class, null);
        if (f47172a) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + C0801b.b(b2.f48971a, i2));
        }
        return C0801b.b(b2.f48971a, i2);
    }

    public static String h(int i2) {
        return i(null, i2);
    }

    public static String i(SwanCoreVersion swanCoreVersion, int i2) {
        if (swanCoreVersion == null) {
            swanCoreVersion = e(i2);
        }
        if (swanCoreVersion.swanCoreVersionCode > 0) {
            return swanCoreVersion.swanCoreVersionName;
        }
        String e2 = d.a.l0.a.m2.e.a.k(i2).e();
        if (f47172a) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionName preset config: " + e2);
        }
        return TextUtils.isEmpty(e2) ? "0" : e2;
    }

    public static boolean j() {
        return h.a().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static boolean k(File file, List<Long> list) {
        if (list == null) {
            return false;
        }
        String name = file.getName();
        for (Long l : list) {
            if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                return true;
            }
        }
        return false;
    }

    public static void l(int i2, int i3) {
        if (f47172a) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i2 != i3) {
            a();
            d.a.l0.a.m2.e.a.v(true, 0);
            d.a.l0.a.m2.e.a.v(true, 1);
            d.a.l0.a.m2.e.a.w(false, 0);
            e.E(false);
        }
    }

    public static void m(int i2, int i3, long j) {
        q.j(new a(i3, j, i2), "reportZipFileCheckFailed");
    }

    public static void n(int i2) {
        o(i2, null);
    }

    public static void o(int i2, d.a.l0.a.v2.e1.b<Exception> bVar) {
        b.C0805b b2 = b.C0805b.b();
        b2.c(true);
        b2.d("openSwanApp");
        p(b2.a(), i2, bVar);
    }

    public static void p(d.a.l0.a.m2.f.b bVar, int i2, d.a.l0.a.v2.e1.b<Exception> bVar2) {
        d.a.l0.n.i.m.h hVar = new d.a.l0.n.i.m.h(i2);
        if (i2 == 0) {
            d.a.l0.n.b.j(hVar, new i(bVar2));
            return;
        }
        l p = d.a.l0.a.c1.b.i().p(bVar2);
        if (p != null) {
            d.a.l0.n.b.k(hVar, new i(null), p);
        } else if (bVar2 != null) {
            bVar2.onCallback(null);
        }
    }

    public static void q(boolean z) {
        h.a().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
    }
}
