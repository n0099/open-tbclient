package d.a.h0.g.k.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.h;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.u0.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.g.k.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0941a implements d.c {
        public C0941a(a aVar) {
        }

        @Override // d.a.h0.a.u0.d.c
        public void a(int i2) {
        }

        @Override // d.a.h0.a.u0.d.c
        public void onFailed() {
            Toast.makeText(AppRuntime.getAppContext(), h.debug_game_extension_download_failed, 1).show();
        }

        @Override // d.a.h0.a.u0.d.c
        public void onSuccess() {
            File c2 = b.c();
            File b2 = b.b();
            if (c2.exists() && d.a.h0.p.d.F(c2.getPath(), b2.getPath())) {
                Toast.makeText(AppRuntime.getAppContext(), h.debug_game_extension_download_success, 1).show();
            } else {
                Toast.makeText(AppRuntime.getAppContext(), h.debug_game_extension_download_failed, 1).show();
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debugGameExtensionCore");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f44398b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                Toast.makeText(context, h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = a2.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            d.a.h0.g.q.a.f(optString, new C0941a(this));
            return false;
        }
        return false;
    }
}
