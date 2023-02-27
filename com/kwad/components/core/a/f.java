package com.kwad.components.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class f {
    public static volatile f Dx;
    public ConcurrentHashMap<String, WeakReference<Object>> Dw = new ConcurrentHashMap<>();

    public static String J(AdTemplate adTemplate) {
        long bJ = com.kwad.sdk.core.response.a.d.bJ(adTemplate);
        long ca = com.kwad.sdk.core.response.a.d.ca(adTemplate);
        return bJ + "-" + ca;
    }

    public static String b(g gVar) {
        String mc = gVar.mc();
        String mi = gVar.mi();
        return mc + "-" + mi;
    }

    @NonNull
    public static f mb() {
        if (Dx == null) {
            synchronized (f.class) {
                if (Dx == null) {
                    Dx = new f();
                }
            }
        }
        return Dx;
    }

    public final void I(AdTemplate adTemplate) {
        this.Dw.remove(J(adTemplate));
    }

    public final boolean a(g gVar) {
        String b = b(gVar);
        com.kwad.sdk.core.e.b.d("AdMemCachePool", "contains key: " + b);
        boolean z = false;
        if (this.Dw.containsKey(b)) {
            WeakReference<Object> weakReference = this.Dw.get(b);
            if (weakReference != null && weakReference.get() != null) {
                z = true;
            }
            if (z) {
                com.kwad.sdk.core.e.b.d("AdMemCachePool", "contains ad: " + weakReference.get());
            }
            return z;
        }
        return false;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Dw.put(J(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }
}
