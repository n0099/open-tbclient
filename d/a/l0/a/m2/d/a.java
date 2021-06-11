package d.a.l0.a.m2.d;

import android.text.TextUtils;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.v2.l0;
import d.a.l0.t.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47178a = k.f46875a;

    public static void a() {
        File c2 = c();
        if (c2.exists()) {
            d.i(c2);
        }
    }

    public static long b() {
        return h.a().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static File c() {
        return new File(d.a.l0.a.f1.c.a.d().get(0).f49097a, "/aiapps_debug_swan_core/");
    }

    public static File d() {
        File c2 = c();
        if (!c2.exists()) {
            c2.mkdirs();
        }
        return new File(c2, "debugSwanCore.zip");
    }

    public static boolean e() {
        File file = new File(c().getPath(), "pkginfo.json");
        if (file.exists()) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(d.D(file));
            } catch (JSONException e2) {
                if (f47178a) {
                    e2.printStackTrace();
                }
            }
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString("version_name");
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            h.a().putLong("aiapps_cur_debug_ver_key", l0.b(optString));
            return true;
        }
        return false;
    }
}
