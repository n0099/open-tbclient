package d.b.h0.a.t1.k.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.v;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final String f47094c = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";

    /* renamed from: d  reason: collision with root package name */
    public static final String f47095d = SchemeConfig.getSchemeHead() + "://swangame/%s";

    /* renamed from: d.b.h0.a.t1.k.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0868a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47098g;

        public C0868a(CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f47096e = callbackHandler;
            this.f47097f = str;
            this.f47098g = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                a.this.k(this.f47098g, this.f47096e, this.f47097f);
            } else {
                d.b.h0.a.v1.c.c.o(hVar, this.f47096e, this.f47097f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47100a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47101b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47102c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f47100a = callbackHandler;
            this.f47101b = unitedSchemeEntity;
            this.f47102c = str;
        }

        @Override // d.b.h0.a.t1.k.h0.a.c
        public void a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() != 0) {
                d.b.h0.a.c0.c.g("history", "get history :" + jSONObject.toString());
                UnitedSchemeUtility.safeCallback(this.f47100a, this.f47101b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f47102c);
                return;
            }
            d.b.h0.a.c0.c.g("history", "none history");
            UnitedSchemeUtility.safeCallback(this.f47100a, this.f47101b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), this.f47102c);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getHistory");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("history", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("history", "none cb");
            if (a0.f47009b) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.R().g(context, "mapp_i_get_history", new C0868a(callbackHandler, optString, unitedSchemeEntity));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        d.b.h0.a.c0.c.g("history", "start get history");
        d.b.h0.a.g0.d.b.j(new b(this, callbackHandler, unitedSchemeEntity, str));
    }
}
