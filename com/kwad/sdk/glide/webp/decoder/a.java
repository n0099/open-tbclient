package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.glide.webp.WebpImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f36115a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36116b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36117c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.d.b f36118d;

    public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f36116b = bVar;
        this.f36117c = eVar;
        this.f36118d = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    public s<Bitmap> a(InputStream inputStream, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        byte[] a2 = h.a(inputStream);
        if (a2 == null) {
            return null;
        }
        return a(ByteBuffer.wrap(a2), i, i2, eVar);
    }

    public s<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        i iVar = new i(this.f36118d, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i, i2));
        try {
            iVar.b();
            return com.kwad.sdk.glide.load.resource.bitmap.d.a(iVar.h(), this.f36117c);
        } finally {
            iVar.i();
        }
    }

    public boolean a(InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36115a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(inputStream, this.f36116b));
    }

    public boolean a(ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        if (((Boolean) eVar.a(f36115a)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.c(WebpHeaderParser.a(byteBuffer));
    }
}
