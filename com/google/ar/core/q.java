package com.google.ar.core;

import java.util.Map;
/* loaded from: classes3.dex */
final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Long, AugmentedFace> f8164a;

    public final synchronized AugmentedFace b(long j, Session session) {
        AugmentedFace augmentedFace;
        augmentedFace = this.f8164a.get(Long.valueOf(j));
        if (augmentedFace == null) {
            augmentedFace = new AugmentedFace(j, session);
            this.f8164a.put(Long.valueOf(j), augmentedFace);
        }
        return augmentedFace;
    }
}
