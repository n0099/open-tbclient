package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class q implements com.kwad.sdk.glide.load.engine.o, com.kwad.sdk.glide.load.engine.s<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f10590a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.s<Bitmap> f10591b;

    private q(@NonNull Resources resources, @NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        this.f10590a = (Resources) com.kwad.sdk.glide.g.j.a(resources);
        this.f10591b = (com.kwad.sdk.glide.load.engine.s) com.kwad.sdk.glide.g.j.a(sVar);
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
        if (this.f10591b instanceof com.kwad.sdk.glide.load.engine.o) {
            ((com.kwad.sdk.glide.load.engine.o) this.f10591b).b();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f10591b.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        this.f10591b.d_();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public BitmapDrawable e() {
        return new BitmapDrawable(this.f10590a, this.f10591b.e());
    }
}
