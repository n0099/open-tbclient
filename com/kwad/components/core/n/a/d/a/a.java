package com.kwad.components.core.n.a.d.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a {
    public static final Map<Integer, WeakReference<AdResultData>> Mu = new HashMap();

    public static void a(int i, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        Mu.put(Integer.valueOf(i), new WeakReference<>(adResultData));
    }

    public static AdResultData at(int i) {
        WeakReference<AdResultData> weakReference = Mu.get(Integer.valueOf(i));
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        return null;
    }
}
