package com.kwad.sdk.core.videocache.a;

import java.io.File;
/* loaded from: classes6.dex */
public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    public final long f34162a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f34162a = j;
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public boolean a(File file, long j, int i) {
        return j <= this.f34162a;
    }
}
