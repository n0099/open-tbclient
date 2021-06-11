package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
/* loaded from: classes7.dex */
public class r implements com.kwad.sdk.glide.load.f<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.b.d f36380a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36381b;

    public r(com.kwad.sdk.glide.load.resource.b.d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f36380a = dVar;
        this.f36381b = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Uri uri, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        com.kwad.sdk.glide.load.engine.s<Drawable> a2 = this.f36380a.a(uri, i2, i3, eVar);
        if (a2 == null) {
            return null;
        }
        return l.a(this.f36381b, a2.e(), i2, i3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Uri uri, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme());
    }
}
