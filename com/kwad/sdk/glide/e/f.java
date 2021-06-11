package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?>> f35835a = new ArrayList();

    /* loaded from: classes7.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g<T> f35836a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35837b;

        public a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            this.f35837b = cls;
            this.f35836a = gVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35837b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <Z> g<Z> a(@NonNull Class<Z> cls) {
        int size = this.f35835a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.f35835a.get(i2);
            if (aVar.a(cls)) {
                return (g<Z>) aVar.f35836a;
            }
        }
        return null;
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f35835a.add(new a<>(cls, gVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f35835a.add(0, new a<>(cls, gVar));
    }
}
