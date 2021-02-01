package com.kwad.sdk.contentalliance.profile.home.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserProfile implements b, Serializable {
    private static final long serialVersionUID = 8190442197779201133L;
    public String authorGender;
    public String authorIcon;
    public long authorId;
    public String authorName;
    public OwnerCount ownerCount = new OwnerCount();
    public List<TabInfo> tabList = new ArrayList();

    /* loaded from: classes3.dex */
    public static class OwnerCount implements b, Serializable {
        private static final long serialVersionUID = 6850889799944988895L;
        public long fansCount;
        public long followCount;
        public long ownerCount;
        public long publicPhotoCount;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.fansCount = jSONObject.optLong("fansCount");
            this.followCount = jSONObject.optLong("followCount");
            this.ownerCount = jSONObject.optLong("ownerCount");
            this.publicPhotoCount = jSONObject.optLong("publicPhotoCount");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "fansCount", this.fansCount);
            o.a(jSONObject, "followCount", this.followCount);
            o.a(jSONObject, "ownerCount", this.ownerCount);
            o.a(jSONObject, "publicPhotoCount", this.publicPhotoCount);
            return jSONObject;
        }
    }

    /* loaded from: classes3.dex */
    public static class TabInfo implements b, Serializable {
        private static final long serialVersionUID = -4013982742376017878L;
        public long tabId;
        public String tabName;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.tabId = jSONObject.optLong("tabId");
            this.tabName = jSONObject.optString("tabName");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "tabId", this.tabId);
            o.a(jSONObject, "tabName", this.tabName);
            return jSONObject;
        }
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        this.authorName = jSONObject.optString("authorName");
        this.authorIcon = jSONObject.optString("authorIcon");
        this.authorGender = jSONObject.optString("authorGender");
        this.ownerCount.parseJson(jSONObject.optJSONObject("ownerCount"));
        JSONArray optJSONArray = jSONObject.optJSONArray("tabList");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                TabInfo tabInfo = new TabInfo();
                tabInfo.parseJson(optJSONObject);
                this.tabList.add(tabInfo);
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
        o.a(jSONObject, "authorName", this.authorName);
        o.a(jSONObject, "authorGender", this.authorGender);
        o.a(jSONObject, "authorIcon", this.authorIcon);
        o.a(jSONObject, "ownerCount", this.ownerCount);
        o.a(jSONObject, "tabList", this.tabList);
        return jSONObject;
    }
}
