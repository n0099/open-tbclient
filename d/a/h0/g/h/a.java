package d.a.h0.g.h;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
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

    /* renamed from: d.a.h0.g.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0936a implements d.c {
        public C0936a() {
        }

        @Override // d.a.h0.a.u0.d.c
        public void a(int i2) {
        }

        @Override // d.a.h0.a.u0.d.c
        public void onFailed() {
            a.this.l(h.swangame_dashboard_download_failed);
        }

        @Override // d.a.h0.a.u0.d.c
        public void onSuccess() {
            File c2 = b.c();
            File b2 = b.b();
            if (!c2.exists() || !d.a.h0.p.d.F(c2.getPath(), b2.getPath())) {
                a.this.l(h.swangame_dashboard_download_failed);
            } else {
                a.this.l(h.swangame_dashboard_download_success);
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/debug/dashboardConnect");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f44398b) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                l(h.aiapps_debug_swan_core_params_empty);
                return false;
            }
            String optString = a2.optString("meterUrl");
            if (TextUtils.isEmpty(optString)) {
                l(h.aiapps_debug_swan_core_url_empty);
                return false;
            }
            b.a();
            d.C0820d c0820d = new d.C0820d();
            c0820d.f44731a = k(context, optString);
            new d.a.h0.a.h0.a().e(c0820d, b.c().getPath(), new C0936a());
            return false;
        }
        return false;
    }

    public final String k(Context context, String str) {
        String f2 = d.a.h0.a.w0.a.O().f(context);
        String str2 = new String(d.a.h0.g.r.a.d().a("BASE64", (f2 + "\u0000\u0000").getBytes()));
        String str3 = str.contains("?") ? "&" : "?";
        return str + str3 + "cuid=" + str2;
    }

    public final void l(int i2) {
        Toast.makeText(d.a.h0.a.w0.a.c(), i2, 1).show();
    }
}
