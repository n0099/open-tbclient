package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class g extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f36353b = "com.kwad.sdk.glide.load.resource.bitmap.CenterCrop".getBytes(com.kwad.sdk.glide.load.c.f36060a);

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    public Bitmap a(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return t.a(eVar, bitmap, i2, i3);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f36353b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof g;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return 298221917;
    }
}
