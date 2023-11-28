package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class d {
    public static long dB(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dF(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String dC(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return "";
        }
        return dF(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String dD(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return "";
        }
        return dF(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean dE(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null || !e.dH(adTemplate)) {
            return false;
        }
        return dF(adTemplate).slideClick;
    }

    @NonNull
    public static AdStyleInfo dF(@NonNull AdTemplate adTemplate) {
        return e.dP(adTemplate).adStyleInfo;
    }

    public static List<String> dG(@NonNull AdTemplate adTemplate) {
        AdStyleInfo dF = dF(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            for (AdStyleInfo.ExposeTagInfo exposeTagInfo : dF.extraDisplayInfo.exposeTagInfoList) {
                arrayList.add(exposeTagInfo.text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
