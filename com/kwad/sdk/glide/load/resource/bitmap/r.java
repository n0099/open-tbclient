package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
/* loaded from: classes6.dex */
public class r implements com.kwad.sdk.glide.load.f<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.b.d f35686a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35687b;

    public r(com.kwad.sdk.glide.load.resource.b.d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f35686a = dVar;
        this.f35687b = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Uri uri, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        com.kwad.sdk.glide.load.engine.s<Drawable> a2 = this.f35686a.a(uri, i, i2, eVar);
        if (a2 == null) {
            return null;
        }
        return l.a(this.f35687b, a2.e(), i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Uri uri, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme());
    }
}
