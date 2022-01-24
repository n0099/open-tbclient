package com.facebook.common.memory;
/* loaded from: classes3.dex */
public interface MemoryTrimmableRegistry {
    void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable);

    void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable);
}
