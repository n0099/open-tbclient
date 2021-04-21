package d.b.h0.a.b2.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.c0.c;
import d.b.h0.a.k;
import d.b.h0.p.d;
import d.b.h0.p.e;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44293a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static C0646a f44294b;

    /* renamed from: c  reason: collision with root package name */
    public static C0646a f44295c;

    /* renamed from: d.b.h0.a.b2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0646a {

        /* renamed from: a  reason: collision with root package name */
        public String f44296a;

        public static String a(int i) {
            return i == 1 ? "game-core-version" : "swan-core-version";
        }

        public static C0646a c(JSONObject jSONObject, int i) {
            C0646a c0646a = new C0646a();
            if (jSONObject != null) {
                c0646a.f44296a = jSONObject.optString(a(i));
            }
            return c0646a;
        }

        public String b() {
            return TextUtils.isEmpty(this.f44296a) ? "0" : this.f44296a;
        }
    }

    public static void a(int i) {
        h.a().putLong(m(i), 0L);
    }

    public static Exception b(long j, int i) {
        c.h("PresetSwanCoreControl", "doPresetUpdate.");
        String f2 = f(i);
        if (!d.G(f2, j(j, i).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + f2);
            c.i("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        d.b.h0.a.b2.b.a(h(i), arrayList);
        h.a().putLong(m(i), j);
        if (i == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        q(false, i);
        if (f44293a) {
            String b2 = e.b(new File(f(i)), false);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            h.a().putString(d.b.h0.a.b2.a.d(i), b2);
            return null;
        }
        return null;
    }

    public static C0646a c() {
        if (f44294b == null) {
            f44294b = C0646a.c(p(0), 0);
        }
        return f44294b;
    }

    public static String d(int i) {
        return i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    public static long e(int i) {
        return h.a().getLong(m(i), 0L);
    }

    public static String f(int i) {
        return i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    public static C0646a g() {
        if (f44295c == null) {
            f44295c = C0646a.c(p(1), 1);
        }
        return f44295c;
    }

    public static File h(int i) {
        return new File(d.b.h0.a.b2.b.c(i), "preset");
    }

    public static C0646a i(int i) {
        if (i == 1) {
            return g();
        }
        return c();
    }

    public static File j(long j, int i) {
        return new File(h(i), String.valueOf(j));
    }

    public static SwanCoreVersion k(int i, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = j(j, i).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static String l(int i) {
        return i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static String m(int i) {
        return i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    public static boolean n(int i) {
        return h.a().getBoolean(l(i), false) || !k(i, e(i)).a();
    }

    public static synchronized Exception o(int i) {
        synchronized (a.class) {
            if (f44293a) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (n(i)) {
                C0646a i2 = i(i);
                long j = h.a().getLong(f(i), 0L);
                long h2 = d.b.h0.a.b2.b.h(i2.b());
                if (f44293a) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + h2);
                }
                return b(h2, i);
            }
            return null;
        }
    }

    public static JSONObject p(int i) {
        if (f44293a) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String q = d.q(AppRuntime.getAppContext(), d(i));
        if (TextUtils.isEmpty(q)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            if (f44293a) {
                Log.d("PresetSwanCoreControl", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f44293a) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }

    public static void q(boolean z, int i) {
        h.a().putBoolean(l(i), z);
    }
}
