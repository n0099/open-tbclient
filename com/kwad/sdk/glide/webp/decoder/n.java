package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class n implements com.kwad.sdk.glide.load.h<k> {

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.h<Bitmap> f10388b;

    public n(com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        this.f10388b = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    @Override // com.kwad.sdk.glide.load.h
    public s<k> a(Context context, s<k> sVar, int i, int i2) {
        k e = sVar.e();
        s<Bitmap> dVar = new com.kwad.sdk.glide.load.resource.bitmap.d(e.b(), com.kwad.sdk.glide.c.a(context).a());
        s<Bitmap> a2 = this.f10388b.a(context, dVar, i, i2);
        if (!dVar.equals(a2)) {
            dVar.d_();
        }
        e.a(this.f10388b, a2.e());
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(MessageDigest messageDigest) {
        this.f10388b.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f10388b.equals(((n) obj).f10388b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f10388b.hashCode();
    }
}
