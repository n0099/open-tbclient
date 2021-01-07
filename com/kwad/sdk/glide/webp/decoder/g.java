package com.kwad.sdk.glide.webp.decoder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class g implements com.kwad.sdk.glide.load.f<InputStream, k> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f10677a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.StreamWebpDecoder.DisableAnimation", false);

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.f<ByteBuffer, k> f10678b;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b c;

    public g(com.kwad.sdk.glide.load.f<ByteBuffer, k> fVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10678b = fVar;
        this.c = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<k> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        byte[] a2 = h.a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f10678b.a(ByteBuffer.wrap(a2), i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f10677a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(inputStream, this.c));
    }
}
