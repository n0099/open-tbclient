package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
final class c implements com.kwad.sdk.glide.load.c {

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.c f10507b;
    private final com.kwad.sdk.glide.load.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.f10507b = cVar;
        this.c = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.f10507b.a(messageDigest);
        this.c.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f10507b.equals(cVar.f10507b) && this.c.equals(cVar.c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return (this.f10507b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f10507b + ", signature=" + this.c + '}';
    }
}
