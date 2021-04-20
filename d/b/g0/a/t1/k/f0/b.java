package d.b.g0.a.t1.k.f0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.v;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f46703c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46704d;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46707g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46708h;

        public a(CallbackHandler callbackHandler, String str, d.b.g0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46705e = callbackHandler;
            this.f46706f = str;
            this.f46707g = eVar;
            this.f46708h = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.o(hVar, this.f46705e, this.f46706f);
            } else {
                b.this.k(this.f46707g, this.f46708h, this.f46705e, this.f46706f);
            }
        }
    }

    public b(j jVar, String str) {
        super(jVar, str);
        this.f46703c = null;
        this.f46704d = false;
    }

    @Override // d.b.g0.a.t1.k.a0
    public final boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("favorite", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46680b) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        JSONObject b2 = v.b(unitedSchemeEntity.getParam("params"));
        String optString = b2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("favorite", "none cb");
            if (a0.f46680b) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.f46704d = b2.optBoolean("isFavorButton", false);
        if (!j(eVar, unitedSchemeEntity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
            return false;
        }
        String optString2 = b2.optString("slaveId");
        String U = d.b.g0.a.z0.f.V().U();
        if (TextUtils.equals(optString2, d.b.g0.a.z0.f.V().p()) && (TextUtils.equals(U, "pages/swan-news-showcase/index") || TextUtils.equals(U, "pages/swan-operate-news/index"))) {
            k(eVar, unitedSchemeEntity, callbackHandler, optString);
        } else {
            eVar.R().g(context, this.f46704d ? "scope_favorite_button" : "mapp_favorite", new a(callbackHandler, optString, eVar, unitedSchemeEntity));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public abstract boolean j(d.b.g0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(d.b.g0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);
}
