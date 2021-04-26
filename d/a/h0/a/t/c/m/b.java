package d.a.h0.a.t.c.m;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.t.b.d {
    public b(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.a.h0.a.t.e.b q() {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-BrightnessApi", "handle");
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return new d.a.h0.a.t.e.b(1001, "SwanApp is null");
        }
        SwanAppActivity v = O.v();
        if (v == null) {
            d.a.h0.a.c0.c.b("Api-BrightnessApi", "null activity");
            return new d.a.h0.a.t.e.b(1001, "null activity");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", d.a.h0.a.c2.d.b.a.b().a(v));
            return new d.a.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new d.a.h0.a.t.e.b(1001, "make result json error");
        }
    }
}
