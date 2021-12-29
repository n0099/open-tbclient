package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.live.mode.LiveInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PhotoInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -4483350806354759008L;
    public BaseInfo baseInfo = new BaseInfo();
    public VideoInfo videoInfo = new VideoInfo();
    public HotspotInfo mHotspotInfo = new HotspotInfo();
    public CoverInfo coverInfo = new CoverInfo();
    public AuthorInfo authorInfo = new AuthorInfo();
    public LiveInfo liveInfo = new LiveInfo();
    public TubeEpisode tubeEpisode = new TubeEpisode();
    public WallpaperInfo wallpaperInfo = new WallpaperInfo();
    public ProductInfo productInfo = new ProductInfo();

    /* loaded from: classes3.dex */
    public static class AuthorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 3647144332352243129L;
        public String authorEid;
        public String authorGender;
        public String authorIcon;
        public String authorIconGuide;
        public long authorId;
        public String authorName;
        public String authorText;
        public boolean isJoinedBlacklist;
        public String kwaiId;
        public String rawAuthorName;
    }

    /* loaded from: classes3.dex */
    public static class BaseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 2257669583403371065L;
        public long commentCount;
        public int contentSourceType;
        public long createTime;
        public long likeCount;
        public long photoId;
        public long playTimes;
        public String recoExt;
        public String sdkExtraData;
        public String shareUrl;
        public String title;
        public String videoDesc;
        public long videoUrlCacheTime;
        public long viewCount;
        public int waterMarkPosition;
    }

    /* loaded from: classes3.dex */
    public static class CoverInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 9136122984250063738L;
        public String blurBackgroundUrl;
        public String blurCoverUrl;
        public String coverUrl;
        public int height;
        public String webpCoverUrl;
        public int width;
    }

    /* loaded from: classes3.dex */
    public static class ProductInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -6976688557388750318L;
        public ProductDetail productDetail = new ProductDetail();
        public String productDetails;
        public long productId;
        public String shennongjiaLog;

        /* loaded from: classes3.dex */
        public static class ProductDetail extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -3610510819973783411L;
            public String linkCode;
            public String nebulaKwaiLink;
            public int platformTypeCode;
            public String strongStyleAdMark;
            public int strongStyleAppearTime;
            public String strongStyleCardUrl;
            public boolean strongStyleEnableClose;
            public long strongStyleItemId;
            public String strongStyleItemPrice;
            public String strongStyleItemUrl;
            public String strongStylePicUrl;
            public String strongStylePriceAfterComm;
            public String strongStyleTitle;
            public String strongStyleUserCommAmountBuying;
            public String strongStyleUserCommAmountSharing;
            public String weakStyleAdMark;
            public int weakStyleAppearTime;
            public boolean weakStyleEnableClose;
            public String weakStyleIcon;
            public int weakStyleShowTime;
            public String weakStyleTitle;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            if (this.productDetails == null) {
                return;
            }
            super.afterParseJson(jSONObject);
            try {
                this.productDetail.parseJson(new JSONObject(this.productDetails));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class TubeEpisode extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -2087412525733788061L;
        public String episodeName;
        public long playCount;
        public String tubeName;
        public long tubeId = -1;
        public boolean hasTube = false;

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject != null && this.tubeId > 0) {
                this.hasTube = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class VideoInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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

    /* loaded from: classes3.dex */
    public static class WallpaperInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -8572865298854850054L;
        public boolean isWallpaperPhoto = false;
    }
}
