package com.kwad.sdk.glide.load.resource.b;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes6.dex */
public final class c extends b<Drawable> {
    public c(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    public static s<Drawable> a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<android.graphics.drawable.Drawable> */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Drawable> a() {
        return this.f35634a.getClass();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return Math.max(1, this.f35634a.getIntrinsicWidth() * this.f35634a.getIntrinsicHeight() * 4);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
    }
}
