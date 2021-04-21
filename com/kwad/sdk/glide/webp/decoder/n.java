package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.kwad.sdk.glide.load.engine.s;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class n implements com.kwad.sdk.glide.load.h<k> {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.h<Bitmap> f36252b;

    public n(com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        this.f36252b = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    @Override // com.kwad.sdk.glide.load.h
    public s<k> a(Context context, s<k> sVar, int i, int i2) {
        k e2 = sVar.e();
        s<Bitmap> dVar = new com.kwad.sdk.glide.load.resource.bitmap.d(e2.b(), com.kwad.sdk.glide.c.a(context).a());
        s<Bitmap> a2 = this.f36252b.a(context, dVar, i, i2);
        if (!dVar.equals(a2)) {
            dVar.d_();
        }
        e2.a(this.f36252b, a2.e());
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(MessageDigest messageDigest) {
        this.f36252b.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f36252b.equals(((n) obj).f36252b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f36252b.hashCode();
    }
}
