package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class f {
    public Map<Integer, AdResultData> Jr = new ConcurrentHashMap();
    public AtomicInteger Js = new AtomicInteger(0);

    /* loaded from: classes10.dex */
    public static class a {
        public static f Jt = new f();
    }

    public static f mB() {
        return a.Jt;
    }

    public final AdResultData d(int i, boolean z) {
        AdResultData adResultData = this.Jr.get(Integer.valueOf(i));
        this.Jr.remove(Integer.valueOf(i));
        return adResultData;
    }

    public final int i(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.Js.incrementAndGet();
        this.Jr.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}
