package d.b.g0.a.c2.c.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.c2.c.a;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b extends a0 {
    public b(j jVar, String str) {
        super(jVar, str);
    }

    public boolean j(Context context, e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("battery", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46288b) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b.g0.a.c0.c.b("battery", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f46288b) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal context");
            }
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    public JSONObject k(@NonNull a.C0635a c0635a) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = 100;
            if (c0635a.f43776a <= 100) {
                i = c0635a.f43776a;
            }
            jSONObject.put("level", String.valueOf(i));
            jSONObject.put("isCharging", c0635a.f43777b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
