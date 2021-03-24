package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.EncodeStrategy;
import java.io.File;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.glide.load.g<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35651a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.g<Bitmap> f35652b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.g<Bitmap> gVar) {
        this.f35651a = eVar;
        this.f35652b = gVar;
    }

    @Override // com.kwad.sdk.glide.load.g
    @NonNull
    public EncodeStrategy a(@NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f35652b.a(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull com.kwad.sdk.glide.load.engine.s<BitmapDrawable> sVar, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f35652b.a(new d(sVar.e().getBitmap(), this.f35651a), file, eVar);
    }
}
