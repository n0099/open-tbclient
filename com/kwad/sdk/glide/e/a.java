package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0407a<?>> f35139a = new ArrayList();

    /* renamed from: com.kwad.sdk.glide.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0407a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.a<T> f35140a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35141b;

        public C0407a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
            this.f35141b = cls;
            this.f35140a = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35141b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.kwad.sdk.glide.load.a<T> a(@NonNull Class<T> cls) {
        for (C0407a<?> c0407a : this.f35139a) {
            if (c0407a.a(cls)) {
                return (com.kwad.sdk.glide.load.a<T>) c0407a.f35140a;
            }
        }
        return null;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.kwad.sdk.glide.load.a<T> aVar) {
        this.f35139a.add(new C0407a<>(cls, aVar));
    }
}
