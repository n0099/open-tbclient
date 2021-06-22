package com.kwad.sdk.core.videocache.a;

import java.io.File;
/* loaded from: classes7.dex */
public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    public final long f34900a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f34900a = j;
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public boolean a(File file, long j, int i2) {
        return j <= this.f34900a;
    }
}
