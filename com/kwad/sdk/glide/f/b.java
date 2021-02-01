package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class b implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f9985b;

    public b(@NonNull Object obj) {
        this.f9985b = j.a(obj);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f9985b.toString().getBytes(f10134a));
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f9985b.equals(((b) obj).f9985b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f9985b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f9985b + '}';
    }
}
