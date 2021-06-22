package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.glide.webp.WebpImage;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.glide.load.f<ByteBuffer, k> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f36628a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public final Context f36629b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36630c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.d.b f36631d;

    public d(Context context, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f36629b = context.getApplicationContext();
        this.f36630c = eVar;
        this.f36631d = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<k> a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        i iVar = new i(this.f36631d, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i2, i3), (WebpFrameCacheStrategy) eVar.a(o.f36667a));
        iVar.b();
        Bitmap h2 = iVar.h();
        if (h2 == null) {
            return null;
        }
        return new m(new k(this.f36629b, iVar, this.f36630c, com.kwad.sdk.glide.load.resource.b.a(), i2, i3, h2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36628a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(byteBuffer));
    }
}
