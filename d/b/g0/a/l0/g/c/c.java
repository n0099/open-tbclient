package d.b.g0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.u0.d;
import d.b.g0.a.v1.c.i.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45110g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45111h;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2) {
            this.f45108e = callbackHandler;
            this.f45109f = str;
            this.f45110g = context;
            this.f45111h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                c.this.l(this.f45110g, this.f45111h, this.f45109f, this.f45108e);
            } else {
                d.b.g0.a.v1.c.c.o(hVar, this.f45108e, this.f45109f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45114c;

        public b(c cVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f45112a = context;
            this.f45113b = callbackHandler;
            this.f45114c = str;
        }

        @Override // d.b.g0.a.u0.d.c
        public void a(int i) {
        }

        @Override // d.b.g0.a.u0.d.c
        public void onFailed() {
            d.b.g0.a.q1.b.f.d.e(this.f45112a, d.b.g0.a.h.aiapps_debug_game_core_download_failed).C();
            this.f45113b.handleSchemeDispatchCallback(this.f45114c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // d.b.g0.a.u0.d.c
        public void onSuccess() {
            File c2 = d.b.g0.g.n.a.b.c();
            File b2 = d.b.g0.g.n.a.b.b();
            if (a0.f46287b) {
                Log.d("replaceGameCore", "gameCoreZipFile: " + c2 + " gameCoreDir: " + b2);
            }
            if (c2.exists() && d.b.g0.p.d.F(c2.getPath(), b2.getPath())) {
                d.b.g0.a.m1.a.a.G(true);
                d.b.g0.a.q1.b.f.d.e(this.f45112a, d.b.g0.a.h.aiapps_debug_game_core_download_success).C();
                this.f45113b.handleSchemeDispatchCallback(this.f45114c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return;
            }
            d.b.g0.a.q1.b.f.d.e(this.f45112a, d.b.g0.a.h.aiapps_debug_game_core_download_failed).C();
            this.f45113b.handleSchemeDispatchCallback(this.f45114c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/debug/replaceGameCore");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_debug_swan_core_params_empty).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
            return false;
        }
        String optString = a2.optString("url");
        String optString2 = a2.optString("cb");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            eVar.R().g(context, "mapp_cts_debug", new a(callbackHandler, optString2, context, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        d.b.g0.a.q1.b.f.d.e(context, d.b.g0.a.h.aiapps_debug_swan_core_url_empty).C();
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "game core url or cb is null");
        return false;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        d.b.g0.g.q.a.g(str, new b(this, context, callbackHandler, str2));
    }
}
