package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class h extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f10278b = "com.kwad.sdk.glide.load.resource.bitmap.CenterInside".getBytes(f10134a);

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    protected Bitmap a(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return t.c(eVar, bitmap, i, i2);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f10278b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return "com.kwad.sdk.glide.load.resource.bitmap.CenterInside".hashCode();
    }
}
