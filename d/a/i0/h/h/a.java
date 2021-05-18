package d.a.i0.h.h;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.i0.a.a1.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.f.g;
import d.a.i0.t.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d.a.i0.h.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1014a implements e.c {
        public C1014a() {
        }

        @Override // d.a.i0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.i0.a.a1.e.c
        public void onFailed() {
            a.this.l(g.aiapps_game_dashboard_download_failed);
        }

        @Override // d.a.i0.a.a1.e.c
        public void onSuccess() {
            File c2 = b.c();
            File b2 = b.b();
            if (!c2.exists() || !d.T(c2.getPath(), b2.getPath())) {
                a.this.l(g.aiapps_game_dashboard_download_failed);
            } else {
                a.this.l(g.aiapps_game_dashboard_download_success);
            }
        }
    }

    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/dashboardConnect");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                l(g.aiapps_debug_game_core_params_empty);
                return false;
            }
            String optString = a2.optString("meterUrl");
            if (TextUtils.isEmpty(optString)) {
                l(g.aiapps_debug_game_core_url_empty);
                return false;
            }
            b.a();
            e.d dVar = new e.d();
            dVar.f40516a = k(context, optString);
            new d.a.i0.a.k0.a().e(dVar, b.c().getPath(), new C1014a());
            return false;
        }
        return false;
    }

    public final String k(Context context, String str) {
        String i2 = d.a.i0.a.c1.a.a0().i(context);
        String str2 = new String(d.a.i0.h.t.a.g().a("BASE64", (i2 + "\u0000\u0000").getBytes()));
        String str3 = str.contains("?") ? "&" : "?";
        return str + str3 + "cuid=" + str2;
    }

    public final void l(int i2) {
        Toast.makeText(d.a.i0.a.c1.a.b(), i2, 1).show();
    }
}
