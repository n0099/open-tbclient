package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes6.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36132a;

    /* renamed from: b  reason: collision with root package name */
    public final e<Bitmap, byte[]> f36133b;

    /* renamed from: c  reason: collision with root package name */
    public final e<com.kwad.sdk.glide.load.resource.d.c, byte[]> f36134c;

    public c(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<com.kwad.sdk.glide.load.resource.d.c, byte[]> eVar3) {
        this.f36132a = eVar;
        this.f36133b = eVar2;
        this.f36134c = eVar3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.glide.load.engine.s<android.graphics.drawable.Drawable> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static s<com.kwad.sdk.glide.load.resource.d.c> a(@NonNull s<Drawable> sVar) {
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    @Nullable
    public s<byte[]> a(@NonNull s<Drawable> sVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        Drawable e2 = sVar.e();
        if (e2 instanceof BitmapDrawable) {
            return this.f36133b.a(com.kwad.sdk.glide.load.resource.bitmap.d.a(((BitmapDrawable) e2).getBitmap(), this.f36132a), eVar);
        }
        if (e2 instanceof com.kwad.sdk.glide.load.resource.d.c) {
            return this.f36134c.a(a(sVar), eVar);
        }
        return null;
    }
}
