package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class e implements c {
    private final ArrayMap<d<?>, Object> b = new com.kwad.sdk.glide.g.b();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(@NonNull d<T> dVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        dVar.a((d<T>) obj, messageDigest);
    }

    @NonNull
    public <T> e a(@NonNull d<T> dVar, @NonNull T t) {
        this.b.put(dVar, t);
        return this;
    }

    @Nullable
    public <T> T a(@NonNull d<T> dVar) {
        return this.b.containsKey(dVar) ? (T) this.b.get(dVar) : dVar.a();
    }

    public void a(@NonNull e eVar) {
        this.b.putAll((SimpleArrayMap<? extends d<?>, ? extends Object>) eVar.b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            a(this.b.keyAt(i2), this.b.valueAt(i2), messageDigest);
            i = i2 + 1;
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.b.equals(((e) obj).b);
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }
}
