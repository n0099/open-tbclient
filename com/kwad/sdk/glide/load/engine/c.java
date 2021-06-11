package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class c implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36201b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36202c;

    public c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.f36201b = cVar;
        this.f36202c = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f36201b.a(messageDigest);
        this.f36202c.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f36201b.equals(cVar.f36201b) && this.f36202c.equals(cVar.f36202c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return (this.f36201b.hashCode() * 31) + this.f36202c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f36201b + ", signature=" + this.f36202c + '}';
    }
}
