package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bg implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bg() {
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
        aVar.a = jSONObject.optInt("entryType");
        aVar.f57810b = jSONObject.optString("sourceDesc");
        if (jSONObject.opt("sourceDesc") == JSONObject.NULL) {
            aVar.f57810b = "";
        }
        aVar.f57811c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f57812d = jSONObject.optInt("likePos");
        aVar.f57813e = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            aVar.f57813e = "";
        }
        aVar.f57814f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f57815g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f57816h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f57817i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.f57818j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
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
            com.kwad.sdk.utils.t.a(jSONObject, "entryType", aVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "sourceDesc", aVar.f57810b);
            com.kwad.sdk.utils.t.a(jSONObject, "sourceDescPos", aVar.f57811c);
            com.kwad.sdk.utils.t.a(jSONObject, "likePos", aVar.f57812d);
            com.kwad.sdk.utils.t.a(jSONObject, "entryId", aVar.f57813e);
            com.kwad.sdk.utils.t.a(jSONObject, "entryTitle", aVar.f57814f);
            com.kwad.sdk.utils.t.a(jSONObject, "entryTitlePos", aVar.f57815g);
            com.kwad.sdk.utils.t.a(jSONObject, "videoDurationPos", aVar.f57816h);
            com.kwad.sdk.utils.t.a(jSONObject, "videoDescPos", aVar.f57817i);
            com.kwad.sdk.utils.t.a(jSONObject, "commentsPos", aVar.f57818j);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
