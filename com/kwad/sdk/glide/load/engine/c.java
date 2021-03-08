package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
final class c implements com.kwad.sdk.glide.load.c {
    private final com.kwad.sdk.glide.load.c b;
    private final com.kwad.sdk.glide.load.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2) {
        this.b = cVar;
        this.c = cVar2;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.c.a(messageDigest);
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.b.equals(cVar.b) && this.c.equals(cVar.c);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }
}
