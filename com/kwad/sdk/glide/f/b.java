package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class b implements c {

    /* renamed from: b  reason: collision with root package name */
    public final Object f35948b;

    public b(@NonNull Object obj) {
        this.f35948b = j.a(obj);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f35948b.toString().getBytes(c.f36158a));
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f35948b.equals(((b) obj).f35948b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f35948b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f35948b + '}';
    }
}
