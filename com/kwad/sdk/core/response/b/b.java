package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class b {
    public static AdStyleInfo.PlayDetailInfo.PatchAdInfo a(@NonNull AdTemplate adTemplate) {
        return q(adTemplate).playDetailInfo.patchAdInfo;
    }

    public static String b(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : q(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardCallDescription;
    }

    public static String c(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : q(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardIconUrl;
    }

    public static String d(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : q(adTemplate).playEndInfo.endTopToolBarInfo.rewardIconUrl;
    }

    public static long e(@Nullable AdTemplate adTemplate) {
        long j = adTemplate != null ? q(adTemplate).playDetailInfo.actionBarInfo.translateBtnShowTime : 0L;
        if (j > 0) {
            return j;
        }
        return 3000L;
    }

    public static long f(@Nullable AdTemplate adTemplate) {
        long j = adTemplate != null ? q(adTemplate).playDetailInfo.actionBarInfo.lightBtnShowTime : 0L;
        if (j > 0) {
            return j;
        }
        return 6000L;
    }

    public static long g(@Nullable AdTemplate adTemplate) {
        long j = adTemplate != null ? q(adTemplate).playDetailInfo.actionBarInfo.cardShowTime : 0L;
        if (j > 0) {
            return j;
        }
        return 9000L;
    }

    public static int h(@Nullable AdTemplate adTemplate) {
        int i = adTemplate != null ? q(adTemplate).playEndInfo.adWebCardInfo.cardShowPlayCount : 0;
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public static long i(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return q(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String j(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : q(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String k(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : q(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static long l(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return q(adTemplate).playDetailInfo.detailWebCardInfo.maxTimeOut;
    }

    public static long m(@Nullable AdTemplate adTemplate) {
        long j = adTemplate != null ? q(adTemplate).playDetailInfo.detailWebCardInfo.cardShowTime : 0L;
        if (j > 0) {
            return j;
        }
        return 5000L;
    }

    public static String n(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null) {
            return q(adTemplate).playDetailInfo.detailWebCardInfo.cardUrl;
        }
        return null;
    }

    public static boolean o(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && c.c(adTemplate)) {
            AdStyleInfo.PlayDetailInfo playDetailInfo = q(adTemplate).playDetailInfo;
            if (playDetailInfo.type == 0) {
                return false;
            }
            AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo = playDetailInfo.detailWebCardInfo;
            return !TextUtils.isEmpty(detailWebCardInfo.cardUrl) && com.kwad.sdk.core.config.a.a(detailWebCardInfo.cardUrl);
        }
        return false;
    }

    public static boolean p(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && c.c(adTemplate)) {
            AdStyleInfo.PlayEndInfo playEndInfo = q(adTemplate).playEndInfo;
            if (playEndInfo.type == 0) {
                return false;
            }
            AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo = playEndInfo.adWebCardInfo;
            return !TextUtils.isEmpty(adWebCardInfo.cardUrl) && com.kwad.sdk.core.config.a.a(adWebCardInfo.cardUrl);
        }
        return false;
    }

    @NonNull
    public static AdStyleInfo q(@NonNull AdTemplate adTemplate) {
        return c.j(adTemplate).adStyleInfo;
    }
}
