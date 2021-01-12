package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class f implements com.kwad.sdk.glide.load.f<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final j f10375a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f10376b;

    public f(j jVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10375a = jVar;
        this.f10376b = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public s<Bitmap> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10375a.a(inputStream, i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10375a.a(inputStream, eVar);
    }
}
