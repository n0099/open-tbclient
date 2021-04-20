package d.b.g0.g.f;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.g.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.e {
        public a(e eVar) {
        }

        @Override // d.b.g0.g.f.d.e
        public void a(boolean z) {
            Context appContext = AppRuntime.getAppContext();
            if (z) {
                Toast.makeText(appContext, d.b.g0.a.h.aiapps_debug_game_sconsole_download_success, 1).show();
            } else {
                Toast.makeText(appContext, d.b.g0.a.h.aiapps_debug_game_sconsole_download_failed, 1).show();
            }
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/debugGameSconsole");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46680b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                Toast.makeText(context, d.b.g0.a.h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = a2.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, d.b.g0.a.h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            d.m().c(optString, new a(this));
            return false;
        }
        return false;
    }
}
