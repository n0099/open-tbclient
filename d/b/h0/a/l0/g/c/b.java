package d.b.h0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.e0.w.d;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45826e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45827f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45828g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f45829h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f45826e = callbackHandler;
            this.f45827f = unitedSchemeEntity;
            this.f45828g = jSONObject;
            this.f45829h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r3v38 */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                d.b.h0.a.v1.c.c.n(hVar, this.f45826e, this.f45827f);
                return;
            }
            try {
                JSONObject jSONObject = this.f45828g;
                b bVar = b.this;
                String string = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_load_cts);
                boolean q = d.b.h0.a.m1.a.a.q();
                d.b.h0.a.l0.g.a.a(q);
                jSONObject.put("loadCts", bVar.k(string, Integer.valueOf(q ? 1 : 0)));
                JSONObject jSONObject2 = this.f45828g;
                b bVar2 = b.this;
                String string2 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_live);
                boolean p = d.b.h0.a.m1.a.a.p();
                d.b.h0.a.l0.g.a.a(p);
                jSONObject2.put("emitLive", bVar2.k(string2, Integer.valueOf(p ? 1 : 0)));
                JSONObject jSONObject3 = this.f45828g;
                b bVar3 = b.this;
                String string3 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_https);
                boolean m = d.b.h0.a.m1.a.a.m();
                d.b.h0.a.l0.g.a.a(m);
                jSONObject3.put("emitHttps", bVar3.k(string3, Integer.valueOf(m ? 1 : 0)));
                JSONObject jSONObject4 = this.f45828g;
                b bVar4 = b.this;
                String string4 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_use_extension);
                boolean v = d.b.h0.a.m1.a.a.v();
                d.b.h0.a.l0.g.a.a(v);
                jSONObject4.put("useExtension", bVar4.k(string4, Integer.valueOf(v ? 1 : 0)));
                JSONObject jSONObject5 = this.f45828g;
                b bVar5 = b.this;
                String string5 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_domain);
                ?? r3 = (d.b.h0.a.m1.a.a.t() || d.b.h0.a.m1.a.a.x()) ? 0 : 1;
                d.b.h0.a.l0.g.a.a(r3);
                jSONObject5.put("emitDomain", bVar5.k(string5, Integer.valueOf((int) r3)));
                JSONObject jSONObject6 = this.f45828g;
                b bVar6 = b.this;
                String string6 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_wss);
                boolean o = d.b.h0.a.m1.a.a.o();
                d.b.h0.a.l0.g.a.a(o);
                jSONObject6.put("emitWss", bVar6.k(string6, Integer.valueOf(o ? 1 : 0)));
                JSONObject jSONObject7 = this.f45828g;
                b bVar7 = b.this;
                String string7 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_launch_mode);
                boolean u = d.b.h0.a.m1.a.a.u();
                d.b.h0.a.l0.g.a.a(u);
                jSONObject7.put("emitLaunchMode", bVar7.k(string7, Integer.valueOf(u ? 1 : 0)));
                this.f45828g.put("debugEnvData", b.this.k(this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_game_extra_data), d.b.h0.a.m1.a.a.g()));
                JSONObject jSONObject8 = this.f45828g;
                b bVar8 = b.this;
                String string8 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_replace_swan_core);
                boolean i = d.b.h0.a.m1.a.a.i();
                d.b.h0.a.l0.g.a.a(i);
                jSONObject8.put("emitReplaceSwanCore", bVar8.k(string8, Integer.valueOf(i ? 1 : 0)));
                JSONObject jSONObject9 = this.f45828g;
                b bVar9 = b.this;
                String string9 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_replace_game_core);
                boolean h2 = d.b.h0.a.m1.a.a.h();
                d.b.h0.a.l0.g.a.a(h2);
                jSONObject9.put("emitReplaceGameCore", bVar9.k(string9, Integer.valueOf(h2 ? 1 : 0)));
                JSONObject jSONObject10 = this.f45828g;
                b bVar10 = b.this;
                String string10 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_replace_js_native);
                boolean n = d.b.h0.a.m1.a.a.n();
                d.b.h0.a.l0.g.a.a(n);
                jSONObject10.put("emitReplaceJsNative", bVar10.k(string10, Integer.valueOf(n ? 1 : 0)));
                boolean d2 = d.p.d();
                JSONObject jSONObject11 = this.f45828g;
                b bVar11 = b.this;
                String string11 = this.f45829h.getResources().getString(d.b.h0.a.h.aiapps_debug_emit_replace_v8_core);
                d.b.h0.a.l0.g.a.a(d2);
                jSONObject11.put("emitReplaceV8Core", bVar11.k(string11, Integer.valueOf(d2 ? 1 : 0)));
                UnitedSchemeUtility.callCallback(this.f45826e, this.f45827f, UnitedSchemeUtility.wrapCallbackParams(this.f45828g, 0));
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f45827f.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
            }
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/debug/getDebugConfig");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        JSONObject jSONObject = new JSONObject();
        d.b.h0.a.c0.c.g("getDebugConfig", "swan getDebugConfig");
        if (d.b.h0.a.r1.d.e().h() == 0) {
            eVar.R().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject, context));
        } else if (d.b.h0.a.r1.d.e().h() == 1) {
            d.b.h0.a.c0.c.g("getDebugConfig", "swangame getDebugConfig");
            if (!a0.f47009b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.b.h0.a.c0.c.b("getDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.optString("category").equals("swanGame")) {
                d.b.h0.a.c0.c.b("getDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    boolean m = d.b.h0.a.m1.a.a.m();
                    d.b.h0.a.l0.g.a.a(m);
                    jSONObject.put("emitHttps", m ? 1 : 0);
                    boolean o = d.b.h0.a.m1.a.a.o();
                    d.b.h0.a.l0.g.a.a(o);
                    jSONObject.put("emitWss", o ? 1 : 0);
                    jSONObject.put("debugEnvData", d.b.h0.a.m1.a.a.g());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                    return false;
                }
            }
        } else {
            d.b.h0.a.c0.c.b("getDebugConfig", "frame type error");
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
