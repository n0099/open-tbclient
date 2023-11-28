package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class i {
    public Map<String, List<AdTemplate>> qd;

    /* loaded from: classes10.dex */
    public static class a {
        public static final i qe = new i((byte) 0);
    }

    public i() {
        this.qd = new ConcurrentHashMap();
    }

    public static i gh() {
        return a.qe;
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public final void B(String str) {
        this.qd.remove(str);
    }
}
