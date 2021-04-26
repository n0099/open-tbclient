package d.a.h0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43206f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43207g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f43208h;

        public a(i iVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f43205e = callbackHandler;
            this.f43206f = unitedSchemeEntity;
            this.f43207g = jSONObject;
            this.f43208h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.n(hVar, this.f43205e, this.f43206f);
                return;
            }
            boolean b2 = d.a.h0.a.l0.g.a.b(this.f43207g.optInt("emitReplaceSwanCore"));
            if (b2 && !d.a.h0.a.b2.b.b()) {
                d.a.h0.a.q1.b.f.d.e(AppRuntime.getAppContext(), d.a.h0.a.h.aiapps_debug_no_swan_core).C();
                this.f43206f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f43208h.getResources().getString(d.a.h0.a.h.aiapps_debug_no_swan_core));
                return;
            }
            d.a.h0.a.m1.a.a.H(b2);
            UnitedSchemeUtility.callCallback(this.f43205e, this.f43206f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.h0.a.m1.a.a.T();
        }
    }

    public i(j jVar) {
        super(jVar, "/swanAPI/debug/setReplaceSwanCoreConfig");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.c0.c.b("setReplaceSwanCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceSwanCore")) {
            d.a.h0.a.c0.c.b("setReplaceSwanCoreConfig", "emitReplaceSwanCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.R().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
