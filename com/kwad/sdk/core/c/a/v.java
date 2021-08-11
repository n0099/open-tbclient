package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class v implements com.kwad.sdk.core.d<PhotoInfo.AuthorInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v() {
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
    public void a(PhotoInfo.AuthorInfo authorInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, authorInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        authorInfo.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        authorInfo.kwaiId = jSONObject.optString("kwaiId");
        authorInfo.authorName = jSONObject.optString("authorName");
        authorInfo.rawAuthorName = jSONObject.optString("rawAuthorName");
        authorInfo.authorIcon = jSONObject.optString("authorIcon");
        authorInfo.authorGender = jSONObject.optString("authorGender");
        authorInfo.authorText = jSONObject.optString("authorText");
        authorInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.AuthorInfo authorInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, authorInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, URLPackage.KEY_AUTHOR_ID, authorInfo.authorId);
            com.kwad.sdk.utils.q.a(jSONObject, "kwaiId", authorInfo.kwaiId);
            com.kwad.sdk.utils.q.a(jSONObject, "authorName", authorInfo.authorName);
            com.kwad.sdk.utils.q.a(jSONObject, "rawAuthorName", authorInfo.rawAuthorName);
            com.kwad.sdk.utils.q.a(jSONObject, "authorIcon", authorInfo.authorIcon);
            com.kwad.sdk.utils.q.a(jSONObject, "authorGender", authorInfo.authorGender);
            com.kwad.sdk.utils.q.a(jSONObject, "authorText", authorInfo.authorText);
            com.kwad.sdk.utils.q.a(jSONObject, "authorIconGuide", authorInfo.authorIconGuide);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
