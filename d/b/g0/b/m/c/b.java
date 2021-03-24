package d.b.g0.b.m.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.Domains;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.v;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f47403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47404f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47405g;

        public a(Context context, CallbackHandler callbackHandler, String str) {
            this.f47403e = context;
            this.f47404f = callbackHandler;
            this.f47405g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            b.this.l(hVar, this.f47403e, this.f47404f, this.f47405g);
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/getCommonSysInfo");
    }

    @Override // d.b.g0.a.t1.k.a0
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
        String c2 = d.b.g0.a.w0.a.O().c(appContext);
        String r = k0.r();
        String E = d.b.g0.b.i.a.E(context);
        String a2 = d.b.g0.a.w0.a.O().a(appContext);
        String cookie = d.b.g0.a.w0.a.m().a().getCookie(Domains.BAIDU);
        String k = i0.k(cookie, "BAIDUID");
        String k2 = i0.k(cookie, "H_WISE_SIDS");
        String a3 = d.b.g0.q.b.b(AppRuntime.getAppContext()).a();
        if (a0.f46287b) {
            Log.d("GetSysInfoAction", "cuid = " + c2 + ", imei = " + r + ", zid = " + E + ", uid = " + a2 + ", baiDuId = " + k + ", sid = " + k2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", c2);
            jSONObject.put("imei", r);
            jSONObject.put("zid", E);
            jSONObject.put("uid", a2);
            jSONObject.put("baidu_id", k);
            jSONObject.put("sid", k2);
            jSONObject.put("uuid", a3);
            c.g("GetSysInfo", "fetch commonSysInfo success");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e2) {
            if (a0.f46287b) {
                e2.printStackTrace();
            }
            c.b("GetSysInfo", "generate data occur exception");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void l(h<b.e> hVar, Context context, CallbackHandler callbackHandler, String str) {
        if (!d.b.g0.a.v1.c.c.h(hVar)) {
            d.b.g0.a.v1.c.c.o(hVar, callbackHandler, str);
        } else {
            k(context, str, callbackHandler);
        }
    }
}
