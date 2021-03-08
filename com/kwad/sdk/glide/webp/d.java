package com.kwad.sdk.glide.webp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.webp.decoder.g;
import com.kwad.sdk.glide.webp.decoder.j;
import com.kwad.sdk.glide.webp.decoder.k;
import com.kwad.sdk.glide.webp.decoder.l;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.glide.d.b {
    @Override // com.kwad.sdk.glide.d.b
    public void a(Context context, com.kwad.sdk.glide.c cVar, Registry registry) {
        Resources resources = context.getResources();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.e a2 = cVar.a();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b b = cVar.b();
        j jVar = new j(registry.a(), resources.getDisplayMetrics(), a2, b);
        com.kwad.sdk.glide.webp.decoder.a aVar = new com.kwad.sdk.glide.webp.decoder.a(b, a2);
        com.kwad.sdk.glide.webp.decoder.c cVar2 = new com.kwad.sdk.glide.webp.decoder.c(jVar);
        com.kwad.sdk.glide.webp.decoder.f fVar = new com.kwad.sdk.glide.webp.decoder.f(jVar, b);
        com.kwad.sdk.glide.webp.decoder.d dVar = new com.kwad.sdk.glide.webp.decoder.d(context, b, a2);
        registry.b(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, cVar2).b(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, fVar).b(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, cVar2)).b(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, fVar)).b(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, new com.kwad.sdk.glide.webp.decoder.b(aVar)).b(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, new com.kwad.sdk.glide.webp.decoder.e(aVar)).b(ByteBuffer.class, k.class, dVar).b(InputStream.class, k.class, new g(dVar, b)).b(k.class, new l());
    }
}
