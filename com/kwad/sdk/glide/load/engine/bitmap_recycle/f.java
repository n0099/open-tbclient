package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class f implements e {
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a() {
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a(int i) {
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config);
    }
}
