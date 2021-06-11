package d.a.l0.a.u.e.o;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.l0.a.u.c.d {
    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b r() {
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-BrightnessApi", "handle");
        }
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.l0.a.u.h.b(1001, "SwanApp is null");
        }
        SwanAppActivity x = Q.x();
        if (x == null) {
            d.a.l0.a.e0.d.b("Api-BrightnessApi", "null activity");
            return new d.a.l0.a.u.h.b(1001, "null activity");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", d.a.l0.a.n2.e.b.a.b().a(x));
            return new d.a.l0.a.u.h.b(0, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new d.a.l0.a.u.h.b(1001, "make result json error");
        }
    }
}
