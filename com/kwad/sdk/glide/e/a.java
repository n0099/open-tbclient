package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0408a<?>> f35140a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0408a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a<T> f35141a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35142b;

        public C0408a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f35142b = cls;
            this.f35141a = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35142b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        for (C0408a<?> c0408a : this.f35140a) {
            if (c0408a.a(cls)) {
                return (com.kwad.sdk.glide.load.a<T>) c0408a.f35141a;
            }
        }
        return null;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f35140a.add(new C0408a<>(cls, aVar));
    }
}
