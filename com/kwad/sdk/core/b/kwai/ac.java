package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ac implements com.kwad.sdk.core.d<PhotoInfo.AuthorInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ac() {
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
        if (jSONObject.opt("kwaiId") == JSONObject.NULL) {
            authorInfo.kwaiId = "";
        }
        authorInfo.authorName = jSONObject.optString("authorName");
        if (jSONObject.opt("authorName") == JSONObject.NULL) {
            authorInfo.authorName = "";
        }
        authorInfo.rawAuthorName = jSONObject.optString("rawAuthorName");
        if (jSONObject.opt("rawAuthorName") == JSONObject.NULL) {
            authorInfo.rawAuthorName = "";
        }
        authorInfo.authorIcon = jSONObject.optString("authorIcon");
        if (jSONObject.opt("authorIcon") == JSONObject.NULL) {
            authorInfo.authorIcon = "";
        }
        authorInfo.authorGender = jSONObject.optString("authorGender");
        if (jSONObject.opt("authorGender") == JSONObject.NULL) {
            authorInfo.authorGender = "";
        }
        authorInfo.authorText = jSONObject.optString("authorText");
        if (jSONObject.opt("authorText") == JSONObject.NULL) {
            authorInfo.authorText = "";
        }
        authorInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
        if (jSONObject.opt("authorIconGuide") == JSONObject.NULL) {
            authorInfo.authorIconGuide = "";
        }
        authorInfo.authorEid = jSONObject.optString("authorEid");
        if (jSONObject.opt("authorEid") == JSONObject.NULL) {
            authorInfo.authorEid = "";
        }
        authorInfo.isJoinedBlacklist = jSONObject.optBoolean("isJoinedBlacklist");
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
            com.kwad.sdk.utils.t.a(jSONObject, URLPackage.KEY_AUTHOR_ID, authorInfo.authorId);
            com.kwad.sdk.utils.t.a(jSONObject, "kwaiId", authorInfo.kwaiId);
            com.kwad.sdk.utils.t.a(jSONObject, "authorName", authorInfo.authorName);
            com.kwad.sdk.utils.t.a(jSONObject, "rawAuthorName", authorInfo.rawAuthorName);
            com.kwad.sdk.utils.t.a(jSONObject, "authorIcon", authorInfo.authorIcon);
            com.kwad.sdk.utils.t.a(jSONObject, "authorGender", authorInfo.authorGender);
            com.kwad.sdk.utils.t.a(jSONObject, "authorText", authorInfo.authorText);
            com.kwad.sdk.utils.t.a(jSONObject, "authorIconGuide", authorInfo.authorIconGuide);
            com.kwad.sdk.utils.t.a(jSONObject, "authorEid", authorInfo.authorEid);
            com.kwad.sdk.utils.t.a(jSONObject, "isJoinedBlacklist", authorInfo.isJoinedBlacklist);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
