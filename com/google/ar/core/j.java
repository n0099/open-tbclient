package com.google.ar.core;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
final class j extends LinkedHashMap<Long, AugmentedFace> {
    j(int i, float f, boolean z) {
        super(1, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry<Long, AugmentedFace> entry) {
        return size() > 10;
    }
}
