package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.baidu.ala.helper.AlaConstants;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PhotoInfo implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = -4483350806354759008L;
    public BaseInfo baseInfo = new BaseInfo();
    public VideoInfo videoInfo = new VideoInfo();
    public CoverInfo coverInfo = new CoverInfo();
    public AuthorInfo authorInfo = new AuthorInfo();
    public TrendInfo trendInfo = new TrendInfo();
    public PhotoAd photoAd = new PhotoAd();
    public LiveInfo liveInfo = new LiveInfo();
    public TubeEpisode tubeEpisode = new TubeEpisode();

    /* loaded from: classes5.dex */
    public static class AuthorInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 3647144332352243129L;
        public String authorGender;
        public String authorIcon;
        public String authorIconGuide;
        public long authorId;
        public String authorName;
        public String authorText;
        public String rawAuthorName;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
            this.authorName = jSONObject.optString("authorName");
            this.rawAuthorName = jSONObject.optString("rawAuthorName");
            this.authorIcon = jSONObject.optString("authorIcon");
            this.authorGender = jSONObject.optString("authorGender");
            this.authorText = jSONObject.optString("authorText");
            this.authorIconGuide = jSONObject.optString("authorIconGuide");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
            o.a(jSONObject, "authorName", this.authorName);
            o.a(jSONObject, "rawAuthorName", this.rawAuthorName);
            o.a(jSONObject, "authorIcon", this.authorIcon);
            o.a(jSONObject, "authorGender", this.authorGender);
            o.a(jSONObject, "authorText", this.authorText);
            o.a(jSONObject, "authorIconGuide", this.authorIconGuide);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class BaseInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 2257669583403371065L;
        public long commentCount;
        public long createTime;
        public long likeCount;
        public long photoId;
        public String recoExt;
        public String shareUrl;
        public String title;
        public String videoDesc;
        public long videoUrlCacheTime;
        public long viewCount;
        public int waterMarkPosition;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.photoId = jSONObject.optLong("photoId");
            this.title = jSONObject.optString("title");
            this.shareUrl = jSONObject.optString("shareUrl");
            this.waterMarkPosition = jSONObject.optInt("waterMarkPosition", 1);
            this.recoExt = jSONObject.optString("recoExt");
            this.likeCount = jSONObject.optLong("likeCount");
            this.commentCount = jSONObject.optLong("commentCount");
            this.viewCount = jSONObject.optLong("viewCount");
            this.createTime = jSONObject.optLong("createTime");
            this.videoDesc = jSONObject.optString("videoDesc");
            this.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "photoId", this.photoId);
            o.a(jSONObject, "title", this.title);
            o.a(jSONObject, "shareUrl", this.shareUrl);
            o.a(jSONObject, "waterMarkPosition", this.waterMarkPosition);
            o.a(jSONObject, "recoExt", this.recoExt);
            o.a(jSONObject, "likeCount", this.likeCount);
            o.a(jSONObject, "commentCount", this.commentCount);
            o.a(jSONObject, "viewCount", this.viewCount);
            o.a(jSONObject, "createTime", this.createTime);
            o.a(jSONObject, "videoDesc", this.videoDesc);
            o.a(jSONObject, "videoUrlCacheTime", this.videoUrlCacheTime);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class CoverInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 9136122984250063738L;
        public String blurBackgroundUrl;
        public String blurCoverUrl;
        public String coverUrl;
        public int height;
        public String webpCoverUrl;
        public int width;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.coverUrl = jSONObject.optString("coverUrl");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.webpCoverUrl = jSONObject.optString("webpCoverUrl");
            this.blurCoverUrl = jSONObject.optString("blurCoverUrl");
            this.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "coverUrl", this.coverUrl);
            o.a(jSONObject, "width", this.width);
            o.a(jSONObject, "height", this.height);
            o.a(jSONObject, "webpCoverUrl", this.webpCoverUrl);
            o.a(jSONObject, "blurCoverUrl", this.blurCoverUrl);
            o.a(jSONObject, "blurBackgroundUrl", this.blurBackgroundUrl);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class PhotoAd implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 3907193550069150451L;
        public boolean requestPatchAd;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.requestPatchAd = jSONObject.optBoolean("requestPatchAd", false);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "requestPatchAd", this.requestPatchAd);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class TubeEpisode implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -2087412525733788061L;
        public String episodeName;
        public long playCount;
        public String tubeName;
        public long tubeId = -1;
        public boolean hasTube = false;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.tubeId = jSONObject.optLong(URLPackage.KEY_TUBE_ID, -1L);
            this.tubeName = jSONObject.optString("tubeName", "");
            this.episodeName = jSONObject.optString("episodeName", "");
            this.playCount = jSONObject.optLong("playCount", 0L);
            this.hasTube = true;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, URLPackage.KEY_TUBE_ID, this.tubeId);
            o.a(jSONObject, "tubeName", this.tubeName);
            o.a(jSONObject, "episodeName", this.episodeName);
            o.a(jSONObject, "playCount", this.playCount);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class VideoInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 1395696168725754442L;
        public long duration;
        public String firstFrame;
        public int height;
        public double heightRatio;
        public double leftRatio;
        public int size;
        public double topRatio;
        public String videoUrl;
        public int width;
        public double widthRatio;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.videoUrl = jSONObject.optString("videoUrl");
            this.firstFrame = jSONObject.optString("firstFrame");
            this.duration = jSONObject.optLong("duration");
            this.size = jSONObject.optInt("size");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.leftRatio = jSONObject.optDouble("leftRatio", 0.0d);
            this.topRatio = jSONObject.optDouble("topRatio", 0.0d);
            this.widthRatio = jSONObject.optDouble("widthRatio", 1.0d);
            this.heightRatio = jSONObject.optDouble("heightRatio", 1.0d);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "videoUrl", this.videoUrl);
            o.a(jSONObject, "firstFrame", this.firstFrame);
            o.a(jSONObject, "duration", this.duration);
            o.a(jSONObject, "size", this.size);
            o.a(jSONObject, "width", this.width);
            o.a(jSONObject, "height", this.height);
            o.a(jSONObject, "leftRatio", this.leftRatio);
            o.a(jSONObject, "topRatio", this.topRatio);
            o.a(jSONObject, "widthRatio", this.widthRatio);
            o.a(jSONObject, "heightRatio", this.heightRatio);
            return jSONObject;
        }
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
        this.videoInfo.parseJson(jSONObject.optJSONObject(AlaConstants.STAT_VIDEO_INFO));
        this.coverInfo.parseJson(jSONObject.optJSONObject("coverInfo"));
        this.authorInfo.parseJson(jSONObject.optJSONObject("authorInfo"));
        this.trendInfo.parseJson(jSONObject.optJSONObject("trendInfo"));
        this.photoAd.parseJson(jSONObject.optJSONObject("photoAd"));
        this.liveInfo.parseJson(jSONObject.optJSONObject(UbcStatConstant.Value.VALUE_HEADLINE_FROM_SERVER));
        this.tubeEpisode.parseJson(jSONObject.optJSONObject("tubeEpisode"));
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "baseInfo", this.baseInfo);
        o.a(jSONObject, AlaConstants.STAT_VIDEO_INFO, this.videoInfo);
        o.a(jSONObject, "coverInfo", this.coverInfo);
        o.a(jSONObject, "authorInfo", this.authorInfo);
        o.a(jSONObject, "trendInfo", this.trendInfo);
        o.a(jSONObject, "photoAd", this.photoAd);
        o.a(jSONObject, UbcStatConstant.Value.VALUE_HEADLINE_FROM_SERVER, this.liveInfo);
        o.a(jSONObject, "tubeEpisode", this.tubeEpisode);
        return jSONObject;
    }
}
