package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class e implements c {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<d<?>, Object> f36164b = new com.kwad.sdk.glide.g.b();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@NonNull d<T> dVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        dVar.a((d<T>) obj, messageDigest);
    }

    @NonNull
    public <T> e a(@NonNull d<T> dVar, @NonNull T t) {
        this.f36164b.put(dVar, t);
        return this;
    }

    @Nullable
    public <T> T a(@NonNull d<T> dVar) {
        return this.f36164b.containsKey(dVar) ? (T) this.f36164b.get(dVar) : dVar.a();
    }

    public void a(@NonNull e eVar) {
        this.f36164b.putAll((SimpleArrayMap<? extends d<?>, ? extends Object>) eVar.f36164b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f36164b.size(); i2++) {
            a(this.f36164b.keyAt(i2), this.f36164b.valueAt(i2), messageDigest);
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f36164b.equals(((e) obj).f36164b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.f36164b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f36164b + '}';
    }
}
