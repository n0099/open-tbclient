package com.kwad.components.core.i;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class c {
    public Object LY;
    public AdTemplate LZ;

    public c(@NonNull AdTemplate adTemplate, int i) {
        this.LY = null;
        try {
            this.LY = new b(adTemplate, i);
        } catch (Throwable unused) {
            this.LZ = adTemplate;
        }
    }

    public static List<AdTemplate> l(List<c> list) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            arrayList.add(cVar.getAdTemplate());
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
        Object obj = this.LY;
        if (obj != null) {
            try {
                adTemplate = ((b) obj).getAdTemplate();
            } catch (Exception unused) {
            }
            if (adTemplate != null) {
                return this.LZ;
            }
            return adTemplate;
        }
        adTemplate = null;
        if (adTemplate != null) {
        }
    }

    public final Object getHost() {
        return this.LY;
    }
}
