package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.g.j;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Object> f6710a = new a<Object>() { // from class: com.kwad.sdk.glide.load.d.1
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };
    private final T b;
    private final a<T> c;
    private final String d;
    private volatile byte[] e;

    /* loaded from: classes3.dex */
    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private d(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        this.d = j.a(str);
        this.b = t;
        this.c = (a) j.a(aVar);
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str) {
        return new d<>(str, null, c());
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str, @NonNull T t) {
        return new d<>(str, t, c());
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        return new d<>(str, t, aVar);
    }

    @NonNull
    private byte[] b() {
        if (this.e == null) {
            this.e = this.d.getBytes(c.f6709a);
        }
        return this.e;
    }

    @NonNull
    private static <T> a<T> c() {
        return (a<T>) f6710a;
    }

    @Nullable
    public T a() {
        return this.b;
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.c.a(b(), t, messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.d.equals(((d) obj).d);
        }
        return false;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.d + "'}";
    }
}
