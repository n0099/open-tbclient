package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.glide.load.f<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final j f36627a;

    public c(j jVar) {
        this.f36627a = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public s<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36627a.a(com.kwad.sdk.glide.g.a.b(byteBuffer), i2, i3, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36627a.a(byteBuffer, eVar);
    }
}
