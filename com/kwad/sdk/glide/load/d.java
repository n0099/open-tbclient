package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.g.j;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Object> f10133a = new a<Object>() { // from class: com.kwad.sdk.glide.load.d.1
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final T f10134b;
    private final a<T> c;
    private final String d;
    private volatile byte[] e;

    /* loaded from: classes4.dex */
    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private d(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        this.d = j.a(str);
        this.f10134b = t;
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
            this.e = this.d.getBytes(c.f10132a);
        }
        return this.e;
    }

    @NonNull
    private static <T> a<T> c() {
        return (a<T>) f10133a;
    }

    @Nullable
    public T a() {
        return this.f10134b;
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
