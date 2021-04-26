package d.a.h0.a.l0.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.u0.d;
import d.a.h0.a.v1.c.i.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43161f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43162g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43163h;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2) {
            this.f43160e = callbackHandler;
            this.f43161f = str;
            this.f43162g = context;
            this.f43163h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                c.this.l(this.f43162g, this.f43163h, this.f43161f, this.f43160e);
            } else {
                d.a.h0.a.v1.c.c.o(hVar, this.f43160e, this.f43161f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f43165a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43166b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43167c;

        public b(c cVar, Context context, CallbackHandler callbackHandler, String str) {
            this.f43165a = context;
            this.f43166b = callbackHandler;
            this.f43167c = str;
        }

        @Override // d.a.h0.a.u0.d.c
        public void a(int i2) {
        }

        @Override // d.a.h0.a.u0.d.c
        public void onFailed() {
            d.a.h0.a.q1.b.f.d.e(this.f43165a, d.a.h0.a.h.aiapps_debug_game_core_download_failed).C();
            this.f43166b.handleSchemeDispatchCallback(this.f43167c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // d.a.h0.a.u0.d.c
        public void onSuccess() {
            File c2 = d.a.h0.g.n.a.b.c();
            File b2 = d.a.h0.g.n.a.b.b();
            if (a0.f44398b) {
                Log.d("replaceGameCore", "gameCoreZipFile: " + c2 + " gameCoreDir: " + b2);
            }
            if (c2.exists() && d.a.h0.p.d.F(c2.getPath(), b2.getPath())) {
                d.a.h0.a.m1.a.a.G(true);
                d.a.h0.a.q1.b.f.d.e(this.f43165a, d.a.h0.a.h.aiapps_debug_game_core_download_success).C();
                this.f43166b.handleSchemeDispatchCallback(this.f43167c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return;
            }
            d.a.h0.a.q1.b.f.d.e(this.f43165a, d.a.h0.a.h.aiapps_debug_game_core_download_failed).C();
            this.f43166b.handleSchemeDispatchCallback(this.f43167c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/debug/replaceGameCore");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.q1.b.f.d.e(context, d.a.h0.a.h.aiapps_debug_swan_core_params_empty).C();
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
        d.a.h0.a.q1.b.f.d.e(context, d.a.h0.a.h.aiapps_debug_swan_core_url_empty).C();
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "game core url or cb is null");
        return false;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        d.a.h0.g.q.a.g(str, new b(this, context, callbackHandler, str2));
    }
}
