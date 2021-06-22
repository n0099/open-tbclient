package d.a.m0.a.c2.f.h0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.d;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final String f44826c = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";

    /* renamed from: d  reason: collision with root package name */
    public static final String f44827d = SchemeConfig.getSchemeHead() + "://swangame/%s";

    /* renamed from: d.a.m0.a.c2.f.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0640a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44828e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44829f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44830g;

        public C0640a(CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            this.f44828e = callbackHandler;
            this.f44829f = str;
            this.f44830g = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.h(iVar)) {
                a.this.k(this.f44830g, this.f44828e, this.f44829f);
            } else {
                d.p(iVar, this.f44828e, this.f44829f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44832a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44833b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44834c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44832a = callbackHandler;
            this.f44833b = unitedSchemeEntity;
            this.f44834c = str;
        }

        @Override // d.a.m0.a.c2.f.h0.a.c
        public void a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() != 0) {
                d.a.m0.a.e0.d.g("history", "get history :" + jSONObject.toString());
                UnitedSchemeUtility.safeCallback(this.f44832a, this.f44833b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f44834c);
                return;
            }
            d.a.m0.a.e0.d.g("history", "none history");
            UnitedSchemeUtility.safeCallback(this.f44832a, this.f44833b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), this.f44834c);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/getHistory");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.m0.a.e0.d.b("history", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44733b) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("history", "none cb");
            if (a0.f44733b) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.T().g(context, "mapp_i_get_history", new C0640a(callbackHandler, optString, unitedSchemeEntity));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        d.a.m0.a.e0.d.g("history", "start get history");
        d.a.m0.a.j0.c.b.i(new b(this, callbackHandler, unitedSchemeEntity, str));
    }
}
