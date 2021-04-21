package d.b.h0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45872f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45873g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f45874h;

        public a(i iVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f45871e = callbackHandler;
            this.f45872f = unitedSchemeEntity;
            this.f45873g = jSONObject;
            this.f45874h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                d.b.h0.a.v1.c.c.n(hVar, this.f45871e, this.f45872f);
                return;
            }
            boolean b2 = d.b.h0.a.l0.g.a.b(this.f45873g.optInt("emitReplaceSwanCore"));
            if (b2 && !d.b.h0.a.b2.b.b()) {
                d.b.h0.a.q1.b.f.d.e(AppRuntime.getAppContext(), d.b.h0.a.h.aiapps_debug_no_swan_core).C();
                this.f45872f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f45874h.getResources().getString(d.b.h0.a.h.aiapps_debug_no_swan_core));
                return;
            }
            d.b.h0.a.m1.a.a.H(b2);
            UnitedSchemeUtility.callCallback(this.f45871e, this.f45872f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.b.h0.a.m1.a.a.T();
        }
    }

    public i(j jVar) {
        super(jVar, "/swanAPI/debug/setReplaceSwanCoreConfig");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.h0.a.c0.c.b("setReplaceSwanCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceSwanCore")) {
            d.b.h0.a.c0.c.b("setReplaceSwanCoreConfig", "emitReplaceSwanCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.R().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
