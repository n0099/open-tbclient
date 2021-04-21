package d.b.h0.a.c2.c.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.c2.c.a;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends a0 {
    public b(j jVar, String str) {
        super(jVar, str);
    }

    public boolean j(Context context, e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("battery", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b.h0.a.c0.c.b("battery", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "getBatteryInfo --- illegal context");
            }
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    public JSONObject k(@NonNull a.C0667a c0667a) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = 100;
            if (c0667a.f44497a <= 100) {
                i = c0667a.f44497a;
            }
            jSONObject.put("level", String.valueOf(i));
            jSONObject.put("isCharging", c0667a.f44498b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
