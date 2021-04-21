package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements com.kwad.sdk.glide.load.engine.o, com.kwad.sdk.glide.load.engine.s<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f36041a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36042b;

    public d(@NonNull Bitmap bitmap, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f36041a = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap, "Bitmap must not be null");
        this.f36042b = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) com.kwad.sdk.glide.g.j.a(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static d a(@Nullable Bitmap bitmap, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void b() {
        this.f36041a.prepareToDraw();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return com.kwad.sdk.glide.g.k.a(this.f36041a);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        this.f36042b.a(this.f36041a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public Bitmap e() {
        return this.f36041a;
    }
}
