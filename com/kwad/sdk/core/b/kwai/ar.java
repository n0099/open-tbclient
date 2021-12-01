package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.kwad.sdk.contentalliance.coupon.model.CouponStatusInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ar implements com.kwad.sdk.core.d<CouponStatusInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ar() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(CouponStatusInfo couponStatusInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, couponStatusInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        couponStatusInfo.statusCode = jSONObject.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, new Integer("-1").intValue());
        couponStatusInfo.statusName = jSONObject.optString("statusName");
        if (jSONObject.opt("statusName") == JSONObject.NULL) {
            couponStatusInfo.statusName = "";
        }
        couponStatusInfo.currTotalAmount = jSONObject.optDouble("currTotalAmount");
        couponStatusInfo.couponLeftTimes = jSONObject.optInt("couponLeftTimes");
        couponStatusInfo.isNewUser = jSONObject.optBoolean("isNewUser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(CouponStatusInfo couponStatusInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, couponStatusInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, EnterDxmPayServiceAction.SERVICE_STATUS_CODE, couponStatusInfo.statusCode);
            com.kwad.sdk.utils.t.a(jSONObject, "statusName", couponStatusInfo.statusName);
            com.kwad.sdk.utils.t.a(jSONObject, "currTotalAmount", couponStatusInfo.currTotalAmount);
            com.kwad.sdk.utils.t.a(jSONObject, "couponLeftTimes", couponStatusInfo.couponLeftTimes);
            com.kwad.sdk.utils.t.a(jSONObject, "isNewUser", couponStatusInfo.isNewUser);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
