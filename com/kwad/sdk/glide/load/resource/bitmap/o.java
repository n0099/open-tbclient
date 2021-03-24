package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class o extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f35678b = "com.kwad.sdk.glide.load.resource.bitmap.FitCenter".getBytes(com.kwad.sdk.glide.load.c.f35376a);

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    public Bitmap a(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return t.b(eVar, bitmap, i, i2);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f35678b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof o;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return 2016935918;
    }
}
