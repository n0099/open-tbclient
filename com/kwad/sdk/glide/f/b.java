package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class b implements c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f35457b;

    public b(@NonNull Object obj) {
        this.f35457b = j.a(obj);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f35457b.toString().getBytes(c.f35666a));
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f35457b.equals(((b) obj).f35457b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f35457b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f35457b + '}';
    }
}
