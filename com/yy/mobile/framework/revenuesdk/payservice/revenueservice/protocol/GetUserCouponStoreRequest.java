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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetUserCouponStoreRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int goodsType;
    public boolean hasUsed;
    public boolean includeExpire;
    public int page;
    public int pageSize;
    public String seq;
    public long uid;

    public GetUserCouponStoreRequest(String str, long j, int i, String str2, int i2, boolean z, int i3, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Integer.valueOf(i), str2, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2)};
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
        this.goodsType = i2;
        this.hasUsed = z;
        this.page = i3;
        this.pageSize = i4;
        this.includeExpire = z2;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", RevenueServerConst.GetUserCouponStoreRequest);
                jSONObject.put("seq", this.seq);
                jSONObject.put("uid", this.uid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("goodsType", this.goodsType);
                jSONObject.put("hasUsed", this.hasUsed);
                jSONObject.put("page", this.page);
                jSONObject.put("pageSize", this.pageSize);
                jSONObject.put("includeExpire", this.includeExpire);
                return jSONObject.toString();
            } catch (JSONException e2) {
                RLog.error("GetUserCouponStoreRequest", "constructPSCIMessageRequest error.", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
