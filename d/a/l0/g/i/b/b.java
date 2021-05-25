package d.a.l0.g.i.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47091c = k.f43199a;

    public b() {
        super("GetSwanGameDuration");
    }

    public static boolean b(Long l, Long l2) {
        return l.longValue() / 86400000 == l2.longValue() / 86400000;
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (f47091c) {
            Log.e("GetSwanGameDuration", "params is " + jSONObject.toString());
        }
        String optString = jSONObject.optString("swanGameId");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(202, "params may be error");
        } else {
            d.a.l0.a.k2.g.b a2 = h.a();
            if (!b(Long.valueOf(a2.getLong(optString + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                d.a.l0.a.k2.g.b a3 = h.a();
                a3.putLong(optString + "_Duration", 0L);
            }
            d.a.l0.a.k2.g.b a4 = h.a();
            long j = a4.getLong(optString + "_Duration", 0L);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("swanGameDuration", j);
                jSONObject2.put("data", jSONObject3);
            } catch (JSONException e2) {
                if (f47091c) {
                    e2.printStackTrace();
                }
            }
            bVar.b(jSONObject2);
        }
        return null;
    }
}
