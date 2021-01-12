package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveInfo implements b, Serializable {
    private static final long serialVersionUID = -6382708726460249425L;
    public String audienceCount;
    public String caption;
    public String exp_tag;
    public String liveStreamId;
    public transient String pcursor;
    public String playInfo;
    public User user = new User();
    public List<CoverThumbnailUrl> cover_thumbnail_urls = new ArrayList();

    /* loaded from: classes4.dex */
    public static class CoverThumbnailUrl implements b, Serializable {
        private static final long serialVersionUID = -9411857293708312L;
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

    /* loaded from: classes4.dex */
    public static class User implements b, Serializable {
        private static final long serialVersionUID = 8394855164198099170L;
        public List<HeadUrl> headurls = new ArrayList();
        public long user_id;
        public String user_name;

        /* loaded from: classes4.dex */
        public static class HeadUrl implements b, Serializable {
            private static final long serialVersionUID = 7710129978455547652L;
            public String cdn;
            public String url;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.cdn = jSONObject.optString("cdn");
                this.url = jSONObject.optString("url");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "cdn", this.cdn);
                o.a(jSONObject, "url", this.url);
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
            this.user_name = jSONObject.optString("user_name");
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

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.liveStreamId = jSONObject.optString("liveStreamId");
        this.user.parseJson(jSONObject.optJSONObject("user"));
        this.playInfo = jSONObject.optString("playInfo");
        this.audienceCount = jSONObject.optString("audienceCount");
        this.caption = jSONObject.optString("caption");
        JSONArray optJSONArray = jSONObject.optJSONArray("cover_thumbnail_urls");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    CoverThumbnailUrl coverThumbnailUrl = new CoverThumbnailUrl();
                    coverThumbnailUrl.parseJson(optJSONObject);
                    this.cover_thumbnail_urls.add(coverThumbnailUrl);
                }
            }
        }
        this.exp_tag = jSONObject.optString("exp_tag");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "liveStreamId", this.liveStreamId);
        o.a(jSONObject, "user", this.user);
        o.a(jSONObject, "playInfo", this.playInfo);
        o.a(jSONObject, "audienceCount", this.audienceCount);
        o.a(jSONObject, "caption", this.caption);
        o.a(jSONObject, "cover_thumbnail_urls", this.cover_thumbnail_urls);
        o.a(jSONObject, "exp_tag", this.exp_tag);
        return jSONObject;
    }
}
