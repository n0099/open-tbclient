package d.b.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.h0.a.u0.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.c {
        public a(f fVar) {
        }

        @Override // d.b.h0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.h0.a.u0.d.c
        public void onFailed() {
            Toast.makeText(d.b.h0.a.w0.a.c(), d.b.h0.a.h.aiapps_debug_swan_core_download_failed, 1).show();
        }

        @Override // d.b.h0.a.u0.d.c
        public void onSuccess() {
            File d2 = d.b.h0.a.b2.d.a.d();
            File c2 = d.b.h0.a.b2.d.a.c();
            if (d2.exists() && d.b.h0.p.d.F(d2.getPath(), c2.getPath())) {
                d.b.h0.a.m1.a.a.H(true);
                Toast.makeText(d.b.h0.a.w0.a.c(), d.b.h0.a.h.aiapps_debug_swan_core_download_success, 1).show();
                return;
            }
            Toast.makeText(d.b.h0.a.w0.a.c(), d.b.h0.a.h.aiapps_debug_swan_core_download_failed, 1).show();
        }
    }

    public f(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/debugSwanCore");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                Toast.makeText(context, d.b.h0.a.h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = a2.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, d.b.h0.a.h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            d.b.h0.a.u0.d.s(optString, new a(this));
            return true;
        }
        return false;
    }
}
