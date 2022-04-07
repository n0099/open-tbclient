package com.google.android.exoplayer2.upstream;
/* loaded from: classes4.dex */
public interface Allocator {
    Allocation allocate();

    int getIndividualAllocationLength();

    int getTotalBytesAllocated();

    void release(Allocation allocation);

    void release(Allocation[] allocationArr);

    void trim();
}
