package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ReportPurchaseRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int currencyType;
    public String expand;
    public final String purchaseData;
    public final String purchaseSign;
    public String seq;
    public int sid;
    public long uid;
    public int usedChannel;

    public ReportPurchaseRequest(long j2, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sid = 0;
        this.usedChannel = 10002;
        this.uid = j2;
        this.sid = i2;
        this.appId = i3;
        this.usedChannel = i4;
        this.currencyType = i5;
        this.seq = str;
        this.purchaseData = str3;
        this.purchaseSign = str4;
        this.expand = str5;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", 1045);
                jSONObject.put("uid", this.uid);
                jSONObject.put("sid", this.sid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put("currencyType", this.currencyType);
                jSONObject.put(IAdRequestParam.SEQ, this.seq);
                jSONObject.put("purchaseData", this.purchaseData);
                jSONObject.put("purchaseSign", this.purchaseSign);
                jSONObject.put("expand", this.expand);
                return jSONObject.toString().replaceAll("", "");
            } catch (JSONException e2) {
                RLog.error("ReportPurchaseRequest", "constructPSCIMessageRequest", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
