package d.a.h0.a.b2.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.c0.c;
import d.a.h0.a.k;
import d.a.h0.p.d;
import d.a.h0.p.e;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41577a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static C0585a f41578b;

    /* renamed from: c  reason: collision with root package name */
    public static C0585a f41579c;

    /* renamed from: d.a.h0.a.b2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0585a {

        /* renamed from: a  reason: collision with root package name */
        public String f41580a;

        public static String a(int i2) {
            return i2 == 1 ? "game-core-version" : "swan-core-version";
        }

        public static C0585a c(JSONObject jSONObject, int i2) {
            C0585a c0585a = new C0585a();
            if (jSONObject != null) {
                c0585a.f41580a = jSONObject.optString(a(i2));
            }
            return c0585a;
        }

        public String b() {
            return TextUtils.isEmpty(this.f41580a) ? "0" : this.f41580a;
        }
    }

    public static void a(int i2) {
        h.a().putLong(m(i2), 0L);
    }

    public static Exception b(long j, int i2) {
        c.h("PresetSwanCoreControl", "doPresetUpdate.");
        String f2 = f(i2);
        if (!d.G(f2, j(j, i2).getPath())) {
            Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + f2);
            c.i("PresetSwanCoreControl", "doPresetUpdate unzip failed: ", exc);
            return exc;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        d.a.h0.a.b2.b.a(h(i2), arrayList);
        h.a().putLong(m(i2), j);
        if (i2 == 0) {
            SwanJSVersionUpdateEvent.sendEvent(j);
        }
        q(false, i2);
        if (f41577a) {
            String b2 = e.b(new File(f(i2)), false);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            h.a().putString(d.a.h0.a.b2.a.d(i2), b2);
            return null;
        }
        return null;
    }

    public static C0585a c() {
        if (f41578b == null) {
            f41578b = C0585a.c(p(0), 0);
        }
        return f41578b;
    }

    public static String d(int i2) {
        return i2 == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json";
    }

    public static long e(int i2) {
        return h.a().getLong(m(i2), 0L);
    }

    public static String f(int i2) {
        return i2 == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip";
    }

    public static C0585a g() {
        if (f41579c == null) {
            f41579c = C0585a.c(p(1), 1);
        }
        return f41579c;
    }

    public static File h(int i2) {
        return new File(d.a.h0.a.b2.b.c(i2), "preset");
    }

    public static C0585a i(int i2) {
        if (i2 == 1) {
            return g();
        }
        return c();
    }

    public static File j(long j, int i2) {
        return new File(h(i2), String.valueOf(j));
    }

    public static SwanCoreVersion k(int i2, long j) {
        SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
        swanCoreVersion.swanCorePath = j(j, i2).getPath();
        swanCoreVersion.swanCoreType = 0;
        swanCoreVersion.swanCoreVersion = j;
        return swanCoreVersion;
    }

    public static String l(int i2) {
        return i2 == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key";
    }

    public static String m(int i2) {
        return i2 == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key";
    }

    public static boolean n(int i2) {
        return h.a().getBoolean(l(i2), false) || !k(i2, e(i2)).a();
    }

    public static synchronized Exception o(int i2) {
        synchronized (a.class) {
            if (f41577a) {
                Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
            }
            if (n(i2)) {
                C0585a i3 = i(i2);
                long j = h.a().getLong(f(i2), 0L);
                long h2 = d.a.h0.a.b2.b.h(i3.b());
                if (f41577a) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + h2);
                }
                return b(h2, i2);
            }
            return null;
        }
    }

    public static JSONObject p(int i2) {
        if (f41577a) {
            Log.d("PresetSwanCoreControl", "readPresetConfig start.");
        }
        String q = d.q(AppRuntime.getAppContext(), d(i2));
        if (TextUtils.isEmpty(q)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            if (f41577a) {
                Log.d("PresetSwanCoreControl", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f41577a) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }

    public static void q(boolean z, int i2) {
        h.a().putBoolean(l(i2), z);
    }
}
