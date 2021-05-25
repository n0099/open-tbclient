package d.a.l0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.a1.e;
import d.a.l0.a.c2.f.a0;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends a0 {

    /* loaded from: classes2.dex */
    public class a implements e.c {
        public a(j jVar) {
        }

        @Override // d.a.l0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.l0.a.a1.e.c
        public void onFailed() {
            Toast.makeText(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_swan_core_download_failed, 1).show();
        }

        @Override // d.a.l0.a.a1.e.c
        public void onSuccess() {
            File d2 = d.a.l0.a.m2.d.a.d();
            File c2 = d.a.l0.a.m2.d.a.c();
            if (d2.exists() && d.a.l0.t.d.T(d2.getPath(), c2.getPath())) {
                d.a.l0.a.u1.a.a.L(true);
                Toast.makeText(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_swan_core_download_success, 1).show();
                return;
            }
            Toast.makeText(d.a.l0.a.c1.a.b(), d.a.l0.a.h.aiapps_debug_swan_core_download_failed, 1).show();
        }
    }

    public j(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debugSwanCore");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                Toast.makeText(context, d.a.l0.a.h.aiapps_debug_params_empty, 1).show();
                return false;
            }
            String optString = a2.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, d.a.l0.a.h.aiapps_debug_download_url_empty, 1).show();
                return false;
            }
            d.a.l0.a.a1.e.H(optString, new a(this));
            return true;
        }
        return false;
    }
}
