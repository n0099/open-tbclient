package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class c implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35513b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f35514c;

    public c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.f35513b = cVar;
        this.f35514c = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f35513b.a(messageDigest);
        this.f35514c.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f35513b.equals(cVar.f35513b) && this.f35514c.equals(cVar.f35514c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return (this.f35513b.hashCode() * 31) + this.f35514c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f35513b + ", signature=" + this.f35514c + '}';
    }
}
