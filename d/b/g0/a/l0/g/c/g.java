package d.b.g0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45535e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45536f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45537g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f45538h;

        public a(g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f45535e = callbackHandler;
            this.f45536f = unitedSchemeEntity;
            this.f45537g = jSONObject;
            this.f45538h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.n(hVar, this.f45535e, this.f45536f);
                return;
            }
            int optInt = this.f45537g.optInt("useExtension");
            if (!d.b.g0.a.l0.g.b.b().exists()) {
                this.f45536f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f45538h.getResources().getString(d.b.g0.a.h.aiapps_debug_no_extension_core));
                return;
            }
            d.b.g0.a.m1.a.a.P(d.b.g0.a.l0.g.a.b(optInt));
            UnitedSchemeUtility.callCallback(this.f45535e, this.f45536f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.b.g0.a.m1.a.a.T();
        }
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/debug/setExtensionConfig");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.g0.a.c0.c.b("ExtCore-SetConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("useExtension")) {
            d.b.g0.a.c0.c.b("ExtCore-SetConfig", "useExtension is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.R().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
