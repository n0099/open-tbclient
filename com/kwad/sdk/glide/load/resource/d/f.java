package com.kwad.sdk.glide.load.resource.d;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.glide.load.h<c> {
    private final com.kwad.sdk.glide.load.h<Bitmap> b;

    public f(com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        this.b = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<c> a(@NonNull Context context, @NonNull s<c> sVar, int i, int i2) {
        c e = sVar.e();
        s<Bitmap> dVar = new com.kwad.sdk.glide.load.resource.bitmap.d(e.b(), com.kwad.sdk.glide.c.a(context).a());
        s<Bitmap> a2 = this.b.a(context, dVar, i, i2);
        if (!dVar.equals(a2)) {
            dVar.d_();
        }
        e.a(this.b, a2.e());
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.b.equals(((f) obj).b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.b.hashCode();
    }
}
