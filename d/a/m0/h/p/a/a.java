package d.a.m0.h.p.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.m0.a.a1.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.f.g;
import d.a.m0.t.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.m0.h.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1107a implements e.c {
        public C1107a(a aVar) {
        }

        @Override // d.a.m0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.m0.a.a1.e.c
        public void onFailed() {
            Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_core_download_failed, 1).show();
        }

        @Override // d.a.m0.a.a1.e.c
        public void onSuccess() {
            File c2 = b.c();
            File b2 = b.b();
            if (c2.exists() && d.T(c2.getPath(), b2.getPath())) {
                d.a.m0.a.u1.a.a.K(true);
                Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_core_download_success, 1).show();
                return;
            }
            Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_core_download_failed, 1).show();
        }
    }

    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debugGameCore");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (a0.f44733b) {
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
            d.a.m0.h.s.a.g(optString, new C1107a(this));
            return true;
        }
        return false;
    }
}
