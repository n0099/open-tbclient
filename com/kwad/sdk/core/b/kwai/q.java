package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q implements com.kwad.sdk.core.d<AdProductInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q() {
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
    public void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adProductInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adProductInfo.icon = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            adProductInfo.icon = "";
        }
        adProductInfo.name = jSONObject.optString("name");
        if (jSONObject.opt("name") == JSONObject.NULL) {
            adProductInfo.name = "";
        }
        adProductInfo.price = jSONObject.optString("price");
        if (jSONObject.opt("price") == JSONObject.NULL) {
            adProductInfo.price = "";
        }
        adProductInfo.originPrice = jSONObject.optString("originPrice");
        if (jSONObject.opt("originPrice") == JSONObject.NULL) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("couponList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(optJSONArray.optJSONObject(i2));
                adProductInfo.couponList.add(couponInfo);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, adProductInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "icon", adProductInfo.icon);
            com.kwad.sdk.utils.t.a(jSONObject, "name", adProductInfo.name);
            com.kwad.sdk.utils.t.a(jSONObject, "price", adProductInfo.price);
            com.kwad.sdk.utils.t.a(jSONObject, "originPrice", adProductInfo.originPrice);
            com.kwad.sdk.utils.t.a(jSONObject, "couponList", adProductInfo.couponList);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
