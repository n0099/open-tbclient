package d.a.l0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47750e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47751f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47752g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f47753h;

        public a(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f47750e = callbackHandler;
            this.f47751f = unitedSchemeEntity;
            this.f47752g = jSONObject;
            this.f47753h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.o(iVar, this.f47750e, this.f47751f);
                return;
            }
            if (d.a.l0.a.p0.f.a.b(this.f47752g.optInt("emitReplaceDynamicLib"))) {
                if (d.a.l0.a.p0.f.b.n().isEmpty()) {
                    Context context = this.f47753h;
                    if (context == null) {
                        context = d.a.l0.a.c1.a.b();
                    }
                    String string = context.getResources().getString(d.a.l0.a.h.aiapps_debug_no_dynamic_lib);
                    d.a.l0.a.z1.b.f.e.g(context, string).F();
                    this.f47751f.result = UnitedSchemeUtility.wrapCallbackParams(1001, string);
                    return;
                }
                d.a.l0.a.p0.f.b.p();
            } else {
                d.a.l0.a.p0.f.b.f();
            }
            UnitedSchemeUtility.callCallback(this.f47750e, this.f47751f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.l0.a.u1.a.a.X();
        }
    }

    public g(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setReplaceDynamicLibConfig");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.l0.a.e0.d.b("setReplaceDynamicLibConfig", "'params' is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceDynamicLib")) {
            d.a.l0.a.e0.d.b("setReplaceDynamicLibConfig", "'emitReplaceSwanCore's is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
