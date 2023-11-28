package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class g {
    public static volatile g Jv;
    public ConcurrentHashMap<String, WeakReference<Object>> Ju = new ConcurrentHashMap<>();

    @NonNull
    public static g mC() {
        if (Jv == null) {
            synchronized (g.class) {
                if (Jv == null) {
                    Jv = new g();
                }
            }
        }
        return Jv;
    }

    public static String al(AdTemplate adTemplate) {
        long dI = com.kwad.sdk.core.response.b.e.dI(adTemplate);
        long dZ = com.kwad.sdk.core.response.b.e.dZ(adTemplate);
        return dI + "-" + dZ;
    }

    public static String b(h hVar) {
        String mD = hVar.mD();
        String mJ = hVar.mJ();
        return mD + "-" + mJ;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Ju.put(al(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void ak(AdTemplate adTemplate) {
        this.Ju.remove(al(adTemplate));
    }

    public final boolean a(h hVar) {
        String b = b(hVar);
        com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains key: " + b);
        boolean z = false;
        if (!this.Ju.containsKey(b)) {
            return false;
        }
        WeakReference<Object> weakReference = this.Ju.get(b);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }
}
