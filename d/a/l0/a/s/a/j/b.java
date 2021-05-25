package d.a.l0.a.s.a.j;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.h0.g.k;
import d.a.l0.a.s.a.f;
import d.a.l0.a.s.a.g;
import d.a.l0.a.s.a.h;
import d.a.l0.a.v2.q0;
import d.a.l0.t.i;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends a0 {

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public static final a f44596e = new a();

        @Override // java.lang.Runnable
        public final void run() {
            k.L2();
        }
    }

    public b(e eVar) {
        super(eVar, "/swanAPI/setTplBdussSync");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
        f.f44582d.l(true);
        if (optParamsAsJo == null) {
            d.a.l0.a.m.a d2 = f.f44582d.d();
            if (d2 != null) {
                d2.onResult(-1);
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            f.f44582d.a(g.d(), g.a());
            return false;
        }
        int optInt = optParamsAsJo.optInt("errno");
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
        q0.X(a.f44596e);
        if (optInt != 0) {
            d.a.l0.a.m.a d3 = f.f44582d.d();
            if (d3 != null) {
                d3.onResult(-1);
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
            f.f44582d.a(g.d(), g.a());
            return false;
        } else if (optJSONObject != null) {
            Map<String, String> c2 = i.c(CookieManager.getInstance().getCookie(Domains.BAIDU));
            Intrinsics.checkNotNullExpressionValue(c2, "SwanAppUrlUtils.parseCookie(cookieString)");
            String str = c2.get("OPENBDUSS");
            if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
                h.f44593b.c(optInt, optJSONObject);
                d.a.l0.a.s.a.a.b(context, str);
                f.f44582d.j(true);
                d.a.l0.a.m.a d4 = f.f44582d.d();
                if (d4 != null) {
                    d4.onResult(0);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, entity, 0);
                f.f44582d.a(g.f(), g.c());
                return true;
            }
            d.a.l0.a.m.a d5 = f.f44582d.d();
            if (d5 != null) {
                d5.onResult(-1);
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "bduss is null");
            f.f44582d.a(g.d(), g.a());
            return false;
        } else {
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "json data is null");
            f.f44582d.a(g.d(), g.a());
            return false;
        }
    }
}
