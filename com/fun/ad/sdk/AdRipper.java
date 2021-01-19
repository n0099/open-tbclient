package com.fun.ad.sdk;

import android.os.Environment;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.d.b;
import com.fun.ad.d;
import com.fun.ad.m;
import com.google.gson.a.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import com.qq.e.comm.plugin.nativeadunified.h;
import com.qq.e.comm.plugin.s.f;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class AdRipper {

    /* loaded from: classes14.dex */
    public static class RippedCSJAd {
        @c("appLinkUrl")
        public String appLinkUrl;
        @c("appName")
        public String appName;
        @c("appPackageName")
        public String appPackageName;
        @c("appSchemaUrl")
        public String appSchemaUrl;
        @c("description")
        public String description;
        @c("imageUrls")
        public List<String> imageUrls;
        @c("interactionType")
        public String interactionType;
        @c("landingPageUrl")
        public String landingPageUrl;
        @c("linkUrl")
        public String linkUrl;
        @c("marketUrl")
        public String marketUrl;
        @c(StatisticConstants.SCREENSHOT)
        public boolean screenshot;
        @c("title")
        public String title;
        @c("videoUrl")
        public String videoUrl;
    }

    /* loaded from: classes14.dex */
    public static class RippedGDTAd {
        @c("appLinkUrl")
        public String appLinkUrl;
        @c("appName")
        public String appName;
        @c("appPackageName")
        public String appPackageName;
        @c("corporationName")
        public String corporationName;
        @c("customized_invoke_url")
        public String customized_invoke_url;
        @c("description")
        public String description;
        @c("imageUrl")
        public String imageUrl;
        @c("linkUrl")
        public String linkUrl;
        @c("title")
        public String title;
        @c("videoUrl")
        public String videoUrl;
    }

    /* loaded from: classes14.dex */
    public static class RippedKSAd {
        @c("adDescription")
        public String adDescription;
        @c("appDownloadUrl")
        public String appDownloadUrl;
        @c("appName")
        public String appName;
        @c("appPackageName")
        public String appPackageName;
        @c("convUrl")
        public String convUrl;
        @c("deeplinkUrl")
        public String deeplinkUrl;
        @c("h5Url")
        public String h5Url;
        @c("marketUrl")
        public String marketUrl;
        @c("materials")
        public List<a> materials;

        /* loaded from: classes14.dex */
        public static class a {
        }
    }

    public static RippedKSAd getRippedKSAd(AdInfo adInfo, boolean z) {
        String a2 = m.a(adInfo);
        if (z) {
            ((d.a) d.pEu).a(FunAdSdk.PLATFORM_KS, a2);
        }
        RippedKSAd rippedKSAd = new RippedKSAd();
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        rippedKSAd.adDescription = adBaseInfo.adDescription;
        rippedKSAd.appName = adBaseInfo.appName;
        rippedKSAd.appPackageName = adBaseInfo.appPackageName;
        rippedKSAd.convUrl = adBaseInfo.convUrl;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        rippedKSAd.h5Url = adConversionInfo.h5Url;
        rippedKSAd.marketUrl = adConversionInfo.marketUrl;
        rippedKSAd.deeplinkUrl = adConversionInfo.deeplinkUrl;
        rippedKSAd.appDownloadUrl = adConversionInfo.appDownloadUrl;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                RippedKSAd.a aVar = new RippedKSAd.a();
                String str = list.get(i2).coverUrl;
                String str2 = list.get(i2).materialUrl;
                arrayList.add(aVar);
                i = i2 + 1;
            }
            rippedKSAd.materials = arrayList;
        }
        return rippedKSAd;
    }

    public static RippedKSAd getRippedKSAd(Object obj, boolean z) {
        Object D = m.D("com.kwad.sdk.core.response.model.AdInfo", obj);
        if (D == null) {
            return null;
        }
        m.a("KS AdRipper, adOriginJson: " + m.a(D));
        return getRippedKSAd((AdInfo) D, z);
    }

    public static RippedKSAd getRippedKSDrawAd(Object obj, boolean z) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            if (declaredField == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null && (obj2 instanceof AdTemplate)) {
                List<AdInfo> list = ((AdTemplate) obj2).adInfoList;
                if (list == null || list.isEmpty()) {
                    return null;
                }
                return getRippedKSAd(list.get(0), z);
            }
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static RippedKSAd getRippedKsSplashAd(Object obj, boolean z) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null && (obj2 instanceof AdResultData)) {
                List<AdTemplate> list = ((AdResultData) obj2).adTemplateList;
                if (list.isEmpty()) {
                    return null;
                }
                List<AdInfo> list2 = list.get(0).adInfoList;
                if (list2.isEmpty()) {
                    return null;
                }
                return getRippedKSAd(list2.get(0), z);
            }
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void rip(String str, Object obj) {
        String a2 = m.a(obj);
        m.a("AdRipper platform: " + str + ", adRippedJson: " + a2);
        d.b bVar = d.pEu;
        FunAdPluginCallback adPluginCallback = FunAdSdk.getAdPluginCallback();
        if (adPluginCallback != null) {
            adPluginCallback.onAdRipped(str, a2);
        }
    }

    public static void ripCSJ(Object obj) {
        if (!d.d) {
            m.a("CSJ AdRipper isReportAdMaterials: false");
            return;
        }
        RippedCSJAd rippedCSJAd = getRippedCSJAd(obj, true);
        if (rippedCSJAd != null) {
            rip(FunAdSdk.PLATFORM_CSJ, rippedCSJAd);
        }
    }

    public static void ripGDTNativeExpress(Object obj) {
        if (!d.d) {
            m.a("GDT AdRipper isReportAdMaterials: false");
            return;
        }
        RippedGDTAd rippedGDTNativeExpressAd = getRippedGDTNativeExpressAd(obj, true);
        if (rippedGDTNativeExpressAd != null) {
            rip(FunAdSdk.PLATFORM_GDT, rippedGDTNativeExpressAd);
        }
    }

    public static void ripGDTNativeUnified(Object obj) {
        if (!d.d) {
            m.a("GDT AdRipper isReportAdMaterials: false");
            return;
        }
        RippedGDTAd rippedGDTNativeUnifiedAd = getRippedGDTNativeUnifiedAd(obj, true);
        if (rippedGDTNativeUnifiedAd != null) {
            rip(FunAdSdk.PLATFORM_GDT, rippedGDTNativeUnifiedAd);
        }
    }

    public static void ripGDTRewardVideo(Object obj) {
        if (!d.d) {
            m.a("GDT AdRipper isReportAdMaterials: false");
            return;
        }
        RippedGDTAd rippedGDTRewardVideoAd = getRippedGDTRewardVideoAd(obj, true);
        if (rippedGDTRewardVideoAd != null) {
            rip(FunAdSdk.PLATFORM_GDT, rippedGDTRewardVideoAd);
        }
    }

    public static void ripGDTSplash(Object obj) {
        if (!d.d) {
            m.a("GDT AdRipper isReportAdMaterials: false");
            return;
        }
        RippedGDTAd rippedGDTSplashAd = getRippedGDTSplashAd(obj, true);
        if (rippedGDTSplashAd != null) {
            rip(FunAdSdk.PLATFORM_GDT, rippedGDTSplashAd);
        }
    }

    public static void ripGDTUnifiedBanner(Object obj) {
        if (!d.d) {
            m.a("GDT AdRipper isReportAdMaterials: false");
            return;
        }
        RippedGDTAd rippedGDTUnifiedBannerAd = getRippedGDTUnifiedBannerAd(obj, true);
        if (rippedGDTUnifiedBannerAd != null) {
            rip(FunAdSdk.PLATFORM_GDT, rippedGDTUnifiedBannerAd);
        }
    }

    public static void ripGDTUnifiedInterstitial(Object obj) {
        if (!d.d) {
            m.a("GDT AdRipper isReportAdMaterials: false");
            return;
        }
        RippedGDTAd rippedGDTUnifiedInterstitialAd = getRippedGDTUnifiedInterstitialAd(obj, true);
        if (rippedGDTUnifiedInterstitialAd != null) {
            rip(FunAdSdk.PLATFORM_GDT, rippedGDTUnifiedInterstitialAd);
        }
    }

    public static void ripKS(Object obj) {
        if (!d.d) {
            m.a("KS AdRipper isReportAdMaterials: false");
            return;
        }
        RippedKSAd rippedKSAd = getRippedKSAd(obj, true);
        if (rippedKSAd != null) {
            rip(FunAdSdk.PLATFORM_KS, rippedKSAd);
        }
    }

    public static void ripKSDrawAd(Object obj) {
        if (!d.d) {
            m.a("KS AdRipper isReportAdMaterials: false");
            return;
        }
        RippedKSAd rippedKSDrawAd = getRippedKSDrawAd(obj, true);
        if (rippedKSDrawAd != null) {
            rip(FunAdSdk.PLATFORM_KS, rippedKSDrawAd);
        }
    }

    public static void ripKsSplash(Object obj) {
        if (!d.d) {
            m.a("KS AdRipper isReportAdMaterials: false");
            return;
        }
        RippedKSAd rippedKsSplashAd = getRippedKsSplashAd(obj, true);
        if (rippedKsSplashAd != null) {
            rip(FunAdSdk.PLATFORM_KS, rippedKsSplashAd);
        }
    }

    public static void saveAdToSdcard(String str, String str2) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), str2);
            file.deleteOnExit();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.flush();
            fileWriter.write(str);
            fileWriter.close();
            m.a("=========saveAdToSdcard Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RippedCSJAd getRippedCSJAd(Object obj, boolean z) {
        Object D = m.D("com.bytedance.sdk.openadsdk.core.d.l", obj);
        if (D == null) {
            return null;
        }
        String a2 = m.a(D);
        m.a("CSJ AdRipper, adOriginJson: " + a2);
        if (a2 == null) {
            return null;
        }
        if (z) {
            ((d.a) d.pEu).a(FunAdSdk.PLATFORM_CSJ, a2);
        }
        try {
            JSONObject jSONObject = new JSONObject(a2);
            RippedCSJAd rippedCSJAd = new RippedCSJAd();
            rippedCSJAd.screenshot = jSONObject.optBoolean("A", false);
            rippedCSJAd.marketUrl = jSONObject.optString("O");
            rippedCSJAd.linkUrl = jSONObject.optString("e");
            rippedCSJAd.title = jSONObject.optString("k");
            rippedCSJAd.description = jSONObject.optString("l");
            JSONArray optJSONArray = jSONObject.optJSONArray(IXAdRequestInfo.GPS);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optJSONObject(i).optString("a"));
                }
                rippedCSJAd.imageUrls = arrayList;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.EVENT_HEAT_X);
            if (optJSONObject != null) {
                rippedCSJAd.videoUrl = optJSONObject.optString(IXAdRequestInfo.GPS);
            }
            switch (jSONObject.optInt(b.f4043a, -1)) {
                case 2:
                    rippedCSJAd.interactionType = "BROWSER";
                    return rippedCSJAd;
                case 3:
                    rippedCSJAd.interactionType = "LANDING_PAGE";
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("p");
                    if (optJSONObject2 != null) {
                        rippedCSJAd.appSchemaUrl = optJSONObject2.optString("a");
                        rippedCSJAd.landingPageUrl = optJSONObject2.optString(b.f4043a);
                        return rippedCSJAd;
                    }
                    return rippedCSJAd;
                case 4:
                    rippedCSJAd.interactionType = "DOWNLOAD";
                    JSONObject optJSONObject3 = jSONObject.optJSONObject(Config.OS);
                    if (optJSONObject3 != null) {
                        rippedCSJAd.appLinkUrl = optJSONObject3.optString("a");
                        rippedCSJAd.appName = optJSONObject3.optString(b.f4043a);
                        rippedCSJAd.appPackageName = optJSONObject3.optString("c");
                        return rippedCSJAd;
                    }
                    return rippedCSJAd;
                case 5:
                    rippedCSJAd.interactionType = "DIAL";
                    return rippedCSJAd;
                default:
                    return rippedCSJAd;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static RippedGDTAd getRippedGDTNativeExpressAd(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null) {
                return null;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField("p");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 != null && (obj3 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj3;
                String jSONObject2 = jSONObject.toString();
                m.a("GDT AdRipper, adOriginJson: " + jSONObject2);
                if (z) {
                    ((d.a) d.pEu).a(FunAdSdk.PLATFORM_GDT, jSONObject2);
                }
                RippedGDTAd rippedGDTAd = new RippedGDTAd();
                rippedGDTAd.videoUrl = jSONObject.optString("video");
                rippedGDTAd.imageUrl = jSONObject.optString("img");
                rippedGDTAd.title = jSONObject.optString(DocumentOpenUtil.TXT);
                rippedGDTAd.description = jSONObject.optString("desc");
                rippedGDTAd.corporationName = jSONObject.optString("corporation_name");
                rippedGDTAd.linkUrl = jSONObject.optString("rl");
                rippedGDTAd.customized_invoke_url = jSONObject.optString("customized_invoke_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                if (optJSONObject != null) {
                    rippedGDTAd.appName = optJSONObject.optString("appname");
                    rippedGDTAd.appPackageName = optJSONObject.optString("pkg_name");
                    rippedGDTAd.appLinkUrl = optJSONObject.optString("pkgurl");
                }
                return rippedGDTAd;
            }
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static RippedGDTAd getRippedGDTNativeUnifiedAd(Object obj, boolean z) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        try {
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = (NativeUnifiedADDataAdapter) obj;
            Field declaredField = nativeUnifiedADDataAdapter.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            obj2 = declaredField.get(nativeUnifiedADDataAdapter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        if (obj2 == null) {
            return null;
        }
        Field declaredField2 = obj2.getClass().getDeclaredField("r");
        declaredField2.setAccessible(true);
        Object obj3 = declaredField2.get(obj2);
        if (obj3 == null) {
            return null;
        }
        JSONObject E = ((h) obj3).E();
        if (E != null) {
            m.a("GDT AdRipper, adOriginJson: " + E.toString());
            if (z) {
                ((d.a) d.pEu).a(FunAdSdk.PLATFORM_GDT, E.toString());
            }
            RippedGDTAd rippedGDTAd = new RippedGDTAd();
            rippedGDTAd.videoUrl = E.optString("video");
            rippedGDTAd.imageUrl = E.optString("img");
            rippedGDTAd.title = E.optString(DocumentOpenUtil.TXT);
            rippedGDTAd.description = E.optString("desc");
            rippedGDTAd.linkUrl = E.optString("rl");
            rippedGDTAd.corporationName = E.optString("corporation_name");
            rippedGDTAd.customized_invoke_url = E.optString("customized_invoke_url");
            JSONObject optJSONObject = E.optJSONObject("ext");
            if (optJSONObject != null) {
                rippedGDTAd.appName = optJSONObject.optString("appname");
                rippedGDTAd.appPackageName = optJSONObject.optString("pkg_name");
                rippedGDTAd.appLinkUrl = optJSONObject.optString("pkgurl");
                return rippedGDTAd;
            }
            return rippedGDTAd;
        }
        return null;
    }

    public static RippedGDTAd getRippedGDTRewardVideoAd(Object obj, boolean z) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("c");
            declaredField.setAccessible(true);
            obj2 = declaredField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        if (obj2 == null) {
            return null;
        }
        Field declaredField2 = obj2.getClass().getDeclaredField("a");
        declaredField2.setAccessible(true);
        Object obj3 = declaredField2.get(obj2);
        if (obj3 == null) {
            return null;
        }
        Field declaredField3 = obj3.getClass().getDeclaredField("h");
        declaredField3.setAccessible(true);
        Object obj4 = declaredField3.get(obj3);
        if (obj4 == null) {
            return null;
        }
        if (obj4 instanceof String[]) {
            String[] strArr = (String[]) obj4;
            if (strArr.length == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strArr[0]);
            m.a("GDT AdRipper, adOriginJson: " + jSONObject.toString());
            if (z) {
                ((d.a) d.pEu).a(FunAdSdk.PLATFORM_GDT, jSONObject.toString());
            }
            RippedGDTAd rippedGDTAd = new RippedGDTAd();
            rippedGDTAd.videoUrl = jSONObject.optString("video");
            rippedGDTAd.imageUrl = jSONObject.optString("img");
            rippedGDTAd.title = jSONObject.optString(DocumentOpenUtil.TXT);
            rippedGDTAd.description = jSONObject.optString("desc");
            rippedGDTAd.linkUrl = jSONObject.optString("rl");
            rippedGDTAd.corporationName = jSONObject.optString("corporation_name");
            rippedGDTAd.customized_invoke_url = jSONObject.optString("customized_invoke_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject != null) {
                rippedGDTAd.appName = optJSONObject.optString("appname");
                rippedGDTAd.appPackageName = optJSONObject.optString("pkg_name");
                rippedGDTAd.appLinkUrl = optJSONObject.optString("pkgurl");
                return rippedGDTAd;
            }
            return rippedGDTAd;
        }
        return null;
    }

    public static RippedGDTAd getRippedGDTSplashAd(Object obj, boolean z) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            obj2 = declaredField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        if (obj2 == null) {
            return null;
        }
        Field declaredField2 = obj2.getClass().getDeclaredField("a");
        declaredField2.setAccessible(true);
        Object obj3 = declaredField2.get(obj2);
        if (obj3 == null) {
            return null;
        }
        Field declaredField3 = obj3.getClass().getDeclaredField(IXAdRequestInfo.GPS);
        declaredField3.setAccessible(true);
        Object obj4 = declaredField3.get(obj3);
        if (obj4 == null) {
            return null;
        }
        JSONObject E = ((f) obj4).E();
        if (E != null) {
            m.a("GDT AdRipper, adOriginJson: " + E.toString());
            if (z) {
                ((d.a) d.pEu).a(FunAdSdk.PLATFORM_GDT, E.toString());
            }
            RippedGDTAd rippedGDTAd = new RippedGDTAd();
            rippedGDTAd.videoUrl = E.optString("video");
            rippedGDTAd.imageUrl = E.optString("img");
            rippedGDTAd.title = E.optString(DocumentOpenUtil.TXT);
            rippedGDTAd.description = E.optString("desc");
            rippedGDTAd.linkUrl = E.optString("rl");
            rippedGDTAd.corporationName = E.optString("corporation_name");
            rippedGDTAd.customized_invoke_url = E.optString("customized_invoke_url");
            JSONObject optJSONObject = E.optJSONObject("ext");
            if (optJSONObject != null) {
                rippedGDTAd.appName = optJSONObject.optString("appname");
                rippedGDTAd.appPackageName = optJSONObject.optString("pkg_name");
                rippedGDTAd.appLinkUrl = optJSONObject.optString("pkgurl");
                return rippedGDTAd;
            }
            return rippedGDTAd;
        }
        return null;
    }

    public static RippedGDTAd getRippedGDTUnifiedBannerAd(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null) {
                return null;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField(b.f4043a);
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 == null) {
                return null;
            }
            Field declaredField3 = obj3.getClass().getDeclaredField("d");
            declaredField3.setAccessible(true);
            Object obj4 = declaredField3.get(obj3);
            if (obj4 == null) {
                return null;
            }
            Field declaredField4 = obj4.getClass().getDeclaredField("a");
            declaredField4.setAccessible(true);
            Object obj5 = declaredField4.get(obj4);
            if (obj5 == null) {
                return null;
            }
            Field declaredField5 = obj5.getClass().getDeclaredField("p");
            declaredField5.setAccessible(true);
            Object obj6 = declaredField5.get(obj5);
            if (obj6 != null && (obj6 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj6;
                String jSONObject2 = jSONObject.toString();
                m.a("GDT AdRipper, adOriginJson: " + jSONObject2);
                if (z) {
                    ((d.a) d.pEu).a(FunAdSdk.PLATFORM_GDT, jSONObject2);
                }
                RippedGDTAd rippedGDTAd = new RippedGDTAd();
                rippedGDTAd.videoUrl = jSONObject.optString("video");
                rippedGDTAd.imageUrl = jSONObject.optString("img");
                rippedGDTAd.title = jSONObject.optString(DocumentOpenUtil.TXT);
                rippedGDTAd.description = jSONObject.optString("desc");
                rippedGDTAd.corporationName = jSONObject.optString("corporation_name");
                rippedGDTAd.linkUrl = jSONObject.optString("rl");
                rippedGDTAd.customized_invoke_url = jSONObject.optString("customized_invoke_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                if (optJSONObject != null) {
                    rippedGDTAd.appName = optJSONObject.optString("appname");
                    rippedGDTAd.appPackageName = optJSONObject.optString("pkg_name");
                    rippedGDTAd.appLinkUrl = optJSONObject.optString("pkgurl");
                }
                return rippedGDTAd;
            }
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static RippedGDTAd getRippedGDTUnifiedInterstitialAd(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("a");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null) {
                return null;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField("a");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            if (obj3 == null) {
                return null;
            }
            Field declaredField3 = obj3.getClass().getDeclaredField("c");
            declaredField3.setAccessible(true);
            Object obj4 = declaredField3.get(obj3);
            if (obj4 == null) {
                return null;
            }
            Field declaredField4 = obj4.getClass().getDeclaredField("h");
            declaredField4.setAccessible(true);
            Object obj5 = declaredField4.get(obj4);
            if (obj5 != null && (obj5 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj5;
                String jSONObject2 = jSONObject.toString();
                m.a("GDT AdRipper, adOriginJson: " + jSONObject2);
                if (z) {
                    ((d.a) d.pEu).a(FunAdSdk.PLATFORM_GDT, jSONObject2);
                }
                RippedGDTAd rippedGDTAd = new RippedGDTAd();
                rippedGDTAd.videoUrl = jSONObject.optString("video");
                rippedGDTAd.imageUrl = jSONObject.optString("img");
                rippedGDTAd.title = jSONObject.optString(DocumentOpenUtil.TXT);
                rippedGDTAd.description = jSONObject.optString("desc");
                rippedGDTAd.corporationName = jSONObject.optString("corporation_name");
                rippedGDTAd.linkUrl = jSONObject.optString("rl");
                rippedGDTAd.customized_invoke_url = jSONObject.optString("customized_invoke_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("ext");
                if (optJSONObject != null) {
                    rippedGDTAd.appName = optJSONObject.optString("appname");
                    rippedGDTAd.appPackageName = optJSONObject.optString("pkg_name");
                    rippedGDTAd.appLinkUrl = optJSONObject.optString("pkgurl");
                }
                return rippedGDTAd;
            }
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
