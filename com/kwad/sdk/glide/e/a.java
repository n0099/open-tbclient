package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0411a<?>> f35919a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0411a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a<T> f35920a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35921b;

        public C0411a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f35921b = cls;
            this.f35920a = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35921b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        for (C0411a<?> c0411a : this.f35919a) {
            if (c0411a.a(cls)) {
                return (com.kwad.sdk.glide.load.a<T>) c0411a.f35920a;
            }
        }
        return null;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f35919a.add(new C0411a<>(cls, aVar));
    }
}
