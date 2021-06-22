package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.g.j;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a<Object> f36159a = new a<Object>() { // from class: com.kwad.sdk.glide.load.d.1
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final T f36160b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f36161c;

    /* renamed from: d  reason: collision with root package name */
    public final String f36162d;

    /* renamed from: e  reason: collision with root package name */
    public volatile byte[] f36163e;

    /* loaded from: classes7.dex */
    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public d(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        this.f36162d = j.a(str);
        this.f36160b = t;
        this.f36161c = (a) j.a(aVar);
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
        if (this.f36163e == null) {
            this.f36163e = this.f36162d.getBytes(c.f36158a);
        }
        return this.f36163e;
    }

    @NonNull
    public static <T> a<T> c() {
        return (a<T>) f36159a;
    }

    @Nullable
    public T a() {
        return this.f36160b;
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f36161c.a(b(), t, messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f36162d.equals(((d) obj).f36162d);
        }
        return false;
    }

    public int hashCode() {
        return this.f36162d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f36162d + "'}";
    }
}
