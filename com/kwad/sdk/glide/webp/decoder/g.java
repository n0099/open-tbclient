package com.kwad.sdk.glide.webp.decoder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class g implements com.kwad.sdk.glide.load.f<InputStream, k> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f36223a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.StreamWebpDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.f<ByteBuffer, k> f36224b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36225c;

    public g(com.kwad.sdk.glide.load.f<ByteBuffer, k> fVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f36224b = fVar;
        this.f36225c = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<k> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        byte[] a2 = h.a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f36224b.a(ByteBuffer.wrap(a2), i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36223a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(inputStream, this.f36225c));
    }
}
