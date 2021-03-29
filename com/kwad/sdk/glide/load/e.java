package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class e implements c {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<d<?>, Object> f35383b = new com.kwad.sdk.glide.g.b();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@NonNull d<T> dVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        dVar.a((d<T>) obj, messageDigest);
    }

    @NonNull
    public <T> e a(@NonNull d<T> dVar, @NonNull T t) {
        this.f35383b.put(dVar, t);
        return this;
    }

    @Nullable
    public <T> T a(@NonNull d<T> dVar) {
        return this.f35383b.containsKey(dVar) ? (T) this.f35383b.get(dVar) : dVar.a();
    }

    public void a(@NonNull e eVar) {
        this.f35383b.putAll((SimpleArrayMap<? extends d<?>, ? extends Object>) eVar.f35383b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.f35383b.size(); i++) {
            a(this.f35383b.keyAt(i), this.f35383b.valueAt(i), messageDigest);
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f35383b.equals(((e) obj).f35383b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f35383b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f35383b + '}';
    }
}
