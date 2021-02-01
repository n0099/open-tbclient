package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public abstract class e implements com.kwad.sdk.glide.load.h<Bitmap> {
    protected abstract Bitmap a(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i, int i2);

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public final com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar, int i, int i2) {
        if (com.kwad.sdk.glide.g.k.a(i, i2)) {
            com.kwad.sdk.glide.load.engine.bitmap_recycle.e a2 = com.kwad.sdk.glide.c.a(context).a();
            Bitmap e = sVar.e();
            if (i == Integer.MIN_VALUE) {
                i = e.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = e.getHeight();
            }
            Bitmap a3 = a(a2, e, i, i2);
            return e.equals(a3) ? sVar : d.a(a3, a2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
