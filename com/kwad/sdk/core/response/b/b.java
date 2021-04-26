package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class b {
    public static String a(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : k(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardCallDescription;
    }

    public static String b(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : k(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardIconUrl;
    }

    public static String c(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : k(adTemplate).playEndInfo.endTopToolBarInfo.rewardIconUrl;
    }

    public static long d(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return k(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String e(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : k(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String f(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : k(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static long g(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return k(adTemplate).playDetailInfo.detailWebCardInfo.maxTimeOut;
    }

    public static String h(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null) {
            return k(adTemplate).playDetailInfo.detailWebCardInfo.cardUrl;
        }
        return null;
    }

    public static boolean i(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && c.a(adTemplate)) {
            AdStyleInfo.PlayDetailInfo playDetailInfo = k(adTemplate).playDetailInfo;
            if (playDetailInfo.type == 0) {
                return false;
            }
            AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo = playDetailInfo.detailWebCardInfo;
            return !TextUtils.isEmpty(detailWebCardInfo.cardUrl) && com.kwad.sdk.core.config.a.a(detailWebCardInfo.cardUrl);
        }
        return false;
    }

    public static boolean j(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && c.a(adTemplate)) {
            AdStyleInfo.PlayEndInfo playEndInfo = k(adTemplate).playEndInfo;
            if (playEndInfo.type == 0) {
                return false;
            }
            AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo = playEndInfo.adWebCardInfo;
            return !TextUtils.isEmpty(adWebCardInfo.cardUrl) && com.kwad.sdk.core.config.a.a(adWebCardInfo.cardUrl);
        }
        return false;
    }

    @NonNull
    public static AdStyleInfo k(@NonNull AdTemplate adTemplate) {
        return c.g(adTemplate).adStyleInfo;
    }
}
