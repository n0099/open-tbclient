package d.a.i0.b.n.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.Domains;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.v2.o0;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46190e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46191f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46192g;

        public a(Context context, CallbackHandler callbackHandler, String str) {
            this.f46190e = context;
            this.f46191f = callbackHandler;
            this.f46192g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            b.this.l(iVar, this.f46190e, this.f46191f, this.f46192g);
        }
    }

    public b(e eVar) {
        super(eVar, "/swanAPI/getCommonSysInfo");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            d.g("GetSysInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.g("GetSysInfo", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.T().g(context, "mapp_i_get_common_sys_info", new a(context, callbackHandler, optString));
        d.g("GetSysInfo", "callback success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void k(Context context, String str, CallbackHandler callbackHandler) {
        Context appContext = AppRuntime.getAppContext();
        String i2 = d.a.i0.a.c1.a.a0().i(appContext);
        String r = q0.r();
        String D = d.a.i0.b.j.a.D(context);
        String h2 = d.a.i0.a.c1.a.a0().h(appContext);
        String cookie = d.a.i0.a.c1.a.p().a().getCookie(Domains.BAIDU);
        String l = o0.l(cookie, "BAIDUID");
        String l2 = o0.l(cookie, "H_WISE_SIDS");
        String a2 = d.a.i0.u.b.b(AppRuntime.getAppContext()).a();
        if (a0.f40775b) {
            Log.d("GetSysInfoAction", "cuid = " + i2 + ", imei = " + r + ", zid = " + D + ", uid = " + h2 + ", baiDuId = " + l + ", sid = " + l2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", i2);
            jSONObject.put("imei", r);
            jSONObject.put("zid", D);
            jSONObject.put("uid", h2);
            jSONObject.put("baidu_id", l);
            jSONObject.put("sid", l2);
            jSONObject.put("uuid", a2);
            d.g("GetSysInfo", "fetch commonSysInfo success");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e2) {
            if (a0.f40775b) {
                e2.printStackTrace();
            }
            d.b("GetSysInfo", "generate data occur exception");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void l(i<b.e> iVar, Context context, CallbackHandler callbackHandler, String str) {
        if (!d.a.i0.a.e2.c.d.h(iVar)) {
            d.a.i0.a.e2.c.d.p(iVar, callbackHandler, str);
        } else {
            k(context, str, callbackHandler);
        }
    }
}
