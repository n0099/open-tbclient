package d.a.h0.b.m.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.Domains;
import d.a.h0.a.c0.c;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.v;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45572f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45573g;

        public a(Context context, CallbackHandler callbackHandler, String str) {
            this.f45571e = context;
            this.f45572f = callbackHandler;
            this.f45573g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            b.this.l(hVar, this.f45571e, this.f45572f, this.f45573g);
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/getCommonSysInfo");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.g("GetSysInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = v.b(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.g("GetSysInfo", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.R().g(context, "mapp_i_get_common_sys_info", new a(context, callbackHandler, optString));
        c.g("GetSysInfo", "callback success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(Context context, String str, CallbackHandler callbackHandler) {
        Context appContext = AppRuntime.getAppContext();
        String f2 = d.a.h0.a.w0.a.O().f(appContext);
        String r = k0.r();
        String E = d.a.h0.b.i.a.E(context);
        String e2 = d.a.h0.a.w0.a.O().e(appContext);
        String cookie = d.a.h0.a.w0.a.m().a().getCookie(Domains.BAIDU);
        String k = i0.k(cookie, "BAIDUID");
        String k2 = i0.k(cookie, "H_WISE_SIDS");
        String a2 = d.a.h0.q.b.b(AppRuntime.getAppContext()).a();
        if (a0.f44398b) {
            Log.d("GetSysInfoAction", "cuid = " + f2 + ", imei = " + r + ", zid = " + E + ", uid = " + e2 + ", baiDuId = " + k + ", sid = " + k2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", f2);
            jSONObject.put("imei", r);
            jSONObject.put("zid", E);
            jSONObject.put("uid", e2);
            jSONObject.put("baidu_id", k);
            jSONObject.put("sid", k2);
            jSONObject.put("uuid", a2);
            c.g("GetSysInfo", "fetch commonSysInfo success");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e3) {
            if (a0.f44398b) {
                e3.printStackTrace();
            }
            c.b("GetSysInfo", "generate data occur exception");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void l(h<b.e> hVar, Context context, CallbackHandler callbackHandler, String str) {
        if (!d.a.h0.a.v1.c.c.h(hVar)) {
            d.a.h0.a.v1.c.c.o(hVar, callbackHandler, str);
        } else {
            k(context, str, callbackHandler);
        }
    }
}
