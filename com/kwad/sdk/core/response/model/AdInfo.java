package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.TbEnum;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AdInfo implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = -8738827282880419389L;
    public String downloadFilePath;
    public String downloadId;
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
    public DOWNLOADSTAUS status = DOWNLOADSTAUS.UNKNOWN;
    public AdPreloadInfo adPreloadInfo = new AdPreloadInfo();
    public AdSplashInfo adSplashInfo = new AdSplashInfo();
    @NonNull
    public AdStyleInfo adStyleInfo = new AdStyleInfo();

    /* loaded from: classes6.dex */
    public static class AdBaseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 1615884096720946547L;
        public String adActionBarColor;
        public String adActionDescription;
        public String adDescription;
        public String adGrayMarkIcon;
        public String adMarkIcon;
        public int adOperationType;
        public int adShowDuration;
        public String adSourceDescription;
        public int adSourceType;
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
        public ABParams mABParams = new ABParams();
        public long packageSize;
        @Nullable
        public String productName;
        public String showUrl;
        public int skipSecond;
        public String videoPlayedNS;
    }

    /* loaded from: classes6.dex */
    public static class AdConversionInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -1623240707193173136L;
        public String appDownloadUrl;
        public String deeplinkUrl;
        public int h5Type;
        public String h5Url;
        public String marketUrl;
        public int retryH5TimeStep;
    }

    /* loaded from: classes6.dex */
    public static class AdMaterialInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 8841259738296866924L;
        @NonNull
        public List<MaterialFeature> materialFeatureList = new ArrayList();
        public int materialType;

        /* loaded from: classes6.dex */
        public static class MaterialFeature extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
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

            @Override // com.kwad.sdk.core.response.a.a
            public void afterParseJson(@Nullable JSONObject jSONObject) {
                JSONObject optJSONObject;
                super.afterParseJson(jSONObject);
                if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("materialSize")) == null) {
                    return;
                }
                this.width = optJSONObject.optInt("width");
                this.height = optJSONObject.optInt("height");
            }

            @Override // com.kwad.sdk.core.response.a.a
            public void afterToJson(JSONObject jSONObject) {
                super.afterToJson(jSONObject);
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                o.a(jSONObject2, "width", this.width);
                o.a(jSONObject2, "height", this.height);
                o.a(jSONObject, "materialSize", jSONObject2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class AdPreloadInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
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

    /* loaded from: classes6.dex */
    public static class AdSplashInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 6666286195277235837L;
        public int imageDisplaySecond;
        public int logoPosition;
        public int mute;
        public int skipSecond;
        public String skipTips;
        public String speakerIconUrl;
        public String speakerMuteIconUrl;
    }

    /* loaded from: classes6.dex */
    public static class AdTrackInfo implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 1185757456598461137L;
        public int type;
        public String[] urls;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            JSONArray optJSONArray = jSONObject.optJSONArray("url");
            if (optJSONArray != null) {
                this.urls = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.urls[i] = optJSONArray.optString(i);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "type", this.type);
            JSONArray jSONArray = new JSONArray();
            String[] strArr = this.urls;
            if (strArr != null) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            o.a(jSONObject, "url", jSONArray);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class AdvertiserInfo implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 1779108296418044788L;
        public String adAuthorText;
        public String authorIconGuide;
        public String portraitUrl;
        public String rawUserName;
        public String userGender;
        public long userId;
        public String userName;

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.userId = jSONObject.optLong("userId");
            this.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
            this.rawUserName = jSONObject.optString("rawUserName");
            this.userGender = jSONObject.optString("userGender");
            this.portraitUrl = jSONObject.optString("portraitUrl");
            this.adAuthorText = jSONObject.optString("adAuthorText");
            this.authorIconGuide = jSONObject.optString("authorIconGuide");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "userId", this.userId);
            o.a(jSONObject, TbEnum.SystemMessage.KEY_USER_NAME, this.userName);
            o.a(jSONObject, "rawUserName", this.rawUserName);
            o.a(jSONObject, "userGender", this.userGender);
            o.a(jSONObject, "portraitUrl", this.portraitUrl);
            o.a(jSONObject, "adAuthorText", this.adAuthorText);
            o.a(jSONObject, "authorIconGuide", this.authorIconGuide);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class DownloadSafeInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -1575212648797728242L;
        public String appPrivacyUrl;
        public String permissionInfo;
        public String webPageTipbarText;
        public String windowPopUrl;
        public int windowPopType = 0;
        public boolean downloadPauseEnable = false;
        public boolean webPageTipbarSwitch = false;
    }

    /* loaded from: classes6.dex */
    public static class MaterialSize extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 4007237406277888273L;
        public int height;
        public int width;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        this.advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        this.adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        this.adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        this.adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        this.adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        this.adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        this.downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        JSONArray optJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AdTrackInfo adTrackInfo = new AdTrackInfo();
                    adTrackInfo.parseJson(optJSONObject);
                    this.adTrackInfoList.add(adTrackInfo);
                }
            }
        }
        this.downloadId = t.a(this.adConversionInfo.appDownloadUrl);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "adBaseInfo", this.adBaseInfo);
        o.a(jSONObject, "advertiserInfo", this.advertiserInfo);
        o.a(jSONObject, "adConversionInfo", this.adConversionInfo);
        o.a(jSONObject, "adMaterialInfo", this.adMaterialInfo);
        o.a(jSONObject, "adStyleInfo", this.adStyleInfo);
        o.a(jSONObject, "adTrackInfo", this.adTrackInfoList);
        o.a(jSONObject, "adPreloadInfo", this.adPreloadInfo);
        o.a(jSONObject, "adSplashInfo", this.adSplashInfo);
        o.a(jSONObject, "downloadSafeInfo", this.downloadSafeInfo);
        return jSONObject;
    }
}
