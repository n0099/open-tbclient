package d.a.h0.a.l0.g.c;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43204g;

        public a(h hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            this.f43202e = callbackHandler;
            this.f43203f = unitedSchemeEntity;
            this.f43204g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.n(hVar, this.f43202e, this.f43203f);
                return;
            }
            d.a.h0.a.m1.a.a.G(d.a.h0.a.l0.g.a.b(this.f43204g.optInt("emitReplaceGameCore")));
            UnitedSchemeUtility.callCallback(this.f43202e, this.f43203f, UnitedSchemeUtility.wrapCallbackParams(0));
            d.a.h0.a.m1.a.a.T();
        }
    }

    public h(j jVar) {
        super(jVar, "/swanAPI/debug/setReplaceGameCoreConfig");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.c0.c.b("setReplaceGameCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!a2.has("emitReplaceGameCore")) {
            d.a.h0.a.c0.c.b("setReplaceGameCoreConfig", "emitReplaceGameCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.R().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2));
            return true;
        }
    }
}
