package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class c implements com.kwad.sdk.glide.load.f<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final j f10670a;

    public c(j jVar) {
        this.f10670a = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public s<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10670a.a(com.kwad.sdk.glide.g.a.b(byteBuffer), i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f10670a.a(byteBuffer, eVar);
    }
}
