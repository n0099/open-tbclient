package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.g.j;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a<Object> f35762a = new a<Object>() { // from class: com.kwad.sdk.glide.load.d.1
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final T f35763b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f35764c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35765d;

    /* renamed from: e  reason: collision with root package name */
    public volatile byte[] f35766e;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public d(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        this.f35765d = j.a(str);
        this.f35763b = t;
        this.f35764c = (a) j.a(aVar);
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
        if (this.f35766e == null) {
            this.f35766e = this.f35765d.getBytes(c.f35761a);
        }
        return this.f35766e;
    }

    @NonNull
    public static <T> a<T> c() {
        return (a<T>) f35762a;
    }

    @Nullable
    public T a() {
        return this.f35763b;
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f35764c.a(b(), t, messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f35765d.equals(((d) obj).f35765d);
        }
        return false;
    }

    public int hashCode() {
        return this.f35765d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f35765d + "'}";
    }
}
