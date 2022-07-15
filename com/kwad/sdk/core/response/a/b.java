package com.kwad.sdk.core.response.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.at;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public final class b {
    public static Random a = new Random();

    public static boolean A(@NonNull AdTemplate adTemplate) {
        List<AdInfo> list = adTemplate.adInfoList;
        if (list != null && list.size() != 0) {
            AdInfo adInfo = adTemplate.adInfoList.get(0);
            if (!a.ar(adInfo) && adInfo.adBaseInfo.taskType == 4) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static String B(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, P(adTemplate).templateId);
        if (a2 != null) {
            return a2.templateUrl;
        }
        return null;
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo C(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static boolean D(AdTemplate adTemplate) {
        AdInfo i = d.i(adTemplate);
        if (n(i) || d.w(adTemplate)) {
            return false;
        }
        return !(F(adTemplate).cardType == 4) && d.i(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && i.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    @NonNull
    public static AdMatrixInfo E(@NonNull AdTemplate adTemplate) {
        return d.a(adTemplate) ? d.i(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    @NonNull
    public static AdMatrixInfo.ActionBarInfoNew F(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.actionBarInfo;
    }

    @NonNull
    public static AdMatrixInfo.AggregationCardInfo G(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.aggregationCardInfo;
    }

    @NonNull
    public static AdMatrixInfo.HalfCardInfo H(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.halfCardInfo;
    }

    @NonNull
    public static AdMatrixInfo.EndCardInfo I(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.endCardInfo;
    }

    @Deprecated
    public static String J(AdTemplate adTemplate) {
        return c.e(adTemplate).playEndInfo.adWebCardInfo.cardUrl;
    }

    @NonNull
    public static AdMatrixInfo.InteractionInfo K(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.interactionInfo;
    }

    @NonNull
    public static AdMatrixInfo.FeedInfo L(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.feedInfo;
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo M(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.interstitialCardInfo;
    }

    @NonNull
    public static AdMatrixInfo.ComplianceCardInfo N(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.complianceCardInfo;
    }

    @NonNull
    public static AdMatrixInfo.DownloadConfirmCardInfo O(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @NonNull
    public static AdMatrixInfo.RewardWatchOnceInfo P(@NonNull AdTemplate adTemplate) {
        return E(adTemplate).adDataV2.rewardWatchOnceInfo;
    }

    public static AdMatrixInfo.DownloadTexts a(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.downloadTexts;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate a(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : E(adTemplate).styles.templateList) {
            if (at.a(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    public static String a(@NonNull AdTemplate adTemplate) {
        AdInfo i = d.i(adTemplate);
        int c = d.c(adTemplate);
        boolean z = c == 3 || c == 2;
        if (z && a.aV(i)) {
            return s(i);
        }
        if (z && a.b(adTemplate)) {
            AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, C(adTemplate).templateId);
            return a2 != null ? a2.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate a3 = a(adTemplate, F(adTemplate).templateId);
        return a3 != null ? a3.templateUrl : "";
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        AdInfo i = d.i(adTemplate);
        if (!d.w(adTemplate) && a.aa(i)) {
            return ae.e(context) ? !a.j(i) : a.j(i);
        }
        return false;
    }

    public static long b(@NonNull AdTemplate adTemplate) {
        return F(adTemplate).maxTimeOut;
    }

    public static AdMatrixInfo.DownloadTexts b(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo.downloadTexts;
    }

    @Nullable
    public static AdMatrixInfo.TemplateData b(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : E(adTemplate).adDataV2.templateDataList) {
            if (at.a(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    public static long c(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData b = b(adTemplate, str);
        if (b != null) {
            return b.templateDelayTime;
        }
        return 0L;
    }

    public static String c(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static boolean c(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(a(adTemplate));
    }

    public static String d(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    @Nullable
    public static String d(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, G(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static long e(@NonNull AdTemplate adTemplate) {
        return c(adTemplate, G(adTemplate).templateId);
    }

    public static AdMatrixInfo.DownloadTexts e(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static long f(@NonNull AdTemplate adTemplate) {
        return G(adTemplate).changeTime * 1000;
    }

    public static String f(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static int g(@NonNull AdTemplate adTemplate) {
        return G(adTemplate).maxTimesPerDay;
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int h(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i == 0) {
                return a.nextBoolean() ? 1 : 2;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            return 1;
        }
    }

    public static long h(@NonNull AdTemplate adTemplate) {
        return G(adTemplate).intervalTime;
    }

    public static boolean i(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean i(@NonNull AdTemplate adTemplate) {
        AdInfo i = d.i(adTemplate);
        return !a.I(i) && a.x(i);
    }

    public static boolean j(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean j(@NonNull AdTemplate adTemplate) {
        AdInfo i = d.i(adTemplate);
        if (TextUtils.isEmpty(d(adTemplate))) {
            return false;
        }
        long e = e(adTemplate);
        if (e <= 0 || e > a.c(i) * 1000) {
            return false;
        }
        return ae.a();
    }

    @Nullable
    public static String k(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, H(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean k(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    @Nullable
    public static String l(@NonNull AdTemplate adTemplate) {
        AdInfo i = d.i(adTemplate);
        int c = d.c(adTemplate);
        if ((c == 3 || c == 2) && a.aV(i)) {
            return J(adTemplate);
        }
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, I(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean l(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 0;
    }

    public static boolean m(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static boolean m(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(l(adTemplate));
    }

    @Nullable
    public static String n(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, K(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.recommendAggregateSwitch && !t(adInfo);
    }

    public static float o(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            i = 7;
        }
        return i;
    }

    public static boolean o(@NonNull AdTemplate adTemplate) {
        if (adTemplate.mAdScene == null || !ae.a() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).k() || TextUtils.isEmpty(n(adTemplate))) {
            return false;
        }
        int adStyle = adTemplate.mAdScene.getAdStyle();
        if (adStyle == 1 || adStyle == 3 || adStyle == 2) {
            AdInfo i = d.i(adTemplate);
            return a.J(i) && a.I(i);
        }
        return false;
    }

    public static String p(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    @Nullable
    public static String p(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, L(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static float q(@NonNull AdTemplate adTemplate) {
        return (float) d.i(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static String q(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts r(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean r(@NonNull AdTemplate adTemplate) {
        return (TextUtils.isEmpty(p(adTemplate)) || TextUtils.isEmpty(d.i(adTemplate).adStyleInfo.feedAdInfo.templateConfig)) ? false : true;
    }

    public static float s(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = d.i(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    @Nullable
    @Deprecated
    public static String s(AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        String str = adInfo.adStyleInfo.playDetailInfo.detailWebCardInfo.cardUrl;
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(str)) {
            return str;
        }
        return null;
    }

    @Nullable
    public static String t(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, M(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean t(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    public static float u(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = d.i(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            i = 7;
        }
        return i;
    }

    public static AdMatrixInfo.RotateInfo v(@NonNull AdTemplate adTemplate) {
        try {
            return d.i(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            return null;
        }
    }

    @Nullable
    public static String w(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, N(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean x(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(w(adTemplate));
    }

    @Nullable
    public static String y(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, O(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean z(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(y(adTemplate));
    }
}
