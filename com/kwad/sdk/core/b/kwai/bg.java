package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
        aVar.f58391b = jSONObject.optString("sourceDesc");
        if (jSONObject.opt("sourceDesc") == JSONObject.NULL) {
            aVar.f58391b = "";
        }
        aVar.f58392c = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.f58393d = jSONObject.optInt("likePos");
        aVar.f58394e = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            aVar.f58394e = "";
        }
        aVar.f58395f = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.f58396g = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.f58397h = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.f58398i = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.f58399j = jSONObject.optInt("commentsPos", new Integer("1").intValue());
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
            com.kwad.sdk.utils.t.a(jSONObject, "sourceDesc", aVar.f58391b);
            com.kwad.sdk.utils.t.a(jSONObject, "sourceDescPos", aVar.f58392c);
            com.kwad.sdk.utils.t.a(jSONObject, "likePos", aVar.f58393d);
            com.kwad.sdk.utils.t.a(jSONObject, "entryId", aVar.f58394e);
            com.kwad.sdk.utils.t.a(jSONObject, "entryTitle", aVar.f58395f);
            com.kwad.sdk.utils.t.a(jSONObject, "entryTitlePos", aVar.f58396g);
            com.kwad.sdk.utils.t.a(jSONObject, "videoDurationPos", aVar.f58397h);
            com.kwad.sdk.utils.t.a(jSONObject, "videoDescPos", aVar.f58398i);
            com.kwad.sdk.utils.t.a(jSONObject, "commentsPos", aVar.f58399j);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
