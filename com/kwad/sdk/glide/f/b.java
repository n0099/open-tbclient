package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class b implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f10283b;

    public b(@NonNull Object obj) {
        this.f10283b = j.a(obj);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f10283b.toString().getBytes(f10432a));
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f10283b.equals(((b) obj).f10283b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f10283b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f10283b + '}';
    }
}
