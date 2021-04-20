package d.b.g0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/abTestConfig");
    }

    public static String k() {
        File a2 = d.b.g0.a.i2.k.a();
        if (a2 == null) {
            return null;
        }
        String path = a2.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path + "/debug_abtest_config.json";
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46680b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && context != null) {
                JSONObject optJSONObject = a2.optJSONObject("abtest");
                if (optJSONObject != null) {
                    Toast.makeText(context, l(optJSONObject) ? d.b.g0.a.h.swanapp_debug_abtest_config_success : d.b.g0.a.h.swanapp_debug_abtest_config_fail, 1).show();
                } else {
                    j();
                    Toast.makeText(context, d.b.g0.a.h.swanapp_delete_debug_abtest_config, 1).show();
                }
                return true;
            }
            Toast.makeText(context, d.b.g0.a.h.swanapp_debug_abtest_config_params_empty, 1).show();
            return false;
        }
        return false;
    }

    public final void j() {
        String k = k();
        if (TextUtils.isEmpty(k)) {
            return;
        }
        File file = new File(k);
        if (file.exists()) {
            file.delete();
        }
    }

    public final boolean l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String k = k();
        if (TextUtils.isEmpty(k)) {
            return false;
        }
        return d.b.g0.a.v0.a.b(k, jSONObject.toString(), false);
    }
}
