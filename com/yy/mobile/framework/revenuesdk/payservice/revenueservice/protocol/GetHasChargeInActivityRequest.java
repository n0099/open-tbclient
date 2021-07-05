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
/* loaded from: classes8.dex */
public class GetHasChargeInActivityRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int activityId;
    public int appId;
    public int currencyType;
    public String seq;
    public long uid;
    public int usedChannel;

    public GetHasChargeInActivityRequest(String str, long j, int i2, int i3, int i4, int i5, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.seq = str;
        this.uid = j;
        this.appId = i2;
        this.usedChannel = i3;
        this.currencyType = i4;
        this.activityId = i5;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", 1026);
                jSONObject.put(IAdRequestParam.SEQ, this.seq);
                jSONObject.put("uid", this.uid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put("currencyType", this.currencyType);
                jSONObject.put("activityId", this.activityId);
                return jSONObject.toString();
            } catch (JSONException e2) {
                RLog.error("GetHasChargeInActivityRequest", "constructPSCIMessageRequest error.", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
