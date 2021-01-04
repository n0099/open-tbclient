package com.kwad.sdk.core.videocache.a;

import java.io.File;
/* loaded from: classes5.dex */
public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    private final long f9777a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f9777a = j;
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    protected boolean a(File file, long j, int i) {
        return j <= this.f9777a;
    }
}
