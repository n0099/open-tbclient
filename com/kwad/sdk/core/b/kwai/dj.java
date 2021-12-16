package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dj implements com.kwad.sdk.core.d<PhotoInfo.ProductInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dj() {
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
    public void a(PhotoInfo.ProductInfo productInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, productInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        productInfo.productId = jSONObject.optLong("productId");
        productInfo.shennongjiaLog = jSONObject.optString("shennongjiaLog");
        if (jSONObject.opt("shennongjiaLog") == JSONObject.NULL) {
            productInfo.shennongjiaLog = "";
        }
        productInfo.productDetails = jSONObject.optString("productDetail");
        if (jSONObject.opt("productDetail") == JSONObject.NULL) {
            productInfo.productDetails = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.ProductInfo productInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, productInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "productId", productInfo.productId);
            com.kwad.sdk.utils.t.a(jSONObject, "shennongjiaLog", productInfo.shennongjiaLog);
            com.kwad.sdk.utils.t.a(jSONObject, "productDetail", productInfo.productDetails);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
