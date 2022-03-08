package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
/* loaded from: classes8.dex */
public class g extends e {
    public final long a;

    public g(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.a = j2;
    }

    @Override // com.kwad.sdk.core.videocache.kwai.e
    public boolean a(File file, long j2, int i2) {
        return j2 <= this.a;
    }
}
