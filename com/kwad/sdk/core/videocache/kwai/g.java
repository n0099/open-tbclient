package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
/* loaded from: classes5.dex */
public class g extends e {
    public final long a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.a = j;
    }

    @Override // com.kwad.sdk.core.videocache.kwai.e
    public boolean a(File file, long j, int i) {
        return j <= this.a;
    }
}
