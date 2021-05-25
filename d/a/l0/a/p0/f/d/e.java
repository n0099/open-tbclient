package d.a.l0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.h0.u.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44056g;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            this.f44054e = callbackHandler;
            this.f44055f = unitedSchemeEntity;
            this.f44056g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.o(iVar, this.f44054e, this.f44055f);
                return;
            }
            if (this.f44056g.has("emitLive")) {
                d.a.l0.a.u1.a.a.P(d.a.l0.a.p0.f.a.b(this.f44056g.optInt("emitLive")));
            }
            if (this.f44056g.has("emitHttps")) {
                d.a.l0.a.u1.a.a.M(d.a.l0.a.p0.f.a.b(this.f44056g.optInt("emitHttps")));
            }
            if (this.f44056g.has("emitDomain")) {
                d.a.l0.a.u1.a.a.R(!d.a.l0.a.p0.f.a.b(this.f44056g.optInt("emitDomain")));
                d.a.l0.a.u1.a.a.U(!d.a.l0.a.p0.f.a.b(this.f44056g.optInt("emitDomain")));
            }
            if (this.f44056g.has("emitWss")) {
                d.a.l0.a.u1.a.a.O(d.a.l0.a.p0.f.a.b(this.f44056g.optInt("emitWss")));
            }
            if (this.f44056g.has("emitLaunchMode")) {
                d.a.l0.a.u1.a.a.S(d.a.l0.a.p0.f.a.b(this.f44056g.optInt("emitLaunchMode")));
            }
            if (this.f44056g.has("debugEnvData")) {
                d.a.l0.a.u1.a.a.J(this.f44056g.optString("debugEnvData"));
            }
            if (this.f44056g.has("emitReplaceJsNative")) {
                d.a.l0.a.u1.a.a.N(d.a.l0.a.p0.f.a.b(this.f44056g.optInt("emitReplaceJsNative")));
            }
            if (this.f44056g.has("emitReplaceV8Core")) {
                g.t.e(g.t.b(this.f44056g.optInt("emitReplaceV8Core")));
            }
            UnitedSchemeUtility.callCallback(this.f44054e, this.f44055f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.l0.a.u1.a.a.X();
        }
    }

    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.l0.a.e0.d.b("setDebugConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("config");
        if (optJSONObject == null) {
            d.a.l0.a.e0.d.b("setDebugConfig", "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (d.a.l0.a.a2.d.g().l() == 0) {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, optJSONObject));
        } else if (d.a.l0.a.a2.d.g().l() == 1) {
            if (!a0.f40949b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!a2.optString("category").equals("swanGame")) {
                d.a.l0.a.e0.d.b("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    d.a.l0.a.u1.a.a.M(d.a.l0.a.p0.f.a.b(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    d.a.l0.a.u1.a.a.O(d.a.l0.a.p0.f.a.b(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    d.a.l0.a.u1.a.a.J(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                d.a.l0.a.u1.a.a.X();
            }
        } else {
            d.a.l0.a.e0.d.b("setDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
