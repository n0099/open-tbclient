package com.kwad.sdk.core.videocache.kwai;
/* loaded from: classes8.dex */
public final class g extends e {
    public final long maxSize;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }

    @Override // com.kwad.sdk.core.videocache.kwai.e
    public final boolean J(long j) {
        return j <= this.maxSize;
    }
}
