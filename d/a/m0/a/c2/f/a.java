package d.a.m0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/abTestConfig");
    }

    public static String k() {
        File a2 = d.a.m0.a.v2.l.a();
        if (a2 == null) {
            return null;
        }
        String path = a2.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path + "/debug_abtest_config.json";
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && context != null) {
                JSONObject optJSONObject = a2.optJSONObject("abtest");
                if (optJSONObject != null) {
                    Toast.makeText(context, l(optJSONObject) ? d.a.m0.a.h.swanapp_debug_abtest_config_success : d.a.m0.a.h.swanapp_debug_abtest_config_fail, 1).show();
                } else {
                    j();
                    Toast.makeText(context, d.a.m0.a.h.swanapp_delete_debug_abtest_config, 1).show();
                }
                return true;
            }
            Toast.makeText(context, d.a.m0.a.h.swanapp_debug_abtest_config_params_empty, 1).show();
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
        return d.a.m0.a.b1.a.b(k, jSONObject.toString(), false);
    }
}
