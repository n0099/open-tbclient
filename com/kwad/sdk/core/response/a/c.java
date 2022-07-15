package com.kwad.sdk.core.response.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class c {
    public static long a(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return e(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String b(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : e(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String c(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : e(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean d(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && d.a(adTemplate)) {
            return e(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    public static AdStyleInfo e(@NonNull AdTemplate adTemplate) {
        return d.i(adTemplate).adStyleInfo;
    }

    public static List<String> f(@NonNull AdTemplate adTemplate) {
        AdStyleInfo e = e(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            for (AdStyleInfo.ExposeTagInfo exposeTagInfo : e.extraDisplayInfo.exposeTagInfoList) {
                arrayList.add(exposeTagInfo.text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
