package com.kwad.sdk.glide.framesequence;

import android.content.Context;
import com.kwad.sdk.glide.Registry;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.glide.d.b {
    @Override // com.kwad.sdk.glide.d.b
    public void a(Context context, com.kwad.sdk.glide.c cVar, Registry registry) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.e a2 = cVar.a();
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b b2 = cVar.b();
        a aVar = new a(registry.a());
        g gVar = new g(registry.a(), b2);
        registry.b(ByteBuffer.class, FrameSequence.class, aVar).b(InputStream.class, FrameSequence.class, gVar).b(ByteBuffer.class, FrameSequenceDrawable.class, new c(a2, aVar)).b(InputStream.class, FrameSequenceDrawable.class, new c(a2, gVar)).a(FrameSequence.class, FrameSequenceDrawable.class, new e(a2));
    }
}
