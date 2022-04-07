package com.facebook.common.memory;
/* loaded from: classes4.dex */
public interface MemoryTrimmableRegistry {
    void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable);

    void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable);
}
