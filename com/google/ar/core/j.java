package com.google.ar.core;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class j extends LinkedHashMap<Long, AugmentedFace> {
    public j(int i, float f, boolean z) {
        super(1, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<Long, AugmentedFace> entry) {
        if (size() > 10) {
            return true;
        }
        return false;
    }
}
