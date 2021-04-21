package com.kwad.sdk.glide.load.resource.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes6.dex */
public class j implements com.kwad.sdk.glide.load.f<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    public final List<ImageHeaderParser> f36126a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.f<ByteBuffer, c> f36127b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36128c;

    public j(List<ImageHeaderParser> list, com.kwad.sdk.glide.load.f<ByteBuffer, c> fVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f36126a = list;
        this.f36127b = fVar;
        this.f36128c = bVar;
    }

    public static byte[] a(InputStream inputStream) {
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
        } catch (IOException e2) {
            if (Log.isLoggable(StreamGifDecoder.TAG, 5)) {
                Log.w(StreamGifDecoder.TAG, "Error reading data from stream", e2);
                return null;
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
        return this.f36127b.a(ByteBuffer.wrap(a2), i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return !((Boolean) eVar.a(i.f36125b)).booleanValue() && com.kwad.sdk.glide.load.b.a(this.f36126a, inputStream, this.f36128c) == ImageHeaderParser.ImageType.GIF;
    }
}
