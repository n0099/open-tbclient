package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes5.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f10626a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f10627b;
    private final e<com.kwad.sdk.glide.load.resource.d.c, byte[]> c;

    public c(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<com.kwad.sdk.glide.load.resource.d.c, byte[]> eVar3) {
        this.f10626a = eVar;
        this.f10627b = eVar2;
        this.c = eVar3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.glide.load.engine.s<android.graphics.drawable.Drawable> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static s<com.kwad.sdk.glide.load.resource.d.c> a(@NonNull s<Drawable> sVar) {
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    @Nullable
    public s<byte[]> a(@NonNull s<Drawable> sVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        Drawable e = sVar.e();
        if (e instanceof BitmapDrawable) {
            return this.f10627b.a(com.kwad.sdk.glide.load.resource.bitmap.d.a(((BitmapDrawable) e).getBitmap(), this.f10626a), eVar);
        }
        if (e instanceof com.kwad.sdk.glide.load.resource.d.c) {
            return this.c.a(a(sVar), eVar);
        }
        return null;
    }
}
