package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class c implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36299b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f36300c;

    public c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.f36299b = cVar;
        this.f36300c = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f36299b.a(messageDigest);
        this.f36300c.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f36299b.equals(cVar.f36299b) && this.f36300c.equals(cVar.f36300c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return (this.f36299b.hashCode() * 31) + this.f36300c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f36299b + ", signature=" + this.f36300c + '}';
    }
}
