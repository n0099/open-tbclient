package d.a.l0.h.f;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.c2.f.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<Boolean> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Context appContext = AppRuntime.getAppContext();
            if (bool.booleanValue()) {
                Toast.makeText(appContext, d.a.l0.f.g.aiapps_debug_game_sconsole_download_success, 1).show();
            } else {
                Toast.makeText(appContext, d.a.l0.f.g.aiapps_debug_game_sconsole_download_failed, 1).show();
            }
        }
    }

    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debugGameSconsole");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                Toast.makeText(context, d.a.l0.f.g.aiapps_debug_game_core_params_empty, 1).show();
                return false;
            }
            String optString = a2.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, d.a.l0.f.g.aiapps_debug_game_core_url_empty, 1).show();
                return false;
            }
            d.m().c(optString, new a(this));
            return false;
        }
        return false;
    }
}
