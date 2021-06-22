package d.a.m0.a.n2.c.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e0.d;
import d.a.m0.a.n2.c.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends a0 {
    public b(e eVar, String str) {
        super(eVar, str);
    }

    public boolean j(Context context, d.a.m0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        if (eVar == null) {
            d.b("battery", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44733b) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b("battery", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44733b) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal context");
            }
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    public JSONObject k(@NonNull a.C0829a c0829a) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i2 = 100;
            if (c0829a.f47576a <= 100) {
                i2 = c0829a.f47576a;
            }
            jSONObject.put("level", String.valueOf(i2));
            jSONObject.put("isCharging", c0829a.f47577b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
