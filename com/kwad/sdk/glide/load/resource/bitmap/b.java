package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.EncodeStrategy;
import java.io.File;
/* loaded from: classes5.dex */
public class b implements com.kwad.sdk.glide.load.g<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f10567a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.g<Bitmap> f10568b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.g<Bitmap> gVar) {
        this.f10567a = eVar;
        this.f10568b = gVar;
    }

    @Override // com.kwad.sdk.glide.load.g
    @NonNull
    public EncodeStrategy a(@NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10568b.a(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull com.kwad.sdk.glide.load.engine.s<BitmapDrawable> sVar, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10568b.a(new d(sVar.e().getBitmap(), this.f10567a), file, eVar);
    }
}
