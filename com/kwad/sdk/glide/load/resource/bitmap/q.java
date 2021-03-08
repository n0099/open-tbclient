package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public final class q implements com.kwad.sdk.glide.load.engine.o, com.kwad.sdk.glide.load.engine.s<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f6795a;
    private final com.kwad.sdk.glide.load.engine.s<Bitmap> b;

    private q(@NonNull Resources resources, @NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        this.f6795a = (Resources) com.kwad.sdk.glide.g.j.a(resources);
        this.b = (com.kwad.sdk.glide.load.engine.s) com.kwad.sdk.glide.g.j.a(sVar);
    }

    @Nullable
    public static com.kwad.sdk.glide.load.engine.s<BitmapDrawable> a(@NonNull Resources resources, @Nullable com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        if (sVar == null) {
            return null;
        }
        return new q(resources, sVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void b() {
        if (this.b instanceof com.kwad.sdk.glide.load.engine.o) {
            ((com.kwad.sdk.glide.load.engine.o) this.b).b();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        this.b.d_();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public BitmapDrawable e() {
        return new BitmapDrawable(this.f6795a, this.b.e());
    }
}
