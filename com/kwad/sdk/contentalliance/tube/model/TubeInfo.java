package com.kwad.sdk.contentalliance.tube.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TubeInfo implements b, Serializable {
    private static final long serialVersionUID = 4200733339719277993L;
    public long authorId;
    public String authorName;
    public boolean isFinished;
    public String name;
    public String summary;
    public List<String> tagList = new ArrayList();
    public int totalEpisodeCount = -1;
    public long tubeId;

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.tubeId = jSONObject.optLong(URLPackage.KEY_TUBE_ID, 0L);
        this.name = jSONObject.optString("name", "");
        this.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID, 0L);
        this.authorName = jSONObject.optString("authorName", "");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("tagList");
            if (optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString != null && !optString.isEmpty()) {
                        this.tagList.add(optString);
                    }
                }
            }
        } catch (Exception e) {
            a.a(e);
        }
        this.totalEpisodeCount = jSONObject.optInt("totalEpisodeCount", -1);
        this.isFinished = jSONObject.optBoolean("isFinished", false);
        this.summary = jSONObject.optString("summary", "");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, URLPackage.KEY_TUBE_ID, this.tubeId);
        o.a(jSONObject, "name", this.name);
        o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
        o.a(jSONObject, "authorName", this.authorName);
        o.a(jSONObject, "tagList", this.tagList);
        o.a(jSONObject, "totalEpisodeCount", this.totalEpisodeCount);
        o.a(jSONObject, "isFinished", this.isFinished);
        o.a(jSONObject, "summary", this.summary);
        return jSONObject;
    }

    public String toString() {
        return "TubeProfileResultData{name='" + this.name + "', authorId=" + this.authorId + ", authorName='" + this.authorName + "', tagList=" + this.tagList + ", totalEpisodeCount=" + this.totalEpisodeCount + ", isFinished=" + this.isFinished + ", summary='" + this.summary + "'}";
    }
}
