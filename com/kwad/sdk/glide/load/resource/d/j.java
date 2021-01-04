package com.kwad.sdk.glide.load.resource.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes5.dex */
public class j implements com.kwad.sdk.glide.load.f<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f10621a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.f<ByteBuffer, c> f10622b;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b c;

    public j(List<ImageHeaderParser> list, com.kwad.sdk.glide.load.f<ByteBuffer, c> fVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10621a = list;
        this.f10622b = fVar;
        this.c = bVar;
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public s<c> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f10622b.a(ByteBuffer.wrap(a2), i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return !((Boolean) eVar.a(i.f10620b)).booleanValue() && com.kwad.sdk.glide.load.b.a(this.f10621a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
