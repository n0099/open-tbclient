package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public final class u implements com.kwad.sdk.glide.load.f<Bitmap, Bitmap> {

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.glide.load.engine.s<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f36489a;

        public a(@NonNull Bitmap bitmap) {
            this.f36489a = bitmap;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        @NonNull
        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.s
        @NonNull
        /* renamed from: b */
        public Bitmap e() {
            return this.f36489a;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public int c() {
            return com.kwad.sdk.glide.g.k.a(this.f36489a);
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public void d_() {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Bitmap bitmap, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new a(bitmap);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return true;
    }
}
