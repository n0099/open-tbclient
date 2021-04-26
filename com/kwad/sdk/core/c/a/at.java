package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoComment;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class at implements com.kwad.sdk.core.c<PhotoComment> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoComment photoComment, JSONObject jSONObject) {
        if (jSONObject == null) {
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
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoComment photoComment, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "subCommentCount", photoComment.subCommentCount);
        com.kwad.sdk.utils.o.a(jSONObject, "hot", photoComment.hot);
        com.kwad.sdk.utils.o.a(jSONObject, "likedCount", photoComment.likedCount);
        com.kwad.sdk.utils.o.a(jSONObject, "time", photoComment.time);
        com.kwad.sdk.utils.o.a(jSONObject, "timestamp", photoComment.timestamp);
        com.kwad.sdk.utils.o.a(jSONObject, "content", photoComment.content);
        com.kwad.sdk.utils.o.a(jSONObject, "photo_id", photoComment.photo_id);
        com.kwad.sdk.utils.o.a(jSONObject, "author_id", photoComment.author_id);
        com.kwad.sdk.utils.o.a(jSONObject, "user_id", photoComment.user_id);
        com.kwad.sdk.utils.o.a(jSONObject, "user_sex", photoComment.user_sex);
        com.kwad.sdk.utils.o.a(jSONObject, "comment_id", photoComment.comment_id);
        com.kwad.sdk.utils.o.a(jSONObject, "headurl", photoComment.headurl);
        com.kwad.sdk.utils.o.a(jSONObject, "author_name", photoComment.author_name);
        return jSONObject;
    }
}
