package com.google.ar.core;

import java.util.Map;
/* loaded from: classes5.dex */
final class q {
    private final Map<Long, AugmentedFace> a;

    public final synchronized AugmentedFace b(long j, Session session) {
        AugmentedFace augmentedFace;
        augmentedFace = this.a.get(Long.valueOf(j));
        if (augmentedFace == null) {
            augmentedFace = new AugmentedFace(j, session);
            this.a.put(Long.valueOf(j), augmentedFace);
        }
        return augmentedFace;
    }
}
