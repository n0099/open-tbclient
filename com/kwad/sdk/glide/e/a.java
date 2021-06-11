package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0408a<?>> f35821a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0408a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a<T> f35822a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35823b;

        public C0408a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f35823b = cls;
            this.f35822a = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35823b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        for (C0408a<?> c0408a : this.f35821a) {
            if (c0408a.a(cls)) {
                return (com.kwad.sdk.glide.load.a<T>) c0408a.f35822a;
            }
        }
        return null;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f35821a.add(new C0408a<>(cls, aVar));
    }
}
