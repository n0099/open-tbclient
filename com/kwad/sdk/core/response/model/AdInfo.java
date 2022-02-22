package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -8738827282880419389L;
    public String downloadFilePath;
    public String downloadId;
    public int ocpcActionType;
    public int progress;
    public long soFarBytes;
    public long totalBytes;
    @NonNull
    public AdBaseInfo adBaseInfo = new AdBaseInfo();
    @NonNull
    public AdvertiserInfo advertiserInfo = new AdvertiserInfo();
    @NonNull
    public AdConversionInfo adConversionInfo = new AdConversionInfo();
    @NonNull
    public AdMaterialInfo adMaterialInfo = new AdMaterialInfo();
    @NonNull
    public List<AdTrackInfo> adTrackInfoList = new ArrayList();
    @NonNull
    public DownloadSafeInfo downloadSafeInfo = new DownloadSafeInfo();
    public int status = 0;
    public AdPreloadInfo adPreloadInfo = new AdPreloadInfo();
    public AdSplashInfo adSplashInfo = new AdSplashInfo();
    @NonNull
    public AdStyleInfo adStyleInfo = new AdStyleInfo();
    public AdStyleInfo adStyleInfo2 = new AdStyleInfo();
    @NonNull
    public AdAggregateInfo adAggregateInfo = new AdAggregateInfo();
    @NonNull
    public AdRewardInfo adRewardInfo = new AdRewardInfo();
    @NonNull
    public AdInsertScreenInfo adInsertScreenInfo = new AdInsertScreenInfo();
    @NonNull
    public AdProductInfo adProductInfo = new AdProductInfo();
    public AdMatrixInfo adMatrixInfo = new AdMatrixInfo();

    /* loaded from: classes4.dex */
    public static class AdAggregateInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 6627768757836702989L;
        public int aggregateAdType;
        public String hotTagUrl;
        public String upperTab;
    }

    /* loaded from: classes4.dex */
    public static class AdBaseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 1615884096720946547L;
        public String adActionBarColor;
        public String adActionDescription;
        public int adAttributeType;
        public long adCacheSecond;
        public int adCacheSwitch;
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
        public int campaignType;
        public String clickUrl;
        public String convUrl;
        public String corporationName;
        public long creativeId;
        public int ecpm;
        public int enableSkipAd;
        public String installAppLabel;
        public ABParams mABParams = new ABParams();
        public String openAppLabel;
        public long packageSize;
        @Nullable
        public String productName;
        public String sdkExtraData;
        public String showUrl;
        public int skipSecond;
        public int taskType;
        public String videoPlayedNS;
        public long viewCount;
    }

    /* loaded from: classes4.dex */
    public static class AdConversionInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -1623240707193173136L;
        public String appDownloadUrl;
        public String callbackUrl;
        public String callbackUrlInfo;
        public String deeplinkUrl;
        public int h5Type;
        public String h5Url;
        public String marketUrl;
        public PlayableStyleInfo playableStyleInfo;
        public String playableUrl;
        public int retryH5TimeStep;
        public int supportThirdDownload;
    }

    /* loaded from: classes4.dex */
    public static class AdInsertScreenInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public int autoCloseTime;
    }

    /* loaded from: classes4.dex */
    public static class AdMaterialInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 8841259738296866924L;
        @NonNull
        public List<MaterialFeature> materialFeatureList = new ArrayList();
        public int materialType;
        public boolean videoVoice;

        /* loaded from: classes4.dex */
        public static class MaterialFeature extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
            public static final long serialVersionUID = -1118440558210936255L;
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

            @Override // com.kwad.sdk.core.response.kwai.a
            public void afterParseJson(@Nullable JSONObject jSONObject) {
                JSONObject optJSONObject;
                super.afterParseJson(jSONObject);
                if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("materialSize")) == null) {
                    return;
                }
                this.width = optJSONObject.optInt("width");
                this.height = optJSONObject.optInt("height");
            }

            @Override // com.kwad.sdk.core.response.kwai.a
            public void afterToJson(JSONObject jSONObject) {
                super.afterToJson(jSONObject);
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                t.a(jSONObject2, "width", this.width);
                t.a(jSONObject2, "height", this.height);
                t.a(jSONObject, "materialSize", jSONObject2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class AdPreloadInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -1208206464894428350L;
        public String preloadId;
        public String preloadTips;
        public int preloadType;
        public int validityPeriod;

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof AdPreloadInfo) && ((AdPreloadInfo) obj).preloadId.equals(this.preloadId);
        }

        public int hashCode() {
            String str = this.preloadId;
            return str != null ? str.hashCode() : super.hashCode();
        }
    }

    /* loaded from: classes4.dex */
    public static class AdRewardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -6571091401675622830L;
        public int rewardTime;
        public int showLandingPage;
        public int skipShowTime;
    }

    /* loaded from: classes4.dex */
    public static class AdSplashInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 6666286195277235837L;
        public int countdownShow;
        public int imageDisplaySecond;
        public int logoPosition;
        public int mute;
        public int skipSecond;
        public String skipTips;
        public String speakerIconUrl;
        public String speakerMuteIconUrl;
        public int fullScreenClickSwitch = 0;
        public int splashCloseButtonNewStyleSwitch = 0;
        public int splashShowClickButtonSwitch = 1;
    }

    /* loaded from: classes4.dex */
    public static class AdTrackInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 1185757456598461137L;
        public int type;
        public List<String> urls;
    }

    /* loaded from: classes4.dex */
    public static class AdvertiserInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 1779108296418044788L;
        public String adAuthorText;
        public String authorIconGuide;
        public String brief;
        public int fansCount;
        public boolean followed;
        public String portraitUrl;
        public String rawUserName;
        public String userGender;
        public long userId;
        public String userName;
    }

    /* loaded from: classes4.dex */
    public static class ComplianceInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -6420581965656630668L;
        public int actionBarType;
        public int describeBarType;
        public int materialJumpType;
        public int titleBarTextSwitch;
    }

    /* loaded from: classes4.dex */
    public static class DownloadSafeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -1575212648797728242L;
        public String appPermissionInfoUrl;
        public String appPrivacyUrl;
        public String autoDownloadUrl;
        public ComplianceInfo complianceInfo;
        public String permissionInfo;
        public boolean secWindowPopNoWifiSwitch;
        public boolean secWindowPopSwitch;
        public String webPageTipbarText;
        public String windowPopUrl;
        public boolean downloadPauseEnable = false;
        public boolean webPageTipbarSwitch = false;
    }

    /* loaded from: classes4.dex */
    public static class H5Config extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -6055740830695990438L;
        public int apiAdTag;
        public int apiBreathLamp;
        public int apiMisTouch;
        public String tagTip;
    }

    /* loaded from: classes4.dex */
    public static class MaterialSize extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 4007237406277888273L;
        public int height;
        public int width;
    }

    /* loaded from: classes4.dex */
    public static class PlayableStyleInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -5205269652522127614L;
        public int playableOrientation;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        this.downloadId = aa.a(this.adConversionInfo.appDownloadUrl);
    }
}
