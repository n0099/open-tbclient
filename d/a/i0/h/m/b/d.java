package d.a.i0.h.m.b;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47284e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47285f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47286g;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            this.f47284e = callbackHandler;
            this.f47285f = unitedSchemeEntity;
            this.f47286g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.o(iVar, this.f47284e, this.f47285f);
                return;
            }
            d.a.i0.a.u1.a.a.K(d.a.i0.a.p0.f.a.b(this.f47286g.optInt("emitReplaceGameCore")));
            UnitedSchemeUtility.callCallback(this.f47284e, this.f47285f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.i0.a.u1.a.a.X();
        }
    }

    public d(e eVar) {
        super(eVar, "/swanAPI/debug/setReplaceGameCoreConfig");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.e0.d.b("setReplaceGameCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceGameCore")) {
            d.a.i0.a.e0.d.b("setReplaceGameCoreConfig", "emitReplaceGameCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2));
            return true;
        }
    }
}
