package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class c {
    public static long bC(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return bG(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String bD(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : bG(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String bE(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : bG(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean bF(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && d.bI(adTemplate)) {
            return bG(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    public static AdStyleInfo bG(@NonNull AdTemplate adTemplate) {
        return d.bQ(adTemplate).adStyleInfo;
    }

    public static List<String> bH(@NonNull AdTemplate adTemplate) {
        AdStyleInfo bG = bG(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            for (AdStyleInfo.ExposeTagInfo exposeTagInfo : bG.extraDisplayInfo.exposeTagInfoList) {
                arrayList.add(exposeTagInfo.text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
