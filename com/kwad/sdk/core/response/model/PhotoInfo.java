package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.live.mode.LiveInfo;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PhotoInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final long serialVersionUID = -4483350806354759008L;
    public BaseInfo baseInfo = new BaseInfo();
    public VideoInfo videoInfo = new VideoInfo();
    public CoverInfo coverInfo = new CoverInfo();
    public AuthorInfo authorInfo = new AuthorInfo();
    public TrendInfo trendInfo = new TrendInfo();
    public PhotoAd photoAd = new PhotoAd();
    public LiveInfo liveInfo = new LiveInfo();
    public TubeEpisode tubeEpisode = new TubeEpisode();

    /* loaded from: classes6.dex */
    public static class AuthorInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 3647144332352243129L;
        public String authorGender;
        public String authorIcon;
        public String authorIconGuide;
        public long authorId;
        public String authorName;
        public String authorText;
        public String kwaiId;
        public String rawAuthorName;
    }

    /* loaded from: classes6.dex */
    public static class BaseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 2257669583403371065L;
        public long commentCount;
        public int contentSourceType;
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
    }

    /* loaded from: classes6.dex */
    public static class CoverInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 9136122984250063738L;
        public String blurBackgroundUrl;
        public String blurCoverUrl;
        public String coverUrl;
        public int height;
        public String webpCoverUrl;
        public int width;
    }

    /* loaded from: classes6.dex */
    public static class PhotoAd extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 3907193550069150451L;
        public int requestAdWidgetWithPosition;
        public boolean requestPatchAd;
    }

    /* loaded from: classes6.dex */
    public static class TubeEpisode extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -2087412525733788061L;
        public String episodeName;
        public long playCount;
        public String tubeName;
        public long tubeId = -1;
        public boolean hasTube = false;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject != null && this.tubeId > 0) {
                this.hasTube = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class VideoInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 1395696168725754442L;
        public long duration;
        public String firstFrame;
        public int height;
        public double heightRatio;
        public double leftRatio;
        public String manifest;
        public int size;
        public double topRatio;
        public String videoUrl;
        public int width;
        public double widthRatio;
    }
}
