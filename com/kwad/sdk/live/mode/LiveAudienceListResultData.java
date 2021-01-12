package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveAudienceListResultData extends BaseResultData {
    private static final long serialVersionUID = -1400500562354543457L;
    public List<CurrentWatchingUser> currentWatchingUsers = new ArrayList();
    public String displayWatchingCount;
    public int pendingDuration;
    public int sequenceId;

    /* loaded from: classes4.dex */
    public static class CurrentWatchingUser implements b, Serializable {
        private static final long serialVersionUID = -8900509159435327530L;
        public List<HeadUrl> headurls = new ArrayList();
        public long user_id;
        public long user_name;

        /* loaded from: classes4.dex */
        public static class HeadUrl implements b, Serializable {
            private static final long serialVersionUID = -8081450700792739733L;
            public String cdn;
            public String url;
            public String urlPattern;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.cdn = jSONObject.optString("cdn");
                this.url = jSONObject.optString("url");
                this.urlPattern = jSONObject.optString("urlPattern");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "cdn", this.cdn);
                o.a(jSONObject, "url", this.url);
                o.a(jSONObject, "urlPattern", this.urlPattern);
                return jSONObject;
            }
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("headurls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        HeadUrl headUrl = new HeadUrl();
                        headUrl.parseJson(optJSONObject);
                        this.headurls.add(headUrl);
                    }
                }
            }
            this.user_id = jSONObject.optLong("user_id");
            this.user_name = jSONObject.optLong("user_name");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "headurls", this.headurls);
            o.a(jSONObject, "user_id", this.user_id);
            o.a(jSONObject, "user_name", this.user_name);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("currentWatchingUsers");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    CurrentWatchingUser currentWatchingUser = new CurrentWatchingUser();
                    currentWatchingUser.parseJson(optJSONObject);
                    this.currentWatchingUsers.add(currentWatchingUser);
                }
            }
        }
        this.pendingDuration = jSONObject.optInt("pendingDuration");
        this.displayWatchingCount = jSONObject.optString("displayWatchingCount");
        this.sequenceId = jSONObject.optInt("sequenceId");
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "currentWatchingUsers", this.currentWatchingUsers);
        o.a(json, "pendingDuration", this.pendingDuration);
        o.a(json, "displayWatchingCount", this.displayWatchingCount);
        o.a(json, "sequenceId", this.sequenceId);
        return json;
    }
}
