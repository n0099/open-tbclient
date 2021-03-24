package d.b.g0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.e0.w.d;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45124g;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            this.f45122e = callbackHandler;
            this.f45123f = unitedSchemeEntity;
            this.f45124g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.n(hVar, this.f45122e, this.f45123f);
                return;
            }
            if (this.f45124g.has("emitLive")) {
                d.b.g0.a.m1.a.a.L(d.b.g0.a.l0.g.a.b(this.f45124g.optInt("emitLive")));
            }
            if (this.f45124g.has("emitHttps")) {
                d.b.g0.a.m1.a.a.I(d.b.g0.a.l0.g.a.b(this.f45124g.optInt("emitHttps")));
            }
            if (this.f45124g.has("emitDomain")) {
                d.b.g0.a.m1.a.a.N(!d.b.g0.a.l0.g.a.b(this.f45124g.optInt("emitDomain")));
                d.b.g0.a.m1.a.a.Q(!d.b.g0.a.l0.g.a.b(this.f45124g.optInt("emitDomain")));
            }
            if (this.f45124g.has("emitWss")) {
                d.b.g0.a.m1.a.a.K(d.b.g0.a.l0.g.a.b(this.f45124g.optInt("emitWss")));
            }
            if (this.f45124g.has("emitLaunchMode")) {
                d.b.g0.a.m1.a.a.O(d.b.g0.a.l0.g.a.b(this.f45124g.optInt("emitLaunchMode")));
            }
            if (this.f45124g.has("debugEnvData")) {
                d.b.g0.a.m1.a.a.F(this.f45124g.optString("debugEnvData"));
            }
            if (this.f45124g.has("emitReplaceJsNative")) {
                d.b.g0.a.m1.a.a.J(d.b.g0.a.l0.g.a.b(this.f45124g.optInt("emitReplaceJsNative")));
            }
            if (this.f45124g.has("emitReplaceV8Core")) {
                d.p.e(d.p.b(this.f45124g.optInt("emitReplaceV8Core")));
            }
            UnitedSchemeUtility.callCallback(this.f45122e, this.f45123f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.b.g0.a.m1.a.a.T();
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.c0.c.b("setDebugConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("config");
        if (optJSONObject == null) {
            d.b.g0.a.c0.c.b("setDebugConfig", "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (d.b.g0.a.r1.d.e().h() == 0) {
            eVar.R().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, optJSONObject));
        } else if (d.b.g0.a.r1.d.e().h() == 1) {
            if (!a0.f46287b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!a2.optString("category").equals("swanGame")) {
                d.b.g0.a.c0.c.b("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    d.b.g0.a.m1.a.a.I(d.b.g0.a.l0.g.a.b(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    d.b.g0.a.m1.a.a.K(d.b.g0.a.l0.g.a.b(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    d.b.g0.a.m1.a.a.F(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                d.b.g0.a.m1.a.a.T();
            }
        } else {
            d.b.g0.a.c0.c.b("setDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
