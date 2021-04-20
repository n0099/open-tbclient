package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.g.j;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a<Object> f35667a = new a<Object>() { // from class: com.kwad.sdk.glide.load.d.1
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final T f35668b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f35669c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35670d;

    /* renamed from: e  reason: collision with root package name */
    public volatile byte[] f35671e;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public d(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        this.f35670d = j.a(str);
        this.f35668b = t;
        this.f35669c = (a) j.a(aVar);
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
        if (this.f35671e == null) {
            this.f35671e = this.f35670d.getBytes(c.f35666a);
        }
        return this.f35671e;
    }

    @NonNull
    public static <T> a<T> c() {
        return (a<T>) f35667a;
    }

    @Nullable
    public T a() {
        return this.f35668b;
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f35669c.a(b(), t, messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f35670d.equals(((d) obj).f35670d);
        }
        return false;
    }

    public int hashCode() {
        return this.f35670d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f35670d + "'}";
    }
}
