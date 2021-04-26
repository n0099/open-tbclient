package d.a.h0.a.b2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.b2.f.b;
import d.a.h0.a.e0.p.i;
import d.a.h0.a.k;
import d.a.h0.l.c;
import d.a.h0.p.d;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41573a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a extends ProviderDelegation {
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
            SwanCoreVersion d2 = b.d(i2);
            if (d2.a()) {
                return d2;
            }
            d.a.h0.a.b2.e.b.b().f(i2);
            return b.d(i2);
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_swan_core", a(0));
            bundle2.putParcelable("aiapps_game_core", a(1));
            return bundle2;
        }
    }

    public static void a(File file, List<Long> list) {
        File[] listFiles;
        if (file == null) {
            return;
        }
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
        }
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (f41573a) {
                    Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores versionFolder: " + file2);
                }
                if (!j(file2, list)) {
                    if (f41573a) {
                        Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores deleteFolder: " + file2);
                    }
                    d.f(file2);
                }
            }
        }
    }

    public static boolean b() {
        return d.a.h0.a.b2.d.a.e();
    }

    public static File c(int i2) {
        if (i2 == 1) {
            return new File(d.a.h0.g.q.a.d(), "game_core");
        }
        return new File(d.a.h0.a.u0.d.d(), "swan_core");
    }

    public static SwanCoreVersion d(int i2) {
        long e2 = d.a.h0.a.b2.e.a.e(i2);
        long d2 = d.a.h0.a.b2.f.a.d(i2);
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVer: " + e2 + " ,remoteVer: " + d2);
        }
        boolean z = i2 == 0;
        if (!i() || !z) {
            if (e2 >= d2) {
                return d.a.h0.a.b2.e.a.k(i2, e2);
            }
            SwanCoreVersion g2 = d.a.h0.a.b2.f.a.g(i2, d2);
            return !g2.a() ? d.a.h0.a.b2.e.a.k(i2, e2) : g2;
        }
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = d.a.h0.a.b2.d.a.c().getPath();
        swanCoreVersion.swanCoreType = 2;
        swanCoreVersion.swanCoreVersion = d.a.h0.a.b2.d.a.b();
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode");
        }
        return swanCoreVersion;
    }

    @Nullable
    public static SwanCoreVersion e(int i2) {
        if (ProcessUtils.isMainProcess()) {
            return d(i2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null);
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + a.b(callOnMainWithContentProvider.mResult, i2));
        }
        return a.b(callOnMainWithContentProvider.mResult, i2);
    }

    public static String f(int i2) {
        return g(null, i2);
    }

    public static String g(SwanCoreVersion swanCoreVersion, int i2) {
        if (swanCoreVersion == null) {
            swanCoreVersion = d(i2);
        }
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString version: " + swanCoreVersion.swanCoreVersion);
        }
        long j = swanCoreVersion.swanCoreVersion;
        if (j > 0) {
            return q(j);
        }
        String b2 = d.a.h0.a.b2.e.a.i(i2).b();
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionString preset config: " + b2);
        }
        return TextUtils.isEmpty(b2) ? "0" : b2;
    }

    public static long h(String str) {
        String[] p = p(str);
        if (p == null) {
            return 0L;
        }
        int i2 = 0;
        long j = 0;
        while (i2 < 3) {
            try {
                j = (j << 16) | (i2 < p.length ? Integer.parseInt(p[i2]) : 0L);
                i2++;
            } catch (NumberFormatException e2) {
                if (f41573a) {
                    throw e2;
                }
                return 0L;
            }
        }
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "getVersion version: " + str + " ,versionCode: " + j);
        }
        return j;
    }

    public static boolean i() {
        return h.a().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
    }

    public static boolean j(File file, List<Long> list) {
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

    public static void k(int i2, int i3) {
        if (f41573a) {
            Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i2 != i3) {
            d.a.h0.a.b2.f.a.b(0);
            d.a.h0.a.b2.e.a.a(0);
            d.a.h0.a.b2.e.a.q(true, 0);
            d.a.h0.a.b2.e.a.q(true, 1);
        }
    }

    public static void l(int i2) {
        m(i2, null);
    }

    public static void m(int i2, d.a.h0.a.i2.u0.b<Exception> bVar) {
        b.C0588b b2 = b.C0588b.b();
        b2.c(true);
        b2.d("openSwanApp");
        n(b2.a(), i2, bVar);
    }

    public static void n(d.a.h0.a.b2.f.b bVar, int i2, d.a.h0.a.i2.u0.b<Exception> bVar2) {
        d.a.h0.l.l.k.h hVar = new d.a.h0.l.l.k.h(i2);
        if (i2 == 0) {
            c.h(hVar, new i(bVar2));
        } else {
            c.i(hVar, new i(null), new d.a.h0.g.n.b.a(bVar2));
        }
    }

    public static void o(boolean z) {
        h.a().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
    }

    public static String[] p(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        if (split.length != 3) {
            return null;
        }
        return split;
    }

    public static String q(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 2; i2 >= 0; i2--) {
            sb.append((j >> (i2 * 16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
            if (i2 > 0) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (f41573a) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("version code: ");
            sb3.append(j);
            sb3.append(" ,version name: ");
            sb3.append((Object) sb);
            sb3.append(" equals: ");
            sb3.append(j == h(sb2));
            Log.d("SwanAppSwanCoreManager", sb3.toString());
        }
        return sb2;
    }
}
