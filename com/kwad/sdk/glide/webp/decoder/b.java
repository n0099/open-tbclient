package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.glide.load.f<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final a f36214a;

    public b(a aVar) {
        this.f36214a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36214a.a(byteBuffer, i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f36214a.a(byteBuffer, eVar);
    }
}
