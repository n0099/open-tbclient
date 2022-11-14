package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetSplitOrderConfigRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long amount;
    public int appId;
    public int currencyType;
    public String expand;
    public String orderId;
    public String seq;
    public int type;
    public long uid;
    public int usedChannel;

    public GetSplitOrderConfigRequest(long j, int i, int i2, int i3, String str, String str2, String str3, long j2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Long.valueOf(j2), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.usedChannel = 10002;
        this.uid = j;
        this.type = i;
        this.appId = i2;
        this.usedChannel = i3;
        this.seq = str;
        this.expand = str2;
        this.orderId = str3;
        this.amount = j2;
        this.currencyType = i4;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", RevenueServerConst.GetChargeCurrencySplitRequest);
                jSONObject.put("uid", this.uid);
                jSONObject.put("type", this.type);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put("seq", this.seq);
                jSONObject.put("orderId", this.orderId);
                jSONObject.put(PayUiEventContent.AMOUNT, this.amount);
                jSONObject.put("currencyType", this.currencyType);
                jSONObject.put("expand", this.expand);
                return jSONObject.toString();
            } catch (JSONException e) {
                RLog.error("GetSplitOrderConfigRequest", "constructPSCIMessageRequest", e);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
