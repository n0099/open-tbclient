package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class i extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f36453b = "com.kwad.sdk.glide.load.resource.bitmap.CircleCrop.1".getBytes(com.kwad.sdk.glide.load.c.f36158a);

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    public Bitmap a(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return t.d(eVar, bitmap, i2, i3);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f36453b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return 768609307;
    }
}
