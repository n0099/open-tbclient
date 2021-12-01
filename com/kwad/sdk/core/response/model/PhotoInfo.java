package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.live.mode.LiveInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PhotoInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4483350806354759008L;
    public transient /* synthetic */ FieldHolder $fh;
    public AuthorInfo authorInfo;
    public BaseInfo baseInfo;
    public CoverInfo coverInfo;
    public LiveInfo liveInfo;
    public HotspotInfo mHotspotInfo;
    public ProductInfo productInfo;
    public TubeEpisode tubeEpisode;
    public VideoInfo videoInfo;
    public WallpaperInfo wallpaperInfo;

    /* loaded from: classes2.dex */
    public static class AuthorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3647144332352243129L;
        public transient /* synthetic */ FieldHolder $fh;
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

        public AuthorInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BaseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2257669583403371065L;
        public transient /* synthetic */ FieldHolder $fh;
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

        public BaseInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class CoverInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 9136122984250063738L;
        public transient /* synthetic */ FieldHolder $fh;
        public String blurBackgroundUrl;
        public String blurCoverUrl;
        public String coverUrl;
        public int height;
        public String webpCoverUrl;
        public int width;

        public CoverInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ProductInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6976688557388750318L;
        public transient /* synthetic */ FieldHolder $fh;
        public ProductDetail productDetail;
        public String productDetails;
        public long productId;
        public String shennongjiaLog;

        /* loaded from: classes2.dex */
        public static class ProductDetail extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -3610510819973783411L;
            public transient /* synthetic */ FieldHolder $fh;
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

            public ProductDetail() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public ProductInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.productDetail = new ProductDetail();
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || this.productDetails == null) {
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

    /* loaded from: classes2.dex */
    public static class TubeEpisode extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2087412525733788061L;
        public transient /* synthetic */ FieldHolder $fh;
        public String episodeName;
        public boolean hasTube;
        public long playCount;
        public long tubeId;
        public String tubeName;

        public TubeEpisode() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tubeId = -1L;
            this.hasTube = false;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                super.afterParseJson(jSONObject);
                if (jSONObject != null && this.tubeId > 0) {
                    this.hasTube = true;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class VideoInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1395696168725754442L;
        public transient /* synthetic */ FieldHolder $fh;
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

        public VideoInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class WallpaperInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8572865298854850054L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isWallpaperPhoto;

        public WallpaperInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isWallpaperPhoto = false;
        }
    }

    public PhotoInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.baseInfo = new BaseInfo();
        this.videoInfo = new VideoInfo();
        this.mHotspotInfo = new HotspotInfo();
        this.coverInfo = new CoverInfo();
        this.authorInfo = new AuthorInfo();
        this.liveInfo = new LiveInfo();
        this.tubeEpisode = new TubeEpisode();
        this.wallpaperInfo = new WallpaperInfo();
        this.productInfo = new ProductInfo();
    }
}
