package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CommentResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = 7438022026198734874L;
    public long commentCount;
    public List<PhotoComment> rootComments = new ArrayList();

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        List<PhotoComment> list = this.rootComments;
        return list == null || list.isEmpty();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(d.b(jSONObject.optString("data")));
            this.commentCount = jSONObject2.optLong("commentCount");
            JSONArray jSONArray = jSONObject2.getJSONArray("rootComments");
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        PhotoComment photoComment = new PhotoComment();
                        photoComment.parseJson(optJSONObject);
                        this.rootComments.add(photoComment);
                    }
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "commentCount", this.commentCount);
        t.a(jSONObject, "rootComments", this.rootComments);
        return jSONObject;
    }
}
