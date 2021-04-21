package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.glide.load.f<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final j f36221a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36222b;

    public f(j jVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f36221a = jVar;
        this.f36222b = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public s<Bitmap> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36221a.a(inputStream, i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36221a.a(inputStream, eVar);
    }
}
