package d.a.h0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.e0.w.d;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43176e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43177f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43178g;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            this.f43176e = callbackHandler;
            this.f43177f = unitedSchemeEntity;
            this.f43178g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.n(hVar, this.f43176e, this.f43177f);
                return;
            }
            if (this.f43178g.has("emitLive")) {
                d.a.h0.a.m1.a.a.L(d.a.h0.a.l0.g.a.b(this.f43178g.optInt("emitLive")));
            }
            if (this.f43178g.has("emitHttps")) {
                d.a.h0.a.m1.a.a.I(d.a.h0.a.l0.g.a.b(this.f43178g.optInt("emitHttps")));
            }
            if (this.f43178g.has("emitDomain")) {
                d.a.h0.a.m1.a.a.N(!d.a.h0.a.l0.g.a.b(this.f43178g.optInt("emitDomain")));
                d.a.h0.a.m1.a.a.Q(!d.a.h0.a.l0.g.a.b(this.f43178g.optInt("emitDomain")));
            }
            if (this.f43178g.has("emitWss")) {
                d.a.h0.a.m1.a.a.K(d.a.h0.a.l0.g.a.b(this.f43178g.optInt("emitWss")));
            }
            if (this.f43178g.has("emitLaunchMode")) {
                d.a.h0.a.m1.a.a.O(d.a.h0.a.l0.g.a.b(this.f43178g.optInt("emitLaunchMode")));
            }
            if (this.f43178g.has("debugEnvData")) {
                d.a.h0.a.m1.a.a.F(this.f43178g.optString("debugEnvData"));
            }
            if (this.f43178g.has("emitReplaceJsNative")) {
                d.a.h0.a.m1.a.a.J(d.a.h0.a.l0.g.a.b(this.f43178g.optInt("emitReplaceJsNative")));
            }
            if (this.f43178g.has("emitReplaceV8Core")) {
                d.p.e(d.p.b(this.f43178g.optInt("emitReplaceV8Core")));
            }
            UnitedSchemeUtility.callCallback(this.f43176e, this.f43177f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.h0.a.m1.a.a.T();
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.c0.c.b("setDebugConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optJSONObject = a2.optJSONObject("config");
        if (optJSONObject == null) {
            d.a.h0.a.c0.c.b("setDebugConfig", "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (d.a.h0.a.r1.d.e().j() == 0) {
            eVar.R().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, optJSONObject));
        } else if (d.a.h0.a.r1.d.e().j() == 1) {
            if (!a0.f44398b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!a2.optString("category").equals("swanGame")) {
                d.a.h0.a.c0.c.b("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    d.a.h0.a.m1.a.a.I(d.a.h0.a.l0.g.a.b(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    d.a.h0.a.m1.a.a.K(d.a.h0.a.l0.g.a.b(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    d.a.h0.a.m1.a.a.F(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                d.a.h0.a.m1.a.a.T();
            }
        } else {
            d.a.h0.a.c0.c.b("setDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
