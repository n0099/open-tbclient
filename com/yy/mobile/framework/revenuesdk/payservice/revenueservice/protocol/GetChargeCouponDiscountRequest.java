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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetChargeCouponDiscountRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public List<Integer> chargeConfigIds;
    public int currencyType;
    public String payChannel;
    public String seq;
    public long uid;
    public int usedChannel;
    public int userCouponId;

    public GetChargeCouponDiscountRequest(String str, String str2, long j, int i, int i2, int i3, int i4, String str3, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str3, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.seq = str;
        this.uid = j;
        this.appId = i;
        this.currencyType = i2;
        this.usedChannel = i3;
        this.userCouponId = i4;
        this.payChannel = str3;
        this.chargeConfigIds = list;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            List<Integer> list = this.chargeConfigIds;
            if (list != null) {
                for (Integer num : list) {
                    jSONArray.put(num);
                }
            }
            try {
                jSONObject.put("cmd", RevenueServerConst.GetChargeCouponDiscountRequest);
                jSONObject.put("uid", this.uid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("currencyType", this.currencyType);
                jSONObject.put("seq", this.seq);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put("userCouponId", this.userCouponId);
                jSONObject.put("payChannel", this.payChannel);
                jSONObject.put("chargeConfigIds", jSONArray);
                return jSONObject.toString();
            } catch (JSONException e) {
                RLog.error("GetChargeCouponDiscountRequest", "GetChargeCouponDiscountRequest error.", e);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
