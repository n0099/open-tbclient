package d.a.i0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.h0.u.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43879f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43880g;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            this.f43878e = callbackHandler;
            this.f43879f = unitedSchemeEntity;
            this.f43880g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.o(iVar, this.f43878e, this.f43879f);
                return;
            }
            if (this.f43880g.has("emitLive")) {
                d.a.i0.a.u1.a.a.P(d.a.i0.a.p0.f.a.b(this.f43880g.optInt("emitLive")));
            }
            if (this.f43880g.has("emitHttps")) {
                d.a.i0.a.u1.a.a.M(d.a.i0.a.p0.f.a.b(this.f43880g.optInt("emitHttps")));
            }
            if (this.f43880g.has("emitDomain")) {
                d.a.i0.a.u1.a.a.R(!d.a.i0.a.p0.f.a.b(this.f43880g.optInt("emitDomain")));
                d.a.i0.a.u1.a.a.U(!d.a.i0.a.p0.f.a.b(this.f43880g.optInt("emitDomain")));
            }
            if (this.f43880g.has("emitWss")) {
                d.a.i0.a.u1.a.a.O(d.a.i0.a.p0.f.a.b(this.f43880g.optInt("emitWss")));
            }
            if (this.f43880g.has("emitLaunchMode")) {
                d.a.i0.a.u1.a.a.S(d.a.i0.a.p0.f.a.b(this.f43880g.optInt("emitLaunchMode")));
            }
            if (this.f43880g.has("debugEnvData")) {
                d.a.i0.a.u1.a.a.J(this.f43880g.optString("debugEnvData"));
            }
            if (this.f43880g.has("emitReplaceJsNative")) {
                d.a.i0.a.u1.a.a.N(d.a.i0.a.p0.f.a.b(this.f43880g.optInt("emitReplaceJsNative")));
            }
            if (this.f43880g.has("emitReplaceV8Core")) {
                g.t.e(g.t.b(this.f43880g.optInt("emitReplaceV8Core")));
            }
            UnitedSchemeUtility.callCallback(this.f43878e, this.f43879f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.i0.a.u1.a.a.X();
        }
    }

    public e(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.e0.d.b("setDebugConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("config");
        if (optJSONObject == null) {
            d.a.i0.a.e0.d.b("setDebugConfig", "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (d.a.i0.a.a2.d.g().l() == 0) {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, optJSONObject));
        } else if (d.a.i0.a.a2.d.g().l() == 1) {
            if (!a0.f40775b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!a2.optString("category").equals("swanGame")) {
                d.a.i0.a.e0.d.b("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    d.a.i0.a.u1.a.a.M(d.a.i0.a.p0.f.a.b(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    d.a.i0.a.u1.a.a.O(d.a.i0.a.p0.f.a.b(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    d.a.i0.a.u1.a.a.J(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                d.a.i0.a.u1.a.a.X();
            }
        } else {
            d.a.i0.a.e0.d.b("setDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
