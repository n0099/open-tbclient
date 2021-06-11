package com.kwad.sdk.glide.load.resource.d;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class f implements com.kwad.sdk.glide.load.h<c> {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.h<Bitmap> f36420b;

    public f(com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        this.f36420b = (com.kwad.sdk.glide.load.h) com.kwad.sdk.glide.g.j.a(hVar);
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<c> a(@NonNull Context context, @NonNull s<c> sVar, int i2, int i3) {
        c e2 = sVar.e();
        s<Bitmap> dVar = new com.kwad.sdk.glide.load.resource.bitmap.d(e2.b(), com.kwad.sdk.glide.c.a(context).a());
        s<Bitmap> a2 = this.f36420b.a(context, dVar, i2, i3);
        if (!dVar.equals(a2)) {
            dVar.d_();
        }
        e2.a(this.f36420b, a2.e());
        return sVar;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f36420b.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f36420b.equals(((f) obj).f36420b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f36420b.hashCode();
    }
}
