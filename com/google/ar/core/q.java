package com.google.ar.core;

import java.util.Map;
/* loaded from: classes11.dex */
final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Long, AugmentedFace> f4043a;

    public final synchronized AugmentedFace b(long j, Session session) {
        AugmentedFace augmentedFace;
        augmentedFace = this.f4043a.get(Long.valueOf(j));
        if (augmentedFace == null) {
            augmentedFace = new AugmentedFace(j, session);
            this.f4043a.put(Long.valueOf(j), augmentedFace);
        }
        return augmentedFace;
    }
}
