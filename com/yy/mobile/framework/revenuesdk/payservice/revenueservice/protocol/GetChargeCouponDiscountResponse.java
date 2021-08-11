package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CouponDiscountInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetChargeCouponDiscountResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int cmd;
    public List<CouponDiscountInfo> couponDiscountInfoList;
    public boolean hasMore;
    public String message;
    public int result;
    public String seq;
    public long uid;
    public int userCouponId;

    public GetChargeCouponDiscountResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cmd = RevenueServerConst.GetChargeCouponDiscountResponse;
        this.couponDiscountInfoList = new ArrayList();
        parserResponse(str);
    }

    private List<CouponDiscountInfo> optCouponDiscountInfo(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    CouponDiscountInfo couponDiscountInfo = new CouponDiscountInfo();
                    couponDiscountInfo.cid = optJSONObject.optInt(IAdRequestParam.CELL_ID);
                    couponDiscountInfo.couponEnabled = optJSONObject.optBoolean("couponEnabled");
                    couponDiscountInfo.srcAmount = optJSONObject.optDouble("srcAmount", 0.0d);
                    couponDiscountInfo.discountAmount = optJSONObject.optDouble("discountAmount", 0.0d);
                    couponDiscountInfo.discountProductId = optJSONObject.optString("discountProductId");
                    couponDiscountInfo.srcCurrencySymbol = optJSONObject.optString("srcCurrencySymbol");
                    arrayList.add(couponDiscountInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !"".equals(str.trim())) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("cmd");
                    if (this.cmd == optInt) {
                        this.uid = jSONObject.optLong("uid");
                        this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                        this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                        this.result = jSONObject.optInt("result");
                        this.message = jSONObject.optString("message");
                        this.userCouponId = jSONObject.optInt("userCouponId");
                        this.couponDiscountInfoList.addAll(optCouponDiscountInfo(jSONObject.optJSONArray("discountList")));
                        return;
                    }
                    throw new Exception(this.cmd + " != " + optInt);
                } catch (JSONException e2) {
                    RLog.error("GetChargeCouponDiscountResponse", "parserResponse error.", e2);
                    return;
                } catch (Exception e3) {
                    RLog.error("GetChargeCouponDiscountResponse", "parserResponse error.", e3);
                    return;
                }
            }
            RLog.error("GetChargeCouponDiscountResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
        }
    }
}
