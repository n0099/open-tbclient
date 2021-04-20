package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class c implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35803b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35804c;

    public c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.f35803b = cVar;
        this.f35804c = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f35803b.a(messageDigest);
        this.f35804c.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f35803b.equals(cVar.f35803b) && this.f35804c.equals(cVar.f35804c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return (this.f35803b.hashCode() * 31) + this.f35804c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f35803b + ", signature=" + this.f35804c + '}';
    }
}
