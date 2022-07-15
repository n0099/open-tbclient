package com.kwad.sdk.core.videocache.kwai;
/* loaded from: classes5.dex */
public final class g extends e {
    public final long a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.a = j;
    }

    @Override // com.kwad.sdk.core.videocache.kwai.e
    public final boolean a(long j) {
        return j <= this.a;
    }
}
