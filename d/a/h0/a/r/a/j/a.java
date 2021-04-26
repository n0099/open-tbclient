package d.a.h0.a.r.a.j;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
import d.a.h0.a.e0.l.i;
import d.a.h0.a.i2.k0;
import d.a.h0.a.r.a.f;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.p.h;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends a0 {

    /* renamed from: d.a.h0.a.r.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class RunnableC0744a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public static final RunnableC0744a f43781e = new RunnableC0744a();

        @Override // java.lang.Runnable
        public final void run() {
            i.E2();
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/setTplBdussSync");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f.f43778d.h(true);
        if (optParamsAsJo == null) {
            d.a.h0.a.m.a c2 = f.f43778d.c();
            if (c2 != null) {
                c2.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        int optInt = optParamsAsJo.optInt("errno");
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        k0.T(RunnableC0744a.f43781e);
        if (optInt != 0) {
            d.a.h0.a.m.a c3 = f.f43778d.c();
            if (c3 != null) {
                c3.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            return false;
        } else if (optJSONObject != null) {
            String str = h.c(CookieManager.getInstance().getCookie(Domains.BAIDU)).get("OPENBDUSS");
            if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
                d.a.h0.a.r.a.h.f43780a.a(optInt, optJSONObject);
                d.a.h0.a.r.a.a.b(context, str);
                f.f43778d.f(true);
                d.a.h0.a.m.a c4 = f.f43778d.c();
                if (c4 != null) {
                    c4.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.h0.a.m.a c5 = f.f43778d.c();
            if (c5 != null) {
                c5.onResult(-1);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "bduss is null");
            return false;
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "json data is null");
            return false;
        }
    }
}
