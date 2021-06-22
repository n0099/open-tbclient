package d.a.m0.h.m.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.a1.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.f.g;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f51236g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f51237h;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2) {
            this.f51234e = callbackHandler;
            this.f51235f = str;
            this.f51236g = context;
            this.f51237h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                c.this.l(this.f51236g, this.f51237h, this.f51235f, this.f51234e);
            } else {
                d.a.m0.a.e2.c.d.p(iVar, this.f51234e, this.f51235f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f51239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51240b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51241c;

        public b(c cVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f51239a = context;
            this.f51240b = callbackHandler;
            this.f51241c = str;
        }

        @Override // d.a.m0.a.a1.e.c
        public void a(int i2) {
        }

        @Override // d.a.m0.a.a1.e.c
        public void onFailed() {
            d.a.m0.a.z1.b.f.e.f(this.f51239a, g.aiapps_debug_game_core_download_failed).F();
            this.f51240b.handleSchemeDispatchCallback(this.f51241c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // d.a.m0.a.a1.e.c
        public void onSuccess() {
            File c2 = d.a.m0.h.p.a.b.c();
            File b2 = d.a.m0.h.p.a.b.b();
            if (a0.f44733b) {
                Log.d("replaceGameCore", "gameCoreZipFile: " + c2 + " gameCoreDir: " + b2);
            }
            if (c2.exists() && d.a.m0.t.d.T(c2.getPath(), b2.getPath())) {
                d.a.m0.a.u1.a.a.K(true);
                d.a.m0.a.z1.b.f.e.f(this.f51239a, g.aiapps_debug_game_core_download_success).F();
                this.f51240b.handleSchemeDispatchCallback(this.f51241c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return;
            }
            d.a.m0.a.z1.b.f.e.f(this.f51239a, g.aiapps_debug_game_core_download_failed).F();
            this.f51240b.handleSchemeDispatchCallback(this.f51241c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public c(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/replaceGameCore");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.m0.a.z1.b.f.e.f(context, g.aiapps_debug_game_core_params_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
            return false;
        }
        String optString = a2.optString("url");
        String optString2 = a2.optString("cb");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            eVar.T().g(context, "mapp_cts_debug", new a(callbackHandler, optString2, context, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.a.m0.a.z1.b.f.e.f(context, g.aiapps_debug_game_core_url_empty).F();
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "game core url or cb is null");
        return false;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        d.a.m0.h.s.a.g(str, new b(this, context, callbackHandler, str2));
    }
}
