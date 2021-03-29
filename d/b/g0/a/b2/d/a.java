package d.b.g0.a.b2.d;

import android.text.TextUtils;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.b2.b;
import d.b.g0.a.k;
import d.b.g0.p.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43571a = k.f45051a;

    public static void a() {
        File c2 = c();
        if (c2.exists()) {
            d.f(c2);
        }
    }

    public static long b() {
        return h.a().getLong("aiapps_cur_debug_ver_key", 0L);
    }

    public static File c() {
        return new File(d.b.g0.a.y0.c.a.d().get(0).f44686a, "/aiapps_debug_swan_core/");
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
                jSONObject = new JSONObject(d.r(file));
            } catch (JSONException e2) {
                if (f43571a) {
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
            h.a().putLong("aiapps_cur_debug_ver_key", b.h(optString));
            return true;
        }
        return false;
    }
}
