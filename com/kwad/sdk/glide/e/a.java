package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0425a<?>> f35524a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0425a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a<T> f35525a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35526b;

        public C0425a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f35526b = cls;
            this.f35525a = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35526b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        for (C0425a<?> c0425a : this.f35524a) {
            if (c0425a.a(cls)) {
                return (com.kwad.sdk.glide.load.a<T>) c0425a.f35525a;
            }
        }
        return null;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f35524a.add(new C0425a<>(cls, aVar));
    }
}
