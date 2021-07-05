package com.kwad.sdk.glide.webp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.webp.decoder.g;
import com.kwad.sdk.glide.webp.decoder.j;
import com.kwad.sdk.glide.webp.decoder.k;
import com.kwad.sdk.glide.webp.decoder.l;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.glide.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.glide.d.b
    public void a(Context context, com.kwad.sdk.glide.c cVar, Registry registry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, cVar, registry) == null) {
            Resources resources = context.getResources();
            com.kwad.sdk.glide.load.engine.bitmap_recycle.e a2 = cVar.a();
            com.kwad.sdk.glide.load.engine.bitmap_recycle.b b2 = cVar.b();
            j jVar = new j(registry.a(), resources.getDisplayMetrics(), a2, b2);
            com.kwad.sdk.glide.webp.decoder.a aVar = new com.kwad.sdk.glide.webp.decoder.a(b2, a2);
            com.kwad.sdk.glide.webp.decoder.c cVar2 = new com.kwad.sdk.glide.webp.decoder.c(jVar);
            com.kwad.sdk.glide.webp.decoder.f fVar = new com.kwad.sdk.glide.webp.decoder.f(jVar, b2);
            com.kwad.sdk.glide.webp.decoder.d dVar = new com.kwad.sdk.glide.webp.decoder.d(context, b2, a2);
            registry.b(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, cVar2).b(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, fVar).b(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, cVar2)).b(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, fVar)).b(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, new com.kwad.sdk.glide.webp.decoder.b(aVar)).b(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, new com.kwad.sdk.glide.webp.decoder.e(aVar)).b(ByteBuffer.class, k.class, dVar).b(InputStream.class, k.class, new g(dVar, b2)).b(k.class, new l());
        }
    }
}
