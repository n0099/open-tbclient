package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public final class u implements com.kwad.sdk.glide.load.f<Bitmap, Bitmap> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.glide.load.engine.s<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f6800a;

        a(@NonNull Bitmap bitmap) {
            this.f6800a = bitmap;
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
            return this.f6800a;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public int c() {
            return com.kwad.sdk.glide.g.k.a(this.f6800a);
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public void d_() {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Bitmap bitmap, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return new a(bitmap);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return true;
    }
}
