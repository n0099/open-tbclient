package com.kwad.components.ad.reward.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    public Object oR;
    public AdTemplate oS;

    public b(@NonNull AdTemplate adTemplate, int i) {
        this.oR = null;
        try {
            this.oR = new a(adTemplate, i);
        } catch (Throwable unused) {
            this.oS = adTemplate;
        }
    }

    public static List<AdTemplate> f(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(bVar.getAdTemplate());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AdTemplate getAdTemplate() {
        AdTemplate adTemplate;
        Object obj = this.oR;
        if (obj != null) {
            try {
                adTemplate = ((a) obj).getAdTemplate();
            } catch (Exception unused) {
            }
            return adTemplate != null ? this.oS : adTemplate;
        }
        adTemplate = null;
        if (adTemplate != null) {
        }
    }

    public final Object getHost() {
        return this.oR;
    }
}
