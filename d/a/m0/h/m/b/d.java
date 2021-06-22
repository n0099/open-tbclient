package d.a.m0.h.m.b;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51242e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51243f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f51244g;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            this.f51242e = callbackHandler;
            this.f51243f = unitedSchemeEntity;
            this.f51244g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.o(iVar, this.f51242e, this.f51243f);
                return;
            }
            d.a.m0.a.u1.a.a.K(d.a.m0.a.p0.f.a.b(this.f51244g.optInt("emitReplaceGameCore")));
            UnitedSchemeUtility.callCallback(this.f51242e, this.f51243f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.m0.a.u1.a.a.X();
        }
    }

    public d(e eVar) {
        super(eVar, "/swanAPI/debug/setReplaceGameCoreConfig");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.m0.a.e0.d.b("setReplaceGameCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceGameCore")) {
            d.a.m0.a.e0.d.b("setReplaceGameCoreConfig", "emitReplaceGameCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2));
            return true;
        }
    }
}
