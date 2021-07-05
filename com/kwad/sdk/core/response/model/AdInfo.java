package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdInfo implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -8738827282880419389L;
    public transient /* synthetic */ FieldHolder $fh;
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
    public DOWNLOADSTAUS status;
    public long totalBytes;

    /* loaded from: classes7.dex */
    public static class AdBaseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1615884096720946547L;
        public transient /* synthetic */ FieldHolder $fh;
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
        public ABParams mABParams;
        public long packageSize;
        @Nullable
        public String productName;
        public String showUrl;
        public int skipSecond;
        public String videoPlayedNS;

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

    /* loaded from: classes7.dex */
    public static class AdConversionInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1623240707193173136L;
        public transient /* synthetic */ FieldHolder $fh;
        public String appDownloadUrl;
        public String deeplinkUrl;
        public int h5Type;
        public String h5Url;
        public String marketUrl;
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

    /* loaded from: classes7.dex */
    public static class AdMaterialInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8841259738296866924L;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public List<MaterialFeature> materialFeatureList;
        public int materialType;

        /* loaded from: classes7.dex */
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
                    o.a(jSONObject2, "width", this.width);
                    o.a(jSONObject2, "height", this.height);
                    o.a(jSONObject, "materialSize", jSONObject2);
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class AdSplashInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6666286195277235837L;
        public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public static class AdTrackInfo implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1185757456598461137L;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;
        public String[] urls;

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

        public void parseJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            JSONArray optJSONArray = jSONObject.optJSONArray("url");
            if (optJSONArray != null) {
                this.urls = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.urls[i2] = optJSONArray.optString(i2);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class AdvertiserInfo implements com.kwad.sdk.core.b, Serializable {
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

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class DownloadSafeInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1575212648797728242L;
        public transient /* synthetic */ FieldHolder $fh;
        public String appPrivacyUrl;
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

    /* loaded from: classes7.dex */
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
        this.status = DOWNLOADSTAUS.UNKNOWN;
        this.adPreloadInfo = new AdPreloadInfo();
        this.adSplashInfo = new AdSplashInfo();
        this.adStyleInfo = new AdStyleInfo();
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
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
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }
}
