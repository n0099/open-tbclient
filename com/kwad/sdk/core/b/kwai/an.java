package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.tachikoma.config.TKConfigResultData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class an implements com.kwad.sdk.core.d<TKConfigResultData.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public an() {
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
    public void a(TKConfigResultData.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optLong("interval");
        aVar.f60398b = jSONObject.optString("jsVersion");
        if (jSONObject.opt("jsVersion") == JSONObject.NULL) {
            aVar.f60398b = "";
        }
        aVar.f60399c = jSONObject.optString("dynamicUrl");
        if (jSONObject.opt("dynamicUrl") == JSONObject.NULL) {
            aVar.f60399c = "";
        }
        aVar.f60400d = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.f60400d = "";
        }
        aVar.f60401e = jSONObject.optInt("dynamicType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(TKConfigResultData.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "interval", aVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "jsVersion", aVar.f60398b);
            com.kwad.sdk.utils.t.a(jSONObject, "dynamicUrl", aVar.f60399c);
            com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, aVar.f60400d);
            com.kwad.sdk.utils.t.a(jSONObject, "dynamicType", aVar.f60401e);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
