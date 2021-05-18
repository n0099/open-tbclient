package d.a.i0.a.c2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.i0.a.k;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class c extends UnitedSchemeBaseDispatcher {
    static {
        boolean z = k.f43025a;
    }

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
        d.a.i0.a.e0.d.a("SwanWalletDispatcher", "entity uri = ", unitedSchemeEntity.getUri());
        d.a.i0.a.e0.d.g("SwanWalletDispatcher", "start UnitedSchemeWalletDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            d.a.i0.a.e0.d.h("SwanWalletDispatcher", "Error: uri action is null.");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            d.a.i0.a.e0.d.h("SwanWalletDispatcher", "Error: is only verify.");
            return true;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.i0.a.e0.d.h("SwanWalletDispatcher", "Error: params is null.");
                return false;
            }
            String optString = optParamsAsJo.optString("orderInfo");
            String optString2 = optParamsAsJo.optString("version");
            String optString3 = optParamsAsJo.optString("cb");
            d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
            if (i2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.i0.a.e0.d.h("SwanWalletDispatcher", "Error: swan app is null.");
                return false;
            } else if (i2.x() == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.i0.a.e0.d.h("SwanWalletDispatcher", "Error: swan activity is null.");
                return false;
            } else {
                String optString4 = optParamsAsJo.optString("from");
                if (TextUtils.isEmpty(optString4)) {
                    optString4 = RetrieveTaskManager.KEY;
                }
                String str = optString4;
                d.a.i0.a.q1.b bVar = new d.a.i0.a.q1.b(i2, unitedSchemeEntity, callbackHandler, optString2, i2.D(), optString3);
                if ("requestPayment".equals(path)) {
                    d.a.i0.a.e0.d.g("SwanWalletDispatcher", "start PAYMENT");
                    d.a.i0.a.j2.k.F("baiduqianbao", "create", 0);
                    return bVar.B("mapp_request_duxiaoman", optString, str);
                } else if ("requestAliPayment".equals(path)) {
                    d.a.i0.a.e0.d.g("SwanWalletDispatcher", "start ALI PAYMENT");
                    d.a.i0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "create", 0);
                    return bVar.B("mapp_request_alipayment", optString, str);
                } else if ("requestPolymerPayment".equals(path)) {
                    d.a.i0.a.e0.d.g("SwanWalletDispatcher", "start POLYMER PAYMENT");
                    d.a.i0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "create", 0);
                    return bVar.J(optString, optParamsAsJo);
                } else if (TextUtils.equals("requestWeChatPayment", path)) {
                    d.a.i0.a.e0.d.g("SwanWalletDispatcher", "start WECHAT HTML5 PAYMENT");
                    d.a.i0.a.j2.k.F("wechatH5Action", "create", 0);
                    return bVar.B("mapp_request_wechatpayment", optString, str);
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
        }
    }
}
