package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<?>> f35933a = new ArrayList();

    /* loaded from: classes7.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g<T> f35934a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f35935b;

        public a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            this.f35935b = cls;
            this.f35934a = gVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f35935b.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <Z> g<Z> a(@NonNull Class<Z> cls) {
        int size = this.f35933a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.f35933a.get(i2);
            if (aVar.a(cls)) {
                return (g<Z>) aVar.f35934a;
            }
        }
        return null;
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f35933a.add(new a<>(cls, gVar));
    }

    public synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f35933a.add(0, new a<>(cls, gVar));
    }
}
