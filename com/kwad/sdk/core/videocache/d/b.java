package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class b implements c {
    public HashMap<String, n> aBB = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aBB.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eo(String str) {
        if (!this.aBB.containsKey(str)) {
            return null;
        }
        return this.aBB.get(str);
    }
}
