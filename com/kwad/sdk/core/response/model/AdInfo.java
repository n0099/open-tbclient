package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -8738827282880419389L;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public AdAggregateInfo adAggregateInfo;
    @NonNull
    public AdBaseInfo adBaseInfo;
    @NonNull
    public AdConversionInfo adConversionInfo;
    @NonNull
    public AdMaterialInfo adMaterialInfo;
    public AdPreloadInfo adPreloadInfo;
    public AdSplashInfo adSplashInfo;
    @NonNull
    public AdStyleInfo adStyleInfo;
    public AdStyleInfo adStyleInfo2;
    @NonNull
    public List<AdTrackInfo> adTrackInfoList;
    @NonNull
    public AdvertiserInfo advertiserInfo;
    public String downloadFilePath;
    public String downloadId;
    @NonNull
    public DownloadSafeInfo downloadSafeInfo;
    public int progress;
    public long soFarBytes;
    public int status;
    public long totalBytes;

    /* loaded from: classes6.dex */
    public static class AdAggregateInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6627768757836702989L;
        public transient /* synthetic */ FieldHolder $fh;
        public int adAggregateInfo;

        public AdAggregateInfo() {
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

    /* loaded from: classes6.dex */
    public static class AdBaseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1615884096720946547L;
        public transient /* synthetic */ FieldHolder $fh;
        public String adActionBarColor;
        public String adActionDescription;
        public int adAttributeType;
        public String adDescription;
        public String adGrayMarkIcon;
        public String adMarkIcon;
        public int adOperationType;
        public int adShowDuration;
        public String adSourceDescription;
        public int adSourceType;
        public H5Config apiExpParam;
        public String appCategory;
        public String appDescription;
        public String appDownloadCountDesc;
        public String appIconUrl;
        public MaterialSize appImageSize;
        public List<String> appImageUrl;
        public String appName;
        public String appPackageName;
        public int appScore;
        public String appVersion;
        public String clickUrl;
        public String convUrl;
        public String corporationName;
        public long creativeId;
        public int ecpm;
        public int enableSkipAd;
        public int industryFirstLevelId;
        public String installAppLabel;
        public ABParams mABParams;
        public String openAppLabel;
        public long packageSize;
        @Nullable
        public String productName;
        public String showUrl;
        public int skipSecond;
        public String videoPlayedNS;
        public long viewCount;

        public AdBaseInfo() {
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
            this.mABParams = new ABParams();
        }
    }

    /* loaded from: classes6.dex */
    public static class AdConversionInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1623240707193173136L;
        public transient /* synthetic */ FieldHolder $fh;
        public String appDownloadUrl;
        public String callbackUrl;
        public String deeplinkUrl;
        public int h5Type;
        public String h5Url;
        public String marketUrl;
        public PlayableStyleInfo playableStyleInfo;
        public String playableUrl;
        public int retryH5TimeStep;

        public AdConversionInfo() {
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

    /* loaded from: classes6.dex */
    public static class AdMaterialInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8841259738296866924L;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public List<MaterialFeature> materialFeatureList;
        public int materialType;
        public boolean videoVoice;

        /* loaded from: classes6.dex */
        public static class MaterialFeature extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -1118440558210936255L;
            public transient /* synthetic */ FieldHolder $fh;
            public String blurBackgroundUrl;
            public long commentCount;
            public String coverUrl;
            public int featureType;
            public String firstFrame;
            public int height;
            public long likeCount;
            public String materialUrl;
            public long photoId;
            public String ruleId;
            public int source;
            public int videoDuration;
            public int videoHeight;
            public int videoWidth;
            public String webpCoverUrl;
            public int width;

            public MaterialFeature() {
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

            @Override // com.kwad.sdk.core.response.a.a
            public void afterParseJson(@Nullable JSONObject jSONObject) {
                JSONObject optJSONObject;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                    super.afterParseJson(jSONObject);
                    if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("materialSize")) == null) {
                        return;
                    }
                    this.width = optJSONObject.optInt("width");
                    this.height = optJSONObject.optInt("height");
                }
            }

            @Override // com.kwad.sdk.core.response.a.a
            public void afterToJson(JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                    super.afterToJson(jSONObject);
                    if (jSONObject == null) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    q.a(jSONObject2, "width", this.width);
                    q.a(jSONObject2, "height", this.height);
                    q.a(jSONObject, "materialSize", jSONObject2);
                }
            }
        }

        public AdMaterialInfo() {
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
            this.materialFeatureList = new ArrayList();
        }
    }

    /* loaded from: classes6.dex */
    public static class AdPreloadInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1208206464894428350L;
        public transient /* synthetic */ FieldHolder $fh;
        public String preloadId;
        public String preloadTips;
        public int preloadType;
        public int validityPeriod;

        public AdPreloadInfo() {
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

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof AdPreloadInfo) && ((AdPreloadInfo) obj).preloadId.equals(this.preloadId) : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = this.preloadId;
                return str != null ? str.hashCode() : super.hashCode();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class AdSplashInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6666286195277235837L;
        public transient /* synthetic */ FieldHolder $fh;
        public int countdownShow;
        public int imageDisplaySecond;
        public int logoPosition;
        public int mute;
        public int skipSecond;
        public String skipTips;
        public String speakerIconUrl;
        public String speakerMuteIconUrl;

        public AdSplashInfo() {
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

    /* loaded from: classes6.dex */
    public static class AdTrackInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1185757456598461137L;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;
        public List<String> urls;

        public AdTrackInfo() {
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

    /* loaded from: classes6.dex */
    public static class AdvertiserInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1779108296418044788L;
        public transient /* synthetic */ FieldHolder $fh;
        public String adAuthorText;
        public String authorIconGuide;
        public String portraitUrl;
        public String rawUserName;
        public String userGender;
        public long userId;
        public String userName;

        public AdvertiserInfo() {
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

    /* loaded from: classes6.dex */
    public static class DownloadSafeInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1575212648797728242L;
        public transient /* synthetic */ FieldHolder $fh;
        public String appPrivacyUrl;
        public String autoDownloadUrl;
        public boolean downloadPauseEnable;
        public String permissionInfo;
        public boolean webPageTipbarSwitch;
        public String webPageTipbarText;
        public int windowPopType;
        public String windowPopUrl;

        public DownloadSafeInfo() {
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
            this.windowPopType = 0;
            this.downloadPauseEnable = false;
            this.webPageTipbarSwitch = false;
        }
    }

    /* loaded from: classes6.dex */
    public static class H5Config extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int apiAdTag;
        public int apiBreathLamp;
        public int apiMisTouch;
        public String tagTip;

        public H5Config() {
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

    /* loaded from: classes6.dex */
    public static class MaterialSize extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4007237406277888273L;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public int width;

        public MaterialSize() {
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

    /* loaded from: classes6.dex */
    public static class PlayableStyleInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5205269652522127614L;
        public transient /* synthetic */ FieldHolder $fh;
        public int playableOrientation;

        public PlayableStyleInfo() {
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

    public AdInfo() {
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
        this.adBaseInfo = new AdBaseInfo();
        this.advertiserInfo = new AdvertiserInfo();
        this.adConversionInfo = new AdConversionInfo();
        this.adMaterialInfo = new AdMaterialInfo();
        this.adTrackInfoList = new ArrayList();
        this.downloadSafeInfo = new DownloadSafeInfo();
        this.status = 0;
        this.adPreloadInfo = new AdPreloadInfo();
        this.adSplashInfo = new AdSplashInfo();
        this.adStyleInfo = new AdStyleInfo();
        this.adStyleInfo2 = new AdStyleInfo();
        this.adAggregateInfo = new AdAggregateInfo();
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            this.downloadId = w.a(this.adConversionInfo.appDownloadUrl);
        }
    }
}
