package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        aVar.f35095a = jSONObject.optInt("entryType");
        aVar.f35096b = jSONObject.optString("sourceDesc");
        aVar.f35097c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f35098d = jSONObject.optInt("likePos");
        aVar.f35099e = jSONObject.optString("entryId");
        aVar.f35100f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f35101g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f35102h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f35103i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
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
            com.kwad.sdk.utils.q.a(jSONObject, "entryType", aVar.f35095a);
            com.kwad.sdk.utils.q.a(jSONObject, "sourceDesc", aVar.f35096b);
            com.kwad.sdk.utils.q.a(jSONObject, "sourceDescPos", aVar.f35097c);
            com.kwad.sdk.utils.q.a(jSONObject, "likePos", aVar.f35098d);
            com.kwad.sdk.utils.q.a(jSONObject, "entryId", aVar.f35099e);
            com.kwad.sdk.utils.q.a(jSONObject, "entryTitle", aVar.f35100f);
            com.kwad.sdk.utils.q.a(jSONObject, "entryTitlePos", aVar.f35101g);
            com.kwad.sdk.utils.q.a(jSONObject, "videoDurationPos", aVar.f35102h);
            com.kwad.sdk.utils.q.a(jSONObject, "videoDescPos", aVar.f35103i);
            com.kwad.sdk.utils.q.a(jSONObject, "commentsPos", aVar.j);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
