package com.google.ar.core;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class j extends LinkedHashMap<Long, AugmentedFace> {
    public j(int i2, float f2, boolean z) {
        super(1, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<Long, AugmentedFace> entry) {
        return size() > 10;
    }
}
