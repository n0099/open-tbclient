package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static String a(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : h(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardCallDescription;
    }

    public static String b(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : h(adTemplate).playDetailInfo.detailTopToolBarInfo.rewardIconUrl;
    }

    public static String c(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : h(adTemplate).playEndInfo.endTopToolBarInfo.rewardIconUrl;
    }

    public static long d(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return h(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String e(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : h(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String f(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : h(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean g(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && d.c(adTemplate)) {
            return h(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    public static AdStyleInfo h(@NonNull AdTemplate adTemplate) {
        return d.j(adTemplate).adStyleInfo;
    }

    public static List<String> i(@NonNull AdTemplate adTemplate) {
        AdStyleInfo h2 = h(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            for (AdStyleInfo.ExposeTagInfo exposeTagInfo : h2.extraDisplayInfo.exposeTagInfoList) {
                arrayList.add(exposeTagInfo.text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
