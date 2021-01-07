package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class r implements com.kwad.sdk.glide.load.f<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.resource.b.d f10592a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f10593b;

    public r(com.kwad.sdk.glide.load.resource.b.d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f10592a = dVar;
        this.f10593b = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        com.kwad.sdk.glide.load.engine.s<Drawable> a2 = this.f10592a.a(uri, i, i2, eVar);
        if (a2 == null) {
            return null;
        }
        return l.a(this.f10593b, a2.e(), i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Uri uri, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
