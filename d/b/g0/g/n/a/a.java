package d.b.g0.g.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.h;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.u0.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.b.g0.g.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0985a implements d.c {
        public C0985a(a aVar) {
        }

        @Override // d.b.g0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.g0.a.u0.d.c
        public void onFailed() {
            Toast.makeText(AppRuntime.getAppContext(), h.debug_game_core_download_failed, 1).show();
        }

        @Override // d.b.g0.a.u0.d.c
        public void onSuccess() {
            File c2 = b.c();
            File b2 = b.b();
            if (c2.exists() && d.b.g0.p.d.F(c2.getPath(), b2.getPath())) {
                Toast.makeText(AppRuntime.getAppContext(), h.debug_game_core_download_success, 1).show();
            } else {
                Toast.makeText(AppRuntime.getAppContext(), h.debug_game_core_download_failed, 1).show();
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debugGameCore");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f46287b) {
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
            d.b.g0.g.q.a.g(optString, new C0985a(this));
            return true;
        }
        return false;
    }
}
