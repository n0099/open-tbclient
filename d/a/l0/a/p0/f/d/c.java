package d.a.l0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44043e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44044f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44045g;

        public a(c cVar, CallbackHandler callbackHandler, String str, String str2) {
            this.f44043e = callbackHandler;
            this.f44044f = str;
            this.f44045g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                d.a.l0.a.e2.c.d.p(iVar, this.f44043e, this.f44044f);
            } else {
                d.a.l0.a.p0.f.b.h(this.f44045g, this.f44043e, this.f44044f);
            }
        }
    }

    public c(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/replaceDynamicLib");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.aiapps_debug_params_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "'params' is null");
            return false;
        }
        String optString = a2.optString("url");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.aiapps_debug_dynamic_lib_url_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "dynamic lib 'url' is empty");
            return false;
        }
        String optString2 = a2.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.l0.a.z1.b.f.e.f(context, d.a.l0.a.h.aiapps_debug_dynamic_lib_cb_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "dynamic lib 'cb' is empty");
            return false;
        }
        eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, optString));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
