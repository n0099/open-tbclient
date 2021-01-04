package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes5.dex */
public final class h implements com.kwad.sdk.glide.load.f<com.kwad.sdk.glide.b.a, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f10618a;

    public h(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f10618a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public s<Bitmap> a(@NonNull com.kwad.sdk.glide.b.a aVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return com.kwad.sdk.glide.load.resource.bitmap.d.a(aVar.h(), this.f10618a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull com.kwad.sdk.glide.b.a aVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return true;
    }
}
