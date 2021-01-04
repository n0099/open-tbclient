package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.glide.webp.WebpImage;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class d implements com.kwad.sdk.glide.load.f<ByteBuffer, k> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f10671a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", false);

    /* renamed from: b  reason: collision with root package name */
    private final Context f10672b;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e c;
    private final com.kwad.sdk.glide.load.resource.d.b d;

    public d(Context context, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f10672b = context.getApplicationContext();
        this.c = eVar;
        this.d = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<k> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        i iVar = new i(this.d, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i, i2), (WebpFrameCacheStrategy) eVar.a(o.f10688a));
        iVar.b();
        Bitmap h = iVar.h();
        if (h == null) {
            return null;
        }
        return new m(new k(this.f10672b, iVar, this.c, com.kwad.sdk.glide.load.resource.b.a(), i, i2, h));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f10671a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(byteBuffer));
    }
}
