package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?>> f35153a = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g<T> f35154a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35155b;

        public a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            this.f35155b = cls;
            this.f35154a = gVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35155b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <Z> g<Z> a(@NonNull Class<Z> cls) {
        int size = this.f35153a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.f35153a.get(i);
            if (aVar.a(cls)) {
                return (g<Z>) aVar.f35154a;
            }
        }
        return null;
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f35153a.add(new a<>(cls, gVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f35153a.add(0, new a<>(cls, gVar));
    }
}
