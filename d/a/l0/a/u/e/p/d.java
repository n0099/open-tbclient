package d.a.l0.a.u.e.p;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.l0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45199d = k.f43199a;

    public d(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void r(String str) {
        if (str != null && str.length() > 3145728) {
            throw new IllegalArgumentException("params过大，len=" + str.length() + "\n" + str.substring(0, 204800));
        }
    }

    public static String t(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            return !TextUtils.isEmpty(str) ? str : "log info is invalid";
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            return jSONObject.length() != 0 ? jSONObject.toString() : "log info is invalid";
        } else {
            return "log info is invalid";
        }
    }

    public d.a.l0.a.u.h.b s(String str) {
        if (f45199d) {
            Log.d("Api-Log", "start logToFile action, params = " + str);
            r(str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Log", str);
        if (!((d.a.l0.a.u.h.b) b2.first).a()) {
            d.a.l0.a.e0.d.b("Api-Log", "parse failed, params = " + str);
            return (d.a.l0.a.u.h.b) b2.first;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        d.a.l0.a.e0.d.h(jSONObject.optString("tag", "logToFile-swanjsLog"), t(jSONObject.opt("data")));
        return new d.a.l0.a.u.h.b(0);
    }
}
