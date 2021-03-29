package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class c implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35514b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35515c;

    public c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.f35514b = cVar;
        this.f35515c = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f35514b.a(messageDigest);
        this.f35515c.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f35514b.equals(cVar.f35514b) && this.f35515c.equals(cVar.f35515c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return (this.f35514b.hashCode() * 31) + this.f35515c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f35514b + ", signature=" + this.f35515c + '}';
    }
}
