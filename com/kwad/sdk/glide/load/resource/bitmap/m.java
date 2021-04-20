package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class m implements com.kwad.sdk.glide.load.h<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.h<Bitmap> f35966b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f35967c;

    public m(com.kwad.sdk.glide.load.h<Bitmap> hVar, boolean z) {
        this.f35966b = hVar;
        this.f35967c = z;
    }

    private com.kwad.sdk.glide.load.engine.s<Drawable> a(Context context, com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        return q.a(context.getResources(), sVar);
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public com.kwad.sdk.glide.load.engine.s<Drawable> a(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.s<Drawable> sVar, int i, int i2) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.e a2 = com.kwad.sdk.glide.c.a(context).a();
        Drawable e2 = sVar.e();
        com.kwad.sdk.glide.load.engine.s<Bitmap> a3 = l.a(a2, e2, i, i2);
        if (a3 != null) {
            com.kwad.sdk.glide.load.engine.s<Bitmap> a4 = this.f35966b.a(context, a3, i, i2);
            if (a4.equals(a3)) {
                a4.d_();
                return sVar;
            }
            return a(context, a4);
        } else if (this.f35967c) {
            throw new IllegalArgumentException("Unable to convert " + e2 + " to a Bitmap");
        } else {
            return sVar;
        }
    }

    public com.kwad.sdk.glide.load.h<BitmapDrawable> a() {
        return this;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f35966b.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f35966b.equals(((m) obj).f35966b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f35966b.hashCode();
    }
}
