package d.b.g0.a.t1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.k;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class h extends UnitedSchemeBaseDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46284a = k.f45050a;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "BDWallet";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.b.g0.a.c0.c.a("SwanWalletDispatcher", "entity uri = ", unitedSchemeEntity.getUri());
        d.b.g0.a.c0.c.g("SwanWalletDispatcher", "start UnitedSchemeWalletDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (f46284a) {
                Log.w("SwanWalletDispatcher", "Uri action is null");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = optParamsAsJo.optString("orderInfo");
            String optString2 = optParamsAsJo.optString("version");
            String optString3 = optParamsAsJo.optString("cb");
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            if (y == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (y.n() == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                d.b.g0.a.i1.b bVar = new d.b.g0.a.i1.b(y, unitedSchemeEntity, callbackHandler, optString2, y.B(), optString3);
                if ("requestPayment".equals(path)) {
                    d.b.g0.a.c0.c.g("SwanWalletDispatcher", "start PAYMENT");
                    return bVar.z("mapp_request_duxiaoman", optString);
                } else if ("requestAliPayment".equals(path)) {
                    d.b.g0.a.c0.c.g("SwanWalletDispatcher", "start ALI PAYMENT");
                    return bVar.z("mapp_request_alipayment", optString);
                } else if ("requestPolymerPayment".equals(path)) {
                    d.b.g0.a.c0.c.g("SwanWalletDispatcher", "start POLYMER PAYMENT");
                    return bVar.G(optString, optParamsAsJo);
                } else if (TextUtils.equals("requestWeChatPayment", path)) {
                    d.b.g0.a.c0.c.g("SwanWalletDispatcher", "start WECHAT HTML5 PAYMENT");
                    return bVar.z("mapp_request_wechatpayment", optString);
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
        }
    }
}
