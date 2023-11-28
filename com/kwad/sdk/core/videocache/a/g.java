package com.kwad.sdk.core.videocache.a;
/* loaded from: classes10.dex */
public final class g extends e {
    public final long maxSize;

    public g(long j) {
        if (j > 0) {
            this.maxSize = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public final boolean am(long j) {
        if (j <= this.maxSize) {
            return true;
        }
        return false;
    }
}
