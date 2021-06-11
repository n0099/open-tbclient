package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class f implements e {
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a() {
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a(int i2) {
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        return a(i2, i3, config);
    }
}
