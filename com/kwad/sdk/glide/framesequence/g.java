package com.kwad.sdk.glide.framesequence;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements com.kwad.sdk.glide.load.f<InputStream, FrameSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f35474a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f35475b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableWebp", Boolean.FALSE);

    /* renamed from: c  reason: collision with root package name */
    public final List<ImageHeaderParser> f35476c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35477d;

    public g(List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f35476c = list;
        this.f35477d = bVar;
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
        if (((Boolean) eVar.a(f35474a)).booleanValue()) {
            return false;
        }
        ImageHeaderParser.ImageType a2 = com.kwad.sdk.glide.load.b.a(this.f35476c, inputStream, this.f35477d);
        if (a2 == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        if (((Boolean) eVar.a(f35475b)).booleanValue() || !(a2 == ImageHeaderParser.ImageType.WEBP || a2 == ImageHeaderParser.ImageType.WEBP_A)) {
            return false;
        }
        return WebpHeaderParser.a(WebpHeaderParser.a(inputStream, this.f35477d));
    }
}
