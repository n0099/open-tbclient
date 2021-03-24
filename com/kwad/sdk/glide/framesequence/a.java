package com.kwad.sdk.glide.framesequence;

import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.glide.load.f<ByteBuffer, FrameSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f35173a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.ByteBufferFsDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f35174b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.framesequence.ByteBufferFsDecoder.DisableWebp", Boolean.FALSE);

    /* renamed from: c  reason: collision with root package name */
    public final List<ImageHeaderParser> f35175c;

    public a(List<ImageHeaderParser> list) {
        this.f35175c = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<FrameSequence> a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        FrameSequence decodeByteArray = FrameSequence.decodeByteArray(bArr);
        if (decodeByteArray == null) {
            return null;
        }
        return new b(decodeByteArray);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f35173a)).booleanValue()) {
            return false;
        }
        byteBuffer.mark();
        ImageHeaderParser.ImageType a2 = com.kwad.sdk.glide.load.b.a(this.f35175c, byteBuffer);
        byteBuffer.reset();
        if (a2 == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        if (((Boolean) eVar.a(f35174b)).booleanValue() || !(a2 == ImageHeaderParser.ImageType.WEBP || a2 == ImageHeaderParser.ImageType.WEBP_A)) {
            return false;
        }
        return WebpHeaderParser.a(WebpHeaderParser.a(byteBuffer));
    }
}
