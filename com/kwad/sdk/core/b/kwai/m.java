package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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
    public void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("thirdAge");
        aVar.f58643b = jSONObject.optInt("thirdGender");
        aVar.f58644c = jSONObject.optString("thirdInterest");
        if (jSONObject.opt("thirdInterest") == JSONObject.NULL) {
            aVar.f58644c = "";
        }
        aVar.f58645d = jSONObject.optString("prevTitle");
        if (jSONObject.opt("prevTitle") == JSONObject.NULL) {
            aVar.f58645d = "";
        }
        aVar.f58646e = jSONObject.optString("postTitle");
        if (jSONObject.opt("postTitle") == JSONObject.NULL) {
            aVar.f58646e = "";
        }
        aVar.f58647f = jSONObject.optString("historyTitle");
        if (jSONObject.opt("historyTitle") == JSONObject.NULL) {
            aVar.f58647f = "";
        }
        aVar.f58648g = jSONObject.optString("channel");
        if (jSONObject.opt("channel") == JSONObject.NULL) {
            aVar.f58648g = "";
        }
        aVar.f58649h = jSONObject.optLong("cpmBidFloor");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "thirdAge", aVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "thirdGender", aVar.f58643b);
            com.kwad.sdk.utils.t.a(jSONObject, "thirdInterest", aVar.f58644c);
            com.kwad.sdk.utils.t.a(jSONObject, "prevTitle", aVar.f58645d);
            com.kwad.sdk.utils.t.a(jSONObject, "postTitle", aVar.f58646e);
            com.kwad.sdk.utils.t.a(jSONObject, "historyTitle", aVar.f58647f);
            com.kwad.sdk.utils.t.a(jSONObject, "channel", aVar.f58648g);
            com.kwad.sdk.utils.t.a(jSONObject, "cpmBidFloor", aVar.f58649h);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
