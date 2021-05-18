package d.a.i0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43905f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43906g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f43907h;

        public a(h hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            this.f43904e = callbackHandler;
            this.f43905f = unitedSchemeEntity;
            this.f43906g = jSONObject;
            this.f43907h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.o(iVar, this.f43904e, this.f43905f);
                return;
            }
            boolean b2 = d.a.i0.a.p0.f.a.b(this.f43906g.optInt("useExtension"));
            if (b2 && !d.a.i0.a.p0.f.c.b().exists()) {
                d.a.i0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.i0.a.h.aiapps_debug_no_extension_core).F();
                this.f43905f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f43907h.getResources().getString(d.a.i0.a.h.aiapps_debug_no_extension_core));
                return;
            }
            d.a.i0.a.u1.a.a.T(b2);
            UnitedSchemeUtility.callCallback(this.f43904e, this.f43905f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.i0.a.u1.a.a.X();
        }
    }

    public h(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setExtensionConfig");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.e0.d.b("ExtCore-SetConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("useExtension")) {
            d.a.i0.a.e0.d.b("ExtCore-SetConfig", "useExtension is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
            return true;
        }
    }
}
