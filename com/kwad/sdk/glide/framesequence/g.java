package com.kwad.sdk.glide.framesequence;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes3.dex */
public class g implements com.kwad.sdk.glide.load.f<InputStream, FrameSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f6618a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableAnimation", false);
    public static final com.kwad.sdk.glide.load.d<Boolean> b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableWebp", false);
    private final List<ImageHeaderParser> c;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b d;

    public g(List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.c = list;
        this.d = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<FrameSequence> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        FrameSequence decodeStream = FrameSequence.decodeStream(inputStream);
        if (decodeStream == null) {
            return null;
        }
        return new b(decodeStream);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f6618a)).booleanValue()) {
            return false;
        }
        ImageHeaderParser.ImageType a2 = com.kwad.sdk.glide.load.b.a(this.c, inputStream, this.d);
        if (a2 == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        if (((Boolean) eVar.a(b)).booleanValue() || !(a2 == ImageHeaderParser.ImageType.WEBP || a2 == ImageHeaderParser.ImageType.WEBP_A)) {
            return false;
        }
        return WebpHeaderParser.a(WebpHeaderParser.a(inputStream, this.d));
    }
}
