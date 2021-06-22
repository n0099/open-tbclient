package d.a.m0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47867f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47868g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f47869h;

        public a(i iVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f47866e = callbackHandler;
            this.f47867f = unitedSchemeEntity;
            this.f47868g = jSONObject;
            this.f47869h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.o(iVar, this.f47866e, this.f47867f);
                return;
            }
            boolean b2 = d.a.m0.a.p0.f.a.b(this.f47868g.optInt("emitReplaceSwanCore"));
            if (b2 && !d.a.m0.a.m2.b.c()) {
                d.a.m0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.m0.a.h.aiapps_debug_no_swan_core).F();
                this.f47867f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f47869h.getResources().getString(d.a.m0.a.h.aiapps_debug_no_swan_core));
                return;
            }
            d.a.m0.a.u1.a.a.L(b2);
            UnitedSchemeUtility.callCallback(this.f47866e, this.f47867f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.m0.a.u1.a.a.X();
        }
    }

    public i(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setReplaceSwanCoreConfig");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.m0.a.e0.d.b("setReplaceSwanCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceSwanCore")) {
            d.a.m0.a.e0.d.b("setReplaceSwanCoreConfig", "emitReplaceSwanCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
