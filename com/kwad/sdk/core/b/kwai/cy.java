package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.kwad.sdk.core.response.model.PhotoComment;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cy implements com.kwad.sdk.core.d<PhotoComment> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoComment photoComment, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoComment.subCommentCount = jSONObject.optLong("subCommentCount");
        photoComment.hot = jSONObject.optBoolean(ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE);
        photoComment.likedCount = jSONObject.optLong("likedCount");
        photoComment.time = jSONObject.optString("time");
        if (jSONObject.opt("time") == JSONObject.NULL) {
            photoComment.time = "";
        }
        photoComment.timestamp = jSONObject.optLong("timestamp");
        photoComment.content = jSONObject.optString("content");
        if (jSONObject.opt("content") == JSONObject.NULL) {
            photoComment.content = "";
        }
        photoComment.photo_id = jSONObject.optLong("photo_id");
        photoComment.author_id = jSONObject.optLong("author_id");
        photoComment.user_id = jSONObject.optLong("user_id");
        photoComment.user_sex = jSONObject.optString("user_sex");
        if (jSONObject.opt("user_sex") == JSONObject.NULL) {
            photoComment.user_sex = "";
        }
        photoComment.comment_id = jSONObject.optLong("comment_id");
        photoComment.headurl = jSONObject.optString("headurl");
        if (jSONObject.opt("headurl") == JSONObject.NULL) {
            photoComment.headurl = "";
        }
        photoComment.author_name = jSONObject.optString("author_name");
        if (jSONObject.opt("author_name") == JSONObject.NULL) {
            photoComment.author_name = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoComment photoComment, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "subCommentCount", photoComment.subCommentCount);
        com.kwad.sdk.utils.t.a(jSONObject, ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE, photoComment.hot);
        com.kwad.sdk.utils.t.a(jSONObject, "likedCount", photoComment.likedCount);
        com.kwad.sdk.utils.t.a(jSONObject, "time", photoComment.time);
        com.kwad.sdk.utils.t.a(jSONObject, "timestamp", photoComment.timestamp);
        com.kwad.sdk.utils.t.a(jSONObject, "content", photoComment.content);
        com.kwad.sdk.utils.t.a(jSONObject, "photo_id", photoComment.photo_id);
        com.kwad.sdk.utils.t.a(jSONObject, "author_id", photoComment.author_id);
        com.kwad.sdk.utils.t.a(jSONObject, "user_id", photoComment.user_id);
        com.kwad.sdk.utils.t.a(jSONObject, "user_sex", photoComment.user_sex);
        com.kwad.sdk.utils.t.a(jSONObject, "comment_id", photoComment.comment_id);
        com.kwad.sdk.utils.t.a(jSONObject, "headurl", photoComment.headurl);
        com.kwad.sdk.utils.t.a(jSONObject, "author_name", photoComment.author_name);
        return jSONObject;
    }
}
