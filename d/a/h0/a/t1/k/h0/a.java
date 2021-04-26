package d.a.h0.a.t1.k.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.v;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final String f44487c = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";

    /* renamed from: d  reason: collision with root package name */
    public static final String f44488d = SchemeConfig.getSchemeHead() + "://swangame/%s";

    /* renamed from: d.a.h0.a.t1.k.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0807a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44489e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44490f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44491g;

        public C0807a(CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44489e = callbackHandler;
            this.f44490f = str;
            this.f44491g = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                a.this.k(this.f44491g, this.f44489e, this.f44490f);
            } else {
                d.a.h0.a.v1.c.c.o(hVar, this.f44489e, this.f44490f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44493a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44494b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44495c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44493a = callbackHandler;
            this.f44494b = unitedSchemeEntity;
            this.f44495c = str;
        }

        @Override // d.a.h0.a.t1.k.h0.a.c
        public void a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() != 0) {
                d.a.h0.a.c0.c.g("history", "get history :" + jSONObject.toString());
                UnitedSchemeUtility.safeCallback(this.f44493a, this.f44494b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f44495c);
                return;
            }
            d.a.h0.a.c0.c.g("history", "none history");
            UnitedSchemeUtility.safeCallback(this.f44493a, this.f44494b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), this.f44495c);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getHistory");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.b("history", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("history", "none cb");
            if (a0.f44398b) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.R().g(context, "mapp_i_get_history", new C0807a(callbackHandler, optString, unitedSchemeEntity));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        d.a.h0.a.c0.c.g("history", "start get history");
        d.a.h0.a.g0.d.b.j(new b(this, callbackHandler, unitedSchemeEntity, str));
    }
}
