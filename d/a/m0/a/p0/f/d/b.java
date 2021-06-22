package d.a.m0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.h0.u.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47820e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47821f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47822g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f47823h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f47820e = callbackHandler;
            this.f47821f = unitedSchemeEntity;
            this.f47822g = jSONObject;
            this.f47823h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r3v41 */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.o(iVar, this.f47820e, this.f47821f);
                return;
            }
            try {
                JSONObject jSONObject = this.f47822g;
                b bVar = b.this;
                String string = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_load_cts);
                boolean s = d.a.m0.a.u1.a.a.s();
                d.a.m0.a.p0.f.a.a(s);
                jSONObject.put("loadCts", bVar.k(string, Integer.valueOf(s ? 1 : 0)));
                JSONObject jSONObject2 = this.f47822g;
                b bVar2 = b.this;
                String string2 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_live);
                boolean r = d.a.m0.a.u1.a.a.r();
                d.a.m0.a.p0.f.a.a(r);
                jSONObject2.put("emitLive", bVar2.k(string2, Integer.valueOf(r ? 1 : 0)));
                JSONObject jSONObject3 = this.f47822g;
                b bVar3 = b.this;
                String string3 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_https);
                boolean o = d.a.m0.a.u1.a.a.o();
                d.a.m0.a.p0.f.a.a(o);
                jSONObject3.put("emitHttps", bVar3.k(string3, Integer.valueOf(o ? 1 : 0)));
                JSONObject jSONObject4 = this.f47822g;
                b bVar4 = b.this;
                String string4 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_use_extension);
                boolean x = d.a.m0.a.u1.a.a.x();
                d.a.m0.a.p0.f.a.a(x);
                jSONObject4.put("useExtension", bVar4.k(string4, Integer.valueOf(x ? 1 : 0)));
                JSONObject jSONObject5 = this.f47822g;
                b bVar5 = b.this;
                String string5 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_domain);
                ?? r3 = (d.a.m0.a.u1.a.a.v() || d.a.m0.a.u1.a.a.z()) ? 0 : 1;
                d.a.m0.a.p0.f.a.a(r3);
                jSONObject5.put("emitDomain", bVar5.k(string5, Integer.valueOf((int) r3)));
                JSONObject jSONObject6 = this.f47822g;
                b bVar6 = b.this;
                String string6 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_wss);
                boolean q = d.a.m0.a.u1.a.a.q();
                d.a.m0.a.p0.f.a.a(q);
                jSONObject6.put("emitWss", bVar6.k(string6, Integer.valueOf(q ? 1 : 0)));
                JSONObject jSONObject7 = this.f47822g;
                b bVar7 = b.this;
                String string7 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_launch_mode);
                boolean w = d.a.m0.a.u1.a.a.w();
                d.a.m0.a.p0.f.a.a(w);
                jSONObject7.put("emitLaunchMode", bVar7.k(string7, Integer.valueOf(w ? 1 : 0)));
                this.f47822g.put("debugEnvData", b.this.k(this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_game_extra_data), d.a.m0.a.u1.a.a.g()));
                JSONObject jSONObject8 = this.f47822g;
                b bVar8 = b.this;
                String string8 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_replace_swan_core);
                boolean k = d.a.m0.a.u1.a.a.k();
                d.a.m0.a.p0.f.a.a(k);
                jSONObject8.put("emitReplaceSwanCore", bVar8.k(string8, Integer.valueOf(k ? 1 : 0)));
                JSONObject jSONObject9 = this.f47822g;
                b bVar9 = b.this;
                String string9 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_replace_game_core);
                boolean h2 = d.a.m0.a.u1.a.a.h();
                d.a.m0.a.p0.f.a.a(h2);
                jSONObject9.put("emitReplaceGameCore", bVar9.k(string9, Integer.valueOf(h2 ? 1 : 0)));
                JSONObject jSONObject10 = this.f47822g;
                b bVar10 = b.this;
                String string10 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_replace_js_native);
                boolean p = d.a.m0.a.u1.a.a.p();
                d.a.m0.a.p0.f.a.a(p);
                jSONObject10.put("emitReplaceJsNative", bVar10.k(string10, Integer.valueOf(p ? 1 : 0)));
                boolean d2 = g.t.d();
                JSONObject jSONObject11 = this.f47822g;
                b bVar11 = b.this;
                String string11 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_replace_v8_core);
                d.a.m0.a.p0.f.a.a(d2);
                jSONObject11.put("emitReplaceV8Core", bVar11.k(string11, Integer.valueOf(d2 ? 1 : 0)));
                boolean m = d.a.m0.a.p0.f.b.m();
                JSONObject jSONObject12 = this.f47822g;
                b bVar12 = b.this;
                String string12 = this.f47823h.getResources().getString(d.a.m0.a.h.aiapps_debug_emit_replace_dynamic_lib);
                d.a.m0.a.p0.f.a.a(m);
                jSONObject12.put("emitReplaceDynamicLib", bVar12.k(string12, Integer.valueOf(m ? 1 : 0)));
                UnitedSchemeUtility.callCallback(this.f47820e, this.f47821f, UnitedSchemeUtility.wrapCallbackParams(this.f47822g, 0));
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f47821f.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
            }
        }
    }

    public b(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/getDebugConfig");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject jSONObject = new JSONObject();
        d.a.m0.a.e0.d.g("getDebugConfig", "swan getDebugConfig");
        if (d.a.m0.a.a2.d.g().l() == 0) {
            eVar.T().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject, context));
        } else if (d.a.m0.a.a2.d.g().l() == 1) {
            d.a.m0.a.e0.d.g("getDebugConfig", "swangame getDebugConfig");
            if (!a0.f44733b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.m0.a.e0.d.b("getDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.optString("category").equals("swanGame")) {
                d.a.m0.a.e0.d.b("getDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    boolean o = d.a.m0.a.u1.a.a.o();
                    d.a.m0.a.p0.f.a.a(o);
                    jSONObject.put("emitHttps", o ? 1 : 0);
                    boolean q = d.a.m0.a.u1.a.a.q();
                    d.a.m0.a.p0.f.a.a(q);
                    jSONObject.put("emitWss", q ? 1 : 0);
                    jSONObject.put("debugEnvData", d.a.m0.a.u1.a.a.g());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                    return false;
                }
            }
        } else {
            d.a.m0.a.e0.d.b("getDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "frame type error");
            return false;
        }
        return true;
    }

    public final JSONObject k(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("value", obj);
        return jSONObject;
    }
}
