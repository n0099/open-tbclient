package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.glide.load.f<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final k f35948a;

    public f(k kVar) {
        this.f35948a = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f35948a.a(com.kwad.sdk.glide.g.a.b(byteBuffer), i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return this.f35948a.a(byteBuffer);
    }
}
