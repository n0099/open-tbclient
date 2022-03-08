package com.kwad.sdk.ec.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.network.BaseRealData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class EcKwaiInfo extends BaseRealData {
    public static final String DEFAULT_PULLNEW = "https://promotion-partner.kuaishou.com/rest/n/promotion/p?adid=7348&imei=__IMEI2__&idfa=__IDFA2__&oaid=__OAID__&ip=__IP__&mac=__MAC2__&androidId=__ANDROIDID2__&callback=__CALLBACK__&siteSet=XXX";
    public String appDescription;
    public String appDownloadUrlAdr;
    public String appIconUrl;
    public String appName;
    public String appPackageName;
    public String pullNewUrl;

    public static EcKwaiInfo fromJson(JSONObject jSONObject) {
        EcKwaiInfo ecKwaiInfo = new EcKwaiInfo();
        ecKwaiInfo.parseData(jSONObject);
        return ecKwaiInfo;
    }

    @NonNull
    public static String getPullNewUrl(EcKwaiInfo ecKwaiInfo) {
        return ecKwaiInfo == null ? DEFAULT_PULLNEW : ecKwaiInfo.getPullNewUrl();
    }

    public AdTemplate generateAdTemplate(String str) {
        String str2 = this.appDownloadUrlAdr;
        AdTemplate adTemplate = new AdTemplate();
        AdInfo adInfo = new AdInfo();
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = str;
        adConversionInfo.appDownloadUrl = str2;
        adConversionInfo.marketUrl = "";
        adConversionInfo.h5Url = "";
        adInfo.downloadId = aa.a(str2);
        adInfo.adBaseInfo.appName = getAppName();
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.appPackageName = this.appPackageName;
        adBaseInfo.appIconUrl = this.appIconUrl;
        adBaseInfo.adDescription = this.appDescription;
        adTemplate.adInfoList.add(adInfo);
        adTemplate.llsid = this.llsid;
        adTemplate.mUniqueId = adInfo.downloadId;
        return adTemplate;
    }

    public String getAppDescription() {
        return this.appDescription;
    }

    public String getAppDownloadUrlAdr() {
        return this.appDownloadUrlAdr;
    }

    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public String getPullNewUrl() {
        return TextUtils.isEmpty(this.pullNewUrl) ? DEFAULT_PULLNEW : this.pullNewUrl;
    }

    @Override // com.kwad.sdk.core.network.BaseRealData
    public void parseData(@NonNull JSONObject jSONObject) {
        this.appDownloadUrlAdr = jSONObject.optString("appDownloadUrlAdr", "");
        this.appIconUrl = jSONObject.optString("appIconUrl", "");
        this.appDescription = jSONObject.optString("appDescription", "");
        this.appName = jSONObject.optString("appName", "");
        this.appPackageName = jSONObject.optString("appPackageName", "");
        this.pullNewUrl = jSONObject.optString("pullNewUrl", DEFAULT_PULLNEW);
    }

    public void setAppDescription(String str) {
        this.appDescription = str;
    }

    public void setAppDownloadUrlAdr(String str) {
        this.appDownloadUrlAdr = str;
    }

    public void setAppIconUrl(String str) {
        this.appIconUrl = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            json.put("appDownloadUrlAdr", this.appDownloadUrlAdr);
            json.put("appIconUrl", this.appIconUrl);
            json.put("appDescription", this.appDescription);
            json.put("appName", this.appName);
            json.put("appPackageName", this.appPackageName);
            json.put("pullNewUrl", this.pullNewUrl);
        } catch (JSONException e2) {
            a.a(e2);
        }
        return json;
    }

    public String toString() {
        return "{\"appDownloadUrlAdr\":\"" + this.appDownloadUrlAdr + "\",\"appIconUrl\":\"" + this.appIconUrl + "\",\"appDescription\":\"" + this.appDescription + "\",\"appName\":\"" + this.appName + "\",\"pullNewUrl\":\"" + this.pullNewUrl + "\",\"appPackageName\":\"" + this.appPackageName + "\"}";
    }
}
