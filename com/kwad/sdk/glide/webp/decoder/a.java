package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.glide.webp.WebpImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f36622a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36623b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36624c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.d.b f36625d;

    public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f36623b = bVar;
        this.f36624c = eVar;
        this.f36625d = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        byte[] a2 = h.a(inputStream);
        if (a2 == null) {
            return null;
        }
        return a(ByteBuffer.wrap(a2), i2, i3, eVar);
    }

    public s<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        i iVar = new i(this.f36625d, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i2, i3));
        try {
            iVar.b();
            return com.kwad.sdk.glide.load.resource.bitmap.d.a(iVar.h(), this.f36624c);
        } finally {
            iVar.i();
        }
    }

    public boolean a(InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36622a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(inputStream, this.f36623b));
    }

    public boolean a(ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36622a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(byteBuffer));
    }
}
