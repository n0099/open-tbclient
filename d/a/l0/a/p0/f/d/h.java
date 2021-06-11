package d.a.l0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47755f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47756g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f47757h;

        public a(h hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f47754e = callbackHandler;
            this.f47755f = unitedSchemeEntity;
            this.f47756g = jSONObject;
            this.f47757h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.o(iVar, this.f47754e, this.f47755f);
                return;
            }
            boolean b2 = d.a.l0.a.p0.f.a.b(this.f47756g.optInt("useExtension"));
            if (b2 && !d.a.l0.a.p0.f.c.b().exists()) {
                d.a.l0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.l0.a.h.aiapps_debug_no_extension_core).F();
                this.f47755f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f47757h.getResources().getString(d.a.l0.a.h.aiapps_debug_no_extension_core));
                return;
            }
            d.a.l0.a.u1.a.a.T(b2);
            UnitedSchemeUtility.callCallback(this.f47754e, this.f47755f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.l0.a.u1.a.a.X();
        }
    }

    public h(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setExtensionConfig");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.l0.a.e0.d.b("ExtCore-SetConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("useExtension")) {
            d.a.l0.a.e0.d.b("ExtCore-SetConfig", "useExtension is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
