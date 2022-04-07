package com.kwad.sdk.core.response.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import java.util.Random;
/* loaded from: classes5.dex */
public class b {
    public static Random a = new Random();

    public static int a(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i == 0) {
                return a.nextBoolean() ? 1 : 2;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
            return 1;
        }
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate a(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : a(adTemplate).styles.templateList) {
            if (at.a(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @NonNull
    public static AdMatrixInfo a(@NonNull AdTemplate adTemplate) {
        return d.c(adTemplate) ? d.j(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        AdInfo j = d.j(adTemplate);
        if (a.U(j)) {
            return af.e(context) ? !a.g(j) : a.g(j);
        }
        return false;
    }

    @Nullable
    public static String b(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, p(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean b(@NonNull AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long c(@NonNull AdTemplate adTemplate) {
        return p(adTemplate).maxTimeOut;
    }

    public static boolean c(@NonNull AdInfo adInfo) {
        try {
            return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(b(adTemplate));
    }

    @Nullable
    public static String e(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, q(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static long f(@NonNull AdTemplate adTemplate) {
        return q(adTemplate).maxTimeOut;
    }

    @Nullable
    public static String g(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, r(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean h(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(g(adTemplate));
    }

    @Nullable
    public static String i(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, s(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static boolean j(@NonNull AdTemplate adTemplate) {
        if (adTemplate.mAdScene == null || !af.a() || com.kwad.sdk.core.config.b.aa() || TextUtils.isEmpty(i(adTemplate))) {
            return false;
        }
        int adStyle = adTemplate.mAdScene.getAdStyle();
        if (adStyle == 1 || adStyle == 3 || adStyle == 2) {
            AdInfo j = d.j(adTemplate);
            return a.C(j) && a.B(j);
        }
        return false;
    }

    @Nullable
    public static String k(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, t(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static float l(@NonNull AdTemplate adTemplate) {
        return (float) d.j(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean m(@NonNull AdTemplate adTemplate) {
        return (TextUtils.isEmpty(k(adTemplate)) || TextUtils.isEmpty(d.j(adTemplate).adStyleInfo.feedAdInfo.templateConfig)) ? false : true;
    }

    @Nullable
    public static String n(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate a2 = a(adTemplate, u(adTemplate).templateId);
        return a2 != null ? a2.templateUrl : "";
    }

    public static float o(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = d.j(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
            i = 7;
        }
        return i;
    }

    @NonNull
    public static AdMatrixInfo.ActionBarInfoNew p(@NonNull AdTemplate adTemplate) {
        return a(adTemplate).adDataV2.actionBarInfo;
    }

    @NonNull
    public static AdMatrixInfo.FullPageActionBarInfo q(@NonNull AdTemplate adTemplate) {
        return a(adTemplate).adDataV2.fullPageActionBarInfo;
    }

    @NonNull
    public static AdMatrixInfo.EndCardInfo r(@NonNull AdTemplate adTemplate) {
        return a(adTemplate).adDataV2.endCardInfo;
    }

    @NonNull
    public static AdMatrixInfo.InteractionInfo s(@NonNull AdTemplate adTemplate) {
        return a(adTemplate).adDataV2.interactionInfo;
    }

    @NonNull
    public static AdMatrixInfo.FeedInfo t(@NonNull AdTemplate adTemplate) {
        return a(adTemplate).adDataV2.feedInfo;
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo u(@NonNull AdTemplate adTemplate) {
        return a(adTemplate).adDataV2.interstitialCardInfo;
    }
}
