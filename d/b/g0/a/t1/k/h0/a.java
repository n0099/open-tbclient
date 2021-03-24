package d.b.g0.a.t1.k.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.v;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final String f46372c = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";

    /* renamed from: d  reason: collision with root package name */
    public static final String f46373d = SchemeConfig.getSchemeHead() + "://swangame/%s";

    /* renamed from: d.b.g0.a.t1.k.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0835a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46375f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46376g;

        public C0835a(CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46374e = callbackHandler;
            this.f46375f = str;
            this.f46376g = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                a.this.k(this.f46376g, this.f46374e, this.f46375f);
            } else {
                d.b.g0.a.v1.c.c.o(hVar, this.f46374e, this.f46375f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46378a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46379b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46380c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f46378a = callbackHandler;
            this.f46379b = unitedSchemeEntity;
            this.f46380c = str;
        }

        @Override // d.b.g0.a.t1.k.h0.a.c
        public void a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() != 0) {
                d.b.g0.a.c0.c.g("history", "get history :" + jSONObject.toString());
                UnitedSchemeUtility.safeCallback(this.f46378a, this.f46379b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f46380c);
                return;
            }
            d.b.g0.a.c0.c.g("history", "none history");
            UnitedSchemeUtility.safeCallback(this.f46378a, this.f46379b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), this.f46380c);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getHistory");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("history", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f46287b) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("history", "none cb");
            if (a0.f46287b) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.R().g(context, "mapp_i_get_history", new C0835a(callbackHandler, optString, unitedSchemeEntity));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        d.b.g0.a.c0.c.g("history", "start get history");
        d.b.g0.a.g0.d.b.j(new b(this, callbackHandler, unitedSchemeEntity, str));
    }
}
