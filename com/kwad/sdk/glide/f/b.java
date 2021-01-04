package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class b implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f10282b;

    public b(@NonNull Object obj) {
        this.f10282b = j.a(obj);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f10282b.toString().getBytes(f10431a));
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f10282b.equals(((b) obj).f10282b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f10282b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f10282b + '}';
    }
}
