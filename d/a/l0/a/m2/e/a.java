package d.a.l0.a.m2.e;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.a1.e;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.t.f;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43503a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static C0746a f43504b;

    /* renamed from: c  reason: collision with root package name */
    public static C0746a f43505c;

    /* renamed from: d.a.l0.a.m2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0746a {

        /* renamed from: a  reason: collision with root package name */
        public String f43506a;

        /* renamed from: b  reason: collision with root package name */
        public long f43507b;

        public static String b(int i2) {
            return i2 == 1 ? "game-core-version-code" : "swan-core-version-code";
        }

        public static String c(int i2) {
            return i2 == 1 ? "game-core-version-name" : "swan-core-version-name";
        }

        public static C0746a f(JSONObject jSONObject, int i2) {
            C0746a c0746a = new C0746a();
            if (jSONObject != null) {
                c0746a.f43506a = jSONObject.optString(c(i2));
                c0746a.f43507b = jSONObject.optLong(b(i2));
            }
            return c0746a;
        }

        public long d() {
            return this.f43507b;
        }

        public String e() {
            return TextUtils.isEmpty(this.f43506a) ? "0" : this.f43506a;
        }
    }

    public static boolean a(String str) {
        d.h("PresetSwanCoreControl", "canPresetFolderWrite presetSavePath=" + str);
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            d.h("PresetSwanCoreControl", "canPresetFolderWrite mkdirs fail");
            return false;
        }
        boolean canWrite = file.canWrite();
        d.h("PresetSwanCoreControl", "canPresetFolderWrite canWrite=" + canWrite);
        return canWrite;
    }

    public static void b(int i2) {
        h.a().putString(p(i2), "0");
        h.a().putLong(o(i2), 0L);
    }

    public static Exception c(C0746a c0746a, int i2) {
        d.h("PresetSwanCoreControl", "doPresetUpdate.");
        if (c0746a == null) {
            return new Exception("preset swan config is null");
        }
        String h2 = h(i2);
        String path = l(c0746a.d(), i2).getPath();
        if (!d.a.l0.t.d.U(h2, path)) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + h2);
            d.h("PresetSwanCoreControl", "doPresetUpdate unzip failed assetExists: " + d.a.l0.a.v2.h.a(AppRuntime.getAppContext(), h2) + ";" + exc);
            boolean a2 = a(path);
            if (i2 == 0 && Looper.myLooper() != Looper.getMainLooper() && !e.w() && !a2) {
                d.h("PresetSwanCoreControl", "doSwanFolderFallback:start.");
                e.e("swan_core" + File.separator + "preset" + File.separator + c0746a.d());
            }
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(c0746a.d()));
        d.a.l0.a.m2.b.b(j(i2), arrayList);
        h.a().putLong(o(i2), c0746a.d());
        h.a().putString(p(i2), c0746a.e());
        if (i2 == 0) {
            SwanJSVersionUpdateEvent.sendEvent(c0746a.d());
        }
        v(false, i2);
        if (f43503a) {
            String b2 = f.b(new File(h(i2)), false);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            h.a().putString(d.a.l0.a.m2.a.d(i2), b2);
            return null;
        }
        return null;
    }

    public static C0746a d() {
        if (f43504b == null) {
            f43504b = C0746a.f(u(0), 0);
        }
        return f43504b;
    }

    public static String e(int i2) {
        return i2 == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    public static long f(int i2) {
        return h.a().getLong(o(i2), 0L);
    }

    public static String g(int i2) {
        return h.a().getString(p(i2), "0");
    }

    public static String h(int i2) {
        return i2 == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    public static C0746a i() {
        if (f43505c == null) {
            f43505c = C0746a.f(u(1), 1);
        }
        return f43505c;
    }

    public static File j(int i2) {
        return new File(d.a.l0.a.m2.b.d(i2), "preset");
    }

    public static C0746a k(int i2) {
        if (i2 == 1) {
            return i();
        }
        return d();
    }

    public static File l(long j, int i2) {
        return new File(j(i2), String.valueOf(j));
    }

    public static SwanCoreVersion m(int i2) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersionCode = f(i2);
        swanCoreVersion.swanCoreVersionName = g(i2);
        swanCoreVersion.swanCorePath = l(swanCoreVersion.swanCoreVersionCode, i2).getPath();
        return swanCoreVersion;
    }

    public static String n(int i2) {
        return i2 == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static String o(int i2) {
        return i2 == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    public static String p(int i2) {
        return i2 == 1 ? "aigames_cur_preset_ver_name_key" : "aiapps_cur_preset_ver_name_key";
    }

    public static boolean q(int i2) {
        if (k(i2).f43507b > 0) {
            return h.a().getBoolean(n(i2), false) || !m(i2).a();
        }
        return false;
    }

    public static boolean r(int i2) {
        return h.a().getBoolean(i2 == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", false);
    }

    public static synchronized void s(int i2) {
        synchronized (a.class) {
            C0746a k = k(i2);
            String h2 = h(i2);
            String path = l(k.d(), i2).getPath();
            boolean y = d.a.l0.t.d.y(h2, path);
            if (f43503a) {
                Log.d("PresetSwanCoreControl", "isZipAssetMatchUnzipResult:" + y + ",path:" + path);
            }
            if (!y) {
                d.a.l0.a.m2.b.m(0, i2, k.d());
                d.a.l0.t.d.L(path);
                d.a.l0.t.d.U(h2, path);
            }
        }
    }

    public static synchronized Exception t(int i2) {
        synchronized (a.class) {
            if (f43503a) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (q(i2)) {
                C0746a k = k(i2);
                long j = h.a().getLong(h(i2), 0L);
                if (f43503a) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + k.e());
                }
                return c(k, i2);
            }
            return null;
        }
    }

    public static JSONObject u(int i2) {
        if (f43503a) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String C = d.a.l0.t.d.C(AppRuntime.getAppContext(), e(i2));
        if (TextUtils.isEmpty(C)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(C);
            if (f43503a) {
                Log.d("PresetSwanCoreControl", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f43503a) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }

    public static void v(boolean z, int i2) {
        h.a().putBoolean(n(i2), z);
    }

    public static void w(boolean z, int i2) {
        h.a().putBoolean(i2 == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", z);
    }
}
