package d.a.s0.u1.u.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements ThirdPartWxRechargeService {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static BroadcastReceiver f67341b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f67342a;

    /* loaded from: classes9.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;
        public final /* synthetic */ ThirdPartWxRechargeService.WxPayType val$wxPayType;

        public a(b bVar, ThirdPartWxRechargeService.WxPayType wxPayType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, wxPayType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bVar;
            this.val$wxPayType = wxPayType;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                intent.getExtras();
                String str = this.val$wxPayType instanceof ThirdPartWxRechargeService.WxPayType.WxPayYYLive ? "wx_pay_result" : "yy_wx_pay_result";
                HashMap hashMap = new HashMap();
                hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, Integer.valueOf(intent.getExtras().getInt("errorCode", -1)));
                hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, intent.getExtras().getString("errorMsg"));
                LiveNPSPluginManager.getInstance().dispatchHostEvent(TbadkCoreApplication.getInst().getContext(), str, hashMap);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1292045350, "Ld/a/s0/u1/u/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1292045350, "Ld/a/s0/u1/u/b/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final PayReq a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
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
        return (PayReq) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public void initWx() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f67342a == null) {
            this.f67342a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public boolean isWxInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f67342a == null) {
                this.f67342a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
            }
            return this.f67342a.isWXAppInstalled();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService
    public void wxRecharge(String str, ThirdPartWxRechargeService.WxPayType wxPayType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wxPayType) == null) {
            try {
                if (this.f67342a == null) {
                    this.f67342a = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), null);
                }
                PayReq a2 = a(new JSONObject(str));
                this.f67342a.registerApp(a2.appId);
                if (!this.f67342a.sendReq(a2)) {
                    String str2 = wxPayType instanceof ThirdPartWxRechargeService.WxPayType.WxPayYYLive ? "wx_pay_result" : "yy_wx_pay_result";
                    HashMap hashMap = new HashMap();
                    hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, 6);
                    hashMap.put(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, "wx_start_failed");
                    LiveNPSPluginManager.getInstance().dispatchHostEvent(TbadkCoreApplication.getInst().getContext(), str2, hashMap);
                }
                if (f67341b != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(f67341b);
                }
                f67341b = new a(this, wxPayType);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("WXPayResult");
                TbadkCoreApplication.getInst().registerReceiver(f67341b, intentFilter);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
