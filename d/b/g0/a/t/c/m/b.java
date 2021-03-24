package d.b.g0.a.t.c.m;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.t.b.d {
    public b(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b q() {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-BrightnessApi", "handle");
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return new d.b.g0.a.t.e.b(1001, "SwanApp is null");
        }
        SwanAppActivity n = O.n();
        if (n == null) {
            d.b.g0.a.c0.c.b("Api-BrightnessApi", "null activity");
            return new d.b.g0.a.t.e.b(1001, "null activity");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", d.b.g0.a.c2.d.b.a.b().a(n));
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new d.b.g0.a.t.e.b(1001, "make result json error");
        }
    }
}
