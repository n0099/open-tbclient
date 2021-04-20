package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0422a<?>> f35429a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0422a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a<T> f35430a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35431b;

        public C0422a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f35431b = cls;
            this.f35430a = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35431b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        for (C0422a<?> c0422a : this.f35429a) {
            if (c0422a.a(cls)) {
                return (com.kwad.sdk.glide.load.a<T>) c0422a.f35430a;
            }
        }
        return null;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f35429a.add(new C0422a<>(cls, aVar));
    }
}
