package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoComment;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bp implements com.kwad.sdk.core.d<PhotoComment> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bp() {
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
    public void a(PhotoComment photoComment, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, photoComment, jSONObject) == null) || jSONObject == null) {
            return;
        }
        photoComment.subCommentCount = jSONObject.optLong("subCommentCount");
        photoComment.hot = jSONObject.optBoolean("hot");
        photoComment.likedCount = jSONObject.optLong("likedCount");
        photoComment.time = jSONObject.optString("time");
        photoComment.timestamp = jSONObject.optLong("timestamp");
        photoComment.content = jSONObject.optString("content");
        photoComment.photo_id = jSONObject.optLong("photo_id");
        photoComment.author_id = jSONObject.optLong("author_id");
        photoComment.user_id = jSONObject.optLong("user_id");
        photoComment.user_sex = jSONObject.optString("user_sex");
        photoComment.comment_id = jSONObject.optLong("comment_id");
        photoComment.headurl = jSONObject.optString("headurl");
        photoComment.author_name = jSONObject.optString("author_name");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoComment photoComment, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, photoComment, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "subCommentCount", photoComment.subCommentCount);
            com.kwad.sdk.utils.q.a(jSONObject, "hot", photoComment.hot);
            com.kwad.sdk.utils.q.a(jSONObject, "likedCount", photoComment.likedCount);
            com.kwad.sdk.utils.q.a(jSONObject, "time", photoComment.time);
            com.kwad.sdk.utils.q.a(jSONObject, "timestamp", photoComment.timestamp);
            com.kwad.sdk.utils.q.a(jSONObject, "content", photoComment.content);
            com.kwad.sdk.utils.q.a(jSONObject, "photo_id", photoComment.photo_id);
            com.kwad.sdk.utils.q.a(jSONObject, "author_id", photoComment.author_id);
            com.kwad.sdk.utils.q.a(jSONObject, "user_id", photoComment.user_id);
            com.kwad.sdk.utils.q.a(jSONObject, "user_sex", photoComment.user_sex);
            com.kwad.sdk.utils.q.a(jSONObject, "comment_id", photoComment.comment_id);
            com.kwad.sdk.utils.q.a(jSONObject, "headurl", photoComment.headurl);
            com.kwad.sdk.utils.q.a(jSONObject, "author_name", photoComment.author_name);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
