package d.b.g0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45542e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45543f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45544g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f45545h;

        public a(i iVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f45542e = callbackHandler;
            this.f45543f = unitedSchemeEntity;
            this.f45544g = jSONObject;
            this.f45545h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.n(hVar, this.f45542e, this.f45543f);
                return;
            }
            boolean b2 = d.b.g0.a.l0.g.a.b(this.f45544g.optInt("emitReplaceSwanCore"));
            if (b2 && !d.b.g0.a.b2.b.b()) {
                d.b.g0.a.q1.b.f.d.e(AppRuntime.getAppContext(), d.b.g0.a.h.aiapps_debug_no_swan_core).C();
                this.f45543f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f45545h.getResources().getString(d.b.g0.a.h.aiapps_debug_no_swan_core));
                return;
            }
            d.b.g0.a.m1.a.a.H(b2);
            UnitedSchemeUtility.callCallback(this.f45542e, this.f45543f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.b.g0.a.m1.a.a.T();
        }
    }

    public i(j jVar) {
        super(jVar, "/swanAPI/debug/setReplaceSwanCoreConfig");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.c0.c.b("setReplaceSwanCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceSwanCore")) {
            d.b.g0.a.c0.c.b("setReplaceSwanCoreConfig", "emitReplaceSwanCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.R().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
