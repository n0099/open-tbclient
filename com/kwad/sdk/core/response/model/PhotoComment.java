package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PhotoComment extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = -8159360430336434144L;
    public long author_id;
    public String author_name;
    public long comment_id;
    public String content;
    public String headurl;
    public boolean hot;
    public long likedCount;
    public long photo_id;
    public long subCommentCount;
    public String time;
    public long timestamp;
    public long user_id;
    public String user_sex;

    @Override // com.kwad.sdk.core.response.a.a
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.subCommentCount = jSONObject.optLong("subCommentCount");
        this.hot = jSONObject.optBoolean("hot");
        this.likedCount = jSONObject.optLong("likedCount");
        this.time = jSONObject.optString("time");
        this.timestamp = jSONObject.optLong("timestamp");
        this.content = jSONObject.optString("content");
        this.photo_id = jSONObject.optLong("photo_id");
        this.author_id = jSONObject.optLong("author_id");
        this.user_id = jSONObject.optLong("user_id");
        this.user_sex = jSONObject.optString("user_sex");
        this.comment_id = jSONObject.optLong("comment_id");
        this.headurl = jSONObject.optString("headurl");
        this.author_name = jSONObject.optString("author_name");
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "subCommentCount", this.subCommentCount);
        o.a(jSONObject, "hot", this.hot);
        o.a(jSONObject, "likedCount", this.likedCount);
        o.a(jSONObject, "time", this.time);
        o.a(jSONObject, "timestamp", this.timestamp);
        o.a(jSONObject, "content", this.content);
        o.a(jSONObject, "photo_id", this.photo_id);
        o.a(jSONObject, "author_id", this.author_id);
        o.a(jSONObject, "user_id", this.user_id);
        o.a(jSONObject, "user_sex", this.user_sex);
        o.a(jSONObject, "comment_id", this.comment_id);
        o.a(jSONObject, "headurl", this.headurl);
        o.a(jSONObject, "author_name", this.author_name);
        return jSONObject;
    }
}
