package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class an implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
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
    public void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.f72579a = jSONObject.optInt("entryType");
        aVar.f72580b = jSONObject.optString("sourceDesc");
        aVar.f72581c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f72582d = jSONObject.optInt("likePos");
        aVar.f72583e = jSONObject.optString("entryId");
        aVar.f72584f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f72585g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f72586h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f72587i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.f72588j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "entryType", aVar.f72579a);
            com.kwad.sdk.utils.q.a(jSONObject, "sourceDesc", aVar.f72580b);
            com.kwad.sdk.utils.q.a(jSONObject, "sourceDescPos", aVar.f72581c);
            com.kwad.sdk.utils.q.a(jSONObject, "likePos", aVar.f72582d);
            com.kwad.sdk.utils.q.a(jSONObject, "entryId", aVar.f72583e);
            com.kwad.sdk.utils.q.a(jSONObject, "entryTitle", aVar.f72584f);
            com.kwad.sdk.utils.q.a(jSONObject, "entryTitlePos", aVar.f72585g);
            com.kwad.sdk.utils.q.a(jSONObject, "videoDurationPos", aVar.f72586h);
            com.kwad.sdk.utils.q.a(jSONObject, "videoDescPos", aVar.f72587i);
            com.kwad.sdk.utils.q.a(jSONObject, "commentsPos", aVar.f72588j);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
