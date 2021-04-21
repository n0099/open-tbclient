package d.b.h0.a.t1.k.f0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.v;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f47032c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47033d;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47034e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47035f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47036g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47037h;

        public a(CallbackHandler callbackHandler, String str, d.b.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
            this.f47034e = callbackHandler;
            this.f47035f = str;
            this.f47036g = eVar;
            this.f47037h = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                d.b.h0.a.v1.c.c.o(hVar, this.f47034e, this.f47035f);
            } else {
                b.this.k(this.f47036g, this.f47037h, this.f47034e, this.f47035f);
            }
        }
    }

    public b(j jVar, String str) {
        super(jVar, str);
        this.f47032c = null;
        this.f47033d = false;
    }

    @Override // d.b.h0.a.t1.k.a0
    public final boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("favorite", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        JSONObject b2 = v.b(unitedSchemeEntity.getParam("params"));
        String optString = b2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("favorite", "none cb");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.f47033d = b2.optBoolean("isFavorButton", false);
        if (!j(eVar, unitedSchemeEntity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
            return false;
        }
        String optString2 = b2.optString("slaveId");
        String U = d.b.h0.a.z0.f.V().U();
        if (TextUtils.equals(optString2, d.b.h0.a.z0.f.V().p()) && (TextUtils.equals(U, "pages/swan-news-showcase/index") || TextUtils.equals(U, "pages/swan-operate-news/index"))) {
            k(eVar, unitedSchemeEntity, callbackHandler, optString);
        } else {
            eVar.R().g(context, this.f47033d ? "scope_favorite_button" : "mapp_favorite", new a(callbackHandler, optString, eVar, unitedSchemeEntity));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public abstract boolean j(d.b.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(d.b.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);
}
