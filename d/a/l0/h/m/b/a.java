package d.a.l0.h.m.b;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.a1.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.f.g;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.h.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1031a implements e.c {
        public C1031a(a aVar) {
        }

        @Override // d.a.l0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.l0.a.a1.e.c
        public void onFailed() {
            Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_extension_download_failed, 1).show();
        }

        @Override // d.a.l0.a.a1.e.c
        public void onSuccess() {
            File c2 = b.c();
            File b2 = b.b();
            if (c2.exists() && d.a.l0.t.d.T(c2.getPath(), b2.getPath())) {
                Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_extension_download_success, 1).show();
            } else {
                Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_extension_download_failed, 1).show();
            }
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debugGameExtensionCore");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                Toast.makeText(context, g.aiapps_debug_game_core_params_empty, 1).show();
                return false;
            }
            String optString = a2.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, g.aiapps_debug_game_core_url_empty, 1).show();
                return false;
            }
            d.a.l0.h.s.a.f(optString, new C1031a(this));
            return false;
        }
        return false;
    }
}
