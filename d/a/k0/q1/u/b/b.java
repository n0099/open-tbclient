package d.a.k0.q1.u.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements ThirdPartWxRechargeService {

    /* renamed from: b  reason: collision with root package name */
    public static BroadcastReceiver f59788b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f59789a;

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public final /* synthetic */ ThirdPartWxRechargeService.WxPayType val$wxPayType;

        public a(ThirdPartWxRechargeService.WxPayType wxPayType) {
            this.val$wxPayType = wxPayType;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            intent.getExtras();
            String str = this.val$wxPayType instanceof ThirdPartWxRechargeService.WxPayType.WxPayYYLive ? "wx_pay_result" : "yy_wx_pay_result";
            HashMap hashMap = new HashMap();
            hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, Integer.valueOf(intent.getExtras().getInt("errorCode", -1)));
            hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, intent.getExtras().getString("errorMsg"));
            LiveNPSPluginManager.getInstance().dispatchHostEvent(TbadkCoreApplication.getInst().getContext(), str, hashMap);
        }
    }

    public final PayReq a(JSONObject jSONObject) {
        PayReq payReq = new PayReq();
        payReq.appId = jSONObject.optString("appid");
        payReq.partnerId = jSONObject.optString("partnerid");
        payReq.prepayId = jSONObject.optString("prepayid");
        payReq.packageValue = jSONObject.optString(AsInstallService.SCHEME_PACKAGE_ADDED);
        payReq.nonceStr = jSONObject.optString("noncestr");
        payReq.timeStamp = jSONObject.optString("timestamp");
        payReq.sign = jSONObject.optString("sign");
        payReq.extData = "YY";
        return payReq;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public void initWx() {
        if (this.f59789a == null) {
            this.f59789a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public boolean isWxInstalled() {
        if (this.f59789a == null) {
            this.f59789a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
        }
        return this.f59789a.isWXAppInstalled();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public void wxRecharge(String str, ThirdPartWxRechargeService.WxPayType wxPayType) {
        try {
            if (this.f59789a == null) {
                this.f59789a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
            }
            PayReq a2 = a(new JSONObject(str));
            this.f59789a.registerApp(a2.appId);
            if (!this.f59789a.sendReq(a2)) {
                String str2 = wxPayType instanceof ThirdPartWxRechargeService.WxPayType.WxPayYYLive ? "wx_pay_result" : "yy_wx_pay_result";
                HashMap hashMap = new HashMap();
                hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, 6);
                hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, "wx_start_failed");
                LiveNPSPluginManager.getInstance().dispatchHostEvent(TbadkCoreApplication.getInst().getContext(), str2, hashMap);
            }
            if (f59788b != null) {
                TbadkCoreApplication.getInst().unregisterReceiver(f59788b);
            }
            f59788b = new a(wxPayType);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("WXPayResult");
            TbadkCoreApplication.getInst().registerReceiver(f59788b, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
